package recAlgorithms;

public class QuickSort {
	public QuickSort() {
		
	}
	public static void sort(int nums[]) {
		quickSort(nums, 0, nums.length-1);
	}
	private static void quickSort(int nums[], int low, int high) {
		if(low < high) {
			//Returns the partition index of where everything to the left is less than
			//The value at the index of the pi, and everything to the right of it is greater.
			int pi = partition(nums, low, high);
			//Exclusively left and exlcusively right is recursively quicksorted.
			quickSort(nums, low, pi-1);
			quickSort(nums, pi+1, high);
		}
		
	}
	private static int partition(int nums[], int low, int high) {
		//Pivot point is the last index.
		int pivot = high;
		
		//Goes through all values up to but not including pivot. 
		//i keeps track of the index where pivot is gonna go.
		int i = low;
		for(int j = low; j<high; j++) {
			/*
			 * j iterates through whole array. 
			 * j being less than or equal to the pivot switches it with the current value of i
			 * and increments i.
			 * i indicates the place where the pivot itself will eventually go.
			 */
			if(nums[j] <= nums[pivot]) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				
			}
		}
		//Switches pivot with value at i.
		int temp = nums[high];
		nums[high] = nums[i];
		nums[i]= temp;
		return i;
	}
}
