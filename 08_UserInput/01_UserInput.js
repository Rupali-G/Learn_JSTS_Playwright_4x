/* Javascript is not created to take input from user. 
It is created to take input from browser.
But still we can take input from user using 
prompt() method, 
readline()-> Node.js module, is allow us to read input from the command line.
promt-sync() -> Node.js module, is allow us to read input from the command line.
fs.readFileSync() -> Node.js module, is allow us to read input from the command line.
HTML form elements. */

let num = prompt("Enter a number:");
num = Number(num);  // convert string to number

if (num % 2 === 0) {
    console.log(num + " is Even");
} else {
    console.log(num + " is Odd");
}

/* This code will you error ->ReferenceError: prompt is not defined
bcoz Javascript was created as a browser-based and is not created to take input from user. 
It is created to take input from browser.Hence we need node js */ 
