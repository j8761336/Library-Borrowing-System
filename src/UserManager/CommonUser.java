import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommonUser {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addUser aU = new addUser();
		aU.setVisible(true);
	}
}

class addUser extends JFrame {
	private String jblname[] = { "�b��:", "�K�X:", "�A����J�K�X:", "�m�W:", "�ͤ�:", "�s���q��:", "E-Mail:", "�t��:" };
	private JLabel jbl[] = new JLabel[8];
	private JButton subjbtn = new JButton("�e�X");
	// private JTextField accjtf = new JTextField();
	// private JTextField passjtf = new JTextField();
	// private JTextField passagainjtf = new JTextField();
	// private JTextField namejtf = new JTextField();
	// private JTextField birthjtf = new JTextField();
	// private JTextField phonejtf = new JTextField();
	// private JTextField emailjtf = new JTextField();
	// private JTextField subjectjtf = new JTextField();
	private JTextField jtf[] = new JTextField[8];
	private JPanel jlbjpl = new JPanel(new GridLayout(8, 1, 3, 3));
	private JPanel jtfjpl = new JPanel(new GridLayout(8, 1, 3, 3));
	private Container cp;
	private Font f1 = new Font(null, Font.CENTER_BASELINE, 24);

	public addUser() {
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(5, 5));
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		subjbtn.setFont(f1);
		this.setTitle("�Ыؤ@��ϥΪ�");
		for (int i = 0; i < 8; i++) {
			jbl[i] = new JLabel(jblname[i]);
			jlbjpl.add(jbl[i]);
			jbl[i].setFont(f1);

		}
		for (int i = 0; i < 8; i++) {
			jtf[i] = new JTextField();
			jtfjpl.add(jtf[i]);
		}
		GridBagConstraints g = new GridBagConstraints();
		g.weightx = 1;
		g.weighty = 1;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(100, 0, 0, 0);
		g.fill = GridBagConstraints.BOTH;
		g.anchor = GridBagConstraints.WEST;
		cp.add(jlbjpl, g);
		g.fill = GridBagConstraints.BOTH;
		g.weightx = 2;
		g.gridwidth = 2;
		g.gridheight = 1;
		g.gridx = 1;
		g.gridy = 0;
		cp.add(jtfjpl, g);
		g.fill = GridBagConstraints.NONE;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(4, 300, 4, 4);
		cp.add(subjbtn, g);

	}

}