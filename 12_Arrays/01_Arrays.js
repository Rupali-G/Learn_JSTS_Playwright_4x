let fruits = [];
console.log(typeof fruits); // object

let browsers = ["chrome", "firefox", "webkit"];
console.log(browsers.length); //3

// console.log(browsers.at(0));
console.log(browsers[0]); //chrome
console.log(browsers[2]); //webkit
console.log(browsers.at(0)); //chrome
// at() suports the negative index, 
console.log(browsers.at(-1)); //webkit
console.log(browsers.at(-2)); //firefox
console.log(browsers.at(-3)); //chrome