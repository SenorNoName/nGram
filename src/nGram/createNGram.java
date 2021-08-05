package nGram;

public class createNGram {
	//2d array of random ints (0-1) used for nGram solution
	public static int[][] squares = {{(int) (Math.random() * 2), (int) (Math.random() * 2), (int) (Math.random() * 2)},
							 {(int) (Math.random() * 2), (int) (Math.random() * 2), (int) (Math.random() * 2)},
							 {(int) (Math.random() * 2), (int) (Math.random() * 2), (int) (Math.random() * 2)}};
	
	//rows
	public int[] r1 = squares[0];
	public int[] r2 = squares[1];
	public int[] r3 = squares[2];
	
	//columns
	public int[] c1 = new int[3];
	public int[] c2 = new int[3];
	public int[] c3 = new int[3];
	
	//misc vars
	private String str = "";
	private String rowcol;
	private int count = 0;
	
	//
	public String getColumns(int[] c, int row) {
		for (int i = 0; i < 3; i++) {
			c[i] = squares[i][row];
		}
		
		for (int i : c) {
			str += i;
		}
		
		rowcol = str;
		str = "";
		return rowcol;
	}
	
	public String getRows(int[] c) {
		for (int i : c) {
			str += i;
		}
		
		rowcol = str;
		str = "";
		return rowcol;
	}
	
	public String getCount(String s) {
		if (s.equals("101")) {
			return "1 1";
		} else {
			char[] charArr = s.toCharArray();
			for (char c : charArr) {
				if (c == '1') {
					count++;
				}
			}
		}
		str += count;
		rowcol = str;
		str = "";
		count = 0;
		return rowcol;
	}
}
