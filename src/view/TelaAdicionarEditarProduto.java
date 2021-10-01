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
import entities.ControleProduto;
import modelo.Cliente;
import modelo.Creme;
import modelo.Kit;
import modelo.Perfume;
import modelo.Sabonete;

public class TelaAdicionarEditarProduto implements ActionListener, ListSelectionListener{

	JFrame frame = new JFrame();
	
	JLabel titulo;
	JLabel labelNome = new JLabel("Nome: ");
    JLabel labelMarca = new JLabel("Marca: ");
    JLabel labelPreco = new JLabel("Preço: ");
    JLabel labelDescricao = new JLabel("Descrição: ");
    JLabel labelVolume = new JLabel("Volume: ");
    JLabel labelGenero = new JLabel("Genero: ");
    JLabel labelFamiliaOufativa = new JLabel("Famíla Oufativa: ");
    JLabel labelTipo = new JLabel("Tipo:");
	JLabel labelPiramideOufativa = new JLabel("Piramide Oufativa: ");
	JLabel labelTipoPele = new JLabel("Tipo de pele: ");
	JLabel labelMassa = new JLabel("Massa: ");
	//JTextField tVolume = new JTextField();
	
	JTextField tGenero = new JTextField();
	JTextField tFamiliaOufativa = new JTextField();
	JTextField tNome;
	JTextField tMarca;
	JTextField tPreco;
	JTextField tDescricao;
	JTextField tTipo;
	JTextField tVolume;
	JTextField tPiramideOufativa;
	JTextField tTipoPele;
	JTextField tMassa;
	
	JButton enviar, cadastrar, deletar;
	
	static int aux;
	static int index;

