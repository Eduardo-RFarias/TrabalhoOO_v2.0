package vision;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.CadastrarPapelControl;

/**
 * JPanel para cadastrar um estúdio.
 * 
 * Herda a classe JCampos que contém um fundo, título e dois botões.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarPapel extends JCampos {
	private static final long serialVersionUID = 1665096962737282898L;
	private JTextField fieldNomePersonagem;
	private JTextField fieldCache;
	private JLabel labelNomeAtor;
	private CadastrarPapelControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarPapel() {
		super("Cadastre o papel desse ator");
		controller = new CadastrarPapelControl(this);

		JLabel labelNomePersonagem = new JLabel("Nome do personagem:");
		labelNomePersonagem.setFont(JCampos.FONT);
		labelNomePersonagem.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNomePersonagem.setBounds(157, 228, 226, 13);
		add(labelNomePersonagem);

		JLabel labelCache = new JLabel("Cache:");
		labelCache.setFont(JCampos.FONT);
		labelCache.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCache.setBounds(157, 293, 226, 13);
		add(labelCache);

		fieldNomePersonagem = new JTextField();
		labelNomePersonagem.setLabelFor(fieldNomePersonagem);
		fieldNomePersonagem.setBounds(393, 225, 149, 19);
		add(fieldNomePersonagem);
		fieldNomePersonagem.setColumns(10);

		fieldCache = new JTextField();
		labelCache.setLabelFor(fieldCache);
		fieldCache.setBounds(393, 293, 149, 19);
		add(fieldCache);
		fieldCache.setColumns(10);

		labelNomeAtor = new JLabel("");
		labelNomeAtor.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeAtor.setFont(JCampos.FONT);
		labelNomeAtor.setBounds(56, 170, 712, 13);
		add(labelNomeAtor);
	}

	public JTextField getFieldNomePersonagem() {
		return fieldNomePersonagem;
	}

	public JTextField getFieldCache() {
		return fieldCache;
	}

	public CadastrarPapelControl getController() {
		return controller;
	}

	public JLabel getLabelNomeAtor() {
		return labelNomeAtor;
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
