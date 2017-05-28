package User;

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

public class RevisePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		changepassword gp = new changepassword();
		gp.setVisible(true);
	}
}

class changepassword extends JFrame {
	private String jlbname[] = { "帳號", "生日", "E-mail", "系級", "學號", "姓名", "電話" };
	private JLabel jlb[] = new JLabel[7];
	private JButton jbt = new JButton("更改密碼");
	private JPanel jlbjpl = new JPanel(new GridLayout(7, 1, 3, 3));
	private Container cp;
	private Font ft = new Font(null, Font.CENTER_BASELINE, 24);

	public changepassword() {
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		jbt.setFont(ft);
		this.setTitle("使用者");
		for (int i = 0; i < 7; i++) {
			jlb[i] = new JLabel(jlbname[i]);
			jlbjpl.add(jlb[i]);
			jlb[i].setFont(ft);
		}
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = 7;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 0;
		g.weighty = 0;
		g.fill = GridBagConstraints.BOTH;
		g.anchor = GridBagConstraints.WEST;
		g.insets = new Insets(100, 50, 0, 0);
		cp.add(jlbjpl, g);
		g.fill = GridBagConstraints.NONE;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(4, 4, 4, 300);
		cp.add(jbt, g);
	}
}