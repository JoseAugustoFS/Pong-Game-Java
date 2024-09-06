package Game;

import javax.swing.JLayeredPane;

import javax.swing.JLabel;

import java.awt.Color;

import java.awt.Font;

public class Main{
	
	public static void main(String[] args)
	{
		Janela janela = new Janela();
		Barras barras = new  Barras();
		Bola bola = new Bola();
		Botoes escolha = new Botoes();
		Teclas tecla = new Teclas();
		
		JLayeredPane painel = new JLayeredPane();
		JLabel fim = new JLabel("FIM!");
		JLabel placar = new JLabel();
		
		painel.setBounds(0, 20, 600, 600);
		barras.setOpaque(false);
		barras.setBounds(0, 0, 600, 600);
		bola.setOpaque(false);
		bola.setBounds(0, 0, 600, 600);
		fim.setBounds(140, 250, 300, 100);
		fim.setVisible(false);
		fim.setFont(new Font("Teste", Font.PLAIN ,150));
		fim.setForeground(Color.WHITE);
		placar.setBounds(43, -35, 600, 100);
		placar.setVisible(false);
		placar.setFont(new Font("Teste", Font.PLAIN ,25));
		placar.setForeground(Color.WHITE);
		
		painel.add(fim);
		painel.add(bola);
		painel.add(barras);
		painel.add(placar);
		
		painel.setVisible(false);
		
		janela.criarJanela();
		janela.Single.addActionListener(escolha);
		janela.Multi.addActionListener(escolha);
		janela.tela.add(painel);
		janela.tela.setFocusable(true);
		janela.tela.addKeyListener(tecla);
		
		int y_player1=150,y_player2=150,x_bola=280,y_bola=250, angulo=0;
		int pontos1=0,pontos2=0;
		boolean single=false,multi=false;
		
		angulo=bola.ResetAngulo(angulo);
		
		while((!single)&&(!multi))
		{			
			
			single=escolha.getEscolhaSingle();
			multi=escolha.getEscolhaMulti();
			System.out.flush();
		}
		
		janela.Single.setVisible(false);
		janela.Multi.setVisible(false);
		janela.titulo.setVisible(false);
		painel.setVisible(true);
		placar.setVisible(true);
		placar.setText(pontos1+"                                                                  "+pontos2);
		
		tecla.multi=multi;
		
		System.out.flush();

		//PONTUACAO
		
		
		while((pontos1<3)&&(pontos2<3))
		{
			
			y_player1=tecla.getPossicaoPlayer1();
			
			if(single)
			{
				if((y_player2>=54)||(y_player2<=355))
				{
					
					if(y_bola>y_player2+150)
					{
						y_player2+=3;
					}
					else
						if(y_bola<y_player2+50)
						{
							y_player2-=3;
						}
				}
			}
			else
				y_player2=tecla.getPossicaoPlayer2();
			
			x_bola+=Math.sin(Math.toRadians(angulo))*10;
			y_bola+=Math.cos(Math.toRadians(angulo))*10;
			angulo=bola.determinarAngulo(angulo, y_player1, y_player2);
			barras.setPossicoes(y_player1, y_player2);
			bola.setPossicao(x_bola, y_bola);
			barras.repaint();
			bola.repaint();
			if(x_bola<53)
			{
				x_bola=280;
				y_bola=250;
				angulo=bola.ResetAngulo(angulo);
				pontos2++;
			}
			if(x_bola>507)
			{
				x_bola=280;
				y_bola=250;
				angulo=bola.ResetAngulo(angulo);
				pontos1++;
			}
			placar.setText(pontos1+"                                                                  "+pontos2);
			
			try { Thread.sleep (50); } catch (InterruptedException ex) {}
		}
		fim.setVisible(true);
	}

}
