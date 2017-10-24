package test.stacks.queues;

import java.util.LinkedList;

public class InventoryQueue<Inventory> {

	private LinkedList<Inventory> list = new LinkedList<>();

	public void enqueue(Inventory inventory) {
		list.addLast(inventory);
	}

	public Inventory dequeue() {
		return list.removeFirst();
	}

	public int getSize() {		 
	 return list.size();
	 
	}

	@Override
	public String toString(){		
		return"Inventory Queue Implementation using LinkedList: "+list.toString();
	}
}
