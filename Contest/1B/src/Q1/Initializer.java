package Q1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Initializer {

	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(
					Initializer.class
							.getResourceAsStream("A-small-attempt3.in"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cases = Integer.parseInt(input.nextLine());
		int count = 0;
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("output",
					true)));
		} catch (Exception e) {

		}

		while (input.hasNext()) {
			count++;
			int n = Integer.parseInt(input.nextLine());
			String[] sArray = new String[n];
			for (int j = 0; j < n; j++)
				sArray[j] = (String) input.nextLine();
			BetterRepeater r = new BetterRepeater(sArray);
			String output = r.findLeastActions();
			if(output == "-1")
				output = "Fegla Won";
			String fOutput = "Case #" + count + ": "+output;
			System.out.println(fOutput);
			out.println(fOutput);
			
		}
		out.close();
	}
}
