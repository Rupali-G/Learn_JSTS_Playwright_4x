//After typing 15, press Enter, then Ctrl+Z, then Enter again. The output will appear.
const data = require('fs').readFileSync(0, 'utf8');
/* The readFileSync(0, 'utf8') method reads input as a string.
For example, if you enter 15, userInput contains "15", not the number 15.
So first we have to convert it into number using Number() method. */
const userInput = Number(data.trim());//convert string into number

for (let i = 1; i <= userInput; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
        console.log("FizzBuzz");
    } else if (i % 3 === 0) {
        console.log("Fizz");
    } else if (i % 5 === 0) {
        console.log("Buzz");
    } else {
        console.log(i);
    }
}
