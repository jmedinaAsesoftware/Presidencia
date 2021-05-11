package Presidencia.Paginas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Presidencia.Steps.botonesPaginas;
import Presidencia.Steps.preguntas;
import net.thucydides.core.annotations.Step;

public class tiposRiesgosPagina {

	private WebDriver driver;
	private botonesPaginas botonesPaginas;
	private preguntas questions;

	@FindBy(how = How.XPATH, using = "//input[@name = 'denominacion']")
	private WebElement textoDenominacion;

	@FindBy(how = How.XPATH, using = "//input[@name = 'descripcion']")
	private WebElement textoDescripcion;
	
	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//p[@class = 'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled MuiFormHelperText-marginDense']")
	private WebElement assertYaExiste;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//h2[@class = 'MuiTypography-root MuiTypography-h6']")
	private WebElement assertConfirmacionEliminar;
	
	public tiposRiesgosPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new botonesPaginas(driver);
		this.questions = new preguntas(driver);
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
	public void btnAgregarRiesgoM() {
		questions.tiempoSegundos(1);
		questions.screenShot();
		botonesPaginas.btnAgregarRiesgo();
	}
	
	@Step
	public void btnEditarRiesgoM(String nombreBuscar) {
		questions.tiempoSegundos(1);
		questions.screenShot();
		botonesPaginas.btnEditarRiesgo(nombreBuscar);
	}
	
	@Step
	public void diligenciarTipoRiesgo(String denominacionP, String descripcionP) {
		
		textoDenominacion.clear();
		textoDenominacion.sendKeys(denominacionP);
		textoDescripcion.clear();
		textoDescripcion.sendKeys(descripcionP);
		questions.screenShot();
		questions.impliciWait();
		botonesPaginas.btnDiagGuardar();
		
		if (assertYaExiste != null) {

			questions.screenShot();

		}

		questions.impliciWait();
		questions.screenShot();
	}
	
	@Step
	public void btnEliminarRiesgoM(String nombreBuscar) {
		questions.tiempoSegundos(1);
		questions.screenShot();
		botonesPaginas.btnEliminarRiesgo(nombreBuscar);
		
		if(assertConfirmacionEliminar != null) {
			questions.screenShot();
			
		}
		botonesPaginas.BtnSi();
		questions.impliciWait();
		questions.screenShot();		
	}
}
