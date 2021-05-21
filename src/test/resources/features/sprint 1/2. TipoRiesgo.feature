#07/05/2020
#Jhonatan Medina Blanco
Feature: Determinar tipo de Riesgos (HU010) (USER STORY 131840) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de tipo de riesgo 

@Regresion
Scenario Outline: Agregar tipo de riego para el periodo actual (TEST CASE 133811) 

	When agregue un tipo de riesgo denominado <denominacionP> y descripcion <descripcionP> 
	And se debe anexar documentos y ver archivos cargados 
	And Se cierra el navegador 
	
	Examples: 

		|denominacionP|descripcionP			|
		|Prueba Auotmatizacion |Jorge QA Auto   |	
		|Prueba Auto 2    |QA Auto         |	
		
		
@Regresion
Scenario Outline: Editar tipo de riego para el periodo actual (TEST CASE 133035) 

	When Editar un tipo de riesgo  nombre a buscar <nombreBuscar> denominado <denominacionP> y descripcion <descripcionP> 
	And Se cierra el navegador 
	
	Examples: 
		|nombreBuscar	|denominacionP   |descripcionP	 |
		|Prueba Auto 2 |Prueba Auto  Update 2	 |pruebas QA Update2|   
		
@Regresion
Scenario Outline: Eliminar un tipo de riesgo  nombre a buscar (TEST CASE 133035) 

	When Eliminar un tipo de riesgo  nombre a buscar <nombreBuscar>
	And Se cierra el navegador 
	
	Examples: 
		|nombreBuscar	 |
		|Prueba Jorge Update 1|  
		|Prueba QA     |
