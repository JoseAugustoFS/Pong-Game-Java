package Game;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter {
	
	
	private int y1=150, y2=150, velocidade=3;
	private boolean update=false;
	public boolean multi;
	
	public int getPossicaoPlayer1()
	{
		update =true;
		return y1;
	}
	public int getPossicaoPlayer2()
	{
		return y2;
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		int tecla = e.getKeyCode();
		if(update)
		{	
			switch(tecla)
			{
			case KeyEvent.VK_W:
				if(y1>=54)
				y1-=velocidade;
				break;
			case KeyEvent.VK_S:
				if(y1<=355)
				y1+=velocidade;
				break;
			case KeyEvent.VK_UP:
				if(multi)
				{
				if(y2>=54)
				y2-=velocidade;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(multi)
				{
				if(y2<=355)
				y2+=velocidade;
				}
				break;
			}
			update=false;
			
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		
	}
	

}
