let results = ["pass", "fail", "pass", "error", "fail"];
console.log(results.indexOf("pass")); //0
console.log(results.indexOf("fail")); //1
console.log(results.indexOf("skip"));  // -1

// lastIndexOf — searches from the end
console.log(results.lastIndexOf("fail")); //4

// includes — returns boolean i.e. true or false 
// includes() method determines whether an array includes a certain value among its entries, returning true or false as appropriate.
console.log(results.includes("error")); // true
console.log(results.includes("skip")); // false