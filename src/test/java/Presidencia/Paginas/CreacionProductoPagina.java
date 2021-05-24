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


public class CreacionProductoPagina {

	private WebDriver driver;
	private BotonesPaginas botonesPaginas;
	private Preguntas preguntas;

	@FindBy(how = How.XPATH, using = "//*[@id=\'menuLeftCollapsed\']/div[2]/a")
	private WebElement opcioncreacionProducto;
	
	@FindBy(how = How.XPATH, using = "//div[@class='contenedor_imagen_piramide']")
	private WebElement imagenpiramideProducto;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-categoria']")
	private WebElement textocategoriaProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-objetivo']")
	private WebElement textoobjetivoProducto;
	

	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-2']")
	private WebElement btnCrearProducto;
	
		
	@FindBy(how = How.XPATH, using = "//input[@name='nombre']")
	private WebElement textoNombre;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='descripcion']")
	private WebElement multilineaDescripcion;
	
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Agregar otro dueño de producto')]")
	private WebElement linkDuenoProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='duenos[0].nombre']")
	private WebElement textoDuenoNombre;
	
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Agregar otros actores')]")
	private WebElement linkActoresProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='actores[0].nombre']")
	private WebElement textoActorNombre;
		
		
	@FindBy(how = How.XPATH, using = "//div[@role= 'presentation']//h2[@class='MuiTypography-root MuiTypography-h6']")
	private WebElement assertConfirmacion;	
	
		
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
		opcioncreacionProducto.click();
		preguntas.screenShot();
		preguntas.impliciWait();
		imagenpiramideProducto.click();		
	}	
	
	

	@Step
	public void CategoriaM(String categoriaP) {
		preguntas.impliciWait();
		preguntas.screenShot();
		textocategoriaProducto.click();
		textocategoriaProducto.sendKeys(categoriaP);
		textocategoriaProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		preguntas.screenShot();
		textocategoriaProducto.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();
		
	}
	
	@Step
	public void ObjetivoM(String objetivoP) {
		
	    preguntas.impliciWait();
	    preguntas.screenShot();
	    textoobjetivoProducto.click();
	    textoobjetivoProducto.sendKeys(objetivoP);
	    textoobjetivoProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		preguntas.screenShot();
		textoobjetivoProducto.sendKeys(Keys.ENTER);
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
	    botonesPaginas.BtnContinuar();
	    
	}
	
	@Step
	public void DiligenciarProductoM(String NombreProducto, String DescProducto) {
		preguntas.impliciWait();
	    preguntas.screenShot();
	    textoNombre.sendKeys(NombreProducto);
	    preguntas.impliciWait();
	    preguntas.screenShot();
	    multilineaDescripcion.sendKeys(DescProducto);
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
        textoDuenoNombre.sendKeys(DuenoProducto);
		textoDuenoNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoDuenoNombre.sendKeys(Keys.ENTER);
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
		textoActorNombre.sendKeys(ActorProducto);
		textoActorNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoActorNombre.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();		
	}
	
	@Step
	public void seleccionarbtnGuardarM() {
		botonesPaginas.BtnGuardar();
		preguntas.screenShot();	
		
		if(assertConfirmacion != null) {
			preguntas.screenShot();
			
		}		
		preguntas.impliciWait();
		preguntas.screenShot();		
		botonesPaginas.BtnSi();

	}
	
	@Step
	public void seleccionarbtnContinuarM() {
	
		botonesPaginas.btnPrincipalGuardar();
		if(assertContinuar != null) {
			preguntas.screenShot();
			
		}
		preguntas.impliciWait();
		preguntas.screenShot();		
		btnassertContinuar.click();
	}
	
}
