package rand_que_deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{

	private int k;
	private Node first;
	private Node last;

	// helper linked list class
	private class Node
	{
		private Item item;
		private Node next;
	}

	/**
	 * construct an empty deque
	 */
	public Deque()
	{
		first = null;
		last = null;
		k = 0;
	}

	/**
	 * is the deque empty?
	 */
	public boolean isEmpty()
	{
		return first == null && last == null;

	}

	/**
	 * return the number of items on the deque
	 */
	public int size()
	{
		return k;
	}

	/**
	 * insert the item at the front
	 */
	public void addFirst(Item item)
	{
		if (item == null)
		{
			throw new NullPointerException("Item added cannot be empty");
		}

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		if (size() == 0)
		{
			last = first;
		}
		first.next = oldfirst;
		k++;
	}

	/**
	 * insert the item at the end
	 */
	public void addLast(Item item)
	{
		if (item == null)
		{
			throw new NullPointerException("Item added cannot be empty");
		}

		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (size() == 0)
		{
			first = last;
		}

		// Perhaps a counter to count how many Deque objects are created?
		// Something to reach the end of the linked list-1 last = oldLast
		// Consider looking at LinkedList implementation for Queue? Possibly Stack?
		last.next = oldlast;
		k++;
	}

	/**
	 * delete and return the item at the front
	 */
	public Item removeFirst()
	{
		if (isEmpty() == true)
		{
			throw new NoSuchElementException("List is empty");
		}

		Item item = first.item; // save item to return
		first = first.next; // delete first node
		k--;
		if (size() == 0)
		{
			first = null;
			last = null;
		}
		return item;
	}

	/**
	 * delete and return the item at the end
	 */
	public Item removeLast()
	{
		if (isEmpty() == true)
		{
			throw new NoSuchElementException("List is empty");
		}

		Item item = last.item; // save item to return
		last = last.next; // delete first node
		k--;
		if (size() == 0)
		{
			first = null;
			last = null;
		}
		return item;
	}

	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<Item>
	{

		private Node current = first;

		public boolean hasNext()
		{
			return current != null;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Item next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args)
	{
		// Creating a deque object(linked-list)
		Deque deque = new Deque();
		// Iterator for deque
		Iterator<String> iter = deque.iterator();
		// hasNext test for iterator should be false
		assert iter.hasNext() == false;
		// Testing if deque is empty before adding elements - should be "true" due to
		// deque of length 0
		assert deque.isEmpty() == true;
		// Add elements to deque
		deque.addFirst("Hello");
		// Check if empty - should be "false" due to adding "Hello"
		assert deque.isEmpty() == false;
		// Check if "Hello" exists by removeFirst
		assert deque.removeFirst() == "Hello";
		// Check if empty - should be "true" due to removing "Hello"
		assert deque.isEmpty() == true;
		// Add more than one element
		deque.addFirst("World");
		deque.addFirst("Cat");
		// Testing iteration of deque elements
		Iterator<String> iterTwo = deque.iterator();
		// hasNext test for iterator should be true
		assert iterTwo.hasNext() == true;
		assert iterTwo.next() == "Cat";
		assert iterTwo.next() == "World";
		// Check size - should be 2 due to "World" and "Cat"
		assert deque.size() == 2;
		// Check if removeLast "World" is removed since it was added last
		assert deque.removeLast() == "World"; // Needs fixing
		// Check size again - should be 1 after removeLast
		assert deque.size() == 1;
		// Check if addLast makes "World" the oldLast and "Java" the newLast
		deque.addLast("Java"); // Only works because I'm adding a last "Java" therefore I can remove it
		assert deque.removeLast() == "Java";
		System.out.println("TESTS ARE DONE!");
	}

}
