let responseTime = 850;  // ms
let sla = 1000;          // ms
let slaStatus = responseTime <= sla ? "Within SLA ✅" : "SLA breached ❌";
console.log(`Response: ${responseTime}ms — ${slaStatus}`);


// Template Literal => ``
/* A Template Literal is a way to create a string using backticks (``) instead 
of single quotes (') or double quotes ("`).
It makes it easy to insert variables into a string.
we use ${} (dollar sign + curly braces) to insert a variable or expression inside a string. */
console.log(`What is the SLA time ? - ${sla}`);

let name = "Rupali";
console.log(`Hello ${name}`);