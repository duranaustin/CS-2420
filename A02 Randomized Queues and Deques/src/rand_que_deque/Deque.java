package rand_que_deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.soap.Node;


public class Deque<Item> implements Iterable<Item> {
	
	private int k;
	private Node first;
	private Node last;
	
	
    // helper linked list class
    private class Node {
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
		   return first == null;
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
	       //Perhaps a counter to count how many Deque objects are created?
	       //Something to reach the end of the linked list-1 last = oldLast
	       //Consider looking at LinkedList implementation for Queue? Possibly Stack?
	       last.next = oldlast;
	       k++;
	   }  
	   
	   /**
	    * delete and return the item at the front
	    */
	   public Item removeFirst()  
	   {
		   if(isEmpty() == true) 
		   {
			   throw new NoSuchElementException("List is empty");
		   }
		   
	        Item item = first.item;        // save item to return
	        first = first.next;            // delete first node
	        k--;
	        return item; 
	   }             
	   
	   
	   /**
	    * delete and return the item at the end
	    */
	   public Item removeLast() 
	   {
		   if(isEmpty() == true) 
		   {
			   throw new NoSuchElementException("List is empty");
		   }
		   
	        Item item = last.item;        // save item to return
	        last = last.next;            // delete first node
	        k--;
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
	    private class ListIterator implements Iterator<Item> {
	        private Node current = first;
	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
