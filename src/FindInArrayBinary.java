

public class FindInArrayBinary {
	static int runCount = 0;
	public static void main(String[] args) {
		FindInArrayBinary find = new FindInArrayBinary();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int[] pointers = {0,nums.length-1};
		System.out.println(find.divideAndFind(nums, 4, pointers));
		System.out.println("Run count "+runCount);
		System.out.println(find.divideAndFind(nums, 5, pointers));
		System.out.println(find.divideAndFind(nums, 6, pointers));
		System.out.println(find.divideAndFind(nums, 7, pointers));
		System.out.println(find.divideAndFind(nums, 0, pointers));
		System.out.println(find.divideAndFind(nums, 1, pointers));
		System.out.println(find.divideAndFind(nums, 2, pointers));
	}
	
	public int test(int[] nums, int target, int[] pointers) {
		
		if (nums[pointers[0]] == target) {
			return pointers[0];
		}else if (nums[pointers[1]] == target){
			return pointers[1];
		}else {
			return -1;
		}
	}
	
	public int  divideAndFind(int[] nums, int target, int[] pointers) {
		runCount++;
		//Should we further divide?
		
		//Don't divide if
		int pointerSize = pointers[1] - pointers[0];
		if (pointerSize < 0) {
			return -1;
		}else if ( pointerSize <= 1) {
			return test(nums, target,pointers);
		}
		
		
		//Yes we should divide further
		int centerPos = ( pointers[1] +  pointers[0])/2;
		//System.out.println(pointers[0]+" "+pointers[1]+"-----"+centerPos);
		int[] pointersLeft = {pointers[0], centerPos};
		int[] pointersRight = {centerPos +1 , pointers[1]};
		int index =divideAndFind(nums, target, pointersLeft);
		if (index<0) {
			return divideAndFind(nums, target, pointersRight);			
		}
		
		return index;
		
		
	}
}
