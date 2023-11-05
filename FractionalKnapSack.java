
import java.util.*;

public class FractionalKnapSack {
	private static double getMaxValue(ItemValue[] arr,int capacity){
		// Sorting items by profit/weight ratio;         n(logn)
		Arrays.sort(arr, new Comparator<ItemValue>() {
			public int compare(ItemValue item1,ItemValue item2)
			{
				double cpr1 = (double) item1.profit / (double) item1.weight;
				double cpr2 = (double) item2.profit / (double) item2.weight;

				if (cpr1 < cpr2)
					return 1; //it returns 1 to indicate that the first item should come after the second item
				else
					return -1;
			}
		});

		double totalValue = 0d;
		for (ItemValue i : arr) {

			int curWt = (int)i.weight;
			int curprof = (int)i.profit;

			if (capacity - curWt >= 0) {
				// This weight can be picked whole
				capacity = capacity - curWt;
				totalValue += curprof;
			}
			else {
				// Item cant be picked whole
				double fraction = ((double)capacity / (double)curWt);
				totalValue += (curprof * fraction);
				capacity = (int)(capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	
	static class ItemValue {
		int profit, weight;

		public ItemValue(int val, int wt){
			this.weight = wt;
			this.profit = val;
		}
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Elements: ");
        int n = scanner.nextInt();
        System.out.print("Enter Initial Weight: ");
        int capacity = scanner.nextInt();

		ItemValue[] arr = new ItemValue[n];
		for (int i = 0; i < n; i++) {
            arr[i] = new ItemValue(i, i);
            System.out.print("Enter Weight for element " + (i + 1) + ": ");
            arr[i].weight = scanner.nextInt();
            System.out.print("Enter Profit for element " + (i + 1) + ": ");
            arr[i].profit = scanner.nextInt();
        }

		double maxValue = getMaxValue(arr, capacity);

		System.out.println("The Maximum Profit is: "+maxValue);
	}
}
