package vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Classe molde para as telas de cadastro comuns, possui uma constante para
 * definir a fonte do texto no aplicativo.
 * 
 * @author Eduardo Rodrigues
 */
public abstract class JCampos extends JPanel implements ActionListener {
	private static final long serialVersionUID = -1060587114635639328L;

	protected static final Font FONT = new Font("Algerian", Font.PLAIN, 14);

	private JButton buttonConfirmar;
	private JButton buttonCancelar;

	/**
	 * Gera um panel com um fundo, um título e dois botões.
	 * 
	 * @param titulo O titulo da tela para ser mostrado no topo
	 */
	public JCampos(String titulo) {
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		setBounds(100, 100, 830, 522);

		JLabel labelTitulo = new JLabel(titulo);
		labelTitulo.setFont(FONT);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(299, 102, 233, 13);
		add(labelTitulo);

		buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.addActionListener(this);
		buttonConfirmar.setForeground(new Color(0, 128, 0));
		buttonConfirmar.setBackground(Color.LIGHT_GRAY);
		buttonConfirmar.setFont(FONT);
		buttonConfirmar.setBounds(492, 457, 119, 21);
		add(buttonConfirmar);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(this);
		buttonCancelar.setForeground(new Color(128, 0, 0));
		buttonCancelar.setBackground(Color.LIGHT_GRAY);
		buttonCancelar.setFont(FONT);
		buttonCancelar.setBounds(621, 457, 113, 21);
		add(buttonCancelar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, 0, 830, 522);
		labelFundo.setIcon(new ImageIcon(CadastrarPapel.class.getResource("/vision/images/iconCurtain.png")));
		add(labelFundo);
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}
}
