# Node Package Manager (npm)

Node Package Manager, or npm, is one the world's largest software registries - which contains over 800,000 software packages. It is widely used for open-source projects as a way to share useful libraries or frameworks with other developers. npm is free to use, all software packages are completely free to use. npm is included along with the installation of Node.js.

npm consists of three distinct components:

- the website
- the CLI tool (`npm`)
- the registry

Use the website to discover packages, set up profiles, and manage other aspects of your npm experience. For example, you can set up Orgs (organizations) to manage access to public or private packages.

The CLI runs from a terminal, and is how most developers interact with npm.

The registry is a large public database of JavaScript software and the meta-information surrounding it.

---

## `npm`

To interface with the software packages stored in the NPM registry, developers use a command-line interface tool called `npm`. This client can be used to download and install software which can be leveraged by projects as dependencies.

---

## `node_modules`

Packages are dropped into the node_modules folder under the prefix. When installing locally, this means that you can `require('packagename')` to load its main module, or `require('packagename/lib/path/to/sub/module')` to load other modules. Using ES6 syntax we are able to use the `import` and `from` keywords to indicate what we wish to use in a particular file, rather than the `require()` syntax.

Global installs on Unix systems go to `{prefix}/lib/node_modules`. Global installs on Windows go to `{prefix}/node_modules` (that is, no `lib` folder.)

Scoped packages are installed the same way, except they are grouped together in a sub-folder of the relevant node_modules folder with the name of that scope prefix by the `@` symbol, e.g. `npm install @myorg/package` would place the package in `{prefix}/node_modules/@myorg/package`. See [`scope`](https://docs.npmjs.com/misc/scope) for more details.
 
If you wish to `require()` or `import` a package for a particular, then install it locally and access it from the local `node_modules` folder.

---

## `package.json`

npm originally started off as a package manager tool for Node.js projects. Node.js projects define their dependencies in a file known as `package.json`. This file can be manually created or generated using the `npm init` command. The primary purpose of the `package.json` is to:

- list the packages your project depends on
- specify versions of a package that your project can use using semantic versioning rules
- make the project's build reproducible, and therefore easier to share with other developers

[More Info](https://docs.npmjs.com/creating-a-package-json-file)