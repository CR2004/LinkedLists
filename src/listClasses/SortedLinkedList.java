package listClasses;

import java.util.*;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator=comparator;
	}
	public BasicLinkedList<T> addToEnd(T data) {
	    throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	public BasicLinkedList<T> addToFront(T data) {
	    throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	public SortedLinkedList<T> add​(T element) {
		Node curr = head;
		if (curr == null) {
			Node newNode = new Node(element);
			head = newNode;
			listSize++;
		} else {
			boolean flag=false;
			Node newNode = new Node(element);
			while (curr.next != null) {
				if (comparator.compare(element,curr.data)>=0 && comparator.compare(element,curr.next.data)<0 ){
					newNode.next = curr.next;
					curr.next = newNode;
					listSize++;
					flag=true;
					break;
				} 
				curr=curr.next;
			}
			if(flag==false) {
				if (comparator.compare(element, curr.data)>0){
					newNode.next = curr.next;
					curr.next = newNode;
					listSize++;
				}
				else {
					newNode.next = head;
					head = newNode;
					listSize++;
				}
			}
		}
		return this;
	}
	public SortedLinkedList<T> remove​(T targetData){
		super.remove​(targetData, comparator);
		return this;
	}

}