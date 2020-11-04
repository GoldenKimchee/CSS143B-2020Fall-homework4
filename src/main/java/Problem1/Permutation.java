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

    //[1,2,3]
    //pick every number and put it in the front
    private static void permute(int[] nums, int position, List<List<Integer>> result) {
        //Stopping condition
        if (position == nums.length - 1) {
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
            result.add(oneResult);
            return;
        } else {
            for (int i = position; i < nums.length; i++) {
                swap(nums, i, position);
                permute(nums, position + 1, result);
                swap(nums, i, position);
            }
        }
        //put number at position in the front
        //call the same private permute with position + 1
        //put the number back to its original position
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
