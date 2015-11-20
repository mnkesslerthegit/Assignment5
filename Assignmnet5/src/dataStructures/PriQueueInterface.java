package dataStructures;
public interface PriQueueInterface<T extends Comparable<T>>

{

	boolean isEmpty();

	// Returns true if this priority queue is empty, false otherwise.

	boolean isFull();

	// Returns true if this priority queue is full, false otherwise.

	void enqueue(T element);

	// Throws PriQOverflowException if this priority queue is full;

	// otherwise, adds element to this priority queue.

	T dequeue();

	// Throws PriQUnderflowException if this priority queue is empty;

	// otherwise, removes element with highest priority from this

	// priority queue and returns it.

}