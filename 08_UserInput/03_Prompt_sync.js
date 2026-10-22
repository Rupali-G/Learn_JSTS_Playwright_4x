const prompt = require("prompt-sync")();
let num = Number(prompt("Enter a number"));
console.log(num);
// but if you directly run it it will give you error 
// because prompt-sync is not a built-in module of node js.
// you have to use node.js
// if you give command "node 03_Prompt_sync.js" in terminal it will not work fine
//bcoz our project is not a node.js project. It is a normal javascript project.
// in this case we have to make this project as node.js project. 
// For that we have to give command "npm init -y" in terminal.
// after that it will create a package.json file in your project folder.
// now you have to install prompt-sync module in your project folder. 
// For that you have to give command "npm install prompt-sync" in terminal.
// now you can run this file using command node foldername.file name
//  "node 08_UserInput/03_Prompt_sync.js" in terminal and it will work fine.