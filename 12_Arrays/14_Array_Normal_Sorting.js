let nums = [10,1,21,2];
nums.sort((a,b) => a-b);// ascending order [ 1, 2, 10, 21 ]
console.log(nums);
nums.sort((a,b) => b-a);
console.log(nums); // descending order [ 21, 10, 2, 1 ]

let names = ["Rupali", "Amit", "Sneha"];
names.sort((a, b) => a.localeCompare(b));
console.log(names); //[ 'Amit', 'Rupali', 'Sneha' ]


// arrow Functions