package management;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager{

	protected String pathDriver = FileSystems.getDefault().getPath("").toString() + "drivers\\";
	protected String chromeDriver = pathDriver + "chromedriver.exe";

	private ChromeDriverService chService;


	public void startService() {
		if(null == chService){
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File(chromeDriver))
						.usingAnyFreePort()
						.build();

				chService.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	public void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService, capabilities);
	}
}