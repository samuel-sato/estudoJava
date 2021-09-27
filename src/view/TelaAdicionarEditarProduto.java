package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.ControleCliente;
import entities.ControleProduto;
import modelo.Cliente;
import modelo.Creme;
import modelo.Kit;
import modelo.Perfume;
import modelo.Sabonete;

public class TelaAdicionarEditarProduto implements ActionListener, ListSelectionListener{

	JLabel labelNome = new JLabel("Nome: ");
    JLabel labelMarca = new JLabel("Marca: ");
    JLabel labelPreco = new JLabel("Preço: ");
    JLabel labelDescricao = new JLabel("Descrição: ");
    
	JFrame frame = new JFrame();
	JTextField tNome;
	JTextField tMarca;
	JTextField tPreco;
	JTextField tDescricao;
	JTextField tCEP;
	JLabel titulo = new JLabel("Cliente");
	JButton enviar, deletar;
		
	
	public TelaAdicionarEditarProduto(int i, int index) {
		
		JLabel labelNome = new JLabel("Nome: ");
		JLabel labelMarca = new JLabel("Marca: ");
	    JLabel labelPreco = new JLabel("Preço: ");
	    JLabel labelDescricao = new JLabel("Descrição: ");
        
    	JFrame frame = new JFrame();
    	JTextField tNome;
		JTextField tMarca;
    	JTextField tPreco;
    	JTextField tDescricao;
    	
    	JLabel titulo = new JLabel("Produto");
    	JButton enviar, deletar;
    	
    	//Verificar se é Perfume/Sabonete/Creme
    	if(ControleProduto.lista.get(index).getClass() == Perfume.class) {
    		System.out.println(ControleProduto.lista.get(index).getClass());
    		JLabel labelVolume = new JLabel("Volume: ");
    		JLabel labelGenero = new JLabel("Genero: ");
    		JLabel labelFamiliaOufativa = new JLabel("Famíla Oufativa: ");
    		
    		labelVolume.setBounds(100, 150, 200, 20);
    		labelGenero.setBounds(100, 170, 200, 20);
    		labelFamiliaOufativa.setBounds(100, 190, 200, 20);
    		
    		JTextField tVolume = new JTextField();
    		JTextField tGenero = new JTextField();
    		JTextField tFamiliaOufativa = new JTextField();
    		
    		tVolume.setBounds(220, 150, 240, 20);
    		tGenero.setBounds(220, 170, 240, 20);
    		tFamiliaOufativa.setBounds(220, 190, 240, 20);
    		
    		frame.add(labelVolume);
    		frame.add(labelGenero);
    		frame.add(labelFamiliaOufativa);
    		frame.add(tVolume);
    		frame.add(tGenero);
    		frame.add(tFamiliaOufativa);
    	}
    	if(ControleProduto.lista.get(index).getClass() == Sabonete.class) {
    		System.out.println(ControleProduto.lista.get(index).getClass());
    	}
    	if(ControleProduto.lista.get(index).getClass() == Creme.class) {
    		System.out.println(ControleProduto.lista.get(index).getClass());
    	}
    	if(ControleProduto.lista.get(index).getClass() == Kit.class) {
    		System.out.println(ControleProduto.lista.get(index).getClass());
    	}
    	
    	    	
    	
    	
    	if(i == 2) {
    		this.tNome = new JTextField(String.valueOf(ControleProduto.lista.get(index).getNome()), 40);
    		this.tMarca = new JTextField(String.valueOf(ControleProduto.lista.get(index).getMarca()),40);
    		this.tPreco = new JTextField(String.valueOf(ControleProduto.lista.get(index).getPreco()),40);
    		this.tDescricao = new JTextField(String.valueOf(ControleProduto.lista.get(index).getDescricao()),40);
    		
        	this.enviar = new JButton("Salvar");
        	
        	deletar = new JButton("Deletar");
        	deletar.setBounds(300, 210, 150, 30);
        	deletar.addActionListener(this);
        	frame.add(deletar);
    	}else {
    		this.tNome = new JTextField(40);
    		this.tMarca = new JTextField(40);
    		this.tPreco = new JTextField(40);
    		this.tDescricao = new JTextField(40);
    		//this.tCEP = new JTextField(40);
        	this.enviar = new JButton("Cadastrar");
    	}
    	
    	titulo.setBounds(100, 20, 200, 40);
    	titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    	
    	frame.setSize(600, 300);
		frame.setLayout(null);
		
		labelNome.setBounds(100, 70, 200, 20);
		this.tNome.setBounds(220, 70, 240, 20);
		labelMarca.setBounds(100, 90, 200, 20);
		this.tMarca.setBounds(220, 90, 240, 20);
		labelPreco.setBounds(100, 110, 200, 20);
		this.tPreco.setBounds(220, 110, 240, 20);
		labelDescricao.setBounds(100, 130, 200, 20);
		this.tDescricao.setBounds(220, 130, 240, 20);
		
		//this.tCEP.setBounds(220, 160, 240, 20);
		
		this.enviar.setBounds(100, 210, 150, 30);
		
		
		frame.add(titulo);
		frame.add(labelNome);
		frame.add(this.tNome);
		frame.add(labelMarca);
		frame.add(this.tMarca);
		frame.add(labelPreco);
		frame.add(this.tPreco);
		frame.add(labelDescricao);
		frame.add(this.tDescricao);
		
				
		frame.add(this.enviar);
		
		this.enviar.addActionListener(this);
		
		
		frame.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == enviar) {
			/*
			System.out.println(String.valueOf(tNome.getText()));
			Cliente c = new Cliente(String.valueOf(tNome.getText()), String.valueOf(tPreco.getText()), String.valueOf(tMarca.getText()), String.valueOf(tDescricao.getText()), String.valueOf(tCEP.getText()));
			ControleCliente.adicionar(c);
			ControleCliente.exibir();
			*/
		}
		if(src == deletar) {
			//inplementar 
		}	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
