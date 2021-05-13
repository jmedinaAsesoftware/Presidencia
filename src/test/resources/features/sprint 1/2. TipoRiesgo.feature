#07/05/2020
#Jhonatan Medina Blanco
Feature: Determinar tipo de Riesgos (HU010) (USER STORY 131840) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de tipo de riesgo 

@Regresion
Scenario Outline: Agregar tipo de riego para el periodo actual (TEST CASE 133811) 

	When agregue un tipo de riesgo denominado <denominacionP> y descripcion <descripcionP> 
	And Se cierra el navegador 
	
	Examples: 

		|denominacionP|descripcionP			|
		|echo 1		  |Creacion de riesgo   |	
		|QA auto 	  |EJEMPLO	   			|
		
@Regresion
Scenario Outline: Editar tipo de riego para el periodo actual (TEST CASE 133035) 

	When Editar un tipo de riesgo  nombre a buscar <nombreBuscar> denominado <denominacionP> y descripcion <descripcionP> 
	Examples: 
		|nombreBuscar	|denominacionP   |descripcionP	 |
		|echo 1		    |Cambio Q		 |pruebas QA aUTO|   
		
@Regresion
Scenario Outline: Eliminar tipo de riesgo para el periodo actual (TEST CASE 133035) 
	When Eliminar un tipo de riesgo  nombre a buscar <nombreBuscar>
	
	Examples: 
		|nombreBuscar	 |
		|Cambio Q |  
