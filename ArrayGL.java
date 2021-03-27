public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here
    public E[] toArray() {
    	E[] output = (E[]) (new Object[size]);
    	for(int i = 0; i < size; i++) {
    		output[i] = elements[i];
    	}

    	return output;
    }
    	
    
  //@return true if the list has no elements, false otherwise.
    @Override
    public boolean isEmpty() {
    	if(size == 0) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public void transformAll(MyTransformer mt) {
    	
    	for(int i = 0; i < size; i++) {
    		if(elements[i] != null) {
    			E currentValue = (E) (mt.transformElement(elements[i]));
    			elements[i] = currentValue;
    		}
    	}
}
   
    @Override
    public void chooseAll(MyChooser mc) {
    	int tempSize = size;
    	for(int i = 0; i < size; i++) {
    		if(elements[i] == null) {
    			tempSize--;
    		}
    		else if(!mc.chooseElement(elements[i])){
    			elements[i] = null;
    			tempSize--;
    		}
    	}
    	E[] temp = (E[]) (new Object[tempSize]);
    	int tempIndex = 0;
    	for(int i = 0; i < size; i++) {
    		if(elements[i] != null) {
    			temp[tempIndex] = elements[i];
    			tempIndex++;
    		}
    	}
    	elements = temp; 
    	size = tempSize;
    }
    
    
    
}