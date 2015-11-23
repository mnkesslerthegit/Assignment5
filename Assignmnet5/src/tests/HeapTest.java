package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataStructures.Heap;

public class HeapTest {
	

	private int leftChild(int index){
		return index * 2;
	}
	
	private int rightChild(int index){
		return (2 * index) + 1; 
	}
	

	private <T extends Comparable<T>> boolean testHeightRelation(T upper, T lower ){
		
		return upper.compareTo(lower) == 1;
		
	}
	Heap<String> myHeap;
	String[] myArray;
	private int heapSize = 11;
	
	@Before
	public void setUp(){
		myHeap = new Heap<>(heapSize );
		/**
		 * Add strings to the heap
		 */
		for(int i = 0; i < heapSize; i++){
			myHeap.enqueue("" + (char) 65 + i );
		}
		System.out.print(myHeap.toArray());
		myArray =  myHeap.toArray();
		
	}
	
	@Test
	public void testHeapOrder() {
		for(int i = 0; i < myArray.length; i++){
			int left = leftChild(i);
			int right = rightChild(i);
			if(testHeightRelation(myArray[i], myArray[left])
					&& testHeightRelation(myArray[i], myArray[right])){
				
			}else{
				fail("Heap order violated at index" + i + "element " + myArray[i]);
			}
			
			
		}
	}
	
	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFull() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDequeue() {
		fail("Not yet implemented");
	}

}
