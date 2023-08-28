package leetcode;
// https://foxtrot.tistory.com/20
class MinimumSizeSubarraySum {
    private int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = nums.length + 1;
        int sum = nums[0];
        while (left < nums.length) {
            if (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                if (minLength == 1) return 1;
                sum -= nums[left++];
            } else {
                if (right < nums.length - 1) {
                    sum += nums[++right];
                } else if (sum >= target) {
                    sum -= nums[left++];
                } else {
                    break;
                }
            }
        }

        if (minLength == nums.length + 1) return 0;
        else return minLength;
    }
}
