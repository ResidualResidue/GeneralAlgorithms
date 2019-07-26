package recAlgorithms;

public class InsertionSort {
	
	public static void sort(int[] nums) {
		//Highest index value in nums that is sorted.
		int place;
		//Sorts the value after place into the sorted part of the array
		int insert;
		for(place = 0; place < nums.length-1; place++) {
			insert = place+1;
			while(insert > 0 && nums[insert] < nums[insert-1]) {
				int temp = nums[insert];
				nums[insert] = nums[insert-1];
				nums[insert-1] = temp;
				insert--;
			}
		}
	}

}
