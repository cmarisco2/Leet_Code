//? LeetCode problem 1299 - 'Easy'

// Problem Statement:
// Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1

// After doing so, return the array

/**
 * Input array: [17, 18, 5, 4, 6, 1]
 * Output: [18, 6, 6, 6, 1, -1]
 */

//? SOLUTION Notes:
//* 1) Reverse Iterate
//* 2) oldMax = -1 (before loop)
//* 3) newMax = max(oldMax, arr[i])

const arr = [17, 18, 5, 4, 6, 1]; 
console.log(arr);

let oldMax = -1;
let newMax;

for(let i = arr.length - 1; i >= 0; i--){
    newMax = Math.max(oldMax, arr[i]);
    arr[i] = oldMax;
    oldMax = newMax;
}

console.log(arr);

