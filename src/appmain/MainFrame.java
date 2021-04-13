package appmain;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import vision.CadastrarAtores;
import vision.CadastrarEstudio;
import vision.CadastrarFilme;
import vision.CadastrarPapel;
import vision.Menu;
import vision.RelatorioAtoresDiretores;
import vision.RelatorioCache;
import vision.RelatorioFilmes;
import vision.RelatorioPersonagens;
import vision.CadastrarNovoAtor;

/**
 * A tela principal do aplicativo, JFrame que armazena todos os JPanel em seu
 * CardLayout.
 * 
 * @author Eduardo Rodrigues
 * @version 2.0
 * 
 */
public class MainFrame extends JFrame implements AncestorListener {

	private static final long serialVersionUID = 4433210214073367477L;
	private JPanel contentPane;
	private static Container cont;
	private Menu menu;
	private CadastrarEstudio cadastrarEstudio;
	private CadastrarFilme cadastrarFilme;
	private CadastrarAtores cadastrarAtores;
	private CadastrarPapel cadastrarPapel;
	private CadastrarNovoAtor cadastrarNovoAtor;
	private RelatorioFilmes relatorioFilmes;
	private RelatorioAtoresDiretores relatorioAtoresDiretores;
	private RelatorioCache relatorioCache;
	private RelatorioPersonagens relatorioPersonagens;
	private MainFrameControl controller;

	/**
	 * Executa o app.
	 * 
	 * @param args argumentos de execucao
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * Cria o frame com CardLayout e tamanho fixo.
	 */
	public MainFrame() {
		controller = new MainFrameControl(this);

		setTitle("App de Cadastro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/vision/images/iconUnb.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());

		menu = new Menu();
		menu.addAncestorListener(this);

		cadastrarEstudio = new CadastrarEstudio();
		cadastrarEstudio.addAncestorListener(this);

		cadastrarFilme = new CadastrarFilme();
		cadastrarFilme.addAncestorListener(this);

		cadastrarAtores = new CadastrarAtores();
		cadastrarAtores.addAncestorListener(this);

		cadastrarPapel = new CadastrarPapel();
		cadastrarPapel.addAncestorListener(this);

		cadastrarNovoAtor = new CadastrarNovoAtor();
		cadastrarNovoAtor.addAncestorListener(this);

		relatorioAtoresDiretores = new RelatorioAtoresDiretores();
		relatorioAtoresDiretores.addAncestorListener(this);

		relatorioFilmes = new RelatorioFilmes();
		relatorioFilmes.addAncestorListener(this);

		relatorioCache = new RelatorioCache();
		relatorioCache.addAncestorListener(this);

		relatorioPersonagens = new RelatorioPersonagens();
		relatorioPersonagens.addAncestorListener(this);

		getContentPane().add(menu, "menu");
		getContentPane().add(cadastrarEstudio, "cadastrarEstudio");
		getContentPane().add(cadastrarFilme, "cadastrarFilme");
		getContentPane().add(cadastrarAtores, "cadastrarAtores");
		getContentPane().add(cadastrarNovoAtor, "cadastrarNovoAtor");
		getContentPane().add(cadastrarPapel, "cadastrarPapel");
		getContentPane().add(relatorioAtoresDiretores, "relatorioAtoresDiretores");
		getContentPane().add(relatorioFilmes, "relatorioFilmes");
		getContentPane().add(relatorioCache, "relatorioCache");
		getContentPane().add(relatorioPersonagens, "relatorioPersonagens");

		cont = getContentPane();
	}

	public static Container getCont() {
		return cont;
	}

	public Menu getMenu() {
		return menu;
	}

	public CadastrarEstudio getCadastrarEstudio() {
		return cadastrarEstudio;
	}

	public CadastrarFilme getCadastrarFilme() {
		return cadastrarFilme;
	}

	public CadastrarAtores getCadastrarAtores() {
		return cadastrarAtores;
	}

	public CadastrarPapel getCadastrarPapel() {
		return cadastrarPapel;
	}

	public CadastrarNovoAtor getCadastrarNovoAtor() {
		return cadastrarNovoAtor;
	}

	public RelatorioFilmes getRelatorioFilmes() {
		return relatorioFilmes;
	}

	public RelatorioAtoresDiretores getRelatorioAtoresDiretores() {
		return relatorioAtoresDiretores;
	}

	public RelatorioCache getRelatorioCache() {
		return relatorioCache;
	}

	public RelatorioPersonagens getRelatorioPersonagens() {
		return relatorioPersonagens;
	}

	public MainFrameControl getController() {
		return controller;
	}

	/**
	 * Modifica algo nos Components quando eles forem mostrados pelo m�todo
	 * CardLayout.show()
	 * 
	 * � a implementa��o da interface AncestorListener
	 */
	@Override
	public void ancestorAdded(AncestorEvent event) {
		controller.mudarTela(event.getSource());
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// Vazio
	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// Vazio
	}
}