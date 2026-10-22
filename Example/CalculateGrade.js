//Calculate the letter grade based on a numeric score. 
// A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60.

let score = 85;
let grade;

if (score >=90 && score <=100) {
    grade = "A";
} else if (score >=80 && score<=89) {
    grade = "B";
} else if (score >=70 && score<=79) {
    grade = "C";
} else if (score >=60 && score<=69) {
    grade = "D";
} else {
    grade = "F";
}

console.log(`The score is ${score} and the grade is ${grade}.`);