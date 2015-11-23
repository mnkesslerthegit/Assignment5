package dataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Heap<E extends Comparable<E>> implements PriQueueInterface<E> {

	private ArrayList<E> myArray = new ArrayList<>();

	public String toString() {
		return myArray.toString();
	}

	public Object[] toArray() {
		return myArray.toArray();
	}

	public boolean contains(E element) {
		return myArray.contains(element);
	}

	/**
	 * I use an array list to simulate an array, because working with generic
	 * arrays in java is too hard.
	 * 
	 * @param initSize
	 */
	public Heap(int initSize) {
		for (int i = 0; i < initSize; i++) {
			myArray.add(null);
		}
	}

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < myArray.size(); i++){
			if(myArray.get(i)!= null){
				return false;
			}
		}
		return true;
		
	}

	@Override
	public void enqueue(E element) {
		System.out.println("Enqueing");
		if (!isFull()) {
			if (!recEnqeue(1, element)) {
				throw new IllegalArgumentException("Failed to enque when heap wasn't full");
			}
		}
		System.out.println(myArray);
		// printArray();
	}

	private void printArray() {
		System.out.println();
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println("I is: " + i + " value is: " + myArray.get(i));
		}
		System.out.println();
	}

	/**
	 * Add an element to the Heap.
	 * 
	 * @param index
	 * @param element
	 * @return
	 */
	private boolean recEnqeue(int index, E element) {
		if (index >= myArray.size()) {
			return false;
		} else {
			// System.out.println("Index is: " + index + " parent is: " +
			// parent(index));
			// System.out.println("Index value is: " + myArray.get(index)+ "
			// parent value is: " + myArray.get(parent(index)));

			// check for space, then balance.
			if (myArray.get(index) == null) {
				myArray.set(index, element);
				System.out.println("Storing " + element + " in " + index);
				balanceUp(index);

				return true;
			}
			// we don't try to access children of null parents
			return myArray.get(index) != null && recEnqeue(rightChild(index), element)
					|| recEnqeue(leftChild(index), element);

		}

	}

	private void balanceUp(int index) {
		// check if element is violating heap order
		if (myArray.get(index).compareTo(myArray.get(parent(index))) < 0) {
			// if it is, swap it with its parent
			swap(index, parent(index));
			// sift up
			balanceUp(parent(index));

		}
	}

	private void swap(int i1, int i2) {
		E temp = myArray.get(i2);
		myArray.set(i2, myArray.get(i1));
		myArray.set(i1, temp);
	}

	/**
	 * 
	 * @param index
	 */
	private void balanceDown(int index) {
		System.out.println(myArray);
		if(index == 0){
			return;
		}
		/**
		 * Check to see if the index has children. If it does, pick the one with the smaller value, and swap them. 
		 */
		if (hasLeft(index)) {
			if(!hasRight(index)){
				
			swap(index, leftChild(index));
			balanceDown(leftChild(index));
			}else{
				if(myArray.get(leftChild(index)).compareTo(myArray.get(rightChild(index))) < 1){
					swap(index, leftChild(index));
					balanceDown(leftChild(index));
				}else{
					swap(index, rightChild(index));
					balanceDown(rightChild(index));
				}
				
			}
		} else if (hasRight(index)) {
			swap(index, rightChild(index));
			balanceDown(rightChild(index));
		}
		


	}

	// if we are at index 1, consider the parent to be index 1
	private int parent(int index) {
		if (index <= 1) {
			return 1;
		} else {
			return index / 2;
		}

	}

	private boolean hasLeft(int index) {
		return leftChild(index) < myArray.size() && myArray.get(leftChild(index)) != null;
	}

	private boolean hasRight(int index) {
		return rightChild(index) < myArray.size() && myArray.get(rightChild(index)) != null;
	}

	private int leftChild(int index) {

		return index * 2;
	}

	private int rightChild(int index) {

		return (2 * index) + 1;
	}

	@Override
	public E dequeue() {
		System.out.println("Deque begins:\n");
		if (myArray.isEmpty()) {
			throw new IndexOutOfBoundsException("Can't deque from empty heap");
		}
		E temp = myArray.get(1);
		// myArray.set(0 Comparable<>);
		myArray.set(1, null);
		balanceDown(1);
		return temp;
	}

	@Override
	public boolean isFull() {
		for (int i = 1; i < myArray.size(); i++) {
			if (myArray.get(i) == null) {
				return false;
			}
		}
		return true;
	}

}
