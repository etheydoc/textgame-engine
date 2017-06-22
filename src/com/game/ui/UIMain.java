package com.game.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UIMain {

	public int WIDTH = 800;
	public int HEIGHT = 600;
	public String title = "TextGame";

	public JPanel p = new JPanel();
	public JFrame j;

	public JTextArea dialog = new JTextArea(20, 50);
	public JTextField input = new JTextField(50);
	public JScrollPane scroll = new JScrollPane(dialog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public UIMain(int width, int height, String title) {
		j = new JFrame();

		this.WIDTH = width;
		this.HEIGHT = height;
		this.title = title;

		j.setSize(600, 450);
		j.setResizable(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setEditable(false);
		dialog.setLineWrap(true);
		dialog.setWrapStyleWord(true);

		// dialog.setBounds(new Rectangle(5, 5, 20, 50));
		// input.setBounds(new Rectangle(5, 60, 5, 20));

		// p.setLayout(new GridLayout(2, 1));

		p.add(scroll);
		p.add(input);

		p.setBackground(Color.BLACK);

		j.setTitle(title);

		j.add(p);
		j.setLocationRelativeTo(null);
		j.setVisible(true);

		// j.pack();
	}

	public void addText(String text) {
		dialog.setText(dialog.getText() + text + "\n");
	}
}
