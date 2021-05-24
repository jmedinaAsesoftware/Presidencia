#18/05/2020
#Jorge Andres Blanco
Feature: Cumplimiento Hu(020) (USER STORY 135364) 
Background: 
	Given que se ingreso a la url
	And dirigirse a la pantalla de creacion de producto

@Regresion2
Scenario Outline: Creacion de Productos (136700) 

	When Seleccione categoria <Categorias> y objetivos <Objetivos> 
	And seleccionar boton Crear producto
	And seleccionar boton continuar
	And Diligenciar campos Nombre Producto <NombreProducto> y Descripcion Producto <DescProducto>
	And Seleccionar opcion Agregar otro dueno de producto
  And diligenciar dueno del producto <DuenoProducto>
  And Seleccionar opcion Agregar otros actores
  And diligenciar nombre del actor <ActorProducto>
  And seleccionar boton guardar
  And seleccionar boton continuar creacion producto
  And Se cierra el navegador 

	
	Examples: 
		|Categorias                  |Objetivos	                  |NombreProducto              |DescProducto	            |DuenoProducto   |ActorProducto         |
		|Categoría - cultura - teatro|Nueva Aspiración modificado |Prueba Automatizada Jorge   |Prueba Automatizada Jorge |Fernando Ruiz   |Angel Cabrera         |
	
	
	@Regresion2
	Scenario Outline: Anexar Documentos (136694 Pendiente Solucion Bug Front CLic opción Ver archivos cargados)
	   When Seleccione categoria <Categorias> y objetivos <Objetivos> 
			And seleccionar boton Crear producto
			And seleccionar boton continuar
			And Diligenciar campos Nombre Producto <NombreProducto> y Descripcion Producto <DescProducto>			
	    And se debe anexar documentos y ver archivos cargados
	    And Se cierra el navegador
	    
	   Examples: 
		|Categorias                  |Objetivos	     |NombreProducto              |DescProducto	            |
		|Categoría - cultura - teatro|nueva          |Prueba Automatizada Jorge   |Prueba Automatizada Jorge|
		
