package com.game.item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	public List<Item> inventory = new ArrayList<Item>();

	public int size() {
		return inventory.size();
	}

	public void addItem(Item item) {
		inventory.add(item);
	}

	public void removeItem(Item item) {
		if (hasItem(item))
			inventory.remove(getIndex(item));
	}

	public int getIndex(Item item) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).equals(item))
				return i;
		}
		return -1;
	}

	public Item getItem(String name) {
		for (Item item : inventory)
			if (item.getName().toLowerCase().equals(name) || item.getName().equals(name))
				return item;
		return null;
	}

	public boolean hasItem(Item item2) {
		for (Item item : inventory)
			if (item.equals(item2))
				return true;
		return false;
	}

	public boolean hasItem(String name) {
		for (Item item : inventory)
			if (item.getName().toLowerCase().equals(name) || item.getName().equals(name))
				return true;
		return false;
	}

}
