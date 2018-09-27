package rand_que_deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class RandomizedQueue<T> implements Iterable<T>
{
	private int size;
	private T[] array;

	public RandomizedQueue(int size)
	{
		this.size = 0;
		array = (T[]) new Object[2];

	}

	public void enqueue(T item)
	{
		if (item == null)
		{
			throw new NullPointerException();
		}

		array[this.size] = item;
		this.size++;
		// TODO refactor resizing array into new method
		if (this.array.length == this.size)
		{
			T[] tempArray = (T[]) new Object[this.array.length * 2];
			for (int i = 0; i < this.array.length; i++)
			{
				tempArray[i] = this.array[i];
			}
			this.array = tempArray;
		}

	}

	public T dequeue()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}

		int index = StdRandom.uniform(0, this.size);
		T temp = array[index];

		// move the last item into the now 'empty' index
		array[index] = array[this.size - 1];
		// null the last item
		array[this.size - 1] = null;
		size--;

		// resize array if it is too small.
		if (size <= array.length / 4)
		{
			T[] tempArray = (T[]) new Object[size * 2];
			for (int i = 0; i < size(); i++)
			{
				tempArray[i] = array[i];
			}
			array = tempArray;
		}

		return temp;

	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator()
	{
		final T[] tempArray = (T[]) new Object[this.size];

		for (int i = 0; i < this.size; i++)
		{
			tempArray[i] = this.array[i];

		}
		StdRandom.shuffle(tempArray);

		return new Iterator<T>()
		{

			int index = 0;

			@Override
			public boolean hasNext()
			{
				return index < tempArray.length;
			}

			@Override
			public T next()
			{
				if (hasNext())
				{
					T value = tempArray[index];
					index++;
					return value;
				}
				throw new NoSuchElementException("No more ");
			}

			@Override
			public void remove()
			{
				throw new UnsupportedOperationException("Remove is not supported");
			}
		};
	}

	public T sample()
	{
		if (this.size() == 1)
		{
			return array[0];
		}
		return array[StdRandom.uniform(0, this.array.length - 1)];
	}

	public void remove()
	{
		throw new UnsupportedOperationException("method remove is not supported");
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int size()
	{
		return size;
	}

	/**
	 * Private method for testing resizing of array
	 */
	private int length()
	{
		return array.length;
	}

	/*
	 * 
	 * 
	 * 
	 * +++++++++++++++++++++TEST CLIENT+++++++++++++++++++++++++++++
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args)
	{
		// create RandomizedQueue size 2 test empty and size
		RandomizedQueue<String> rq = new RandomizedQueue<String>(2);
		assert rq.isEmpty() == true;
		assert rq.size() == 0;

		// test enqueue and size and sample
		rq.enqueue("a");
		assert rq.size() == 1;
		assert rq.sample().equals("a");

		// test dequeue size and empty
		assert rq.dequeue().equals("a");
		assert rq.size() == 0;
		assert rq.isEmpty() == true;

		Iterator<String> iter = rq.iterator();
		assert iter.hasNext() == false;

		// catch unsupported operation for remove
		// try
		// {
		// iter.remove();
		// } catch (UnsupportedOperationException e)
		// {
		// System.out.println("caught remove exception\n");
		// }
		//
		// // Test iterator next on no next
		// try
		// {
		// iter.next();
		//
		// } catch (NoSuchElementException e)
		// {
		// System.out.println("caught no such element exception\n");
		// }

		// Test resizing arrays
		RandomizedQueue<String> rqSize = new RandomizedQueue<String>(2);

		assert rqSize.length() == 2;
		rqSize.enqueue("a");
		rqSize.enqueue("b");
		rqSize.enqueue("c");
		assert rqSize.length() == 4;
		rqSize.enqueue("d");
		assert rqSize.length() == 8;
		rqSize.enqueue("e");
		rqSize.enqueue("f");
		rqSize.enqueue("g");
		rqSize.enqueue("h");
		assert rqSize.length() == 16;
		assert (rqSize.size() == 8);

		rqSize.dequeue();
		rqSize.dequeue();
		rqSize.dequeue();
		rqSize.dequeue();

		assert rqSize.length() == 8;
		rqSize.dequeue();
		rqSize.dequeue();
		assert rqSize.size() == 2;
		Iterator<String> iterTwo = rqSize.iterator();
		Iterator<String> iterThree = rqSize.iterator();
		assert rqSize.length() == 4;

		System.out.println("print iterTwo next " + iterTwo.next());
		System.out.println("print iterThree next " + iterThree.next());
		System.out.println("print iterThree next " + iterThree.next());
		System.out.println("print iterTwo next " + iterTwo.next());

		System.out.println("tests done");

	}

}
