//! Time O(logn * n) | space O(1)
function isAllocationPossible(array, students, m) {
    let allocated_students = 1;
    let pages = 0;
    for(let i = 0; i < array.length; i++) {
        if(array[i] > m) return false;
        if(pages + array[i] > m) {
            allocated_students++;
            pages += array[i];
        } else {
            pages += array[i];
        }
    }
    if(allocated_students > students) {
        return false;
    } return true;
}
function allocate_min_no_of_pages(books, students) {
    if(books < students) return -1;
    let ans = 0;
    let low = Math.min(...books); //! min in array
    let high = books.reduce( (a, b) => a + b); // ! sum of array elements
    while(low <= high) {
        let mid = Math.floor((low + high) / 2);
        if(isAllocationPossible(books, students, mid)) {
            ans = mid;
            high = mid - 1;
        } else low = mid + 1;
    }
    return ans;  
}
let array = [12, 34, 67, 90];
let students = 2;
console.log(allocate_min_no_of_pages(array, students));
