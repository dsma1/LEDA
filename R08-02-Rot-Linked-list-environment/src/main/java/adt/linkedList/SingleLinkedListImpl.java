package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> auxLinkedList = getHead();
		int contadorSize = 0;

		while (!auxLinkedList.isNIL()) {
			auxLinkedList = auxLinkedList.getNext();
			contadorSize++;
		}

		return contadorSize;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxLinkedList = getHead();

		while (!auxLinkedList.getData().equals(element)) {
			auxLinkedList = auxLinkedList.getNext();
		}

		return auxLinkedList.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = getHead();

		while (!auxHead.isNIL()) {
			auxHead.getNext();
		}

		auxHead = new SingleLinkedListNode(element, new SingleLinkedListNode());
		setHead(auxHead);
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> auxLinkedList = getHead();

		while (!auxLinkedList.getData().equals(element)) {
			auxLinkedList = auxLinkedList.getNext();
		}

		if (!auxLinkedList.isNIL()) {
			auxLinkedList.setData(auxLinkedList.getNext().getData());
			auxLinkedList.setNext(auxLinkedList.getNext().getNext());
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[size()];
		SingleLinkedListNode<T> auxLinkedList = getHead();

		for (int i = 0; i < this.size(); i++) {
			result[i] = auxLinkedList.getData();
			auxLinkedList = auxLinkedList.getNext();
		}

		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
