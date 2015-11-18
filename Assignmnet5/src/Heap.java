import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<E extends Comparable<E>> implements PriQueueInterface<E> {

	/**
	 * I looked online to understand how to make java accept a generic array:
	 */
	private E[] elements;

	public Heap(Class<E> c, int size) {
		@SuppressWarnings("unchecked")
		final E[] elements = (E[]) Array.newInstance(c, size);
		this.elements = elements;
	}

	@Override
	public boolean isEmpty() {
		//if there is an element inside, return false
		for(@SuppressWarnings("unused") E elem : elements){
			return false;
		}
		return true;
	}

	@Override
	public boolean isFull() {
		int i = 0;
		for(E element : elements){
			i++;
		}
		return i == elements.length;
	}

	@Override
	public void enqueue(E element) {
	
		
			recEnqeue(0, element);
		

	}
	
	private boolean recEnqeue(int index, E element){

		if(elements[index] == null){
			elements[index] = element;
			return true;
		}else{
		return recEnqeue(rightChild(index), element) 
				|| recEnqeue(leftChild(index), element);
		
		}
		
	}
	
	private int leftChild(int index){
		return index * 2;
	}
	
	private int rightChild(int index){
		return (2 * index) + 1; 
	}
	
	
	

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

}
