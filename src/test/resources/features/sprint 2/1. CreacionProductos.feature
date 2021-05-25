#18/05/2020
#Jorge Andres Blanco
Feature: Cumplimiento Hu(020) (USER STORY 135364) 
Background: 
	Given que se ingreso a la url
	And dirigirse a la pantalla de creacion de producto

@Regresion
Scenario Outline: Creacion de Productos (136700) 

	When Seleccione categoria <Categorias> y objetivos <Objetivos> y hacer clic en Crear Producto 
	And  Diligenciar campos Nombre Producto <NombreProducto> , Descripcion Producto <DescProducto> 
	And  Diligenciar campos Dueno del producto<DuenoProducto> y nombre del actor<ActorProducto>	
	And  Se cierra el navegador   
	
	Examples:
	|Categorias                  |Objetivos	      |NombreProducto              |DescProducto	            |DuenoProducto  |ActorProducto   |
	|Categoría - Paz - JEP       |Objetivo prueba |Prueba Automatizada Jorge   |Prueba Automatizada Jorge |Maria Angul    |Angel Cabrer    |
	
	
	@Regresion
	Scenario Outline: Anexar Documentos (136694 Pendiente Solucion Bug Front CLic opción Ver archivos cargados)
	   When Seleccione categoria <Categorias> y objetivos <Objetivos> y hacer clic en Crear Producto 
			And  Diligenciar campos Nombre Producto <NombreProducto> , Descripcion Producto <DescProducto> 
	    And se debe anexar documentos y ver archivos cargados
	    And Se cierra el navegador
	    
	   Examples: 
		|Categorias                  |Objetivos	     |NombreProducto              |DescProducto	            |
		|Categoría - cultura - teatro|nueva          |Prueba Automatizada Jorge   |Prueba Automatizada Jorge|
		
