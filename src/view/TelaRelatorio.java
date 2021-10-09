package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import entities.DadoVenda;

/**
 * Classe que exibe tela de relatorio de vendas
 * @author samuel
 * @version 1.0
 */
public class TelaRelatorio implements ActionListener {
	
	private static JFrame frame = new JFrame("Loja de Perfume");
	private static JLabel titulo = new JLabel("Menu Inicial");
	private static JLabel labelBusca = new JLabel("Buscar por dada:");
	private static JLabel labelEdita = new JLabel("Editar venda:");
	private static JComboBox comboData= new JComboBox(DadoVenda.getListaData().toArray());//ajustar datas
	private JButton pesquisar = new JButton("Buscar");
	private JButton atualizar = new JButton("Atualizar");
	private JButton editar = new JButton("Editar");
	
	private JList listaVenda = new JList(DadoVenda.getListaRelatorio().toArray());
	
	JScrollPane scroll = new JScrollPane(listaVenda);
	
	public TelaRelatorio() {
		frame.setSize(600, 300);
		frame.setLayout(null);
		labelBusca.setBounds(350, 40, 180, 20);
		labelEdita.setBounds(350, 120, 180, 20);
		comboData.setBounds(480, 40, 110, 20);
		scroll.setBounds(40, 40, 300, 150);
		pesquisar.setBounds(480, 70, 100, 20);
		atualizar.setBounds(350, 200, 100, 20);
		editar.setBounds(480, 120, 100, 20);
		
		frame.add(pesquisar);
		frame.add(labelBusca);
		frame.add(labelEdita);
		frame.add(comboData);
		frame.add(atualizar);
		frame.add(editar);
		frame.add(scroll);
		
		pesquisar.addActionListener(this);
		editar.addActionListener(this);
		atualizar.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		
		if(src == pesquisar) {
			new TelaFiltroVenda((String)comboData.getSelectedItem());
			//listaVenda.setListData(DadoVenda.buscarPorData((String)comboData.getSelectedItem()).toArray());
			//System.out.println(comboData.getSelectedItem());
		}
		if(src == editar) {
			new TelaEditarVenda(listaVenda.getSelectedIndex());
		}
		if(src == atualizar) {
			listaVenda.setListData(DadoVenda.getListaRelatorio().toArray());
		}
	}
}
