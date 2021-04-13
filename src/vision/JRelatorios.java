package vision;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Classe molde para as telas de relatorio comuns.
 * 
 * @author Eduardo Rodrigues
 */
public abstract class JRelatorios extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3204559558142446074L;
	private JButton buttonVoltar;

	/**
	 * Gera um panel com um fundo, um título e um botão.
	 * 
	 * @param titulo O titulo da tela para ser mostrado no topo
	 */
	public JRelatorios(String titulo) {
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		setBounds(100, 100, 830, 522);

		JLabel labelTitulo = new JLabel(titulo);
		labelTitulo.setFont(JCampos.FONT);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(51, 59, 725, 13);
		add(labelTitulo);

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(this);
		buttonVoltar.setForeground(new Color(153, 0, 0));
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setFont(JCampos.FONT);
		buttonVoltar.setBounds(657, 428, 119, 21);
		add(buttonVoltar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, 0, 830, 522);
		labelFundo.setIcon(new ImageIcon(JRelatorios.class.getResource("/vision/images/iconScreen.png")));
		add(labelFundo);
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}
}
