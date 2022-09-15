import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings({ "serial", "unused" })
public class F_M_MainClass extends JFrame{
	
	
	InputStream input = null;
	FileOutputStream output = null;
	
	
	
	
	public static Connection con;
	public static CallableStatement cs;
	
	public static int no, pDocIds,  docN, nvisit, lab_lq_id, lab_ht_id, mroMax, labMax, phamMax, ids, mroQueue,phamQueue, rol, rol1, lUsers, lCourse, lHistory, lInitial, lLab, lNok, lParents, lImg, lPatients, lPham;
	
	public static String aUsername, aPassword, aPost, dashName1, Chk, chk, date,name, dis="0", p_qu1="0",fileName;
	
	public static int theEmId [],tll [], h_p_id[], pham_id [], allIds[], phamid[], phamidQ[], p_qu[], labidQ [], labp_qu[], labid [], pDocHId [], pDocId [];
	
	public static String theEmDept [], theEmName [],h_pProcess[], h_pName [], phamName[],phamMedicText[], labTest [], pham_pName[], lab_pName[], Doch_pName[];
	
	
	public static ImageIcon ic1,nic1;
	static ImageIcon passport = new ImageIcon("img/passport.png");
	ImageIcon logo = new ImageIcon("img/FUOYE.png");
	ImageIcon medical = new ImageIcon("img/Medical Blue.png");
	ImageIcon sSearch = new ImageIcon("img/sSearch.png");
	ImageIcon mSearch = new ImageIcon("img/mSearch.png");
	ImageIcon queueImage = new ImageIcon("img/queue.png");
	public static ImageIcon img = new ImageIcon();
	public static ImageIcon img2 = new ImageIcon();
	
	public static Image image1,mimg1;
	
	JButton labExit = new JButton("Exit");
	JButton docExit = new JButton("Exit");
	JButton phamExit = new JButton("Exit");
	JButton lgBtn = new JButton("Login");
	JButton lgBtn2 = new JButton("Check");
	JButton cancle = new JButton("Cancel");
	JButton cancle2 = new JButton("Cancel");
	JButton submit = new JButton("Submit");
	JButton OutBt = new JButton("Cancel");
	JButton cancle1 = new JButton("Cancel");
	JButton cancel2 = new JButton("Cancel");
	JButton cancle3 = new JButton("Cancel");
	JButton check = new JButton("Check");
	JButton emergency = new JButton("Emergency");
	JButton queue = new JButton("Queue");
	JButton register = new JButton("Register");
	JButton check2 = new JButton("Check");
	JButton Back = new JButton("Back");
	JButton eBack = new JButton("Back");
	JButton next1 = new JButton("Next");
	JButton next2 = new JButton("Next");
	JButton rDone = new JButton("Done");
	JButton Continue = new JButton("Continue");
	JButton LabSentBT = new JButton("Send");
	JButton medicationBT = new JButton("Send");
	JButton FinalDoctorDone = new JButton("Done");
	JButton DoctorReject = new JButton("Reject");
	JButton phamDoneBt = new JButton("Done");
	JButton phamRejectBt = new JButton("Reject");
	JButton mainBack = new JButton("Back");
	JButton LabRefBt = new JButton("Refresh");
	JButton refresh = new JButton("Refresh");
	JButton labDoneBt = new JButton("Done");
	JButton photo = new JButton("Photo");
	JButton DocRefresh = new JButton("Refresh");
	JButton imgBack = new JButton("Back");
	JButton imgNext = new JButton("Next");
	
	
	
	
	
	JPasswordField password = new JPasswordField("");
	
	public static JTextField userName = new JTextField("");
	public static JTextField cardNumber = new JTextField("");
	public static JTextField eSurName = new JTextField("",12);
	public static JTextField eFirstName = new JTextField("",12);
	public static JTextField surnamea = new JTextField();
	public static JTextField firstNamea = new JTextField();
	public static JTextField middleNamea = new JTextField();
	public static JTextField blooda = new JTextField();
	public static JTextField genotypea = new JTextField();
	public static JTextField pNumbera = new JTextField();
	public static JTextField DOBy = new JTextField("Year");
	public static JTextField heighta = new JTextField();
	public static JTextField entryLevela = new JTextField();
	public static JTextField entryYeara = new JTextField();
	public static JTextField pSurnamea = new JTextField();
	public static JTextField pFirstNamea = new JTextField();
	public static JTextField pPNumbera = new JTextField();
	public static JTextField nSurnamea = new JTextField();
	public static JTextField nFirstNamea = new JTextField();
	public static JTextField nPNumbera = new JTextField();
	public static JTextField sugarLevel = new JTextField("0");
	public static JTextField pregnancy = new JTextField("NA");
	public static JTextField Typhoid = new JTextField("NA");
	public static JTextField fbs = new JTextField("0");
	public static JTextField rbs = new JTextField("0");
	public static JTextField malarialParasite = new JTextField("NA");
	public static JTextField weight = new JTextField();
	public static JTextField xRC = new JTextField();
	public static JTextField eyesTest = new JTextField();
	public static JTextField breastTest = new JTextField();
	public static JTextField pad1 = new JTextField();
	public static JTextField pad2 = new JTextField();
	public static JTextField pad3 = new JTextField();
	public static JTextField pad4 = new JTextField();
	public static JTextField pad5 = new JTextField();
	public static JTextField pad6 = new JTextField();
	public static JTextField pad7 = new JTextField();
	public static JTextField pad8 = new JTextField();
	public static JTextField pad9 = new JTextField();
	public static JTextField pad10 = new JTextField();
	public static JTextField pad11 = new JTextField();
	public static JTextField padGenoType = new JTextField();
	public static JTextField pad12 = new JTextField();
	public static JTextField pad13 = new JTextField();
	public static JTextField pad14 = new JTextField();
	public static JTextField pad15 = new JTextField();
	public static JTextField pad16 = new JTextField();
	public static JTextField pad17 = new JTextField();
	public static JTextField pad18 = new JTextField();
	public static JTextField pad19 = new JTextField();
	public static JTextField pad20 = new JTextField();
	public static JTextField pad21 = new JTextField();
	public static JTextField pad22 = new JTextField();
	public static JTextField pad23 = new JTextField();
	public static JTextField pad24 = new JTextField();
	public static JTextField pad25 = new JTextField();
	public static JTextField pad26 = new JTextField();
	public static JTextField pad27 = new JTextField();
	public static JTextField weight2 = new JTextField();
	public static JTextField temperature = new JTextField();
	public static JTextField temperature2 = new JTextField();
	public static JTextField bp2 = new JTextField();
	public static JTextField bp = new JTextField();
	public static JTextField mfDoctor = new JTextField();
	public static JTextField nVisit = new JTextField();	
	public static JTextField DLK = new JTextField("   DOCTOR");
	public static JTextField DocdashName1 = new JTextField();
	public static JTextField newBPResult = new JTextField();
	public static JTextField newTempResult = new JTextField();
	public static JTextField newWeightResult = new JTextField();
	public static JTextField AttendentdashName1 = new JTextField();
	public static JTextField PLK = new JTextField("   PHARMACIST");
	public static JTextField phamPName = new JTextField(20);
	public static JTextField labPName = new JTextField(20);
	public static JTextField LLK = new JTextField(" LAB ATTENDANT");
	public static JTextField LabAttendentdashName1 = new JTextField();
	public static JTextField lab_test = new JTextField(18);
	public static JTextField FBSCheck = new JTextField("0");
	public static JTextField RBSCheck = new JTextField("0");
	public static JTextField malarialCheck = new JTextField("NA");
	public static JTextField pregnancyCheck = new JTextField("NA");
	public static JTextField sugarCheck = new JTextField("0");
	public static JTextField typhoidCheck = new JTextField("NA");
	
	public static JTextField dashName = new JTextField();
	
