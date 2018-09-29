# CS-2420
/******************************************************************************
 *  Name:    Ashton Chatelain

 *
 *  Partner Name:   Austin Duran  
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
 
 Randomized Queue is implemented with an array to store the elements. This allows
 constant time access to an element at random index, and constant time to move 
 the element at the end to the element that is randomly chosen that needs to be
 removed by the dequeue method.
 
 Deque is implemented with a linked list. Head(first) and tail(last) are stored in order to 
 give constant time access to add at head(first) or tail(last). When empty we set the last to first if
 addFirst is called, and vice versa for addLast. Since it is only required to remove and add from
 the head and tail, we thought that a linked list would be the best possible solution. Setting
 nodes at first and last help us to track where the Head is and where the Tail is. 


/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~28  bytes 

Each RandomizedQueue has two fields: int size = 4 bytes + T[] = 24 bytes An iterator also has a 24 byte array

Deque:              ~68  bytes

Each Deque has 68 bytes allocated. Deque has three fields: int k = 4 bytes, Node first = 8 bytes, Node last = 8 bytes. --Contained inside of Deque is a private non-static class "Node" which has 1 field: Node next = 8 bytes. We account for extra padding 8 bytes, we don't account for "Item" type.

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
 We received no help on this assignment.
 
	
/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
 We followed the protocol as described on the assignment page. We decided to split up
 our work by class. I(Austin Duran) worked mainly on the Deque.java class. (Ashton Chatelain)
 worked mainly on the RandomizedQueue.java class. However, we both helped the other one 
 out when we found ourselves stuck on implementing some parts of our classes. Especially with the testing of each class.



/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
 No serious problems were encountered.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
 
We met up to code in a group study room in the B.R.I.C. and had fun ironing out details and our bad code. 