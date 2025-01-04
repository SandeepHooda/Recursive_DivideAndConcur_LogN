import java.util.Arrays;

public class Search2D {

	/*
	 * Problem: Given an m x n matrix where each row is sorted in ascending order, 
	 * and the first element of each row is greater than the last element of the previous row, 
	 * write an algorithm to find a target value in the matrix in O(log n).


	 */

	static int counter = 0;
	public static void main(String[] args) {
		int[][] nums = {
				{2,5,7,8},//0
				{11,14,17,19},//1
				{23,25,26,28},//2
				{31,32,34,36}//3
		};
		for (int[] row: nums ) {
			for (int target: row) {
				counter = 0;
				int[] result = findIn2D(nums, target, 0);
				if(target == nums[result[0]][result[1]]) {
					System.out.println("Iteration "+counter );
				}else {
					System.out.println(" Not found !!!!!!!!!! "+target);
				}
				
			}
		}
		//int[] result = findIn2D(nums, 31, 0);
		//System.out.println("Iteration "+counter +" row "+result[0]+" col "+result[1]);
	}
	
	public static int findInOneD(int[] nums , int target, int rowOffset) {
		counter++;
		int rowsCount = nums.length;
		int rowsCountHalf = rowsCount/2;
		int diff = target - nums[rowsCountHalf];
		
		if (diff ==0 ) {
			return rowsCountHalf+rowOffset;
		}else if (diff > 0) {//Search right 
			return findInOneD(Arrays.copyOfRange(nums, rowsCountHalf, nums.length), target, rowOffset+rowsCountHalf);
		}else {
			return findInOneD( Arrays.copyOfRange(nums, 0, rowsCountHalf), target,rowOffset);
		}
		
	}
	public static int[] findIn2D(int[][] nums , int target, int rowOffset) {
		counter++;
		int rowsCount = nums.length;
		int rowsCountHalf = rowsCount/2;
		if (rowsCount == 1) {
			int[] result ={rowOffset, 0};
			result[1] = findInOneD(nums[0] ,  target, 0);
			return result;
		}else {
			
		}
		
		int diff = target - nums[rowsCountHalf][0];
		if (diff ==0 ) {
			int[] result ={rowsCountHalf+rowOffset, 0};
			return result;
		} else if (diff > 0) {//search right half
			return findIn2D( Arrays.copyOfRange(nums, rowsCountHalf, nums.length), target,rowOffset+rowsCountHalf);
		}else { //Search left half
			return findIn2D( Arrays.copyOfRange(nums, 0, rowsCountHalf), target,rowOffset);
		}
		
		
	}
	

}
