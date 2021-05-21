package Presidencia.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Presidencia.Steps.BotonesPaginas;
import Presidencia.Steps.Preguntas;
import net.thucydides.core.annotations.Step;


public class CreacionProductoPagina {

	private WebDriver driver;
	private BotonesPaginas botonesPaginas;
	private Preguntas preguntas;

	@FindBy(how = How.XPATH, using = "//*[@id=\'menuLeftCollapsed\']/div[2]/a")
	private WebElement creacionProducto;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'content-app\']/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div")
	private WebElement piramideProducto;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-categoria']")
	private WebElement categoriaProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-objetivo']")
	private WebElement objetivoProducto;
	

	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-2'] ")
	private WebElement btnCrearProducto;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continuar')]")
	private WebElement btnContinuar;
	
	@FindBy(how = How.XPATH, using = "//input[@name='nombre']")
	private WebElement inputNombre;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='descripcion']")
	private WebElement textDescripcion;
	
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Agregar otro dueño de producto')]")
	private WebElement linkDuenoProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='duenos[0].nombre']")
	private WebElement inputDuenoNombre;
	
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Agregar otros actores')]")
	private WebElement linkActoresProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='actores[0].nombre']")
	private WebElement inputActorNombre;
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Guardar')]")
	private WebElement btnGuardar;	
	
	
	@FindBy(how = How.XPATH, using = "//div[@role= 'presentation']//h2[@class='MuiTypography-root MuiTypography-h6']")
	private WebElement assertConfirmacion;	
	
	@FindBy(how = How.XPATH, using = "//button[@class='botonPrincipalAzul']")
	private WebElement btnSi;	
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continuar')]")
	private WebElement btnContinuarCreacion;
	
	@FindBy(how = How.XPATH, using = "//div[@role= 'presentation']//h2[contains(text(),'¿Está seguro que desea continuar?')]")
	private WebElement assertContinuar;	
	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiDialogActions-root textoCentrado MuiDialogActions-spacing']//button[@class='botonPrincipalAzul']")
	private WebElement btnassertContinuar;
	
	
	
	
	public CreacionProductoPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new BotonesPaginas(driver);
		this.preguntas = new Preguntas(driver);
	}

		
	@Step
	public void crearProductoM() {
		preguntas.screenShot();
		preguntas.impliciWait();
		creacionProducto.click();
		preguntas.screenShot();
		preguntas.impliciWait();
		piramideProducto.click();		
	}	
	
	

	@Step
	public void CategoriaM(String categoriaP) {
		preguntas.impliciWait();
		preguntas.screenShot();
		categoriaProducto.click();
		categoriaProducto.sendKeys(categoriaP);
		categoriaProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		preguntas.screenShot();
		categoriaProducto.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();
		
	}
	
	@Step
	public void ObjetivoM(String objetivoP) {
		
	    preguntas.impliciWait();
	    preguntas.screenShot();
	    objetivoProducto.click();
	    objetivoProducto.sendKeys(objetivoP);
		objetivoProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		preguntas.screenShot();
		objetivoProducto.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();		
	}
	
	@Step
	public void btncrearProductoM() {
		preguntas.impliciWait();
		preguntas.screenShot();
		btnCrearProducto.click();
	}
	
	@Step
	public void btncontinuarM() {
		preguntas.impliciWait();
	    preguntas.screenShot();
	    btnContinuar.click();
	    
	}
	
	@Step
	public void DiligenciarProductoM(String NombreProducto, String DescProducto) {
		preguntas.impliciWait();
	    preguntas.screenShot();
	    inputNombre.sendKeys(NombreProducto);
	    preguntas.impliciWait();
	    preguntas.screenShot();
	    textDescripcion.sendKeys(DescProducto);
	}
	
	@Step
	public void selDuenoProductoM() {
		preguntas.impliciWait();
	    preguntas.screenShot();
	    linkDuenoProducto.click();
	}
	
	@Step
	public void DiligenciarDuenoProductoM(String DuenoProducto) {
		preguntas.impliciWait();
		preguntas.screenShot();
        inputDuenoNombre.sendKeys(DuenoProducto);
		inputDuenoNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		inputDuenoNombre.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();		
	}
	
	@Step
	public void selActoresM() {
		preguntas.impliciWait();
	    preguntas.screenShot();
	    linkActoresProducto.click();
	}
	
	@Step
	public void DiligenciarActorProductoM(String ActorProducto) {
		preguntas.impliciWait();
		preguntas.screenShot();
		inputActorNombre.sendKeys(ActorProducto);
		inputActorNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		inputActorNombre.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();		
	}
	
	@Step
	public void seleccionarbtnGuardarM() {
		btnGuardar.click();
		preguntas.impliciWait();
		preguntas.screenShot();	
		
		if(assertConfirmacion != null) {
			preguntas.screenShot();
			
		}		
		preguntas.impliciWait();
		preguntas.screenShot();		
		btnSi.click();

	}
	
	@Step
	public void seleccionarbtnContinuarM() {
		btnContinuarCreacion.click();
		preguntas.impliciWait();
		preguntas.screenShot();	
		if(assertContinuar != null) {
			preguntas.screenShot();
			
		}
		preguntas.impliciWait();
		preguntas.screenShot();		
		btnassertContinuar.click();
	}
	
	
	
	
}
