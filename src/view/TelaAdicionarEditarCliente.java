package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.ControleCliente;
import modelo.Cliente;

public class TelaAdicionarEditarCliente implements  ActionListener, ListSelectionListener {
	
	JLabel labelNome = new JLabel("Nome: ");
    JLabel labelTel = new JLabel("Telefone: ");
    JLabel labelCpf = new JLabel("CPF: ");
    JLabel labelCEP = new JLabel("CEP: ");
    JLabel labelEmail = new JLabel("Email: ");
    
	JFrame frame = new JFrame();
	JTextField tNome;
	JTextField tEmail;
	JTextField tTel;
	JTextField tCPF;
	JTextField tCEP;
	JLabel titulo = new JLabel("Cliente");
	private static JButton enviar, deletar;
	private static JButton editar;

	
	static int index;
		
	
	public TelaAdicionarEditarCliente(int i, int index) {
		this.index = index;	
		
		JLabel labelNome = new JLabel("Nome: ");
        JLabel labelTel = new JLabel("Telefone: ");
        JLabel labelCpf = new JLabel("CPF: ");
        JLabel labelCEP = new JLabel("CEP: ");
        JLabel labelEmail = new JLabel("Email: ");
        
    	//JFrame frame = new JFrame();
    	JTextField tNome;
    	JTextField tEmail;
    	JTextField tTel;
    	JTextField tCPF;
    	JTextField tCEP;
    	JLabel titulo = new JLabel("Cliente");
    	//JButton enviar, editar, deletar;
    	
    	editar = new JButton("Salvar");
    	editar.setBounds(100, 200, 150, 30);
    	
    	enviar = new JButton("Salvar");
    	enviar.setBounds(100, 200, 150, 30);
    	
    	if(i == 2) {
    		this.tNome = new JTextField(String.valueOf(ControleCliente.listaCliente.get(index).getNome()), 40);
    		this.tEmail = new JTextField(String.valueOf(ControleCliente.listaCliente.get(index).getEmail()),40);
    		this.tTel = new JTextField(String.valueOf(ControleCliente.listaCliente.get(index).getTelefone()),40);
    		this.tCPF = new JTextField(String.valueOf(ControleCliente.listaCliente.get(index).getCPF()),40);
    		this.tCEP = new JTextField(String.valueOf(ControleCliente.listaCliente.get(index).getCEP()),40);
        	
        	
        	deletar = new JButton("Deletar");
        	deletar.setBounds(300, 200, 150, 30);
        	deletar.addActionListener(this);
        	frame.add(deletar);
        	frame.add(editar);
        	
        	
    	}else {
    		this.tNome = new JTextField(40);
    		this.tEmail = new JTextField(40);
    		this.tTel = new JTextField(40);
    		this.tCPF = new JTextField(40);
    		this.tCEP = new JTextField(40);
        	enviar = new JButton("Cadastrar");
        	enviar.setBounds(100, 200, 150, 30);
        	
        	frame.add(enviar);
        	
    	}
    	
    	titulo.setBounds(100, 30, 200, 40);
    	titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    	
    	frame.setSize(600, 300);
		frame.setLayout(null);
		
		labelNome.setBounds(100, 80, 200, 20);
		this.tNome.setBounds(220, 80, 240, 20);
		labelEmail.setBounds(100, 100, 200, 20);
		this.tEmail.setBounds(220, 100, 240, 20);
		labelTel.setBounds(100, 120, 200, 20);
		this.tTel.setBounds(220, 120, 240, 20);
		labelCpf.setBounds(100, 140, 200, 20);
		this.tCPF.setBounds(220, 140, 240, 20);
		labelCEP.setBounds(100,160, 200, 20);
		this.tCEP.setBounds(220, 160, 240, 20);
		
		//this.enviar.setBounds(100, 200, 150, 30);
		
		
		frame.add(titulo);
		frame.add(labelNome);
		frame.add(this.tNome);
		frame.add(labelTel);
		frame.add(this.tTel);
		frame.add(labelCpf);
		frame.add(this.tCPF);
		frame.add(labelCEP);
		frame.add(this.tCEP);
		frame.add(labelEmail);
		frame.add(this.tEmail);		
		
		
		//this.enviar.addActionListener(this);
		
		editar.addActionListener(this);
		enviar.addActionListener(this);
		frame.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == enviar) {
			System.out.println(String.valueOf(tNome.getText()));
			Cliente c = new Cliente(String.valueOf(tNome.getText()), String.valueOf(tTel.getText()), String.valueOf(tEmail.getText()), String.valueOf(tCPF.getText()), String.valueOf(tCEP.getText()));
			ControleCliente.adicionar(c);
			//ControleCliente.exibir();
			JOptionPane.showMessageDialog(null, "Cliente adicionado!");
		}
		if(src == editar) {
			Cliente c = new Cliente(String.valueOf(tNome.getText()), String.valueOf(tTel.getText()), String.valueOf(tEmail.getText()), String.valueOf(tCPF.getText()), String.valueOf(tCEP.getText()));
			ControleCliente.editar(this.index, c);
			JOptionPane.showMessageDialog(null, "Editado!");
		}
		if(src == deletar) {
			ControleCliente.excluir(this.index);
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Cliente Deletado!"); 
			
			
		}	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
