# Angular Modules (NgModules)

NgModules are classes decorated with `@NgModule`. The `@NgModule` decorator’s `imports` array tells Angular what other NgModules the current module needs. The modules in the imports array are different than JavaScript modules because they are NgModules rather than regular JavaScript modules. Classes with an `@NgModule` decorator are by convention kept in their own files, but what makes them an NgModule isn’t being in their own file, like JavaScript modules; it’s the presence of `@NgModule` and its metadata.

The properties of the `@NgModule` decorator are used to organized and relate components, directives, pipes, services, and other Angular modules to one another. Components, directives, and pipes to be used within an Angular module are declared within the `declarations` array. Services to be used within the Angular module are declared within the `providers` array. As mentioned, to include other Angular modules within another they are declared within the `imports` array. The `exports` array can be used for making NgModules available to other parts of the application.

The final property of the `@NgModule` decorator is the `bootstrap` array, which will contain a single component declarations. The declared component is the root component that Angular creates and inserts into the index.html when the module is loaded.

For more information visit: [angular.io](https://angular.io/guide/ngmodules)

## Commonly Used NgModules

An Angular app needs at least one module that serves as the root module. As you add features to your app, you can add them in modules. The following are frequently used Angular modules with examples of some of the things they contain:

| NgModule	            | `import` it `from`          | Why you use it                                                     |
| --------------------- |:---------------------------:|:------------------------------------------------------------------:|
| `BrowserModule`       | `@angular/platform-browser` | When you want to run your app in a browser                         |
| `CommonModule`        | `@angular/common`           | When you want to use `NgIf`, `NgFor`                               |
| `FormsModule`         | `@angular/forms`            | When you want to build template driven forms (includes `NgModel`)  |
| `ReactiveFormsModule` | `@angular/forms`            | When you want to build reactive forms                              |
| `RouterModule`        | `@angular/router`           | When you want to use `RouterLink`, `.forRoot()`, and `.forChild()` |
| `HttpClientModule`    | `@angular/common/http`      | When you want to talk to a server                                  |

For more information visit: [angular.io](https://angular.io/guide/frequent-ngmodules)