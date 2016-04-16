package Q2;

public class LotteryCalculator {
	long a;
	long b;
	long k;
	// next binary number
	final static long MAX = 2 ^ 30;
	long nbn;

	public LotteryCalculator(long a, long b, long k) {
		this.a = a;
		this.b = b;
		this.k = k;
	}

	public String calculate() {
		if (a > b) {
			long t = a;
			a = b;
			b = t;
		}
		if (a <= k)
			return Long.toString(a * b);

		long count = k * b;

		for (long i = k; i < a; i++) {
			long longerval = getBinaryinterval(i);
			count += b / nbn * longerval;

			long extra = b % nbn;
			if (extra < k)
				count += extra;
			else
				count += k;
		}
		return Long.toString(count);
	}

	private long findNextBinaryNumberWith1Bit(long longerval) {
		for (long i = 0; i < 32; i++) {
			double pow = Math.pow(2, i);
			if (longerval < pow)
				return (long) pow;
		}
		return -1;
	}

	private long getBinaryinterval(long currentIndex) {
		nbn = b;
		long i = 0;
		long count = 0;
		while (i < nbn) {
			if ((i & currentIndex) < k)
				count++;
			else if(nbn == MAX){
				nbn = findNextBinaryNumberWith1Bit(count);
			}
			i++;
		}
		return count;

	}

}
