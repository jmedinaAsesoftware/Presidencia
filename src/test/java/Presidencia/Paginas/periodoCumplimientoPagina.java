package Presidencia.Paginas;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.BotonesPaginas;
import Presidencia.Steps.Preguntas;
import net.thucydides.core.annotations.Step;

public class periodoCumplimientoPagina {

	private WebDriver driver;
	private BotonesPaginas botonesPaginas;
	private Preguntas questions;

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
		this.botonesPaginas = new BotonesPaginas(driver);
		this.questions = new Preguntas(driver);

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
	public void validarArchivos() throws AWTException {

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
