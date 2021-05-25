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

		
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-categoria']")
	private WebElement textoCategoriaProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@id='demo-simple-select-placeholder-label-objetivo']")
	private WebElement textoObjetivoProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='nombre']")
	private WebElement textoNombre;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='descripcion']")
	private WebElement textoDescripcion;
	
	@FindBy(how = How.XPATH, using = "//input[@name='duenos[0].nombre']")
	private WebElement textoDuenoNombre;
			
	@FindBy(how = How.XPATH, using = "//input[@name='actores[0].nombre']")
	private WebElement textoActorNombre;
			
	public CreacionProductoPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPaginas = new BotonesPaginas(driver);
		this.preguntas = new Preguntas(driver);
	}

		
	@Step
	public void crearProductoM() {
		preguntas.screenShot();
		botonesPaginas.btnMenuCrearProducto();
		preguntas.screenShot();
		botonesPaginas.btnPiramideCrearProducto();		
	}	
		

	@Step
	public void seleccionarCategoriaObjetivoM(String categoriaP,String objetivoP ) {
		
		preguntas.impliciWait();
		preguntas.screenShot();
		textoCategoriaProducto.sendKeys(categoriaP);
		preguntas.impliciWait();
		textoCategoriaProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoCategoriaProducto.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
	
		
		preguntas.impliciWait();
		textoObjetivoProducto.sendKeys(objetivoP);
		preguntas.impliciWait();
		textoObjetivoProducto.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoObjetivoProducto.sendKeys(Keys.ENTER);
		preguntas.impliciWait();
		preguntas.screenShot();
		
		preguntas.impliciWait();
		botonesPaginas.btnCrearProducto_Mas();
		preguntas.screenShot();
		
		preguntas.impliciWait();
		preguntas.screenShot();
		botonesPaginas.BtnContinuar();
	}	
	
	@Step
	public void diligenciarProductoM(String NombreProducto, String DescProducto) {
		preguntas.impliciWait();
	    textoNombre.sendKeys(NombreProducto);
	    preguntas.impliciWait();
	    preguntas.screenShot();
	    textoDescripcion.sendKeys(DescProducto);
	}
		
	@Step
	public void diligenciarDuenoActorM(String DuenoProducto, String ActorProducto) {
		preguntas.impliciWait();
		preguntas.screenShot();	
		textoDuenoNombre.sendKeys(DuenoProducto);
		preguntas.impliciWait();
		textoDuenoNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoDuenoNombre.sendKeys(Keys.ENTER);
		
		preguntas.impliciWait();
		textoActorNombre.sendKeys(ActorProducto);
		preguntas.impliciWait();
		textoActorNombre.sendKeys(Keys.ARROW_DOWN);
		preguntas.impliciWait();
		textoActorNombre.sendKeys(Keys.ENTER);
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
}
