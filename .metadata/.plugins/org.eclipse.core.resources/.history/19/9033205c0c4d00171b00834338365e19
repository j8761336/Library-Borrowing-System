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

public class ReviseData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		changedata cd = new changedata();
		cd.setVisible(true);
	}
}

class changedata extends JFrame {
	private String jlbname[] = { "帳號:", "姓名:","學號:","生日:", "E-mail:", "系級:", "電話:" };
	private JLabel jlb[] = new JLabel[7];
	private String jlb2name[] = {"0","0","0","0","0","0","0"};
	private JLabel jlb2[]=new JLabel[7];
	private JButton jbt[]=new JButton[7];
	private String jbtname=("修改");
	private JPanel jlbjpl = new JPanel(new GridLayout(7, 1, 30, 30));
	private JPanel jlb2jpl = new JPanel(new GridLayout(7, 1, 30, 30));	
	private JPanel jbtjpl=new JPanel(new GridLayout(7,1,20,20));
	private Container cp;
	private Font ft = new Font(null, Font.CENTER_BASELINE, 24);

	public changedata() {
		init();
	}

	private void init() {
		this.setBounds(10, 10, 700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new GridBagLayout());
		this.setTitle("修改資料");
		for (int i = 0; i < 7; i++) {
			jlb[i] = new JLabel(jlbname[i]);
			jlbjpl.add(jlb[i]);
			jlb[i].setFont(ft);
		}
		for(int i=0;i<7;i++){
			jlb2[i]=new JLabel(jlb2name[i]);
			jlb2jpl.add(jlb2[i]);
			jlb2[i].setFont(ft);
		}
		for(int i=0;i<7;i++){
			jbt[i]=new JButton("修改");
			jbtjpl.add(jbt[i]);
			jbt[i].setFont(ft);
		}
		GridBagConstraints g = new GridBagConstraints();
		g.gridx =1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.WEST;
		g.insets = new Insets(10, 50,100, 100);
		cp.add(jlbjpl, g);
		g.gridx =1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.CENTER;
		g.insets = new Insets(10, 0,100,0);
		cp.add(jlb2jpl, g);
		g.gridx =2;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.NONE;
		g.anchor = GridBagConstraints.EAST;
		g.insets = new Insets(10, 0,100, 100);
		cp.add(jbtjpl, g);
	}
}
