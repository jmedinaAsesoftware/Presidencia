package Presidencia.Steps;

import java.awt.AWTException;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BotonesPaginas {

	private WebDriver driver;
	private Preguntas questions = new Preguntas(driver);

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

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sí')]")
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

	@FindBy(how = How.XPATH, using = "//div[@class = 'contenedor']//label[contains(text(), 'Agregar')]")
	private WebElement btnAgregaMas;

	@FindBy(how = How.XPATH, using = "//button[@aria-label = 'menu']")
	private WebElement btnMenu;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Asignación responsables')]")
	private WebElement btnAsignacionResponsable;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Agregar actores')]")
	private WebElement btnAgregarActores;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'Agregar líder')]")
	private WebElement btnAgregarLider;
	
	public BotonesPaginas(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Preguntas(driver);
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
		System.out.println(file);

	}

	public void BtnGuardar() {
		BtnGuardar.click();
		questions.impliciWait();

	}

	public void BtnSi() {
	
		questions.impliciWait();
		BtnSi.isDisplayed();
		BtnSi.click();
		questions.tiempoSegundos(1);
		questions.screenShot();
		

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
		btnPrincipalGuardar.isDisplayed();
		questions.impliciWait();
		questions.screenShot();
	}

	public void CargarArchivoMasivo() throws AWTException {

		File file = new File(
				"C:\\Users\\jmedina\\Documents\\Captura\\DocumentoReferenciaCargueAspiracionesFormato.xlsx");
		String path = file.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(path);
		questions.tiempoSegundos(1);

	}

	public void btnAgregaMas() {
		btnAgregaMas.click();
		questions.impliciWait();

	}

	public void btnEditarAspiraciones(String nombreBuscarP) {

		driver.findElement(By.xpath("//td/label[contains(text(),'" + nombreBuscarP + "')]/../../td[7]")).click();

	}

	public void btnEliminarAspiracion(String nombreBuscar) {

		driver.findElement(By.xpath("//td/label[contains(text(),'" + nombreBuscar + "')]/../../td[6]")).click();

	}

	public void btnMenu() {
		questions.impliciWait();
		btnMenu.isDisplayed();
		btnMenu.click();
	}

	public void btnAsignacionResponsable() {
		questions.impliciWait();
		btnAsignacionResponsable.isDisplayed();
		questions.screenShot();
		btnAsignacionResponsable.click();
		questions.tiempoSegundos(1);
	}

	public void btnAgregarResponsable(String buscarObjetivoP) {

		WebElement objetivo = driver
				.findElement(By.xpath("//td[contains(text(),'" + buscarObjetivoP + "')]/../td[5]/div/div[3]"));
		questions.tiempoSegundos(1);
		Actions scrolldown = new Actions(driver);
		scrolldown.moveToElement(objetivo).build().perform();
		questions.screenShot();
		questions.impliciWait();
		objetivo.click();
		questions.screenShot();

	}

	public void btnAgregarActores() {
		questions.impliciWait();
		btnAgregarActores.isDisplayed();
		questions.screenShot();
		btnAgregarActores.click();
	}
	
	public void btnAgregarLider() {
		questions.impliciWait();
		btnAgregarLider.isDisplayed();
		questions.screenShot();
		btnAgregarLider.click();
	}
	
	public void btnConsuResponsable(String buscarObjetivoP) {

		WebElement objetivo = driver
				.findElement(By.xpath("//td[contains(text(),'" + buscarObjetivoP + "')]/../td[5]/div/div[2]"));
		questions.tiempoSegundos(1);
		Actions scrolldown = new Actions(driver);
		scrolldown.moveToElement(objetivo).build().perform();
		questions.screenShot();
		questions.impliciWait();
		objetivo.click();
		questions.screenShot();

	}
}
