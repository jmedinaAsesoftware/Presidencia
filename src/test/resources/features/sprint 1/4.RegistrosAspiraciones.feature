#12/05/2020
#Jhonatan Medina Blanco
Feature: Aspiraciones (HU 012) (USER STORY 131843) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de registro Aspiraciones 
	
@Regresion 
Scenario: cargar archivo de aspiraciones (134788) 
	When Se realice el cargue de masivo de aspiraciones 
	And Se cierra el navegador 
	
@Regresion 
Scenario Outline: : agregar aspiraciones (133039) 
#And se debe anexar documentos y ver archivos cargados 
	When agregar registo de aspiraciones 
	And diligenciar nombre <nombreP> descripcion <descripcionP> origen <origenP> sector <sectorP> 
	And Se cierra el navegador 
	Examples: 
		|nombreP		|descripcionP |origenP|sectorP	 |
		|Prueba final	|ejecucions	  |QA	  |Sector - 2|
		
		@Regresion 
		Scenario Outline: Editar Aspiraciones (134784) 
			
			When edite nombre a buscar <nombreBuscarP> nombre <nombreP> descripcion <descripcionP> origen <origenP> sector <sectorP> 
			And se debe anexar documentos y ver archivos cargados 
			And Se cierra el navegador 
			Examples: 
				|nombreBuscarP	|nombreP				|descripcionP |origenP|sectorP	 |
				|Salud automatizacion|edicion Automatizacion	|ejecucions	  |QA	  |Sector - 2|
				
		