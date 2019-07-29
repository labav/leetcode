package leetcode.e1_two_sum;

/**
 * https://leetcode.com/problems/two-sum/
 */

public class Solution {
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 7, 11, 2};
        int target = 9;

        int[] arr = twoSum(nums, target);

        System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }


}
