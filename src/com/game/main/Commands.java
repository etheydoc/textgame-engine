package com.game.main;

import com.game.entity.EntityHostile;
import com.game.entity.Player;

public class Commands {

	private String[] move = { "walk", "run", "move", "go", "climb", "crawl" };
	private String[] inv = { "inventory", "items", "carrying" };
	private String drop = "drop", take = "take", look = "look", attack = "attack";

	public String run(String in, Player player) {
		if (isInArray(in, move)) {
			String[] words = in.split(" ");
			if (words[1].equals("north")) {
				if (player.setCell(player.getCell().getCell(0)))
					return descCell(player);
			} else if (words[1].equals("south")) {
				if (player.setCell(player.getCell().getCell(1)))
					return descCell(player);
			} else if (words[1].equals("east")) {
				if (player.setCell(player.getCell().getCell(2)))
					return descCell(player);
			} else if (words[1].equals("west")) {
				if (player.setCell(player.getCell().getCell(3)))
					return descCell(player);
			} else if (words[1].equals("up")) {
				if (player.setCell(player.getCell().getCell(4)))
					return descCell(player);
			} else if (words[1].equals("down")) {
				if (player.setCell(player.getCell().getCell(5)))
					return descCell(player);
			} else
				return "You cannot go that way.";

		} else if (isInArray(in, inv)) {
			StringBuilder out = new StringBuilder();
			for (int i = 0; i < player.inv.size(); i++) {
				out.append("\n" + player.inv.inventory.get(i).getName() + ": " + player.inv.inventory.get(i).getDesc());
			}
			String output = out.toString();
			if (output.length() > 0)
				return "You are carrying:\n" + output;
			else
				return "You are carrying nothing.";
		} else if (in.contains(drop)) {
			String item = in.split(drop)[1].trim();
			if (player.inv.hasItem(item)) {
				player.getCell().items.addItem(player.inv.getItem(item));
				player.inv.removeItem(player.inv.getItem(item));
				return ("You drop the " + item + ".");
			} else
				return ("You're not carrying a " + item + ".");
		} else if (in.contains(take)) {
			String item = in.split(take)[1].trim();
			if (player.getCell().items.hasItem(item)) {
				player.inv.addItem(player.getCell().items.getItem(item));
				player.getCell().items.removeItem(player.getCell().items.getItem(item));
				return ("You pick up the " + item + ".");
			} else {
				if (firstLetterVowel(item))
					return ("You don't see an " + item + " here.");
				else
					return ("You don't see a " + item + " here.");
			}
		} else if (in.contains(look)) {
			descCell(player);
		} else if (in.contains(attack)) {
			String entity = in.split(attack)[1].trim();
			if (player.getCell().entities.size() > 0 && player.getCell().entities.hasEntity(entity)) {
				if (player.getCell().entities.getEntity(entity).getClass().equals(EntityHostile.class)) {
					EntityHostile eh = (EntityHostile) player.getCell().entities.getEntity(entity);
					return player.dmgEntity(eh);
				} else {
					return ("You can't attack that.");
				}
			} else {
				return ("You don't see a " + entity + " here.");
			}
		}

		return "Unknown command.";

	}

	private String descCell(Player player) {
		StringBuilder items = new StringBuilder();
		if (player.getCell().items.size() > 0) {
			for (int i = 0; i < player.getCell().items.size() - 1; i++) {
				String iname = player.getCell().items.inventory.get(i).getName();
				if (firstLetterVowel(iname))
					items.append("an " + iname + ", ");
				else
					items.append("a " + iname + ", ");
			}

			String iname = player.getCell().items.inventory.get(player.getCell().items.size() - 1).getName();
			if (player.getCell().items.size() > 1) {
				if (firstLetterVowel(iname))
					items.append("and an " + iname + ".");
				else
					items.append("and a " + iname + ".");
			} else {
				if (firstLetterVowel(iname))
					items.append("an " + iname + ".");
				else
					items.append("a " + iname + ".");
			}
		}

		StringBuilder entities = new StringBuilder();
		if (player.getCell().entities.size() > 0) {
			for (int i = 0; i < player.getCell().entities.size() - 1; i++) {
				String ename = player.getCell().entities.entities.get(i).getName();
				if (firstLetterVowel(ename))
					entities.append("an " + ename + ", ");
				else
					entities.append("a " + ename + ", ");
			}

			String ename = player.getCell().entities.entities.get(player.getCell().entities.size() - 1).getName();
			if (player.getCell().items.size() > 1) {
				if (firstLetterVowel(ename))
					entities.append("and an " + ename + ".");
				else
					entities.append("and a " + ename + ".");
			} else {
				if (firstLetterVowel(ename))
					entities.append("an " + ename + ".");
				else
					entities.append("a " + ename + ".");
			}
		}

		StringBuilder output = new StringBuilder();
		if (player.getCell().items.size() > 0 || player.getCell().entities.size() > 0) {
			output.append("\n\nYou see here ");
			if (player.getCell().items.size() > 0)
				output.append(items.toString());
			if (player.getCell().entities.size() > 0)
				output.append("\n\nYou also see " + entities.toString());
		}

		return player.getCell().getName() + "\n\n" + player.getCell().getDesc() + output.toString();

	}

	private boolean firstLetterVowel(String str) {
		if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o'
				|| str.charAt(0) == 'u')
			return true;

		return false;
	}

	private boolean isInArray(String s, String[] a) {
		for (int i = 0; i < a.length; i++)
			if (s.contains(a[i]))
				return true;

		return false;
	}

}
