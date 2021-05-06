#05/05/2020
#Jhonatan Medina Blanco
@Regresion
Feature: Determinar tipo de Riesgos (HU010) (USER STORY 131840) 
Scenario Outline: Agregar tipo de riego para el periodo actual (TEST CASE 133811) 
	Given que se ingreso a la url 
	And dirigirse al formulario de tipo de riesgo 
	When agregue un tipo de riesgo denominado <denominacionP> y descripcion <descripcionP> 
	And Se cierra el navegador 
	
	Examples: 
		|denominacionP|descripcionP|
		|pruebas auto |EJEMPLO	   |	
		|QA auto 2 	  |EJEMPLO	   |	
		
	