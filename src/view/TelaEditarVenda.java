package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TelaEditarVenda {

	private static JFrame frame = new JFrame("Loja de Perfume");
	private static JList listaCarrinhoBox;// = new JList();
	private static JList listaCarrinho = new JList();
	private static JLabel cliente = new JLabel("Cliente:");
	JTextField tNome;

	private static JLabel formaPagamento = new JLabel("Forma de pagamento:");
	private static JRadioButton pix = new JRadioButton("Pix", false);
	private static JRadioButton cartao = new JRadioButton("Cartão", false);
	private static JRadioButton dinheiro = new JRadioButton("Dinheiro", false);
	JScrollPane scroll = new JScrollPane(listaCarrinho);  
	
	public TelaEditarVenda() {
		
		tNome = new JTextField("TESTEs");
		listaCarrinhoBox = new JList();
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		cliente.setBounds(300, 40, 100, 20);
		
		this.tNome.setBounds(300, 60, 240, 20);
		
		scroll.setBounds(50, 40, 210, 150);
		formaPagamento.setBounds(300, 160, 180, 20);
		pix.setBounds(300, 180, 80, 20);
		cartao.setBounds(380, 180, 80, 20);
		dinheiro.setBounds(460, 180, 100, 20);
		
		frame.add(scroll);
		frame.add(formaPagamento);
		frame.add(pix);
		frame.add(cartao);
		frame.add(dinheiro);
		frame.add(tNome);
		frame.add(cliente);
		
		frame.setVisible(true);
		
	}
}
