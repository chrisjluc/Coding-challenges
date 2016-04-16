package Question2;

public class CookieCalculator {
	double F; // increase in rate from farm
	double X; // Target
	double C; // cost of farm
	double totalTime = 0;
	boolean done = false;
	double R = 2;

	public CookieCalculator(double f, double x, double c) {
		F = f;
		X = x;
		C = c;
	}

	public void calculate(){
		double time1 = X/R;
		double R1 = R + F;
		double time2 = C/R + X/R1;
		if(time1 <= time2){
			totalTime += time1;
			done = true;
		}
		else{
			totalTime += C/R;
			R = R1;
		}
			
	}
}
