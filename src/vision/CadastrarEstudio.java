package vision;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import control.CadastrarEstudioControl;

/**
 * JPanel para cadastrar um estúdio.
 * 
 * Herda a classe JCampos que contém um fundo, título e dois botões.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarEstudio extends JCampos {
	private static final long serialVersionUID = -7318790884045444829L;
	private JTextField fieldNome;
	private JTextField fieldDono;
	private JTextField fieldFaturamento;
	private JFormattedTextField ftfieldData;
	private CadastrarEstudioControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarEstudio() {
		super("Cadastre um novo estudio");

		controller = new CadastrarEstudioControl(this);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(JCampos.FONT);
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setBounds(169, 195, 175, 13);
		add(labelNome);

		JLabel labelDono = new JLabel("Dono:");
		labelDono.setFont(JCampos.FONT);
		labelDono.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDono.setBounds(169, 243, 175, 13);
		add(labelDono);

		JLabel labelData = new JLabel("Data de funda\u00E7\u00E3o:");
		labelData.setFont(JCampos.FONT);
		labelData.setHorizontalAlignment(SwingConstants.RIGHT);
		labelData.setBounds(158, 297, 186, 13);
		add(labelData);

		JLabel labelFaturamento = new JLabel("Faturamento do ano anterior:");
		labelFaturamento.setFont(JCampos.FONT);
		labelFaturamento.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFaturamento.setBounds(82, 343, 262, 13);
		add(labelFaturamento);

		fieldNome = new JTextField();
		labelNome.setLabelFor(fieldNome);
		fieldNome.setBounds(405, 192, 147, 19);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldDono = new JTextField();
		labelDono.setLabelFor(fieldDono);
		fieldDono.setBounds(405, 240, 147, 19);
		add(fieldDono);
		fieldDono.setColumns(10);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		ftfieldData = new JFormattedTextField(mascaraData);
		labelData.setLabelFor(ftfieldData);
		ftfieldData.setBounds(405, 294, 147, 19);
		add(ftfieldData);

		fieldFaturamento = new JTextField();
		labelFaturamento.setLabelFor(fieldFaturamento);
		fieldFaturamento.setBounds(405, 340, 147, 19);
		add(fieldFaturamento);
		fieldFaturamento.setColumns(10);
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldDono() {
		return fieldDono;
	}

	public JTextField getFieldFaturamento() {
		return fieldFaturamento;
	}

	public JFormattedTextField getFieldData() {
		return ftfieldData;

	}

	public CadastrarEstudioControl getController() {
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