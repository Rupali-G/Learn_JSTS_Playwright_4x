// Map and Filters
// every vs some

// every — ALL MUST PASS THE CONDITION (like AND Condition)
// every method check condition for all elements in an array. It returns true if all elements pass the test; otherwise, it returns false.
console.log([80, 90, 85].every(i => i >= 70)); // true
console.log([80, 60, 85].every(i => i >= 70)); // false


// some — AT LEAST ONE SHOULD BE PASS THE CONDITION  (like OR Condition)
// some method check condition for all elements in an array. It returns true if at least one element pass the test; otherwise, it returns false.
console.log([80, 60, 85].some(s => s < 70)); // true
console.log([80, 90, 85].some(s => s < 70)); // false