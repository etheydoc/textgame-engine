package com.game.entity;

import com.game.util.Maths;

public class EntityHostile extends Entity {

	private int hp = 100;

	private int minDmg = 1;
	private int maxDmg = 5;

	private double acc = 0.5; // likelihood of hit

	private boolean unique = false;
	private boolean dead = false;

	public EntityHostile(String name, int hp, int minDmg, int maxDmg, double acc, boolean unique) {
		super(name);
		this.hp = hp;
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.acc = acc;
		this.unique = unique;
	}

	public String damage(int dmg) {
		hp -= dmg;
		if (hp > 0) {
			if (unique)
				return ("You hit " + this.getName() + " for " + dmg + " damage!");
			else
				return ("You hit the " + this.getName() + " for " + dmg + " damage!");
		} else {
			dead = true;
			
			if (unique)
				return ("You kill " + this.getName() + "!");
			else
				return ("You kill the " + this.getName() + "!");
		}
	}

	public String dmgPlayer(Player player) {
		if (Maths.randDouble(0, 1) <= acc) {
			int dmg = Maths.randInt(minDmg, maxDmg);

			String pdmg = player.damage(dmg);

			if (unique)
				return (this.getName() + " hits you!\n\n" + pdmg);
			else
				return ("The " + this.getName() + " hits you!\n\n" + pdmg);
		}

		if (unique)
			return (this.getName() + " missed.");
		else
			return ("The " + this.getName() + " missed.");
	}

	public boolean getDead() {
		return dead;
	}

	public boolean getUnique() {
		return unique;
	}

}
