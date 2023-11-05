// import java.util.*;

// class fibonacci_Number{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int maxNumber = 0; 
//         int previousNumber = 0;
//         int nextNumber = 1;
//         System.out.print("How many numbers you want in Fibonacci : ");
//         maxNumber = sc.nextInt();
//         System.out.print("The fibonacci numbers are : ");
//         int i=1;
//         while(i<=maxNumber){
//             System.out.print(previousNumber+" ");
//             int sum = previousNumber+nextNumber;
//             previousNumber = nextNumber;
//             nextNumber = sum;
//             i++;
//         }
//     }
// }




import java.util.*;

class fibonacci_Number{
    public static int fibonacciRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
                return 1;
            }
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
        }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int maxNumber = 0;
        System.out.print("How many numbers you want in Fibonacci : ");
        maxNumber = sc.nextInt();
        System.out.print("The fibonacci numbers are : ");
        for(int i = 0; i < maxNumber; i++){
			System.out.print(fibonacciRecursion(i) +" ");
		}
    }
}