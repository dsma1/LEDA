package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!stack2.isEmpty()) {
			swapStackValues(stack2, stack1);
		}
		
		try {
			stack1.push(element);
		} catch (StackOverflowException e)  {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		swapStackValues(stack1, stack2);
		T result = stack2.top();

		try {
			stack2.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		}

		return result;
	}

	@Override
	public T head() {
		swapStackValues(stack1, stack2);
		T result = stack2.top();

		return result;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull() || stack2.isFull();
	}
	
	private void swapStackValues(Stack<T> firstStack, Stack<T> secondStack) {
		while(!firstStack.isEmpty()) {
			try {
				secondStack.push(firstStack.pop());
			} catch (StackUnderflowException | StackOverflowException e) {}
		}
	}
	
}
