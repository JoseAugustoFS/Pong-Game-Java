package Game;

import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;

import java.util.Random;

@SuppressWarnings("serial")
public class Bola extends JPanel {
	
	Random aleatorio = new Random();
	private int x=250,y=250;
	private int raio=20;
	
	public void setPossicao(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, raio, raio);
	}
	
	public int determinarAngulo(int angulo, int y1, int y2)
	{
		int fator_ateatoriedade=aleatorio.nextInt(8);
		if((y-raio<=45)&&((angulo>90)&&(angulo<270)))
		{
			if(angulo>180)
				angulo+=100+fator_ateatoriedade;
			else
				if(angulo>90)
					angulo-=100+fator_ateatoriedade;
				else
					if(angulo==180)
						angulo=135;
		}
		else
		if((y+raio>=545)&&((angulo<90)||(angulo>270)))
		{
			if(angulo>270)
				angulo-=90+fator_ateatoriedade;
			else
				if(angulo<90)
					angulo+=90+fator_ateatoriedade;
				else
					if(angulo==0)
						angulo=45;
		}
		if((x-raio<=52)&&((angulo<360)&&(angulo>180)))
		{
			if((y>=y1-2)&&(y<=y1+202))
			//if(true)
			{
				if(angulo>270)
					angulo-=270+fator_ateatoriedade;
				else
					if(angulo>180)
						angulo-=90+fator_ateatoriedade;
					else
						if(angulo==270)
							angulo=45;
			}
		}
		if((x+raio>=510)&&((angulo<180)&&(angulo>0)))
		{
			if((y>=y2-2)&&(y<=y2+202))
			//if(true)
			{
				if(angulo<90)
					angulo+=270+fator_ateatoriedade;
				else
					if(angulo<180)
						angulo+=90+fator_ateatoriedade;
					else
						if(angulo==90)
							angulo=135;
			}
		}
		
		
		return angulo;
	}
	
	public int ResetAngulo(int angulo)
	{
		int fator_aleatoriedade=aleatorio.nextInt(5)+15;
		
		if(aleatorio.nextInt(2)==1)
			fator_aleatoriedade*=-1;
		if(aleatorio.nextInt(2)==1)
			angulo=90+fator_aleatoriedade;
		else
			angulo=270+fator_aleatoriedade;
		
		return angulo;
	}

}
