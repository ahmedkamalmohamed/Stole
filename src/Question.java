
public class Question {
	int ID;
	String Question;
	String Answer;
	public Question(int i,String Q,String ans) {
		ID=i;
		Question=Q;
		Answer=ans;
	}
	public Question() {
	}
	public void SetQ(int i,String q,String ans)
	{
		ID=i;
		Question=q;
		Answer=ans;
	}
	public void SetID(int i)
	{
		ID=i;
	}
	public void SetQuestion(String q)
	{
		Question =q;
	}
	public void SetAnswer(String ans)
	{
		Answer=ans;
	}
	public int getID()
	{
		return ID;
	}
	public String getQuestion()
	{
		return Question;
	}
	public String getAnswer()
	{
		return Answer;
	}
}
