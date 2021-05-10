package Presidencia.Steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class ElementosPaginas {
	
	private WebDriver driver;
	private preguntas preguntas;
	
	
	public ElementosPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.preguntas = new preguntas(driver);
	}
	
	@Step
	public void scrollBajar() {
		WebElement scroll = driver.findElement(By.xpath("//div[@class ='MuiGrid-root MuiBox-root jss56 MuiGrid-container MuiGrid-justify-xs-space-between']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(3)).build().perform();
		preguntas.impliciWait();
	}

}