	public static JTextArea addressa = new JTextArea();
	public static JTextArea pAddressa = new JTextArea();
	public static JTextArea nAddressa = new JTextArea();
	public static JTextArea newLabTestResult = new JTextArea();
	public static JTextArea RemarkA = new JTextArea();
	public static JTextArea TestA = new JTextArea();
	public static JTextArea MedicationA = new JTextArea();
	public static JTextArea MedicationText = new JTextArea();
	public static JTextArea newDoctorRemark = new JTextArea();
	public static JTextArea prisMedication = new JTextArea("Prescribed Drugs");
	public static JTextArea RFRegection = new JTextArea();
	public static JTextArea VitalSignA = new JTextArea();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox gendera = new JComboBox(new Object[]{"M","F"});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox facultya = new JComboBox(new Object[] {"AGRICULTURE","ART","EDUCATION","ENGINEERING","MANAGEMENT SCIENCES","SCIENCES","SOCIAL SCIENCES"});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox departmenta = new JComboBox(new Object[] {"AGR. ECO. & EXT","ANIMAL PDT. & HEALTH","SOIL SC & LAND RSC. MGT.","CROP SC. & HCTR","FISHERY & AQUAC","FOOD SC & TECH","HST AND TOURISM MGT.","WATER RSC. MGT & AGRO."});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox DOBm = new JComboBox(new Object[] {"Month","1","2","3","4","5","6","7","8","9","10","11","12"});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox DOBd = new JComboBox(new Object[] {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox eFaculty = new JComboBox(new Object[] {"AGRICULTURE","ART","EDUCATION","ENGINEERING","MANAGEMENT SCIENCES","SCIENCES","SOCIAL SCIENCES"});
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox eDepartment = new JComboBox(new Object[] {"AGR. ECO. & EXT","ANIMAL PDT. & HEALTH","SOIL SC & LAND RSC. MGT.","CROP SC. & HCTR","FISHERY & AQUAC","FOOD SC & TECH","HST AND TOURISM MGT.","WATER RSC. MGT & AGRO."});
	
	
	
	
	@SuppressWarnings("rawtypes")
	public static DefaultListModel dlm = new DefaultListModel();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JList lst = new JList(dlm);
	
	
	
	
	
	
	public static JCheckBox UrineTestCheckBox = new JCheckBox("Urine Test");
	public static JCheckBox BloodTestCheckBox = new JCheckBox("Blood Test");
	
	public static JPanel emergencyPage = new JPanel(new BorderLayout());
	public static JPanel LgPag2 = new JPanel();
	public static JPanel mainMRPagePanel = new JPanel();
	public static JPanel aCentrePanel = new JPanel();
	public static JPanel a_mainPage = new JPanel(new BorderLayout());
	public static JPanel ddcenter = new JPanel(new GridLayout(5,6,4,4));
	public static JPanel checkPage = new JPanel(new BorderLayout());
	public static JPanel registerPanel = new JPanel(new GridLayout(1,1));
	public static JPanel imagePanel = new JPanel();
	public static JPanel laboratory = new JPanel(new BorderLayout());
	public static JPanel LabCenter = new JPanel();
	public static JPanel pharmacy = new JPanel(new BorderLayout());
	public static JPanel phamacyQueue = new JPanel();
	public static JPanel phamacyCenter = new JPanel();
	public static JPanel J = new JPanel(new GridLayout(1,1));
	public static JPanel ee = new JPanel(new FlowLayout(FlowLayout.CENTER));
	public static JPanel eeList = new JPanel(new BorderLayout());
	public static JPanel lgPage = new JPanel();
	//public static JPanel searchCenter1; = new JPanel(new BorderLayout());
	
	
	
	
	public static JScrollPane addressScroll = new JScrollPane(addressa);
	public static JScrollPane SpAddressa = new JScrollPane(pAddressa);
	public static JScrollPane SnAddressa = new JScrollPane(nAddressa);
	public static JScrollPane VitalSignTA = new JScrollPane(VitalSignA);
	public static JScrollPane RemarkTA = new JScrollPane(RemarkA);
	public static JScrollPane TestTA = new JScrollPane(TestA);
	public static JScrollPane MedicationTA = new JScrollPane(MedicationA);
	public static JScrollPane newLabTestResults = new JScrollPane(newLabTestResult);
	public static JScrollPane medicationText = new JScrollPane(MedicationText);
	public static JScrollPane newDoctorRemarkScroll = new JScrollPane(newDoctorRemark);
	public static JScrollPane prisMedicationScroll = new JScrollPane(prisMedication);
	public static JScrollPane RFRegectionScroll = new JScrollPane(RFRegection);
	
	
	
	public static JLabel pixLabel = new JLabel();
	public static JLabel imgLLabel = new JLabel(passport);
	
	JTabbedPane registerTab = new JTabbedPane();
	
	
	
	public static CardLayout MasterCard = new CardLayout();
	public static CardLayout phamacyCard = new CardLayout();
	public static CardLayout LabCard = new CardLayout();
	public static CardLayout LgCard = new CardLayout();
	
	Handler listener = new Handler();
	
	HistoryList IListener = new HistoryList();
	
	public static FileOutputStream fos = null;
	
	static JCheckBox remoteCheckBox = new JCheckBox();
	
	public void frameOne() {
		
		LgPag2.setLayout(LgCard);
		
		JPanel lgP = new JPanel(new BorderLayout());
		JLabel greetings = new JLabel("WELCOME");
		greetings.setForeground(Color.GREEN);
		greetings.setFont(new Font("Time new Romans", Font.BOLD,30));
		
		lgP.add(new JLabel("                              "),BorderLayout.WEST);
		lgP.add(greetings,BorderLayout.CENTER);
		JPanel quitPanel = new JPanel(new GridLayout(1,6));
		JButton dkkd = new JButton("QUIT");
		quitPanel.add(dkkd);
		dkkd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
			
		
		
		lgPage.setLayout(new BorderLayout());
		JPanel lgPage1 = new JPanel();
		
		JPanel lgPage2 = new JPanel();
		
		lgBtn.setBackground(new Color(13,153,3));
		lgBtn.setFont(new Font("Calibril",Font.BOLD,14));
		lgBtn.setToolTipText("Click her to Login");
		cancle.setBackground(Color.red);
		cancle.setFont(new Font("Calibril",Font.BOLD,12));
		cancle.setToolTipText("Click here to Exit");
		userName.setFont(new Font("Calibril",Font.BOLD,14));
		userName.setToolTipText("Enter your username to login as an authorized user");
		password.setFont(new Font("Calibril",Font.BOLD,14));
		password.setToolTipText("Enter your password here");
		
		
		lgBtn.addActionListener(listener);
		cancle.addActionListener(listener);		
		
		JLabel lglname = new JLabel(" FUOYE MEDIC");
		lglname.setFont(new Font("Calibril",Font.BOLD,52));
		lglname.setForeground(new Color(13,153,3));
		
		lgPage1.setLayout(new BorderLayout());
		JPanel pl = new JPanel(new GridLayout(7,1,4,4));
		pl.add(new JLabel(""));
		pl.add(new JLabel(""));
		pl.add(new JLabel(""));
		pl.add(new JLabel("  User Name   "));
		pl.add(new JLabel("  Password   "));
		pl.setBackground(new Color(239,240,246));
		
		JPanel pll = new JPanel(new GridLayout(7,1,4,4));
		pll.add(new JLabel(""));
		pll.add(new JLabel(""));
		pll.add(new JLabel(""));
		pll.add(userName);
		pll.add(password);
		pll.add(new JLabel(""));
		pll.add(new JCheckBox("Allow remote access"));
		pll.setBackground(new Color(239,240,246));
		
		lgPage1.add(pl, BorderLayout.WEST);
		lgPage1.add(pll, BorderLayout.CENTER);
		lgPage1.add(new JLabel("   "), BorderLayout.EAST);
		
		lgPage2.setLayout(new GridLayout(1,4,4,4));
		lgPage2.add(new JLabel(""));
		lgPage2.add(lgBtn);
		lgPage2.add(new JLabel(""));
		lgPage2.add(cancle);
		lgPage2.add(new JLabel(""));
		
		lgPage1.add(lgPage2, BorderLayout.SOUTH);
		
		JPanel lgPage3 = new JPanel(new GridLayout(7,1));
		for (int i=0; i<6;i++) {
			lgPage3.add(new JLabel(""));
		}
		lgPage3.add(new JLabel("                                       BAYODE BLESSING AKINBOLA, CSC/2017/1072"));
		
		lgPage1.setBackground(new Color(239,240,246));
		lgPage2.setBackground(new Color(239,240,246));
		
		lgPage.add(lglname, BorderLayout.NORTH);
		lgPage.add(lgPage1, BorderLayout.CENTER);
		lgPage.add(lgPage3, BorderLayout.SOUTH);
		
		LgPag2.add(lgPage,"Home");
		LgPag2.add(lgP,"Loged");
		
		add(LgPag2);
		
	}
	
	// ---------FRAME TWO------------------------------------------------------------------------------------------------------
	
	public void frameTwo() {
		aCentrePanel.setLayout(MasterCard);
		setLayout(new BorderLayout());
		mainMRPagePanel.setLayout(new BorderLayout());
		
		check.addActionListener(listener);
		check2.addActionListener(listener);
		emergency.addActionListener(listener);
		Back.addActionListener(listener);
		register.addActionListener(listener);
		queue.addActionListener(listener);
		lgBtn2.addActionListener(listener);
		eBack.addActionListener(listener);
		OutBt.addActionListener(listener);
		Continue.addActionListener(listener);
		cancle1.addActionListener(listener);
		cancle2.addActionListener(listener);
		cancel2.addActionListener(listener);
		submit.addActionListener(listener);
		cancle3.addActionListener(listener);
		next1.addActionListener(listener);
		next2.addActionListener(listener);
		rDone.addActionListener(listener);
		LabSentBT.addActionListener(listener);
		medicationBT.addActionListener(listener);
		FinalDoctorDone.addActionListener(listener);
		DoctorReject.addActionListener(listener);
		phamDoneBt.addActionListener(listener);
		photo.addActionListener(listener);
		
		
		JPanel FuoyeTopPanel = new JPanel(new BorderLayout());
		JLabel lglname = new JLabel("                FUOYE MEDIC");
		lglname.setFont(new Font("Calibril",Font.BOLD,70));
		lglname.setForeground(new Color(233,229,89));
		
		FuoyeTopPanel.setBackground(new Color(13,153,3));
		FuoyeTopPanel.add(new JLabel(logo), BorderLayout.WEST);
		FuoyeTopPanel.add(lglname, BorderLayout.CENTER);
		
		
// CENTRE PANELS
				
		dashName.setForeground(Color.blue);
		dashName.setFont(new Font("Calibril",Font.BOLD,16));
		dashName.setEditable(false);
		//dashName.setBackground(Color.red);
		dashName.setBorder(null);
		
		JPanel dashboard = new JPanel(new BorderLayout());
		dashboard.setBackground(new Color(245,247,253));
		JPanel dashTop = new JPanel(new GridLayout(1,1));
		dashTop.add(dashName, BorderLayout.CENTER);
		
		check.setBackground(Color.GRAY);
		check.setFont(new Font("Calibril",Font.BOLD,22));
		check.setForeground(Color.WHITE);
		check.setToolTipText("Click to check for patient's records");
		emergency.setBackground(Color.RED);
		emergency.setFont(new Font("Calibril",Font.BOLD,22));
		emergency.setForeground(Color.WHITE);
		emergency.setToolTipText("Click to performe a random search of file for an emergency patient");
		queue.setBackground(Color.GRAY);
		queue.setFont(new Font("Calibril",Font.BOLD,22));
		queue.setForeground(Color.WHITE);
		queue.setToolTipText("Check for patient's queue");
		register.setBackground(Color.GRAY);
		register.setFont(new Font("Calibril",Font.BOLD,22));
		register.setForeground(Color.WHITE);
		register.setToolTipText("Click to register a new Patient (Medical Record Officers Only)");
		cancle1.setFont(new Font("Calibril",Font.PLAIN,11));
		cancle1.setBackground(Color.RED);
		cancle1.setToolTipText("Click to cancel the registration");
		cancle2.setFont(new Font("Calibril",Font.BOLD,14));
		cancle2.setBackground(Color.RED);
		cancle2.setToolTipText("Click to cancel the registration");
		cancle3.setFont(new Font("Calibril",Font.PLAIN,8));
		cancle3.setBackground(Color.RED);
		cancle3.setToolTipText("Click to cancel the registration");
		next1.setFont(new Font("Calibril",Font.BOLD,16));
		next1.setBackground(Color.GREEN);
		next2.setFont(new Font("Calibril",Font.BOLD,16));
		next2.setBackground(Color.GREEN);
		rDone.setFont(new Font("Calibril",Font.BOLD,10));
		rDone.setBackground(Color.GREEN);
		
		
		
		
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(check);
		ddcenter.add(new JLabel(""));
		ddcenter.add(emergency);
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(queue);
		ddcenter.add(new JLabel(""));
		ddcenter.add(register);
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		ddcenter.add(new JLabel(""));
		
		dashboard.add(dashTop, BorderLayout.NORTH);
		dashboard.add(ddcenter,BorderLayout.CENTER);
		
		a_mainPage.setBackground(new Color(161,181,137));
		a_mainPage.add(new JLabel(medical),BorderLayout.WEST);
		a_mainPage.add(dashboard, BorderLayout.CENTER);
		
//CHECK PANEL
		
		checkPage.setBackground(new Color(161,181,137));
		check2.setFont(new Font("Calibril",Font.BOLD,22));
		cardNumber.setFont(new Font("Calibril",Font.BOLD,20));
		Back.setBackground(Color.red);
		Back.setFont(new Font("Calibril",Font.BOLD,13));
		OutBt.setBackground(Color.red);
		Continue.setBackground(Color.GREEN);
		Continue.setFont(new Font("Calibril",Font.BOLD,10));
		cancel2.setBackground(Color.red);
		submit.setBackground(Color.GREEN);
		
		JPanel cC = new JPanel(new GridLayout(2,3));
		cC.add(new JLabel(""));
		cC.add(new JLabel(""));
		cC.add(new JLabel(""));
		cC.add(new JLabel(""));
		cC.add(Back);
		cC.add(new JLabel(""));
		
		JLabel ccc = new JLabel("Card Number");
		ccc.setFont(new Font("Calibril",Font.BOLD,20));
		JPanel cc = new JPanel(new GridLayout(2,1));
		cc.add(ccc);
		cc.setFont(new Font("Calibril",Font.BOLD,20));
		cc.add(cC);
		
		JPanel cc2 = new JPanel(new GridLayout(2,1,4,4));
		cc2.add(cardNumber);
		cc2.add(check2);
		
		JPanel cBody = new JPanel(new GridLayout(5,6,4,4));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(cc);
		cBody.add(cc2);
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		cBody.add(new JLabel(""));
		
		checkPage.add(new JLabel(sSearch),BorderLayout.WEST);
		checkPage.add(cBody,BorderLayout.CENTER);
		

		
		
//REGISTRATION PANEL
		JLabel surname = new JLabel("                             Surname:");
		surname.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel firstName = new JLabel("                             First name:");
		firstName.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel middleName = new JLabel("                             Middle name:");
		middleName.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel gender = new JLabel("                             Gender:");
		gender.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel DOB = new JLabel("                             Date of Birth:");
		DOB.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel height = new JLabel("                             Height:");
		height.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel pNumbe = new JLabel("                           Phone number:");
		pNumbe.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel address = new JLabel("                             Address:");
		address.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel faculty = new JLabel("                             Faculty:");
		faculty.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel department = new JLabel("                             Department:");
		department.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel entryLevel = new JLabel("                             Entry Level:");
		entryLevel.setFont(new Font("Calibril",Font.PLAIN,16));
		JLabel entryYear = new JLabel("                             Admission Year:");
		entryYear.setFont(new Font("Calibril",Font.PLAIN,14));
		
		surnamea.setFont(new Font("Calibril",Font.PLAIN,16));
		firstNamea.setFont(new Font("Calibril",Font.PLAIN,16));
		middleNamea.setFont(new Font("Calibril",Font.PLAIN,16));
		gendera.setFont(new Font("Calibril",Font.PLAIN,16));
		DOBy.setFont(new Font("Calibril",Font.PLAIN,16));
		heighta.setFont(new Font("Calibril",Font.PLAIN,16));
		pNumbera.setFont(new Font("Calibril",Font.PLAIN,16));
		blooda.setFont(new Font("Calibril",Font.PLAIN,16));
		genotypea.setFont(new Font("Calibril",Font.PLAIN,16));
		addressa.setFont(new Font("Calibril",Font.PLAIN,16));
		facultya.setFont(new Font("Calibril",Font.PLAIN,16));
		departmenta.setFont(new Font("Calibril",Font.PLAIN,16));
		entryYeara.setFont(new Font("Calibril",Font.PLAIN,16));
		entryLevela.setFont(new Font("Calibril",Font.PLAIN,16));
		surnamea.setFont(new Font("Calibril",Font.PLAIN,16));
		
		
		
		
		facultya.addItemListener((ItemListener) new ItemListener() {
			@SuppressWarnings("unchecked")
			public void itemStateChanged(ItemEvent ie) {
				
				String it2=facultya.getSelectedItem().toString();
				
				departmenta.removeAllItems();
				
				String agric [] = {"AGR. ECO. & EXT","ANIMAL PDT. & HEALTH","SOIL SC & LAND RSC. MGT.","CROP SC. & HCTR","FISHERY & AQUAC","FOOD SC & TECH","HST AND TOURISM MGT.","WATER RSC. MGT & AGRO."};
				String art [] = {"ENG. & LIT. STUDIES","HIS. & INT STUDIES","LIN. & LANGUAGES","THR. & MED. ARTS"};
				String edu [] = {"EDUCATIONAL FOUNDATION","EDU. MGT & BUS. STUDIES","LIBRARY & INFO. SC.","BIOLOGY EDUCATION","MATHS. EDUCATION"};
				String eng [] = {"AGRIC & BIO-RESOURCES","CIVIL ENGINEERING","COMPUTER ENGINEERING","ELECTRICAL & ELEC. ENG","MECHANICAL ENGINEERING","MECHATRONICS ENGINEERING","METALLUGICAL & MAT. ENG."};
				String mgt [] = {"ACCOUNTING","BANKING & FINANCE","BUS. ADMIN","PUBLIC ADMIN."};
				String sciences [] = {"ANIMAL & ENV. BIO.","BIOCHEMISTRY","COMPUTER SCIENCES","INDUSTRIAL CHEM.","MATHEMATICS","MICROBIOLOGY","PLANT SC. & BIOTECH."};
				String ss [] = {"CRIMINOLOGY & SEC. STUDIES","DEMOGRAPHY & SOC. STAT.","ECON. & DEV. STUDIES","MASS COMMUNICATION","PEACE & CONFLICT RESL.","POLITICAL SCIENCE","SOCIOLOGY"};
				if (it2.contentEquals("ART")) {
					for (int i=0;i<art.length;i++) {
						String tak =  art[i];
						departmenta.addItem(tak);
					}
				}
				
				else if (it2.equals("SCIENCES")) {
					
					for (int i=0;i<sciences.length;i++) {
						String tak =  sciences[i];
						departmenta.addItem(tak);
					}
				}
				else if (it2.equals("AGRICULTURE")) {
					
					for (int i=0;i<agric.length;i++) {
						String tak =  agric[i];
						departmenta.addItem(tak);
					}
				}
				else if (it2.equals("EDUCATION")) {
					
					for (int i=0;i<edu.length;i++) {
						String tak =  edu[i];
						departmenta.addItem(tak);
					}
				}
				else if (it2.equals("ENGINEERING")) {
					
					for (int i=0;i<eng.length;i++) {
						String tak =  eng[i];
						departmenta.addItem(tak);
					}
				}
				else if (it2.equals("MANAGEMENT SCIENCES")) {
					
					for (int i=0;i<mgt.length;i++) {
						String tak =  mgt[i];
						departmenta.addItem(tak);
					}
				}
				else if (it2.equals("SOCIAL SCIENCES")) {
					
					for (int i=0;i<ss.length;i++) {
						String tak =  ss[i];
						departmenta.addItem(tak);
					}
				}
			}
		});
		
		eFaculty.addItemListener((ItemListener) new ItemListener() {
			@SuppressWarnings("unchecked")
			public void itemStateChanged(ItemEvent ie) {
				
				String it2=eFaculty.getSelectedItem().toString();
				
				eDepartment.removeAllItems();
				
				String agric [] = {"AGR. ECO. & EXT","ANIMAL PDT. & HEALTH","SOIL SC & LAND RSC. MGT.","CROP SC. & HCTR","FISHERY & AQUAC","FOOD SC & TECH","HST AND TOURISM MGT.","WATER RSC. MGT & AGRO."};
				String art [] = {"ENG. & LIT. STUDIES","HIS. & INT STUDIES","LIN. & LANGUAGES","THR. & MED. ARTS"};
				String edu [] = {"EDUCATIONAL FOUNDATION","EDU. MGT & BUS. STUDIES","LIBRARY & INFO. SC.","BIOLOGY EDUCATION","MATHS. EDUCATION"};
				String eng [] = {"AGRIC & BIO-RESOURCES","CIVIL ENGINEERING","COMPUTER ENGINEERING","ELECTRICAL & ELEC. ENG","MECHANICAL ENGINEERING","MECHATRONICS ENGINEERING","METALLUGICAL & MAT. ENG."};
				String mgt [] = {"ACCOUNTING","BANKING & FINANCE","BUS. ADMIN","PUBLIC ADMIN."};
				String sciences [] = {"ANIMAL & ENV. BIO.","BIOCHEMISTRY","COMPUTER SCIENCES","INDUSTRIAL CHEM.","MATHEMATICS","MICROBIOLOGY","PLANT SC. & BIOTECH."};
				String ss [] = {"CRIMINOLOGY & SEC. STUDIES","DEMOGRAPHY & SOC. STAT.","ECON. & DEV. STUDIES","MASS COMMUNICATION","PEACE & CONFLICT RESL.","POLITICAL SCIENCE","SOCIOLOGY"};
				if (it2.contentEquals("ART")) {
					for (int i=0;i<art.length;i++) {
						String tak =  art[i];
						eDepartment.addItem(tak);
					}
				}
				
				else if (it2.equals("SCIENCES")) {
					
					for (int i=0;i<sciences.length;i++) {
						String tak =  sciences[i];
						eDepartment.addItem(tak);
					}
				}
				else if (it2.equals("AGRICULTURE")) {
					
					for (int i=0;i<agric.length;i++) {
						String tak =  agric[i];
						eDepartment.addItem(tak);
					}
				}
				else if (it2.equals("EDUCATION")) {
					
					for (int i=0;i<edu.length;i++) {
						String tak =  edu[i];
						eDepartment.addItem(tak);
					}
				}
				else if (it2.equals("ENGINEERING")) {
					
					for (int i=0;i<eng.length;i++) {
						String tak =  eng[i];
						eDepartment.addItem(tak);
					}
				}
				else if (it2.equals("MANAGEMENT SCIENCES")) {
					
					for (int i=0;i<mgt.length;i++) {
						String tak =  mgt[i];
						eDepartment.addItem(tak);
					}
				}
				else if (it2.equals("SOCIAL SCIENCES")) {
					
					for (int i=0;i<ss.length;i++) {
						String tak =  ss[i];
						eDepartment.addItem(tak);
					}
				}
			}
		});
		
		
		JPanel patientDetailsPanel = new JPanel(new GridLayout(6,5,4,4));
			JPanel pd1 = new JPanel(new GridLayout(2,1));
			pd1.add(surname);
			pd1.add(new JLabel(""));			
		patientDetailsPanel.add(pd1);
			JPanel pda = new JPanel(new GridLayout(2,1));
			pda.add(surnamea);
			pda.add(new JLabel(""));			
		patientDetailsPanel.add(pda);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd7 = new JPanel(new GridLayout(2,1));
			pd7.add(address);
			pd7.add(new JLabel(""));
		patientDetailsPanel.add(pd7);
			JPanel pd7a = new JPanel(new GridLayout(1,1));
			pd7a.add(addressScroll);
		patientDetailsPanel.add(pd7a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd2 = new JPanel(new GridLayout(2,1));
			pd2.add(firstName);
			pd2.add(new JLabel(""));
		patientDetailsPanel.add(pd2);
			JPanel pd2a = new JPanel(new GridLayout(2,1));
			pd2a.add(firstNamea);
			pd2a.add(new JLabel(""));
		patientDetailsPanel.add(pd2a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd8 = new JPanel(new GridLayout(2,1));
			pd8.add(faculty);
			pd8.add(new JLabel(""));
		patientDetailsPanel.add(pd8);
			JPanel pd8a = new JPanel(new GridLayout(2,1));
			pd8a.add(facultya);
			pd8a.add(new JLabel(""));
		patientDetailsPanel.add(pd8a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd3 = new JPanel(new GridLayout(2,1));
			pd3.add(middleName);
			pd3.add(new JLabel(""));
		patientDetailsPanel.add(pd3);
			JPanel pd3a = new JPanel(new GridLayout(2,1));
			pd3a.add(middleNamea);
			pd3a.add(new JLabel(""));
		patientDetailsPanel.add(pd3a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd9 = new JPanel(new GridLayout(2,1));
			pd9.add(department);
			pd9.add(new JLabel(""));
		patientDetailsPanel.add(pd9);
			JPanel pd9a = new JPanel(new GridLayout(2,1));
			pd9a.add(departmenta);
			pd9a.add(new JLabel(""));
		patientDetailsPanel.add(pd9a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd4 = new JPanel(new GridLayout(2,1));
			pd4.add(gender);
			pd4.add(new JLabel(""));
		patientDetailsPanel.add(pd4);
			JPanel pd4a = new JPanel(new GridLayout(2,1));
			pd4a.add(gendera);
			pd4a.add(new JLabel(""));
		patientDetailsPanel.add(pd4a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd10 = new JPanel(new GridLayout(2,1));
			pd10.add(entryYear);
			pd10.add(entryLevel);
		patientDetailsPanel.add(pd10);
			JPanel pd10a = new JPanel(new GridLayout(2,1));
			pd10a.add(entryYeara);
			pd10a.add(entryLevela);
		patientDetailsPanel.add(pd10a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd5 = new JPanel(new GridLayout(2,1));
			pd5.add(DOB);
			pd5.add(new JLabel(""));
		patientDetailsPanel.add(pd5);
			JPanel pd5a = new JPanel(new GridLayout(2,3,4,4));
			pd5a.add(DOBy);
			pd5a.add(DOBm);
			pd5a.add(DOBd);
			pd5a.add(new JLabel(""));
			pd5a.add(new JLabel(""));
			pd5a.add(new JLabel(""));
		patientDetailsPanel.add(pd5a);
		patientDetailsPanel.add(new JLabel(""));
		JPanel pd11 = new JPanel(new GridLayout(2,1));
			pd11.add(new JLabel(""));
			pd11.add(pNumbe);
		patientDetailsPanel.add(pd11);
			JPanel pd11a = new JPanel(new GridLayout(2,1));
			pd11a.add(new JLabel(""));
			pd11a.add(pNumbera);
		patientDetailsPanel.add(pd11a);
		patientDetailsPanel.add(new JLabel(""));
			JPanel pd6 = new JPanel(new GridLayout(2,1));
			pd6.add(height);
			pd6.add(new JLabel(""));
		patientDetailsPanel.add(pd6);
			JPanel pd6a = new JPanel(new GridLayout(2,1));
			pd6a.add(heighta);
			pd6a.add(new JLabel(""));
		patientDetailsPanel.add(pd6a);
		patientDetailsPanel.add(new JLabel(""));
		patientDetailsPanel.add(new JLabel(""));
		JPanel pd12 = new JPanel(new GridLayout(3,3,4,4));
		pd12.add(cancle1);
		pd12.add(new JLabel(""));
		pd12.add(next1);
		for (int i=0;i<=4;i++) {
			pd12.add(new JLabel(""));
		}
		patientDetailsPanel.add(pd12);
		
		JLabel pSurname = new JLabel("                    Surname:");
		JLabel pFirstName = new JLabel("                    First name:");
		JLabel pAddress = new JLabel("                    Address:");
		JLabel pPNumber = new JLabel("                    Phone Number:");
		JLabel nSurname = new JLabel("                    Surname:");
		JLabel nFirstName = new JLabel("                    First name:");
		JLabel nAddress = new JLabel("                    Address:");
		JLabel nPNumber = new JLabel("                    Phone Number:");
		
		pSurname.setFont(new Font("Calibril",Font.PLAIN,16));
		nSurname.setFont(new Font("Calibril",Font.PLAIN,16));
		pFirstName.setFont(new Font("Calibril",Font.PLAIN,16));
		nFirstName.setFont(new Font("Calibril",Font.PLAIN,16));
		pPNumber.setFont(new Font("Calibril",Font.PLAIN,16));
		nPNumber.setFont(new Font("Calibril",Font.PLAIN,16));
		pAddress.setFont(new Font("Calibril",Font.PLAIN,16));
		nAddress.setFont(new Font("Calibril",Font.PLAIN,16));
		
		pSurnamea.setFont(new Font("Calibril",Font.PLAIN,16));
		nSurnamea.setFont(new Font("Calibril",Font.PLAIN,16));
		pFirstNamea.setFont(new Font("Calibril",Font.PLAIN,16));
		nFirstNamea.setFont(new Font("Calibril",Font.PLAIN,16));
		pPNumbera.setFont(new Font("Calibril",Font.PLAIN,16));
		nPNumbera.setFont(new Font("Calibril",Font.PLAIN,16));
		pAddressa.setFont(new Font("Calibril",Font.PLAIN,16));
		nAddressa.setFont(new Font("Calibril",Font.PLAIN,16));

		JPanel initialMedicalStatusPanel = new JPanel(new GridLayout(12,5,4,4));
		
		sugarLevel.setFont(new Font("Calibril",Font.PLAIN,16));
		pregnancy.setFont(new Font("Calibril",Font.PLAIN,16));
		Typhoid.setFont(new Font("Calibril",Font.PLAIN,16));
		fbs.setFont(new Font("Calibril",Font.PLAIN,16));
		rbs.setFont(new Font("Calibril",Font.PLAIN,16));
		malarialParasite.setFont(new Font("Calibril",Font.PLAIN,16));
		weight.setFont(new Font("Calibril",Font.PLAIN,16));
		xRC.setFont(new Font("Calibril",Font.PLAIN,16));
		eyesTest.setFont(new Font("Calibril",Font.PLAIN,16));
		breastTest.setFont(new Font("Calibril",Font.PLAIN,16));
		blooda.setFont(new Font("Calibril",Font.PLAIN,16));
		genotypea.setFont(new Font("Calibril",Font.PLAIN,16));
		
		JLabel df2 = new JLabel("                        Basic:");
		df2.setForeground(Color.MAGENTA);
		df2.setFont(new Font("Calibril",Font.BOLD,18));
		initialMedicalStatusPanel.add(df2);
		initialMedicalStatusPanel.add(new JLabel(""));
		JLabel df = new JLabel("                        BLOOD TEST:");
		df.setForeground(Color.MAGENTA);
		df.setFont(new Font("Calibril",Font.BOLD,18));
		initialMedicalStatusPanel.add(df);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Eyes test:"));
		initialMedicalStatusPanel.add(eyesTest);
		initialMedicalStatusPanel.add(new JLabel("                                  Blood Group:"));
		initialMedicalStatusPanel.add(blooda);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Weight:"));
		initialMedicalStatusPanel.add(weight);
		initialMedicalStatusPanel.add(new JLabel("                                  Genotype:"));
		initialMedicalStatusPanel.add(genotypea);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Breast Test:"));
		initialMedicalStatusPanel.add(breastTest);
		initialMedicalStatusPanel.add(new JLabel("                                  FBS:"));
		initialMedicalStatusPanel.add(fbs);	
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  X-Ray Comment:"));
		initialMedicalStatusPanel.add(xRC);
		initialMedicalStatusPanel.add(new JLabel("                                  RBS:"));
		initialMedicalStatusPanel.add(rbs);
		initialMedicalStatusPanel.add(new JLabel(""));
		JLabel DF = new JLabel("                                  Urinalysis:");
		DF.setForeground(Color.MAGENTA);
		DF.setFont(new Font("Calibril",Font.BOLD,18));
		initialMedicalStatusPanel.add(DF);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Sugar Level:"));
		initialMedicalStatusPanel.add(sugarLevel);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Malarial Parasite:"));
		initialMedicalStatusPanel.add(malarialParasite);
		initialMedicalStatusPanel.add(new JLabel("                                  Pregnancy:"));
		initialMedicalStatusPanel.add(pregnancy);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  BP:"));
		initialMedicalStatusPanel.add(bp);
		initialMedicalStatusPanel.add(new JLabel("                                  Typhoid:"));
		initialMedicalStatusPanel.add(Typhoid);
		initialMedicalStatusPanel.add(new JLabel(""));
		initialMedicalStatusPanel.add(new JLabel("                                  Temperature:"));
		initialMedicalStatusPanel.add(temperature);
		initialMedicalStatusPanel.add(new JLabel(""));
		
		JPanel ld = new JPanel(new GridLayout(1,3,4,4));
		ld.add(cancle2);
		ld.add(new JLabel(""));
		ld.add(next2);
		initialMedicalStatusPanel.add(ld);
		
		for(int i=0;i<=11;i++) {
			initialMedicalStatusPanel.add(new JLabel(""));
		}
		
		JLabel S1 = new JLabel("    Parent's Details");
		S1.setFont(new Font("Calibril",Font.BOLD,20));
		S1.setForeground(new Color(13,153,3));
		JLabel S2 = new JLabel("Next of Kin Details");
		S2.setFont(new Font("Calibril",Font.BOLD,20));
		S2.setForeground(new Color(13,153,3));
		JPanel otherDetailsPanel = new JPanel(new GridLayout(5,6,4,4));
		otherDetailsPanel.add(S1);
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(S2);
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
			JPanel od1 = new JPanel(new GridLayout(2,1));
			od1.add(pSurname);
			od1.add(new JLabel(""));
		otherDetailsPanel.add(od1);
			JPanel oda = new JPanel(new GridLayout(2,1));
			oda.add(pSurnamea);
			oda.add(new JLabel(""));
		otherDetailsPanel.add(oda);
		otherDetailsPanel.add(new JLabel(""));
			JPanel od1b = new JPanel(new GridLayout(2,1));
			od1b.add(nSurname);
			od1b.add(new JLabel(""));
		otherDetailsPanel.add(od1b);
			JPanel odab = new JPanel(new GridLayout(2,1));
			odab.add(nSurnamea);
			odab.add(new JLabel(""));
		otherDetailsPanel.add(odab);		
		
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
			JPanel od2 = new JPanel(new GridLayout(2,1));
			od2.add(pFirstName);
			od2.add(new JLabel(""));
		otherDetailsPanel.add(od2);
			JPanel od2a = new JPanel(new GridLayout(2,1));
			od2a.add(pFirstNamea);
			od2a.add(new JLabel(""));
		otherDetailsPanel.add(od2a);
		otherDetailsPanel.add(new JLabel(""));
			JPanel od2b = new JPanel(new GridLayout(2,1));
			od2b.add(nFirstName);
			od2b.add(new JLabel(""));
		otherDetailsPanel.add(od2b);
			JPanel od2ab = new JPanel(new GridLayout(2,1));
				od2ab.add(nFirstNamea);
				od2ab.add(new JLabel(""));
		otherDetailsPanel.add(od2ab);
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
			JPanel od3 = new JPanel(new GridLayout(2,1));
			od3.add(pAddress);
			od3.add(new JLabel(""));
		otherDetailsPanel.add(od3);
			JPanel od3a = new JPanel(new GridLayout(1,1));
			od3a.add(SpAddressa);
		otherDetailsPanel.add(od3a);
		otherDetailsPanel.add(new JLabel(""));
			JPanel od3b = new JPanel(new GridLayout(2,1));
			od3b.add(nAddress);
			od3b.add(new JLabel(""));
		otherDetailsPanel.add(od3b);
			JPanel od3ab = new JPanel(new GridLayout(1,1));
				od3ab.add(SnAddressa);
		otherDetailsPanel.add(od3ab);
		otherDetailsPanel.add(new JLabel(""));
		otherDetailsPanel.add(new JLabel(""));
			JPanel od4 = new JPanel(new GridLayout(2,1));
			od4.add(pPNumber);
			od4.add(new JLabel(""));
		otherDetailsPanel.add(od4);			
			JPanel od4a = new JPanel(new GridLayout(2,1));
			od4a.add(pPNumbera);
			od4a.add(new JLabel(""));
		otherDetailsPanel.add(od4a);
		otherDetailsPanel.add(new JLabel(""));
			JPanel od4b = new JPanel(new GridLayout(2,1));
			od4b.add(nPNumber);
			od4b.add(new JLabel(""));
		otherDetailsPanel.add(od4b);			
			JPanel od4ab = new JPanel(new GridLayout(2,1));
			od4ab.add(nPNumbera);
			od4ab.add(new JLabel(""));
		otherDetailsPanel.add(od4ab);
		JPanel Cc = new JPanel(new GridLayout(3,3,4,4));
		Cc.add(new JLabel(""));
		Cc.add(new JLabel(""));
		Cc.add(new JLabel(""));
		Cc.add(new JLabel(""));
		Cc.add(cancle3);
		Cc.add(rDone);
		Cc.add(new JLabel(""));
		Cc.add(new JLabel(""));
		Cc.add(new JLabel(""));
		otherDetailsPanel.add(Cc);
		otherDetailsPanel.add(new JLabel(""));
		
		imagePanel.setLayout(new GridLayout(1,3));
		imagePanel.add(new JLabel(""));
			JPanel dpanel = new JPanel(new BorderLayout());
			dpanel.setBackground(Color.WHITE);
			dpanel.add(imgLLabel, BorderLayout.CENTER);
			JPanel dlss = new JPanel(new GridLayout(1,11));
			dlss.add(new JLabel("        "));
			dpanel.add(dlss,BorderLayout.EAST);
			
			JPanel dkklsl = new JPanel(new GridLayout(3,3));
			dkklsl.add(new JLabel(""));
			photo.setFont(new Font("Calibri",Font.BOLD,14));
			dkklsl.add(photo);
			dkklsl.add(new JLabel(""));
			dkklsl.add(new JLabel(""));
				imgBack.addActionListener(listener);
				imgBack.setBackground(Color.red);
				imgNext.addActionListener(listener);
				imgNext.setBackground(Color.green);
				JPanel thethird = new JPanel(new BorderLayout());
				thethird.add(imgBack, BorderLayout.WEST);
				thethird.add(imgNext, BorderLayout.EAST);
			dkklsl.add(thethird);
			dkklsl.add(new JLabel(""));
			dkklsl.add(new JLabel(""));
			dkklsl.add(new JLabel(""));
			dkklsl.add(new JLabel(""));
			
			JPanel imagePanel2 = new JPanel(new BorderLayout());
			
			imagePanel2.add(dpanel,BorderLayout.CENTER);
			imagePanel2.add(dkklsl,BorderLayout.SOUTH);
			
			
		imagePanel.add(imagePanel2);
		imagePanel.add(new JLabel(""));
	
		registerTab.add(patientDetailsPanel, "Patient's Details");
		registerTab.add(imagePanel,"Image");
		registerTab.add(initialMedicalStatusPanel, "Investigation");
		registerTab.add(otherDetailsPanel, "Other Details");
		
		registerPanel.add(registerTab);
		
//PATENT'S DETAILS
		pad1.setEditable(false);
		pad2.setEditable(false);
		pad3.setEditable(false);
		pad4.setEditable(false);
		pad5.setEditable(false);
		pad6.setEditable(false);
		pad7.setEditable(false);
		pad8.setEditable(false);
		pad9.setEditable(false);
		pad10.setEditable(false);
		pad11.setEditable(false);
		pad12.setEditable(false);
		pad13.setEditable(false);
		pad14.setEditable(false);
		pad15.setEditable(false);
		pad16.setEditable(false);
		pad17.setEditable(false);
		pad18.setEditable(false);
		pad19.setEditable(false);
		pad20.setEditable(false);
		pad21.setEditable(false);
		pad22.setEditable(false);
		pad23.setEditable(false);
		pad24.setEditable(false);
		pad25.setEditable(false);
		pad26.setEditable(false);
		pad27.setEditable(false);
		padGenoType.setEditable(false);
		
		JPanel PatentDetail = new JPanel(new GridLayout(1,4,4,4));
			JPanel j = new JPanel(new GridLayout(11,2,4,4));
			
			j.add(new JLabel("Patient's Details:"));
			j.add(new JLabel(""));
			j.add(new JLabel("    Surname:"));
			j.add(pad1);
			j.add(new JLabel("    First name:"));
			j.add(pad2);
			j.add(new JLabel("    Middle name:"));
			j.add(pad3);
			j.add(new JLabel("    Gender:"));
			j.add(pad4);
			j.add(new JLabel("    Date of Birth:"));
			j.add(pad5);
			j.add(new JLabel("    Weight:"));
			j.add(pad6);
			j.add(new JLabel("    Height:"));
			j.add(pad7);
			j.add(new JLabel("    Address:"));
			j.add(pad8);
			j.add(new JLabel("    Faculty"));
			j.add(pad9);
			j.add(new JLabel("    Department:"));
			j.add(pad10);
			
		PatentDetail.add(j);
		
			JPanel jj = new JPanel(new GridLayout(3,1,4,4));
				
				J.setBackground(Color.CYAN);
				J.add(pixLabel);
			jj.add(J);
				JPanel jj2 = new JPanel(new GridLayout(5,2,4,4));
				jj2.add(new JLabel("            Blood Group:"));
				jj2.add(pad11);
				jj2.add(new JLabel("            Geno Type:"));
				jj2.add(padGenoType);
				jj2.add(new JLabel("            Sugar Level:"));
				jj2.add(pad12);
				jj2.add(new JLabel("            Pregnancy Test:"));
				jj2.add(pad13);
				jj2.add(new JLabel("            Typhoid Test:"));
				jj2.add(pad14);
			jj.add(jj2);
				JPanel jj3 = new JPanel(new GridLayout(5,2,4,4));
				jj3.add(new JLabel("            FBS (Blood):"));
				jj3.add(pad15);
				jj3.add(new JLabel("            RBS (Blood):"));
				jj3.add(pad16);
				jj3.add(new JLabel("            Malarial Parasite:"));
				jj3.add(pad17);				
				jj3.add(new JLabel("            Temperature:"));
				jj3.add(pad18);
				jj3.add(new JLabel("            BP:"));
				jj3.add(pad19);
			
			jj.add(jj3);
			
		PatentDetail.add(jj);
			JPanel jjj = new JPanel(new GridLayout(11,2,4,4));
			jjj.add(new JLabel("        Parent's Details:"));
			jjj.add(new JLabel(""));
			jjj.add(new JLabel("                    Surname:"));
			jjj.add(pad20);
			jjj.add(new JLabel("                    First name:"));
			jjj.add(pad21);
			jjj.add(new JLabel("                    Address:"));
			jjj.add(pad22);
			jjj.add(new JLabel("                    Phone number:"));
			jjj.add(pad23);
			jjj.add(new JLabel("        Next of Kin:"));
			jjj.add(new JLabel(""));
			jjj.add(new JLabel("                    Surname:"));
			jjj.add(pad24);
			jjj.add(new JLabel("                    First name:"));
			jjj.add(pad25);
			jjj.add(new JLabel("                    Address"));
			jjj.add(pad26);
			jjj.add(new JLabel("                    Phone number:"));
			jjj.add(pad27);
			
			JPanel JJ = new JPanel(new GridLayout(2,2,4,4));
			JJ.add(new JLabel(""));
			JJ.add(OutBt);
			JJ.add(new JLabel(""));
			JJ.add(new JLabel(""));
			JPanel JJ2 = new JPanel(new GridLayout(2,2,4,4));
			JJ2.add(new JLabel(""));
			JJ2.add(Continue);
			JJ2.add(new JLabel(""));
			JJ2.add(new JLabel(""));
			jjj.add(JJ);
			jjj.add(JJ2);
			
			
		PatentDetail.add(jjj);
		
		PatentDetail.add(new JLabel(""));
	
//VITAL SIGN
		JPanel vitalSignPanel = new JPanel(new BorderLayout());
		vitalSignPanel.add(new JLabel("                "), BorderLayout.WEST);
			JPanel vSCenter = new JPanel(new GridLayout(6,4,4,4));
			vSCenter.add(new JLabel(""));
			JPanel vSCenter2 = new JPanel(new GridLayout(2,1));
			vSCenter2.add(new JLabel(""));
			vSCenter2.add(new JLabel("                                        Weight:"));
            vSCenter.add(vSCenter2);
            JPanel vSCenter3 = new JPanel(new GridLayout(2,1));
            vSCenter3.add(new JLabel(""));
			vSCenter3.add(weight2);
			vSCenter.add(vSCenter3);
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			JPanel vSCenter4 = new JPanel(new GridLayout(2,1));
			vSCenter4.add(new JLabel(""));
			vSCenter4.add(new JLabel("                                        Temperature:"));
			vSCenter.add(vSCenter4);
			JPanel vSCenter5 = new JPanel(new GridLayout(2,1));
			vSCenter5.add(new JLabel(""));
			vSCenter5.add(temperature2);
			vSCenter.add(vSCenter5);
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			JPanel vSCenter6 = new JPanel(new GridLayout(2,1));
			vSCenter6.add(new JLabel(""));
			vSCenter6.add(new JLabel("                                        BP:"));
			vSCenter.add(vSCenter6);
			JPanel vSCenter7 = new JPanel(new GridLayout(2,1));
			vSCenter7.add(new JLabel(""));
			vSCenter7.add(bp2);	
			vSCenter.add(vSCenter7);
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			vSCenter.add(new JLabel(""));
			JPanel vSCenter8 = new JPanel(new GridLayout(2,3));
			vSCenter8.add(new JLabel(""));
			vSCenter8.add(new JLabel(""));
			vSCenter8.add(new JLabel(""));
			vSCenter8.add(cancel2);
			vSCenter8.add(new JLabel(""));
			vSCenter8.add(submit);
			vSCenter.add(vSCenter8);
			
			for(int i=0;i<=9;i++) {
				vSCenter.add(new JLabel(""));
			}
			

		vitalSignPanel.add(vSCenter,BorderLayout.CENTER);
		vitalSignPanel.add(new JLabel("                   "),BorderLayout.EAST);
		

//EMERGENCY
		eBack.setBackground(Color.red);
		eBack.setFont(new Font("Calibril",Font.BOLD,18));
		JLabel et = new JLabel("            Surname");
		et.setFont(new Font("Calibril",Font.PLAIN,15));
		JLabel et2 = new JLabel("            First Name");
		et2.setFont(new Font("Calibril",Font.PLAIN,15));
		JLabel ett = new JLabel("Faculty");
		ett.setFont(new Font("Calibril",Font.PLAIN,20));
		JLabel et3 = new JLabel("Department");
		et3.setFont(new Font("Calibril",Font.PLAIN,20));
		eSurName.setFont(new Font("Calibril",Font.BOLD,15));
		eFirstName.setFont(new Font("Calibril",Font.BOLD,15));
		eDepartment.setFont(new Font("Calibril",Font.BOLD,15));
		eFaculty.setFont(new Font("Calibril",Font.BOLD,15));
		lgBtn2.setFont(new Font("Calibril",Font.BOLD,20));
		
		
		JPanel eeA = new JPanel(new GridLayout(1,2));
		eeA.add(et);
		eeA.add(eSurName);
		
		JPanel eeB = new JPanel(new GridLayout(1,2));
		eeB.add(et2);
		eeB.add(eFirstName);
		
		
		/*ee.add(ett);
		ee.add(eFaculty);
		ee.add(new JLabel(" "));
		//ee.add(et3);
		ee.add(eDepartment);*/
		
		JPanel ee1 = new JPanel(new GridLayout(3,4,4,4));
		ee1.add(new JLabel(""));
		ee1.add(new JLabel(""));
		ee1.add(new JLabel(""));
		ee1.add(new JLabel(""));
		ee1.add(new JLabel(""));
		ee1.add(eeA);
		ee1.add(eeB);
		ee1.add(new JLabel(""));
		ee1.add(new JLabel(""));
			JPanel ee2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			ee2.add(eBack);
			JPanel ee4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			ee4.add(lgBtn2);
		ee1.add(ee2);
		ee1.add(ee4);
		ee1.add(new JLabel(""));
		
		eeList.add(ee1, BorderLayout.NORTH);
		
		//eeList.add(SearcherScrol,BorderLayout.CENTER);
		
		emergencyPage.setBackground(new Color(161,181,137));
		emergencyPage.add(new JLabel(mSearch), BorderLayout.WEST);
		emergencyPage.add(eeList, BorderLayout.CENTER);
		
		
		
		
		
//DOCTOR'S QUEUE
		
		
//PATIENT'S DASHBOARD
		JPanel DDashboard = new JPanel(new BorderLayout());
			JPanel ddTop = new JPanel(new GridLayout(3,4,4,4));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel("                                           Numbers of visit: "));
			nVisit.setEditable(false);
			ddTop.add(nVisit);
			//ddTop.add(new JLabel("                                           Most Frequent Doctor: "));
			mfDoctor.setEditable(false);
		//	ddTop.add(mfDoctor);
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
			ddTop.add(new JLabel(""));
		DDashboard.add(ddTop, BorderLayout.NORTH);
		DDashboard.add(new JLabel("     "), BorderLayout.WEST);
		DDashboard.add(new JLabel("     "), BorderLayout.EAST);
			JPanel ddCenter = new JPanel(new GridLayout(1,4,4,4));
			ddCenter.setBackground(Color.GRAY);
				JPanel ddCenterPanel1 = new JPanel(new BorderLayout());
				ddCenterPanel1.add(new JLabel("Medical Histories"), BorderLayout.NORTH);
					JPanel ddCP1Center = new JPanel(new BorderLayout());
					lst.addListSelectionListener(IListener);
					lst.setFont(new Font("Calibri",Font.PLAIN,15));
					ddCP1Center.add(lst, BorderLayout.WEST);
						JPanel ddCP1Center_= new JPanel(new GridLayout(4,1));
						VitalSignA.setEditable(false);
						ddCP1Center_.add(VitalSignTA);
						RemarkA.setEditable(false);
						ddCP1Center_.add(RemarkTA);
						TestA.setEditable(false);
						ddCP1Center_.add(TestTA);
						MedicationA.setEditable(false);
						ddCP1Center_.add(MedicationTA);
					ddCP1Center.add(ddCP1Center_,BorderLayout.CENTER);
				ddCenterPanel1.add(ddCP1Center);
			ddCenter.add(ddCenterPanel1);
				JPanel ddCenterPanel2 =  new JPanel(new BorderLayout());
				ddCenterPanel2.add(new JLabel("  New Vital Signs"),BorderLayout.NORTH);
					JPanel ddCP2Center = new JPanel(new GridLayout(2,1,4,4));
						JPanel ddCP2 = new JPanel(new GridLayout(6,2,4,4));
						ddCP2.add(new JLabel("                         BP: "));
						newBPResult.setFont(new Font("Calibri",Font.PLAIN,19));
						newBPResult.setEditable(false);
						ddCP2.add(newBPResult);
						ddCP2.add(new JLabel(""));
						ddCP2.add(new JLabel(""));
						ddCP2.add(new JLabel("                         Temp: "));
						newTempResult.setFont(new Font("Calibri",Font.PLAIN,19));
						newTempResult.setEditable(false);
						ddCP2.add(newTempResult);
						ddCP2.add(new JLabel(""));
						ddCP2.add(new JLabel(""));
						ddCP2.add(new JLabel("                         Weight: "));
						newWeightResult.setFont(new Font("Calibri",Font.PLAIN,19));
						newWeightResult.setEditable(false);
						ddCP2.add(newWeightResult);
						JPanel k55 = new JPanel(new GridLayout(3,1));
						k55.add(new JLabel(""));
						k55.add(new JLabel(""));
						k55.add(new JLabel("  Laboratory Test Results"));
						ddCP2.add(k55);
						ddCP2.add(new JLabel(""));
					ddCP2Center.add(ddCP2);
					newLabTestResult.setFont(new Font("Calibri",Font.PLAIN,19));
					newLabTestResult.setEditable(false);
					ddCP2Center.add(newLabTestResults);
					
				ddCenterPanel2.add(ddCP2Center);
			ddCenter.add(ddCenterPanel2);
				JPanel ddCenterPanel3 = new JPanel(new GridLayout(2,1));
					JPanel ddCP3 = new JPanel(new GridLayout(5,3));
					ddCP3.add(new JLabel("              Tests "));
					ddCP3.add(new JLabel(""));
					ddCP3.add(new JLabel(""));
					ddCP3.add(new JLabel(""));
					ddCP3.add(UrineTestCheckBox);
					ddCP3.add(new JLabel(""));
					ddCP3.add(new JLabel(""));
					ddCP3.add(BloodTestCheckBox);
					ddCP3.add(new JLabel(""));
					ddCP3.add(new JLabel(""));
					LabSentBT.addActionListener(listener);
						JPanel LabSentBt = new JPanel();
						LabSentBt.add(new JLabel(""));
						LabSentBt.add(LabSentBT);
					ddCP3.add(LabSentBt);
					ddCP3.add(new JLabel(""));
					
				ddCenterPanel3.add(ddCP3);
					JPanel medicationPanel = new JPanel(new BorderLayout());
					medicationPanel.add(new JLabel("  Medications:"),BorderLayout.NORTH);
					MedicationText.setFont(new Font("Calibri",Font.PLAIN,19));
					medicationPanel.add(medicationText,BorderLayout.CENTER);
					JPanel bt = new JPanel(new GridLayout(1,3));
					bt.add(new JLabel(""));
					bt.add(new JLabel(""));
					medicationBT.addActionListener(listener);
					bt.add(medicationBT);
					medicationPanel.add(bt,BorderLayout.SOUTH);
				ddCenterPanel3.add(medicationPanel);
			ddCenter.add(ddCenterPanel3);
				JPanel ddCenterPanel4 = new JPanel(new BorderLayout());
				ddCenterPanel4.add(new JLabel("  Doctor's Remark"),BorderLayout.NORTH);
				newDoctorRemark.setFont(new Font("Calibri",Font.PLAIN,19));
				ddCenterPanel4.add(newDoctorRemarkScroll,BorderLayout.CENTER);
					JPanel ddCP4 = new JPanel(new GridLayout(1,3));
					ddCP4.add(DoctorReject);
					ddCP4.add(new JLabel(""));
					ddCP4.add(FinalDoctorDone);
				ddCenterPanel4.add(ddCP4,BorderLayout.SOUTH);
			ddCenter.add(ddCenterPanel4);
			DDashboard.add(ddCenter,BorderLayout.CENTER);		
		
//PHARMACY
			
				JPanel attendentDetails = new JPanel(new GridLayout(8,1));
				
				refresh.addActionListener(listener);
				attendentDetails.setBackground(new Color(43,134,145));
				attendentDetails.add(new JLabel("                                                                   "));
				attendentDetails.add(new JLabel("    NAME:"));
				AttendentdashName1.setEditable(false);
				AttendentdashName1.setFont(new Font("Calibril",Font.BOLD,20));
				AttendentdashName1.setBackground(new Color(43,134,145));
				AttendentdashName1.setForeground(Color.WHITE);
				attendentDetails.add(AttendentdashName1);
				attendentDetails.add(new JLabel("    POST:"));
				PLK.setEditable(false);
				PLK.setFont(new Font("Calibril",Font.BOLD,20));
				PLK.setBackground(new Color(43,134,145));
				PLK.setForeground(Color.WHITE);
				attendentDetails.add(PLK);
				refresh.setFont(new Font("Calibril",Font.PLAIN,18));
				attendentDetails.add(refresh);
				phamExit.addActionListener(listener);
				phamExit.setFont(new Font("Calibri",Font.PLAIN,21));
				phamExit.setFont(new Font("Calibri",Font.PLAIN,18));
				phamExit.setBackground(Color.red);
				attendentDetails.add(phamExit);
				
			pharmacy.add(attendentDetails,BorderLayout.WEST);
				
				phamacyCenter.setLayout(phamacyCard);
				
			//PHARMACY QUEUE
				
				
				
				
				
			//PHARMACY PATIENT
				phamRejectBt.addActionListener(listener);
				JPanel drugRequest = new JPanel(new BorderLayout());
					JPanel DRTop = new JPanel(new GridLayout(2,1));
						JPanel DRTop1 = new JPanel();
						DRTop1.add(new JLabel("      NAME: "));
						phamPName.setEditable(false);
						DRTop1.add(phamPName);
					DRTop.add(DRTop1);
					DRTop.add(new JLabel(""));
				drugRequest.add(DRTop,BorderLayout.NORTH);
					JPanel DRCenter = new JPanel(new GridLayout(1,4,4,4));
						JPanel DRC1Panel = new JPanel(new BorderLayout());
						DRC1Panel.add(new JLabel("     Medications: "),BorderLayout.NORTH);
						DRC1Panel.add(prisMedicationScroll,BorderLayout.CENTER);
					DRCenter.add(DRC1Panel);
						JPanel DRC2Panel = new JPanel(new BorderLayout());
						DRC2Panel.add(new JLabel("     Reason for rejection:"),BorderLayout.NORTH);
						DRC2Panel.add(RFRegectionScroll,BorderLayout.CENTER);
							JPanel dkjdo = new JPanel(new GridLayout(1,5));
							dkjdo.add(new JLabel(""));
							dkjdo.add(phamRejectBt);
							dkjdo.add(new JLabel(""));
							dkjdo.add(phamDoneBt);
							dkjdo.add(new JLabel(""));
						DRC2Panel.add(dkjdo,BorderLayout.SOUTH);
					DRCenter.add(DRC2Panel);
					DRCenter.add(new JLabel(""));
					
			drugRequest.add(DRCenter,BorderLayout.CENTER);
			
			phamacyCenter.add(drugRequest,"Drug Request");     // 2
			
			pharmacy.add(phamacyCenter,BorderLayout.CENTER);
			
//LABORATORY
			
				JPanel LabAttendentDetails = new JPanel(new GridLayout(8,1));
				
				LabAttendentDetails.setBackground(new Color(43,134,145));
				LabAttendentDetails.add(new JLabel("                                                                   "));
				LabAttendentDetails.add(new JLabel("    NAME:"));
				LabAttendentdashName1.setEditable(false);
				LabAttendentdashName1.setFont(new Font("Calibril",Font.BOLD,20));
				LabAttendentdashName1.setBackground(new Color(43,134,145));
				LabAttendentdashName1.setForeground(Color.WHITE);
				LabAttendentDetails.add(LabAttendentdashName1);
				LabAttendentDetails.add(new JLabel("    POST:"));
				LLK.setEditable(false);
				LLK.setFont(new Font("Calibril",Font.BOLD,20));
				LLK.setBackground(new Color(43,134,145));
				LLK.setForeground(Color.WHITE);
				LabAttendentDetails.add(LLK);
				LabRefBt.setFont(new Font("Calibri",Font.PLAIN,18));
				LabAttendentDetails.add(LabRefBt);
				labExit.addActionListener(listener);
				labExit.setBackground(Color.red);
				labExit.setFont(new Font("Calibri",Font.PLAIN,18));
				LabAttendentDetails.add(labExit);
				
			laboratory.add(LabAttendentDetails,BorderLayout.WEST);
			
				
				LabCenter.setLayout(LabCard);
				
			//LABORATORY QUEUE
				
			
			//LABORATORY PATIENT
				JPanel testRequest = new JPanel(new BorderLayout());
					JPanel TRTop = new JPanel(new GridLayout(3,1));
						JPanel TRTop1 = new JPanel();
						TRTop1.add(new JLabel("      NAME: "));
						labPName.setEditable(false);
						TRTop1.add(labPName);
					TRTop.add(TRTop1);
					LabRefBt.addActionListener(listener);
					labDoneBt.addActionListener(listener);
					
						JPanel TRTop2 = new JPanel();
						TRTop2.add(new JLabel("      Test Type:"));
						lab_test.setEditable(false);
						TRTop2.add(lab_test);
					TRTop.add(TRTop2);
				testRequest.add(TRTop, BorderLayout.NORTH);
					JPanel TRCenter = new JPanel(new GridLayout(1,3,4,4));
						JPanel TRC1 = new JPanel(new BorderLayout());
						TRC1.add(new JLabel("Blood Test Results"), BorderLayout.NORTH);
							JPanel bPanel = new JPanel(new GridLayout(8,1,4,4));
						//	bPanel.setBackground(new Color(242,235,235));
							FBSCheck.setBackground(new Color(255,255,255));
							RBSCheck.setBackground(new Color(255,255,255));
							malarialCheck.setBackground(new Color(255,255,255));
							FBSCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							RBSCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							malarialCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							bPanel.add(new JLabel(""));
								JPanel fbspa = new JPanel(new BorderLayout());
								fbspa.add(new JLabel("  FBS:"), BorderLayout.NORTH);
								fbspa.add(FBSCheck, BorderLayout.CENTER);
							bPanel.add(fbspa);
								JPanel rbspa = new JPanel(new BorderLayout());
								rbspa.add(new JLabel("  RBS:  "), BorderLayout.NORTH);
								rbspa.add(RBSCheck, BorderLayout.CENTER);
							bPanel.add(rbspa);
								JPanel mcp = new JPanel(new BorderLayout());
								mcp.add(new JLabel("  Malarial Parasite: "), BorderLayout.NORTH);
								mcp.add(malarialCheck, BorderLayout.CENTER);
							bPanel.add(mcp);
							
						TRC1.add(bPanel,BorderLayout.CENTER);
							JPanel bLast = new JPanel(new GridLayout(2,1));
							bLast.add(new JLabel(""));
						TRC1.add(bLast, BorderLayout.SOUTH);
						
						JPanel TRC2 = new JPanel(new BorderLayout());
						TRC2.add(new JLabel("Urine Test Results"), BorderLayout.NORTH);
							JPanel uPanel = new JPanel(new GridLayout(8,1,4,4));
						//	uPanel.setBackground(new Color(252,255,255));
							pregnancyCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							sugarCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							typhoidCheck.setFont(new Font("Calibril",Font.PLAIN,15));
							pregnancyCheck.setBackground(new Color(255,255,255));
							sugarCheck.setBackground(new Color(255,255,255));
							typhoidCheck.setBackground(new Color(255,255,255));
							uPanel.add(new JLabel(""));
								JPanel pcc = new JPanel(new BorderLayout());
								pcc.add(new JLabel(" Pregnancy:  "), BorderLayout.NORTH);
								pcc.add(pregnancyCheck,BorderLayout.CENTER);
							uPanel.add(pcc);
								JPanel scc = new JPanel(new BorderLayout());
								scc.add(new JLabel("  Sugar Level:  "), BorderLayout.NORTH);
								scc.add(sugarCheck, BorderLayout.CENTER);
							uPanel.add(scc);
								JPanel tcc = new JPanel(new BorderLayout());
								tcc.add(new JLabel("  Typhoid:  "),BorderLayout.NORTH);
								tcc.add(typhoidCheck, BorderLayout.CENTER);
							uPanel.add(tcc);
						TRC2.add(uPanel,BorderLayout.CENTER);
							JPanel uLast = new JPanel(new GridLayout(2,1));
							uLast.add(new JLabel(""));
						TRC2.add(uLast, BorderLayout.SOUTH);
						
						JPanel TRC3 = new JPanel(new BorderLayout());
							JPanel perf = new JPanel(new GridLayout(4,5,4,4));
							perf.add(labDoneBt);
							for (int iq=1;iq<=19;iq++) {
							perf.add(new JLabel(""));
							}
						TRC3.add(perf,BorderLayout.SOUTH);
						
					TRCenter.add(TRC1);
					TRCenter.add(TRC2);
					TRCenter.add(TRC3);
					
				testRequest.add(TRCenter);	
				
				LabCenter.add(testRequest,"Test Result");
			
			laboratory.add(LabCenter,BorderLayout.CENTER);
			
			
//CARD
		aCentrePanel.add(a_mainPage, "Home");
		aCentrePanel.add(checkPage, "Check");
		aCentrePanel.add(emergencyPage, "Emergency");
		aCentrePanel.add(registerPanel, "Register");
		aCentrePanel.add(PatentDetail,"Patent Details");
		aCentrePanel.add(vitalSignPanel,"Vital Sign");
		//aCentrePanel.add(doctorsQueue,"DocQueue");
		aCentrePanel.add(DDashboard,"DPatient Dashboard");
		aCentrePanel.add(pharmacy,"Phamacy");
		aCentrePanel.add(laboratory,"Laboratory");
		
		
		
// LOWER PANEL
		JPanel lll = new JPanel(new GridLayout(2,1,4,4));
		lll.setBackground(Color.WHITE);
		JLabel bb = new JLabel("                                                                                                                                                                                                                                                BAYODE BLESSING AKINBOLA, CSC/2017/1072");
		bb.setForeground(new Color(145,6,140));
		bb.setFont(new Font("Calibril",Font.BOLD,16));
		lll.add(bb);
		lll.add(new JLabel("                                                                                                                                                                                                                                                                                                                                                                                       CSC320:  SOFTWARE LABORATORY"));
		
		mainMRPagePanel.add(FuoyeTopPanel,BorderLayout.NORTH);
		mainMRPagePanel.add(aCentrePanel,BorderLayout.CENTER);
		mainMRPagePanel.add(lll,BorderLayout.SOUTH);
		
		add(mainMRPagePanel);
	}
	
	
	public void doctorPag() {
		JPanel doctorsQueue = new JPanel(new BorderLayout());
		
		F_M_MainClass connCSH = new F_M_MainClass();
		
		try {
			connCSH.docQ();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		DocRefresh.addActionListener(listener);
		DocRefresh.setFont(new Font("Calibri",Font.PLAIN,21));
		docExit.addActionListener(listener);
		docExit.setFont(new Font("Calibri",Font.PLAIN,21));
		JPanel DoctorsDetails = new JPanel(new GridLayout(8,1));
		DoctorsDetails.setBackground(new Color(43,134,145));
		DoctorsDetails.add(new JLabel("                                                                   "));
		DoctorsDetails.add(new JLabel("    NAME:"));
		DocdashName1.setEditable(false);
		DocdashName1.setFont(new Font("Calibril",Font.BOLD,20));
		DocdashName1.setBackground(new Color(43,134,145));
		DocdashName1.setForeground(Color.WHITE);
		DoctorsDetails.add(DocdashName1);
		DoctorsDetails.add(new JLabel("    POST:"));
		DLK.setEditable(false);
		DLK.setFont(new Font("Calibril",Font.BOLD,20));
		DLK.setBackground(new Color(43,134,145));
		DLK.setForeground(Color.WHITE);
		DoctorsDetails.add(DLK);
		DoctorsDetails.add(DocRefresh);
		docExit.setBackground(Color.red);
		DoctorsDetails.add(docExit);
		
		doctorsQueue.add(DoctorsDetails,BorderLayout.WEST);
		
		
		
		
		
		
		

		JPanel doctorsQueueCenter = new JPanel();
		
				
		doctorsQueueCenter.setLayout(new GridLayout(rol1+10,1,4,4));
		
		String [] taker = new String[rol1];
			for(int i=0;i<rol1;i++) {
				
				JPanel docCenter1 = new JPanel(new BorderLayout());
				
				String ii = Integer.toString(i+1);
				
				taker[i] = ii;
				
				int a = i;
				
				docCenter1.add(new JLabel("    "+ii),BorderLayout.WEST);
				docCenter1.add(new JLabel("                                "+Doch_pName[a]), BorderLayout.CENTER);
				
				JButton readyBt = new JButton("Ready");
						readyBt.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								String mm = "You clicked button "+ taker[a];
								JOptionPane.showMessageDialog(null, mm);
								docN = pDocHId[a];
								pDocIds = pDocId [a];
								
								
								try {
									PreparedStatement ps = con.prepareStatement("UPDATE fuoye_medical.history SET process = \"DOCTOR\" WHERE id = "+pDocHId[a]);
									
									int rr = ps.executeUpdate();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								try {
									
									cs = con.prepareCall("{call docDetails(?,?,?,?,?,?,?,?,?,?,?)}");
									
									cs.setInt(1, pDocHId[a]);
									cs.registerOutParameter(2, Types.INTEGER);
									cs.registerOutParameter(3, Types.INTEGER);
									cs.registerOutParameter(4, Types.INTEGER);
									cs.registerOutParameter(5, Types.INTEGER);
									cs.registerOutParameter(6, Types.INTEGER);
									cs.registerOutParameter(7, Types.VARCHAR);
									cs.registerOutParameter(8, Types.VARCHAR);
									cs.registerOutParameter(9, Types.INTEGER);
									cs.registerOutParameter(10, Types.VARCHAR);
									cs.registerOutParameter(11, Types.VARCHAR);
									cs.execute();
									
									newBPResult.setText(cs.getString(2));
									newTempResult.setText(cs.getString(3));
									newWeightResult.setText(cs.getString(4));
									newLabTestResult.setText("FBS:  "+cs.getInt(5)+"\nRBS:  "+cs.getInt(6)+"\nMalarial Parasite:  "+cs.getString(7)+"\nPregnancy:  "+cs.getString(8)+"\nSugar Level:  "+cs.getInt(9)+"\nTyphoid:  "+cs.getString(10));
									
									cs = con.prepareCall("{call visit(?,?)}");
									cs.setInt(1, pDocId[a]);
									cs.registerOutParameter(2, Types.INTEGER);
									cs.execute();
									
									String sse = Integer.toString((cs.getInt(2)));
									nvisit = cs.getInt(2);
									nVisit.setText(sse);
									
									
									F_M_MainClass connSCh = new F_M_MainClass();
									connSCh.visitList();
									
								} catch (SQLException e) {
									e.printStackTrace();
								} 
								
								
								
								MasterCard.show(aCentrePanel, "DPatient Dashboard");
								
							}
						});
						
						
				docCenter1.add(readyBt, BorderLayout.EAST);
				
				if(i%2==0) {
				docCenter1.setBackground(Color.WHITE);
				}
				
				doctorsQueueCenter.add(docCenter1);
				
			}
			
			
			
			JScrollPane DocQueueScroll = new JScrollPane(doctorsQueueCenter);
			
			doctorsQueue.add(DocQueueScroll,BorderLayout.CENTER);
			
			aCentrePanel.add(doctorsQueue,"DocQueue");
			MasterCard.show(aCentrePanel, "DocQueue");
			
			
	}
	
	@SuppressWarnings("unchecked")
	public void visitList() throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		
		dlm.clear();
		dlm.removeAllElements();
		
		allIds = new int[nvisit];
		
		String u8 = "SELECT id, date FROM fuoye_medical.history WHERE patient_id="+pDocIds;
		PreparedStatement prdst = con.prepareStatement(u8);
		ResultSet rs = prdst.executeQuery();
		
		int i = 0;
		while(rs.next()&& i<nvisit) {
			allIds [i] = rs.getInt("id");
			dlm.addElement(rs.getString("date"));
			i++;
		}
		
		
	}
	
	
// 0000000000000000000000000000000000000000000  DOC  000000000000000000000000000000000000000000000000000000
	public void docQ() throws SQLException {
		
		cs = con.prepareCall("{call docMax(?)}");
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		int rz = cs.getInt(1);
		rol1 = rz;
		
		pDocHId = new int[rol1];
		pDocId = new int[rol1];
		Doch_pName = new String[rol1];
		
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
				
		String u8 = "SELECT id, patient_id FROM fuoye_medical.history WHERE status=1 AND process=\"QUEUE\"";
		PreparedStatement prdst = con.prepareStatement(u8);
		ResultSet rs = prdst.executeQuery();
		int i = 0;
		while(rs.next()) {
			pDocHId [i] = rs.getInt("id");
			pDocId [i] = rs.getInt("patient_id");
			i++;
		}
			
			for(int i1=0; i1<rol1; i1++) {
				
				PreparedStatement prdst1 = con.prepareStatement("SELECT surname, firstname FROM fuoye_medical.patients WHERE patient_id="+pDocId[i1]);
				ResultSet rs1 = prdst1.executeQuery();
				rs1.next();
				
				Doch_pName[i1] = rs1.getString("surname")+"       "+rs1.getString("firstname");
				
			}
			
	}
	
	
// 0000000000000000000000000000000000000000000  MRO  000000000000000000000000000000000000000000000000000000
	public void mroQ() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		
		PreparedStatement prdst = con.prepareStatement("SELECT patient_id, process FROM fuoye_medical.history WHERE status=1");
		
		ResultSet rs = prdst.executeQuery();
		
		int i = 0;
		while(rs.next()) {
			h_p_id [i] = rs.getInt("patient_id");
			h_pProcess[i] = rs.getString("process");
			i++;
		}
		
	}
	
	public void tmroQ() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		
		for(int i=0; i<mroQueue; i++) {
		
			PreparedStatement prdst = con.prepareStatement("SELECT surname, firstname FROM fuoye_medical.patients WHERE patient_id="+h_p_id [i]);
			ResultSet rs = prdst.executeQuery();
			rs.next();
			
			h_pName[i] = rs.getString("surname")+"       "+rs.getString("firstname");
		}
		
	}
	public void theQueue() throws SQLException {

		JPanel queuePanel = new JPanel(new BorderLayout());
		JPanel qpCenter = new JPanel();
		qpCenter.setLayout(new GridLayout(mroQueue+10,1,4,4));
		mainBack.addActionListener(listener);
		mainBack.setBackground(Color.red);
		
		for(int i=1;i<=mroQueue;i++) {

			JPanel qpCenter1 = new JPanel(new BorderLayout());
			
			String ii = Integer.toString(i);
			
			qpCenter1.add(new JLabel("    "+ii),BorderLayout.WEST);

			qpCenter1.add(new JLabel("                                "+h_pName[i-1]), BorderLayout.CENTER);
			qpCenter1.add(new JLabel(h_pProcess[i-1]+"       "), BorderLayout.EAST);
			
			if(i%2==0) {
			qpCenter1.setBackground(Color.WHITE);
			}
			
			qpCenter.add(qpCenter1);
			
		}
		JPanel md = new JPanel(new GridLayout(1,9));
		md.add(mainBack);
		for (int is=1;is<=8;is++) {
		md.add(new JLabel(""));
		}
		qpCenter.add(md, BorderLayout.SOUTH);
		

	JScrollPane OQueueScroll = new JScrollPane(qpCenter);	
	
	queuePanel.add(new JLabel(queueImage), BorderLayout.WEST);
	queuePanel.add(OQueueScroll,BorderLayout.CENTER);
	
	aCentrePanel.add(queuePanel,"Queue");
	MasterCard.show(aCentrePanel, "Queue");
	}
	
	
	
	
// 0000000000000000000000000000000000000000000  PHAMACY  000000000000000000000000000000000000000000000000000000	

	public void phamMedicRegtMs() throws SQLException {
		
		cs = con.prepareCall("{call phamMedicationReject(?,?)}"); 
		cs.setString(1, dis);
		String lk = String.format(RFRegection.getText());
		cs.setString(2, lk);
		cs.execute();
	
	}
	
	public void phamMedicationDone() throws SQLException {
		
		cs = con.prepareCall("{call phamMedicationDone(?,?)}"); 
		cs.setString(1, p_qu1);
		
		cs.setString(2, dis);
		cs.execute();
	
	}
	

	

	

		
	public void thePham() throws SQLException {
		
		F_M_MainClass connSCheck = new F_M_MainClass();
		connSCheck.lastNumber();
		
		connSCheck.queueMax();
		
		phamQueue = phamMax;
		
		phamid = new int[phamQueue];
		phamName = new String[phamQueue];
		phamidQ  = new int[phamQueue];
		p_qu = new int[phamQueue];
		
		PreparedStatement prdstb = con.prepareStatement("SELECT history_id, id FROM fuoye_medical.phamqueue WHERE status=1");
		
		ResultSet rsb = prdstb.executeQuery();
		
		int ib = 0;
		while(rsb.next()) {
			
			p_qu [ib] = rsb.getInt("id");
			
			phamidQ [ib] = rsb.getInt("history_id");
			
			ib++;
		}
		
		for(int ic=0;ic<phamQueue;ic++) {
			PreparedStatement prdstc = con.prepareStatement("SELECT patient_id FROM fuoye_medical.history WHERE id="+phamidQ [ic]);
			ResultSet rsc = prdstc.executeQuery();
			
			rsc.next();
				
			phamid [ic] = rsc.getInt("patient_id");
			
			
		}
		
		for(int iq=0; iq<phamQueue; iq++) {
			
			PreparedStatement prdstq = con.prepareStatement("SELECT surname, firstname FROM fuoye_medical.patients WHERE patient_id="+phamid [iq]);
			ResultSet rsq = prdstq.executeQuery();
			rsq.next();
			phamName[iq] = rsq.getString("surname")+"       "+rsq.getString("firstname");
		}
		
		
		
		
		
		
		
		
		
		
		JPanel phamacyQueueCenter = new JPanel();
		phamacyQueueCenter.setLayout(new GridLayout(phamQueue+10,1,4,4));	
		
		prisMedication.setEditable(false);
		prisMedication.setFont(new Font("Calibril",Font.PLAIN,18));
		
		String [] ptaker = new String[phamQueue];
			for(ids=1;ids<=phamQueue;ids++) {
				
				JPanel phamCenter1 = new JPanel(new BorderLayout());
				
				String ii = Integer.toString(ids);
				ptaker[ids-1] = ii;
				int a = ids-1;
				
				phamCenter1.add(new JLabel("    "+ii),BorderLayout.WEST);
				
				phamCenter1.add(new JLabel("                                "+phamName[ids-1]), BorderLayout.CENTER);

				JButton readyBt = new JButton("Ready");
						readyBt.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								
								String mm = "You clicked button "+ ptaker[a];
								JOptionPane.showMessageDialog(null, mm);
								
								
								dis = Integer.toString(phamidQ [a]);
								
								p_qu1 = Integer.toString(p_qu [a]);
								
								try {
									cs = con.prepareCall("{call phamMedication(?,?)}");
									cs.setString(1, dis);
									cs.registerOutParameter(2, Types.VARCHAR);
									cs.execute();
									
									prisMedication.setText(cs.getString(2));
									
									
								}
								catch(Exception ex) {
									ex.printStackTrace();
								}
								phamPName.setText(phamName[a]);
								phamacyCard.show(phamacyCenter, "Drug Request");
								
								
							}
						});
						
						
				phamCenter1.add(readyBt, BorderLayout.EAST);
				
				if(ids%2==0) {
				phamCenter1.setBackground(Color.WHITE);
				}
				
				phamacyQueueCenter.add(phamCenter1);
				
				
			}
			JScrollPane phamQueueScroll = new JScrollPane(phamacyQueueCenter);
			
			phamacyCenter.add(phamQueueScroll,"PhamQueue");	
			
			
		
		
		
		
		
	}
	// 0000000000000000000000000000000000000000000  LABORATORY  000000000000000000000000000000000000000000000000000000	
	
	public void labQ() throws SQLException {
		JPanel LabQueue = new JPanel(new GridLayout(1,1));
		
		JPanel labQueueCenter = new JPanel();
		
		labQueueCenter.setLayout(new GridLayout(labMax+10,1,4,4));		
		F_M_MainClass connSCheck = new F_M_MainClass();
		connSCheck.queueMax();
		String [] ltaker = new String[labMax];

		labp_qu = new int[labMax];
		labidQ = new int[labMax];

			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
			PreparedStatement prdst = con.prepareStatement("SELECT history_id, id FROM fuoye_medical.labqueue WHERE status=1");
			ResultSet rs = prdst.executeQuery();
			int i = 0;
			while(rs.next()) {
				labp_qu [i] = rs.getInt("id");
				labidQ [i] = rs.getInt("history_id");
				i++;
			}
			
			
		labid = new int[labMax];
		labTest = new String[labMax];
		
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
			for(int i1=0;i1<labMax;i1++) {
				PreparedStatement prdst1 = con.prepareStatement("SELECT patient_id, lab_test FROM fuoye_medical.history WHERE id="+labidQ [i1]);
				ResultSet rs1 = prdst1.executeQuery();
				rs1.next();
				labid [i1] = rs1.getInt("patient_id");
				labTest [i1] = rs1.getString("lab_test");
					
			}

		lab_pName = new String[labMax];

			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
			for(int i2= 0; i2<labMax; i2++) {
				
				PreparedStatement prdst2 = con.prepareStatement("SELECT surname, firstname FROM fuoye_medical.patients WHERE patient_id="+labid [i2]);
				ResultSet rs2 = prdst2.executeQuery();
				rs2.next();
				
				lab_pName[i2] = rs2.getString("surname")+"       "+rs2.getString("firstname");
				
			}

			for(int i_=0;i_<labMax;i_++) {
				
				JPanel labCenter1 = new JPanel(new BorderLayout());
				
				String ii = Integer.toString(i_+1);
				
				ltaker[i_] = ii;
				
				int a = i_;
							
				labCenter1.add(new JLabel("    "+ii),BorderLayout.WEST);
				labCenter1.add(new JLabel("                                "+lab_pName[i_]), BorderLayout.CENTER);
				
				JButton readyBt = new JButton("Ready");
						readyBt.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								String mm = "You clicked button "+ ltaker[a];
								JOptionPane.showMessageDialog(null, mm);
								
								lab_ht_id = labidQ[a];
								
								lab_lq_id = labp_qu[a];
								
								labPName.setText(lab_pName[a]);
								
								lab_test.setText(labTest[a]);
								
								LabCard.show(LabCenter, "Test Result");
							}
						});
						
						
				labCenter1.add(readyBt, BorderLayout.EAST);
				
