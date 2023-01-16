package keywordFramework.exceptions;

public class InvalidBrowserNameException extends RuntimeException{
	private String browserName = null;
	public  InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;

	}
	@Override
	public String getMessage() {
		
		return "Invalid browser name: "+browserName;
	}

}
