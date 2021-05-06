package Presidencia.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.botonesPaginas;
import Presidencia.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class tiposRiesgosPagina {

	private WebDriver driver;
	private botonesPaginas botonesPaginas;
	private Questions questions;

	@FindBy(how = How.XPATH, using = "//input[@name = 'denominacion']")
	private WebElement textoDenominacion;

	@FindBy(how = How.XPATH, using = "//input[@name = 'descripcion']")
	private WebElement textoDescripcion;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//p")
	private WebElement alertaYaExiste;

	public tiposRiesgosPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new botonesPaginas(driver);
		this.questions = new Questions(driver);
	}

	@Step
	public void llegarTipoRiesgo() {

		botonesPaginas.BtnPrepararPeriodo();
		botonesPaginas.BtnGestionCumplimiento();
		botonesPaginas.BtnContinuar();
		questions.screenShot();
		questions.impliciWait();
		questions.AsserSeguroContinuar();
		questions.tiempoSegundos(1);
		botonesPaginas.btnDiagContinuar();
		botonesPaginas.BtnContinuar();
		questions.tiempoSegundos(1);
		questions.screenShot();
		questions.AsserContinuarPiramide();
		botonesPaginas.BtnSi();
	}

	@Step
	public void diligenciarTipoRiesgo(String denominacionP, String descripcionP) {
		questions.tiempoSegundos(1);
		questions.screenShot();
		botonesPaginas.btnAgregarRiesgo();
		textoDenominacion.sendKeys(denominacionP);
		textoDescripcion.sendKeys(descripcionP);
		questions.screenShot();
		questions.impliciWait();
		botonesPaginas.btnDiagGuardar();
		questions.impliciWait();
		questions.screenShot();
		if (alertaYaExiste.getText().equals("La denominación ya existe")) {

			questions.screenShot();
			botonesPaginas.btnDiagCerrar();

		}
		
	}
}
