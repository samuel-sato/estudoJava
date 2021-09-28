package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
//import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.ControleCliente;
import entities.ControleProduto;
import entities.Dado;


public class TelaVenda implements ActionListener, ListSelectionListener {
	
	private static String[] num= {"1", "2", "3", "4", "5", "6"};
	
	private static DefaultListModel model = new DefaultListModel();
	
	private static JFrame frame = new JFrame("Venda");
	private static JLabel carrinho = new JLabel("Carrinho");
	private static JLabel item = new JLabel("Selecione um produto");
	private static JLabel cliente = new JLabel("Selecione um cliente");
	private static JComboBox lItem = new JComboBox(Dado.nomeProduto(ControleProduto.lista).toArray());
	private static JLabel quantidade = new JLabel("Nº");

	
	
	private static JComboBox lCliente = new JComboBox(Dado.nomeCliente(ControleCliente.listaCliente).toArray());
	private static JComboBox lnumero = new JComboBox(num);
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);

	private static JLabel formaPagamento = new JLabel("Forma de pagamento");
	private static JRadioButton FormaPagamento = new JRadioButton();
	private static JButton adicionar = new JButton("Adicionar Item");
	private static JButton vender = new JButton("Vender");
	private static JButton cancelar = new JButton("Cancelar");
	private static JList listaCarrinho = new JList(model);
	
    JScrollPane scroll1 = new JScrollPane(listaCarrinho);


	public TelaVenda() {
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		carrinho.setBounds(50, 20, 100, 20);
		scroll1.setBounds(50, 40, 210, 150);
		cliente.setBounds(300, 20, 200, 20);
		lCliente.setBounds(300, 40, 200, 20);
		
		item.setBounds(300, 80, 200, 20);
		lItem.setBounds(300, 100, 200, 20);
		quantidade.setBounds(530, 80, 50, 20);
		lnumero.setBounds(530, 100, 40, 20);
		adicionar.setBounds(300, 130, 150, 20);
		
		formaPagamento.setBounds(300, 160, 180, 20);
		pix.setBounds(300, 180, 80, 20);
		cartao.setBounds(380, 180, 80, 20);
		dinheiro.setBounds(460, 180, 100, 20);
		
		cancelar.setBounds(300, 205, 100, 20);
		vender.setBounds(440, 205, 100, 20);
		
		frame.add(cliente);
		frame.add(lCliente);
		frame.add(item);
		frame.add(lItem);
		frame.add(lnumero);
		frame.add(quantidade);
		frame.add(adicionar);
		
		frame.add(formaPagamento);
		frame.add(pix);
		frame.add(cartao);
		frame.add(dinheiro);
		
		frame.add(vender);
		frame.add(cancelar);
		
		frame.add(carrinho);
		frame.add(scroll1);
		
		frame.setVisible(true);
		
		pix.addActionListener(this);
		cartao.addActionListener(this);
		dinheiro.addActionListener(this);
		adicionar.addActionListener(this);
		
		lItem.addActionListener(this);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		//System.out.println(src);
		if(src == pix) {
			cartao.setSelected(false);
			dinheiro.setSelected(false);
		}
		if(src == cartao) {
			pix.setSelected(false);
			dinheiro.setSelected(false);
		}
		if(src == dinheiro) {
			cartao.setSelected(false);
			pix.setSelected(false);
		}
		if(src == adicionar) {
			model.addElement(lItem.getSelectedItem());
		}
		if(src == lItem) {
			
		}
		
	}

}