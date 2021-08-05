package nGram;

import java.util.Arrays;

public class checkNGram {
	
	createNGram n = new createNGram();
	
	public int[][] squares = {{0, 0, 0}, 
							  {0, 0, 0}, 
							  {0, 0, 0}};
	
	public boolean checkSolution() {
		
		if (Arrays.equals(n.squares[0], squares[0]) && 
			Arrays.equals(n.squares[1], squares[1]) && 
			Arrays.equals(n.squares[2], squares[2])) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clear() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				n.squares[i][j] = (int) (Math.random() * 2);
			}
		}
		new GUI();
	}
	
}
