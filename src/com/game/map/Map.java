package com.game.map;

import java.util.ArrayList;
import java.util.List;

public class Map {

	public List<Cell> cells = new ArrayList<Cell>();

	public Cell getCell(String name) {
		for (Cell cell : cells)
			if (cell.getName().equals(name))
				return cell;

		return null;
	}

}
