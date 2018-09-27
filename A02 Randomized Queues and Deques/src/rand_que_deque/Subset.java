package rand_que_deque;

import edu.princeton.cs.algs4.StdIn;

public class Subset
{

	public static void main(String[] args)
	{
		/*
		 * 
		 * REQUIRED CODE FOR RandomizedQueue
		 * 
		 * 
		 */

		// ask StdIn to read an int
		int k = StdIn.readInt();
		RandomizedQueue<String> rq = new RandomizedQueue<String>(k);

		// enqueue k Strings from StdIn

		for (int i = 0; i < k; i++)
		{
			rq.enqueue(StdIn.readString());

		}
		// randomly dequeue all the strings.
		for (int i = 0; i < k; i++)
		{
			System.out.println(rq.dequeue());
		}

	}

}
