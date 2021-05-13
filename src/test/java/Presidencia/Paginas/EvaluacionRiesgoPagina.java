package Presidencia.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Presidencia.Steps.ElementosPaginas;
import Presidencia.Steps.BotonesPaginas;
import Presidencia.Steps.Preguntas;
import net.thucydides.core.annotations.Step;

public class EvaluacionRiesgoPagina {

	private WebDriver driver;
	private tiposRiesgosPagina tiposRiesgosPagina;
	private BotonesPaginas botonesPaginas;
	private Preguntas preguntas;
	private ElementosPaginas elementosPaginas;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 01.escala")
	private WebElement textoNivel1;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 01.descripcion")
	private WebElement textoDescripcionNivel1;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 02.escala")
	private WebElement textoNivel2;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 02.descripcion")
	private WebElement textoDescripcionNivel2;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 03.escala")
	private WebElement textoNivel3;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 03.descripcion")
	private WebElement textoDescripcionNivel3;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 04.escala")
	private WebElement textoNivel4;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 04.descripcion")
	private WebElement textoDescripcionNivel4;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 05.escala")
	private WebElement textoNivel5;

	@FindBy(how = How.NAME, using = "Impacto en el cumplimiento.Nivel 05.descripcion")
	private WebElement textoDescripcionNivel5;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 01.escala")
	private WebElement textoCumplimientoNivel1;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 01.descripcion")
	private WebElement textoDesCumplimientoNivel1;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 02.escala")
	private WebElement textoCumplimientoNivel2;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 02.descripcion")
	private WebElement textoDesCumplimientoNivel2;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 03.escala")
	private WebElement textoCumplimientoNivel3;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 03.descripcion")
	private WebElement textoDesCumplimientoNivel3;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 04.escala")
	private WebElement textoCumplimientoNivel4;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 04.descripcion")
	private WebElement textoDesCumplimientoNivel4;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 05.escala")
	private WebElement textoCumplimientoNivel5;

	@FindBy(how = How.NAME, using = "Probabilidad de ocurrencia.Nivel 05.descripcion")
	private WebElement textoDesCumplimientoNivel5;

	public EvaluacionRiesgoPagina(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.tiposRiesgosPagina = new tiposRiesgosPagina(driver);
		this.botonesPaginas = new BotonesPaginas(driver);
		this.preguntas = new Preguntas(driver);
		this.elementosPaginas = new ElementosPaginas(driver);

	}

	@Step
	public void llegarEvaluacionM() {
		tiposRiesgosPagina.llegarTipoRiesgo();
		botonesPaginas.BtnContinuar();
		preguntas.impliciWait();
		botonesPaginas.btnDiagContinuar();
		preguntas.impliciWait();
	}

	@Step
	public void limpiarCampoImpacto() {
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		preguntas.impliciWait();
		textoNivel1.clear();
		textoDescripcionNivel1.clear();
		textoNivel2.clear();
		textoDescripcionNivel2.clear();
		textoNivel3.clear();
		textoDescripcionNivel3.clear();
		textoNivel4.clear();
		textoDescripcionNivel4.clear();
		textoNivel5.clear();
		textoDescripcionNivel5.clear();
		preguntas.screenShot();

	}

	@Step
	public void diligenciarNivelesImpactoM(String nivel1P, String descripNivel1P, String nivel2P,
			String descripNivel2P) {

		textoNivel1.sendKeys(nivel1P);
		textoDescripcionNivel1.sendKeys(descripNivel1P);
		textoNivel2.sendKeys(nivel2P);
		textoDescripcionNivel2.sendKeys(descripNivel2P);

	}

	@Step
	public void segundoDiligenciarNivelesImpactoM(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		textoNivel3.sendKeys(nivel3P);
		textoDescripcionNivel3.sendKeys(descripNivel3P);
		textoNivel4.sendKeys(nivel4P);
		textoDescripcionNivel4.sendKeys(descripNivel4P);
		textoNivel5.sendKeys(nivel5P);
		textoDescripcionNivel5.sendKeys(descripNivel5P);

	}

	@Step
	public void limpiarCamposProbabilidad() {
		elementosPaginas.scrollBajarDos();
		preguntas.screenShot();
		preguntas.tiempoSegundos(1);
		preguntas.impliciWait();
		textoCumplimientoNivel1.clear();
		textoDesCumplimientoNivel1.clear();
		textoCumplimientoNivel2.clear();
		textoDesCumplimientoNivel2.clear();
		textoCumplimientoNivel3.clear();
		textoDesCumplimientoNivel3.clear();
		textoCumplimientoNivel4.clear();
		textoDesCumplimientoNivel4.clear();
		textoCumplimientoNivel5.clear();
		textoDesCumplimientoNivel5.clear();
		preguntas.screenShot();
	}

	@Step
	public void diligenciarProbabilidadM(String nivel1P, String descripNivel1P, String nivel2P, String descripNivel2P) {
		textoCumplimientoNivel1.sendKeys(nivel1P);
		textoDesCumplimientoNivel1.sendKeys(descripNivel1P);
		textoCumplimientoNivel2.sendKeys(nivel2P);
		textoDesCumplimientoNivel2.sendKeys(descripNivel2P);

	}

	@Step
	public void segundoDiligenciarProbabilidadM(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		textoCumplimientoNivel3.sendKeys(nivel3P);
		textoDesCumplimientoNivel3.sendKeys(descripNivel3P);
		textoCumplimientoNivel4.sendKeys(nivel4P);
		textoDesCumplimientoNivel4.sendKeys(descripNivel4P);
		textoCumplimientoNivel5.sendKeys(nivel5P);
		textoDesCumplimientoNivel5.sendKeys(descripNivel5P);
		preguntas.screenShot();
	}

	@Step
	public void guardarM() {
		preguntas.screenShot();
		botonesPaginas.btnPrincipalGuardar();
		preguntas.tiempoSegundos(1);
		preguntas.screenShot();
		preguntas.AsserEvaluacionRiesgos();
		preguntas.impliciWait();
		botonesPaginas.BtnSi();
		preguntas.screenShot();
	}
}
