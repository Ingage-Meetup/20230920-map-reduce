# C3 Meetup - JavaScript

## Overview

This is a starter project for C3 Meetup Exercises and Katas, implemented using Javascript. There are really only 2 files you
will typically care about:
1. [app.js](./app.js) - this is where you will implement any exercise or kata we discuss duing the meetup
2. [app.test.js](./app.test.js) - this is a jest unit test file for app.js

There is a third file, [index.js](./index.js), which simply calls out to the `doAllTheThings()` function in app.js. This can be useful if you want to run your code as a command-line program. 

## Prerequisites

You must have at least [node](https://nodejs.org/en/download/) with npm installed to use this project.  You can optionally use nvm to choose different versions of node - the minimum required node version is 12.16.x.

## Usage

To use this project, first start by cloning this repository to your local machine, then change to the `src/JavaScript` directory.  Then install the required node modules (jest is the only one required at first) with `npm i`.  Finally, you can run `npm start`, which will execute `node index.js`, and you should see the output `Hi there` in the console window.  If you run `npm test`, that will run `jest`, which will execute the tests in app.test.js.

Have fun!