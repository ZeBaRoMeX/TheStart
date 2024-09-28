package GUI;
import javax.swing.*;//JFrame,JLabel,JTextField,JButton
import java.awt.*;//Font, Color
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import GUI.*;

public class HomePage extends JFrame implements ActionListener{
	JLabel titleLabel;
	JButton dnrBtn, rcvrBtn, invBtn, logoutBtn;
	
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	Font font25 = new Font("cambria",Font.BOLD,25);
	Font font30 = new Font("cambria",Font.BOLD,30);
	
	class BackGroundPanel extends JPanel{
		Image backGroundImage = new ImageIcon("./Backup/rbc2.jpg").getImage();
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			double scaleFactor = 1.1;
			short newWidth = (short)(getWidth()*scaleFactor);
			short newHeight = (short)(getHeight()*scaleFactor);
			g.drawImage(backGroundImage,0,0,newWidth,newHeight,this);
		}
	}
	
	public JFrame previousPage;
	
	public HomePage(){
		super("Home Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);//w,h
		this.setLocation(300,100);//x,y
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);
		
		titleLabel = new JLabel("Welcome!");
		titleLabel.setBounds(120,30,200,30);//x,y,w,h
		titleLabel.setFont(font30);
		titleLabel.setForeground(Color.WHITE);
		backGroundPanel.add(titleLabel);
		
		short top = 100;
		short gap = 80;
		
		dnrBtn = new JButton("Donor List");
		dnrBtn.setBounds(90,top,200,40);
		dnrBtn.setBackground(Color.WHITE);
		dnrBtn.setForeground(Color.BLACK);
		dnrBtn.setFont(font15);
		dnrBtn.addActionListener(this);
		backGroundPanel.add(dnrBtn);
		
		rcvrBtn = new JButton("Receiver List");
		rcvrBtn.setBounds(90,top+=gap,200,40);
		rcvrBtn.setBackground(Color.WHITE);
		rcvrBtn.setForeground(Color.BLACK);
		rcvrBtn.setFont(font15);
		rcvrBtn.addActionListener(this);
		backGroundPanel.add(rcvrBtn);
		
		invBtn = new JButton("Inventory List");
		invBtn.setBounds(90,top+=gap,200,40);
		invBtn.setBackground(Color.WHITE);
		invBtn.setForeground(Color.BLACK);
		invBtn.setFont(font15);
		invBtn.addActionListener(this);
		backGroundPanel.add(invBtn);
		
		
		logoutBtn = new JButton("LOGOUT");
		logoutBtn.setBounds(280,18,100,30); //X,Y,W,H
		logoutBtn.setBackground(new Color(180, 153, 170));
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setFont(font15);
		logoutBtn.addActionListener(this);
		backGroundPanel.add(logoutBtn);
		
		this.setContentPane(backGroundPanel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == logoutBtn){
			System.out.println("LOGOUT CLICKED");
			JOptionPane.showMessageDialog(this,"Logged out successfully.");
			this.previousPage.setVisible(true);
            this.dispose();	
		}
		
		else if(e.getSource() == invBtn){
			System.out.println("INV CLICKED");
			InventoryPage ip = new InventoryPage();
			ip.previousPage = this;
			this.setVisible(false);
		}
		
		else if(e.getSource() == dnrBtn){
			System.out.println("DON CLICKED");
			DonorPage dp = new DonorPage();
			dp.previousPage = this;
			this.setVisible(false);
		}
		
		else if(e.getSource() == rcvrBtn){
			System.out.println("INV CLICKED");
			ReceiverPage rcvp = new ReceiverPage();
			rcvp.previousPage = this;
			this.setVisible(false);
		}
		
		
		
	}
	
	
}