//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findPlatform(int arr[], int dep[]) {
        // Sort both the arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformsNeeded = 1; // At least one platform is needed
        int maxPlatforms = 1;
        int i = 1; // Pointer for arrival array
        int j = 0; // Pointer for departure array
        
        int n = arr.length;
        
        while (i < n && j < n) {
            // If the current train arrives before the train at dep[j] departs
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > maxPlatforms) {
                    maxPlatforms = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }
        
        return maxPlatforms;
    }
}
