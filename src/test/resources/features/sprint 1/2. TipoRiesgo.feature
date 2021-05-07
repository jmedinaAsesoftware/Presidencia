#07/05/2020
#Jhonatan Medina Blanco
@Regresion 
Feature: Determinar tipo de Riesgos (HU010) (USER STORY 131840) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de tipo de riesgo 
	
Scenario Outline: Agregar tipo de riego para el periodo actual (TEST CASE 133811) 

	When agregue un tipo de riesgo denominado <denominacionP> y descripcion <descripcionP> 
	And Se cierra el navegador 
	
	Examples: 
		|denominacionP|descripcionP|
		|pruebas auto |EJEMPLO	   |	
		|QA auto 	  |EJEMPLO	   |
		
		
Scenario Outline: Editar tipo de riego para el periodo actual (TEST CASE 133035) 

	When Editar un tipo de riesgo  nombre a buscar <nombreBuscar> denominado <denominacionP> y descripcion <descripcionP> 
	Examples: 
		|nombreBuscar|denominacionP|descripcionP	   |
		|QA auto	 |Se cambio QA |se cambio el nombre|   
		
		