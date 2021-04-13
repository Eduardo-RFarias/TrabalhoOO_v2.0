package vision;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import control.CadastrarAtorControl;
import javax.swing.JScrollPane;

/**
 * JPanel para selecionar atores para o filme.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarAtores extends JPanel implements ActionListener {
	private static final long serialVersionUID = 3378863774624440091L;
	private JList<String> fieldAtores;
	private JButton buttonSelecionar;
	private JButton buttonNovoAtor;
	private JButton buttonFinalizar;
	private CadastrarAtorControl controller;

	/**
	 * Cria o panel com uma lista com botão, um botão para cadastrar um novo ator e
	 * um botão para finalizar o cadastro.
	 */
	public CadastrarAtores() {
		controller = new CadastrarAtorControl(this);

		setBackground(new Color(245, 245, 220));
		setLayout(null);
		setBounds(100, 100, 830, 522);

		JLabel labelTitulo = new JLabel("Quais atores est\u00E3o no filme?");
		labelTitulo.setFont(JCampos.FONT);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(278, 61, 254, 13);
		add(labelTitulo);

		JLabel labelTitulo2 = new JLabel("Escolha um ator existente ou Cadastre um novo ator");
		labelTitulo2.setFont(JCampos.FONT);
		labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo2.setBounds(108, 84, 602, 13);
		add(labelTitulo2);

		JLabel labelLista = new JLabel("Lista:");
		labelLista.setHorizontalAlignment(SwingConstants.CENTER);
		labelLista.setFont(JCampos.FONT);
		labelLista.setBounds(367, 114, 68, 13);
		add(labelLista);

		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.setForeground(new Color(153, 51, 102));
		buttonSelecionar.setFont(JCampos.FONT);
		buttonSelecionar.setBackground(Color.LIGHT_GRAY);
		buttonSelecionar.setBounds(122, 429, 117, 21);
		buttonSelecionar.addActionListener(this);
		add(buttonSelecionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 132, 588, 289);
		add(scrollPane);

		fieldAtores = new JList<>();
		scrollPane.setViewportView(fieldAtores);
		fieldAtores.setModel(controller.atualizarModeloLista());
		fieldAtores.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		fieldAtores.setFont(JCampos.FONT);
		fieldAtores.setForeground(Color.BLACK);
		fieldAtores.setBackground(new Color(245, 245, 220));

		buttonNovoAtor = new JButton("Novo ator");
		buttonNovoAtor.setFont(JCampos.FONT);
		buttonNovoAtor.setForeground(Color.BLACK);
		buttonNovoAtor.setBackground(SystemColor.activeCaption);
		buttonNovoAtor.setBounds(122, 463, 182, 49);
		buttonNovoAtor.addActionListener(this);
		add(buttonNovoAtor);

		buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setEnabled(false);
		buttonFinalizar.setForeground(new Color(153, 0, 0));
		buttonFinalizar.setFont(JCampos.FONT);
		buttonFinalizar.setBackground(Color.LIGHT_GRAY);
		buttonFinalizar.setBounds(601, 477, 107, 21);
		buttonFinalizar.addActionListener(this);
		add(buttonFinalizar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, 0, 830, 522);
		labelFundo.setIcon(new ImageIcon(CadastrarAtores.class.getResource("/vision/images/iconCurtain.png")));
		add(labelFundo);
	}

	public JList<String> getFieldAtores() {
		return fieldAtores;
	}

	public JButton getButtonSelecionar() {
		return buttonSelecionar;
	}

	public JButton getButtonNovoAtor() {
		return buttonNovoAtor;
	}

	public CadastrarAtorControl getController() {
		return controller;
	}

	public JButton getButtonFinalizar() {
		return buttonFinalizar;
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