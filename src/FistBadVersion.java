
public class FistBadVersion {

	static int runCount = 0;
	public static void main(String[] args) {
		System.out.println(findFirstBad(1,10000));
		System.out.println("Run count "+runCount);

	}
	
	public static boolean isBadVersion(int version) {
	    return version >= 56949; // First bad version is 6
	}
	
	public static int findFirstBad(int start, int end) {
		runCount++;
		//Do we need to divide further
		if (  end < start) {
			return -1;
		}else if (start == end){
			if (isBadVersion(start)) {
				return start;
			}
		}
		
		//If yes then
		int midVersion = (start + end)/2;
		//Test the half and make a recursive call 
		if (isBadVersion(midVersion)) {
			return findFirstBad(start, midVersion);//Left
		}else {
			return findFirstBad(midVersion+1, end);//Right
		}
				
		
	}

}
