# What is Angular?

An open-source, TypeScript-based framework, developed and maintained by Google, for building single-page client applications.

## Why Angular? 

### Why not JavaScript or jQuery?

Sure we can, and that is actually how many web applications are built. However as our applications get more complex, vanilla JS/jQ code becomes harder to maintain.

Angular (NG) provides us with a way to properly structure or code, without having to understand complex JS design patterns (i.e. Revealing Module or Prototype patterns)

Applications built with JS/jQ are also more difficult to test, and NG simplifies this task by giving us a way to generate a generic project from a template that includes nearly everything we would need in an enterprise client-side web application: generated project structure, integrated unit test runner, end-to-end testing tools, etc..

---

# Architecture of Angular applications

A lot of applications have at least two parts: a front-end and a back-end. The front-end, 
or client, is the part that runs in the web browser and is what user interacts with (UI). We can use HTML, CSS, TS, and nG to build our front-end.

The back-end sits on a web server, or multiple web servers hosted on the cloud. It is responsible for 
storing the data and any kind of processing (business logic). Our front-end talks to the back-end to 
get or persist data through an HTTP service (a collection of endpoints that are accessible via the 
HTTP protocol).

#### Back-end:
* Data + APIs
* Business Logic

#### Front-end:
* HTML templates
* Presentation Logic

---

# Setting Up the Development Environment (Our first Angular App)

1) Install the latest version of NodeJS

* Node.js is a runtime environment for executing JS code outside of the browser
    * NG 7 apps require Node.js v8 (and support v10)
    * NG 8 apps require Node.js v10
    

2) With NodeJS installed, use Node Package Manager (NPM) to install third-party libraries. In our
case we use it to install the Angular Command Line Interface (CLI), using the following command: `npm install -g @angular/cli@7.3.9`

* Although Angular 8 is out, we will use the latest stable release of Angular 7.

* The NG CLI is a command-line tool that is used to create our NG project and its various services, components, etc.

* The `-g` installs our nG CLI globally. Without it, the NG CLI will only be installed in the current folder and will not accessible anywhere else.

* The installation process takes a minute.

* Check for success:

    * In the terminal type the following command to see the installed versions of the NG CLI, Node.js, TypeScript, and your machine's OS: `ng --version`


3) To create a new nG project type the following command into the terminal: `ng new hello-world`

* This generates a lot of files for us and uses NPM to download any third-party libraries that are required.
* You may be prompted decisions regarding routing and styling.


4) Once the project is created, we can launch it on a Node server using one of the following commands: `ng serve` or `npm start`

* By default, our live development server is deployed on localhost port 4200
    * We could open on another port if we wish by including the `-o` flag (`--open`) and the desired port: `ng serve -o 4201`


# Structure of an Angular Application

* e2e 
    * End-to-end tests are automated tests that simulate a real user's interaction with our web page

* node_modules
    * the storage location of all of the third-party libraries our application depends upon
    * only used for development (`ng build` will resolve dependencies and bundle them with our source code for production)
    * should not be pushed to a public repository

* src
    * the actual source code of our nG application
    * contains the following:

        * app
            * contains a module and a component

        * assets
            * storage location for static assets for the web page (images, audio, etc.)

        * environments
            * contains configuration settings for different environment
            * contains one file for the production environment and one for the development environment

        * favicon.ico
            * icon displayed in the browser tab

        * index.html
            * a simple HTML file that contains our nG application
            * has no references to external stylesheet, since they will be added dynamically later

        * main.ts
            * starting point of the nG application
            * location where we bootstrap the application's main module using the statement:

                    `platformBrowserDynamic().bootstrapModule(AppModule);`

        * polyfills.ts
            * imports some scripts required to run nG, since nG framework uses features of JS that are
            not in the current version of JS.

        * style.css
            * the location where we can add global styles for the application (each component can have
            its own styles, as well)

        * test.ts
            * used to set up a testing environment

    * .angular.json
        * configuration file for the NG CLI

    * .editorconfig
        * used to ensure that all developers working on a project have their editors configured in the
        same manner

    * karma.conf.js
        * another configuration file for a test runner known as Karma, used to testing JS code

    * package.json
        * a standard file that all Node projects have
        * contains a list of dependencies and the versions used (needed for production)
        * contains a list of development dependencies and the versions used (needed for developers only)

    * protractor.conf.js
        + a configuration file used for  the e2e testing framework Protractor
    
    * tsconfig.json
        + a settings file for the TS compiler

    * tslint.json
        + includes settings for tslint, a static analysis tool for TS code (checks TS code for readability,
        maintainability, and functionality)



