let scores = [45, 82, 91, 60, 73];
let grades = scores.map(i => i > 70 ? "Pass" : "Fail");
/* map() takes each element from an existing array, performs an operation on it, 
and creates a new array with the results. */    
console.log(grades);// ["Fail", "Pass", "Pass", "Fail", "Pass"]

//Example 1: Multiply every number by 2
let arr = [1, 2, 3, 4];
let result = arr.map(num => num * 2);
console.log(result); // [2, 4, 6, 8]

//Example 2: Filter out numbers less than 3
let arr2 = [1, 2, 3, 4];
let result2 = arr2.filter(num => num >= 3);
console.log(result2); // [3, 4]

//Example 2: Add 10 to every number
let arr1= [5, 10, 15];
let result1 = arr1.map(num => num + 10);
console.log(result1); // [15, 20, 25]

// Filter
let passing = scores.filter(s => s >= 70);
console.log(passing);// [82, 91, 73]

// The main difference is:
// - map() performs an operation on every element in an array and returns a new array.
// - filter() selects elements that satisfy a condition and returns a new array containing only those elements.