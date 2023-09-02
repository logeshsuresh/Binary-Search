class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        /*
            In order to eliminate a lot of edge cases,
            we move low = 1 and high = n - 2
        */
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // check if mid is single element
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if ( (mid % 2 == 1 && nums[mid] == nums[mid-1]) || mid % 2 == 0 && (nums[mid] == nums[mid+1]) ) {
                // mid is in left half
                low = mid + 1;
            }  else {
                // mid is in right half
                high = mid - 1;
            }
        }

        return -1;
    }
}