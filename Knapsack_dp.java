import java.util.Arrays;

public class Knapsack_dp {
    public static void main(String args[]) {
        int w = 50;
        int n = 3;
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};

        // Populate base cases    O(N*W)
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }
        
        
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity];
                int maxValWithCurr = 0;
                
                int weightOfCurr = wt[item - 1];
                if (capacity >= weightOfCurr) {
                    maxValWithCurr = val[item - 1]; 
                    
                    int remainingCapacity = capacity - weightOfCurr; 
                    maxValWithCurr += mat[item - 1][remainingCapacity]; 
                }
                
                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
            }
        }
        
        System.out.println("The Maximum Profit is: "+mat[n][w]); // Final answer
        //System.out.println(Arrays.deepToString(mat)); // Visualization of the table
    }
}