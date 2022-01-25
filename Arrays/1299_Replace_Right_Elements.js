//!LeetCode problem 1299 - 'Easy'

//? Problem Statement:
//* Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1

//* After doing so, return the array

/**
 ** Input array: [17, 18, 5, 4, 6, 1]
 ** Output: [18, 6, 6, 6, 1, -1]
 */

//! SOLUTION Notes:
//* 1) Reverse Iterate to have a O(N) solution
//* 2) Fence Post 'oldMax = -1'
//* 3) Swap Concept -> use 'arr[i]' in 1st statement, before overwriting in next, with the old value. Similar to swapping values in an array. It'll be used for next iteration
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

