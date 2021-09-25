package view;

import entities.ControleCliente;

import java.awt.Font;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import entities.Dado;

public class TelaCliente {

	private static JFrame frame = new JFrame("Clientes");
	private static JLabel titulo = new JLabel("Lista de Clientes");
	private static JButton novoCliente = new JButton("Novo Cliente");
	private static JButton editar = new JButton("Editar Cliente");
	private static JList lista = new JList(Dado.nomeCliente(ControleCliente.listaCliente).toArray());
	
	private JLabel labelNome = new JLabel("Nome: ");
    private JLabel labelTel = new JLabel("Telefone: ");
    private JLabel labelCpf = new JLabel("CPF: ");
    private JLabel labelCEP = new JLabel("CEP: ");
    private JLabel labelEmail = new JLabel("Email: ");
	
    JScrollPane scroll = new JScrollPane(lista);
    
    
    
    public TelaCliente() {
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setBounds(100, 10, 200, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		novoCliente.setBounds(100, 45, 150, 20);
		editar.setBounds(350, 45, 150, 20);
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
		
		
	
		lista.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = lista.getSelectedIndex();

				updateLabels(index);
				
			}
			public void updateLabels(int n) {
				labelNome.setText("Nome: "+ControleCliente.listaCliente.get(n).getNome());
				labelTel.setText("Telefone: "+ControleCliente.listaCliente.get(n).getTelefone());
				labelCpf.setText("CPF: "+ControleCliente.listaCliente.get(n).getCPF());
				labelCEP.setText("CEP: "+ControleCliente.listaCliente.get(n).getCEP());
				labelEmail.setText("Email: "+ControleCliente.listaCliente.get(n).getEmail());
				
			}
		});
		
		
		
		frame.setVisible(true);
	}
	
}
