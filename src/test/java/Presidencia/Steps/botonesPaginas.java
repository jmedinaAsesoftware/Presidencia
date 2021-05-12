package Presidencia.Steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class botonesPaginas {

	private WebDriver driver;
	private preguntas questions = new preguntas(driver);

	@FindBy(how = How.CSS, using = "div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-3 > div > svg")
	private WebElement BtnPrepararPeriodo;

	@FindBy(how = How.CSS, using = "div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-5 > div > svg")
	private WebElement BtnGestionCumplimiento;

	@FindBy(how = How.XPATH, using = "//button[@class = 'MuiButtonBase-root MuiButton-root MuiButton-text button-more-file']")
	private WebElement BtnVerArchivos;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Salir')]")
	private WebElement BtnSalir;

	@FindBy(how = How.CSS, using = "label > span.MuiButton-label > svg")
	private WebElement BtnAnexarDocumento;

	@FindBy(how = How.CSS, using = "div:nth-child(2) > div > button")
	private WebElement BtnGuardar;

	@FindBy(how = How.XPATH, using = "//div//button[contains(text(),'Guardar')]")
	private WebElement btnPrincipalGuardar;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Si')]")
	private WebElement BtnSi;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continuar')]")
	private WebElement BtnContinuar;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//button[contains(text(),'Continuar')]")
	private WebElement btnDiagContinuar;

	@FindBy(how = How.XPATH, using = "//div[@class = 'contenedor']//label[contains(text(), 'Agregar tipo de riesgo +')]")
	private WebElement btnAgregarRiesgo;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//div//button[contains(text(),'Guardar')]")
	private WebElement btnDiagGuardar;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//div//button[contains(text(),'Cerrar')]")
	private WebElement btnDiagCerrar;

	@FindBy(how = How.XPATH, using = "//table//tbody//tr//*[contains(text(),'Automatizacion')]")
	private WebElement btnPrueba;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//button[@class='botonPrincipalBlanco']")
	private WebElement btnNo;

	@FindBy(how = How.XPATH, using = "//div[@role= 'dialog']//button[@class='botonPrincipalAzul']")
	private WebElement btnSi;

	@FindBy(how = How.XPATH, using = "//table//tbody//tr//*[@class = 'border']")
	private WebElement btnEditarRiesgo;

	public botonesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new preguntas(driver);
	}

	public void BtnPrepararPeriodo() {
		BtnPrepararPeriodo.click();
		questions.impliciWait();
		questions.tiempoSegundos(1);
	}

	public void BtnGestionCumplimiento() {
		BtnGestionCumplimiento.click();
		questions.impliciWait();
		questions.tiempoSegundos(1);
	}

	public void BtnVerArchivos() {
		BtnVerArchivos.click();
		questions.impliciWait();
		questions.tiempoSegundos(1);
	}

	public void BtnSalir() {
		BtnSalir.click();
		questions.tiempoSegundos(1);
	}

	public void BtnAnexarDocumento() {
		BtnAnexarDocumento.click();
		questions.tiempoSegundos(1);

	}

	public void CargarArchivo() throws AWTException {

		File file = new File("C:\\Users\\jmedina\\Documents\\Captura\\RAC-26 Automatizacion Sinap.doc");
		String path = file.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(path);
		questions.tiempoSegundos(1);

	}

	public void BtnGuardar() {
		BtnGuardar.click();
		questions.impliciWait();

	}

	public void BtnSi() {
		BtnSi.click();
		questions.impliciWait();

	}

	public void BtnNo() {
		BtnSi.click();
		questions.impliciWait();

	}

	public void BtnContinuar() {
		BtnContinuar.isDisplayed();
		questions.tiempoSegundos(1);
		BtnContinuar.click();

	}

	public void btnDiagContinuar() {
		btnDiagContinuar.click();
		questions.impliciWait();

	}

	public void btnAgregarRiesgo() {
		btnAgregarRiesgo.click();
		questions.impliciWait();

	}

	public void btnDiagGuardar() {
		btnDiagGuardar.click();
		questions.tiempoSegundos(1);

	}

	public void btnDiagCerrar() {
		btnDiagCerrar.click();
		questions.impliciWait();

	}

	public void btnEditarRiesgo(String nombreBuscar) {

		driver.findElement(By.xpath("//td/label[contains(text(),'" + nombreBuscar + "')]/../../td[5]")).click();

	}

	public void btnEliminarRiesgo(String nombreBuscar) {

		driver.findElement(By.xpath("//td/label[contains(text(),'" + nombreBuscar + "')]/../../td[4]")).click();

	}

	public void btnPrincipalGuardar() {
		questions.tiempoSegundos(1);
		btnPrincipalGuardar.click();
	}

}
