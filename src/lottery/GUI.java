package lottery;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {
	
	//button positions
	static int x =170;
	static int xlength =150;
	
	static JFrame frameMain;
	static JPanel panelMain;
	//Menu bar components
    static JMenu file;
    static JMenu edit;
    static JMenu help;
    
    static JMenuItem saveAction;
    static JMenuItem loadAction;
    static JMenuItem exitAction;
    static JMenuItem UndoAction;
    static JMenuItem FAQAction;
    static JMenuItem rulesAction;
	static JMenuBar menuBar;
	//JFrame components for the Lottery Game
	static JPanel panelIntro;
	static JPanel panelRules;
	static JPanel panelPlay;
	static JPanel panelResults;
	static JLabel labelIntro;
	static JLabel labelRules;
	static JLabel labelPlay;
	static JLabel labelError;
	static JLabel labelResults;
	static JButton buttonLotto;
	static JButton buttonPlay1;
	static JButton buttonPlay2;
	static JButton buttonPlay3;
	static JButton buttonRules;
	static JButton buttonEnter;
	static JButton buttonClose;
	static JButton buttonHome;
	static JButton buttonHome2;
	static JTextField textfield;
	//JFrame components for the tic tac toe game
	static JPanel panelIntroTic;
	static JPanel panelRulesTic;
	static JPanel panelPlayTic;
	static JPanel panelTicLevel;
	static JLabel labelIntroTic;
	static JLabel labelRulesTic;
	static JLabel labelTicLevel;
	static JLabel labelPlayTic;
	static JLabel labelTicO;
	static JLabel labelTicX;
	static JLabel labelX;
	static JLabel labelO;
	static JLabel labelXturn;
	static JLabel labelOturn;
	static JLabel labelXvictory;
	static JLabel labelOvictory;
	static JLabel labelResultsTic;
	static JButton buttonTic;
	static JButton buttonPlayTic;
	static JButton buttonPlayComp;
	static JButton buttonPlayTic2;
	static JButton buttonPlayTic3;
	static JButton buttonPlayTic4;
	static JButton buttonRulesTic;
	static JButton buttonHome3;
	static JButton buttonHome4;
	static JButton buttonHome5;
	static JButton buttonTic00;
	static JButton buttonTic10;
	static JButton buttonTic20;
	static JButton buttonTic01;
	static JButton buttonTic11;
	static JButton buttonTic21;
	static JButton buttonTic02;
	static JButton buttonTic12;
	static JButton buttonTic22;
	static JComboBox <Object> menuLevels;
	    
	//lottery game variables
	static String input;
	
	// variables containing inputed numbers
	static String[] arr;
	static int[] numbers;
	
	// user errors (when inputting)
	static String messageError;
	static boolean hasErrors;
	static boolean withinRange;
	
	//generating random numbers
	static int[] randomNumb;
	static int randomSize;
	
	//comparing arrays
	static int match;
	static String messageResults;
	
	
	//Tic Tac Toe variables
	//deciding whose turn it is
	static boolean player1;
	//tic tac board
	static int[][] gridTic;
	//dimensions of tic tac board
	static int length= 3;
	//count how many times buttons are pressed
	static int countbutton = 0;
	//player names
	static Player p1;
	static Player p2;
	//computers turn
	static boolean isHumanturn= true;
	//whether player with computer
	static boolean AIplay = false;
	static int level;
		
	public static void setupGUI(){
		
		frameMain = new JFrame("Game Centre");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setupMenuBar();
        
        //set up panels for the lottery 
        setupIntroGUI();
        setupRulesGUI();
        setupPlayGUI();
        setupResultsGUI();
        
        //set up panels for Tic Tac Toe
        setupIntroTicGUI();
        setupPlayTicGUI();
        setupRulesTicGUI();
        setupPlayLevelGUI();
        
        panelMain = new JPanel();
        panelMain.setSize(500,320);
        panelMain.setLayout(null);
        
        //button for lottery game
        buttonLotto = new JButton("The Lottery");
        buttonLotto.setBounds(x,50,xlength,40);
        //set button: click to play game
        
        buttonLotto.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelMain.setVisible(false);
	        	  panelIntro.setVisible(true);
	    			//open the first screen	
	          }
	          });
        
        buttonTic = new JButton("Tic-Tac-Toe");
        buttonTic.setBounds(x,100,xlength,40);
        //set button: click to play game
        
        buttonTic.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelMain.setVisible(false);
	        	  panelIntroTic.setVisible(true);
	        	  loadAction.setEnabled(true);
	    			//open the first screen	
	          }
	          });
        
        panelMain.add(buttonTic);
        panelMain.add(buttonLotto);
        
        panelMain.setVisible(true);
        
        frameMain.add(panelMain);
        //panels for the lottery game
        frameMain.add(panelIntro);
        frameMain.add(panelPlay);
        frameMain.add(panelRules);
        frameMain.add(panelResults);
        //panels for tic tac toe
        frameMain.add(panelIntroTic);
        frameMain.add(panelPlayTic);
        frameMain.add(panelRulesTic);
        frameMain.add(panelTicLevel);
        
	    frameMain.setSize(500, 320);
	    frameMain.setLayout(null);
	    frameMain.setResizable(false);
	    frameMain.setVisible(true);
	}

	public static void setupMenuBar(){
		
        //set up menu bar on frame
        menuBar = new JMenuBar();
        
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        
        saveAction = new JMenuItem("Save Game");
        loadAction = new JMenuItem("Load Game");
        exitAction = new JMenuItem("Exit");
        UndoAction = new JMenuItem("Undo");
        FAQAction = new JMenuItem("FAQ");
        rulesAction = new JMenuItem("Rules");
        
        saveAction.setEnabled(false);
        loadAction.setEnabled(false);
        UndoAction.setEnabled(false);
        FAQAction.setEnabled(false);
        rulesAction.setEnabled(false);
        
        saveAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
        		JFileChooser fileChooser = new JFileChooser();
        		
        		fileChooser.setCurrentDirectory(new File("."));
        		
        		if(fileChooser.showSaveDialog(frameMain)==JFileChooser.APPROVE_OPTION){
            	
	            	String filename = fileChooser.getSelectedFile().getAbsolutePath();
	            	
	           	if(filename.length()<5 || !filename.substring(filename.length()-4, filename.length()).equals(".lgs")){
	            		filename += ".lgs";
	            	}
	            	
	            	PrintWriter writer;
	            	
					try {
						//lgs -> lily's game suite
						writer = new PrintWriter(filename);
		            	writer.println("game: Tic Tac Toe");
		            	writer.println("players:" + p1.getName() + "," + p2.getName());
		            	writer.println("scores:" + p1.getScore() + "," + p2.getScore());
		            	writer.println("AI?:" + AIplay);
		            	writer.close();
		            	
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Failed to save.","alert", JOptionPane.ERROR_MESSAGE);
					}
        		
            	}
            }
        });
        
        loadAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		  		
            	if(chooseFile()){
            		
	            	panelIntroTic.setVisible(false);
	            	panelPlayTic.setVisible(true);
	            	loadAction.setEnabled(false);
	            	saveAction.setEnabled(true);
	            		
	            	//set game labels
					labelTicX.setText(p1.getName());
					labelXvictory.setText("won: " +p1.getScore());
					labelTicO.setText(p2.getName());
					labelOvictory.setText("won: " +p2.getScore());
	           	}
            }
        });
        
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        
        file.add(saveAction);
        file.add(loadAction);
        file.add(exitAction);
        edit.add(UndoAction);
        help.add(FAQAction);
        help.add(rulesAction);
        
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        
        frameMain.setJMenuBar(menuBar);
	}
	
	public static boolean chooseFile(){
		
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setCurrentDirectory(new File("."));
		
		FileFilter filter = new FileNameExtensionFilter("LGS File", "lgs");
		
		fileChooser.setFileFilter(filter);
		
		if(fileChooser.showOpenDialog(frameMain)==JFileChooser.APPROVE_OPTION){
			
			File file = fileChooser.getSelectedFile();
			
			FileInputStream fs;
			try {
				fs = new FileInputStream(file);
			
    			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
					try {
						br.readLine();
						String players = br.readLine();
						String[] playerNames = players.split(":");
						playerNames = playerNames[1].split(",");
							
						p1= new Player(playerNames[0]);
						p2= new Player(playerNames[1]);
			
						String scores = br.readLine();
						String[] scoresArr = scores.split(":");
						scoresArr = scoresArr[1].split(",");
						
						int score1 = Integer.parseInt(scoresArr[0]);
						int score2 = Integer.parseInt(scoresArr[1]);
						
						p1.setScore(score1);
						p2.setScore(score2);
						
						br.close(); 
						
						return true;
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();	
						br.close();
					}	
				
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();	
			}
		}
		return false;
	}
	
	// panels for the lottery game	
	public static void setupIntroGUI(){
		
        //introduction panel
        panelIntro = new JPanel();
        panelIntro.setSize(500, 320);
        panelIntro.setLayout(null);
        
        labelIntro = new JLabel("Welcome to the lottery game!");
        labelIntro.setBounds(170,20,300, 40);
       //introduction message
        
        buttonPlay1 = new JButton("Play Game!");
        buttonPlay1.setBounds(x,70,xlength,40);
        //set button: click to play game
        
        buttonPlay1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  //enter new GUI to start playing game
	        	  panelIntro.setVisible(false);
	        	  panelPlay.setVisible(true);
	          }
	          });
        
        buttonRules = new JButton("Check Rules");
        buttonRules.setBounds(x,130,xlength, 40);
        //set button: click for rules
        
        buttonRules.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelIntro.setVisible(false);
	        	  panelRules.setVisible(true);
	          }
	          });
        
        buttonHome = new JButton("Return Home");
        buttonHome.setBounds(x,190,xlength,40);
        
        buttonHome.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelIntro.setVisible(false);
	        	  panelMain.setVisible(true);
	          }
	          });
        
        //intro panel
        panelIntro.add(buttonHome);
        panelIntro.add(buttonPlay1);
        panelIntro.add(buttonRules);
        panelIntro.add(labelIntro);
        
        panelIntro.setVisible(false);
		
	}
	
	public static void setupRulesGUI(){
		
    	panelRules = new JPanel();
        panelRules.setSize(500,320);
        panelRules.setLayout(null);
        
        labelRules = new JLabel("<html>The Rules:<br>1) Enter 5 numbers in the draw.<br>2) Click play!<br>3) See if your numbers came up in the lotto draw.</html>");
        labelRules.setBounds(150,50,300,100);
        //text explaining rules
    	
        buttonPlay2 = new JButton("Play Game!");
        buttonPlay2.setBounds(x,170,xlength,40);
        
        buttonPlay2.addActionListener(new ActionListener() {
        	//on button click, open new screen to play
	          public void actionPerformed(ActionEvent e){
	        	  panelRules.setVisible(false);
	        	  panelPlay.setVisible(true);
	          }
	          });
        
        panelRules.add(buttonPlay2);
        panelRules.add(labelRules);
        //Display components of window.	
        
        panelRules.setVisible(false);
        
	}
	
	public static void setupPlayGUI(){
		
    	panelPlay = new JPanel();
        panelPlay.setSize(500,320);
        panelPlay.setLayout(null);  
        
        labelPlay = new JLabel("Please enter 5 numbers from 1 to 100:");
        labelPlay.setBounds(150,30,300, 40);
        //text explaining rules
        
		labelError = new JLabel();
		labelError.setBounds(150,60,300,50);
		labelError.setForeground(Color.red);
		//label for user errors in inputting numbers
        
        textfield = new JTextField("Enter numbers.. e.g. 1,2,3,4,5");
        textfield.setBounds(100,120,300, 40);
        //input numbers
        
        textfield.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
					textfield.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
					textfield.setText("");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	
        buttonEnter = new JButton("Enter into the lottery!");
        buttonEnter.setBounds(150,190,200,40);
        
        buttonEnter.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  InputNumbers();
	          }
	          });
       
        panelPlay.add(labelPlay);
        panelPlay.add(labelError);
        panelPlay.add(textfield);
        panelPlay.add(buttonEnter);
        //Display components of window.
        
        panelPlay.setVisible(false);
        
	}
	
	public static void setupResultsGUI(){
		
    	panelResults = new JPanel();
        panelResults.setSize(500,320);
        panelResults.setLayout(null);  
        
        labelResults = new JLabel();
        labelResults.setBounds(100,80,300,70);
        //text explaining rules
        
        buttonPlay3 = new JButton("Play again!");
        buttonPlay3.setBounds(383,220,100,40);
        
        buttonPlay3.addActionListener(new ActionListener() {
        	//on button click, open new screen to play
	          public void actionPerformed(ActionEvent e){
	        	  panelResults.setVisible(false);
	        	  panelIntro.setVisible(true);
	          }
	          });
        
        buttonHome2 = new JButton("Home");
        buttonHome2.setBounds(2,220,100,40);
        
        buttonHome2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelResults.setVisible(false);
	        	  panelMain.setVisible(true);
	          }
	          });
        
        panelResults.add(buttonHome2);
        panelResults.add(buttonPlay3);
        panelResults.add(labelResults);
        //Display components of window
        
        panelResults.setVisible(false);
		
	}

	public static void InputNumbers(){
	
	input= textfield.getText();
	//user input
	
	arr = input.split(",");
	//convert user input to array
	numbers = new int[5];
	
	messageError = "<html>";

	if (arr.length != 5){
		//check array length
		messageError += "Please enter 5 numbers<br>";
		hasErrors= true;
	}
	else{
		try{
			for(int i = 0; i<5; i++){
				//convert string array into integer array
			   numbers[i] = Integer.parseInt(arr[i]);
			   }
			}	
		
		catch(NumberFormatException e){
			//otherwise error message
			messageError+="Please enter numbers only<br>";
			hasErrors= true;
		}
		
		withinRange = true;
		
		for(int i = 0; i < 5; i++){
			 //check numbers are within range
			
			   if((numbers[i]<1 || numbers[i]>100) && withinRange == true){
				   
				   //add message error for first number which is out of range
				   messageError += "Please enter numbers from 1 to 100<br>";
				   withinRange = false;
				   hasErrors= true;
			   }
		   }
	}
		
	if (hasErrors) {
			messageError += "</html>";
			labelError.setText(messageError);
	        hasErrors = false;

	        }
	else{
		
		randomNumb =Utilities.generateRandomNumb(5, 100);
		
		match = Utilities.compareArrays(randomNumb, numbers);
		
        if (match==5){
        	messageResults="WOOOHOOO YOU WON! PERFECT MATCH!";
        }
        
        else if (match==1){
        	messageResults="Good Try! You got 1 number right!";
        }
        
        else if (match>0 && match<5){
        	messageResults="Good Try! You got " + match + " numbers right!";
        }
    	
        else {
        	messageResults="You lost. Why don't you try again?";
        }
		
        labelResults.setText("<html>The winning numbers are: " + randomNumb[0] + ", " + randomNumb[1] + ", "+ randomNumb[2] + ", "+ randomNumb[3] + " and "+ randomNumb[4] + ".<br>" + messageResults + "<br></html>");
        
		panelPlay.setVisible(false);
  	  	panelResults.setVisible(true);
	}
		
	}

	//panels for the tic tac toe game
	public static void setupIntroTicGUI(){
		
	    //introduction panel
	    panelIntroTic = new JPanel();
	    panelIntroTic.setSize(500,320);
	    panelIntroTic.setLayout(null);
	    
	    labelIntroTic = new JLabel("Welcome to Tic-Tac-Toe!");
	    labelIntroTic.setBounds(170,10,300, 40);
	   //introduction message
	    
	    buttonPlayTic = new JButton("Player vs Player");
	    buttonPlayTic.setBounds(x,60,xlength,40);
	    //set button: click to play game
	    
	    buttonPlayTic.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  //enter new GUI to start playing game
	        	  showInputPlayer();
	        	  decidePlayerStart();
	        	  panelIntroTic.setVisible(false);
	        	  loadAction.setEnabled(false);
	        	  panelPlayTic.setVisible(true);
	        	  saveAction.setEnabled(true);
	          }
	          });
	    
	    buttonPlayComp = new JButton("Player vs Computer");
	    buttonPlayComp.setBounds(x,110,xlength,40);
	    //set button: click to play game
	    
	    buttonPlayComp.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelIntroTic.setVisible(false);
	        	  loadAction.setEnabled(false);
	        	  panelTicLevel.setVisible(true);
	          }
	          });
	    
	    buttonRulesTic = new JButton("Check Rules");
	    buttonRulesTic.setBounds(x,160,xlength, 40);
	    //set button: click for rules
	    
	    buttonRulesTic.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelIntroTic.setVisible(false);
	        	  loadAction.setEnabled(false);
	        	  panelRulesTic.setVisible(true);
	          }
	          });
	    
	    buttonHome3 = new JButton("Return Home");
	    buttonHome3.setBounds(x,210,xlength,40);
	    
	    buttonHome3.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelIntroTic.setVisible(false);
	        	  loadAction.setEnabled(false);
	        	  panelMain.setVisible(true);
	          }
	          });
	    
	    //intro panel
	    panelIntroTic.add(buttonHome3);
	    panelIntroTic.add(buttonPlayTic);
	    panelIntroTic.add(buttonPlayComp);
	    panelIntroTic.add(buttonRulesTic);
	    panelIntroTic.add(labelIntroTic);
	    
	    panelIntroTic.setVisible(false);
		
	}
	
	public static void setupRulesTicGUI(){
		
    	panelRulesTic = new JPanel();
        panelRulesTic.setSize(500,320);
        panelRulesTic.setLayout(null);
        
        labelRulesTic = new JLabel("<html>The Rules:<br>Aim- Put three of your marks (X or O) in a row before your opponent!<br><br>1) Players choose X or O<br>2) First player starts by clicking grid<br>3) Players alternate putting their signs on the board<br>4) Game ends when 3 signs are in a row (diagonal, vertical or horizontal)<br></html>");
        labelRulesTic.setBounds(70,20,350,150);
        //text explaining rules
    	
        buttonPlayTic3 = new JButton("Play Game!");
        buttonPlayTic3.setBounds(383,220,100,40);
        
        buttonPlayTic3.addActionListener(new ActionListener() {
        	//on button click, open new screen to play
	          public void actionPerformed(ActionEvent e){
	        	  panelRulesTic.setVisible(false);
	        	  panelIntroTic.setVisible(true);
	        	  loadAction.setEnabled(true);
	          }
	          });
        
        buttonHome5 = new JButton("Back");
        buttonHome5.setBounds(2,220,100,40);
        
        buttonHome5.addActionListener(new ActionListener() {
        	//on button click, open new screen to play
	          public void actionPerformed(ActionEvent e){
	        	  panelRulesTic.setVisible(false);
	        	  panelIntroTic.setVisible(true);
	        	  loadAction.setEnabled(true);
	          }
	          });
        
        panelRulesTic.add(buttonHome5);
        panelRulesTic.add(buttonPlayTic3);
        panelRulesTic.add(labelRulesTic);
        //Display components of window.	
        
        panelRulesTic.setVisible(false);
        
	}
	
	public static void showInputPlayer(){
		
		p1= new Player(JOptionPane.showInputDialog("Player 1 name: (max 7 characters)"));
		labelTicX.setText(p1.getName());
		
		labelXvictory.setText("won: " +p1.getScore());
		
		if(AIplay){
			//two different AI players- easy and difficult levels
			if(level>80){
				p2= new Player("Jack Pro", false, level);
			}else{
				p2= new Player("Joe Easy", false, level);
			}
		}
		//else human player
		else{
			p2= new Player(JOptionPane.showInputDialog("Player 2 name: (max 7 characters)"));
		}
		
		labelTicO.setText(p2.getName());
		labelOvictory.setText("won: " +p2.getScore());
		
	}
	
	public static void decidePlayerStart(){
		//determine who goes first
		int[] randomTurn = Utilities.generateRandomNumb(1, 2);
		
		if(randomTurn[0]==1){
			player1= true;
			labelXturn.setText("you start");
		} else{
			player1= false;
			labelOturn.setText("you start");
		}
	}
	
	public static void setupPlayLevelGUI(){
		
    	panelTicLevel = new JPanel();
        panelTicLevel.setSize(500,320);
        panelTicLevel.setLayout(null);  
        
        labelTicLevel = new JLabel("Choose the difficulty level:");
        labelTicLevel.setBounds(120,70,150, 30);
        
        String[] listLevels = {"easy", "difficult"};
        
        menuLevels = new JComboBox(listLevels);
        menuLevels.setBounds(300,70,80, 30);
        menuLevels.setSelectedIndex(0);
        
        level=65;
        
        menuLevels.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  
	        	  String choice = (String) menuLevels.getSelectedItem();
	        	  
	        	  if(choice =="difficult"){
	        		  level = 85;
	        	  } 
	        	  
	        	  if(choice =="easy"){
	        		  level = 65;
	        	  }
	          }
        });  
        
    	
        buttonPlayTic4 = new JButton("Play Game!");
        buttonPlayTic4.setBounds(150,150,200,40);
        
	    buttonPlayTic4.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  
	        	  isHumanturn = false;
	        	  AIplay=true;
	        	  showInputPlayer();
	        	  decidePlayerStart();
	        	  startTicAI();
	        	  panelTicLevel.setVisible(false);
	        	  panelPlayTic.setVisible(true);
	        	  saveAction.setEnabled(true);
	          }
	          });
       
        panelTicLevel.add(labelTicLevel);
        panelTicLevel.add(menuLevels);
        panelTicLevel.add(buttonPlayTic4);
        
        panelTicLevel.setVisible(false);
	}
	
	public static void setupPlayTicGUI(){
		
		//forms tic tac toe matrix of length 3
		gridTic = new int[length][length];
		
	    //components of the panel panel
	    panelPlayTic = new JPanel();
	    panelPlayTic.setSize(500,320);
	    panelPlayTic.setLayout(null);
	    
	    //player X details
	    labelTicX = new JLabel("");
	    labelTicX.setBounds(5,60,60,40);
	    
	    labelX = new JLabel("X");
	    labelX.setBounds(20,25,40,40);
	    labelX.setFont(new Font ("Arial", Font.PLAIN, 24));
	   
	    labelXturn = new JLabel("");
	    labelXturn.setBounds(5,85,60,40);
	    labelXturn.setForeground(Color.BLUE);
	    
	    labelXvictory = new JLabel("");
	    labelXvictory.setBounds(5,0,50, 40);
	    
	    //player O details
	    labelTicO = new JLabel("");
	    labelTicO.setBounds(425,60,60,40);
	    
	    labelO = new JLabel("O");
	    labelO.setBounds(440,25,40,40);
	    labelO.setFont(new Font ("Arial", Font.PLAIN, 24));

	    labelOturn = new JLabel("");
	    labelOturn.setBounds(425,85,60,40);
	    labelOturn.setForeground(Color.BLUE);
	    
	    labelOvictory = new JLabel("");
	    labelOvictory.setBounds(430,0,50, 40);
	    
	    labelResultsTic = new JLabel("");
	    labelResultsTic.setBounds(165, 200, 200, 40);
	    
	    //Tic Tac Toe grid of buttons
	    //top left
	    buttonTic00 = new JButton("");
	    buttonTic00.setBounds(170,70,50,40);
	    buttonTic00.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
	    
	    buttonTic00.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        		  playButtons(buttonTic00, 0, 0);
	        	  }
	          }
	          });
	    
	    //top centre
	    buttonTic01 = new JButton("");
	    buttonTic01.setBounds(220,70,50,40);
	    buttonTic01.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
	    
	    buttonTic01.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        		  playButtons(buttonTic01, 0, 1);
	        	  }
	          }
	          });
	    
	    //top right
	    buttonTic02 = new JButton("");
	    buttonTic02.setBounds(270,70,50,40);
	    buttonTic02.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));
	    
	    buttonTic02.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic02, 0, 2);
	        	  }
	        	  }
	          });
	    
	    //centre left
	    buttonTic10 = new JButton("");
	    buttonTic10.setBounds(170,110,50,40);
	    buttonTic10.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
	    
	    buttonTic10.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic10, 1, 0);
	        	  }
	        	  }
	          });
	    
	    //centre centre
	    buttonTic11 = new JButton("");
	    buttonTic11.setBounds(220,110,50,40);
	    buttonTic11.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    
	    buttonTic11.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic11, 1, 1);
	        	  }
	        	  }
	          });
	    
	    //centre right
	    buttonTic12 = new JButton("");
	    buttonTic12.setBounds(270,110,50,40);
	    buttonTic12.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
	    
	    buttonTic12.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic12, 1, 2);
	        	  }
	        	  }
	          });
	    
	    //bottom left
	    buttonTic20 = new JButton("");
	    buttonTic20.setBounds(170,150,50,40);
	    buttonTic20.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
	    
	    buttonTic20.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic20, 2, 0);
	        	  }
	        	  }
	          });
	    
	    //bottom centre
	    buttonTic21 = new JButton("");
	    buttonTic21.setBounds(220,150,50,40);
	    buttonTic21.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
	    
	    buttonTic21.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic21, 2, 1);
	        	  }
	        	  }
	          });
	    
	    //bottom right
	    buttonTic22 = new JButton("");
	    buttonTic22.setBounds(270,150,50,40);
	    buttonTic22.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
	    
	    buttonTic22.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  if(isHumanturn){
	        	  	playButtons(buttonTic22, 2, 2);
	        	  }
	        	  }
	          });
	    
	    JButton[] whitebuttons = {buttonTic00,buttonTic10,buttonTic20,
	    	buttonTic01,buttonTic11,buttonTic21,
	    	buttonTic02,buttonTic12,buttonTic22};
	    
	    
	    for(JButton wbutt : whitebuttons){
	    	wbutt.setBackground(Color.white);
	    }
	    
	    buttonHome4 = new JButton("Home");
	    buttonHome4.setBounds(2,220,100,40);
	    
	    buttonHome4.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  panelPlayTic.setVisible(false);
	        	  saveAction.setEnabled(false);
	        	  panelMain.setVisible(true);
	        	  resetTicTac();
	          }
	          });
	    
	    buttonPlayTic2 = new JButton("Play again");
	    buttonPlayTic2.setBounds(383,220,100,40);
	    
	    buttonPlayTic2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e){
	        	  resetTicTac();
	        	  decidePlayerStart();
	        	  
	        	  if(AIplay){
		        	  isHumanturn = false;
		        	  startTicAI();
	        	  }
	          }
	          }); 
	    
	    //add components to play panel
	    panelPlayTic.add(labelTicX);
	    panelPlayTic.add(labelX);
	    panelPlayTic.add(labelXturn);
	    panelPlayTic.add(labelXvictory);
	    panelPlayTic.add(labelTicO);
	    panelPlayTic.add(labelO);
	    panelPlayTic.add(labelOturn);
	    panelPlayTic.add(labelOvictory);
	    panelPlayTic.add(labelResultsTic);
	    panelPlayTic.add(buttonHome4);
	    panelPlayTic.add(buttonPlayTic2);
	    panelPlayTic.add(buttonTic00);
	    panelPlayTic.add(buttonTic10);
	    panelPlayTic.add(buttonTic20);
	    panelPlayTic.add(buttonTic01);
	    panelPlayTic.add(buttonTic11);
	    panelPlayTic.add(buttonTic21);
	    panelPlayTic.add(buttonTic02);
	    panelPlayTic.add(buttonTic12);
	    panelPlayTic.add(buttonTic22);
	    
	    panelPlayTic.setVisible(false);
		
	}
	
	public static void playButtons(JButton button, int grid1, int grid2){
		
		//if game has not yet been won
		if(labelResultsTic.getText().isEmpty()){
		
			//count how many times buttons are pressed
			countbutton++;
			
		  	  //first time button is pressed
		  	 if(button.getText().isEmpty()){
		  		  
		  		//it's player 1's turn
		      	if(player1){
		      	  button.setText("X");
		      	  gridTic[grid1][grid2]= 1;
		      		  
		      		//swap turns to other player
		      		player1=false;
		      		labelOturn.setText("your turn");
		      		labelXturn.setText("");
		      	  }
		      	  else{//player 2's turn
		      		button.setText("O");
		      		gridTic[grid1][grid2]= 100;
		      		player1=true;
		      		labelXturn.setText("your turn");
		      		labelOturn.setText("");
		      	  }
		      	  
		      	checkWin();
		      	
		      	if(AIplay){
		      		isHumanturn = false;
		      		
		      		if (countbutton==1){
		      			startTicAI();
		      		}else{
		      			playTicAI();
		      		}
		      	}
	  	  }
		}
    }
	
	public static void checkWin(){
		
    	  //check if player has won
    	  if (Utilities.isWinRowColumn(gridTic, length) || Utilities.isWinDiagonal(gridTic, length)){
    		
		      labelXturn.setText("");
	      	  labelOturn.setText("");
	      		  
	      	  if(player1){
	    			labelResultsTic.setText("Well done " + p2.getName() + ". You won!");
	    			labelOvictory.setText("won: " + p2.increaseScore());
	    			
	    	  }
	    	  else{
	    			labelResultsTic.setText("Well done " + p1.getName() + ". You won!");
	    			labelXvictory.setText("won: " + p1.increaseScore());
	    	  }
	  	  }
    	  
    	  //if it is a draw, no more empty spaces in grid
    	  else if (countbutton>8){
    		
    		  ArrayList<Integer> Spaces = Utilities.findEmptySpaces(3,gridTic);
    		  
    		 if(Spaces.isEmpty()){ 
    			 
    			labelXturn.setText("");
    		    labelOturn.setText("");
    		      	  
    	    	labelResultsTic.setText("It's a draw! Want to Play again?");
    	    } 
    			 
    	  }
	}
	
	public static void startTicAI(){
		
		ArrayList<Integer> choices;
		
		if(labelOturn.getText()=="you start"|| countbutton==1){
			
			countbutton++;
			
			int[] position = new int[2];

			JButton[][] buttonGrid= {{buttonTic00,buttonTic01,buttonTic02},
					{buttonTic10,buttonTic11,buttonTic12},
					{buttonTic20,buttonTic21,buttonTic22},};
			
			int[] randomLevel= Utilities.generateRandomNumb(1,95);
			
			//is player level high enough to go for good choices
			if(level > randomLevel[0]){
				
				choices=Utilities.findEmptyCorners(gridTic);
				
				position= chooseGridPosition(choices);
				
			}
			else{
				
				choices= Utilities.findEmptySpaces(3, gridTic);
				
				position= chooseGridPosition(choices);
				
			}
			
			try {
				Thread.sleep(10*randomLevel[0]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gridTic[position[0]][position[1]] = 100;
			buttonGrid[position[0]][position[1]].setText("O");
			
			labelXturn.setText("your turn");
	      	labelOturn.setText("");
		}
		
		isHumanturn = true;
		player1 = true;
	}
	
	public static void playTicAI(){
		
		ArrayList<Integer> choices;
		
		countbutton++;
		
		int[] position = new int[2];
		
		JButton[][] buttonGrid= {{buttonTic00,buttonTic01,buttonTic02},
								{buttonTic10,buttonTic11,buttonTic12},
								{buttonTic20,buttonTic21,buttonTic22},};

		
		//if game has not yet been won
		if(labelResultsTic.getText().isEmpty()){
			
			position = Utilities.defenseStrategy(3,gridTic);
			
			int[] randomLevel= Utilities.generateRandomNumb(1,100);
			
			//array list
			if(position[0] == -1){
				
				int[] randomLevel2= Utilities.generateRandomNumb(1,85);
				
				if(level > randomLevel[0] && countbutton<5){
					
					choices=Utilities.findEmptyCorners(gridTic);
						
					position= chooseGridPosition(choices);
				
				}
			
				else if(level > randomLevel2[0]){
					
					choices =Utilities.basicStrategy(3,gridTic);
					
					position= chooseGridPosition(choices);
					
				}
				
				else{
						
					choices= Utilities.findEmptySpaces(3, gridTic);
					
					position= chooseGridPosition(choices);
					
					}
				}
				
				
			try {
				Thread.sleep(10*randomLevel[0]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gridTic[position[0]][position[1]] = 100;
			buttonGrid[position[0]][position[1]].setText("O");	
			

			labelXturn.setText("your turn");
      		labelOturn.setText("");
			
			isHumanturn = true;
			player1=true;
			
				
			checkWin();
			
			}
				
		
	}
	
	public static int[] chooseGridPosition(ArrayList<Integer> choices){
		
		//randomly choose one of the positions from the array list
		
		int[] position = new int[2];
		
		int choiceSize = choices.size()/2;
		
		int[] randomChoice= Utilities.generateRandomNumb(1,choiceSize);
		
		int finalchoice = (randomChoice[0] -1)*2;
		
		position[0]= choices.get(finalchoice);
		position[1]= choices.get(finalchoice+1);
		
		return position;
		
	}
	
	public static void resetTicTac(){
		
		//reset count of times buttons are clicked
		countbutton=0;
		
		//clear whose turn it is
		labelXturn.setText("");
      	labelOturn.setText("");
		
		//clear results message
	    labelResultsTic.setText("");
	    
	    JButton[] buttons = {buttonTic00,buttonTic10,buttonTic20,
		    	buttonTic01,buttonTic11,buttonTic21,
		    	buttonTic02,buttonTic12,buttonTic22};
	    
	    //clear text in buttons   
	    for(int i=0; i<9; i++){
	    	buttons[i].setText("");
	    }

	    //empty matrix for tic tac
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				//sum all the matrix elements in a column
				gridTic[i][j]= 0;
			}
		}
	}
	
	}


