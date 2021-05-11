package Presidencia.Definitions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import Presidencia.Paginas.EvaluacionRiesgoPagina;
import Presidencia.Paginas.periodoCumplimientoPagina;
import Presidencia.Paginas.tiposRiesgosPagina;
import Presidencia.Steps.Conexion;
import Presidencia.Steps.ElementosPaginas;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private periodoCumplimientoPagina periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
	private tiposRiesgosPagina tiposRiesgosPage = new tiposRiesgosPagina(driver);
	private EvaluacionRiesgoPagina evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
	private ElementosPaginas elementosPaginas = new ElementosPaginas(driver);

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

	@Then("^al hacer clic en guardar se debe almacenar la informacion$")
	public void validarGuardado() throws AWTException {
		this.periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
		this.periodoCumplimientoPage.validarArchivos();
	}

	@And("^se debe anexar documentos y ver archivos cargados$")
	public void validarAnexarDocumentos() throws AWTException {
		this.elementosPaginas = new ElementosPaginas(driver);
		this.elementosPaginas.ValidarArchivosCargados();
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
		this.tiposRiesgosPage.btnAgregarRiesgoM();
		this.tiposRiesgosPage.diligenciarTipoRiesgoM(denominacionP, descripcionP);
	}

	@When("^Editar un tipo de riesgo  nombre a buscar (.*) denominado (.*) y descripcion (.*)$")
	public void editarTipoRiesgo(String nombreBuscar, String denominacionP, String descripcionP) {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.btnEditarRiesgoM(nombreBuscar);
		this.tiposRiesgosPage.diligenciarTipoRiesgoM(denominacionP, descripcionP);
	}

	@And("^dirigirse al formulario de evaluacion riesgo$")
	public void DiriigirEvaluacionRiesgo() {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.llegarEvaluacionM();
	}

	@When("^diligencie el campo nivel 1 (.*) descripcion (.*) campo nivel 2 (.*) descripcion (.*)$")
	public void diligenciarEvaluacionRiesgo(String nivel1P, String descripNivel1P, String nivel2P,
			String descripNivel2P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.limpiarCampoImpacto();
		this.evaluacionRiesgoPagina.diligenciarNivelesImpactoM(nivel1P, descripNivel1P, nivel2P, descripNivel2P);

	}

	@And("^diligenciar campo nivel 3 (.*) descripcion (.*) campo nivel 4 (.*) descripcion (.*) campo nivel 5 (.*) descripcion (.*)$")
	public void segundoDiligenciarEvaluacionRiesgo(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.segundoDiligenciarNivelesImpactoM(nivel3P, descripNivel3P, nivel4P, descripNivel4P,
				nivel5P, descripNivel5P);
		this.evaluacionRiesgoPagina.guardarM();

	}

	@When("^limpie los campos de probabilidad de ocurrencia$")
	public void limpiarCamposOcurrencia() {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.limpiarCamposProbabilidad();
	}

	@Then("^debe diligenciar el campo nivel 1 (.*) descripcion (.*) campo nivel 2 (.*) descripcion (.*)$")
	public void diligenciarProbabilidad(String nivel1P, String descripNivel1P, String nivel2P, String descripNivel2P) {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.diligenciarProbabilidadM(nivel1P, descripNivel1P, nivel2P, descripNivel2P);

	}

	@And("^diligenciar los campo nivel 3 (.*) descripcion (.*) campo nivel 4 (.*) descripcion (.*) campo nivel 5 (.*) descripcion (.*)$")
	public void segundoDiligenciarProbabilidad(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.segundoDiligenciarProbabilidadM(nivel3P, descripNivel3P, nivel4P, descripNivel4P,
				nivel5P, descripNivel5P);
		this.evaluacionRiesgoPagina.guardarM();
	}
}