function sort(arr)
{
    var n = arr.length;
 
    // The output character array that will have sorted arr
    var output = Array.from({length: n}, (_, i) => 0);
 
    // Create a count array to store count of individual
    // characters and initialize count array as 0
    var count = Array.from({length: 256}, (_, i) => 0);
 
 
    // store count of each character
    for (var i = 0; i < n; ++i)
        ++count[arr[i].charCodeAt(0)];
    // Change count[i] so that count[i] now contains actual
    // position of this character in output array
    for (var i = 1; i <= 255; ++i)
        count[i] += count[i - 1];
 
    // Build the output character array
    // To make it stable we are operating in reverse order.
    for (var i = n - 1; i >= 0; i--) {
        output[count[arr[i].charCodeAt(0)] - 1] = arr[i];
        --count[arr[i].charCodeAt(0)];
    }
 
    // Copy the output array to arr, so that arr now
    // contains sorted characters
    for (var i = 0; i < n; ++i)
        arr[i] = output[i];
     return arr;
}
 
// Driver method
    var arr = [ 'g', 'e', 'e', 'k', 's', 'f', 'o',
                   'r', 'g', 'e', 'e', 'k', 's' ];
 
    arr = sort(arr);
    document.write("Sorted character array is ");
    for (var i = 0; i < arr.length; ++i)
        document.write(arr[i]);