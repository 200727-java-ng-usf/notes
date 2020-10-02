# Angular Services

In many of our components, we will require information that is retrieved from external resources, such as a web server. We could include the logic for calling an HTTP endpoint in our component, but there are some problems with this approach. First, the addition of this logic will tightly couple our component to that HTTP endpoint, this will make unit testing much more difficult. Second, this logic is likely to be reused elsewhere in our application and we would not want to keep writing it over and over each place it is necessary. Lastly, by including the logic to call an HTTP endpoint we would violate the principle that our component should only be responsible for presentation logic.

Our solution, instead, should be to create a *service* with handles this extra functionality. We will use the NG CLI to automatically generate a service that will handle the retrieval of data. The below command will do this:

    ng generate service <name>

The shorthand syntax for this is:

    ng g s <name>

Services in NG do not get the `@Component` decorator, like our components do. Instead they can optionally include the `@Injectable` decorator which will allow NG to inject other services into the current service, but only if they are included in its constructor. Services can injected into components and other services as a dependencies. Doing this will allow us to keep our components and the services they use loosely coupled, using a design pattern known as *dependency injection*.

The purpose of a service is to provide a concise bit of code that performs a specific task. A service can do something as simple as providing a value definition, or as complex as providing full HTTP communication to a web server.

A service provides a container for reusable functionality that is readily available to NG applications. Services are defined and registered with the dependency injection mechanism in NG. Which allows us to inject our services into modules, components, and even other services.

NG comes with several built-in services that are included in some of its libraries. Once included within a module, services can be used throughout that module's members. Below are the most commonly used built-in services:

* `HttpClient`
    * replaces the deprecated `http` service
    * provides a simple-to-use functionality to send HTTP request to the web server or other services

* `forms`
    * provides a service that allows for dynamic and reactive forms with simple form validation

* `router`
    * provides navigation between views and between sections within views

* `animate`
    * provides animation hooks to link into both CSS and JS-based animations

## Dependency Injection (in general)

***Dependency injection (DI)*** is a technique whereby some object or mechanism supplies the dependencies required by another object. We've discussed the concept of _dependency_ from the perspective of packaged, third-party software that can be used within our project(s). Here, we are talking about dependency at the code-level. 

If `Object A` includes another object, `Object B`, as a part of its state and relies on that object to provide some aspect of its functionality, then `Object A` is said to be dependent upon`Object B`. 

An _injection_ is the passing of a dependency to a dependent object (a client) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.

The intent behind dependency injection is to achieve separation of concerns of the construction and use of objects.

## Dependency Injection (in Angular)

In the case of Angular, dependency injection is a way to create objects that depend on the other objects. Angular's Dependency Injection system supplies the dependent objects when it creates an instance of an object.

Without a DI system in place we would be required to manually wire objects together. This will be a tedious and error-prone process. In order for DI to work in Angular, Angular needs to be aware of every single entity that we want to inject into our components and services.


### Pre-Angular 6 DI System

Before the release of Angular 6, the only way to do that, was to specify services in the `providers` of the `@NgModule` decorator.

Using the `providers` property can lead to three different scenarios based on specific circumstances:

- Specifying services as `providers` within an eagerly imported Angular module
    - services are registered as global singletons
    - services are accessible everywhere since provided by the root injector
    
- Specifying services as `providers` within a lazy loaded module
    - services are instantiated
    - services are provided by the child injector of the lazily loaded module
    - attempting to inject these services within a eagerly loaded component could result in a `No provider for service!` error.

- Specifying services as `providers` within a `@Component` or `@Directive` decorator
    - services are instantiated per component
    - services are accessible to the component and its children


### Angular 6+ DI System

Angular 6 brought improvements to the framework's DI system, especially with regard to how we model our application's dependencies. Introduced with the version release was the `providedIn` property within the `@Injectable` decorator. 

The main benefit of this provided was the ability of ***tree-shakable providers***, which are services are optionally bundled with our application depending on whether or not they are used. This may not seem like a big deal for you, unless you use modules from third-parties and are concerned about unnecessary logic being bundled in with your source code.

When it comes to how we associate services and Angular modules. The way that this new system works is logically the reverse of the previous method. Previously, the module itself had to declare dependencies, now it is the service itself declaring where it should be provided.

    @Injectable({
        providedIn: 'root'
    })
    export class MyService {}


    @Injectable({
        providedIn: EagerlyLoadedModule
    })
    export class AnotherService {}


    @Injectable({
        providedIn: LazilyLoadedModule
    })
    export class YetAnotherService {}

Here we see three services configured to mirror three scenarios that we had described in Angular's previous DI system. There are some important differences that should be noted:

- Specifying `root` as the value for `providedIn`
    - `root` indicates the root module, `AppModule`
    - services are bundled only if they are used
    
- Specifying an eagerly-loaded module as the value for `providedIn`
    - prevents the rest of the application from injecting the service without importing of the corresponding module
    - Stick with `providedIn: 'root'` in every eagerly imported module scenario

- Specifying an lazily-loaded module as the value for `providedIn`
    - prevents the service from being injected anywhere outside of the module it is provided in
