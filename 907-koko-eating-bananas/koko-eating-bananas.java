class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = maximum(piles);
        int k = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (calculateTotalHours(piles, mid, h)) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    public static int maximum(int[] piles) {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++) {
            maxValue = Math.max(maxValue, piles[i]);
        }
        return maxValue;
    }

    public static boolean calculateTotalHours(int[] piles, int noOfBananasPerHour, int h) {
        int hoursTaken = 0;
        int n = piles.length;
        for (int i = 0; i<n; i++) {
            hoursTaken += Math.ceil((double)piles[i] / (double)noOfBananasPerHour);
            
        }
        return (hoursTaken <= h);
    }
}