package com.bl.hashTable;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int numBuckets;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);
		// Create Empty Buckets LinkedList
		for (int i = 0; i < numBuckets; i++)
			this.myBucketArray.add(null);
	}

	// This Implements Hash function is find index for a key
	private int getBucketIndex(K key) {
		int indexHashCode = Math.abs(key.hashCode());
		int index = indexHashCode % numBuckets;
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myList = this.myBucketArray.get(index);
		if (myList == null)
			return null;
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public void delete(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		myLinkedList.delete(key);
		myBucketArray.remove(index);
	}

	@Override
	public String toString() {
		return "MyHashMapNodes{" + myBucketArray + '}';
	}
}
