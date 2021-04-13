package vision;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import control.NovoAtorControl;

import java.awt.Color;

/**
 * JPanel para cadastrar um estúdio.
 * 
 * Herda a classe JCampos que contém um fundo, título e dois botões.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarNovoAtor extends JCampos {
	private static final long serialVersionUID = 3798826210256319527L;
	private JTextField fieldNome;
	private JTextField fieldIdade;
	private JTextField fieldNacionalidade;
	private JTextField fieldSeguro;
	private JComboBox<String> fieldSexo;
	private JLabel labelPapeisPossiveis;
	private JTextArea fieldPapeisPossiveis;
	private NovoAtorControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarNovoAtor() {
		super("Cadastre um novo ator");

		controller = new NovoAtorControl(this);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(FONT);
		labelNome.setBounds(78, 182, 287, 21);
		add(labelNome);

		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIdade.setFont(FONT);
		labelIdade.setBounds(78, 216, 287, 21);
		add(labelIdade);

		JLabel labelNacionalidade = new JLabel("Nacionalidade:");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNacionalidade.setFont(FONT);
		labelNacionalidade.setBounds(78, 257, 287, 21);
		add(labelNacionalidade);

		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSexo.setFont(FONT);
		labelSexo.setBounds(78, 292, 287, 26);
		add(labelSexo);

		JLabel labelSeguro = new JLabel("Numero do seguro social:");
		labelSeguro.setFont(FONT);
		labelSeguro.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSeguro.setBounds(78, 328, 287, 28);
		add(labelSeguro);

		labelPapeisPossiveis = new JLabel("Papeis Possiveis (um por linha):");
		labelPapeisPossiveis.setFont(FONT);
		labelPapeisPossiveis.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPapeisPossiveis.setBounds(88, 385, 277, 13);
		add(labelPapeisPossiveis);

		fieldNome = new JTextField();
		fieldNome.setBounds(398, 181, 198, 24);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldIdade = new JTextField();
		fieldIdade.setBounds(398, 215, 198, 24);
		add(fieldIdade);
		fieldIdade.setColumns(10);

		fieldNacionalidade = new JTextField();
		fieldNacionalidade.setBounds(398, 256, 198, 24);
		add(fieldNacionalidade);
		fieldNacionalidade.setColumns(10);

		fieldSexo = new JComboBox<>();
		fieldSexo.setFont(FONT);
		fieldSexo.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro" }));
		fieldSexo.setBounds(398, 290, 198, 30);
		add(fieldSexo);

		fieldSeguro = new JTextField();
		fieldSeguro.setBounds(398, 330, 198, 26);
		add(fieldSeguro);
		fieldSeguro.setColumns(10);

		fieldPapeisPossiveis = new JTextArea();
		fieldPapeisPossiveis.setBorder(new LineBorder(new Color(0, 0, 0)));
		fieldPapeisPossiveis.setBounds(398, 366, 198, 68);
		add(fieldPapeisPossiveis);
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldIdade() {
		return fieldIdade;
	}

	public JTextField getFieldNacionalidade() {
		return fieldNacionalidade;
	}

	public JTextField getFieldSeguro() {
		return fieldSeguro;
	}

	public JComboBox<String> getFieldSexo() {
		return fieldSexo;
	}

	public JTextArea getFieldPapeisPossiveis() {
		return fieldPapeisPossiveis;
	}

	public NovoAtorControl getController() {
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
