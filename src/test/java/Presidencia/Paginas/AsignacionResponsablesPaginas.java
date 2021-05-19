package Presidencia.Paginas;

import org.junit.Assert;
import org.openqa.selenium.By;
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
	public void agregarLiderM(String nombreP) {

		preguntas.impliciWait();
		preguntas.screenShot();
		textoNombre.sendKeys(nombreP);
		preguntas.impliciWait();
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
}
