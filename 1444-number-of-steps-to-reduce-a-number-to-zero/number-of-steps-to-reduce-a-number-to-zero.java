class Solution {
    public int numberOfSteps(int num) {
        int count = calculateSteps(num, 0);
        return count;
    }

    public static int calculateSteps(int n, int steps) {
        if (n == 0) {
            return steps;
        }
        if (n % 2 == 0) return calculateSteps(n / 2, steps + 1);
        else return calculateSteps(n - 1, steps + 1);
    }
}