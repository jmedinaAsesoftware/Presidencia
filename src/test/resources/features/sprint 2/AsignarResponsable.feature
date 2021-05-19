#18/05/2020
#Jhonatan Medina Blanco
@Regresion1
Feature: Asignar Aspiraciones (HU 017) (USER STORY 134835) 
Scenario Outline: Asignación de responsable Líder Cumplimiento. TEST CASE 136670 

	Given que se ingreso a la url 
	When Llegue a la opcion asignar responsables 
	And buscar categoria  y objetivo <buscarObjetivoP> y hacer clic en e boton Mas 
	Then se valida si ya hay un lider <nombreP> 
	
	Examples: 
		|buscarObjetivoP	  |nombreP|
		|Pruebas Automatizadas|Diego Mes|
	