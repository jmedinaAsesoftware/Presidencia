package Presidencia.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import java.util.List;

public class Conexion {

	private WebDriver driver;

	@Before
	@Step
	public WebDriver abrirNavegador() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://fabricaeyfront.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.driver;

	}

	@Step
	public void CerrarNavegadorWer(WebDriver driver) {

		driver.close();

	}

}
