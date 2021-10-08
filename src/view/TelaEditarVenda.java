package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entities.DadoVenda;

public class TelaEditarVenda implements ActionListener{
	
	private int ID;

	private static String[] num= {"1", "2", "3", "4", "5", "6"};
	
	private static JFrame frame = new JFrame("Loja de Perfume");
	
	private JList listaCarrinhoBox = new JList(DadoVenda.getListaVenda().get(0).getListaVenda().toArray());
	
	private static JLabel cliente = new JLabel("Cliente:");
	private JTextField tNome = new JTextField();
	private static JComboBox lItem = new JComboBox();
	private static JComboBox lnumero = new JComboBox(num);

	private static JLabel formaPagamento = new JLabel("Forma de pagamento:");
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);
	
	private static JButton atualizar = new JButton("Atualizar");
	private static JButton cancelar = new JButton("Cancelar");
	private static JButton carregar = new JButton("Carregar");
	
	
	
	public TelaEditarVenda(int id) {
		this.ID = id;
		System.out.println(id);
		
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		cliente.setBounds(300, 40, 100, 20);
		
		tNome.setBounds(300, 60, 240, 20);
		
		listaCarrinhoBox.setBounds(50, 40, 210, 150);
		formaPagamento.setBounds(300, 160, 180, 20);
		pix.setBounds(300, 180, 80, 20);
		cartao.setBounds(380, 180, 80, 20);
		dinheiro.setBounds(460, 180, 100, 20);
		cancelar.setBounds(300, 205, 100, 20);
		atualizar.setBounds(440, 205, 100, 20);
		carregar.setBounds(300, 20, 100, 20);
		lnumero.setBounds(530, 100, 40, 20);
		lItem.setBounds(300, 100, 200, 20);
		
		
		frame.add(listaCarrinhoBox);
		frame.add(formaPagamento);
		frame.add(pix);
		frame.add(cartao);
		frame.add(dinheiro);
		frame.add(tNome);
		frame.add(cliente);
		frame.add(cancelar);
		frame.add(atualizar);
		frame.add(carregar);
		frame.add(lnumero);
		frame.add(lItem);
		
		frame.setVisible(true);
		
		atualizar.addActionListener(this);
		carregar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		if (src == atualizar) {
			//editar aqui
			int i = DadoVenda.getListaVenda().get(0).getID();
			//System.out.println(DadoVenda.buscaPorVenda(i).getListaVenda().toArray());
			//listaCarrinhoBox.setListData(DadoVenda.buscaPorVenda(0).getListaVenda().toArray());
		}
		if(src == carregar) {
			listaCarrinhoBox.removeAll();
			tNome.setText(DadoVenda.getListaVenda().get(this.ID).getCliente().getNome());
			listaCarrinhoBox.setListData(DadoVenda.getListaVenda().get(this.ID).getListaVenda().toArray());
			System.out.println(DadoVenda.getListaVenda().get(this.ID).getListaVenda());
			System.out.println(this.ID);
			//DadoVenda.getListaVenda().get(this.ID).get
			//lItem.addItem(DadoVenda.getListaVenda().get(this.ID).getListaVenda().get(0));
		}
		
	}
}
