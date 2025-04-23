package quizGame;

public class Score {
	
	double score = 0;
	double percent = 0;
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
