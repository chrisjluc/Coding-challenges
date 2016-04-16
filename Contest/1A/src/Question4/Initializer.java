package Question4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Initializer {

	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(Initializer.class.getResourceAsStream("D-small-practice.in"));
		} catch (Exception e1) {
		}
		int cases = Integer.parseInt(input.nextLine());
		int count = 0;
		PrintWriter out = null;
		try {
		    out = new PrintWriter(new BufferedWriter(new FileWriter("output3", true)));
		}catch(Exception e){
			
		}

		while (input.hasNext()) {
			count++;
			int n = Integer.parseInt(input.nextLine());
			String[] s = input.nextLine().split("\\s+");
			String[] s1 = input.nextLine().split("\\s+");
			ArrayList<Double> d = new ArrayList<Double>();
			ArrayList<Double> d1 = new ArrayList<Double>();
			ArrayList<Double> d2 = new ArrayList<Double>();
			ArrayList<Double> d3 = new ArrayList<Double>();
			for(int i = 0; i < s.length;i++){
				d.add(Double.parseDouble(s[i]));
				d2.add(Double.parseDouble(s[i]));
			}
			for(int i = 0; i < s1.length;i++){
				d1.add(Double.parseDouble(s1[i]));
				d3.add(Double.parseDouble(s1[i]));
			}
			Collections.sort(d, new Comparator<Double>() {
				@Override
				public int compare(Double c1, Double c2) {
					return Double.compare(c1, c2);
				}
			});
			Collections.sort(d1, new Comparator<Double>() {
				@Override
				public int compare(Double c1, Double c2) {
					return Double.compare(c1, c2);
				}
			});
			Collections.sort(d2, new Comparator<Double>() {
				@Override
				public int compare(Double c1, Double c2) {
					return Double.compare(c1, c2);
				}
			});
			Collections.sort(d3, new Comparator<Double>() {
				@Override
				public int compare(Double c1, Double c2) {
					return Double.compare(c1, c2);
				}
			});
			
			War w = new War(n, d, d1);
			int warPoints = w.playWar();
			w.naomiWeights = d2;
			w.kenWeights = d3;
			int dWarPoints = w.playDWar();
			
			String a = "Case #" + count + ": "+dWarPoints+ " "+warPoints;
			out.println(a);
			System.out.println(a);
		}
		out.close();
	}
}
