package adt.hashtable.open;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

			while (!(this.table[hash] == null || this.table[hash].equals(deletedElement) || this.isFull())) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
				this.COLLISIONS++;
			}
			
			this.table[hash] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

			while (!this.table[hash].equals(element)) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
			}

			this.table[hash] = new DELETED();
			this.elements--;
			if (probe != 0) {this.COLLISIONS--;}
		}
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

			while (this.table[hash] != element || this.table[hash] != null) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
			}

			if (this.table[hash] != null) {
				result = element;
			}
		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);

			while (this.table[hash] != element || this.table[hash] != null) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, ++probe);
			}

			if (this.table[hash] != null) {
				index = hash;
			}
		}

		return index;
	}

}
