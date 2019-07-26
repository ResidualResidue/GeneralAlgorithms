package recAlgorithms;

public class QuickSort {
	public QuickSort() {
		
	}
	public static void sort(int nums[]) {
		quickSort(nums, 0, nums.length-1);
	}
	private static void quickSort(int nums[], int low, int high) {
		if(low < high) {
		
			int pi = partition(nums, low, high);
		
			quickSort(nums, low, pi-1);
			quickSort(nums, pi+1, high);
		}
		
	}
	private static int partition(int nums[], int low, int high) {
		int pivot = high;
		
		//i sorts the 
		int i = low;
		for(int j = low; j<high; j++) {
			if(nums[j] <= nums[pivot]) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				
			}
		}
		int temp = nums[high];
		nums[high] = nums[i];
		nums[i]= temp;
		return i;
	}
}
