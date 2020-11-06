package Problem1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            List<Integer> one = new ArrayList<>();
            result.add(one);
        } else {
            permute(nums, 0, result);
        }
        return result;
    }

    //helper function
    private static void permute(int[] nums, int position, List<List<Integer>> result) {
        //Stopping condition
        if (position == nums.length - 1) {
            List<Integer> oneResult = new ArrayList<>(); //Create a list to add the result in
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]); //builds one unique combination
            }
            result.add(oneResult); //adds that combo to the result list
            return;

        //Recursive procedure
        } else {
            //swaps the number at position with itself and the rest of the numbers on the right
            for (int i = position; i < nums.length; i++) {
                swap(nums, i, position); //main operation that swaps numbers
                permute(nums, position + 1, result); //swaps for next index
                swap(nums, i, position); //resets the positions back to normal
            }
        }
    }

    //another helper function
    //swaps the elements at indexes i and j
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
