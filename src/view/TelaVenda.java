package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
//import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.DadoCliente;
import entities.DadoProduto;
import entities.DadoVenda;
import entities.Estoque;
import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;


public class TelaVenda implements ActionListener, ListSelectionListener {
	
	private static String[] num= {"1", "2", "3", "4", "5", "6"};
	
	private static List<String> model = new ArrayList<>();
	
	private JFrame frame = new JFrame("Venda");
	private static JLabel carrinho = new JLabel("Carrinho");
	private static JLabel item = new JLabel("Selecione um produto");
	private static JLabel cliente = new JLabel("Selecione um cliente");
	private static JLabel total = new JLabel("TOTAL:");
	
	private static JLabel quantidade = new JLabel("Nº");
	private static List<String> boxCliente = DadoCliente.nomeCliente();
	private static JComboBox lCliente = new JComboBox(boxCliente.toArray());
	private static List<String> boxProduto = Estoque.listaParaVenda();
	private static JComboBox<String> lItem= new JComboBox(boxProduto.toArray());
	
	
	private static JComboBox lnumero = new JComboBox(num);
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);

	private static JLabel formaPagamento = new JLabel("Forma de pagamento");
	private static JRadioButton FormaPagamento = new JRadioButton();
	private static JButton adicionar = new JButton("Adicionar Item");
	private static JButton vender = new JButton("Vender");
	private static JButton cancelar = new JButton("Cancelar");
	private static JButton atualizar = new JButton("Atualizar");
	private static JList listaCarrinho = new JList(model.toArray());
	
    JScrollPane scroll1 = new JScrollPane(listaCarrinho);  
    
	public TelaVenda() {

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		Venda.setPosicao();
		Venda.carrinho.clear();
		Venda.unid.clear();
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		total.setBounds(50, 205, 100, 20);
		atualizar.setBounds(170, 205, 100, 20);
		
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
		frame.add(total);
		frame.add(atualizar);
		
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
		atualizar.addActionListener(this);
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
			
			String s = (String) lnumero.getSelectedItem();
			v.adicionarCarrinho(DadoProduto.getProduto(lItem.getSelectedIndex()), Integer.parseInt(s));
			
			model.add(lItem.getSelectedItem()+" - "+Integer.parseInt(s));
			System.out.println(lItem.getSelectedItem()+" - "+Integer.parseInt(s));
			listaCarrinho.setListData(model.toArray());
		
		}
		if(src == vender) {
			v.setCliente(DadoCliente.getCliente(lCliente.getSelectedIndex()));
			
			if(model.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nenhum produto no carrinho");
			} else if(!cartao.isSelected() && !pix.isSelected() && !dinheiro.isSelected()) {
				JOptionPane.showMessageDialog(null, "Nenhuma forma de pagamento selecionada");
				
			} else {
				//v.listaProdutos();
				
				v.setCliente(DadoCliente.getCliente(lCliente.getSelectedIndex()));
				if(v.vender()) {
					JOptionPane.showMessageDialog(null, "VENDA REALIZADA");
					DadoVenda.adicionar(v);
					model.clear();
					Venda.setPosicao();
				}					
			}
		}
		if(src == cancelar) {
			frame.dispose();
			model.clear();
			cartao.setSelected(false);
			pix.setSelected(false);
			dinheiro.setSelected(false);
			model.clear();
			listaCarrinho.setListData(model.toArray());
			
		}
		if(src == atualizar) {
			//lItem = new JComboBox(boxProduto.toArray());
			DadoProduto.listar();
			total.setText("TOTAL: "+v.precoTotal());
			lItem.removeAllItems();
			for (int i=0;i<Estoque.getPosicao(); i++) {
				try {
					Produto[] p = Estoque.getProduto();
					lItem.addItem(p[i].getNome());
				}catch(NullPointerException ex) {
				}
			}
			lCliente.removeAllItems();
			for (int i=0;i<DadoCliente.getnCliente()-1; i++) {
				try {
					Cliente c = DadoCliente.getCliente(i);
					lCliente.addItem(c.getNome());
				}catch(NullPointerException ex) {
				}
			}
			
		}
	}
}