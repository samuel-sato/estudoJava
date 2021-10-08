package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import entities.DadoVenda;

public class TelaFiltroVenda  implements ActionListener{

	private static JFrame frame = new JFrame("Loja de Perfume");
	private static JLabel titulo = new JLabel("Data");
	private JButton mostrar = new JButton("Mostrar");
	private static JList listaCarrinhoBox = new JList();
	private static String st;
	
	public TelaFiltroVenda(String s) {
		st = s;
		frame.setSize(600, 300);
		frame.setLayout(null);
		listaCarrinhoBox.setBounds(50, 60, 210, 150);
		mostrar.setBounds(300, 60, 100, 20);
		titulo.setBounds(260, 20, 120, 30);
		
		frame.add(titulo);
		frame.add(mostrar);
		frame.add(listaCarrinhoBox);
		frame.setVisible(true);
		
		mostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		if(src == mostrar) {
			titulo.setText(st);
			listaCarrinhoBox.setListData(DadoVenda.buscarPorData(st).toArray());
		}
		
	}
}
