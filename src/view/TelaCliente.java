package view;

import entities.DadoCliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Cliente;

public class TelaCliente implements ActionListener, ListSelectionListener{
	private int index;

	private static JFrame frame;
	private static JLabel titulo;
	private static JButton novoCliente;
	private static JButton editar;
	private static JButton atualizar;
	//private static DefaultListModel model = new DefaultListModel();
	//public static List <Cliente> listaCliente = new ArrayList<Cliente>();

	
	private JList lista = new JList(DadoCliente.nomeCliente().toArray());
	
	private JLabel labelNome;
    private JLabel labelTel = new JLabel("Telefone: ");
    private JLabel labelCpf = new JLabel("CPF: ");
    private JLabel labelCEP = new JLabel("CEP: ");
    private JLabel labelEmail = new JLabel("Email: ");
	
    JScrollPane scroll = new JScrollPane(lista);
    
    public TelaCliente() {
    	frame = new JFrame("Clientes");
    	titulo = new JLabel("Lista de Clientes");
    	novoCliente = new JButton("Novo Cliente");
    	editar = new JButton("Editar Cliente");
    	atualizar = new JButton("Atualizar lista");

    	labelNome = new JLabel("Nome: ");
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setBounds(100, 10, 200, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		novoCliente.setBounds(100, 45, 150, 20);
		editar.setBounds(350, 45, 150, 20);
		atualizar.setBounds(100, 200, 150, 20);
		scroll.setBounds(100, 80, 200, 120);
		
		labelNome.setBounds(320, 80, 200, 20);
		labelEmail.setBounds(320, 100, 200, 20);
		labelTel.setBounds(320, 120, 200, 20);
		labelCpf.setBounds(320, 140, 200, 20);
		labelCEP.setBounds(320,160, 200, 20);
		
		frame.add(scroll);
		frame.add(titulo);
		frame.add(novoCliente);
		frame.add(editar);
		frame.add(labelNome);
		frame.add(labelTel);
		frame.add(labelCpf);
		frame.add(labelCEP);
		frame.add(labelEmail);
		frame.add(atualizar);
		
		lista.addListSelectionListener(this);

		novoCliente.addActionListener(this);
		editar.addActionListener(this);
		atualizar.addActionListener(this);
		frame.setVisible(true);
	}
    
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		this.index = lista.getSelectedIndex();
		updateLabels(this.index);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == novoCliente) {
			new TelaAdicionarEditarCliente(1, index);
		}
		if(src == editar) {
			try {
				new TelaAdicionarEditarCliente(2, index);
			} catch (IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Nenhum Cliente selecionado!");

			}
			
		}
		if(src ==atualizar) {
			lista.setListData(DadoCliente.nomeCliente().toArray());
			lista.updateUI();
			updateLabels((this.index)+1);
		}
		
	}
	public void updateLabels(int n) {
		try {
			labelNome.setText("Nome: "+DadoCliente.getCliente(n).getNome());
			labelTel.setText("Telefone: "+DadoCliente.getCliente(n).getTelefone());
			labelCpf.setText("CPF: "+DadoCliente.getCliente(n).getCPF());
			labelCEP.setText("CEP: "+DadoCliente.getCliente(n).getCEP());
			labelEmail.setText("Email: "+DadoCliente.getCliente(n).getEmail());
			
		} catch (IndexOutOfBoundsException ex){
			//updateLabels((this.index)+1);
			//System.out.println("deu erro");
		}	

	}

}
