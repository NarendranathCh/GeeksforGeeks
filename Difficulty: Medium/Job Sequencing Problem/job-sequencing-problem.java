//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        if (n == 0) {
            result.add(0);
            result.add(0);
            return result;
        }
        
        // Create an array of Job objects
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i + 1, deadline[i], profit[i]);
        }
        
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        
        // Initialize slots to keep track of scheduled jobs
        int[] schedule = new int[maxDeadline + 1]; // 1-based indexing
        boolean[] occupied = new boolean[maxDeadline + 1];
        
        int jobCount = 0;
        int totalProfit = 0;
        
        // Schedule jobs
        for (Job job : jobs) {
            // Find the latest possible slot before the deadline
            for (int j = Math.min(maxDeadline, job.deadline); j >= 1; j--) {
                if (!occupied[j]) {
                    occupied[j] = true;
                    schedule[j] = job.id;
                    jobCount++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
    
    // Helper Job class
    class Job {
        int id;
        int deadline;
        int profit;
        
        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends