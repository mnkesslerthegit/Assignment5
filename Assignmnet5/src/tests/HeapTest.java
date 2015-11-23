package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataStructures.Heap;

public class HeapTest {

	private int leftChild(int index) {
		// index++;
		return index * 2;
	}

	private int rightChild(int index) {
		// index++;
		return (2 * index) + 1;
	}

	Heap<String> myHeap;
	String[] myArray;
	private int heapSize = 10;

	@Before
	public void setUp() {
		myHeap = new Heap<>(heapSize);
		myArray = new String[heapSize];

		/**
		 * Add some strings to the heap
		 */
		for (int i = 0; i < heapSize / 2; i++) {

			myHeap.enqueue("" + (char) (65 + i));
		}

	}

	/**
	 * I test heapOrder after every test.
	 */
	@After
	public void tearDown() {

		// setRegularArray();
		testHeapOrder();

		myHeap = null;
	}

	private void setRegularArray() {
		myArray = new String[heapSize];

		Object[] temp = myHeap.toArray();
		// System.out.println("temp is: " + temp);
		if (!myHeap.isEmpty()) {
			for (int i = 0; i < heapSize; i++) {
				if (temp[i] != null) {
					// System.out.println("got here: " + temp[i]);
					myArray[i] = (String) temp[i];
				} else {
					myArray[i] = null;
				}
			}
		}
	}

	private <T extends Comparable<T>> boolean testHeightRelation(T upper, T lower) {

		System.out.println("upper: " + upper + " lower: " + lower);
		System.out.println(upper.compareTo(lower));

		return upper.compareTo(lower) > 0;

	}

	private void testHeapOrder() {
		setRegularArray();
		System.out.println("\n");
		System.out.println("Heap order test");
		for (int i = 1; i < myArray.length; i++) {
			int left = leftChild(i);
			int right = rightChild(i);
			System.out.println("HeapOrder reached " + i + ", element: " + myArray[i]);

			// check for a null parent
			if (left < myArray.length && myArray[left] != null) {
				if (myArray[i] == null) {
					fail("null parent at index" + i + " where left child is " + myArray[left]);
				}
			}

			if (right < myArray.length && myArray[right] != null) {
				if (myArray[i] == null) {
					fail("null parent at index" + i + " where right child is " + myArray[right]);
				}
			}

			if (myArray[i] == null) {
				continue;
			}
			// System.out.println("left is: " + left);
			// System.out.print("Array length is: " + myArray.length);

			// check for a smaller parent
			if (left < myArray.length) {
				if (myArray[left] != null && testHeightRelation(myArray[i], myArray[left])) {

					fail("Heap order violated at index" + i + " element " + myArray[i] + "\n" + "at left child, index"
							+ left + " element " + myArray[left]);
				}
			}
			if (right < myArray.length) {
				if (myArray[right] != null && testHeightRelation(myArray[i], myArray[right])) {

					fail("Heap order violated at index" + i + " element " + myArray[i] + "\n" + "at right child, index"
							+ right + "element" + myArray[right]);
				}
			}

		}
	}

	@Test
	public void testIsEmpty() {
		for (int i = 0; i < heapSize * 2; i++) {

			myHeap.dequeue();
		}
		Assert.assertEquals(true, myHeap.isEmpty());
	}

	@Test
	public void testIsFull() {
		for (int i = 0; i < heapSize * 2; i++) {

			myHeap.enqueue("" + (char) (65 + randy.nextInt(30)));
		}
		Assert.assertEquals(true, myHeap.isFull());
	}

	Random randy = new Random();

	@Test
	public void testEnqueue() {

		myHeap.enqueue("Need");
		for (int i = 0; i < heapSize * 2; i++) {

			myHeap.enqueue("" + (char) (65 + randy.nextInt(30)));
		}
		Assert.assertEquals(true, (myHeap.contains("Need"))); // testIsFull();

	}

	@Test
	public void testDequeue() {
		String testString = "Need";
		myHeap.enqueue(testString);
		for (int i = 0; i < heapSize * 3; i++) {
			try {
				myHeap.dequeue();
			} catch (IndexOutOfBoundsException e) {

			}
			testHeapOrder();
		}

		Assert.assertEquals(false, (myHeap.contains(testString)));
		Assert.assertEquals(true, (myHeap.isEmpty()));

		myHeap.enqueue(testString);
		Assert.assertEquals(true, (myHeap.contains(testString)));
		// System.out.print(myHeap);
		// String result = myHeap.dequeue();
		Assert.assertTrue(myHeap.dequeue().equals(testString));
		Assert.assertEquals(false, (myHeap.contains(testString)));

	}

}
