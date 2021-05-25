#12/05/2020
#Jhonatan Medina Blanco
Feature: Aspiraciones (HU 012) (USER STORY 131843) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de registro Aspiraciones 
	
@Regresion1 
Scenario: cargar archivo de aspiraciones (134788) 
	When Se realice el cargue de masivo de aspiraciones 
	And Se cierra el navegador 
	
@Regresion1 
Scenario Outline: : agregar aspiraciones (133039) 

	When agregar registo de aspiraciones 
	And diligenciar nombre <nombreP> descripcion <descripcionP> origen <origenP> sector <sectorP> 
	And Se cierra el navegador 
	Examples: 
		|nombreP				|descripcionP |origenP|sectorP	 |
		|prueba regresion dos	|ejecucions	  |QA	  |Sector - 2|
		
		@Regresion1
		Scenario Outline: Editar Aspiraciones (134784) 
		
			When edite nombre a buscar <nombreBuscarP> nombre <nombreP> descripcion <descripcionP> origen <origenP> sector <sectorP> 
			And se debe anexar documentos y ver archivos cargados 
			And Se cierra el navegador 
			Examples: 
				|nombreBuscarP		 |nombreP					|descripcionP |origenP|sectorP	 |
				|Salud automatizacion|Pruebas Automatizadas		|ejecucions	  |QA	  |Sector - 2|
				
				
				@Regresion1
				Scenario Outline: Eliminar aspiracion (133041) 
					When Eliminar aspiracion nombre a buscar <nombreBuscar> 
					
						Examples: 
						|nombreBuscar|
						|Pruebas Automatizadas	|
						
		