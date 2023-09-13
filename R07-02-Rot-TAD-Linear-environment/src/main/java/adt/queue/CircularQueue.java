package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		 
		if (tail + 1 == array.length) {
			tail = 0;
			array[tail] = element;
			elements++;
		} else {
			tail++;
			array[tail] = element;
			elements++;
		}
	
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} 

		head++;
		T dequeued = array[head];
		array[head] = null;
		elements--;

		return dequeued;

	}

	@Override
	public T head() {
		T result = null;

		if (elements > 0 && head + 1 < array.length) {
			result = array[head + 1];
		} else if (elements > 0 && head + 1 == array.length) {
			result = array[0];
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
