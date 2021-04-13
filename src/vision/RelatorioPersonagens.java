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

import control.RelatorioPersonagensControl;

/**
 * JPanel para mostrar um relatorio de personagens.
 * 
 * Herda a classe JRelatorios que contém um fundo, título e um botão.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioPersonagens extends JRelatorios {
	private static final long serialVersionUID = 4858476353847442512L;
	private JComboBox<Object> fieldAtor;
	private JTextArea fieldRelatorio;
	private RelatorioPersonagensControl controller;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public RelatorioPersonagens() {
		super("Relatorio de personagens de um ator");

		controller = new RelatorioPersonagensControl(this);

		JLabel lblNewLabel = new JLabel("Escolha o ator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(JCampos.FONT);
		lblNewLabel.setBounds(49, 135, 162, 21);
		add(lblNewLabel);

		fieldAtor = new JComboBox<>();
		fieldAtor.addActionListener(this);
		fieldAtor.setBounds(71, 168, 113, 21);
		add(fieldAtor);

		JScrollPane scrollPane = new JScrollPane();
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

	public RelatorioPersonagensControl getController() {
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
