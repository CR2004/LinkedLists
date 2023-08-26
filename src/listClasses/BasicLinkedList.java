package listClasses;

import java.util.*;

//import MyLinkedList.myLinkedList.Node;

//import MyLinkedList.MyLinkedList.Node;


public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	public BasicLinkedList() {
		this.head=null;
		this.tail=null;
		this.listSize=0;
	}
	public int getSize() {
		return listSize;
	}
	public BasicLinkedList<T> addToEnd​(T data){
		Node newNode=new Node(data);
		if(head==null && tail==null) {
			newNode.next=head;
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=newNode;
			newNode.next=null;
		}
		listSize++;
		return this;
		
	}
	public BasicLinkedList<T> addToFront​(T data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		listSize++;
		return this;
	}
	public T getFirst() {
		if(head==null) {
			return null;
		}
		return head.data;
	}
	public T getLast() {
		if(tail==null) {
			return null;
		}
		return tail.data;
	}
	public T retrieveFirstElement() {
		if(listSize==0) {
			return null;
		}
		T element=head.data;
		head=head.next;
		listSize--;
		return element;
	}
	public T retrieveLastElement() {
		Node curr=head;
		Node prev = null;
		if(listSize==0) {
			return null;
		}
		T element=tail.data;
		while(curr.next!=null) {
			if(curr.next==tail) {
				prev=curr;
			}
			curr=curr.next;
		}
		tail=prev;
		tail.next=null;
		listSize--;
		return element;
	}
	public BasicLinkedList<T> remove​(T targetData,Comparator<T> comparator){
		  Node curr = head, prev = null;
		  
	        while (curr != null && curr.data == targetData) 
	        {
	            head = curr.next; 
	            curr = head; 
	        }
	  
	       
	        while (curr != null) 
	        {
	            while (curr != null && curr.data != targetData) 
	            {
	                prev = curr;
	                curr = curr.next;
	            }
	  
	            if (curr == null)
	                return null;
	  
	            
	            prev.next = curr.next;
	  
	            
	            curr = prev.next;
	        }
	        return this;
	}
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			Node curr=head;
			
			@Override
			public boolean hasNext() {
				return curr!=null;
			}
			@Override
            public T next() {
                if (hasNext()) {
                    T result = curr.data;
                    curr = curr.next;
                    return result;
                }
                return null;
            }
			@Override
			public void remove() {
				Node prev=head;
				if(prev.next==null) {
					head=null;
					listSize--;
				}
				while(prev.next!=null) {
					if(prev.next==curr) {
						prev.next=curr.next;
						listSize--;
						break;
					}
				}
			}
		};
	}
	public ArrayList<T> getReverseArrayList(){
		ArrayList<T> arr1=new ArrayList<T>();
		ArrayList<T> arr2=new ArrayList<T>();
		Node curr=head;
		while(curr!=null) {
			arr1.add(curr.data);
			curr=curr.next;
		}
		getResult(arr1,arr2);
		return arr2;
	}
	/*
	private void getResult(Node curr,ArrayList<T> arr1) {
		if(curr==null) {
			return;
		}
		getResult(curr.next,arr1);
		arr1.add(curr.data);
	}*/
	private  void getResult(ArrayList<T> list,ArrayList<T> list2) {
		if (list.size() < 1) {
			return;
		}
		list2.add(list.get(list.size() - 1));
		list.remove(list.size()-1);
		getResult(list,list2);
	}
	public BasicLinkedList<T> getReverseList(){
		if(head==null) {
			return null;
		}
		head=getReverse(head);
		return this;
	}
	private Node getReverse(Node node){
		Node newHead;
		if((node.next == null)){
	           return node;
	    }
		newHead = getReverse(node.next);
		node.next.next = node;
	    node.next = null;
	    return newHead;
	}
	public String toString() {
		String result = "\" ";
		Node curr = head;

		while (curr != null) {
			result += curr.data + " ";

			curr = curr.next;
		}

		return result + "\"";
	}
	
}