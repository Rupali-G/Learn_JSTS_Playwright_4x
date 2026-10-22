let browsers = ["Chrome", "Firefox", "Safari"]; // declaration and initialization of an array

let scores = new Array(3);  // creates empty array with 3 slots. 
scores[0] = "1"; 

let scores2 = new Array(1, 2, 3);

let numbers = new Array(100, 200, 300, 400);

//Array.of() => of() is used to create a new array instance with a variable number of arguments, regardless of number or type of the arguments.
let test = Array.of(10, 20, 30, 40, 50);
console.log(test.length);

// Array.from() => from() is used for string to character array conversion. It can also be used to convert array-like objects to arrays.
let chars = Array.from("hello");
console.log(chars);  // ["h", "e", "l", "l", "o"]