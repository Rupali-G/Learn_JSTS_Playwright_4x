let arr = [1,2,3];
console.log(arr);
console.log(arr.length);

// Add to END
// push() method adds one or more elements to the end of an array and returns the new length of the array.
arr.push(4);
console.log(arr);
console.log(arr.length);

// Remove from END
//pop() method removes the last element from an array and returns that element. This method changes the length of the array.
arr.pop();
console.log(arr);

arr.push(5, 6); // push() can add multiple elements to the end of an array.
console.log(arr);

// Add to BEGINNING
//unshift() method adds one or more elements to the beginning of an array and returns the new length of the array.
arr.unshift(0); 
console.log(arr);

// Remove from BEGINNING
//shift() method removes the first element from an array and returns that removed element. This method changes the length of the array.
arr.shift();
console.log(arr);

// [ 1, 2, 3, 5, 6 ]
// The splice() method can add, remove, or replace elements in an array.
// arr.splice(startNumber, HowManyElementsToDelete, InsertedItem1, InsertedItem2, ...)
arr = [1, 2, 5, 6];
arr.splice(2, 0, 99);
console.log(arr); //[ 1, 2, 99, 5, 6 ]
/* 2 → Start at index 2 (where 5 currently exists).
0 → Delete zero elements.
99 → Insert 99 at that position.
deleteCount = 0 means add without removing anything. */

arr = [1, 2, 5, 6];
arr.splice(2, 1);
console.log(arr); //[1, 2, 6]
/* 2 → Start at index 2, where the value is 5.
1 → Delete one element.
No third parameter → Nothing new is inserted.
deleteCount = 1 means remove one element starting at the specified index. */

arr = [1, 2, 5, 6];
arr.splice(2, 1, 99);
console.log(arr); //[ 1, 2, 99, 6 ]
/* 2 → Start at index 2, where the value is 5.
1 → Remove one element (5).
99 → Insert 99 at that position. */

arr = [ 1, 2, 99, 5, 6 ];
arr.splice(1, 2, 10, 20);
console.log(arr); //[ 1, 10, 20, 5, 6 ]

arr = [ 1, 10, 20, 30 ];
arr.splice(2,2,99);
console.log(arr); //[ 1, 10, 99 ]

arr = [ 1, 10, 20 ];
arr.splice(2,2,99);
console.log(arr); //[ 1, 10, 99 ]

arr = [ 1, 2, 99, 5, 6 ];
arr.splice(1, 2, 10, 20);
console.log(arr); //[ 1, 10, 20, 5, 6 ]