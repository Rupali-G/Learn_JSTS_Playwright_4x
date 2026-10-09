/* ============================================================
Topic: null vs undefined in JavaScript
============================================================ */

/*
  SIMPLE DEFINITIONS:

  undefined  ->  A variable exists, but it has not been assigned any value yet.
                 JavaScript itself sets this automatically.
                 typeof undefined is "undefined".

  null       ->  A variable exists, but the developer explicitly/intentionally 
                assigns "no value" or "empty".
                It is intentional absence of any value.
                typeof null is "object" (this is a known quirk in JavaScript).

*/

var x;
console.log(x);

var audi = null;
console.log(audi);

/* ---------------------------------------------------------
 1. undefined
 -------------------------------------------------------- */

let userName; // declared but not assigned
console.log(userName);
console.log(typeof userName);

function greet() {
     // no return statement
 }
 console.log(greet()); 

let x;
x = 10;
console.log(x);

/*  --------------------------------------------------------
 2. null
 -------------------------------------------------------- */
let profilePicture = null;
console.log(profilePicture);
console.log(typeof profilePicture); // "object"   <-- known JS quirk!

/*
  | Feature              | undefined                     | null                           |
  |----------------------|-------------------------------|--------------------------------|
  | Meaning              | value Not assigned yet        | value Intentionally empty            |
  | Who sets it?         | JavaScript automatically      | Developer manually             |
  | Type                 | undefined                     | object (historical bug in JS)  |
  | ==  comparison       | null == undefined  -> true    |                                |
  | === comparison       | null === undefined -> false   |                                |
*/