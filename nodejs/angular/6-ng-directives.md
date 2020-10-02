# Angular Directives

Directives are used to manipulate the Document Object Model (DOM). We can use directives to create elements, remove elements, change the class, styling, or attributes of an element. Additionally, we can create our own custom directives that have user-defined functionalities.

Directives _extend_ the behavior of HTML, enabling you to create custom HTML elements, attributes, and classes with functionality specific to an application. nG provides many built-in directives which provide the capability to interact with form elements, bind data in a component to the view, and interact with browser events.

### Understanding Directives

Directives are a combination of nG template marup and supporting TS code. NG directive markups can be HTML attributes, element names, or CSS classes. The TS directive code defines the template data and behavior of the HTML elements.

The nG compiler traverses the template DOM and compiles all of the directives. Then it links the directives by combining a directive with a scope to produce a new live view. The live view contains the DOM elements and functionality defined in the directive.

### Using Built-in Directives

Much of the NG functionality that is needs to be implemented in HTML elements is provided through built-in directives. These directives provide a wide variety of support for nG applications. NG directives fall into one of the three categories:

* *Component:* A directive with a template
* *Structural* A directive that manipulates the DOM
* *Attribute* A directive that manipulates the appearance or behavior of a DOM element

#### Structural Directives

We have already discussed NG components, so we will move to *structural directives*. NG includes many built-in directives that dynamically update, create, and remove elements from the DOM. These directives create the layout, look, and feel of an application. Below is a list of the built-in structural directives:

* `ngFor`
    * used to create a copy of a template for each item within an iterable object

* `ngIf`
    * used to display a template if a certain condition is met, otherwise remove it

* `ngSwitch`
    * displays a template based upon the value passed to it, a default template (`ngSwitchDefault`) is provided if the value given does not match any specified cases (`ngSwitchCase`)


#### Attribute Directives

NG attribute directives modify how HTML elements look and behave. The are injected straight into the HTML and dynamically modify how the user interacts with an HTML segment. Attribute directives are so named because they loop like normal HTML attributes. Below is a list of the built-in NG attribute directives:

* `ngModel`
    * watches a variable for changes and then updates display values based on those changes

* `ngForm`
    * creates a form group and allows it to track the values and validation within that form group. By using `ngSubmit`, you can pass the form data as an object to the submission event.

* `ngStyle`
    * updates the styles of an HTML element

* `ngClass`
    * updates the class of an HTML element

#### `RouterOutlet` Directive

The `RouterOutlet` is a directive from the router library that is used like a component. It acts as a placeholder (`<router-outlet>`) that marks the spot in the template where the router should display the components for that outlet.