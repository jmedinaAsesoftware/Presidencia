package Presidencia.Steps;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class ElementosPaginas {
	
	private WebDriver driver;
	private Preguntas preguntas;
	private BotonesPaginas botonesPaginas;
	
	
	@FindBy(how = How.XPATH, using = "//button[@class = 'botonPrincipalAzul']")
	private WebElement RegistrosAnexos;

	@FindBy(how = How.XPATH, using = "//div[@class ='MuiAlert-message']")
	private WebElement AlertaLimites;
	
	public ElementosPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.preguntas = new Preguntas(driver);
		this.botonesPaginas = new BotonesPaginas(driver);
	}
	
	@Step
	public void scrollBajar() {
		WebElement scroll = driver.findElement(By.xpath("//div[@class ='contenedor']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(3)).build().perform();
		preguntas.impliciWait();
	}
	
	@Step
	public void ValidarArchivosCargados() throws AWTException {
			
		botonesPaginas.BtnVerArchivos();
			
		if (RegistrosAnexos != null) {
			List<WebElement> RegistrosAnexosQ = driver.findElements(By.xpath("//button[contains(text(),'Eliminar')]"));
			System.out.println(RegistrosAnexosQ.size());
			preguntas.screenShot();
			preguntas.impliciWait();
			botonesPaginas.BtnSalir();
		}

		//botonesPaginas.BtnAnexarDocumento();
		botonesPaginas.CargarArchivo();
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		preguntas.esperarElemento();
		
		boolean mensaje = AlertaLimites.isDisplayed();
		preguntas.esperarElemento();
		String mensaje1 = AlertaLimites.getText();
		System.out.print(mensaje);
		if(mensaje1.contains("Éxito")) {
			
			preguntas.screenShot();
			preguntas.impliciWait();
			botonesPaginas.BtnVerArchivos();
			preguntas.screenShot();
			preguntas.impliciWait();
			botonesPaginas.BtnSalir();
		}
		if(mensaje1.contains("Alerta")) {
			preguntas.impliciWait();
			preguntas.screenShot();
			preguntas.AsserCargaArchivoMaximo();
			preguntas.impliciWait();
			
		}
	
	}
	
	@Step
	public void scrollBajarDos() {
		WebElement scroll = driver.findElement(By.xpath("//div[@class ='pantalla_completa']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(3)).build().perform();
		preguntas.impliciWait();
	}

}
