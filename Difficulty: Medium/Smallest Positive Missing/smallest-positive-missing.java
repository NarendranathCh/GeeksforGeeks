class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Place each number in its correct index (value x goes to index x-1)
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // swap arr[i] with arr[arr[i] - 1]
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // Step 2: The first place where index doesn't match value gives answer
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;  // smallest missing positive
            }
        }

        // Step 3: If all positions are filled correctly
        return n + 1;
    }
}
