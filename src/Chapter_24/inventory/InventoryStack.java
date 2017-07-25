package test.stacks.queues;

import java.util.ArrayList;

public class InventoryStack<Inventory> {
	private ArrayList<Inventory> list = new ArrayList<>();

	public int getSize() {
		return list.size();
	}

	public Inventory peek() {
		return list.get(getSize() - 1);
	}

	public void push(Inventory o) {
		list.add(o);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	

	public Inventory pop() {
		Inventory o = list.get(getSize() - 1); 
		list.remove(getSize() - 1); 
		return o;
	}
	
	
	@Override
	public String toString(){
		
		return"Inventory Stack Implementation using ArrayList: "+list.toString();

	}
}
