let nums = [10,25,30,45];
// find() => returns the first element (only one element returned) in the array that satisfies the condition. Otherwise undefined is returned.
let result = nums.find(temp => temp > 20); //find value in array that is greater than 20. It will return the first value that satisfies the condition.
console.log(result); //25

// findIndex() => returns the index of the first element in the array that satisfies the condition. Otherwise -1 is returned.
let index = nums.findIndex(n => n > 20);
console.log(index); //1

// findLast() => returns the last element (only one element returned) in the array that satisfies the condition. Otherwise undefined is returned.
console.log(nums.findLast(n => n > 20)); //  45
// findLastIndex() => returns the index of the last element in the array that satisfies the condition. Otherwise -1 is returned.
console.log(nums.findLastIndex(n => n > 20)); // 3