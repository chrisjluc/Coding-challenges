package Question4;

import java.util.ArrayList;

public class War {
	int n;
	ArrayList<Double> naomiWeights;
	ArrayList<Double> kenWeights;

	public War(int n, ArrayList<Double> naomiWeights,
			ArrayList<Double> kenWeights) {
		super();
		this.n = n;
		this.naomiWeights = naomiWeights;
		this.kenWeights = kenWeights;
	}

	public int playDWar() {
		int points = 0;
		for (int i = 0; i < n; i++) {
			int lastIndex = kenWeights.size() - 1;
			double numNaomi = naomiWeights.get(0);
			double numKenLast = kenWeights.get(lastIndex);
			double numKenFirst = kenWeights.get(0);
			if(numNaomi > numKenFirst){
				naomiWeights.remove(0);
				kenWeights.remove(0);
				points++;
			}
			else if (numNaomi > numKenLast) {
				return points +lastIndex + 1;
			} else {
				naomiWeights.remove(0);
				kenWeights.remove(lastIndex);
			}
		}
		return points;
	}

	public int playWar() {
		int points = 0;
		for (int i = 0; i < n; i++) {
			double num = naomiWeights.get(0);
			int index = findIndexOfWeightBigEnough(num);
			if (index == 0) {
				naomiWeights.remove(0);
				kenWeights.remove(0);
			} else if (index > 0) {
				naomiWeights.remove(0);
				kenWeights.remove(index);
			} else {
				naomiWeights.remove(0);
				kenWeights.remove(0);
				points++;
			}
		}
		return points;
	}

	private int findIndexOfWeightBigEnough(Double d) {
		for (int i = 0; i < kenWeights.size(); i++) {
			if (kenWeights.get(i) > d)
				return i;
		}
		return -1;
	}

}
