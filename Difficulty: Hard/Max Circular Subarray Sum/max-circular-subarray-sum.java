class Solution {
    public int maxCircularSum(int arr[]) {
        if (arr == null || arr.length == 0) return 0;

        int total = 0;
        int maxEnding = arr[0], maxSoFar = arr[0];
        int minEnding = arr[0], minSoFar = arr[0];

        total = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            // Kadane for max subarray
            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            // Kadane for min subarray
            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);

            total += x;
        }

        // If all numbers are negative, maxSoFar is the answer (can't use circular wrap).
        if (maxSoFar < 0) {
            return maxSoFar;
        }

        // Otherwise, maximum of non-wrapping (maxSoFar) and wrapping (total - minSoFar)
        return Math.max(maxSoFar, total - minSoFar);
    }
}
