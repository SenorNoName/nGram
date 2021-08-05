package nGram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractAction;

public class GUI implements ActionListener {
	
	//instances of create and check classes
	createNGram n = new createNGram();
	checkNGram c = new checkNGram();
	
	//private vars
	private boolean test;
	private int correct;
	
	//JFrame and JPanel GUI
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	//JLabels for numbers (number of 1s in rows/columns of squares[][])
	private JLabel r1 = new JLabel(n.getCount(n.getRows(n.r1)));
	private JLabel r2 = new JLabel(n.getCount(n.getRows(n.r2)));
	private JLabel r3 = new JLabel(n.getCount(n.getRows(n.r3)));
	private JLabel c1 = new JLabel(n.getCount(n.getColumns(n.c1, 0)));
	private JLabel c2 = new JLabel(n.getCount(n.getColumns(n.c2, 1)));
	private JLabel c3 = new JLabel(n.getCount(n.getColumns(n.c3, 2)));
	
	//placeholder and score JLabels
	private JLabel blank = new JLabel("");
	private JLabel score = new JLabel("Score: 0");
	
	//JButtons for nGram squares; change color (white/black) and int of squares[][] in c (0/1)
	/* [b1, b2, b3,
	 *  b4, b5, b6,
	 *  b7, b8, b9]
	 */
	private JButton b1 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b1);
			changeInt(0, 0);
		}
	});
	
	private JButton b2 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b2);
			changeInt(0, 1);
		}
	});
	
	private JButton b3 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b3);
			changeInt(0, 2);
		}
	});
	
	private JButton b4 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b4);
			changeInt(1, 0);
		}
	});
	
	private JButton b5 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b5);
			changeInt(1, 1);
		}
	});
	
	private JButton b6 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b6);
			changeInt(1, 2);
		}
	});
	
	private JButton b7 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b7);
			changeInt(2, 0);
		}
	});
	
	private JButton b8 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b8);
			changeInt(2, 1);
		}
	});
	
	private JButton b9 = new JButton(new AbstractAction("") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeColor(b9);
			changeInt(2, 2);
		}
	});
	
	//JButton to check squares[][] in c against squares[][] in n; increases score and saves if correct
	private JButton check = new JButton(new AbstractAction("Check") {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			test = c.checkSolution();
			
			if (test) {
				correct = Score.correct++;
				//score.setText("Score : " + correct);
				frame.dispose();
				c.clear();
			}
		}
	});
	
	//array of buttons
	private JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, check};
	
	//GUI constructor
	public GUI() {
		
		//border and grid
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		panel.setLayout(new GridLayout(5, 4));
		
		//set size, color, events of JButtons
		for (JButton b : buttons) {
			b.setPreferredSize(new Dimension(75, 75));
			b.setBackground(Color.WHITE);
			b.addActionListener(this);
		}
		
		//display JButtons and JLabels
		//r0
		panel.add(blank);
		panel.add(c1);
		panel.add(c2);
		panel.add(c3);
		
		//r1
		panel.add(r1);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
		//r2
		panel.add(r2);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		
		//r3
		panel.add(r3);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		
		//check button and score label
		panel.add(check);
		panel.add(score);
		
		//frame border, close, title
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("NGram");
		frame.pack();
		frame.setVisible(true);
		
	}

	//change color of button (if black -> white; if white -> black)
	public void changeColor(JButton button) {
		if (button.getBackground().equals(Color.BLACK)) {
			button.setBackground(Color.WHITE);
		} else {
			button.setBackground(Color.BLACK);
		}
	}
	
	//change int in c squares[][] (if 0 -> 1; if 1 -> 0)
	public void changeInt(int row, int col) {
		if (c.squares[row][col] == 0) {
			c.squares[row][col] = 1;
		} else if (c.squares[row][col] == 1) {
			c.squares[row][col] = 0;
		}
	}

	//extra override method
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
