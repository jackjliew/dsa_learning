package gmail.jackjliew.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
* */
public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {


        List resultList = new ArrayList();
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            resultList = findIntersect(nums2, nums1);
        } else {
            resultList = findIntersect(nums1, nums2);
        }

        int count = resultList.size();
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            result[i] = (int) resultList.get(i);
        }

        return result;
    }

    public List findIntersect(int[] small, int[] large) {
        List result = new ArrayList();
        Map indexMap = new HashMap();
        int m = small.length;
        int n = large.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (small[i] == large[j] && !indexMap.containsKey(j)) {
                    result.add(small[i]);
                    indexMap.put(j, j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        IntersectionofTwoArraysII sut = new IntersectionofTwoArraysII();
        int[] result = sut.intersect(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(result[i]);
        }

    }

}
