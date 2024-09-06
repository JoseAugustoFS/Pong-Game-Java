package Game;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JLabel;

public class Janela {

	JFrame tela = new JFrame("Pong");
	JButton Single = new JButton("Singleplayer");
	JButton Multi = new JButton("Multiplayer");
	JLabel titulo = new JLabel("Pong");


	
	public void criarJanela()
	{

		tela.setSize(600,600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setVisible(true);
		tela.getContentPane().setBackground(Color.BLACK);

		titulo.setBounds(215, 70, 300, 95);
		titulo.setFont(new Font("Teste", Font.PLAIN, 75));
		titulo.setForeground(Color.WHITE);
		Single.setBounds(145, 230, 300, 80);
		Single.setFont(new Font("Teste", Font.PLAIN, 25));
		Multi.setBounds(145, 330, 300, 80);
		Multi.setFont(new Font("Teste", Font.PLAIN, 25));

		tela.add(Single);
		tela.add(Multi);
		tela.add(titulo);
		
		


		
	}
	
	
}
