# Angular Components

Components are the most basic building block of an UI in an Angular application. An Angular application is a tree of Angular components. Angular components are a subset of directives. Unlike directives, components always have a template and only one component can be instantiated per an element in a template.

A component encapsulates the data, the HTML markup, and the logic of the view. Imagine we are building a website using Angular. Our entire page could be viewed as one large component (`AppComponent`) that is broken into smaller sub-components (`NavComponent`, `SidebarComponent`, etc.). A key feature of our components is that they are reusable, providing a consistency in not only the look and feel of our application, but also its functionality. Additionally, the idea of using components means that we can work on smaller, more maintainable pieces of our application.

All Angular applications have a root component, known as the `AppComponent`. All other components branch outward from this root component in a tree-like structure.

---

## Creating Components

There are basically three steps that you need to follow in order to use a component:

1) Create the component

2) Register the component in a module

3) Add an element in the HTML markup where the component should be rendered

We have two options to choose from when it comes to creating NG components. We can either create them ourselves manually, or we can use the NG CLI to generate them automatically, which is the most common manner of doing so.

In order to create a new component using the CLI, we will execute the command `ng generate component <name>` (or the shorthand syntax: `ng g c <name>`). This create a folder titled with the name we provided, inside of this folder will be four files: an `.html`, a `.css`, and two `.ts` files.

The `.html` file is used for the **template** of our component, which is simply the HTML markup that makes up what the component should look like when rendered. Templates are the aspects of our component that represent its presentation logic. We can use data-binding techniques such as interpolation, class binding, style binding, and two-way binding to wire the internal logic of our component to the view. This `.html` file is linked to the component within the `@Component` decorator as a value to the `templateUrl` property. Optionally the markup could be included directly within the `@Component` decorator as a value to the `template` property (though this is not usually recommended).

The `.css` file is used to style the component's template. This file is linked to the component within the `@Component` decorator as a value within the `styleUrls` property array.

The two `.ts` files included are the actual component's logic file (`<name>.component.ts`) and its accompanying unit test file (`<name>.component.spec.ts`) - which is written using **Jasmine** (a unit testing framework for JS) and executed by **Karma** (a test runner for executing Jasmine tests).

---

## Component Lifecycle

A component has a lifecycle managed by Angular. Angular creates it, renders it, creates and renders its children, checks it when its data-bound properties change, and destroys it before removing it from the DOM.

Angular offers lifecycle hooks that provide visibility into these key life moments and the ability to act when they occur. A directive has the same set of lifecycle hooks.

| Hook            | Purpose and Timing  |
|-----------------|---------------------|
| `ngOnChanges()` |	Respond when Angular (re)sets data-bound input properties. The method receives a SimpleChanges object of current and previous property values. Called before `ngOnInit()` and whenever one or more data-bound input properties change.
| `ngOnInit()` | Initialize the directive/component after Angular first displays the data-bound properties and sets the directive/component's input properties. Called once, after the first `ngOnChanges()`.
| `ngDoCheck()` | Detect and act upon changes that Angular can't or won't detect on its own. Called during every change detection run, immediately after `ngOnChanges()` and `ngOnInit()`.
| `ngAfterContentInit()` | Respond after Angular projects external content into the component's view / the view that a directive is in. Called once after the first `ngDoCheck()`.
| `ngAfterContentChecked()` | Respond after Angular checks the content projected into the directive/component. Called after the `ngAfterContentInit()` and every subsequent `ngDoCheck()`.
| `ngAfterViewInit()` | Respond after Angular initializes the component's views and child views / the view that a directive is in. Called once after the first `ngAfterContentChecked()`.
| `ngAfterViewChecked()` | Respond after Angular checks the component's views and child views / the view that a directive is in. Called after the `ngAfterViewInit()` and every subsequent `ngAfterContentChecked()`.
| `ngOnDestroy()` | Cleanup just before Angular destroys the directive/component. Unsubscribe Observables and detach event handlers to avoid memory leaks. Called just before Angular destroys the directive/component.

---

## `@Component` Decorator

Every Angular component is decorated with the `@Component` decorator, which takes in an object representing the component's metadata. Information such as its `selector`, which indicates the custom markup tag that will be included within a template to indicate where the component should be rendered. Other metadata properties include the `template`, `templateUrl`, and `styleUrls` properties, which have already been discussed.