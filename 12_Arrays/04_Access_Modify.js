// Accessing & Modifying

let statuses = ["pass", "fail", "skip"];

console.log(statuses[0]);
console.log(statuses[2]);

console.log(statuses.at(-1));
console.log(statuses.at(-2));
console.log(statuses.at(-4));

// Modify
//array will be mutable in nature, so we can modify the array elements.
statuses[1] = "blocked";
console.log(statuses);

console.log(statuses.length);