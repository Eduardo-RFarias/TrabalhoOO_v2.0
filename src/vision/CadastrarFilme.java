package vision;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.CadastrarFilmeControl;

/**
 * JPanel para cadastrar um filme.
 * 
 * Herda a classe JCampos que contém um fundo, título e dois botões.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarFilme extends JCampos {
	private static final long serialVersionUID = -7309653702183828956L;
	private JComboBox<Object> fieldEstudio;
	private JTextField fieldNome;
	private JTextField fieldMeses;
	private JTextField fieldAno;
	private JTextField fieldCopy;
	private JTextField fieldCusto;
	private JTextField fieldDiretor;
	private CadastrarFilmeControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarFilme() {
		super("Cadastre um novo filme");

		controller = new CadastrarFilmeControl(this);

		JLabel labelNome = new JLabel("Nome do filme:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(JCampos.FONT);
		labelNome.setBounds(169, 172, 175, 13);
		add(labelNome);

		JLabel labelEstudio = new JLabel("Estudio do filme:");
		labelEstudio.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEstudio.setFont(JCampos.FONT);
		labelEstudio.setBounds(169, 204, 175, 13);
		add(labelEstudio);

		JLabel labelMeses = new JLabel("Meses de desenvolvimento:");
		labelMeses.setFont(JCampos.FONT);
		labelMeses.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMeses.setBounds(82, 239, 262, 13);
		add(labelMeses);

		JLabel labelAno = new JLabel("Ano de lan\u00E7amento:");
		labelAno.setFont(JCampos.FONT);
		labelAno.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAno.setBounds(169, 283, 175, 13);
		add(labelAno);

		JLabel labelCopy = new JLabel("Numero de Copyright:");
		labelCopy.setFont(JCampos.FONT);
		labelCopy.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCopy.setBounds(158, 327, 186, 13);
		add(labelCopy);

		JLabel labelCusto = new JLabel("Custo total do filme:");
		labelCusto.setFont(JCampos.FONT);
		labelCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCusto.setBounds(82, 374, 262, 13);
		add(labelCusto);

		JLabel labelDiretor = new JLabel("Diretor:");
		labelDiretor.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDiretor.setFont(JCampos.FONT);
		labelDiretor.setBounds(169, 414, 175, 13);
		add(labelDiretor);

		fieldNome = new JTextField();
		fieldNome.setBounds(405, 169, 147, 19);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldEstudio = new JComboBox<>();
		labelEstudio.setLabelFor(fieldEstudio);
		fieldEstudio.setBounds(405, 200, 147, 21);
		fieldEstudio.setModel(controller.atualizarModelo());
		add(fieldEstudio);

		fieldMeses = new JTextField();
		labelMeses.setLabelFor(fieldMeses);
		fieldMeses.setBounds(405, 236, 147, 19);
		add(fieldMeses);
		fieldMeses.setColumns(10);

		fieldAno = new JTextField();
		labelAno.setLabelFor(fieldAno);
		fieldAno.setBounds(405, 280, 147, 19);
		add(fieldAno);
		fieldAno.setColumns(10);

		fieldCopy = new JTextField();
		labelCopy.setLabelFor(fieldCopy);
		fieldCopy.setBounds(405, 324, 147, 19);
		add(fieldCopy);
		fieldCopy.setColumns(10);

		fieldCusto = new JTextField();
		labelCusto.setLabelFor(fieldCusto);
		fieldCusto.setBounds(405, 371, 147, 19);
		add(fieldCusto);
		fieldCusto.setColumns(10);

		fieldDiretor = new JTextField();
		labelDiretor.setLabelFor(fieldDiretor);
		fieldDiretor.setBounds(405, 411, 147, 19);
		add(fieldDiretor);
		fieldDiretor.setColumns(10);

	}

	public JComboBox<Object> getFieldEstudio() {
		return fieldEstudio;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldMeses() {
		return fieldMeses;
	}

	public JTextField getFieldAno() {
		return fieldAno;
	}

	public JTextField getFieldCopy() {
		return fieldCopy;
	}

	public JTextField getFieldCusto() {
		return fieldCusto;
	}

	public JTextField getFieldDiretor() {
		return fieldDiretor;
	}

	public CadastrarFilmeControl getController() {
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