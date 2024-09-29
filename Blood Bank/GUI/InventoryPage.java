package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.BloodInventory;
import EntityList.InventoryList;
import File.FileIO;
@SuppressWarnings("unchecked")
public class InventoryPage extends JFrame implements ActionListener{
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font17 = new Font("cambria",Font.BOLD,17);
	Font font18 = new Font("cambria",Font.BOLD,18);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField idTextField,wbTextField,bpTextField,rbcTextField,plateTextField,cryopptTextField,expiryDayTextField,expiryMonthTextField,expiryYearTextField;
	JComboBox bgComboBox;
	JTextField searchTextField,deleteTextField;
	JTextArea display;
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton;
	JButton backButton;
	
	
	InventoryList inventoryList = new InventoryList((short)1000);
	
	class BackGroundPanel extends JPanel{
		Image backGroundImage = new ImageIcon("./Backup/background2.jpg").getImage();
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			double scaleFactor = 1.1;
			int newWidth = (int)(getWidth()*scaleFactor);
			int newHeight = (int)(getHeight()*scaleFactor);
			g.drawImage(backGroundImage,0,0,newWidth,newHeight,this);
		}
	}
	
	public JFrame previousPage;
	
	public InventoryPage(){
		super("Blood Product Database");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,850); //width, height
		this.setLocation(150,0); //X, Y
		ImageIcon icon = new ImageIcon("./Backup/icon.jpeg");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(218,232,252));
		
		BackGroundPanel backGroundPanel = new BackGroundPanel();		
		backGroundPanel.setLayout(null);

		//===========DEMO DATA=================
		FileIO.loadItemsFromFile(inventoryList);
		
		//=================Image Example====================

	
		//============= Title ===========
		JLabel title = new JLabel("Blood Product Inventory");
		title.setBounds(260,10,500,50); //X,Y,W,H
		title.setFont(titleFont);
		//=========== Sub Title ==========
		JLabel subTitle = new JLabel("INFORMATIONS");
		subTitle.setBounds(330,60,320,50); //X,Y,W,H
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		
		
		//////////////////////////////////////////////////////////////////////////////
		//---------------------- LEFT SIDE COMPONENTS ------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		//======= Entry Form ===========
		int top = 40;
		int gap = 40;
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(20,top,200,30); //X,Y,W,H
		idLabel.setFont(font15);
		
		idTextField = new JTextField();
		idTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		idTextField.setFont(font15);
		
		
		JLabel bgLabel = new JLabel("Blood Group");
		bgLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		bgLabel.setFont(font15);
		
		String bloodGroups[] = {"Select Option","A+","A-","B+","B-","AB+","AB-","O+","O-"};
		bgComboBox = new JComboBox(bloodGroups);
		bgComboBox.setBounds(20,top+=gap,200,30); //X,Y,W,H
		bgComboBox.setFont(font15);
		
		
		
		JLabel wbLabel = new JLabel("Whole Blood Quantity");
		wbLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		wbLabel.setFont(font15);
		
		wbTextField = new JTextField();
		wbTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		wbTextField.setFont(font15);
		
		
		JLabel bpLabel = new JLabel("Blood Plasma Quantity");
		bpLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		bpLabel.setFont(font15);
		
		bpTextField = new JTextField();
		bpTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		bpTextField.setFont(font15);
		
		
		JLabel rbcLabel = new JLabel("Red Blood Cell Quantity");
		rbcLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		rbcLabel.setFont(font15);
		
		rbcTextField = new JTextField();
		rbcTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		rbcTextField.setFont(font15);
		
		
		JLabel plateLabel = new JLabel("Platelet Quantity");
		plateLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		plateLabel.setFont(font15);
		
		plateTextField = new JTextField();
		plateTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		plateTextField.setFont(font15);
		
		
		JLabel cryopptLabel = new JLabel("Cryoprecipitate Quantity");
		cryopptLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		cryopptLabel.setFont(font15);
		
		cryopptTextField = new JTextField();
		cryopptTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		cryopptTextField.setFont(font15);
		
		
		JLabel expiryLabel = new JLabel("Expiry Date");
		expiryLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		expiryLabel.setFont(font15);
		
		expiryDayTextField = new JTextField();
		expiryDayTextField.setBounds(20,top+=gap,60,30); //X,Y,W,H
		expiryDayTextField.setFont(font15);
		
		expiryMonthTextField = new JTextField();
		expiryMonthTextField.setBounds(90,top,60,30); //X,Y,W,H
		expiryMonthTextField.setFont(font15);
		
		expiryYearTextField = new JTextField();
		expiryYearTextField.setBounds(160,top,60,30); //X,Y,W,H
		expiryYearTextField.setFont(font15);
		
		
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
		backGroundPanel.add(idLabel);
		backGroundPanel.add(idTextField);
		backGroundPanel.add(bgLabel);
		backGroundPanel.add(bgComboBox);
		backGroundPanel.add(wbLabel);
		backGroundPanel.add(wbTextField);
		backGroundPanel.add(bpLabel);
		backGroundPanel.add(bpTextField);
		backGroundPanel.add(rbcLabel);
		backGroundPanel.add(rbcTextField);
		backGroundPanel.add(plateLabel);
		backGroundPanel.add(plateTextField);
		backGroundPanel.add(cryopptLabel);
		backGroundPanel.add(cryopptTextField);
		backGroundPanel.add(expiryLabel);
		backGroundPanel.add(expiryDayTextField);
		backGroundPanel.add(expiryMonthTextField);
		backGroundPanel.add(expiryYearTextField);
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
			String bloodGroup = (String)bgComboBox.getSelectedItem();
			try{
				if (inventoryList.getById(idTextField.getText()) == null) {
                
				if (idTextField.getText().isEmpty() &&
                    bloodGroup.equals("Select Option") &&
                    wbTextField.getText().isEmpty() &&
                    bpTextField.getText().isEmpty() &&
                    rbcTextField.getText().isEmpty() &&
                    plateTextField.getText().isEmpty() &&
                    cryopptTextField.getText().isEmpty() &&
                    expiryDayTextField.getText().isEmpty()&&
                    expiryMonthTextField.getText().isEmpty()&&
                    expiryYearTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
                    return;					
					}
				
				else if (!idTextField.getText().isEmpty() &&
                    !bloodGroup.equals("Select Option") &&
                    !wbTextField.getText().isEmpty() &&
                    !bpTextField.getText().isEmpty() &&
                    !rbcTextField.getText().isEmpty() &&
                    !plateTextField.getText().isEmpty() &&
                    !cryopptTextField.getText().isEmpty() &&
                    !expiryDayTextField.getText().isEmpty()&&
                    !expiryMonthTextField.getText().isEmpty()&&
                    !expiryYearTextField.getText().isEmpty()) {
                    
                    BloodInventory b = new BloodInventory(idTextField.getText(),
                                                          bloodGroup,
                                                          Float.parseFloat(wbTextField.getText()),
                                                          Float.parseFloat(bpTextField.getText()),
                                                          Float.parseFloat(rbcTextField.getText()),
                                                          Float.parseFloat(plateTextField.getText()),
                                                          Float.parseFloat(cryopptTextField.getText()),
                                                          Short.parseShort(expiryDayTextField.getText()),
                                                          Short.parseShort(expiryMonthTextField.getText()),
                                                          Short.parseShort(expiryYearTextField.getText()));
                    inventoryList.enter(b);
					FileIO.writeItemInFile(b);
                    reloadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Please Provide All Information", "Missing Data", JOptionPane.ERROR_MESSAGE);
                }
            }   else {
                JOptionPane.showMessageDialog(this, "Id Already Used", "Error", JOptionPane.ERROR_MESSAGE);
            }
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}
            

        } else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");
			String bloodGroup = (String)bgComboBox.getSelectedItem();
            BloodInventory b = inventoryList.getById(idTextField.getText());			
            try{
				if (b != null) {
				if(!bloodGroup.equals("Select Option")){
					b.setBloodGroup(bloodGroup);
				}
                if (!wbTextField.getText().isEmpty()) {
                    b.setWholeBloodAmount(Float.parseFloat(wbTextField.getText()));
                }
                if (!bpTextField.getText().isEmpty()) {
                    b.setBloodPlasmaAmount(Float.parseFloat(bpTextField.getText()));
                }
                if (!rbcTextField.getText().isEmpty()) {
                    b.setRBCAmount(Float.parseFloat(rbcTextField.getText()));
                }
                if (!plateTextField.getText().isEmpty()) {
                    b.setPlateletAmount(Float.parseFloat(plateTextField.getText()));
                }
                if (!cryopptTextField.getText().isEmpty()) {
                    b.setCryoPPTAmount(Float.parseFloat(cryopptTextField.getText()));
                }
                if (!expiryDayTextField.getText().isEmpty()) {
                    b.setExpiryDay(Short.parseShort(expiryDayTextField.getText()));
                }
                if (!expiryMonthTextField.getText().isEmpty()) {
                    b.setExpiryMonth(Short.parseShort(expiryMonthTextField.getText()));
                }
                if (!expiryYearTextField.getText().isEmpty()) {
                    b.setExpiryYear(Short.parseShort(expiryYearTextField.getText()));
                }
                reloadData();
				FileIO.updateItemInFile(inventoryList);
                JOptionPane.showMessageDialog(this, "Item Information is Updated");
            } else if(b == null ){
                JOptionPane.showMessageDialog(this, "No item found with this ID", "Error", JOptionPane.WARNING_MESSAGE);
            }
			else{
				JOptionPane.showMessageDialog(this, "Please input information to update", "Error", JOptionPane.WARNING_MESSAGE);
			}
			}
			catch(Exception exp){
				System.out.println("Invalid Input");
			}
			

        } 
		else if (searchButton == e.getSource()) {
            System.out.println("SEARCH CLICKED");
            BloodInventory b = inventoryList.getById(searchTextField.getText());
            if (b != null) {
                display.setText(b.getItemAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No item Found with this ID");
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");
            BloodInventory b = inventoryList.getById(deleteTextField.getText());
            if (b != null) {
                inventoryList.removeById(deleteTextField.getText());
				FileIO.updateItemInFile(inventoryList);
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
		display.setText(inventoryList.getAllItemsAsString());
	}	
}
