class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here
//This class would choose all elements in the list.
class ChooseAllChooser<E> implements MyChooser<E>{

	@Override
	public boolean chooseElement(E element) {
		return true;
	}
}
//This class would choose random element
class RandomChooser<E> implements MyChooser<E>{
	
	//@return true if random number is 1; return false if random number is 0. 
	@Override
	public boolean chooseElement(E element) {
		int randomNum = (int) (Math.random() * 2);
		if(randomNum == 0)
			return false;
		return true;
		
	}
	
}
