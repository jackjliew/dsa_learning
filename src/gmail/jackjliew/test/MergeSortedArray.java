package gmail.jackjliew.test;

import java.util.Arrays;

/*
* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

* */

public class MergeSortedArray {
    public void merge_easy(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int end = m+n-1;
        int end1 = m -1;
        int end2 = n -1;

        while(end2 >= 0){
            if(end1 >=0){
                nums1[end--] = nums1[end1] > nums2[end2] ? nums1[end1--] : nums2[end2--];
            }else{
                nums1[end--] = nums2[end2--];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;



        MergeSortedArray sut = new MergeSortedArray();
        sut.merge(nums1, m, nums2, n);

        printArray(nums1, m + n);


        int[] nums3 = {1};
        m = 1;
        int[] nums4 = {};
        n = 0;
        sut.merge(nums3, m, nums4, n);
        printArray(nums3, m + n);

        int[] nums5 = {0};
        m = 0;
        int[] nums6 = {1};
        n = 1;
        sut.merge(nums5, m, nums6, n);
        printArray(nums5, m + n);

    }

    private static void printArray(int[] nums1, int length) {
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(nums1[i]);
        }
        System.out.println("");
    }
}
