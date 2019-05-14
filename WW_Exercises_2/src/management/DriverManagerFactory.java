package management;


public class DriverManagerFactory {
	
	public enum DriverType {
	    CHROME,
	    FIREFOX,
	    IE,
	    SAFARI;
	}

	public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                //driverManager = new FirefoxDriverManager();
            	driverManager = null;
                break;
            default:
                //driverManager = new SafariDriverManager();
            	driverManager = null;
                break;
        }
        return driverManager;

    }
}