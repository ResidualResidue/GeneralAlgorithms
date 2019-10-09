package recAlgorithms;

public class MergeSort {
	
	/*
	 * This is the start of the end - Call divide on the entire array
	 */
	public static void sort(int nums[]) {
		divide(nums, 0, nums.length-1);
	}
	
	private static void divide(int nums[], int l, int r) {
		//Makes sure there's at least 2 values in subarray.
		if(r-l >= 1) {
			//Finds midpoint between the two halves
			int m = (l+r)/2;
			/*
			 * Repeatedly call divide until the subarray with l being the beginning and r being the last index
			 * Once the array is of 2, call merge, and that will sort the two items into the main array.
			 */
			divide(nums, l, m);
			divide(nums, m+1, r);
			merge(nums, l, m, r);
		}
	}
	private static void merge(int nums[], int l, int m, int r) {
		
		//2 subarrays dividing nums in half.
		int leftHalf[] = subArray.subarray(nums, l, m);
		int rightHalf[] = subArray.subarray(nums, m+1, r);
		
		/*
		 * From l to r, sort the numbers in leftHalf and rightHalf
		 * into nums from least to greatest.
		 */
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = l; i <=r; i++) {
			//First two cases make sure no out of bounds errors
			if(leftIndex >= leftHalf.length) {
				nums[i] = rightHalf[rightIndex];
				rightIndex++;
			}else if(rightIndex >= rightHalf.length) {
				nums[i] = leftHalf[leftIndex];
				leftIndex++;
			//Sort in order of least to greatest.
			}else {
				if(leftHalf[leftIndex] <= rightHalf[rightIndex]) {
					nums[i] = leftHalf[leftIndex];
					leftIndex++;
				}else {
					nums[i] = rightHalf[rightIndex];
					rightIndex++;
				}
			}
			
			
		}
	}
}