	public TelaAdicionarEditarProduto(int v) {
		TelaAdicionarEditarProduto.aux=v;
		
		JFrame frame = new JFrame();
		
	    //JTextField tVolume;
    	
    	JLabel titulo = new JLabel("Produto");
		
		this.tNome = new JTextField(40);
		this.tMarca = new JTextField(40);
		this.tPreco = new JTextField(40);
		this.tDescricao = new JTextField(40);
		this.tVolume = new JTextField(40);
		this.tGenero = new JTextField();
		this.tFamiliaOufativa = new JTextField(40);
		
		this.tTipo = new JTextField(40);
		this.tVolume = new JTextField(40);
		this.tPiramideOufativa = new JTextField(40);
		this.tTipoPele = new JTextField(40);
		this.tMassa = new JTextField(40);
    	this.cadastrar = new JButton("Cadastrar");
    	

    	titulo.setBounds(100, 20, 200, 40);
    	titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    	
    	frame.setSize(600, 300);
		frame.setLayout(null);
		
		this.labelNome.setBounds(100, 50, 200, 20);
		this.tNome.setBounds(230, 50, 240, 20);
		this.labelMarca.setBounds(100, 70, 200, 20);
		this.tMarca.setBounds(230, 70, 240, 20);
		this.labelPreco.setBounds(100, 90, 200, 20);
		this.tPreco.setBounds(230, 90, 240, 20);
		this.labelDescricao.setBounds(100, 110, 200, 20);
		this.tDescricao.setBounds(230, 110, 240, 20);
		
		//this.tCEP.setBounds(220, 160, 240, 20);
		
		this.cadastrar.setBounds(100, 210, 150, 30);
				
		frame.add(titulo);
		frame.add(this.labelNome);
		frame.add(this.tNome);
		frame.add(this.labelMarca);
		frame.add(this.tMarca);
		frame.add(this.labelPreco);
		frame.add(this.tPreco);
		frame.add(this.labelDescricao);
		frame.add(this.tDescricao);
		frame.add(this.cadastrar);
		
		this.cadastrar.addActionListener(this);
		
		if(v==1) {
			titulo.setText("Perfume");
    		
    		this.labelVolume.setBounds(100, 130, 200, 20);
    		this.labelGenero.setBounds(100, 150, 200, 20);
    		this.labelFamiliaOufativa.setBounds(100, 170, 200, 20);
    		
    		this.tVolume.setBounds(230, 130, 240, 20);
    		this.tGenero.setBounds(230, 150, 240, 20);
    		this.tFamiliaOufativa.setBounds(230, 170, 240, 20);
    		
    		frame.add(this.labelVolume);
    		frame.add(this.labelGenero);
    		frame.add(this.labelFamiliaOufativa);
    		frame.add(this.tVolume);
    		frame.add(this.tGenero);
    		frame.add(this.tFamiliaOufativa);
    		
		}
		if(v==2) {
			titulo.setText("Sabonete");
			
			JLabel labelVolume = new JLabel("Volume/Massa: ");
			
    		//tVolume = new JTextField();
    		
    		this.labelTipo.setBounds(100, 130, 200, 20);
    		labelVolume.setBounds(100, 150, 200, 20);
    		this.labelPiramideOufativa.setBounds(100, 170, 200, 20);
    		
    		
    		
    		tTipo.setBounds(230, 130, 240, 20);
    		this.tVolume.setBounds(230, 150, 240, 20);
    		tPiramideOufativa.setBounds(230, 170, 240, 20);
    		
    		frame.add(this.labelTipo);
    		frame.add(labelVolume);
    		frame.add(this.labelPiramideOufativa);
    		frame.add(this.tVolume);
    		frame.add(this.tTipo);
    		frame.add(this.tPiramideOufativa);
		}
		if(v==3) {
			titulo.setText("Creme");
			
    		this.labelTipo.setBounds(100, 130, 200, 20);
    		this.labelTipoPele.setBounds(100, 150, 200, 20);
    		this.labelMassa.setBounds(100, 170, 200, 20);
    		
    		this.tTipo.setBounds(230, 130, 240, 20);
    		this.tTipoPele.setBounds(230, 150, 240, 20);
    		this.tMassa.setBounds(230, 170, 240, 20);
    		
    		frame.add(this.labelTipo);
    		frame.add(this.labelTipoPele);
    		frame.add(this.labelMassa);
    		frame.add(this.tTipo);
    		frame.add(this.tTipoPele);
    		frame.add(this.tMassa);
		}
		
		frame.setVisible(true);

	}
	public TelaAdicionarEditarProduto(int i, int index) {

		this.index = index;
		
    	JLabel titulo = new JLabel("Produto");
    	
    	this.tNome = new JTextField(String.valueOf(ControleProduto.lista.get(index).getNome()), 40);
    	this.tMarca = new JTextField(String.valueOf(ControleProduto.lista.get(index).getMarca()),40);
   		this.tPreco = new JTextField(String.valueOf(ControleProduto.lista.get(index).getPreco()),40);
   		this.tDescricao = new JTextField(String.valueOf(ControleProduto.lista.get(index).getDescricao()),40);
    		
        this.enviar = new JButton("Salvar");
        	
        deletar = new JButton("Deletar");
       	deletar.setBounds(300, 210, 150, 30);
        deletar.addActionListener(this);
        frame.add(deletar);
    	if(ControleProduto.lista.get(index).getClass() == Perfume.class) {
        	
        	Perfume per = (Perfume) ControleProduto.lista.get(index);

        	this.tVolume = new JTextField(String.valueOf(per.getVolume()));
        	this.tGenero = new JTextField(per.getGenero());
        	this.tFamiliaOufativa = new JTextField(per.getFamiliaOufativa());
        		
        	this.labelVolume.setBounds(100, 130, 200, 20);
        	this.labelGenero.setBounds(100, 150, 200, 20);
        	this.labelFamiliaOufativa.setBounds(100, 170, 200, 20);
        		
        	this.tVolume.setBounds(230, 130, 240, 20);
        	this.tGenero.setBounds(230, 150, 240, 20);
        	this.tFamiliaOufativa.setBounds(230, 170, 240, 20);
        		
        	frame.add(this.labelVolume);
        	frame.add(this.labelGenero);
        	frame.add(this.labelFamiliaOufativa);
        	frame.add(this.tVolume);
        	frame.add(this.tGenero);
        	frame.add(this.tFamiliaOufativa);
        }
    	
        if(ControleProduto.lista.get(index).getClass() == Sabonete.class) {
        	Sabonete sab = (Sabonete) ControleProduto.lista.get(index);
        		
        	this.labelTipo.setBounds(100, 130, 200, 20);
        	this.labelVolume.setBounds(100, 150, 200, 20);
        	this.labelPiramideOufativa.setBounds(100, 170, 200, 20);
        		
        	this.tTipo = new JTextField(sab.getTipo());
        	this.tVolume = new JTextField(String.valueOf(sab.getVolume()));
        	this.tPiramideOufativa = new JTextField(sab.getPiramideOufativa());
        		
        	this.tTipo.setBounds(230, 130, 240, 20);
        	this.tVolume.setBounds(230, 150, 240, 20);
        	this.tPiramideOufativa.setBounds(230, 170, 240, 20);
        		
        	frame.add(this.labelTipo);
        	frame.add(this.labelVolume);
        	frame.add(this.labelPiramideOufativa);
        	frame.add(this.tVolume);
        	frame.add(this.tTipo);
        	frame.add(this.tPiramideOufativa);
        	
        }
        if(ControleProduto.lista.get(index).getClass() == Creme.class) {        	
        	Creme cre = (Creme) ControleProduto.lista.get(index);

        	this.labelTipo.setBounds(100, 130, 200, 20);
        	this.labelTipoPele.setBounds(100, 150, 200, 20);
        	this.labelMassa.setBounds(100, 170, 200, 20);
        	
        	this.tTipo = new JTextField(cre.getTipoCreme());
        	this.tTipoPele = new JTextField(cre.getTipoPele());
        	this.tMassa = new JTextField(String.valueOf(cre.getMassa()));
        	
        	this.tTipo.setBounds(230, 130, 240, 20);
        	this.tTipoPele.setBounds(230, 150, 240, 20);
        	this.tMassa.setBounds(230, 170, 240, 20);
        	
        	frame.add(this.labelTipo);
        	frame.add(this.labelTipoPele);
        	frame.add(this.labelMassa);
        	frame.add(this.tTipo);
        	frame.add(this.tTipoPele);
        	frame.add(this.tMassa);        	
        }
        if(ControleProduto.lista.get(index).getClass() == Kit.class) {
        	
        	System.out.println(ControleProduto.lista.get(index).getClass());
        }

    	titulo.setBounds(100, 20, 200, 40);
    	titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    	
    	frame.setSize(600, 300);
		frame.setLayout(null);
		
		this.labelNome.setBounds(100, 50, 200, 20);
		this.tNome.setBounds(230, 50, 240, 20);
		this.labelMarca.setBounds(100, 70, 200, 20);
		this.tMarca.setBounds(230, 70, 240, 20);
		this.labelPreco.setBounds(100, 90, 200, 20);
		this.tPreco.setBounds(230, 90, 240, 20);
		this.labelDescricao.setBounds(100, 110, 200, 20);
		this.tDescricao.setBounds(230, 110, 240, 20);
		
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
		if(src == cadastrar) {
			
			if(TelaAdicionarEditarProduto.aux==1) {
				//System.out.println(tVolume.getText()+" -----------");
				Perfume p = new Perfume(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), Integer.valueOf(this.tVolume.getText()), String.valueOf(tGenero.getText()), String.valueOf(tFamiliaOufativa.getText()));
				//System.out.println(String.valueOf(tNome.getText()+' '+Double.valueOf(tPreco.getText())));
				ControleProduto.adicionar(p);
			}
			if(TelaAdicionarEditarProduto.aux==2) {
				Sabonete s = new Sabonete(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), String.valueOf(tTipo.getText()), Integer.valueOf(tVolume.getText()), String.valueOf(tPiramideOufativa.getText()));
				ControleProduto.adicionar(s);
			}
			if(TelaAdicionarEditarProduto.aux==3) {
				Creme c = new Creme(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), String.valueOf(tTipoPele.getText()), String.valueOf(tTipo.getText()), Integer.valueOf(tMassa.getText()));
				ControleProduto.adicionar(c);
			}
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Produto Adicionado!");
		}
		if(src == enviar) {
			if(ControleProduto.lista.get(TelaAdicionarEditarProduto.index).getClass() == Perfume.class) {
				Perfume p = new Perfume(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), Integer.valueOf(this.tVolume.getText()), String.valueOf(tGenero.getText()), String.valueOf(tFamiliaOufativa.getText()));
				ControleProduto.editar(TelaAdicionarEditarProduto.index, p);
			}
			if(ControleProduto.lista.get(TelaAdicionarEditarProduto.index).getClass() == Sabonete.class) {
				Sabonete s = new Sabonete(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), String.valueOf(tTipo.getText()), Integer.valueOf(tVolume.getText()), String.valueOf(tPiramideOufativa.getText()));
				ControleProduto.editar(TelaAdicionarEditarProduto.index, s);
			}
			if(ControleProduto.lista.get(TelaAdicionarEditarProduto.index).getClass() == Creme.class) {
				Creme c = new Creme(String.valueOf(tNome.getText()), String.valueOf(tMarca.getText()), Double.valueOf(tPreco.getText()), String.valueOf(tDescricao.getText()), String.valueOf(tTipoPele.getText()), String.valueOf(tTipo.getText()), Integer.valueOf(tMassa.getText()));
				ControleProduto.editar(TelaAdicionarEditarProduto.index, c);
			}
			if(ControleProduto.lista.get(TelaAdicionarEditarProduto.index).getClass() == Kit.class) {
				
				//ControleProduto.editar(TelaAdicionarEditarProduto.index, p);
			}
			//ControleProduto.editar(TelaAdicionarEditarProduto.index, p);
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Produto Editado!");
			
		}
		if(src == deletar) {
			ControleProduto.excluir(TelaAdicionarEditarProduto.index); 
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Produto Deletado!"); 
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}