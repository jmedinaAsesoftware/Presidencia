package Presidencia.Paginas;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.botonesPaginas;
import Presidencia.Steps.preguntas;
import net.thucydides.core.annotations.Step;

public class periodoCumplimientoPagina {

	private WebDriver driver;
	private botonesPaginas botonesPaginas;
	private preguntas questions;

	@FindBy(how = How.XPATH, using = "//input[@name = 'fechaInicio']")
	private WebElement TextoFechaInicio;

	@FindBy(how = How.XPATH, using = "//input[@name = 'fechaFin']")
	private WebElement TextoFechaFin;

	@FindBy(how = How.XPATH, using = "//button[@class = 'botonPrincipalAzul']")
	private WebElement RegistrosAnexos;

	@FindBy(how = How.XPATH, using = "//div[@class ='MuiAlert-message']")
	private WebElement AlertaLimites;

	public periodoCumplimientoPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new botonesPaginas(driver);
		this.questions = new preguntas(driver);
	}

	@Step
	public void informacioGeneral(String FechaInicio, String FechaFin) {

		botonesPaginas.BtnPrepararPeriodo();
		botonesPaginas.BtnGestionCumplimiento();
		questions.tiempoSegundos(1);
		TextoFechaInicio.sendKeys(FechaInicio);
		questions.impliciWait();
		TextoFechaFin.sendKeys(FechaFin);
		questions.screenShot();
	}


	@Step
	public void ValidarArchivosCargados() throws AWTException {

		botonesPaginas.BtnVerArchivos();
			
		if (RegistrosAnexos != null) {
			List<WebElement> RegistrosAnexosQ = driver.findElements(By.xpath("//button[contains(text(),'Eliminar')]"));
			System.out.println(RegistrosAnexosQ.size());
			questions.screenShot();
			questions.impliciWait();
			botonesPaginas.BtnSalir();
		}

		botonesPaginas.BtnAnexarDocumento();
		botonesPaginas.CargarArchivo();
		questions.tiempoSegundos(1);
		questions.screenShot();
		questions.esperarElemento();
		
		boolean mensaje = AlertaLimites.isDisplayed();
		questions.esperarElemento();
		String mensaje1 = AlertaLimites.getText();
		System.out.print(mensaje);
		if(mensaje1.contains("Éxito")) {
			
			questions.screenShot();
			questions.impliciWait();
			botonesPaginas.BtnVerArchivos();
			questions.screenShot();
			questions.impliciWait();
			botonesPaginas.BtnSalir();
		}
		if(mensaje1.contains("Alerta")) {
			
			questions.screenShot();
			questions.AsserCargaArchivoMaximo();
			questions.impliciWait();
			
		}
		questions.impliciWait();
		botonesPaginas.BtnGuardar();
		questions.tiempoSegundos(1);
		questions.screenShot();
		questions.AsserGuardarCumpliento();
		questions.impliciWait();
		botonesPaginas.BtnSi();
		questions.impliciWait();
		questions.screenShot();
	}
}
