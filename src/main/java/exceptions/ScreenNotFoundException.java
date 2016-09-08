package exceptions;

public class ScreenNotFoundException extends Exception
{
	private final String screenName;

	public ScreenNotFoundException(String screenName)
	{
		this.screenName = screenName;
	}

	@Override
	public String getMessage()
	{
		return "Screen {" + screenName + "} not found!";
	}
}
