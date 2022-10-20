package gmail.jackjliew.test;

import java.util.*;

public class ContainDuplicate {

    public boolean containsDuplicateSort(int[] nums) {
        if (nums == null)
            return false;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicateHashMap(int[] nums) {
        if (nums == null)
            return false;

        int length = nums.length;
        Map numsmap = new HashMap(length);
        for (int i = 0; i < nums.length; i++) {
            if (!numsmap.containsKey(nums[i])) {
                numsmap.put(nums[i], 1);
            } else {
                return true;
                //numsmap.put(nums[i], (int) numsmap.get(nums[i]) + 1);
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;

        Set numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);

        }
        return nums.length != numSet.size();
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        int[] nums = {1, 8, 2, 6, 4, 2};
        containDuplicate.containsDuplicateSort(nums);
    }
}
