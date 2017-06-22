package com.game.map;

import com.game.entity.EntityDatabase;
import com.game.entity.EntityHostile;
import com.game.entity.Player;
import com.game.item.Inventory;

public class Cell {

	private String name = "Nothing";
	private String desc = "There is nothing here.";
	public Inventory items = new Inventory(); // list of items in this cell
	public EntityDatabase entities = new EntityDatabase(); // list of entities
															// in this cell

	private Cell north, south, east, west, up, down;

	public Cell(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String update(Player player) {
		if (entities.size() > 0) {
			for (int i = 0; i < entities.size(); i++) {
				if (entities.entities.get(i).getClass().equals(EntityHostile.class)) {
					// combat controls
					EntityHostile entity = (EntityHostile) entities.entities.get(i);

					if (!entity.getDead()) {
						return entity.dmgPlayer(player);
					} else {
						entities.removeEntity(entities.getEntity(entity.getName()));
					}
				}
			}
		}

		return null;
	}

	public void setCell(Cell c, int dir) {
		if (dir == 0)
			north = c;
		else if (dir == 1)
			south = c;
		else if (dir == 2)
			east = c;
		else if (dir == 3)
			west = c;
		else if (dir == 4)
			up = c;
		else
			down = c;
	}

	public void linkCells(Cell c, int dir) {
		if (dir == 0) {
			north = c;
			c.south = this;
		} else if (dir == 1) {
			south = c;
			c.north = this;
		} else if (dir == 2) {
			east = c;
			c.west = this;
		} else if (dir == 3) {
			west = c;
			c.east = this;
		} else if (dir == 4) {
			up = c;
			c.down = this;
		} else {
			down = c;
			c.up = this;
		}
	}

	public Cell getCell(int dir) {
		if (dir == 0) {
			if (north != null)
				return north;
		} else if (dir == 1) {
			if (south != null)
				return south;
		} else if (dir == 2) {
			if (east != null)
				return east;
		} else if (dir == 3) {
			if (west != null)
				return west;
		} else if (dir == 4) {
			if (up != null)
				return up;
		} else if (dir == 5) {
			if (down != null)
				return down;
		}

		return null;
	}

}
