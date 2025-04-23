package quizGame;

public class Score {
	
	private double score;
	private double percent;
	public Score()
	{
		score = 0;
		percent = 0;
	}
	public void increaseScore()
	{
		score++;
	}
	public void calculatePercentage(int questionTotal)
	{
		percent = score / questionTotal;
	}
	public String displayFinalScore()
	{
		return "Final Score: " + percent*100 + "%";
	}
}
