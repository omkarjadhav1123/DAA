import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jobSceduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> deadlines = new ArrayList<>();
        List<Integer> profits = new ArrayList();
        List<String> jobSequence = new ArrayList();

        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x;
            String z;
            System.out.print("Enter job id: ");
            z = scanner.next();
            jobSequence.add(z);
            System.out.print("Enter Deadline for Job " + (z) + ": ");
            x = scanner.nextInt();
            deadlines.add(x);
            System.out.print("Enter Profit for Job " + (z) + ": ");
            x = scanner.nextInt();
            profits.add(x);
        }
    


        // Sort jobs based on profit
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (profits.get(i) < profits.get(j)) {
                    Collections.swap(profits, i, j);
                    Collections.swap(deadlines, i, j);
                    Collections.swap(jobSequence, i, j);
                }
            }
        }
        int t=3;
        boolean result[] = new boolean[t];
        String job[] = new String[t];
        for(int i=0; i<n; i++){
            int time = deadlines.get(i);
            for(int j=Math.min(t-1,time-1); j>=0; j--){
                if(result[j] == false){
                    result[j] = true;
                    job[j] = jobSequence.get(i);
                    break;
                }
            }
        }

        System.out.print("Job Sequence (in order of execution): ");
        for (String jobIndex : job) {
            if(jobIndex == null)
                continue;
            System.out.print("Job " + (jobIndex ) + " ");
        }
    }
}
