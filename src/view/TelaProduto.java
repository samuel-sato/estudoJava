package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import modelo.Produto;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.ControleCliente;
import entities.ControleProduto;
import entities.Dado;


public class TelaProduto implements ActionListener, ListSelectionListener{

	private int index;

	private static JFrame frame;
	private static JLabel titulo;
	private static JButton novoProduto;
	private static JButton editar;
	private static JButton atualizar;
	private JList lista1 = new JList(Dado.nomeProduto(ControleProduto.lista).toArray());
	
	private JLabel labelNome;
    private JLabel labelMarca = new JLabel("Marca: ");
    private JLabel labelPreco = new JLabel("Preço: ");
    private JLabel labelDescricao = new JLabel("Descrição: ");
    
	
    JScrollPane scroll1 = new JScrollPane(lista1);
    

    public TelaProduto() {
    	frame = new JFrame("Produtos");
    	titulo = new JLabel("Lista de Produtos");
    	novoProduto = new JButton("Novo Produto");
    	editar = new JButton("Editar Produto");
    	atualizar = new JButton("Atualizar lista");

    	labelNome = new JLabel("Nome: ");
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setBounds(100, 10, 250, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		novoProduto.setBounds(100, 45, 150, 20);
		editar.setBounds(350, 45, 150, 20);
		atualizar.setBounds(100, 200, 150, 20);
		scroll1.setBounds(100, 80, 200, 120);
		
		labelNome.setBounds(320, 80, 200, 20);
		labelMarca.setBounds(320, 100, 200, 20);
		labelPreco.setBounds(320, 120, 200, 20);
		labelDescricao.setBounds(320,140, 200, 20);
		
		frame.add(scroll1);
		frame.add(titulo);
		frame.add(novoProduto);
		frame.add(editar);
		frame.add(labelNome);
		frame.add(labelMarca);
		frame.add(labelPreco);
		frame.add(labelDescricao);
		frame.add(atualizar);
		
		lista1.addListSelectionListener(this);

		novoProduto.addActionListener(this);
		editar.addActionListener(this);
		atualizar.addActionListener(this);
		frame.setVisible(true);
	}
    
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		this.index = lista1.getSelectedIndex();
		updateLabels(this.index);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == novoProduto) {
			//new TelaAdicionarEditarProduto(1, index);			
			new EscolhaProduto();
		}
		if(src == editar) {
			try {
				new TelaAdicionarEditarProduto(2, index);
			} catch(IndexOutOfBoundsException ex){
				
			}
			
		}
		if(src ==atualizar) {
			try {
				lista1.setListData(Dado.nomeProduto(ControleProduto.lista).toArray());
				lista1.updateUI();
			} catch (IndexOutOfBoundsException ex){
				//updateLabels((this.index)+1);
				//System.out.println("deu erro");
			}	

		}

	}
	public void updateLabels(int n) {
		labelNome.setText("Nome: "+ControleProduto.lista.get(n).getNome());
		labelMarca.setText("Marca: "+ControleProduto.lista.get(n).getMarca());
		labelPreco.setText("Preço: "+ControleProduto.lista.get(n).getPreco());
		labelDescricao.setText("Descrição: "+ControleProduto.lista.get(n).getDescricao());
	}
	
	
}
