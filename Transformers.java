
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here

//This class would contain a method that make a string read the same backward as forward
class ToPalindrome implements MyTransformer<String>{
	/*@return the palindrome of the string
	 * @param   str  string that wish to transform to its palindrome
	 */
	@Override
	public String transformElement(String str) {
		String newString = "";
		for(int i = 0; i < str.length(); i++) {
			newString = str.charAt(i) + newString;
		}
		return str + newString;
	}

}
//This class would contain a method that return the opposite number of a given double number
class ToOpposite implements MyTransformer<Double>{
	@Override
	public Double transformElement(Double num) {
		return num * -1.0;
	}

}