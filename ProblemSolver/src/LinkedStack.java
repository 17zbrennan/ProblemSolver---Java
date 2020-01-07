
public class SinglyStack <E extends Comparable<E>> {
	private LinkedList<E> stack;

	public SinglyStack() {
		stack = new LinkedList();
	}
	
	
	public int size() {
		return stack.size();
	}

	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	
	public void push(Object e) {
		stack.insertFirst((E)e);
	}

	
	public Object top() {
		return stack.getFirst();
	}

	
	public Object pop() {
		return stack.removeFirst();
	}

	
	public String toString() {
		return "SinglyStack [stack=" + stack + "]";
	}
	

}
