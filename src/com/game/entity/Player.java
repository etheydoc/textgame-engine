package com.game.entity;

import com.game.item.Inventory;
import com.game.util.Maths;

public class Player extends Entity {

	private int hp = 100;
	private int maxHP = 100;

	private boolean dead = false;

	private int minDmg = 1;
	private int maxDmg = 10;

	private double acc = 0.7;

	public Inventory inv = new Inventory();

	public Player(String name, int maxHP, int minDmg, int maxDmg, double acc) {
		super(name);
		this.hp = maxHP;
		this.maxHP = maxHP;
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.acc = acc;
	}

	public String dmgEntity(EntityHostile entity) {
		if (Maths.randDouble(0, 1) <= acc) {
			int dmg = Maths.randInt(minDmg, maxDmg);

			return (entity.damage(dmg));
		} else {
			if (entity.getUnique())
				return ("You miss " + entity.getName());
			else
				return ("You miss the " + entity.getName());
		}
	}

	public String damage(int dmg) {
		hp -= dmg;

		if (hp > 0) {
			return ("You take " + dmg + " damage.");
		} else {
			dead = true;
			return ("You have died.");
		}

	}

	public String heal(int heal) {
		hp += heal;
		if (hp > maxHP) {
			hp = maxHP;
			return ("You have been healed to full health.");
		}
		return ("You regain " + heal + " hitpoints.");
	}

	public boolean getDead() {
		return dead;
	}
}
