package com.bl.hashTable;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public INode<K> search(K key) {
		INode<K> myNode = head;
		while (myNode != null && myNode.getNext() != null) {
			if (myNode.getKey().equals(key)) {
				return myNode;
			}
			myNode = myNode.getNext();
		}
		return null;
	}

	public INode delete(K key) {
		INode<K> myNode = head;
		INode<K> previous = null;
		while (myNode != null && myNode.getNext() != null) {
			previous = myNode;
			if (myNode.getKey().equals(key)) {
				previous.setNext(myNode.getNext());
			}
			myNode = myNode.getNext();
		}
		return myNode;
	}

	public void append(INode<K> currentNode) {
		if (this.tail == null)
			this.tail = currentNode;
		if (this.head == null) {
			this.head = currentNode;
		} else {
			this.tail.setNext(currentNode);
			this.tail = currentNode;
		}
	}

	@Override
	public String toString() {
		return "\nMyLinkedList [\nhead = " + head + ",\ntail = " + tail + "]";
	}
}
