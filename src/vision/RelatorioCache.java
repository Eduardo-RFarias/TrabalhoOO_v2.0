package vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import control.RelatorioCacheControl;

/**
 * JPanel para mostrar um relatorio de atores e diretores.
 * 
 * Herda a classe JRelatorios que contém um fundo, título e um botão.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioCache extends JRelatorios {

	private static final long serialVersionUID = -5775661600224506181L;
	private JComboBox<Object> fieldAtor;
	private JScrollPane scrollPane;
	private JTextArea fieldRelatorio;
	private RelatorioCacheControl controller;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public RelatorioCache() {
		super("Relatorio do cache dos atores");

		controller = new RelatorioCacheControl(this);

		JLabel lblNewLabel = new JLabel("Escolha o ator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(JCampos.FONT);
		lblNewLabel.setBounds(49, 135, 162, 21);
		add(lblNewLabel);

		fieldAtor = new JComboBox<>();
		fieldAtor.addActionListener(this);
		fieldAtor.setBounds(71, 168, 113, 21);
		add(fieldAtor);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 109, 512, 295);
		add(scrollPane);

		fieldRelatorio = new JTextArea();
		fieldRelatorio.setFont(new Font("Algerian", Font.PLAIN, 12));
		scrollPane.setViewportView(fieldRelatorio);
		fieldRelatorio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldRelatorio.setBackground(new Color(245, 245, 220));
		fieldRelatorio.setEditable(false);
	}

	public JComboBox<Object> getFieldAtor() {
		return fieldAtor;
	}

	public JTextArea getFieldRelatorio() {
		return fieldRelatorio;
	}

	public RelatorioCacheControl getController() {
		return controller;
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
