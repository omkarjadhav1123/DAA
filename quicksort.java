//4 6 2 5 7 9 1 3

import java.util.*;


class quicksort{

    static int partition(int a[], int l, int h){
        int pivot = a[l];
        int i=l;
        int j=h;
        while(i<j){
            while(a[i]<=pivot) i++;
            while(a[j]>pivot) j--;
            if(i<j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;
        return j;
    }
    static void Quicksort(int a[], int l, int h){
        if(l<h){
            int pivot = partition(a,l,h);
            Quicksort(a,l,pivot-1);
            Quicksort(a,pivot+1,h);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total count of numbers : ");
        int n=sc.nextInt();
        System.out.print("Enter The numbers: ");
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        
        Quicksort(a,0,n-1);

        for(int i=0; i<a.length; i++){
            System.out.print( +a[i]+" ");
        }
    }
}