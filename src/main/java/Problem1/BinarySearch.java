package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }
        return binarySearch(data, target, 0, data.length - 1);  // place holder
    }

    //helper function
    public static int binarySearch(int[] data, int target, int start, int end) {
        if (start > end) { //target not found
            return -1;
        }

        int mid = (start + end) / 2; //main operation

        if (data[mid] == target) { //found target
            return mid;
        } else if (data[mid] < target) { //if int at mid is smaller than target
            return binarySearch(data, target, mid + 1, end);
        } //if int at mid is bigger than target
         return binarySearch(data, target, start, mid - 1);
    }
}
