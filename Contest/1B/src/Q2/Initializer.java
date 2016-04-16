package Q2;

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
	private static String inputFile = "B-large-practice.in";

	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(
					Initializer.class.getResourceAsStream(inputFile));
		} catch (Exception e) {
			e.printStackTrace();
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
			String[] s = input.nextLine().split("\\s+");
			LotteryCalculator lc = new LotteryCalculator(
					Long.parseLong(s[0]), Long.parseLong(s[1]),
					Long.parseLong(s[2]));
			String output = lc.calculate();
			String fOutput = "Case #" + count + ": " + output;
			System.out.println(fOutput);
			out.println(fOutput);

		}
		out.close();
	}
}
