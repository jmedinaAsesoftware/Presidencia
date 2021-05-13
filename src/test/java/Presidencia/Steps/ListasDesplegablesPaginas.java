package Presidencia.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class ListasDesplegablesPaginas {

	private WebDriver driver;
private Preguntas preguntas;
	@FindBy(how = How.XPATH, using = "//*[@id='demo-simple-select-filled']")
	private WebElement listaSector;

	public ListasDesplegablesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
this.preguntas = new Preguntas(driver);
	}
	
	@Step
	public void listaSectorM(String sectorP) {
		preguntas.tiempoSegundos(1);
		listaSector.click();
		WebElement seleccionar = driver.findElement(By.xpath("//ul/li/em[contains(text(), '"+ sectorP +"')]"));
		preguntas.impliciWait();
		seleccionar.click();
		preguntas.impliciWait();
	}

}
