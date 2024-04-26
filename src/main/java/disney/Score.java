package disney;

public class Score {
	public static String mbti = "";
	public static int[] steps = new int[6];
	public static int currentStep = 0;
		
	public static void setScore(int step, int value) {
		steps[step] = value;
		currentStep = step;
	}
	
	public static int getScore() {
		int sum = 0;
		for(int step: steps) {
			sum += step;
		}
		return sum;
	}
	
	public static void reset() {
		steps = new int[6];
		currentStep = 0;
	}
	
	public void setMBTI(String str) {
		mbti += str;
	}
	
	public String getMBTI() {
		if (getScore() >= 3) {
			return "I";
		} else {
			return "E";
		}
	}
	
}