package vision;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.MenuControl;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * JPanel de menu.
 * 
 * @author Eduardo Rodrigues
 */
public class Menu extends JPanel implements ActionListener {
	private static final long serialVersionUID = -6180976424149762050L;
	private final JButton buttonRegistrarEstudio;
	private final JButton buttonMostrarPersonagens;
	private final JButton buttonMostrarCache;
	private final JButton buttonMostrarAtores;
	private final JButton buttonMostrarFilmes;
	private final JButton buttonAdicionarFilme;
	private final MenuControl controller;

	/**
	 * Cria o painel com um fundo e vários botões e textos.
	 */
	public Menu() {
		controller = new MenuControl(this);

		setBackground(new Color(245, 245, 220));
		setBounds(100, 100, 830, 522);
		setLayout(null);

		buttonAdicionarFilme = new JButton("Adicionar filmes a estudio");
		buttonAdicionarFilme.setEnabled(false);
		buttonAdicionarFilme.setBackground(Color.LIGHT_GRAY);
		buttonAdicionarFilme.setForeground(Color.BLACK);
		buttonAdicionarFilme.setFont(JCampos.FONT);
		buttonAdicionarFilme.setBounds(280, 213, 267, 31);
		buttonAdicionarFilme.addActionListener(this);
		add(buttonAdicionarFilme);

		buttonMostrarFilmes = new JButton("Mostrar filmes do estudio");
		buttonMostrarFilmes.setEnabled(false);
		buttonMostrarFilmes.setForeground(Color.BLACK);
		buttonMostrarFilmes.setBackground(Color.LIGHT_GRAY);
		buttonMostrarFilmes.setFont(JCampos.FONT);
		buttonMostrarFilmes.setBounds(280, 254, 267, 31);
		buttonMostrarFilmes.addActionListener(this);
		add(buttonMostrarFilmes);

		buttonMostrarAtores = new JButton("Mostrar atores e diretores");
		buttonMostrarAtores.setEnabled(false);
		buttonMostrarAtores.setFont(JCampos.FONT);
		buttonMostrarAtores.setBackground(Color.LIGHT_GRAY);
		buttonMostrarAtores.setForeground(Color.BLACK);
		buttonMostrarAtores.setBounds(280, 295, 267, 31);
		buttonMostrarAtores.addActionListener(this);
		add(buttonMostrarAtores);

		buttonMostrarCache = new JButton("Mostrar cache total do ator");
		buttonMostrarCache.setEnabled(false);
		buttonMostrarCache.setFont(JCampos.FONT);
		buttonMostrarCache.setBackground(Color.LIGHT_GRAY);
		buttonMostrarCache.setForeground(Color.BLACK);
		buttonMostrarCache.setBounds(280, 336, 267, 31);
		buttonMostrarCache.addActionListener(this);
		add(buttonMostrarCache);

		buttonMostrarPersonagens = new JButton("Mostrar personagens do ator");
		buttonMostrarPersonagens.setEnabled(false);
		buttonMostrarPersonagens.setFont(JCampos.FONT);
		buttonMostrarPersonagens.setBackground(Color.LIGHT_GRAY);
		buttonMostrarPersonagens.setForeground(Color.BLACK);
		buttonMostrarPersonagens.setBounds(280, 377, 267, 31);
		buttonMostrarPersonagens.addActionListener(this);
		add(buttonMostrarPersonagens);

		buttonRegistrarEstudio = new JButton("Registrar novo Estudio");
		buttonRegistrarEstudio.setFont(JCampos.FONT);
		buttonRegistrarEstudio.setForeground(Color.BLACK);
		buttonRegistrarEstudio.setBackground(Color.LIGHT_GRAY);
		buttonRegistrarEstudio.setBounds(280, 166, 267, 37);
		buttonRegistrarEstudio.addActionListener(this);
		add(buttonRegistrarEstudio);

		JLabel labelMenu = new JLabel("Menu");
		labelMenu.setHorizontalAlignment(SwingConstants.TRAILING);
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Algerian", Font.BOLD, 50));
		labelMenu.setBounds(21, 227, 144, 69);
		add(labelMenu);

		JLabel labelIconMask = new JLabel("");
		labelIconMask.setBounds(228, 0, 217, 145);
		labelIconMask.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/iconMask.png")));
		add(labelIconMask);

		JLabel labelIconMenu = new JLabel("");
		labelIconMenu.setBounds(0, 0, 209, 522);
		labelIconMenu.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/iconMenu.png")));
		add(labelIconMenu);

		JLabel labelTitulo = new JLabel("App de Cadastro");
		labelTitulo.setFont(new Font("Algerian", Font.PLAIN, 35));
		labelTitulo.setBounds(455, 60, 325, 47);
		add(labelTitulo);

		JLabel labelIconUNB = new JLabel("");
		labelIconUNB.setBounds(680, 382, 100, 69);
		labelIconUNB.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/iconUnb.png")));
		add(labelIconUNB);

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

	public JButton getButtonRegistrarEstudio() {
		return buttonRegistrarEstudio;
	}

	public JButton getButtonMostrarPersonagens() {
		return buttonMostrarPersonagens;
	}

	public JButton getButtonMostrarCache() {
		return buttonMostrarCache;
	}

	public JButton getButtonMostrarAtores() {
		return buttonMostrarAtores;
	}

	public JButton getButtonMostrarFilmes() {
		return buttonMostrarFilmes;
	}

	public JButton getButtonAdicionarFilme() {
		return buttonAdicionarFilme;
	}

	public MenuControl getController() {
		return controller;
	}
}