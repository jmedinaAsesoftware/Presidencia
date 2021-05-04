package Presidencia.Paginas;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.BotonesPages;
import Presidencia.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class PeriodoCumplimientoPage {

	private WebDriver driver;
	private BotonesPages botonesPage;
	private Questions questions;

	@FindBy(how = How.XPATH, using = "//input[@name = 'fechaInicio']")
	private WebElement TextoFechaInicio;

	@FindBy(how = How.XPATH, using = "//input[@name = 'fechaFin']")
	private WebElement TextoFechaFin;

	@FindBy(how = How.XPATH, using = "//button[@class = 'botonPrincipalAzul']")
	private WebElement RegistrosAnexos;

	@FindBy(how = How.XPATH, using = "//div[@class ='MuiAlert-message']")
	private WebElement AlertaLimites;

	public PeriodoCumplimientoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPage = new BotonesPages(driver);
		this.questions = new Questions(driver);
	}

	@Step
	public void informacioGeneral(String FechaInicio, String FechaFin) {

		botonesPage.BtnPrepararPeriodo();
		botonesPage.BtnGestionCumplimiento();
		questions.tiempoSegundos(1);
		TextoFechaInicio.sendKeys(FechaInicio);
		questions.impliciWait();
		TextoFechaFin.sendKeys(FechaFin);
		questions.screenShot();
	}


	@Step
	public void ValidarArchivosCargados() throws AWTException {

		botonesPage.BtnVerArchivos();
			
		if (RegistrosAnexos != null) {
			List<WebElement> RegistrosAnexosQ = driver.findElements(By.xpath("//button[contains(text(),'Eliminar')]"));
			System.out.println(RegistrosAnexosQ.size());
			questions.screenShot();
			questions.impliciWait();
			botonesPage.BtnSalir();
		}

		botonesPage.BtnAnexarDocumento();
		botonesPage.CargarArchivo();
		questions.tiempoSegundos(1);
		String mensaje = AlertaLimites.getText();
		System.out.print(mensaje);
		if(mensaje.contains("Éxito")) {
			
			questions.impliciWait();
			botonesPage.BtnVerArchivos();
			questions.screenShot();
			questions.impliciWait();
			botonesPage.BtnSalir();
		}
		if(mensaje.contains("Alerta")) {

			questions.AsserCargaArchivoMaximo();
			questions.impliciWait();
			questions.screenShot();
		}
		questions.impliciWait();
		botonesPage.BtnGuardar();
		questions.tiempoSegundos(1);
		questions.AsserGuardarCumpliento();
		questions.screenShot();
		questions.impliciWait();
		botonesPage.BtnSi();
		questions.impliciWait();
		questions.screenShot();
	}
}
