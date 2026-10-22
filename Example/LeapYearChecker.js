//Write a program to check if a given year is a leap year. 
// A leap year is divisible by 4, except for century years which must be divisible
//  by 400.


let year = 2023;

if (year % 400 === 0) {
    console.log("YES");
} else if (year % 100 === 0) {
    console.log("NO");
} else if (year % 4 === 0) {
    console.log("YES");
} else {
    console.log("NO");
}
