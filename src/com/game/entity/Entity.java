package com.game.entity;

import com.game.map.Cell;

public class Entity {

	private String name;
	private Cell cell;

	public Entity(String name) {
		this.name = name;
	}

	public Cell getCell() {
		return cell;
	}

	public boolean setCell(Cell cell) {
		if (cell != null) {
			this.cell = cell;
			return true;
		} else
			return false;
	}

	public String getName() {
		return name;
	}

}
