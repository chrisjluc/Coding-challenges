package Question1;
public class Magictrick {
	private int answer1;
	private int answer2;
	private int caseNumber;
	private int[][] board1;
	private int[][] board2;
	private static String BAD_MAGICIAN ="Bad magician!";
	private static String VOLUNTEER_CHEATED ="Volunteer cheated!";
	

	public Magictrick(int caseNumber, int answer1, int answer2, int[][] board1, int[][] board2) {
		this.caseNumber = caseNumber;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.board1 = board1;
		this.board2 = board2;
	}
	public String performTrick(){
		int[] selectedRowValues1 = new int[4];
		selectedRowValues1 = board1[answer1-1];
		int[] selectedRowValues2 = new int[4];
		selectedRowValues2 = board2[answer2-1];
		String output = "Case #" + caseNumber + ": ";
		String chosenCard = null;
		
		for(int i = 0; i < 4; i++){
			for( int j = 0; j < 4; j++){
				//There's a match
				if(selectedRowValues1[i] == selectedRowValues2[j]){
					if(chosenCard == null){
						chosenCard = Integer.toString(selectedRowValues1[i]);
					}else if(chosenCard.length() < 3)
						chosenCard = BAD_MAGICIAN;
				}
			}
		}
		if(chosenCard == null)
			chosenCard = VOLUNTEER_CHEATED;
		return output + chosenCard;
	}
}
