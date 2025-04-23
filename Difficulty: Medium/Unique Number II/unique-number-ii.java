//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        
        // Step 2: Find the rightmost set bit (this will help differentiate the two unique numbers)
        int rightmostSetBit = xor & -xor;
        
        // Step 3: Partition the array into two groups and find each unique number
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        // Return the numbers in increasing order
        return num1 < num2 ? new int[]{num1, num2} : new int[]{num2, num1};
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int[] ans = ob.singleNum(arr);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends