Simple promise:

	function getTheAnswerOfTheUniverse() {
		return new Promise((resolve, reject) => {
			setTimeout(() => {
				let answer = 42;
				if(answer != 42) reject('The answer could not be determined.');
				else resolve(answer);
			}, 5000);
		});
	}
---
	getTheAnswerOfTheUniverse()
		.then(answer => console.log(answer))
		.catch(err => console.error(err));
	


We understand that promises work when there is a single request and a single response.

What happens we the source of our information is actually a repeated stream?

Can we wire promises into an event stream?

If we look at it, most of the asynchronicity in our application is event-oriented: events from the server, events from the user, etc.

The natural thing we think at first is to take what we know about event listeners and promises and use them help us with the idea of dealing with a data stream. So let's unpack that and see how that works out for us.

	let p1 = new Promise((resolve, reject) => {
		$('#btn').click(event => {
			let className = event.target.className;
			if(/foobar/.test(className)) resolve(className);
			else reject();
		});
	});

	p1.then(className => {
		console.log(className);
	});

Say I have a button on my page and I wanted to represent the click of that button by way of a Promise. So we construct a promise, we setup our click handler with some sort of logic for doing something. In this case we are checking to see if the value of `className` matches to the regular expression "foobar". If it does, we will resolve the promise and provide the value; if it does not, we will reject the promise. 

Later in our program, we respond to that promise using the `then()` method and providing a callback where we simply print out the value. The idea of what this code represents is that everytime we click the button, we will get some sort of print out as to whether or not the button click has a class name that matches some value. 

The problem with this solution is that our promise will only fire off once, once resolved. Assume that something other part of our application is dynamically changing the classes of buttons on our page. Since a promise only fires off once, we will not be able to detect dynamic changes.

We are problem solvers though, so we think of inverting the solution. Instead of creating a promise that contains a button click handler, do it the other way around: create the button click handler and within its callback create a promise in it. So that might look something like:

	$('#btn').click(event => {
		let className = event.target.className;

		let p1 = new Promise((resolve, reject) => {
			if(/foobar/.test(className)) resolve(className);
			else reject();
		}

		p1.then(className => {
			console.log(className);
		});
	});

What this does is I get a whole new promise for each event that is fired...but why? Why even bother creating a promise just for it to immediately be resolved? The other issue with this solution, is that we have conflated our separation of concerns. At least in our first solution we were able to set up our promise logic in one spot and listen for its resolution in a different section of the code. Here, everything is occurring within the event handler callback. Our source and subscription are configured in the same place, which is a symptom poor design.

So we see that promises, at least by themselves, are not enough for us in an event-oriented landscape.

-----------------------------------

Enter observables. While not currently a part of core JavaScript, there is a proposal to have it added to the language (https://github.com/tc39/proposal-observable). There is a third-party library, RxJS (Reactive extensions: JavaScript, brought to you by Microsoft), which provides a popular and clean implementation for observables.

To understand an observable conceptually think about a spreadsheets. Think about how a cell's value might be used to determine the cell of another value, and that cell's value might be used by another. An observable is similar to a chain of calculated fields in a spreadsheet. 

The calculation chain is a flow of data, the origin cell is the source location. Each cell in our calculation chain subscribes to the value of the previous cell and uses it to perform some calculation, which the value of is subscribed to by another cell.

An observable is a way to model a piece of data coming in from a producer or event emitter and all of the steps it takes to propogate through a system. An observable is data flow mechanism, which are built to respond to events. This is a pattern we can use to solve our issues with events from before.

	let obsv$ = Rx.Observable.fromEvent(btn, 'click');

	obsv$.pipe(
		map(event => event.target.className);
		filter(className => /foobar/.test(className));
		distinctUntilChanged();
		
	).subscribe(data => {
		let className = data[1];
		console.log(className);
	});

What this is doing is creating for us an Observable, as implemented by the RxJS library. The way this works is that the `.fromEvent()` method takes in a DOM element and an event name (in this case a button and the click event) and it hooks a custom-made event handler to the DOM element. Everytime the event handler fires off, it pumps another piece of data into the Observable. Note that `.fromEvent()` is merely one of a dozen or so ways of creating Observables.

What we are able to do with this Observable is everytime a new piece of data comes into it, we can run it through a pipeline of operations; hence, `.pipe()`. Inside of the `.pipe()` call, we see some familiar functional operations like `map()` and `filter()`. These are functionally the same, but provided by RxJS to specifically work with their implementation of observables. 

In the synchronous sense, `.map()` and `.filter()` work on each item within an array. In the asynchronous world of observables, this means that instead of working on each item in an array, we are mapping or filter each piece of data pushed through the pipeline. If it helps, you can conceptualize an observable as an never-ending array that just has new values pushed into it asynchronously. 

`.distinctUntilChanged()` is an interesting one because it is the first operation we see in this pipeline which actually is asynchronous in nature. This operation retricts the ability for duplicate values to go through the pipeline, so as not needlessly bother subscribers with information they already have.

Outside of the `.pipe()` call, we have the `.subscribe()` method with takes a callback. This method basically allows us to work with data in a synchronous fashion after all of the manipulation the Observable pipeline is. 