package rand_que_deque;

import edu.princeton.cs.algs4.StdIn;

public class Subset
{

	public static void main(String[] args)
	{
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter a number");
		// int k = scanner.nextInt();
		// System.out.println("your number is " + k + "");
		// String string = StdIn.readString();

		// Creating a deque object(linked-list)
		Deque deque = new Deque();
		deque.addFirst("Hello");
		deque.addLast("World");

		// deque.removeFirst();

		// Printing size of the linked list. this is correct
		System.out.println(deque.size() + "");

		// Printing removeFirst which ideally should remove "Hello" because it was added
		// first
		// However, it's printing "World". Therefore the implementation of
		// "deque.addFirst" or
		// deque.removeFirst could be incorrect. TODO: Work on this!
		System.out.println(deque.removeFirst());

		// Printing removeLast which ideally should remove "World" because it was added
		// last.
		// this is correct
		// System.out.println(deque.removeLast());

		// addLast should add an element to the end of the deque instead of at front.
		// Should print "kitten" as it is added to the end of the list
		// deque.addLast("Kitten");
		// System.out.println(deque.removeLast());

		// while (deque.iterator().hasNext())
		// {
		// System.out.println(deque.iterator().next());
		// }

		System.out.println(deque.isEmpty());

		/*
		 * 
		 * REQUIRED CODE FOR RandomizedQueue
		 * 
		 * 
		 */
		int k = StdIn.readInt();
		RandomizedQueue<String> rq = new RandomizedQueue<String>(k);

		for (int i = 0; i < k; i++)
		{
			rq.enqueue(StdIn.readString());

		}
		for (int i = 0; i < k; i++)
		{
			System.out.println(rq.dequeue());
		}

	}

}
