package dataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<E extends Comparable<E>> implements PriQueueInterface<E> {

	/**
	 * I looked online to understand how to make java accept a generic array:
	 */
	private E[] elements;

	@SuppressWarnings("unchecked")
	public Heap(int size) {
		elements = (E[]) new Comparable[size];

	}

	public E[] toArray() {
		E[] result = Arrays.<E>copyOf(elements, elements.length);
		return result;
	}

	@Override
	public boolean isEmpty() {
		// if there is an element inside, return false
		for (@SuppressWarnings("unused")
		E elem : elements) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isFull() {
		int i = 0;
		for (E element : elements) {
			i++;
		}
		return i == elements.length;
	}

	@Override
	public void enqueue(E element) {

		recEnqeue(0, element);

	}

	/**
	 * Add an element to the Heap. 
	 * 
	 * @param index
	 * @param element
	 * @return
	 */
	private boolean recEnqeue(int index, E element) {
		if (index >= elements.length) {
			return false;
		
		}else if (elements[index] == null) {
			elements[index] = element;
			return true;
		
		} else {

			return recEnqeue(rightChild(index), element) || recEnqeue(leftChild(index), element);

		}

	}

	private int leftChild(int index) {
		return index * 2;
	}

	private int rightChild(int index) {
		return (2 * index) + 1;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

}
