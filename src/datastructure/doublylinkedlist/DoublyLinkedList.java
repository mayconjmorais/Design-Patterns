package datastructure.doublylinkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedList<R> implements List<R> {

	private Node<R> head;
	private Node<R> tail;
	private int size; // length of LinkedList

	/**
	 * Method to informs how many elements are inside the LinkedList
	 * 
	 * @return the size of LinkedList
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Method responsible to clear LinkedList
	 */
	public void clear() {
		tail = head = null;
		size = 0;
	}

	/**
	 * Method responsible to check if object informed it's found inside LinkedList
	 * 
	 * @param o: Element that should be searched inside the LinkedList
	 * @return: True if it's found
	 */
	public boolean contains(Object o) {

		for (Node<R> n = head; n != null; n = n.getNext()) {
			if (n.getData().equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to include a node in the LinkedList
	 * 
	 * @param e: represents the element to be appended to this list
	 * @return:
	 */
	public boolean add(R e) {
		Node<R> ln = new Node<R>(e);

		if (isEmpty()) {
			head = ln;
		} else {
			tail.setNext(ln);
		}

		ln.setPrev(head);
		tail = ln;
		size++;

		return true;
	}

	/**
	 * Method responsible to removes the element at the specified position in this
	 * list
	 * 
	 * @param index: the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	public R remove(int index) {

		if (isEmpty() || (index < 0 || index > size()))
			throw new IndexOutOfBoundsException();

		Node<R> temp = new Node<R>(head.getData());

		if (index == 0) {
			if (size() == 1) {
				clear();
			} else {
				temp = head;
				head = head.getNext();
				head.setPrev(null);
				size--;
			}
		} else {
			temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			size--;
		}

		return (getNodeBefore(index) == null ? null : getNodeBefore(index).getData());
	}

	/**
	 * Method to include a node in the LinkedList
	 * 
	 * @param index:   position where the node should be included
	 * @param element: represents the element to be appended to this list
	 */
	public void add(int index, R element) {
		Node<R> temp = new Node<R>(element);

		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		if (isEmpty()) {
			head = tail = temp;
		} else if (index == 0) {
			temp.setNext(head);
			head = temp;
		} else if (index == size) {
			tail.setNext(temp);
			tail = temp;
		} else {
			Node<R> current = getNodeBefore(index);
			temp.setNext(current.getNext());
			current.setNext(temp);
		}
		size++;
	}

	/**
	 * Method to return previous node indicate for index
	 * 
	 * @param index position where previous node should be returned
	 * @return position index - 1 from list (previous node indicated by index)
	 */
	private Node<R> getNodeBefore(int index) {

		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		if (index == 0)
			return null;
		if (index == 1)
			return head;
		int counter = 2;

		for (Node<R> n = head.getNext(); n != null; n = n.getNext()) {
			if (counter == index)
				return n;
			counter++;
		}
		return null;
	}

	/**
	 * Method responsible to replaces the element at the specified position in this
	 * list with the specified element.
	 * 
	 * @param index   of the element to replace
	 * @param element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	public R set(int index, R element) {
		if (isEmpty() || (index < 0 || index > size()))
			throw new IndexOutOfBoundsException();

		Node<R> temp = new Node<R>(element);

		int counter = 0;

		if (index == 0) {
			temp.setNext(head.getNext());
			head = temp;
		} else {
			Node<R> current = getNodeBefore(index);
			for (Node<R> n = head; n != null; n = n.getNext()) {
				if (counter == index) {
					n = temp;
					n.setNext(current.getNext().getNext());
					current.setNext(n);
				}
				counter++;
			}
		}
		return (getNodeBefore(index) == null ? null : getNodeBefore(index).getData());
	}

	/**
	 * 
	 * @return true if no elements found inside the list.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to print list for user
	 */
	public String toString() {
		StringBuilder b = new StringBuilder("[ ");
		String delimiter = "";
		for (Node<R> n = head; n != null; n = n.getNext()) {
			b.append(delimiter).append(n.getData());
			delimiter = ", ";
		}
		return b.append(" ]").toString();
	}

	@Override
	public Iterator<R> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends R> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends R> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public R get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<R> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<R> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<R> subList(int fromIndex, int toIndex) {
		
		if (fromIndex < 0 || toIndex > size())
			throw new IndexOutOfBoundsException();
		
		if (fromIndex > toIndex)
			throw new IllegalArgumentException();
		
		List<R> sub = new ArrayList<R>();
		
		if (fromIndex == toIndex) {return sub;}
		
		int i = 0;
		for (Node<R> n = head; n != null; n = n.getNext()) {
			if (i == fromIndex) {
				for (int j = i; j < toIndex; j++) {
					sub.add(n.getData());
					n = n.getNext();
				}
				//return sub;
			}
			i++;
		}
		return sub;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = 0, i = 0;
		for (Node<R> n = head; n != null; n = n.getNext()) {
			i++;
			if (n.getData().equals(o)) {
				index = i;
			}
		}
		return (index == 0 ? -1 : index - 1);
	}

//class Node<R>
	private class Node<E> {
		private E data;
		private Node<E> next, prev;

		public Node(E data) {
			this.data = data;
		}

		public Node(Node<E> next, Node<E> previous) {
			this.next = next;
			this.prev = previous;
		}

		public Node(E data, Node<E> next, Node<E> previous) {
			this.data = data;
			this.next = next;
			this.prev = previous;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public E getData() {
			return data;
		}
	}

	private class DLLIterator implements Iterator<R> {

		private DLLIterator() {
			
		}
		
		private Node<R> current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public R next() {
			R iter = current.getData();
			current = current.getNext();
			return iter;
		}
	}
}