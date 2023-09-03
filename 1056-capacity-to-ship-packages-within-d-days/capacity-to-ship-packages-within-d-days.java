class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = calculateMin(weights), high = calculateSum(weights);
        int capacity = low;

        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (noOfDays(weights, mid, days)) {
                capacity = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return capacity;
    }

    private int calculateSum(int[] weights) {
        int sum = 0;

        for(int weight : weights) {
            sum += weight;
        }

        return sum;
    }

    private int calculateMin(int[] weights) {
        int minValue = Integer.MAX_VALUE;

        for(int weight : weights) {
            minValue = Math.min(minValue, weight);
        }

        return minValue;
    }

    private static boolean noOfDays(int[] weights, int maxAllowed, int days) {
        int daysReq = 1;
        int conveyorCap = 0;

        for(int weight : weights) {
            if (weight > maxAllowed) {
                return false;
            } else if (weight + conveyorCap > maxAllowed) {
                daysReq += 1;
                conveyorCap = weight;
            } else {
                conveyorCap += weight;
            }
        }
        
        return (daysReq <= days);
    }
}