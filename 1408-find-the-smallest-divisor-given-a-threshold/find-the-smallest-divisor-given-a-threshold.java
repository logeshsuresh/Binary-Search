class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = calculateMax(nums);
        int minDiv = 1;

        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (calculateDivSum(nums, mid, threshold)) {
                minDiv = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minDiv;
    }

    private static int calculateMax(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for(int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        return maxValue;
    }

    private static boolean calculateDivSum(int[] nums, int div, int threshold) {
        int divSum = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            if (nums[i] == 1) {
                divSum += nums[i];
            } else {
                divSum += Math.ceil((double)nums[i] / (double)div);
            }
        }
        return divSum <= threshold;
    }
}