package vision;

import java.awt.event.ActionEvent;

import control.RelatorioAtoresDiretoresControl;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;

/**
 * JPanel para mostrar um relatorio de atores e diretores.
 * 
 * Herda a classe JRelatorios que contém um fundo, título e um botão.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioAtoresDiretores extends JRelatorios {
	private static final long serialVersionUID = 8666047587238744431L;

	private RelatorioAtoresDiretoresControl controller;

	private JTextArea fieldRelatorio;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public RelatorioAtoresDiretores() {
		super("Relatorio de atores e diretores");

		controller = new RelatorioAtoresDiretoresControl(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 95, 723, 309);
		add(scrollPane);

		fieldRelatorio = new JTextArea();
		scrollPane.setViewportView(fieldRelatorio);
		fieldRelatorio.setFont(new Font("Algerian", Font.PLAIN, 14));
		fieldRelatorio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldRelatorio.setBackground(new Color(245, 245, 220));
	}

	public RelatorioAtoresDiretoresControl getController() {
		return controller;
	}

	public JTextArea getFieldRelatorio() {
		return fieldRelatorio;
	}

	/**
	 * Executa o comando para o botão selecionado.
	 * 
	 * implementação da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}
}
