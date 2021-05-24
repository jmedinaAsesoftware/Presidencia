package Presidencia.Paginas;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Presidencia.Steps.BotonesPaginas;
import Presidencia.Steps.ElementosPaginas;
import Presidencia.Steps.ListasDesplegablesPaginas;
import Presidencia.Steps.Preguntas;

import net.thucydides.core.annotations.Step;

public class AspiracionesPaginas {

	private WebDriver driver;
	private EvaluacionRiesgoPagina evaluacionRiesgoPagina;
	private BotonesPaginas botonesPaginas;
	private Preguntas preguntas;
	private ElementosPaginas elementosPaginas;
	private ListasDesplegablesPaginas listasDesplegablesPaginas;

	@FindBy(how = How.XPATH, using = "//textarea[@name = 'nombre']")
	private WebElement textoNombre;

	@FindBy(how = How.XPATH, using = "//textarea[@name = 'descripcion']")
	private WebElement textoDescripcion;

	@FindBy(how = How.XPATH, using = "//textarea[@name = 'origen']")
	private WebElement textoOrigen;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//h2[@class = 'MuiTypography-root MuiTypography-h6']")
	private WebElement assertConfirmacionEliminar;

	public AspiracionesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.botonesPaginas = new BotonesPaginas(driver);
		this.preguntas = new Preguntas(driver);
		this.elementosPaginas = new ElementosPaginas(driver);
		this.listasDesplegablesPaginas = new ListasDesplegablesPaginas(driver);
	}

	@Step
	public void llegarRegistroAspiracionM() {

		evaluacionRiesgoPagina.llegarEvaluacionM();
		preguntas.impliciWait();
		preguntas.screenShot();
		botonesPaginas.BtnContinuar();
		preguntas.impliciWait();
		preguntas.screenShot();
		botonesPaginas.btnDiagContinuar();
		preguntas.impliciWait();

	}

	@Step
	public void cargarArchivoMasivoM() throws AWTException {
		preguntas.impliciWait();
		botonesPaginas.CargarArchivoMasivo();
		preguntas.screenShot();
		preguntas.impliciWait();
		elementosPaginas.scrollBajarDos();

	}

	@Step
	public void btnAgregarAspiracionesM() {
		preguntas.tiempoSegundos(1);
		elementosPaginas.scrollBajarDos();
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		botonesPaginas.btnAgregaMas();
	}

	@Step
	public void btnEditarAspiracionM(String nombreBuscarP) {
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		botonesPaginas.btnEditarAspiraciones(nombreBuscarP);
	}

	@Step
	public void diligenciarFormularioM(String nombreP, String descripcionP, String origenP, String sectorP) {
		preguntas.screenShot();
		textoNombre.sendKeys(nombreP);
		textoDescripcion.sendKeys(descripcionP);
		textoOrigen.sendKeys(origenP);
		listasDesplegablesPaginas.listaSectorM(sectorP);
		preguntas.impliciWait();
		preguntas.screenShot();
		preguntas.impliciWait();
		botonesPaginas.btnDiagGuardar();
		preguntas.impliciWait();
		preguntas.screenShot();
	}

	@Step
	public void limpiarCamposM() {
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		textoNombre.clear();
		textoDescripcion.clear();
		textoOrigen.clear();

	}

	@Step
	public void btnEliminarAspiracionM(String nombreBuscar) {
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		botonesPaginas.btnEliminarAspiracion(nombreBuscar);

		if (assertConfirmacionEliminar != null) {
			preguntas.screenShot();

		}
		botonesPaginas.BtnSi();
		preguntas.impliciWait();
		preguntas.screenShot();

	}

}