package Game;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Botoes implements ActionListener {
	
	private boolean single = false;
	private boolean multi = false;
	
	public boolean getEscolhaSingle()
	{
		return single;
	}
	
	public boolean getEscolhaMulti()
	{
		return multi;
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		System.out.flush();
		JButton botao= (JButton) evento.getSource();
		String escolha=botao.getText();
		if((!single)&&(!multi))
		{			
			if(escolha.equals("Singleplayer"))
			{
				single=true;			
			}
			else
			{
				multi=true;
			}
		}
	}

}
