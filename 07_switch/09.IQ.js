let status = 0;
console.log(typeof status);
switch (status) { //In switch it is === Strict comparison, value and data type both of them should be same.

    case false:
        console.log("false matched");
        break;
    case 0:
        console.log("0 matched");
        break;
}