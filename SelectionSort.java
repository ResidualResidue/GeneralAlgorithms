package recAlgorithms;

public class SelectionSort {

	public static void sort(int nums[]) {
		//Place is the highest index where the array is sorted.
		int place = 0;
		//Search is the starting point to search for a minimum.
		int search;
		while(place < nums.length) {
			
			//Minimum in a current search.
			int min = nums[place];
			//Index of minimum in a current search.
			int minIndex = place;
			//Must find the index of minimum in search.
			for(search = place; search < nums.length; search++) {
				if(nums[search] < min) {
					min = nums[search];
					minIndex = search;
				}
			}
			//Must switch the number at "place" with the minumum
			int temp = nums[minIndex];
			nums[minIndex] = nums[place];
			nums[place] = temp;			 
			place++;
		}		
		
	}
}
