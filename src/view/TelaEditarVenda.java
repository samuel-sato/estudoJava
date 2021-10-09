package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.DadoCliente;
import entities.DadoVenda;
import modelo.Venda;

/**
 * Classe que exibe tela de edição dos dados de uma venda
 * @author samuel
 * @version 1.0
 */
public class TelaEditarVenda implements ActionListener{
	
	private int ID;

	private static String[] num= {"1", "2", "3", "4", "5", "6"};
	
	private static JFrame frame = new JFrame("Loja de Perfume");
	
	private JList listaCarrinhoBox = new JList();
	
	private static JLabel cliente = new JLabel("Cliente:");
	private JTextField tNome = new JTextField();
	private static JComboBox lCliente = new JComboBox(DadoCliente.nomeCliente().toArray());
	//private static JComboBox lnumero = new JComboBox(num);

	private static JLabel formaPagamento = new JLabel("Forma de pagamento:");
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);
	
	private static JButton atualizar = new JButton("Atualizar");
	private static JButton cancelar = new JButton("Cancelar");
	private static JButton carregar = new JButton("Carregar");
	private static JButton deletar = new JButton("Deletar");
	
	
	
	public TelaEditarVenda(int id) {
		this.ID = id;
		System.out.println(id);
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		cliente.setBounds(300, 50, 100, 20);
		
		carregar.setBounds(300, 20, 100, 20);
		lCliente.setBounds(300, 70, 240, 20);
		
		listaCarrinhoBox.setBounds(50, 40, 210, 150);
		formaPagamento.setBounds(300, 100, 180, 20);
		pix.setBounds(300, 120, 80, 20);
		cartao.setBounds(380, 120, 80, 20);
		dinheiro.setBounds(460, 120, 100, 20);
		cancelar.setBounds(300, 200, 100, 20);
		atualizar.setBounds(440, 200, 100, 20);
		deletar.setBounds(100, 200, 100, 20);
		
		
		//lnumero.setBounds(530, 100, 40, 20);
		//lItem.setBounds(300, 100, 200, 20);
		
		
		frame.add(listaCarrinhoBox);
		frame.add(formaPagamento);
		frame.add(pix);
		frame.add(cartao);
		frame.add(dinheiro);
		frame.add(lCliente);
		frame.add(cliente);
		frame.add(cancelar);
		frame.add(atualizar);
		frame.add(carregar);
		frame.add(deletar);
		//frame.add(lnumero);
		//frame.add(lItem);
		
		frame.setVisible(true);
		
		
		pix.addActionListener(this);
		cartao.addActionListener(this);
		dinheiro.addActionListener(this);
		
		atualizar.addActionListener(this);
		carregar.addActionListener(this);
		cancelar.addActionListener(this);
		deletar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		Venda v = DadoVenda.getListaVenda().get(this.ID);
		
		if(src == pix) {
			cartao.setSelected(false);
			dinheiro.setSelected(false);
			DadoVenda.getListaVenda().get(this.ID).setFormaPagamento(pix.getText());
		}
		if(src == cartao) {
			pix.setSelected(false);
			dinheiro.setSelected(false);
			DadoVenda.getListaVenda().get(this.ID).setFormaPagamento(cartao.getText());
		}
		if(src == dinheiro) {
			cartao.setSelected(false);
			pix.setSelected(false);
			DadoVenda.getListaVenda().get(this.ID).setFormaPagamento(dinheiro.getText());
		}
		
		if (src == atualizar) {
			DadoVenda.getListaVenda().get(this.ID).setCliente(DadoCliente.getCliente(lCliente.getSelectedIndex()));
			
		}
		if(src == carregar) {
			
			int n = v.getNProdutos();
			listaCarrinhoBox.removeAll();
			tNome.setText(DadoVenda.getListaVenda().get(this.ID).getCliente().getNome());
			listaCarrinhoBox.setListData(DadoVenda.getListaVenda().get(this.ID).getListaVenda().toArray());
			
			//lItem.removeAll();
			for (int i=0;i<=n; i++) {
				//lItem.addItem(v.getListaVenda().get(i));
			}
			
			if(v.getFormaPagamento().equalsIgnoreCase("Dinheiro")) {
				dinheiro.setSelected(true);
				cartao.setSelected(false);
				pix.setSelected(false);
			}
			if(v.getFormaPagamento().equalsIgnoreCase("Cartão")) {
				cartao.setSelected(true);
				pix.setSelected(false);
				dinheiro.setSelected(false);
			}
			if(v.getFormaPagamento().equalsIgnoreCase("Pix")) {
				pix.setSelected(true);
				cartao.setSelected(false);
				dinheiro.setSelected(false);
			}
			
			int ncliente = DadoCliente.getnCliente();
			
			
			lCliente.setSelectedIndex(DadoCliente.buscaIdentificada(DadoVenda.getListaVenda().get(this.ID).getCliente()));
		}
		if(src == cancelar) {
			frame.dispose();
		}
		if(src == deletar) {
			if(DadoVenda.excluir(this.ID)) {
				JOptionPane.showMessageDialog(null, "Venda excluida");
			} else {
				
			}
		}
		
	}
}
