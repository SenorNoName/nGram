package nGram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {
	
	public static int correct = 0;
	
	public static int setScore() throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter("score.txt");
		writer.println(correct);
		writer.close();
		
		File text = new File("score.txt");
		Scanner scan = new Scanner(text);
		
		int lineNum = 1;
		while(scan.hasNextLine()) {
			
		}
		
	}
	
}
