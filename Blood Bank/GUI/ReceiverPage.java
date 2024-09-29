package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import File.FileIO;
@SuppressWarnings("unchecked")
public class ReceiverPage extends JFrame implements ActionListener{
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font17 = new Font("cambria",Font.BOLD,17);
	Font font18 = new Font("cambria",Font.BOLD,18);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField receiverIDTextField,receiverNameTextField,receiverAgeTextField,requiredAmountTextField,locationTextField;
	JComboBox receiverGenderComboBox,requiredBloodGroupComboBox,requiredBloodProductComboBox;
	JTextField searchTextField,deleteTextField;
	
	JTextArea display;
	
	
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton;
	JButton backButton;
	ReceiverList receiverList = new ReceiverList((short)1000);
	
	class BackGroundPanel extends JPanel{
		Image backGroundImage = new ImageIcon("./Backup/background2.jpg").getImage();
		
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
	
	public ReceiverPage(){
		super("Blood Recipient Database");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,850); //width, height
		this.setLocation(150,0); //X, Y
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(218,232,252));
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);

		//===========DEMO DATA=================
		FileIO.loadReceiversFromFile(receiverList);
		
		//=================Image Example====================

	
		//============= Title ===========
		JLabel title = new JLabel("List of Recipients");
		title.setBounds(310,10,500,50); //X,Y,W,H
		title.setFont(titleFont);
		//=========== Sub Title ==========
		JLabel subTitle = new JLabel("INFORMATIONS");
		subTitle.setBounds(330,60,320,50); //X,Y,W,H
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		
		
		//////////////////////////////////////////////////////////////////////////////
		//---------------------- LEFT SIDE COMPONENTS ------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		//======= Entry Form ===========
		short top = 40;
		short gap = 40;
		
		JLabel receiverIDLabel = new JLabel("ID");
		receiverIDLabel.setBounds(20,top,200,30); //X,Y,W,H
		receiverIDLabel.setFont(font15);
		
		receiverIDTextField = new JTextField();
		receiverIDTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverIDTextField.setFont(font15);
		
		
		JLabel receiverNameLabel = new JLabel("Receiver Name:");
		receiverNameLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverNameLabel.setFont(font15);
		
		receiverNameTextField = new JTextField();
		receiverNameTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverNameTextField.setFont(font15);
		
		
		JLabel receiverAgeLabel = new JLabel("Receiver Age:");
		receiverAgeLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverAgeLabel.setFont(font15);
		
		receiverAgeTextField = new JTextField();
		receiverAgeTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverAgeTextField.setFont(font15);
		
		
		JLabel receiverGenderLabel = new JLabel("Receiver Gender:");
		receiverGenderLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverGenderLabel.setFont(font15);
		
		String genders[] = {"Select Option","Male","Female","Other"};
		receiverGenderComboBox = new JComboBox(genders);
		receiverGenderComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,H
		receiverGenderComboBox.setFont(font15);
		
		
		JLabel requiredBloodGroupLabel = new JLabel("Required Blood Group:");
		requiredBloodGroupLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredBloodGroupLabel.setFont(font15);
		
		String bloodGroups[] = {"Select Option","A+","A-","B+","B-","AB+","AB-","O+","O-"};
		requiredBloodGroupComboBox = new JComboBox(bloodGroups);
		requiredBloodGroupComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredBloodGroupComboBox.setFont(font15);
		
		
		JLabel requiredBloodProductLabel = new JLabel("Required Blood Product:");
		requiredBloodProductLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredBloodProductLabel.setFont(font15);
		
		String bloodProducts[] = {"Select Option","Whole Blood","Blood Plasma","Red Blood Cells","Platelets","Cryoprecipitate"};
		requiredBloodProductComboBox = new JComboBox(bloodProducts);
		requiredBloodProductComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredBloodProductComboBox.setFont(font15);
				
		JLabel requiredAmountLabel = new JLabel("Amount Required:");
		requiredAmountLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredAmountLabel.setFont(font15);
		
		requiredAmountTextField = new JTextField();
		requiredAmountTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		requiredAmountTextField.setFont(font15);
		
		
		JLabel locationLabel = new JLabel("Admitted in:");
		locationLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		locationLabel.setFont(font15);
		
		locationTextField = new JTextField();
		locationTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		locationTextField.setFont(font15);
		
		
		addButton = new JButton("ADD");
		addButton.setBounds(20,top+=gap+20,200,30); //X,Y,W,H
		addButton.setBackground(new Color(180, 153, 170));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(font15);
		addButton.addActionListener(this);
		
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(20,top+=gap,200,30); //X,Y,W,H
		updateButton.setBackground(Color.BLACK);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font15);
		updateButton.addActionListener(this);
		
		backButton = new JButton("BACK");
		backButton.setBounds(700,10,200,30); //X,Y,W,H
		backButton.setBackground(Color.WHITE);
		backButton.setForeground(Color.BLACK);
		backButton.setFont(font15);
		backButton.addActionListener(this);
		backGroundPanel.add(backButton);
		
		
		
		//============RIGHT SIDE COMPONENTS=========
		top = 100;
		gap = 40;
		//======= Search =====
		JLabel searchLabel = new JLabel("Search By ID");
		searchLabel.setBounds(700,top,200,30); //X,Y,W,H
		searchLabel.setFont(font15);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchTextField.setFont(font15);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		
		
		//======= Delete =====
		JLabel deleteLabel = new JLabel("Delete By ID");
		deleteLabel.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteLabel.setFont(font15);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteTextField.setFont(font15);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		
		
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(700,500,200,30); //X,Y,W,H
		showAllButton.setBackground(Color.PINK);
		showAllButton.setForeground(Color.WHITE);
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		
		
		
		clearButton = new JButton("CLEAR SCREEN");
		clearButton.setBounds(700,550,200,30); //X,Y,W,H
		clearButton.setBackground(Color.DARK_GRAY);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(font15);
		clearButton.addActionListener(this);
		
		//Data Display Area
		display = new JTextArea();
		display.setFont(font17);
		display.setForeground(Color.BLACK);
		display.setOpaque(false);
		display.setBackground(new Color(0, 0, 0, 0));
		
		JScrollPane jsp = new JScrollPane(display);
		jsp.setBounds(250,100,400,500);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		backGroundPanel.add(jsp);
		
		
		reloadData();
		
		
		
		backGroundPanel.add(title);
		backGroundPanel.add(subTitle);
		backGroundPanel.add(receiverIDLabel);
		backGroundPanel.add(receiverIDTextField);
		backGroundPanel.add(receiverNameLabel);
		backGroundPanel.add(receiverNameTextField);
		backGroundPanel.add(receiverAgeLabel);
		backGroundPanel.add(receiverAgeTextField);
		backGroundPanel.add(receiverGenderLabel);
		backGroundPanel.add(receiverGenderComboBox);
		backGroundPanel.add(requiredBloodGroupLabel);
		backGroundPanel.add(requiredBloodGroupComboBox);
		backGroundPanel.add(requiredBloodProductLabel);
		backGroundPanel.add(requiredBloodProductComboBox);
		backGroundPanel.add(requiredAmountLabel);
		backGroundPanel.add(requiredAmountTextField);
		backGroundPanel.add(locationLabel);
		backGroundPanel.add(locationTextField);
		backGroundPanel.add(addButton);
		backGroundPanel.add(updateButton);
		backGroundPanel.add(searchLabel);
		backGroundPanel.add(searchTextField);
		backGroundPanel.add(searchButton);
		backGroundPanel.add(deleteLabel);
		backGroundPanel.add(deleteTextField);
		backGroundPanel.add(deleteButton);
		backGroundPanel.add(clearButton);
		backGroundPanel.add(showAllButton);
		
		//================= DISPLAY THE FRAME ======================//
		this.setContentPane(backGroundPanel);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        if (addButton == e.getSource()) {
            System.out.println("ADD CLICKED");
			String gender = (String)receiverGenderComboBox.getSelectedItem();
		    String bloodGroup = (String)requiredBloodGroupComboBox.getSelectedItem();
			String bloodProduct = (String)requiredBloodProductComboBox.getSelectedItem();
            try{
				if (receiverList.getById(receiverIDTextField.getText()) == null) {
                if (receiverIDTextField.getText().isEmpty() &&
                    receiverNameTextField.getText().isEmpty() &&
                    receiverAgeTextField.getText().isEmpty() &&
                    gender.equals("Select Option") &&
                    bloodGroup.equals("Select Option") &&
                    bloodProduct.equals("Select Option") &&
                    requiredAmountTextField.getText().isEmpty() &&
                    locationTextField.getText().isEmpty()){
						JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
                else if (!receiverIDTextField.getText().isEmpty() &&
                    !receiverNameTextField.getText().isEmpty() &&
                    !receiverAgeTextField.getText().isEmpty() &&
                    !gender.equals("Select Option") &&
                    !bloodGroup.equals("Select Option") &&
                    !bloodProduct.equals("Select Option") &&
                    !requiredAmountTextField.getText().isEmpty() &&
                    !locationTextField.getText().isEmpty()){
						
                    BloodReceiver b = new  BloodReceiver(receiverIDTextField.getText(),
                                                         receiverNameTextField.getText(),
                                                         Short.parseShort(receiverAgeTextField.getText()),
                                                         gender,
                                                         bloodGroup,
                                                         bloodProduct,
                                                         Float.parseFloat(requiredAmountTextField.getText()),
                                                         locationTextField.getText());
                    receiverList.enter(b);
					FileIO.writeReceiverInFile(b);
                    reloadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
                }
            }
			else {
                JOptionPane.showMessageDialog(this, "Id Already Used", "Error", JOptionPane.ERROR_MESSAGE);
            }
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}
			

        } 
		else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");
			String gender = (String)receiverGenderComboBox.getSelectedItem();
		    String bloodGroup = (String)requiredBloodGroupComboBox.getSelectedItem();
			String bloodProduct = (String)requiredBloodProductComboBox.getSelectedItem();
            BloodReceiver b = receiverList.getById(receiverIDTextField.getText());
            try{
				if (b != null) {
                if (!receiverNameTextField.getText().isEmpty()) {
                    b.setReceiverName(receiverNameTextField.getText());
                }
                if (!receiverAgeTextField.getText().isEmpty()) {
                    b.setReceiverAge(Short.parseShort(receiverAgeTextField.getText()));
                }
				if(!gender.equals("Select Option")){
					b.setReceiverGender(gender);
				}
				if(!bloodGroup.equals("Select Option")){
					b.setRequiredBloodGroup(bloodGroup);
				}
				if(!bloodProduct.equals("Select Option")){
					b.setRequiredBloodGroup(bloodProduct);
				}
                if (!requiredAmountTextField.getText().isEmpty()) {
                    b.setRequiredAmount(Float.parseFloat(requiredAmountTextField.getText()));
                }
                if (!locationTextField.getText().isEmpty()) {
                    b.setLocation(locationTextField.getText());
                }
                reloadData();
				FileIO.updateReceiverInFile(receiverList);
                JOptionPane.showMessageDialog(this, "Recepient Information is Updated");
            } 
			else {
                JOptionPane.showMessageDialog(this, "Please input information to update", "Error", JOptionPane.WARNING_MESSAGE);
            }
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}

        }
		else if (searchButton == e.getSource()) {
            System.out.println("SEARCH CLICKED");
            BloodReceiver b = receiverList.getById(searchTextField.getText());
            if (b != null) {
                display.setText(b.getReceiverAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Recipient Found with this ID");
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");
            BloodReceiver b = receiverList.getById(deleteTextField.getText());
            if (b != null) {
                receiverList.removeById(deleteTextField.getText());
				FileIO.updateReceiverInFile(receiverList);
                reloadData();
            } else {
                JOptionPane.showMessageDialog(this, "No Recipient Found with this ID", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else if (showAllButton == e.getSource()) {
            System.out.println("SHOW ALL CLICKED");
            reloadData();

        } else if (clearButton == e.getSource()) {
            System.out.println("CLEAR CLICKED");
            display.setText("");
					
        } else if (backButton == e.getSource()) {
            System.out.println("BACK CLICKED");
			this.previousPage.setVisible(true);
            this.dispose();			
        }
    }
	
	public void reloadData(){
		display.setText(receiverList.getAllReceiversAsString());
	}
	
}
