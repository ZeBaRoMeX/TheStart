package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import File.FileIO;
@SuppressWarnings("unchecked")
public class DonorPage extends JFrame implements ActionListener{
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font17 = new Font("cambria",Font.BOLD,17);
	Font font18 = new Font("cambria",Font.BOLD,18);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField donorIdTextField,donorNameTextField,donorAgeTextField,donorDonationDayTextField,donorDonationMonthTextField,donorDonationYearTextField,amountDonatedTextField;
	JComboBox donorGenderComboBox,donorBloodGroupComboBox;
	JTextField searchTextField,deleteTextField,AmountDonatedTextField;
	JTextArea display;
	
	
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton;
	JButton backButton;
	DonorList donorList = new DonorList((short)1000);
	
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
	
	public DonorPage(){
		super("Blood Donor Database");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,750); //width, height
		this.setLocation(150,0); //X, Y
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(218,232,252));
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);

		//===========DEMO DATA=================
		FileIO.loadDonorsFromFile(donorList);
		
		//=================Image Example====================

	
		//============= Title ===========
		JLabel title = new JLabel("List Of Donors");
		title.setBounds(320,10,500,50); //X,Y,W,H
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
		
		JLabel donorIdLabel = new JLabel("ID");
		donorIdLabel.setBounds(20,top,200,30); //X,Y,W,H
		donorIdLabel.setFont(font15);
		
		donorIdTextField = new JTextField();
		donorIdTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorIdTextField.setFont(font15);
		
		
		JLabel donorNameLabel = new JLabel("Name");
		donorNameLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorNameLabel.setFont(font15);
		
		donorNameTextField = new JTextField();
		donorNameTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorNameTextField.setFont(font15);
		
		
		JLabel donorAgeLabel = new JLabel("Age");
		donorAgeLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorAgeLabel.setFont(font15);
		
		donorAgeTextField = new JTextField();
		donorAgeTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorAgeTextField.setFont(font15);
		
		JLabel donorGenderLabel  = new JLabel("Gender");
		donorGenderLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorGenderLabel.setFont(font15);
		
		String genders[] = {"Select Option","Male","Female","Other"};
		donorGenderComboBox = new JComboBox(genders);
		donorGenderComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorGenderComboBox.setFont(font15);
		
		JLabel donorBloodGroupLabel = new JLabel("Donor Blood Group");
		donorBloodGroupLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorBloodGroupLabel.setFont(font15);
		
		String bloodGroups[] = {"Select Option","A+","A-","B+","B-","AB+","AB-","O+","O-"};
		donorBloodGroupComboBox = new JComboBox(bloodGroups);
		donorBloodGroupComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,a
		donorBloodGroupComboBox.setFont(font15);
		
		JLabel donorLastDonatedLabel = new JLabel("Last Donated on");
		donorLastDonatedLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		donorLastDonatedLabel.setFont(font15);
		
		donorDonationDayTextField = new JTextField();
		donorDonationDayTextField.setBounds(20,top+=gap,60,30); //X,Y,W,H
		donorDonationDayTextField.setFont(font15);
		
		donorDonationMonthTextField = new JTextField();
		donorDonationMonthTextField.setBounds(90,top,60,30); //X,Y,W,H
		donorDonationMonthTextField.setFont(font15);
		
		donorDonationYearTextField = new JTextField();
		donorDonationYearTextField.setBounds(160,top,60,30); //X,Y,W,H
		donorDonationYearTextField.setFont(font15);
		
		
		
		JLabel amountDonatedTextLabel = new JLabel("Amount Donated");
		amountDonatedTextLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		amountDonatedTextLabel.setFont(font15);
		
		amountDonatedTextField = new JTextField();
		amountDonatedTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		amountDonatedTextField.setFont(font15);
		
		
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
		backGroundPanel.add(donorIdLabel);
		backGroundPanel.add(donorIdTextField);
		backGroundPanel.add(donorNameLabel);
		backGroundPanel.add(donorNameTextField);
		backGroundPanel.add(donorGenderLabel);
		backGroundPanel.add(donorGenderComboBox);
		backGroundPanel.add(donorAgeLabel);
		backGroundPanel.add(donorAgeTextField);
		backGroundPanel.add(donorLastDonatedLabel);
		backGroundPanel.add(donorDonationDayTextField);
		backGroundPanel.add(donorDonationMonthTextField);
		backGroundPanel.add(donorDonationYearTextField);
		backGroundPanel.add(donorBloodGroupLabel);
		backGroundPanel.add(donorBloodGroupComboBox);
		backGroundPanel.add(amountDonatedTextLabel);
		backGroundPanel.add(amountDonatedTextField);
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
		    String gender = (String)donorGenderComboBox.getSelectedItem();
		    String bloodGroup = (String)donorBloodGroupComboBox.getSelectedItem();
            try{
				if (donorList.getById(donorIdTextField.getText()) == null) {
                if (donorIdTextField.getText().isEmpty() &&
                    donorAgeTextField.getText().isEmpty() &&
                    donorNameTextField.getText().isEmpty() &&
                    donorAgeTextField.getText().isEmpty() &&
                    gender.equals("Select Option") &&
                    donorDonationDayTextField.getText().isEmpty()&&
                    donorDonationMonthTextField.getText().isEmpty()&&
                    donorDonationYearTextField.getText().isEmpty() &&
                    bloodGroup.equals("Select Option") &&
                    amountDonatedTextField.getText().isEmpty()){
						JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
                if (!donorIdTextField.getText().isEmpty() &&
                    !donorAgeTextField.getText().isEmpty() &&
                    !donorNameTextField.getText().isEmpty() &&
                    !donorAgeTextField.getText().isEmpty() &&
                    !gender.equals("Select Option") &&
                    !donorDonationDayTextField.getText().isEmpty()&&
                    !donorDonationMonthTextField.getText().isEmpty()&&
                    !donorDonationYearTextField.getText().isEmpty() &&
                    !bloodGroup.equals("Select Option") &&
                    !amountDonatedTextField.getText().isEmpty()) {
                    
                    BloodDonor b = new BloodDonor(donorIdTextField.getText(),
                                                  donorNameTextField.getText(),
                                                  Short.parseShort(donorAgeTextField.getText()),
												  gender,
												  bloodGroup,
												  Short.parseShort(donorDonationDayTextField.getText()),
												  Short.parseShort(donorDonationMonthTextField.getText()),
												  Short.parseShort(donorDonationYearTextField.getText()),
                                                  Float.parseFloat(amountDonatedTextField.getText()));
                    donorList.enter(b);
					FileIO.writeDonorInFile(b);
                    reloadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Id Already Used", "Error", JOptionPane.ERROR_MESSAGE);
            }
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}

        } else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");
		    String gender = (String)donorGenderComboBox.getSelectedItem();
		    String bloodGroup = (String)donorBloodGroupComboBox.getSelectedItem();
            BloodDonor b = donorList.getById(donorIdTextField.getText());
            try{
				if (b != null) {
                if (!donorNameTextField.getText().isEmpty()) {
                    b.setDonorName(donorNameTextField.getText());
                }
				if(!gender.equals("Select Option")){
					b.setDonorGender(gender);
				}
				if(!bloodGroup.equals("Select Option")){
					b.setDonorBloodGroup(bloodGroup);
				}
				if (!donorAgeTextField.getText().isEmpty()) {
                    b.setDonorAge(Short.parseShort(donorAgeTextField.getText()));
                }
                if (!donorDonationDayTextField.getText().isEmpty()) {
                    b.setDonationDay(Short.parseShort(donorDonationDayTextField.getText()));
                }
                if (!donorDonationMonthTextField.getText().isEmpty()) {
                    b.setDonationMonth(Short.parseShort(donorDonationMonthTextField.getText()));
                }
                if (!donorDonationYearTextField.getText().isEmpty()) {
                    b.setDonationYear(Short.parseShort(donorDonationYearTextField.getText()));
                }
                if (!amountDonatedTextField.getText().isEmpty()) {
                    b.setAmountDonated(Float.parseFloat(amountDonatedTextField.getText()));
                }
                reloadData();
				FileIO.updateDonorInFile(donorList);
                JOptionPane.showMessageDialog(this, "Donor Information is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Please input information to update", "Error", JOptionPane.WARNING_MESSAGE);
            }
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}

        } else if (searchButton == e.getSource()) {
            System.out.println("SEARCH CLICKED");
            BloodDonor b = donorList.getById(searchTextField.getText());
            if (b != null) {
                display.setText(b.getDonorAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No item Found with this ID");
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");
            BloodDonor b = donorList.getById(deleteTextField.getText());
            if (b != null) {
                donorList.removeById(deleteTextField.getText());
				FileIO.updateDonorInFile(donorList);
                reloadData();
            } else {
                JOptionPane.showMessageDialog(this, "No item Found with this ID", "Error", JOptionPane.WARNING_MESSAGE);
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
		display.setText(donorList.getAllDonorsAsString());
	}
	
}
