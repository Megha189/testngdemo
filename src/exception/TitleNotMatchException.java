package exception;

@SuppressWarnings("serial")
public class TitleNotMatchException extends RuntimeException{

	public void msg()
	{
		System.out.println("tilte is not matched...");
	}
}
