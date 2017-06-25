package ladylike778;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dandan.Login;

public class TEST extends JFrame {
	private static JButton b1=new JButton("借書");
	private static JButton b2=new JButton("還書");
	private static JButton b3=new JButton("歷史紀錄");
	private String a1;
	 public TEST(String account) {
		// TODO Auto-generated constructor stub
		 this.a1=account;
	}
	public void Tt(){
		 Tt1();
	 }
	public void Tt1() {
		// TODO Auto-generated method stub
		

		JFrame a=new JFrame();
		a.setVisible(true);
		a.setLayout(null);
		a.setBounds(200, 200, 600, 600);
		b1.setBounds(100, 150, 200, 50);
		b2.setBounds(100, 250, 200, 50);b3.setBounds(100, 350, 200, 50);
		a.add(b1);a.add(b2);a.add(b3);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String c=a1;
				LoanFrame b=new LoanFrame(c);
						b.setVisible(true);
			
		}		
	});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String k=a1;
				Returnbook e1=new Returnbook(k);
						e1.setVisible(true);
			
		}		
	});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String h=a1;
				UserHistory b=new UserHistory(h);
						b.setVisible(true);
			
		}		
	});

}
}