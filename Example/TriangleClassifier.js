//Write a program that takes three sides of a triangle and classifies 
// it as Equilateral, Isosceles, or Scalene.
//Input:10 10 15, Output: Isosceles, Two sides are equal (10 and 10)
//Input: 5 5 5, Output: Equilateral, All sides are equal (5, 5, and 5)
//Input: 10 20 30, Output: Scalene, All sides are different (10, 20, and 30)

let side_1 = 10;
let side_2 = 120;
let side_3 = 102;

if (side_1 === side_2 && side_1 === side_3) {
    console.log("Equilateral");
} else if (side_1 === side_2 || side_1 === side_3 || side_2 === side_3) {
    console.log("Isosceles");
} else {
    console.log("Scalene");
}
