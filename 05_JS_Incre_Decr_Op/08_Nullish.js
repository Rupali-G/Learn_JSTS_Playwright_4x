/* The Nullish Coalescing Operator (??) is used to provide a default value when a
variable is null or undefined.
In simple words: If the value is missing (null or undefined), use the default value. */

let name1 = null;
let result = name1 ?? "Guest";
console.log(result);

let amul = null;
let val = amul ?? "NANDANI Milk";
console.log(val);


let api_response = null;
let responsedata = api_response ?? "{}";
console.log(responsedata);

let api_response1 = "Pramod";
let responsedata1 = api_response1 ?? "{}";
console.log(responsedata1);