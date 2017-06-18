package ladylike778;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Userid3 extends JFrame {
	public Userid3(){		
	JFrame a=new JFrame();
	JTextField idget=new JTextField();
	JButton okok=new JButton("確認");		
    a.setVisible(true);
	a.setResizable(false); 
	a.setLayout(null);
	a.setBounds(100, 100, 400, 200);
	a.setTitle("輸入借用者ID");		
	idget.setBounds(20,20,330,30);
	okok.setBounds(290,80, 60,30);
	a.add(idget);a.add(okok);
	okok.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			a.setVisible(false);
			String h=idget.getText();
			UserHistory b=new UserHistory(h);
					b.setVisible(true);}});	
}}
