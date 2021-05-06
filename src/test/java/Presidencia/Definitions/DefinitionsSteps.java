package Presidencia.Definitions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import Presidencia.Paginas.periodoCumplimientoPagina;
import Presidencia.Paginas.tiposRiesgosPagina;
import Presidencia.Steps.Conexion;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private periodoCumplimientoPagina periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
	private tiposRiesgosPagina tiposRiesgosPage = new tiposRiesgosPagina(driver);
	

	@Given("^que se ingreso a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}
	
	@When("^Se consulte la fecha inicio (.*) y fecha fin (.*)$")
	public void diligenciarFormulario(String FechaInicio, String FechaFin) {
		this.periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
		this.periodoCumplimientoPage.informacioGeneral(FechaInicio, FechaFin);
	}

	@And("^se debe anexar documentos y ver archivos cargados$")
	public void validarAnexarDocumentos() throws AWTException {
		this.periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
		this.periodoCumplimientoPage.ValidarArchivosCargados();
	}
	
	@And("^Se cierra el navegador$")
	public void CerrarNavegador() {
		this.conexion = new Conexion();
		this.conexion.CerrarNavegadorWer(driver);
	}
	
	@And("^dirigirse al formulario de tipo de riesgo$")
	public void DiriigirTipoRiesgo() {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.llegarTipoRiesgo();
	}
	
	@When("^agregue un tipo de riesgo denominado (.*) y descripcion (.*)$")
	public void agregarTipoRiesgo(String denominacionP, String descripcionP) {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.diligenciarTipoRiesgo(denominacionP, descripcionP);
	}
}