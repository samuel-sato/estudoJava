package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.ControleProduto;
import entities.ControleVenda;
import entities.Dado;
import entities.Estoque;
import modelo.Produto;
import modelo.Venda;

public class TelaEstoque implements ActionListener, ListSelectionListener{
	
private static String[] num= {"0", "1", "2", "3", "4", "5", "6"};
	
	private static JFrame frame = new JFrame("Venda");
	private static JLabel carrinho = new JLabel("Estoque");
	private static JLabel item = new JLabel("Selecione um produto");

	public JComboBox lItem = new JComboBox(Dado.nomeProduto(ControleProduto.lista).toArray());
	private static JLabel quantidade = new JLabel("Nº");
	
	private JComboBox lnumero = new JComboBox<Object>(num);
	
	private static JButton adicionar = new JButton("Adicionar");
	private static JButton retirar = new JButton("Retirar");
	private static JButton vender = new JButton("Vender");
	private static JButton cancelar = new JButton("Cancelar");
	private JList listaEstoque = new JList(Estoque.listarEstoque().toArray());
	
    JScrollPane scroll1 = new JScrollPane(listaEstoque);
    
    
	public TelaEstoque() {
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		carrinho.setBounds(50, 20, 100, 20);
		scroll1.setBounds(50, 40, 210, 150);
		item.setBounds(300, 20, 200, 20);
		lItem.setBounds(300, 40, 200, 20);
		
		quantidade.setBounds(530, 20, 50, 20);
		lnumero.setBounds(530, 40, 40, 20);
		adicionar.setBounds(300, 70, 100, 20);
		retirar.setBounds(440, 70, 100, 20);
		
		frame.add(item);
		frame.add(lItem);
		frame.add(lnumero);
		frame.add(quantidade);
		frame.add(adicionar);
		frame.add(retirar);
		
		
		frame.add(carrinho);
		frame.add(scroll1);
		
		frame.setVisible(true);
		
		adicionar.addActionListener(this);
		vender.addActionListener(this);
		cancelar.addActionListener(this);
		lItem.addActionListener(this);
		retirar.addActionListener(this);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object src = arg0.getSource();
		int num = lnumero.getSelectedIndex();
		if(src == adicionar) {
			
			Estoque.adicionar(ControleProduto.lista.get(lItem.getSelectedIndex()), (num));
	
			listaEstoque.setListData(Estoque.listarEstoque().toArray());
			listaEstoque.updateUI();
			//lnumero.setSelectedIndex(0);
			 
		}
		if (src == retirar) {
			Estoque.retirar(ControleProduto.lista.get(lItem.getSelectedIndex()), (num));
	
			listaEstoque.setListData(Estoque.listarEstoque().toArray());
			listaEstoque.updateUI();
			 
			//lnumero.setSelectedIndex(0);
		}
		num = 0;
	}

}
