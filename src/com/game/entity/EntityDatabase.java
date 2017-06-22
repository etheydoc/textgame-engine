package com.game.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityDatabase {

	public List<Entity> entities = new ArrayList<Entity>();

	public int size() {
		return entities.size();
	}

	public void addEntity(Entity Entity) {
		entities.add(Entity);
	}

	public void removeEntity(Entity Entity) {
		if (hasEntity(Entity))
			entities.remove(getIndex(Entity));
	}

	public int getIndex(Entity Entity) {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).equals(Entity))
				return i;
		}
		return -1;
	}

	public Entity getEntity(String name) {
		for (Entity Entity : entities)
			if (Entity.getName().toLowerCase().equals(name) || Entity.getName().equals(name))
				return Entity;
		return null;
	}

	public boolean hasEntity(Entity Entity2) {
		for (Entity Entity : entities)
			if (Entity.equals(Entity2))
				return true;
		return false;
	}

	public boolean hasEntity(String name) {
		for (Entity Entity : entities)
			if (Entity.getName().toLowerCase().equals(name) || Entity.getName().equals(name))
				return true;
		return false;
	}

}
