 function countingSort(array) { //! for only positive numbers
        let outputArray = Array(array.length).fill(0);
        let maxElement = Math.max(...array); //! O(n)
        let n = array.length;
        let frequency_array = Array(maxElement + 1).fill(0);

        //! fill the frequency array

        for(let i = 0; i < n; i++) {
        
            frequency_array[array[i]] += 1;

        }
        //! create the prefix sum array of frequency array
        for(let i = 1; i < frequency_array.length; i++) {
            frequency_array[i] = frequency_array[i] + frequency_array[i - 1] ; 
        }

        //! fill the output array based on the correct index of last occurence of any element

        for(let i = 0; i < n; i++) {
            let current_element = array[i];
            outputArray[frequency_array[current_element] - 1] = array[i];
            frequency_array[current_element] -= 1;
        }
        return outputArray;
 }

let array = [1, 4, 3, 2, 1, 1, 2, 3];
let sortedArray = countingSort(array);

console.log(sortedArray);