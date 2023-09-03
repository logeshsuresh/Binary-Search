class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m*k > n) return -1;
        int low = calculateMinMax(bloomDay)[0], high = calculateMinMax(bloomDay)[1];
        int minDays = -1;

        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (totalBouquets(bloomDay, mid, m, k)) {
                minDays = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minDays;
    }

    private static int[] calculateMinMax(int[] bloomDay) {
        int minMax[] = new int[2];
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int day : bloomDay) {
            minValue = Math.min(minValue, day);
            maxValue = Math.max(maxValue, day);
        }
        minMax[0] = minValue;
        minMax[1] = maxValue;
        return minMax;
    }

    private static boolean totalBouquets(int[] bloomDay, int day, int m, int k) {
        int flowersBloomed = 0;
        int totalBouquets = 0;
        int n = bloomDay.length;
        for(int i = 0; i<n; i++) {
            if (bloomDay[i] <= day) {
                flowersBloomed += 1;
            } else {
                totalBouquets += flowersBloomed / k;
                flowersBloomed = 0;
            }
        }
        totalBouquets += flowersBloomed/k;
        return totalBouquets >= m;
    }
}