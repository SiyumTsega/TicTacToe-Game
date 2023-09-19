import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JTextField textField = new JTextField();
	JButton [] buttons = new JButton[10];
	boolean player1Turn = false;
	Random random = new Random();
	
	TicTacToe(){
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		buttonsPanel.setLayout(new GridLayout(3,3));
		buttonsPanel.setBackground(Color.white);
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonsPanel.add(buttons[i]);
			buttons[i].setBackground(new Color(25, 75, 25));
			buttons[i].setFont(new Font("verdana", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel);
		frame.setVisible(true);
		
		firstTurn();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1Turn = false;
						textField.setText("O's Turn");
						check();
					}
				}else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1Turn = true;
						textField.setText("X's Turn");
						check();
					}
				}
			}
		}
	}

	private void check() {
		
		//x wins
			if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X") ) {
				xWins(0,1,2);
			}
			if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X") ) {
				xWins(3,4,5);
			}
			if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X") ) {
				xWins(6,7,8);
			}
			if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X") ) {
				xWins(0,3,6);
			}
			if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X") ) {
				xWins(1,4,7);
			}
			if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X") ) {
				xWins(2,5,8);
			}
			if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X") ) {
				xWins(0,4,8);
			}
			if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X") ) {
				xWins(2,4,6);
			}
			
			///O wins
			if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O") ) {
				oWins(0,1,2);
			}
			if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O") ) {
				oWins(3,4,5);
			}
			if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O") ) {
				oWins(6,7,8);
			}
			if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O") ) {
				oWins(0,3,6);
			}
			if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O") ) {
				oWins(1,4,7);
			}
			if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O") ) {
				oWins(2,5,8);
			}
			if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O") ) {
				oWins(0,4,8);
			}
			if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O") ) {
				oWins(2,4,6);
			}
	}


	private void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("O Wins");
	}


	private void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("X Wins");		
	}


	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0) {
			player1Turn = true;
			textField.setText("X's Turn");
		}
		else {
			player1Turn = false;
			textField.setText("O's Turn");
		}
	}
	

	
}
