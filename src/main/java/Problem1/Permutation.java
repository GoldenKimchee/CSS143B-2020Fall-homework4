package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
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
            return;
        }

        permute(nums, position + 1, result);
        //put number at position in the front
        //call the same private permute with position + 1
        //put the number back to its original position
    }


    public static void main(String[] args) {
        ArrayList items = new ArrayList();
        items.add("Rachel");
        items.add('h');
        items.add(8);
        System.out.println(items);
    }
}
