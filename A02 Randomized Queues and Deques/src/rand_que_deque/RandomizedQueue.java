package rand_que_deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<T> implements Iterable<T>
{
	private int size;
	private T[] array;

	@SuppressWarnings("unchecked")
	public RandomizedQueue(int size)
	{
		this.size = 0;
		array = (T[]) new Object[10];

	}

	@SuppressWarnings("unchecked")
	public void enqueue(T item)
	{
		if (item == null)
		{
			throw new NullPointerException();
		}

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

		array[this.size] = item;
		this.size++;

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

		// TODO resize array if it is too small.

		return temp;

	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator()
	{
		@SuppressWarnings("unchecked")
		final T[] tempArray = (T[]) new Object[this.size];

		for (int i = 0; i < this.size; i++)
		{
			tempArray[i] = this.array[i];

		}

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
		return (T) array[StdRandom.uniform(0, this.array.length - 1)];
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

		assert rq.iterator().getClass() == Iterator.class;
		assert rq.iterator().hasNext() == false;

		try
		{
			rq.remove();
		} catch (UnsupportedOperationException e)
		{
			assert e.getClass() == UnsupportedOperationException.class;
			System.out.println("caught remove exception");
		}
		try
		{
			rq.iterator().next();

		} catch (NoSuchElementException e)
		{
			assert e.getClass() == NoSuchElementException.class;
			System.out.println("caught no such element exception");
		}

		// TODO test exceptions
		System.out.println("tests done");

	}

}
