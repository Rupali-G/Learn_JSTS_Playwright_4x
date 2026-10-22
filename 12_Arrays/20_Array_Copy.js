let original = [1, 2, 3];
let copy1 = [...original];
// console.log(original);
// console.log(copy1);

let copy2 = original.slice();
copy2.push(92);
copy1.push(93);
console.log(original);
console.log(copy1);
console.log(copy2);



// Deep cOPY
let deep_copy_array = original;
// Deep copy

deep_copy_array.push(91);
// Both original and deep_copy_array will be affected because array is mutable 
// and they reference the same array in memory.
console.log(original); // [ 1, 2, 3, 91 ]
console.log(deep_copy_array); // [ 1, 2, 3, 91 ]