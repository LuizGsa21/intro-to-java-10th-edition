package test.stacks.queues;

public class TestInventoryStackQueue {

	public static void main(String[] args) {
		// Create a stack
		InventoryStack<Inventory> stack = new InventoryStack();
		//System.out.println("Creating an Inventory Stack Implementation " + stack.toString());
		
		
		// Add elements to the stack
		Inventory gotDVDSeason1 = new Inventory("Season 1", 29.99, 56, 5); //Create the first inventory
		stack.push(gotDVDSeason1); // Push it to the stack
		System.out.println("(1) " + stack);

		Inventory gotDVDSeason2 = new Inventory("Season 2", 29.99, 57, 10); //Create the second inventory
		stack.push(gotDVDSeason2); // Push it to the the stack
		System.out.println("(2) " + stack);

		Inventory gotDVDSeason3 = new Inventory("Season 3", 29.99, 58, 10); //Create the third inventory
		stack.push(gotDVDSeason3); // Push it to the the stack
		
		Inventory gotDVDSeason4 = new Inventory("Season 4", 29.99, 59, 10); //Create the fourth inventory
		stack.push(gotDVDSeason4); // Push it to the the stack
		
		System.out.println("(3) " + stack);
		// Remove elements from the stack
		System.out.println("(4) " + stack.pop());
		System.out.println("(5) " + stack.pop());
		System.out.println("(6) " + stack);

		// Create a queue
		InventoryQueue<Inventory> queue = new InventoryQueue<Inventory>();

		// Add elements to the queue
		queue.enqueue(gotDVDSeason1); // Add it to the queue
		System.out.println("(7) " + queue);

		queue.enqueue(gotDVDSeason2); // Add it to the queue
		System.out.println("(8) " + queue);

		queue.enqueue(gotDVDSeason3); // Add it to the queue
		queue.enqueue(gotDVDSeason4); // Add it to the queue
		System.out.println("(9) " + queue);

		// Remove elements from the queue
		System.out.println("(10) " + queue.dequeue());
		System.out.println("(11) " + queue.dequeue());
		System.out.println("(12) " + queue);
	}
}
