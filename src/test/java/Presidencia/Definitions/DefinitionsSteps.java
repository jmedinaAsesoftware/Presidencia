package Presidencia.Definitions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import Presidencia.Paginas.PeriodoCumplimientoPage;
import Presidencia.Steps.Conexion;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private PeriodoCumplimientoPage periodoCumplimientoPage = new PeriodoCumplimientoPage(driver);
	

	@Given("^que se ingreso a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}
	
	@When("^Se consulte la fecha inicio (.*) y fecha fin (.*)$")
	public void diligenciarFormulario(String FechaInicio, String FechaFin) {
		this.periodoCumplimientoPage = new PeriodoCumplimientoPage(driver);
		this.periodoCumplimientoPage.informacioGeneral(FechaInicio, FechaFin);
	}

	@And("^se debe anexar documentos y ver archivos cargados$")
	public void validarAnexarDocumentos() throws AWTException {
		this.periodoCumplimientoPage = new PeriodoCumplimientoPage(driver);
		this.periodoCumplimientoPage.ValidarArchivosCargados();
	}
	
	@And("Se cierra el navegado")
	public void CerrarNavegador() {
		this.conexion = new Conexion();
		this.conexion.CerrarNavegador();
	}
}