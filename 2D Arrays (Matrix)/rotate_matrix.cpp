// Rotate clockwise and anti-clockwise
/*
This implementation first defines two functions, rotateClockwise and rotateCounterclockwise, 
to rotate the image by 90 degrees clockwise and counterclockwise, respectively. 
Each function takes a 2D vector image as input and modifies it in place.

The printImage function is used to print the image for demonstration purposes.

Finally, the main function initializes an example image, prints it, rotates 
it by 90 degrees clockwise, prints it again, rotates it by 90 degrees counterclockwise, 
and prints it one last time to verify that the rotations worked as expected.
*/
#include <iostream>
#include <vector>

using namespace std;

// Function to rotate the image by 90 degrees clockwise
void rotateClockwise(vector<vector<int>>& image) {
    int n = image.size();
    for (int i = 0; i < n / 2; i++) {
        for (int j = i; j < n - i - 1; j++) {
            int temp = image[i][j];
            image[i][j] = image[n - j - 1][i];
            image[n - j - 1][i] = image[n - i - 1][n - j - 1];
            image[n - i - 1][n - j - 1] = image[j][n - i - 1];
            image[j][n - i - 1] = temp;
        }
    }
}

// Function to rotate the image by 90 degrees counterclockwise
void rotateCounterclockwise(vector<vector<int>>& image) {
    int n = image.size();
    for (int i = 0; i < n / 2; i++) {
        for (int j = i; j < n - i - 1; j++) {
            int temp = image[i][j];
            image[i][j] = image[j][n - i - 1];
            image[j][n - i - 1] = image[n - i - 1][n - j - 1];
            image[n - i - 1][n - j - 1] = image[n - j - 1][i];
            image[n - j - 1][i] = temp;
        }
    }
}

// Function to print the image
void printImage(vector<vector<int>>& image) {
    for (auto row : image) {
        for (auto pixel : row) {
            cout << pixel << " ";
        }
        cout << endl;
    }
}

// Driver code
int main() {
    vector<vector<int>> image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    cout << "Original Image:" << endl;
    printImage(image);

    rotateClockwise(image);
    cout << "Image rotated by 90 degrees clockwise:" << endl;
    printImage(image);

    rotateCounterclockwise(image);
    cout << "Image rotated by 90 degrees counterclockwise:" << endl;
    printImage(image);

    return 0;
}
