# Angular Data Binding

One of the best features of nG is the built-in *data binding*. Data binding is the process of linking data from a component with what is displayed in a web page. When data in the component changes, the UI rendered to the user is automatically updated. nG provides a very clean interface to link the model data to elements in a web page.


## Understanding Data Binding

Data binding means linking data in an application with the UI element that is rendered to the user. When data is changed in the model, the web page is automatically updated. This way, the model is always the only source for data represented to the user, and the view is just a projection of the model. The glue that puts the view and the model together is data binding.

There are many ways in nG to use data binding to make an application look and actin different ways. The following is a list of the types of data binding available in nG:

* Interpolation
    * uses the double curly braces `{{ }}` to get values directly from the component
    * Syntax: `{{ title }}`

* Property binding
    * used to set the property of a DOM object
    * Syntax: `<img [src]="myValue">`

* Event binding
    * used to handle user inputs and actions
    * Syntax: `<button (click)="myAction">Click Me!</button>`

* Attribute binding
    * allows the setting of attributes of a DOM object
    * Syntax: `<div [attr.aria-label]="labelName"></div>`

* Class binding
    * allows the setting of CSS class names to a DOM object
    * Syntax: `<div [class.nameHere]="true"></div>`

* Style binding
    * used to create inline CSS styles for a DOM object
    * Syntax: `<p [style.styleProperty]="myValue"></p>`
    * Syntax: `<div [style.backgroundColor]="'green'"></div>`

* Two-way binding
    * used with data entry forms to receive and display data.
    * Syntax: `<input [(ngModel)]="myValue">`


### Property Binding

Property binding is a type of data binding that is used to dynamically set the DOM properties of an HTML element. To understand how this works, let's compare it to something we are already familiar with: string interpolation. Consider the following:

    <img src="{{ imageUrl }}">

This is pretty straightforward. We are setting the `src` attribute equal to whatever the value of the component's `imageUrl` field is. Now, compare this to code that does the *exact* same thing, but using property binding:

    <img [src]="imageUrl">

This syntax is actually cleaner than it was before using interpolation. The nG compiler scans the DOM and sees the `src` attribute encapsulated within square brackets, and it knows that the value assigned to it is going to be a field of the component.

It is important to note that property binding is one-way, meaning that changes in the component will be reflected in the DOM, but any changes made on the DOM will not reflect in the component.


### Attribute Binding

Attribute binding allows the setting of attributes of a DOM object. To fully grasp attribute binding, it is important to understand the difference between HTML and the DOM. The DOM is model of objects that represent the structure of a document. It is essentially a tree of documents in memory. HTML is the way that we repesent the DOM in text. When you browser parses HTML it is actually creating DOM objects in memory that represent the structure of the webpage.

Most of the attributes of HTML elements have a one-to-one mapping to properties on DOM objects. There are a few exceptions to this rule, though. For instance, the HTML element `<td>` has an attribute `colspan`. However, there is no `colspan` DOM property. Likewise, we can set the text content of a HTML element like `<h1>` using the DOM property `textContent`. There is no equivalent HTML attribute for this DOM property.

In order to get around these boundary cases, we can alter the same syntax we used with property binding just a bit. For example, let's create a table with a row that contains data where the `colspan` attribute is set dynamically to a field within the component.

    <table>
        <tr>
            <td [attr.colspan]="myValue"></td>
        </tr>
    </table>

Since there is no DOM property equivalent to the HTML attribute `colspan` we need to include the `attr.` prefix to let nG know that it is working with an HTML attribute rather than a DOM property.


### Class Binding

There are sometimes where we may want to add additional classes to an element based upon some condition. To do this, we do a variation of property binding:

    <button class="btn btn-primary" [class.active]="isActive">

Notice that we use the `class.` prefix. Also, keep in mind that the assignment to`myValue` corresponds to a boolean field declared within our component:

    import { Component } from '@angular/core';

    @Component({
        selector: 'myButton',
        template: `
                    <button class="btn btn-primary" [class.active]="isActive">
                  `
    });
    export class ButtonComponent {
        isActive: boolean = true;
    }


### Style Binding

Another variation of property binding, style binding is similar in concept to our previous example of class binding. We use style binding to dynamically apply inline styles to a DOM object. The syntax for style binding looks like:

    <button [style.backgroundColor]="isActive ? 'blue' : 'white'">Save</button>

