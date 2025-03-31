//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        int[] lastOccurrence = new int[26];
        
        // Initialize last occurrence array
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int partitions = 0;
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, lastOccurrence[c - 'a']);
            if (i == end) {
                partitions++;
                start = end + 1;
            }
        }
        
        return partitions;
    }
}

// Driver Code Ends