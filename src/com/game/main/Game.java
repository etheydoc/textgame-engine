package com.game.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import com.game.entity.EntityDatabase;
import com.game.entity.Player;
import com.game.item.Inventory;
import com.game.map.Map;
import com.game.ui.UIMain;

public class Game implements KeyListener {

	private UIMain ui;
	private String user = "default";
	private Commands cmd = new Commands();
	private Player player;
	private Map map;
	private Inventory itemDB; // item database
	private EntityDatabase entityDB; // entity database

	public Game(int w, int h, String t) {
		ui = new UIMain(w, h, t);
		ui.input.addKeyListener(this);

		user = JOptionPane.showInputDialog("What's your name?");
		player = new Player(user, 100, 1, 10, 0.7);

		itemDB = Data.initItems();
		entityDB = Data.initEntities();
		map = Data.initMap();
		player.setCell(map.getCell("Prison Cell"));
		player.inv.addItem(itemDB.getItem("$1 Bill"));

		map.cells.get(1).items.addItem(itemDB.getItem("pocketknife"));
		map.cells.get(1).entities.addEntity(entityDB.getEntity("zombie"));

		ui.addText(player.getCell().getName() + "\n\n" + player.getCell().getDesc());
	}

	private void update(String str) {
		ui.addText("\n" + cmd.run(str, player));
		String update = player.getCell().update(player);
		if (update != null)
			if (!update.isEmpty())
				ui.addText("\n" + update);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_ENTER) {
			// process input
			String grab = ui.input.getText();
			ui.addText("\n" + user + ": " + grab);
			ui.input.setText("");

			// grab = grab.replaceAll("[^A-Za-z0-9 ]", "");
			grab = grab.toLowerCase();
			grab = grab.trim();

			update(grab);
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {

	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

	public static void main(String[] args) {
		new Game(800, 600, "TextGame");
	}

}
