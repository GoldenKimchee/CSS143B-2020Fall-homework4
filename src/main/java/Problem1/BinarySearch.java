package Problem1;

public class BinarySearch {
    // Main function that calls the helper function
    public static int binarySearch(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }
        return binarySearch(data, target, 0, data.length - 1);
    }

    //helper function
    //Does the bulk of the work, solves the subproblems
    public static int binarySearch(int[] data, int target, int start, int end) {
        if (start > end) { //target not found in array
            return -1;
        }

        int mid = (start + end) / 2; //find middle index to compare with

        if (data[mid] == target) { //found target
            return mid;
        } else if (data[mid] < target) { //if int at mid is smaller than target
            return binarySearch(data, target, mid + 1, end);
        } //if int at mid is bigger than target
         return binarySearch(data, target, start, mid - 1);
    }
}