# NG usage of Webpack

NG CLI uses a tool known as Webpack, which is a build automation tool. Webpack is responsible for gathering scripts and stylesheets, bundling them, then minifying them for optimization.

Common bundles managed by the nG CLI (These bundles are injected into the index.html):

* polyfills.bundle.js (necessary non-standard JS features)
* main.bundle.js (nG source code)
* styles.bundle.js (stylesheets)
* vendor.bundle.js (third-party dependencies)
* inline.bundle.js (Webpack loader)

For more notes on Webpack: [More information](https://github.com/wsingleton/190422-Java-USF/blob/master/Week_5-Angular_DevOps/angular/webpack.md)


# Angular Version History

* AngularJS
    * introduced in 2010
    * JS framework for building client applications
    * still activately maintained by the AngularJS team at Google 

* Angular 2
    * introduced in September 2016
    * written in TS

* Angular 4
    * introduced in March 2017
    * new features (not all inclusive):
        * changes to NG Routing
        * support for animations (without writing functions)
        * changes and additions to built-in directives
        * Angular Universal (running nG apps outside of the browser and on a web server)


* Angular 5
    * introduced in November 2017
    * new features (not all inclusive):
        * HttpClient (officially replaces the deprecated Http)
        * Compiler and BuildOptimizer improvements
        * new Router lifecycle events [What's that?](https://angular.io/guide/router#router-events)


* Angular 6
    * introduced in April 2018
    * still written in TS
    * new features (not all inclusive):
        * Webpack v4
        * support for RxJS 6 library
        * new nG CLI commands (`ng add`, `ng update`, etc.)
        * tree-shakeable services

* Angular 7
    * introduced in October 2018
    * new features (not all inclusive):
        * improvements to Angular Material & CDK [What's that?](https://material.angular.io/cdk/categories)
        * support for Typescript 3.1
        * support for RxJS 6.3, 
        * support for Node 10 (still supporting Node 8).

* Angular 8
    * Introduced in May 2019
    * Requires Node 10
    * New features (not all inclusive):
        * Differential Loading [What's that?](https://dev.to/lacolaco/differential-loading-a-new-feature-of-angular-cli-v8-4jl)
        * Dynamic imports for lazy routes [What's that?](https://alligator.io/angular/lazy-loading/)
        * CLI workflow improvements
        * Preview of Ivy (new rendering engine) [What's that?](https://blog.nrwl.io/understanding-angular-ivy-incremental-dom-and-virtual-dom-243be844bf36) and Bazel (new build system) [What's that?](https://github.com/bazelbuild/bazel)

* Angular 9
    * Introduced in February 2020
    * new features (not all inclusive)
        * Ivy Engine made the default compiler (results in smaller bundle sizes than previous versions)
        * ModuleWithProviders Support
        * Changes with Angular Forms (<ngForm> replaced with <ng-form>
        * New scopes added to dependency injection system
        * [Good resource](https://blog.angular.io/version-9-of-angular-now-available-project-ivy-has-arrived-23c97b63cfa3)

* Angular 10
    * Introduced in June 2020
    * new features (not all inclusive)
        * Optional Strict(er) Mode
        * Support for TypeScript 3.9 (support for 4.0 added in 10.1)
        * TSlib, the runtime library for TypeScript containing helper functions, updated to Tslib 2.0


## Why no Angular 3?

Angular consists of a few different libraries that are distributed as separate packages. Before Angular 4 was released, the latest versions of these libraries were:

            @angular/core       v2.3.0
            @angular/compiler   v2.3.0
            @angular/http       v2.3.0
            @angular/router     v3.3.0

Notice that the NG router package's version was out of sync with the other nG packages. In order to get all of the packages back in sync, the NG development team decided to skip an Angular 3 release, and go straight to Angular 4. Although technically, the version number was officially dropped from the name to help emphasize that there are only two version of Angular: AngularJS and Angular. The latter being all versions of Angular from v2 and beyond.