				if(i_%2==0) {
				labCenter1.setBackground(Color.WHITE);
				}
				
				labQueueCenter.add(labCenter1);
				
			}
			
		JScrollPane labQueueScroll = new JScrollPane(labQueueCenter);
		
		LabQueue.add(labQueueScroll);
		
		LabCenter.add(LabQueue,"LabQueue");
		
	}
	
	
	
// ----------------MAIN METHOD------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		}
		catch(Exception exec) {
			exec.printStackTrace();
		}
		
		F_M_MainClass call = new F_M_MainClass();
		call.frameOne();
		call.setTitle("FUOYE MEDIC");
		call.setSize(400,450);
		call.setLocationRelativeTo(null);
		call.setResizable(false);
		call.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		call.setVisible(true);
		
		
		
		/*
		F_M_MainClass cal = new F_M_MainClass();
		cal.frameTwo();
		cal.setTitle("FUOYE MEDIC");
		cal.setSize(1365,770);
		cal.setLocationRelativeTo(null);
		cal.setResizable(false);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      	MasterCard.show(aCentrePanel, "DocQueue");
		cal.setVisible(true);
		*/
		

	}
	
	public void queueMax() throws SQLException {
		cs = con.prepareCall("{call allQueueMax(?,?,?)}");
		cs.registerOutParameter(1, Types.INTEGER);
		cs.registerOutParameter(2, Types.INTEGER);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.execute();
		
		mroMax = cs.getInt(1);
		phamMax = cs.getInt(2);
		labMax = cs.getInt(3);
	}
	
	// ---------CONNECTOR CLASS-----------------------------------------------------------------------------------------------
	public void dbConnector() {
			
			if(remoteCheckBox.isSelected()){
				try {
				con = DriverManager.getConnection("jdbc:mysql://fuoye@127.0.0.1:22/fuoye_medical?serverTimezone=UTC","fuoye", "B.blessing2");
				}
				catch(Exception exec) {
					exec.printStackTrace();
				}
				
			}
			else {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
					}
					catch(Exception exec) {
						exec.printStackTrace();
					}
			}
			
		}
	public class ConnectorClass {
		
		public  void aUser() throws SQLException, ClassNotFoundException {			
			try {
			cs = con.prepareCall("{call authorised_user(?,?,?,?,?)}");
			cs.setString(1, userName.getText());
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			aPassword = cs.getString(2);
			aPost = cs.getString(3);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.execute();
			
			name = cs.getString(4)+" "+cs.getString(5);
			
			dashName1 = ("Welcome "+cs.getString(4)+" "+cs.getString(5));
			
			
			
			}
			catch(Exception exec) {
				exec.printStackTrace();
				
			}
			
		}
		
		public void singleCheck () throws SQLException, IOException {
			
			
			
			try {
				
				cs = con.prepareCall("{call patient_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cs.setString(1, chk);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.DATE);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.VARCHAR);
				cs.registerOutParameter(10, Types.VARCHAR);
				cs.registerOutParameter(11, Types.VARCHAR);
				cs.registerOutParameter(12, Types.INTEGER);
				cs.registerOutParameter(13, Types.VARCHAR);
				cs.registerOutParameter(14, Types.VARCHAR);
				cs.registerOutParameter(15, Types.INTEGER);
				cs.registerOutParameter(16, Types.INTEGER);
				cs.registerOutParameter(17, Types.VARCHAR);
				cs.registerOutParameter(18, Types.INTEGER);
				cs.execute();
				
				
				
				pad1.setText(cs.getString(2));
				pad2.setText(cs.getString(3));
				pad3.setText(cs.getString(4));
				pad4.setText(cs.getString(5));
				pad5.setText(cs.getString(6));
				pad6.setText(cs.getString(7));
				pad7.setText(cs.getString(8));
				pad8.setText(cs.getString(11));
				pad11.setText(cs.getString(9));
				padGenoType.setText(cs.getString(10));
				pad12.setText(cs.getString(12));
				pad13.setText(cs.getString(13));
				pad14.setText(cs.getString(14));
				pad15.setText(cs.getString(15));
				pad16.setText(cs.getString(16));
				pad17.setText(cs.getString(17));
				pad18.setText(cs.getString(19));
				pad19.setText(cs.getString(18));
				
				
				cs = con.prepareCall("{call nok(?,?,?,?,?)}");
				cs.setString(1, chk);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.execute();
				
				pad24.setText(cs.getString(2));
				pad25.setText(cs.getString(3));
				pad26.setText(cs.getString(4));
				pad27.setText(cs.getString(5));
				
				cs = con.prepareCall("{call parents(?,?,?,?,?)}");
				cs.setString(1, chk);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.execute();
				
				pad20.setText(cs.getString(2));
				pad21.setText(cs.getString(3));
				pad22.setText(cs.getString(4));
				pad23.setText(cs.getString(5));
				
				cs = con.prepareCall("{call course(?,?,?)}");
				cs.setString(1, chk);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.execute();
				pad9.setText(cs.getString(2));
				pad10.setText(cs.getString(3));
				
				F_M_MainClass cconn = new F_M_MainClass();
				cconn.imageRetrieve();
				
				
			}
			catch(Exception exec) {
				exec.printStackTrace();
			}
			
			
		}
		
		public void emergencyCheck() throws SQLException {
			
			cs = con.prepareCall("{call emergency_count(?,?,?)}");
			cs.setString(1, eSurName.getText());
			cs.setString(2, eFirstName.getText());
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			no = cs.getInt(3);
			
			if (no==0) {
				JOptionPane.showMessageDialog(null, "Invalid credential.");
			}
			else {
				
				PreparedStatement pss = con.prepareStatement("SELECT patient_id,surname,firstname,midde_name FROM fuoye_medical.patients WHERE surname= \""+eSurName.getText()+"\" AND firstname = \""+eFirstName.getText()+"\"");
				ResultSet rs = pss.executeQuery();
				
				theEmName = new String[no];
				theEmId = new int[no];
				int i= 0;
				while (rs.next()) {
					theEmId[i] = rs.getInt("patient_id");
					theEmName[i] = rs.getString("surname")+"    "+rs.getString("firstname")+"    "+rs.getString("midde_name");
					
					i++;
					
				}
				
				theEmDept = new String[no];
				
				
				
				for (int y1=0;y1<no;y1++) {
					
					
					PreparedStatement pss2 = con.prepareStatement("SELECT department FROM fuoye_medical.course WHERE patient_id = "+theEmId[y1]);
					
					ResultSet rs2 = pss2.executeQuery();
					rs2.next();
					theEmDept[y1] = rs2.getString("department");
					
				}
				
				
				/*
				
				try {
					cs = con.prepareCall("{call emergency_checker(?,?,?)}");
					cs.setString(1, eSurName.getText());
					cs.setString(2, eFirstName.getText());
					cs.registerOutParameter(3, Types.INTEGER);
					cs.execute();
					chk = cs.getString(3);
					
					cs = con.prepareCall("{call emergency_checker2(?,?)}");
					cs.setString(1, chk);
					cs.registerOutParameter(2, Types.VARCHAR);
					cs.execute();
					Chk = cs.getString(2);
					
					
				}
				catch(Exception exec) {
					exec.printStackTrace();
				}
				*/
			}
		}
			
	}
	public void imageRetrieve() throws SQLException, IOException {
		
		ic1 = new ImageIcon("images/"+chk+"A.PNG");
		image1 = ic1.getImage();
		mimg1 = image1.getScaledInstance(pixLabel.getWidth(), pixLabel.getHeight(), Image.SCALE_SMOOTH);
		nic1 = new ImageIcon(mimg1);
		pixLabel.setIcon(nic1);
		
	}
	public void exitM() {
		F_M_MainClass slkde = new F_M_MainClass();
		slkde.frameTwo();
		slkde.dispose();
		
		F_M_MainClass slkd = new F_M_MainClass();
		slkd.frameOne();
		slkd.setTitle("FUOYE MEDIC");
		slkd.setSize(400,450);
		slkd.setLocationRelativeTo(null);
		slkd.setResizable(false);
		slkd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slkd.setVisible(true);
		
		
		
	}
	public void medsentButton() throws SQLException {

		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		cs = con.prepareCall("{call medsentButton(?,?)}");
		cs.setInt(1, lPham+1);		
		cs.setInt(2, docN);
		cs.execute();
		
		String medica = MedicationText.getText();
		String sddd = "UPDATE fuoye_medical.history SET medication = \""+medica+"\", process = \"PHARMACY\" WHERE id ="+ docN;
		PreparedStatement prdst = con.prepareStatement(sddd); 
		int rs = prdst.executeUpdate();
		
	}
	
	public void docDoneB() throws SQLException {
		
		F_M_MainClass connCSH = new F_M_MainClass();
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");
		
		String medica = newDoctorRemark.getText();
		String docName = DocdashName1.getText();
		String sddd = "UPDATE fuoye_medical.history SET status = 0, doctors_comment = \""+medica+"\", process = \"PHARMACY\", doctorName =\""+docName+"\" WHERE id ="+ docN;
		PreparedStatement prdst = con.prepareStatement(sddd); 
		int rs = prdst.executeUpdate();
		
		connCSH.docQ();
		MasterCard.show(aCentrePanel, "DocQueue");
		
	}
	public void labsentButton() throws SQLException {
		
		F_M_MainClass connCSH = new F_M_MainClass();
		
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuoye_medical?serverTimezone=UTC","root", "B.blessing2");

		cs = con.prepareCall("{call labsentButton(?,?)}");
		
		if(UrineTestCheckBox.isSelected() && BloodTestCheckBox.isSelected()) {
			
			cs.setInt(1, lLab+1);
			cs.setInt(2, docN);
			cs.execute();
			
			PreparedStatement prdst = con.prepareStatement("UPDATE fuoye_medical.history SET lab_test = \"BLOOD AND URINE\", process = \"LABORATORY\" WHERE id ="+ docN);
			int rs = prdst.executeUpdate();
			
			connCSH.docQ();
			
			MasterCard.show(aCentrePanel, "DocQueue");
			
		}
		else if(BloodTestCheckBox.isSelected()) {
			
			cs.setInt(1, lLab+1);
			cs.setInt(2, docN);
			cs.execute();
			
			PreparedStatement prdst = con.prepareStatement("UPDATE fuoye_medical.history SET lab_test = \"BLOOD\", process = \"LABORATORY\" WHERE id ="+ docN);
			int rs = prdst.executeUpdate();
			
			connCSH.docQ();
			MasterCard.show(aCentrePanel, "DocQueue");
			
		}
		else if (UrineTestCheckBox.isSelected()) {
			
			cs.setInt(1, lLab+1);
			cs.setInt(2, docN);
			cs.execute();
			
			PreparedStatement prdst = con.prepareStatement("UPDATE fuoye_medical.history SET lab_test = \"URINE\", process = \"LABORATORY\" WHERE id ="+ docN);
			int rs = prdst.executeUpdate();
			
			connCSH.docQ();
			
			MasterCard.show(aCentrePanel, "DocQueue");
		}
		else {
			JOptionPane.showMessageDialog(null, "No Check box Clicked\n\nPlease ensure at least one is checked");
		}
	}
	
	public void SearchList() {
		
		
		
		
		
		
		
		
		JPanel eeList2 = new JPanel();
		eeList2.setLayout(new GridLayout(no+10,1,4,4));
		
		String [] ptaker = new String[no];
			for(int d=0;d<no;d++) {
				
				String ii = Integer.toString(d+1);
				ptaker[d] = ii;
				int a = d;
				
				JPanel searchCenter1 = new JPanel(new BorderLayout());
				
				searchCenter1.add(new JLabel("    "+ii),BorderLayout.WEST);
				
				searchCenter1.add(new JLabel("                                "+theEmName[d]+"                  ( "+theEmDept[d]+" DEPARTMENT )"), BorderLayout.CENTER);
				
				JButton readyBt = new JButton("View Details");
						readyBt.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								
								String mm = "You clicked button "+ ptaker[a];
								JOptionPane.showMessageDialog(null, mm);
								
								
								chk = Integer.toString(theEmId [a]);
								
								ConnectorClass dkdkdsl = new ConnectorClass();
								
								try {
									dkdkdsl.singleCheck();
									
								}
								catch(Exception ex) {
									ex.printStackTrace();
								}
								
								MasterCard.show(aCentrePanel, "Patent Details");
							}
						});
						
						
						searchCenter1.add(readyBt, BorderLayout.EAST);
				
					if(d%2==0) {
						
						searchCenter1.setBackground(Color.WHITE);
					}
					
					eeList2.add(searchCenter1);
			
			}
		
		JScrollPane SearcherScrol = new JScrollPane(eeList2);
		
		eeList.add(SearcherScrol, BorderLayout.CENTER);
		
		aCentrePanel.add(emergencyPage, "Emergency");
		
		MasterCard.show(aCentrePanel, "Home");
		//ksaj;
	}
	
	
	
	public void nokReg() throws IOException {
		try {
			cs = con.prepareCall("{call nokRegistration(?,?,?,?,?,?)}");
			
			lNok +=1;
			String nokn = Integer.toString(lNok);
			cs.setString(1, nokn);
			String patn = Integer.toString(lPatients);
			cs.setString(2, patn);
			cs.setString(3, nSurnamea.getText().toUpperCase());
			cs.setString(4, nFirstNamea.getText().toUpperCase());
			cs.setString(5, nAddressa.getText().toUpperCase());
			cs.setString(6, nPNumbera.getText());
			cs.execute();
			
			
			cs = con.prepareCall("{call courseR(?,?,?,?,?,?)}");
			lCourse +=1;
			String cour = Integer.toString(lNok);
			cs.setString(1, cour);
			String cpid = Integer.toString(lPatients);
			cs.setString(2, cpid);
			cs.setString(3, facultya.getSelectedItem().toString());
			cs.setString(4, departmenta.getSelectedItem().toString());
			cs.setString(5, entryYeara.getText());
			cs.setString(6, entryLevela.getText());
			cs.execute();
			
			cs = con.prepareCall("{call imageR(?,?,?)}");
			lImg +=1;
			String imgg_ = Integer.toString(lNok);
			cs.setString(1, imgg_);
			String imgid_ = Integer.toString(lPatients);
			cs.setString(2, imgid_);
			cs.setString(3, fileName);
			
			cs.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		F_M_MainClass dth = new F_M_MainClass();
		dth.imgStore();
		
		
	}
	public void imgStore() throws IOException {
		File fileSource = new File(fileName);
		File fileDestination = new File("C:\\Users\\B.BLESSING\\eclipse-workspace\\jse\\FUOYE_MEDIC\\images\\"+lPatients+"A.png");
		try {
			Files.copy(fileSource.toPath(), fileDestination.toPath(),StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/*
		String destination = "image/"+lPatients+"A.PNG";
		
		System.out.println("sh");
		
		InputStream inputStr = null;
		OutputStream outputStr = null;
		try {
			inputStr = new FileInputStream(fileName);
			
			System.out.println(fileName);
			
			outputStr = new FileOutputStream(destination);
			
			System.out.println(destination);
			
			byte[] buf = new byte[204800];
			int bytesRead;
			while((bytesRead = inputStr.read(buf))>0) {
				outputStr.write(buf, 0, bytesRead);
			}
			
			System.out.println("done");
		}
		finally {
			inputStr.close();
			outputStr.close();
		} */
		
		
		/*String destination = "image/"+(lPatients+1)+"A.PNG";
		
		File.createTempFile(fileName, destination);
		
		
		File.Utils.copyFile(fileName, destination);*/
	}
	public void imgStoreLoader() {
		JFileChooser chooser =new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		fileName = f.getAbsolutePath();
		ImageIcon ic = new ImageIcon(fileName);
		Image image = ic.getImage();
		Image mimg = image.getScaledInstance(imgLLabel.getWidth(), imgLLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon nic = new ImageIcon(mimg);
		imgLLabel.setIcon(nic);
	}
	
	public void parReg() {
		try {
			cs = con.prepareCall("{call registration(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			lPatients +=1;
			String intT = Integer.toString(lPatients);
			cs.setString(1, intT);
			cs.setString(2, surnamea.getText().toUpperCase());
			cs.setString(3, firstNamea.getText().toUpperCase());
			cs.setString(4, middleNamea.getText().toUpperCase());
			cs.setString(5, gendera.getSelectedItem().toString());
				String doby =  DOBy.getText().toString();
				String dobm = (String) DOBm.getSelectedItem();
				String dobd = (String) DOBd.getSelectedItem();
				String dobM = doby+"-"+dobm+"-"+dobd;
			cs.setString(6, dobM);
			cs.setString(7, weight.getText());
			cs.setString(8, heighta.getText());
			cs.setString(9, blooda.getText().toUpperCase());
			cs.setString(10, genotypea.getText().toUpperCase());
			cs.setString(11, addressa.getText().toString().toUpperCase());
			cs.setString(12, temperature.getText());
			cs.setString(13, pNumbera.getText());
			cs.execute(); 
			
			cs = con.prepareCall("{call parentRegistration(?,?,?,?,?,?)}");
			lParents +=1;
			String parn = Integer.toString(lParents);
			cs.setString(1, parn);
			String ppatn = Integer.toString(lPatients);
			cs.setString(2, ppatn);
			cs.setString(3, pSurnamea.getText().toUpperCase());
			cs.setString(4, pFirstNamea.getText().toUpperCase());
			cs.setString(5, pAddressa.getText().toUpperCase());
			cs.setString(6, pPNumbera.getText());
			cs.execute();
			
			
			cs = con.prepareCall("{call intialTest(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			lInitial +=1;
			String intt = Integer.toString(lInitial);
			cs.setString(1, intt);
			String tn = Integer.toString(lPatients);
			cs.setString(2, tn);
			cs.setString(3, pregnancy.getText().toUpperCase());
			cs.setString(4, sugarLevel.getText());
			cs.setString(5, Typhoid.getText().toUpperCase());
			cs.setString(6, fbs.getText());
			cs.setString(7, rbs.getText());
			cs.setString(8, malarialParasite.getText().toUpperCase());
			cs.setString(9, temperature.getText());
			cs.setString(10, bp.getText());
			cs.setString(11, weight.getText());
			cs.setString(12, breastTest.getText());
			cs.setString(13, xRC.getText());
			cs.setString(14, eyesTest.getText());
			cs.execute();
			
			
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void lastNumber() {
		try {
			cs = con.prepareCall("{call allMax(?,?,?,?,?,?,?,?,?,?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2,Types.INTEGER);
			cs.registerOutParameter(3,Types.INTEGER);
			cs.registerOutParameter(4,Types.INTEGER);
			cs.registerOutParameter(5,Types.INTEGER);
			cs.registerOutParameter(6,Types.INTEGER);
			cs.registerOutParameter(7,Types.INTEGER);
			cs.registerOutParameter(8,Types.INTEGER);
			cs.registerOutParameter(9,Types.INTEGER);
			cs.registerOutParameter(10,Types.INTEGER);
			cs.execute();
			
			lUsers = cs.getInt(1);
			lCourse = cs.getInt(2);
			lHistory = cs.getInt(3);
			lInitial = cs.getInt(4);
			lLab = cs.getInt(5);
			lNok = cs.getInt(6);
			lParents = cs.getInt(7);
			lImg = cs.getInt(8);
			lPatients = cs.getInt(9);
			lPham = cs.getInt(10);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void newDate() {
		LocalDate current = LocalDate.now();
		date = String.format(current.toString());
	}
	
	public void newVitalTest() {
		try {
			cs = con.prepareCall("{call newVitalTest(?,?,?,?,?,?)}");
			lHistory +=1;
			String LH = Integer.toString(lHistory);
			cs.setString(1, LH);			
			cs.setString(2, chk);
			cs.setString(3, weight2.getText());
			cs.setString(4, temperature2.getText());
			cs.setString(5, bp2.getText());
			cs.setString(6, date);
			cs.execute();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void labBloodTest() throws SQLException {
		
		cs = con.prepareCall("{call labDoneBlood(?,?,?,?,?)}");
		cs.setInt(1, lab_lq_id);
		cs.setInt(2, lab_ht_id);
		cs.setString(3, FBSCheck.getText());
		cs.setString(4, RBSCheck.getText());
		cs.setString(5, malarialCheck.getText());
		cs.execute();
	}
	
	public void labUrineTest() throws SQLException {
		
		cs = con.prepareCall("{call labDoneUrine(?,?,?,?,?)}");
		cs.setInt(1, lab_lq_id);
		cs.setInt(2, lab_ht_id);
		cs.setString(3, pregnancyCheck.getText());
		cs.setString(4, sugarCheck.getText());
		cs.setString(5, typhoidCheck.getText());
		cs.execute();
	}
	public void theList(int ilist) throws SQLException {
				
		cs = con.prepareCall("{call hst(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setInt(1, allIds[ilist]);
		cs.registerOutParameter(2, Types.INTEGER);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.INTEGER);
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.registerOutParameter(6, Types.INTEGER);
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.registerOutParameter(8, Types.INTEGER);
		cs.registerOutParameter(9, Types.INTEGER);
		cs.registerOutParameter(10, Types.VARCHAR);
		cs.registerOutParameter(11, Types.VARCHAR);
		cs.registerOutParameter(12, Types.VARCHAR);
		cs.registerOutParameter(13, Types.VARCHAR);
		cs.execute();
		
		VitalSignA.setText("Vital tests:\n  BP: "+cs.getInt(2)+"\n  Weight: "+cs.getInt(3)+"\n  Temperature: "+cs.getInt(4));
		RemarkA.setText("Tests:\n  Pregnancy: "+cs.getString(5)+"\n  Sugar Level: "+cs.getInt(6)+"\n  Typhoid: "+cs.getString(7)+"\n  FBS: "+cs.getInt(8)+"\n  RBS: "+cs.getInt(9)+"\n  Malarial Parasite: "+cs.getString(10));
		TestA.setText("Doctor's remark: \n"+cs.getString(11)+"\n\nDoctor's Name:\n"+cs.getString(13));
		MedicationA.setText("Medications: \n"+cs.getString(12));
		 
	}
	
	// ------- ITEM LISTENER -------------------------------------------------------------------------------------------------
	
	class HistoryList implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			int item = lst.getSelectedIndex();
			
			F_M_MainClass lll = new F_M_MainClass();
			try {
				lll.theList(item);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
	}
	
	
	
	
	
	
	// --------EVENT HANDLER--------------------------------------------------------------------------------------------------
	public class Handler implements ActionListener {
		@SuppressWarnings({ "deprecation" })
		public void actionPerformed (ActionEvent event) {
			
			ConnectorClass conn = new ConnectorClass();
			
			if (event.getSource()== lgBtn) {
				
				String pas = String.format(password.getText());
				try {
					conn.aUser();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (pas.equals(aPassword)) {
					JOptionPane.showMessageDialog(null, dashName1);	
					DocdashName1.setText(dashName1);
					DLK.setText(aPost);
					dashName.setText("                                                                         "+ dashName1);
					
					
					F_M_MainClass cal = new F_M_MainClass();
					cal.frameTwo();
					cal.setTitle("FUOYE MEDIC");
					cal.setSize(1365,770);
					cal.setLocationRelativeTo(null);
					cal.setResizable(false);
					cal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					cal.setVisible(true);
					
					userName.setText("");
					password.setText("");
					
					if (aPost.equals("DOCTOR")) {
						DocdashName1.setText(name);
						
						F_M_MainClass connCSH = new F_M_MainClass();
						
						try {
							connCSH.docQ();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						connCSH.doctorPag();
						
						MasterCard.show(aCentrePanel, "DocQueue");
					}
					else if(aPost.equals("PHARMACIST")){
						AttendentdashName1.setText(name);
						F_M_MainClass connSCheck = new F_M_MainClass();
						connSCheck.lastNumber();
						try {
							connSCheck.queueMax();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						phamQueue = phamMax;
						
						phamid = new int[phamQueue];
						phamName = new String[phamQueue];
						phamidQ  = new int[phamQueue];
						p_qu = new int[phamQueue];
						
						try {
							connSCheck.thePham();
						} catch (SQLException e) {
							e.printStackTrace();
						}
	
						phamacyCard.show(phamacyCenter,"PhamQueue");
						MasterCard.show(aCentrePanel, "Phamacy");
					}
					else if(aPost.equals("LAB ATTENDANT")){
						LabAttendentdashName1.setText(name);
						
						F_M_MainClass connSCheck = new F_M_MainClass();
						try {
							connSCheck.labQ();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						//LabCard.show(LabCenter, "LabQueue");
						
						MasterCard.show(aCentrePanel, "Laboratory");
					}
					else if(aPost.equals("MEDICAL RECORD OFFICER")){
						MasterCard.show(aCentrePanel, "Home");
					}
							
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect login credentials");
				}
			}
			else if (event.getSource() == cancle) {
				System.exit(0);
			}
			else if (event.getSource()==check) {
				MasterCard.show(aCentrePanel, "Check");
			}
			else if (event.getSource()==check2) {
				
				chk=cardNumber.getText();				
				
				
				String qC = "SELECT surname FROM fuoye_medical.patients WHERE patient_id="+chk;
				Statement st = null;
				ResultSet rs = null;
				
				try {
					
					st = con.createStatement();
					
					rs = st.executeQuery(qC);
					
					if(rs.absolute(1)) {
						ConnectorClass connSCheck = new ConnectorClass();
						try {
							connSCheck.singleCheck();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						MasterCard.show(aCentrePanel, "Patent Details");
					}
					else
						JOptionPane.showMessageDialog(null, "Patient not found");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			else if(event.getSource()== emergency){
				MasterCard.show(aCentrePanel, "Emergency");
			}
			else if(event.getSource()== Back){
				MasterCard.show(aCentrePanel, "Home");
			}
			else if(event.getSource()== eBack){
				MasterCard.show(aCentrePanel, "Home");
			}
			
			else if(event.getSource()== lgBtn2){
			
					ConnectorClass connSCheck = new ConnectorClass();
					F_M_MainClass connSChecks = new F_M_MainClass();
					try {
						connSCheck.emergencyCheck();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					connSChecks.SearchList();
					
					MasterCard.show(aCentrePanel, "Emergency");
					
			}
			else if(event.getSource()== queue){
				
				F_M_MainClass connSCheck = new F_M_MainClass();
				connSCheck.lastNumber();
				
				try {
					connSCheck.queueMax();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				mroQueue=mroMax;
				
				h_p_id = new int[mroQueue];
				h_pProcess = new String[mroQueue];
				h_pName = new String[mroQueue];
				
				                  
				try {
					connSCheck.mroQ();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				try {
					connSCheck.tmroQ();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				try {
					connSCheck.theQueue();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
			}
			else if(event.getSource()== register){
				MasterCard.show(aCentrePanel, "Register");
				registerTab.setSelectedIndex(0);
			}
			else if(event.getSource()== cancle1){
				surnamea.setText("");
				firstNamea.setText("");
				middleNamea.setText("");
				heighta.setText("");
				addressa.setText("");
				entryLevela.setText("");
				entryYeara.setText("");
				DOBy.setText("");
				MasterCard.show(aCentrePanel, "Home");
			}
			else if(event.getSource()== OutBt) {
				MasterCard.show(aCentrePanel, "Home");
			}
			
			
			
			else if(event.getSource()== mainBack) {
				MasterCard.show(aCentrePanel, "Home");
			}
			
			
			else if(event.getSource()== cancle2){
				surnamea.setText("");
				firstNamea.setText("");
				middleNamea.setText("");
				heighta.setText("");
				addressa.setText("");
				DOBy.setText("");
				entryLevela.setText("");
				entryYeara.setText("");
				MasterCard.show(aCentrePanel, "Home");
			}
			else if(event.getSource()== cancle3){
				surnamea.setText("");
				firstNamea.setText("");
				middleNamea.setText("");
				heighta.setText("");
				addressa.setText("");
				entryLevela.setText("");
				entryYeara.setText("");
				MasterCard.show(aCentrePanel, "Home");
			}
			else if (event.getSource() == next1) {
				registerTab.setSelectedIndex(1);
			}
			else if (event.getSource() == next2) {
				registerTab.setSelectedIndex(3);
			}
			else if (event.getSource() == imgNext) {
				registerTab.setSelectedIndex(2);
			}
			else if (event.getSource() == imgBack) {
				MasterCard.show(aCentrePanel, "Home");
			}
			else if(event.getSource()== Continue) {
				
				String qCt = "SELECT id FROM fuoye_medical.history WHERE patient_id="+chk+" AND status = 1";
				PreparedStatement stt;
				try {
					stt = con.prepareStatement(qCt);
					ResultSet rst = stt.executeQuery();
					if (rst.absolute(1)) {
						JOptionPane.showMessageDialog(null, "This Patient's record had been administered.");
					}
					else {
						MasterCard.show(aCentrePanel, "Vital Sign");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			else if(event.getSource()== cancel2) {
				MasterCard.show(aCentrePanel, "Home");
			}
			
			else if(event.getSource()== labExit) {
				F_M_MainClass connCSH = new F_M_MainClass();
				connCSH.exitM();
				
			}
			else if(event.getSource()== phamExit) {
				F_M_MainClass connCSH = new F_M_MainClass();
				connCSH.exitM();
			}
			else if(event.getSource()== docExit) {
				F_M_MainClass connCSH = new F_M_MainClass();
				connCSH.exitM();
			}
			else if(event.getSource()== DoctorReject) {
				F_M_MainClass connCSH = new F_M_MainClass();
				dlm.setSize(0);
				try {
					PreparedStatement ps = con.prepareStatement("UPDATE fuoye_medical.history SET process = \"QUEUE\" WHERE id = "+docN);
					int rr = ps.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				try {
					connCSH.docQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connCSH.doctorPag();
				
			}
			
			
			else if(event.getSource()== DocRefresh) {
				F_M_MainClass connCSH = new F_M_MainClass();
				
				try {
					connCSH.docQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connCSH.doctorPag();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			else if(event.getSource()== photo) {
				F_M_MainClass connCSh = new F_M_MainClass();
				connCSh.imgStoreLoader();
			}
			else if(event.getSource()== submit) {
								
				F_M_MainClass cal = new F_M_MainClass();
				cal.newDate();
				cal.lastNumber();
				cal.newVitalTest();
				
				JOptionPane.showMessageDialog(null, "Operation Successful"); 
				
				MasterCard.show(aCentrePanel, "Home");
			}
			else if(event.getSource()== rDone) {
				F_M_MainClass ca = new F_M_MainClass();
				ca.lastNumber();
				ca.parReg();
				try {
					ca.nokReg();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Operation Successful\n\n\n\nThe Patient's id is: "+lPatients); 
				
				MasterCard.show(aCentrePanel, "Home");
			}
			
			else if(event.getSource()==	phamRejectBt) {
				
				F_M_MainClass connSCheck = new F_M_MainClass();
				
				
				try {
					phamMedicRegtMs();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				connSCheck.lastNumber();
				
				try {
					connSCheck.queueMax();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				phamQueue = phamMax;
				
				phamid = new int[phamQueue];
				phamName = new String[phamQueue];
				phamidQ  = new int[phamQueue];
				p_qu = new int[phamQueue];
				
				
				try {
					connSCheck.thePham();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				phamacyCard.show(phamacyCenter,"PhamQueue");
				
			}
			else if(event.getSource()==phamDoneBt) {
				
				F_M_MainClass connSCheck = new F_M_MainClass();
				
				try {
					connSCheck.phamMedicationDone();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				
				
				connSCheck.lastNumber();
				
				try {
					connSCheck.queueMax();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				phamQueue = phamMax;
				
				phamid = new int[phamQueue];
				phamName = new String[phamQueue];
				phamidQ  = new int[phamQueue];
				p_qu = new int[phamQueue];
				
				try {
					connSCheck.thePham();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				phamacyCard.show(phamacyCenter,"PhamQueue");
				
			}
			else if (event.getSource()==refresh) {
				F_M_MainClass connSCheck = new F_M_MainClass();
				
				try {
					connSCheck.thePham();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				phamacyCard.show(phamacyCenter,"PhamQueue");
			}
			else if (event.getSource()==LabRefBt) {
				F_M_MainClass connSCheck = new F_M_MainClass();
				try {
					connSCheck.labQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				LabCard.show(LabCenter, "LabQueue");
			}
			
			else if (event.getSource()==labDoneBt) {
				
				F_M_MainClass connSCheck = new F_M_MainClass();
				
				String l = lab_test.getText();
				if (l.equals("BLOOD")) {
					try {
						connSCheck.labBloodTest();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Result sent succeful.");
				}
				
				else if(l.equals("URINE")) {
					try {
						connSCheck.labUrineTest();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Result sent succeful.");
				}
				else if(l.equals("BLOOD AND URINE")) {
					try {
						connSCheck.labBloodTest();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						connSCheck.labUrineTest();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Result sent succeful.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Sorry no test performed.");
				}
				
				try {
					connSCheck.labQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				LabCard.show(LabCenter, "LabQueue");
			}
			
			else if(event.getSource()==LabSentBT) {
				F_M_MainClass connSCheck = new F_M_MainClass();
				connSCheck.lastNumber();
				
				try {
					connSCheck.labsentButton();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				

				try {
					connSCheck.docQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connSCheck.doctorPag();
				
				
				
				MasterCard.show(aCentrePanel, "DocQueue");
				
			}
			else if(event.getSource()==medicationBT) {
				F_M_MainClass connSCheck = new F_M_MainClass();
				connSCheck.lastNumber();
				
				try {
					connSCheck.medsentButton();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					connSCheck.docQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Medication sent");
				//connSCheck.doctorPag();
				
				//MasterCard.show(aCentrePanel, "DocQueue");
				
			}
			else if(event.getSource()==FinalDoctorDone) {
				F_M_MainClass connSCheck = new F_M_MainClass();
				connSCheck.lastNumber();
				
				try {
					connSCheck.docDoneB();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					connSCheck.docQ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				connSCheck.doctorPag();
				
				MasterCard.show(aCentrePanel, "DocQueue");
				
			}
			
			
		}
	}	

}
