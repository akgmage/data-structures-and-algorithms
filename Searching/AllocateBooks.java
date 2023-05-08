/**
 * Problem Description
 *
 *
 *
 * Given an array of integers A of size N and an integer B.
 *
 * The College library has N books. The ith book has A[i] number of pages.
 *
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 *
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *  1 <= A[i], B <= 105
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return that minimum possible number.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [12, 34, 67, 90]
 * B = 2
 * Input 2:
 * A = [5, 17, 100, 11]
 * B = 4
 *
 *
 * Example Output
 * Output 1:
 * 113
 * Output 2:
 * 100
 *
 *
 * Example Explanation
 * Explanation 1:
 * There are two students. Books can be distributed in following fashion :
 * 1)  [12] and [34, 67, 90]
 *     Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2)  [12, 34] and [67, 90]
 *     Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3)  [12, 34, 67] and [90]
 *     Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 *     Of the 3 cases, Option 3 has the minimum pages = 113.
 */
package Searching;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] books = { 12, 34, 67, 90 };
        int students = 2;
        int ans = solve(books, students);
        System.out.println(ans);
    }
    public static int solve(int[] books, int students) {
        // O(N*Log(sumOfBooks - Min(book)) time | O(1) space

        if (students > books.length) return -1;

        int left = books[0];
        int right = books[0];

        // find min and sum
        for (int i = 1; i < books.length; i++) {
            left = Math.min(books[i], left);
            right += books[i];
        }
        int ans = -1;

        // binary search based on books

        while (left <= right) {

            int middle = left + (right - left)/2;

            if (isAllocationPossible(books, students, middle)) {
                ans = middle;
                right = middle - 1; // go left we want min.allocation
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }
    public static boolean isAllocationPossible(int[] books, int students, int maxPages) {
        int allocatedStudents = 1;
        int allocatedPages = 0;

        for (int currentPages : books) {
            if (currentPages > maxPages) return false; // you cannot assign
            if (allocatedPages + currentPages > maxPages) {
                allocatedStudents += 1;
                allocatedPages = currentPages;
            } else {
                allocatedPages += currentPages;
            }
        }
        return allocatedStudents <= students;
    }
}
