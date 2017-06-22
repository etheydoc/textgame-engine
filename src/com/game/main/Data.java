package com.game.main;

import com.game.entity.Entity;
import com.game.entity.EntityDatabase;
import com.game.entity.EntityHostile;
import com.game.item.Inventory;
import com.game.item.Item;
import com.game.map.Cell;
import com.game.map.Map;

public class Data {

	/*
	 * HOW TO ADD NEW CELLS/ROOMS:
	 * 
	 * Define a new Cell(String name, String description). Link the Cell to
	 * other Cells by calling linkCells(Cell cell, int direction). Direction key
	 * (defines which direction the linked cell is in): 0 = north 1 = south 2 =
	 * east 3 = west 4 = up 5 = down For one-way connections, use
	 * cell.setCell(Cell cell, int direction). Lastly, call m.cells.add(cell) to
	 * add it to the database.
	 */

	public static Map initMap() {
		Map m = new Map();

		Cell start = new Cell("Prison Cell",
				"A dark and musty prison cell with walls of stone. The grate in the center of the floor has been removed.");
		Cell tunnel = new Cell("Drainage Tunnel",
				"This corridor is even darker than the prison cells above. It smells incredibly terrible.");
		Cell outdoors1 = new Cell("Forest",
				"Beyond the prison fence, where the tunnel emerges, lies a forest of pine trees. The smell is very refreshing, as is the cool breeze.");

		start.linkCells(tunnel, 5);
		tunnel.linkCells(outdoors1, 2);

		m.cells.add(start);
		m.cells.add(tunnel);
		m.cells.add(outdoors1);

		return m;
	}

	/*
	 * HOW TO ADD ITEMS: Define a new Item(String name, String description).
	 * Then add it to the database. Easy as that (for now).
	 */

	public static Inventory initItems() {
		Inventory db = new Inventory();

		Item dollar = new Item("$1 Bill", "A single, crumpled dollar bill.");
		Item knife = new Item("Pocketknife", "A cheap but effective blade.");

		db.addItem(dollar);
		db.addItem(knife);

		return db;
	}

	public static EntityDatabase initEntities() {
		EntityDatabase edb = new EntityDatabase();

		Entity zombie = new EntityHostile("Zombie", 15, 1, 5, 0.4, false);

		edb.addEntity(zombie);

		return edb;
	}

}
