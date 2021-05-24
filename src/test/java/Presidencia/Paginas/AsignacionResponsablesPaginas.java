package Presidencia.Paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.BotonesPaginas;
import Presidencia.Steps.Preguntas;

import net.thucydides.core.annotations.Step;

public class AsignacionResponsablesPaginas {

	private WebDriver driver;
	private BotonesPaginas botonesPaginas;
	private Preguntas preguntas;

	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Nombre']")
	private WebElement textoNombre;

	@FindBy(how = How.XPATH, using = "//input[@name = 'personas[0].rolCumplimiento']")
	private WebElement textoRolCumplimiento;

	public AsignacionResponsablesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new BotonesPaginas(driver);
		this.preguntas = new Preguntas(driver);

	}

	@Step
	public void llegarAsignarM() {
		botonesPaginas.btnMenu();
		botonesPaginas.btnAsignacionResponsable();

	}

	@Step
	public void agregarResponsableM(String buscarObjetivoP) {
		preguntas.impliciWait();
		botonesPaginas.btnAgregarResponsable(buscarObjetivoP);
		preguntas.impliciWait();

	}

	@Step
	public void consultarResponsableM(String buscarObjetivoP) {
		preguntas.impliciWait();
		botonesPaginas.btnConsuResponsable(buscarObjetivoP);
		preguntas.impliciWait();
		preguntas.screenShot();

	}

	@Step
	public void agregarLiderM(String nombreP) {
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		preguntas.tiempoSegundos(1);
		textoNombre.sendKeys(nombreP);
		preguntas.tiempoSegundos(1);
		textoNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoNombre.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();

	}

	@Step
	public void guardarM() {
		botonesPaginas.btnPrincipalGuardar();
		botonesPaginas.BtnSi();
		preguntas.tiempoSegundos(1);
		preguntas.AsserMensajeExitoso();
	}

	@Step
	public void continuarM() {
		botonesPaginas.BtnContinuar();
		botonesPaginas.btnDiagContinuar();
		preguntas.tiempoSegundos(1);
		preguntas.AsserMensajeExitoso();
	}

	@Step
	public void agregarActoresM(String nombreP, String rolCumplimientoP) {

		botonesPaginas.btnAgregarActores();
		preguntas.impliciWait();
		preguntas.screenShot();
		textoNombre.sendKeys(nombreP);
		preguntas.impliciWait();
		textoNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoNombre.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		textoRolCumplimiento.sendKeys(rolCumplimientoP);
		textoRolCumplimiento.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoRolCumplimiento.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();

	}

	@Step
	public void editarResponsableM(String buscarNombreP, String rolCumplimientoP) {
		botonesPaginas.btneditarResponsables(buscarNombreP);
		textoRolCumplimiento.clear();
		textoRolCumplimiento.sendKeys(rolCumplimientoP);
		preguntas.screenShot();

	}

	@Step
	public void eliminarResponsableM(String buscarNombreP) {
		botonesPaginas.btnEliminarResponsables(buscarNombreP);
	}
}
