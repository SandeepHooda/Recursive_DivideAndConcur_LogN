
import java.util.Arrays;
import java.util.List;

public class ColorBlindFormList {
	static int runCount = 0;
	static String colorToFind = "red";

	public static void main(String[] args) {
		String[] colors = { "red", "green", "blue", "white", "black", "noar", "blac", "red1", "green1", "blue1",
				"white1", "black1", "noar1", "blac1" };
		List<String> colorsToTest = Arrays.asList(colors);
		ColorBlindFormList test = new ColorBlindFormList();

		for (String color : colors) {
			runCount = 0;
			colorToFind = color;
			System.out.println(test.findColorBlindness_DivideAndConcur(colorsToTest));
			System.out.println("Run count "+colorToFind +" "+ runCount);
		}
		
		
		
	}

	public boolean testBlindness(List<String> color) {
		//This is still O(n) but we are not optimizing this test function
		if (color.contains(colorToFind)) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> findColorBlindness_DivideAndConcur(List<String> colors) {
		runCount++;

		// Should we further divide?

		// Don't divide if
		if (!testBlindness(colors)) {// Does not contain in the list or this half
			return null;
		} else if (colors.size() == 1) { // The list or the sublist has only one element
			return colors;
		}

		// Yes we should divide further
		// Test the half and make a recursive call
		List<String> lefthalf = colors.subList(0, colors.size() / 2);
		List<String> righthalf = colors.subList(colors.size() / 2, colors.size());

		if ((testBlindness(lefthalf))) {
			return findColorBlindness_DivideAndConcur(lefthalf);
		} else {
			return findColorBlindness_DivideAndConcur(righthalf);
		}

	}

}
