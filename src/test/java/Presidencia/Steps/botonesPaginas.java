package Presidencia.Steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class botonesPaginas {

	private WebDriver driver;
	private Questions questions = new Questions(driver);

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
	
	
	public botonesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);
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

		Robot robot = new Robot();
		robot.setAutoDelay(1000);

		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\jmedina\\Documents\\Captura\\RAC-26 Automatizacion Sinap.doc");
		questions.impliciWait();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void BtnGuardar() {
		BtnGuardar.click();
		questions.impliciWait();

	}

	public void BtnSi() {
		BtnSi.click();
		questions.impliciWait();

	}

	public void BtnContinuar() {
		BtnContinuar.click();
		questions.impliciWait();
		questions.tiempoSegundos(1);

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
}
