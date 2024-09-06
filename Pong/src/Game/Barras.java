package Game;

import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class Barras extends JPanel {
	private int y1,y2;
	
	public void setPossicoes(int y1, int y2)
	{
		this.y1=y1;
		this.y2=y2;
	}
	
	public void paintComponent(Graphics g)
	{
		//Barreira
		g.fillRect(0, 30, 600, 20);
		//Barras
		g.setColor(Color.WHITE);
		g.fillRect(40, y1, 20, 200);
		g.fillRect(520, y2, 20, 200);
	}

}
