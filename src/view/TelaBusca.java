package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.DadoCliente;
import entities.DadoProduto;

public class TelaBusca implements  ActionListener {

	private static String[] num= {"Produto", "Cliente"};

	private static JFrame frame = new JFrame("Busca");
	JLabel labelNome = new JLabel("Nome: ");
	JLabel labelBusca = new JLabel("Buscar por:");
	JTextArea labelResultado = new JTextArea("Resultado");
	JTextField tNome = new JTextField(40);
	JButton buscar = new JButton("Busca");
	private static JComboBox lnumero = new JComboBox(num);

	public TelaBusca() {
		
		labelNome.setBounds(100, 60, 200, 20);
		this.tNome.setBounds(200, 60, 240, 20);
		labelBusca.setBounds(100, 100, 200, 20);
		lnumero.setBounds(200, 100, 100, 20);
		buscar.setBounds(350, 100, 100, 20);
		labelResultado.setBounds(100, 140, 400, 100);
		labelResultado.setLineWrap(true);
		labelResultado.setWrapStyleWord(true);
		
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		frame.add(labelNome);
		frame.add(labelBusca);
		frame.add(tNome);
		frame.add(lnumero);
		frame.add(buscar);
		frame.add(labelResultado);
		
		buscar.addActionListener(this);		
		
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		String nome = tNome.getText();
		if(src == buscar) {
			if(lnumero.getSelectedIndex()==0) {
				System.out.println(DadoProduto.buscar(nome));
				labelResultado.setText(DadoProduto.buscar(nome));
			} else{
				System.out.println(DadoCliente.buscar(nome));
				labelResultado.setText(DadoCliente.buscar(nome));

			}	
		}
		
	}
	
}