Again, notice the prefix, `style.`. Just to show what kind of assignments we are allowed to do within our HTML elements, we are assigning either the value `blue` or `white` to this element based upon the boolean value of `isActive`.


### Event Binding

In nG, there is event binding which is used to handle DOM events performed by the user. Examples of events include: keystrokes, mouse movements, clicks, etc. Using our button example, we can bind its click event to specific action:

    <button (click)="doSomething()">Click Me!</button>

If the user clicks on this button, then the component method `doSomething` will be executed. Notice that instead of square brackets, we use parenthesis to encapsulate our DOM object's event property.

Sometimes we need to get access to the event object within our method. To do this, we include a parameter that represents the event in the method signature:

    <button (click)="doSomething($event)">Click Me!</button>

The parameter `$event` represents a DOM event, no different than the event object we have worked with in JS or jQ. 

It should be noted that event propagation occurs the same way in nG as it does in JS. By default, events will propagate up the DOM tree (bubbling) until a handler stops this propagation.

    <div (click)="doSomethingElse()">
        <button (click)="doSomething()">Click Me!</button>
    </div>

Clicking on the button will cause both the button's click event, and the containing div's click event to be executed. In order to stop this from occurring, you can include the statement: `$event.stopPropagation();` in the method implementation to prevent the event from bubbling up the DOM tree.


#### Event Filtering

Before moving on from event binding, we need to discuss how we can filter events. Say that we have input, and we want to handle the keyUp event. The markup for this would like something like:

    <input (keyup)="onKeyUp($event)" />

In our component, we would traditionally write something like this to ensure that this method only executes if the 'Enter' key was pressed:

    export class DemoComponent {
        onKeyUp($event) {
            if ($event.keyCode === 13) console.log('ENTER was pressed');
        }
    }

However in nG, we have a better way of doing this: applying an event filter. Applying an event filter will short our syntax, like so:

    <input (keyup.enter)="onKeyUp()" />

Likewise, our component's onKeyUp method implementation does not need the if statement checking to see if the key pressed was the 'Enter' key:

    export class DemoComponent {
        onKeyUp() {
            console.log('ENTER was pressed');
        }
    }


#### Template Variables

Following along with the example from before, say that we wanted to get the value entered into the input element. There are two ways to do this in nG: using the event object's or by using template variables.

First, we will look at how this is accomplished using the event object:

    <input (keyup.enter)="onKeyUp($event)" />

Our component:

    export class DemoComponent {
        onKeyUp($event) {
            console.log($event.target.value);
        }
    }

This is a bit noisy, and using template variables allows us to clean up this syntax by using a variable that references the input field and the value within it:

    <input #email (keyup.enter)="onKeyUp(email.value)" />

Our component now looks like:

    export class DemoComponent {
        onKeyUp(email) {
            console.log(email);
        }
    }


### Two-Way Binding

The code we used in the previous example works, but it can be better. The first issue with it is that we are passing the `email` variable around a lot. In OOP languages, we should not really pass parameters around in this manner. In its current state, our code is very procedural. Let's use two-way binding to make it better:

    <input [value]="email" (keyUp.enter)="onKeyUp()" />

Our component:

    export class DemoComponent {
        email: string = me@example.com;

        onKeyUp() {
            console.log(this.email);
        }
    }

This should work, right? Well, unfortunately it doesn't. If we enter a new email into the input field and press 'Enter', the original email `me@example.com` is still printed to the console. This is because, if you recall, property binding is one-way (from the component to the DOM). What this means is that changes made on the DOM do not get reflected in the internal state of our component. To make this binding two-way, we need to refactor our code:

    <input [value]="email" (keyUp.enter)="email = $event.target.value; onKeyUp()" />

This works, but the syntax is cluttered and ugly. There has to be a better way, right? In fact there is, let's refactor this once more:

    <input [(ngModel)]="email" (keyUp.enter)="onKeyUp()" />

We have this strange syntax that combines square brackets with parenthesis. This is how two-way binding is represented in nG, I remember this syntax as *banana-in-a-box* - since the parenthesis encapsulated within square brackets looks like a banana in a box. 

The property we bind to is the `ngModel` directive. To use `ngModel` directive we need to include the `FormsModule` in the `imports` array of the `AppModule`. The `FormsModule` can be imported from the path: `@angular/forms`.