class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int indices[] = {-1, -1};

        indices[0] = findFirstPosition(nums, n, target);
        indices[1] = findLastPosition(nums, n, target);

        return indices;
    }

    public int findFirstPosition(int[] nums, int n, int target) {
        int firstPos = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstPos = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstPos;
    }

    public int findLastPosition(int[] nums, int n, int target) {
        int lastPosition = - 1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastPosition = mid;
                low = mid + 1;
            } else if (nums[mid] > target)  {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastPosition;
    }
}