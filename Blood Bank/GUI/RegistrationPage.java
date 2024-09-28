package GUI;
import javax.swing.*;//JFrame,JLabel,JTextField,JButton
import java.awt.*;//Font, Color
import java.awt.event.*;
import File.FileIO;

public class RegistrationPage extends JFrame implements ActionListener,MouseListener{
	JLabel userLabel, passLabel;
	JTextField userField;
	JPasswordField passField;
	JButton registerBtn,backBtn;
	
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
	
	public JFrame previousPage;
	
	public RegistrationPage(){
		super("User Registration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		this.setSize(400,400);//w,h
		this.setLocation(300,100);//x,y
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);
		
		userLabel = new JLabel("User Name");
		userLabel.setBounds(100,30,200,30);//x,y,w,h
		userLabel.setFont(font25);
		userLabel.setForeground(Color.BLACK);
		backGroundPanel.add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(100,70,200,30);//x,y,w,h
		userField.setFont(font25);
		backGroundPanel.add(userField);
		
		passLabel = new JLabel("User Password");
		passLabel.setBounds(100,110,200,30);//x,y,w,h
		passLabel.setFont(font25);
		passLabel.setForeground(Color.BLACK);
		backGroundPanel.add(passLabel);
		
		passField = new JPasswordField();
		passField.setEchoChar('*');
		passField.setBounds(100,150,200,30);//x,y,w,h
		passField.setFont(font25);
		backGroundPanel.add(passField);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(100,200,200,30);
		backBtn.setFont(font25);
		backBtn.setBackground(new Color(180, 153, 170));
		backBtn.setForeground(Color.WHITE);
		backBtn.addActionListener(this);
		backBtn.addMouseListener(this);
		backGroundPanel.add(backBtn);
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(100,240,200,30);
		registerBtn.setFont(font25);
		registerBtn.setBackground(new Color(180, 153, 170));
		registerBtn.setForeground(Color.WHITE);
		registerBtn.addActionListener(this);
		registerBtn.addMouseListener(this);
		backGroundPanel.add(registerBtn);
		
		
		this.setContentPane(backGroundPanel);
		this.setVisible(true);
	}
	
	public void mouseEntered(MouseEvent e){
		if(e.getSource() == backBtn){
			backBtn.setBackground(new Color(146, 48, 63));
			backBtn.setForeground(Color.WHITE);
		}
		if(e.getSource() == registerBtn){
			registerBtn.setBackground(new Color(146, 48, 63));
			registerBtn.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent e){
		if(e.getSource() == backBtn){
			backBtn.setBackground(new Color(180, 153, 170));
			backBtn.setForeground(Color.WHITE);
		}
		if(e.getSource() == registerBtn){
			registerBtn.setBackground(new Color(180, 153, 170));
			registerBtn.setForeground(Color.WHITE);
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
		
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == registerBtn){
			String userName = userField.getText();
			String userPassword = String.valueOf(passField.getPassword());
			
			if(userName.isEmpty() || userPassword.isEmpty()){
				JOptionPane.showMessageDialog(this,"One or more fields are empty","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(FileIO.userExists(userName)){
				JOptionPane.showMessageDialog(this,"User Already Exists","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(FileIO.registerNewUser(userName,userPassword)){
				JOptionPane.showMessageDialog(this,"User Registered Successfully");
				this.previousPage.setVisible(true);
				this.dispose();
			}
			
			else{
				JOptionPane.showMessageDialog(this,"Registration Failed","Error",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		else if(e.getSource() == backBtn){
			this.previousPage.setVisible(true);
		    this.dispose();
		}
	}
}