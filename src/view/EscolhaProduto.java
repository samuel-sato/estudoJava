package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EscolhaProduto implements  ActionListener, ListSelectionListener  {
	
	JFrame frame;
	JLabel titulo;
	JButton perfume, creme, sabonete, kit;
	
	static int nProduto;
	
	public EscolhaProduto() {
		frame = new JFrame();
		perfume = new JButton("Perfume");
		creme = new JButton("Creme");
		sabonete = new JButton("Sabonete");
		kit = new JButton("Kit");
		
		frame.setSize(300, 300);
		frame.setLayout(null);
		
		titulo = new JLabel("Categoria do Produto");
		titulo.setBounds(30, 30, 250, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		perfume.setBounds(20, 100, 120, 30);
		creme.setBounds(20, 150, 120, 30);
		sabonete.setBounds(165, 100, 120, 30);
		kit.setBounds(165, 150, 120, 30);
		
		frame.add(titulo);
		frame.add(perfume);
		frame.add(creme);
		frame.add(sabonete);
		frame.add(kit);
		
		perfume.addActionListener(this);
		creme.addActionListener(this);
		sabonete.addActionListener(this);
		kit.addActionListener(this);
		
		frame.setVisible(true);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		
		if(src == perfume) {
			
			EscolhaProduto.nProduto=1;
			new TelaAdicionarEditarProduto(1);
		}
		if(src == sabonete) {
			EscolhaProduto.nProduto=2;
			new TelaAdicionarEditarProduto(2);
		}
		if(src == creme) {
			EscolhaProduto.nProduto=3;
			new TelaAdicionarEditarProduto(3);
		}
		
		if(src == kit) {
			EscolhaProduto.nProduto=4;
			new TelaAdicionarEditarProduto(4);
		}
		
	}
}
