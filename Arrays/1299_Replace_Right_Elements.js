//!LeetCode problem 1299 - 'Easy'

//? Problem Statement:
//* Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

//* After doing so, return the array.

/**
 * Input array: [17, 18, 5, 4, 6, 1]
 * Output: [18, 6, 6, 6, 1, -1]
 */

const arr = [17, 18, 5, 4, 6, 1]; 

console.log(arr);

//* Fence Post Setup
let N = arr.length;
let tempVal = arr[N - 2];
arr[N - 2] = arr[N - 1];
let max;

//* Loop w/ Reassign from the Right

for(i = N - 3; i >= 0; i--){
    max = Math.max(tempVal, arr[i + 1]);
    tempVal = arr[i];
    arr[i] = max;
}

arr[N - 1] = -1;

console.log(arr);


//* Note:
//* Solution Does not account for arr < size = 3.

