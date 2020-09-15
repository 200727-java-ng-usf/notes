# Angular Pipes

*Pipes* are used to format data. NG comes with several built-in pipes that allow for convenient and common data transformations:

* Uppercase
* Lowercase
* Decimal
* Currency
* Percent

In addition to these built-in pipes, we can also create our own custom pipes. For now, let's just focus on working with the ones that are included by default in NG to understand the basics of using them.

Pipes are applied to change the way that our data is rendered to the view, and we do this by using the pipe operator within the string interpolation operators and following the interpolated value:

    {{ title | uppercase }}

This will render the value of the component's title field to the view as text, but applies the built-in pipe `uppercase`. Naturally, this pipe formats the value of title to be rendered in uppercase.

Pipes can also be chained to create a flow in which formatting can be layered or overridden. For instance:

    {{ title | uppercase | lowercase }}

The above will render the text in all lowercase, because first the `uppercase` pipe is applied, and the formatted value is then transformed by the `lowercase` pipe. 

Several of the default pipes take arguments, let's take a look at the currency pipe. Say that we have a numeric value that we want to render in a specific currency format:

    let value = 124.90

Say that want to render this value to the view but formatted to look like: `A$0,124.90`. We are giving it four interger places to show that we can format it to look however we like. So, in our template we will have:

    {{ value | currency:'AUD':'symbol':'4.2-2'}}

So, there is a lot going on there. However, let's break it down and understand what each of these parts are doing. So, we start off with the `currency` pipe, we can include arguments to this pipe using the colon operator, `:`. 

* The first argument, `'AUD'`, indicates the target currency's country. 
* The second argument, `'symbol'`, indicates that the currency symbol should be used.
* The third argument, `'4.2-2'`, indicates that our numeric value should have 4 integer places, as well as minimum of 2 and a maximum of 2 decimal places.

Another built-in pipe is the `DatePipe`, which is used to format date values. Say that we have a value that is initialized to a `Date` object:

    let myDate = new Date(2018, 3, 19);

Printing this value out without formatting first will be techically accurate, but very lengthy and hard to read:

    Thu Apr 18 2018 00:00:00 GMT-0700 (PDT)

We can use the built-in pipe for dates to format this to be render as: `04/19/2018`. Which is a much cleaner and easier to read syntax. In our template we would have the following:

    {{ myDate | date:'shortDate' }}

The `'shortDate'` argument is one taken by `DatePipe` to perform a certain transformation on the value to get a shortened version of the date from the raw data (See [the offical Angular documentation on DatePipe](https://angular.io/api/common/DatePipe) for all of the different arguments that can be used with this pipe). With the basics of pipes, and a few examples of built-in ones, let's look at creating our own custom pipes in nG.


### Custom Pipes

In addition to our built-in pipes, we can create our own custom-defined pipes that can transform data in anyway that we choose. For instance, say that we want to create a pipe that trims a long string down to its first 25 characters, and then appends an ellipses to the end, to indicate that the text continues. First let's have value:

    let myText = "Here is a long string that we are going to use a custom pipe. Only the first 25 characters of this string will be visible, the rest will be replaced by an ellipses (...)."

We can use the nG CLI to automatically generate the files necessary for our pipe, as well as automatically add it into the `declarations` array of the `AppModule`. The command to generate a pipe using nG CLI is:

    ng generate pipe summary

As usual, there is a shorthand syntax that can be used:

    ng g p summary

Inside of the main TS file generated we have:

    import { Pipe, PipeTransform } from '@angular/core';

    @Pipe({
    name: 'summary'
    })
    export class SummaryPipe implements PipeTransform {

        transform(value: any, args?: any): any {
            return null;
        }

    }

We can see that we have a few imports included in this file. The first being the import for the `Pipe` decorator, and the second for the `PipeTransform` interface. We apply our `Pipe` decorator and give our pipe a `name` which will be used to call this pipe inside our interpolation operator within the template. Additionally, our class is implementing the `PipeTransform` interface which requires that our class define an implementation for the `transform()` method. This method is required to take one parameter, `value`, and as many optional parameters as needed.

We need to provide an algorithm to our `transform()` method that will format our data for us. It may look something like:

    transform(value: string, limit?: number) {
        if(!value) return null;
        let upTo = (limit) ? limit : 50;
        return value.substring(0, upTo) + '...';
    }

Notice that we have changed the data types of our first and second parameters. Additionally, I have renamed the second parameter to increase readability. The first line of the method, just returns null if our value is falsy. The second line assigns either the optional `limit` argument that could be passed to the pipe, or the default value of 50. Finally, our last line returns the substring of `value` from the 0th position up to the value assigned to the `upTo` variable, and concatenated with an ellipses.


### Pure and Impure Pipes

When configuring the metadata for a custom nG pipe, you can specify whether or not the given pipe is *pure* or *impure* using the `pipe` property of the `@Pipe` decorator, the default value of this decorator property is `true`.

    @Pipe({
        name: 'somePipe',
        pure: false
    })
    export class SomePipe { }

Let's first take a second to confirm what we mean by *pure* and *impure*. A pure function is one that given the same input, will always return the same output. Another key characteristic of pure functions is that they are complete independent of outside state. This feature makes our functions immune to the bugs that can occur due to shared mutable states. Additionally, because of this independence, pure functions are perfect for parallel processing.

The way this applies to NG pipes is that pure pipes have no internal state, and this pipe can be shared with no side effects. However, when we work with pure pipes there can be some intended consequences. For instance, if we are using a pure pipe upon an object, the pipe will only be applied the first time it is rendered or when the object's reference changes. Simply changing the state of the object will not trigger the pipe to reformat the object.