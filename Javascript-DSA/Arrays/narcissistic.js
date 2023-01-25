//! https://relevel.com/courses/backend-development-course-0001/schedule/class-details/ae173dd6-a086-4a56-85d0-0e41f00cdf14/live-class

let num = 10000;

for (let n = 0; n <= num; n++) {

    let str = "" + n;
    let numberOfDigits = str.length;
    let temp = n;
    let sum = 0;

    while (temp > 0) {
        let lastDigit = temp % 10;
        sum = sum + Math.pow(lastDigit, numberOfDigits);
        temp = Math.floor(temp / 10);
    }
    if (sum == n) {
        console.log(n);
    }
}