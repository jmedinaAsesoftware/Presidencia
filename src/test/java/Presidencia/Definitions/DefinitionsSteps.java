package Presidencia.Definitions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import Presidencia.Paginas.AsignacionResponsablesPaginas;
import Presidencia.Paginas.AspiracionesPaginas;
import Presidencia.Paginas.EvaluacionRiesgoPagina;
import Presidencia.Paginas.periodoCumplimientoPagina;
import Presidencia.Paginas.tiposRiesgosPagina;
import Presidencia.Paginas.CreacionProductoPagina;
import Presidencia.Steps.Conexion;
import Presidencia.Steps.ElementosPaginas;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;

public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private periodoCumplimientoPagina periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
	private tiposRiesgosPagina tiposRiesgosPage = new tiposRiesgosPagina(driver);
	private CreacionProductoPagina creacionproductoPage = new CreacionProductoPagina(driver);

	private EvaluacionRiesgoPagina evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
	private ElementosPaginas elementosPaginas = new ElementosPaginas(driver);
	private AspiracionesPaginas aspiracionesPaginas = new AspiracionesPaginas(driver);
	private AsignacionResponsablesPaginas asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);

	@Given("^que se ingreso a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}

	@When("^Se consulte la fecha inicio (.*) y fecha fin (.*)$")
	public void diligenciarFormulario(String FechaInicio, String FechaFin) {
		this.periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
		this.periodoCumplimientoPage.informacioGeneral(FechaInicio, FechaFin);
	}

	@Then("^al hacer clic en guardar se debe almacenar la informacion$")
	public void validarGuardado() throws AWTException {
		this.periodoCumplimientoPage = new periodoCumplimientoPagina(driver);
		this.periodoCumplimientoPage.validarArchivos();
	}

	@And("^se debe anexar documentos y ver archivos cargados$")
	public void validarAnexarDocumentos() throws AWTException {
		this.elementosPaginas = new ElementosPaginas(driver);
		this.elementosPaginas.ValidarArchivosCargados();
	}

	@And("^Se cierra el navegador$")
	public void CerrarNavegador() {
		this.conexion = new Conexion();
		this.conexion.CerrarNavegadorWer(driver);
	}

	@And("^dirigirse al formulario de tipo de riesgo$")
	public void DiriigirTipoRiesgo() {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.llegarTipoRiesgo();
	}

	@When("^agregue un tipo de riesgo denominado (.*) y descripcion (.*)$")
	public void agregarTipoRiesgo(String denominacionP, String descripcionP) {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.btnAgregarRiesgoM();

		this.tiposRiesgosPage.diligenciarTipoRiesgoM(denominacionP, descripcionP);
	}

	@When("^Editar un tipo de riesgo  nombre a buscar (.*) denominado (.*) y descripcion (.*)$")
	public void editarTipoRiesgo(String nombreBuscar, String denominacionP, String descripcionP) {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.btnEditarRiesgoM(nombreBuscar);
		this.tiposRiesgosPage.diligenciarTipoRiesgoM(denominacionP, descripcionP);
	}

	@When("^Eliminar un tipo de riesgo  nombre a buscar (.*)$")
	public void eliminarTipoRiesgo(String nombreBuscar) {
		this.tiposRiesgosPage = new tiposRiesgosPagina(driver);
		this.tiposRiesgosPage.btnEliminarRiesgoM(nombreBuscar);

	}

	@And("^dirigirse al formulario de evaluacion riesgo$")
	public void DiriigirEvaluacionRiesgo() {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.llegarEvaluacionM();
	}

	@When("^diligencie el campo nivel 1 (.*) descripcion (.*) campo nivel 2 (.*) descripcion (.*)$")
	public void diligenciarEvaluacionRiesgo(String nivel1P, String descripNivel1P, String nivel2P,
			String descripNivel2P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.limpiarCampoImpacto();
		this.evaluacionRiesgoPagina.diligenciarNivelesImpactoM(nivel1P, descripNivel1P, nivel2P, descripNivel2P);

	}

	@And("^diligenciar campo nivel 3 (.*) descripcion (.*) campo nivel 4 (.*) descripcion (.*) campo nivel 5 (.*) descripcion (.*)$")
	public void segundoDiligenciarEvaluacionRiesgo(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.segundoDiligenciarNivelesImpactoM(nivel3P, descripNivel3P, nivel4P, descripNivel4P,
				nivel5P, descripNivel5P);
		this.evaluacionRiesgoPagina.guardarM();

	}

	@When("^limpie los campos de probabilidad de ocurrencia$")
	public void limpiarCamposOcurrencia() {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.limpiarCamposProbabilidad();
	}

	@Then("^debe diligenciar el campo nivel 1 (.*) descripcion (.*) campo nivel 2 (.*) descripcion (.*)$")
	public void diligenciarProbabilidad(String nivel1P, String descripNivel1P, String nivel2P, String descripNivel2P) {
		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.diligenciarProbabilidadM(nivel1P, descripNivel1P, nivel2P, descripNivel2P);

	}

	@And("^diligenciar los campo nivel 3 (.*) descripcion (.*) campo nivel 4 (.*) descripcion (.*) campo nivel 5 (.*) descripcion (.*)$")
	public void segundoDiligenciarProbabilidad(String nivel3P, String descripNivel3P, String nivel4P,
			String descripNivel4P, String nivel5P, String descripNivel5P) {

		this.evaluacionRiesgoPagina = new EvaluacionRiesgoPagina(driver);
		this.evaluacionRiesgoPagina.segundoDiligenciarProbabilidadM(nivel3P, descripNivel3P, nivel4P, descripNivel4P,
				nivel5P, descripNivel5P);
		this.evaluacionRiesgoPagina.guardarM();

	}

	@And("^dirigirse al formulario de registro Aspiraciones$")
	public void dirigirseRegistroAspiraciones() {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.llegarRegistroAspiracionM();
	}

	@When("^Se realice el cargue de masivo de aspiraciones$")
	public void dcargueMasivoAspiraciones() throws AWTException {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.cargarArchivoMasivoM();
	}

	@When("^agregar registo de aspiraciones$")
	public void agregarAspiracion() {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.btnAgregarAspiracionesM();
	}

	@And("^diligenciar nombre (.*) descripcion (.*) origen (.*) sector (.*)$")
	public void diligenciarAspiraciones(String nombreP, String descripcionP, String origenP, String sectorP) {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.diligenciarFormularioM(nombreP, descripcionP, origenP, sectorP);

	}

	@When("^edite nombre a buscar (.*) nombre (.*) descripcion (.*) origen (.*) sector (.*)$")
	public void editarAspiraciones(String nombreBuscarP, String nombreP, String descripcionP, String origenP,
			String sectorP) {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.btnEditarAspiracionM(nombreBuscarP);
		this.aspiracionesPaginas.limpiarCamposM();
		this.aspiracionesPaginas.diligenciarFormularioM(nombreP, descripcionP, origenP, sectorP);

	}

	@When("^Eliminar aspiracion nombre a buscar (.*)$")
	public void eliminarAspiracion(String nombreBuscar) {
		this.aspiracionesPaginas = new AspiracionesPaginas(driver);
		this.aspiracionesPaginas.btnEliminarAspiracionM(nombreBuscar);

	}


	@When("^Llegue a la opcion asignar responsables$")
	public void llegarAsignar() {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.llegarAsignarM();

	}

	@And("^Buscar categoria y objetivo (.*) y hacer clic en boton Mas$")
	public void agregaResponsable(String buscarCategoria) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.agregarResponsableM(buscarCategoria);

	}

	@Then("^Se agregue un lider (.*)$")
	public void agregarLider(String nombreP) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.agregarLiderM(nombreP);
		this.asignacionResponsablesPaginas.guardarM();
	}

	@Then("^Se agregue un actor (.*) y rol (.*)$")
	public void agregarActor(String nombreP, String rolCumplimientoP) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.agregarActoresM(nombreP, rolCumplimientoP);
		this.asignacionResponsablesPaginas.guardarM();
	}

	@Then("^Buscar categoria y objetivo (.*) y hacer clic en editar$")
	public void consultarResponsables(String buscarObjetivoP) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.consultarResponsableM(buscarObjetivoP);
	}
	

	@And("^dirigirse a la pantalla de creacion de producto$")
	public void DirigirCreacionProducto() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.crearProductoM();
	}
	
	@When("^Seleccione categoria (.*) y objetivos (.*)$")
	public void seleccionarOpciones(String categoriaP, String objetivoP) {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.CategoriaM(categoriaP);
		this.creacionproductoPage.ObjetivoM(objetivoP);
	}
	
	@And("^seleccionar boton Crear producto$")
	public void CrearProducto() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.btncrearProductoM();
	}
	
	@And("^seleccionar boton continuar$")
	public void Continuar() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.btncontinuarM();
	}
	
	@And("^Diligenciar campos Nombre Producto (.*) y Descripcion Producto (.*)$")
	public void diligenciarProducto(String NombreProducto, String DescProducto) {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.DiligenciarProductoM(NombreProducto,DescProducto);
	}
	
	@And("^Seleccionar opcion Agregar otro dueno de producto$")
	public void SeleccionarDuenoProducto() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.selDuenoProductoM();
	}
	
	@And("^diligenciar dueno del producto (.*)$")
	public void diligenciarDuenoProducto(String DuenoProducto) {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.DiligenciarDuenoProductoM(DuenoProducto);
	}
	
	@And("^Seleccionar opcion Agregar otros actores$")
	public void SeleccionarActores() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.selActoresM();
	}
	
	@And("^diligenciar nombre del actor (.*)$")
	public void diligenciarActorProducto(String ActorProducto) {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.DiligenciarActorProductoM(ActorProducto);
	}
	@And("^seleccionar boton guardar$")
	public void SeleccionarbtnGuardar() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.seleccionarbtnGuardarM();
	}
	
	@And("^seleccionar boton continuar creacion producto$")
	public void SeleccionarbtnContinuar() {
		this.creacionproductoPage = new CreacionProductoPagina(driver);
		this.creacionproductoPage.seleccionarbtnContinuarM();
	}
	
	


	@And("^Al seleccionar el nombre (.*) para editar el rol (.*) se confimar la actualizacion (.*)$")
	public void editarRolResponsable(String buscarNombreP, String rolCumplimientoP, String buscarObjetivoP) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.editarResponsableM(buscarNombreP, rolCumplimientoP);
		this.asignacionResponsablesPaginas.guardarM();
		this.asignacionResponsablesPaginas.continuarM();
		this.asignacionResponsablesPaginas.consultarResponsableM(buscarObjetivoP);
	}
	
	@And("^Al seleccionar el nombre (.*) para eliminar el responsable se confimar la eliminacion (.*)$")
	public void eliminarRolResponsable(String buscarNombreP, String buscarObjetivoP) {
		this.asignacionResponsablesPaginas = new AsignacionResponsablesPaginas(driver);
		this.asignacionResponsablesPaginas.eliminarResponsableM(buscarNombreP);
		this.asignacionResponsablesPaginas.consultarResponsableM(buscarObjetivoP);
	}

}