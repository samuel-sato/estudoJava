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
import modelo.Venda;

public class TelaEstoque implements ActionListener, ListSelectionListener{
	
private static String[] num= {"1", "2", "3", "4", "5", "6"};
	
	private static DefaultListModel model = new DefaultListModel();
	
	private static JFrame frame = new JFrame("Venda");
	private static JLabel carrinho = new JLabel("Estoque");
	private static JLabel item = new JLabel("Selecione um produto");

	public static JComboBox lItem = new JComboBox(Dado.nomeProduto(ControleProduto.lista).toArray());
	private static JLabel quantidade = new JLabel("Nº");
	
	//private static JComboBox lCliente = new JComboBox(Dado.nomeCliente(ControleCliente.listaCliente).toArray());
	private static JComboBox lnumero = new JComboBox(num);
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);

	private static JLabel formaPagamento = new JLabel("Forma de pagamento");
	private static JRadioButton FormaPagamento = new JRadioButton();
	private static JButton adicionar = new JButton("Adicionar");
	private static JButton retirar = new JButton("Retirar");
	private static JButton vender = new JButton("Vender");
	private static JButton cancelar = new JButton("Cancelar");
	private static List<String> teste = Dado.nomeEstoque();
	private static JList listaCarrinho = new JList(teste.toArray());
	
    JScrollPane scroll1 = new JScrollPane(listaCarrinho);

    //Venda v;
    
    
	public TelaEstoque() {
		
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
		
		formaPagamento.setBounds(300, 160, 180, 20);
		pix.setBounds(300, 180, 80, 20);
		cartao.setBounds(380, 180, 80, 20);
		dinheiro.setBounds(460, 180, 100, 20);
		
		cancelar.setBounds(300, 205, 100, 20);
		vender.setBounds(440, 205, 100, 20);
		
		//frame.add(cliente);
		//frame.add(lCliente);
		frame.add(item);
		frame.add(lItem);
		frame.add(lnumero);
		frame.add(quantidade);
		frame.add(adicionar);
		frame.add(retirar);
		
		//frame.add(formaPagamento);
		//frame.add(pix);
		//frame.add(cartao);
		//frame.add(dinheiro);
		
		//frame.add(vender);
		//frame.add(cancelar);
		
		frame.add(carrinho);
		frame.add(scroll1);
		
		frame.setVisible(true);
		
		pix.addActionListener(this);
		cartao.addActionListener(this);
		dinheiro.addActionListener(this);
		adicionar.addActionListener(this);
		vender.addActionListener(this);
		cancelar.addActionListener(this);
		lItem.addActionListener(this);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Venda v = new Venda();
		Object src = arg0.getSource();
		//System.out.println(src);
		if(src == pix) {
			cartao.setSelected(false);
			dinheiro.setSelected(false);
			v.setFormaPagamento(pix.getText());
		}
		if(src == cartao) {
			pix.setSelected(false);
			dinheiro.setSelected(false);
			v.setFormaPagamento(cartao.getText());
		}
		if(src == dinheiro) {
			cartao.setSelected(false);
			pix.setSelected(false);
			v.setFormaPagamento(dinheiro.getText());
		}
		if(src == adicionar) {
			//v.adicionarCarrinho(ControleProduto.lista.get(lItem.getSelectedIndex()), (lnumero.getSelectedIndex()+1));
			//model.addElement(lItem.getSelectedItem()+" - "+(lnumero.getSelectedIndex()+1));
			
			Estoque.adicionarVariasUnidades(ControleProduto.lista.get(lItem.getSelectedIndex()), (lnumero.getSelectedIndex()+1));
			Estoque.listarEstoque();
		}
		if(src == vender) {
			//v.setCliente(ControleCliente.listaCliente.get(lCliente.getSelectedIndex()));
			
			if(model.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nenhum produto no carrinho");
			} else if(!cartao.isSelected() && !pix.isSelected() && !dinheiro.isSelected()) {
				JOptionPane.showMessageDialog(null, "Nenhuma forma de pagamento selecionada");
				
			} else {
				
				for (int i = 0;i<model.getSize(); i++) {
					
					System.out.println(model.get(i));
				}
				System.out.println();
				v.listaProdutos();
				ControleVenda.adicionar(v);
				JOptionPane.showMessageDialog(null, "VENDA REALIZADA");
				model.clear();
				
				ControleVenda.exibir();
			}
		}
		if(src == cancelar) {
			frame.dispose();
			model.clear();
			cartao.setSelected(false);
			pix.setSelected(false);
			dinheiro.setSelected(false);
			
		}
		
	}

}
