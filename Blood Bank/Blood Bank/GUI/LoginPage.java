package GUI;
import javax.swing.*;//JFrame,JLabel,JTextField,JButton
import java.awt.*;//Font, Color
import java.awt.event.*;
import File.FileIO;

public class LoginPage extends JFrame implements ActionListener, MouseListener{
	JLabel userLabel, passLabel;
	JTextField userField;
	JPasswordField passField;
	JButton loginBtn,newUserBtn;
	
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	Font font25 = new Font("cambria",Font.BOLD,25);
	Font font30 = new Font("cambria",Font.BOLD,30);
	
	class BackGroundPanel extends JPanel{
		Image backGroundImage = new ImageIcon("./Backup/Image.jpg").getImage();
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			double scaleFactor = 1.1;
			short newWidth = (short)(getWidth()*scaleFactor);
			short newHeight = (short)(getHeight()*scaleFactor);
			g.drawImage(backGroundImage,0,0,newWidth,newHeight,this);
		}
	}
	
	public LoginPage(){
		super("Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		this.setSize(400,400);//w,h
		this.setLocation(300,100);//x,y
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);
		
		//User Name Label
		userLabel = new JLabel("User Name");
		userLabel.setBounds(100,30,200,30);//x,y,w,h
		userLabel.setFont(font25);
		userLabel.setForeground(Color.BLACK);
		backGroundPanel.add(userLabel);
		
		
		//User Name TextField
		userField = new JTextField();
		userField.setBounds(100,70,200,30);//x,y,w,h
		userField.setFont(font25);
		backGroundPanel.add(userField);
		
		
		//Password Label
		passLabel = new JLabel("User Password");
		passLabel.setBounds(100,110,200,30);//x,y,w,h
		passLabel.setFont(font25);
		passLabel.setForeground(Color.BLACK);
		backGroundPanel.add(passLabel);
		
		
		//Passowrd Field
		passField = new JPasswordField();
		passField.setEchoChar('*');
		passField.setBounds(100,150,200,30);//x,y,w,h
		passField.setFont(font25);
		backGroundPanel.add(passField);
		
		//Login Button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(100,200,200,30);
		loginBtn.setFont(font25);
		loginBtn.setBackground(new Color(180, 153, 170));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(this);
		backGroundPanel.add(loginBtn);
		
		//New User Button
		newUserBtn = new JButton("New User");
		newUserBtn.setBounds(100,240,200,30);
		newUserBtn.setFont(font25);
		newUserBtn.setBackground(new Color(180, 153, 170)); //New User Button Colour
		newUserBtn.setForeground(Color.WHITE);
		newUserBtn.addActionListener(this);
		newUserBtn.addMouseListener(this);
		backGroundPanel.add(newUserBtn);
		
		this.setContentPane(backGroundPanel);
		this.setVisible(true);
	}
	
	public void mouseEntered(MouseEvent e){
		if(e.getSource() == loginBtn){
			loginBtn.setBackground(new Color(146, 48, 63));
			loginBtn.setForeground(Color.WHITE);
		}
		if(e.getSource() == newUserBtn){
			newUserBtn.setBackground(new Color(146, 48, 63));
			newUserBtn.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent e){
		if(e.getSource() == loginBtn){
			loginBtn.setBackground(new Color(180, 153, 170));
			loginBtn.setForeground(Color.WHITE);
		}
		if(e.getSource() == newUserBtn){
			newUserBtn.setBackground(new Color(180, 153, 170));
			newUserBtn.setForeground(Color.WHITE);
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == loginBtn){
			
			String userName =userField.getText();
			String userPassword = String.valueOf(passField.getPassword());
			
			if(FileIO.checkUser(userName,userPassword)){
				JOptionPane.showMessageDialog(this,"User Verified");
				HomePage hp = new HomePage();
		        hp.previousPage = this;
				this.setVisible(false);
				
			}
			else{
				JOptionPane.showMessageDialog(this,"User Name or Password Missmatch","Invalid User",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(e.getSource() == newUserBtn){
			RegistrationPage regp = new RegistrationPage();
			regp.previousPage = this;
			this.setVisible(false);
		}
	}	
}
