

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorBlindFormList {

	public static void main(String[] args) {
		String[] colors = {"red", "green", "blue","white","black", "noar", "blac",
				"red1", "green1", "blue1","white1","black1", "noar1", "blac1"};
		List<String> colorsToTest = Arrays.asList(colors);
		ColorBlindFormList test = new ColorBlindFormList();
		
		System.out.println(test.findColorBlindness_DivideAndConcur(colorsToTest));

	}
	
	
	public boolean testBlindness(List<String> color) {
		if (color.contains("green1") ) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public List<String> findColorBlindness_DivideAndConcur(List<String> colors){
		System.out.println(" Running");
		
		//Should we further divide?
		
		//Don't divide if
		if (!testBlindness(colors)) {//Does not contain in the list or this half 
			return null;
		}else if (colors.size() == 1) { //The list or the sublist  has only one element
			return colors;
		}
		
	
		//Yes we should divide further
		List<String> lefthalf = colors.subList(0, colors.size()/2);
		List<String> righthalf = colors.subList(colors.size()/2,colors.size() );
		
		if ((testBlindness(lefthalf)  )) {
			return findColorBlindness_DivideAndConcur(lefthalf);
		}else {
			return findColorBlindness_DivideAndConcur(righthalf);
		}
		
		
	}

}
