public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
    	front = new Node(null, null);
    	size = 0;
    	Node currentNode = front;
    	for(int i = 0; i < contents.length; i++) {
    		
    		currentNode.next = new Node(contents[i], null);
    		size++;
    		currentNode = currentNode.next;
    	}
    	
    }

    //@return the contents of the list as a new array     
    @SuppressWarnings("unchecked")
    @Override
    	public E[] toArray() {
    	Node currentNode = this.front.next;
    	E[] elements = (E[])(new Object[size]);
    	for(int i = 0; i < size; i++) {
    		elements[i] = currentNode.value;
    		currentNode = currentNode.next;
    	}
    	return elements;
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
    	Node currentNode = front;
    	while(currentNode.next != null) {
    		
    		currentNode = currentNode.next;
    		if(currentNode.value != null) {
    			E currentValue = (E) (mt.transformElement(currentNode.value));
    		
    			currentNode.value = currentValue;
    		}
    		
    	}
    }
    @Override
    public void chooseAll(MyChooser mc) {
    	Node currentNode = front;
    	while(currentNode.next != null) {
    		
    		if(currentNode.next.value == null) {
    			currentNode.next = currentNode.next.next;
    			size--;
    		}
    		else if(!(mc.chooseElement(currentNode.next.value))) {
    			currentNode.next = currentNode.next.next;
    			size--;
    			
    		}
    		else {
    		currentNode = currentNode.next;
    		}
    		if(currentNode == null) {
    			break;
    		}
    	}
    }
    	
   
    
    
    
    
    
}