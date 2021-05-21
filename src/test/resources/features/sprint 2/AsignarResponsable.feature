#18/05/2020
#Jhonatan Medina Blanco
Feature: Asignar Aspiraciones (HU 017) (USER STORY 134835) 
Background: 
	Given que se ingreso a la url 
	When Llegue a la opcion asignar responsables 
	
@Regresion1 
Scenario Outline: Asignación de responsable Líder Cumplimiento. TEST CASE 136670 

	And Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en boton Mas 
	Then Se agregue un lider  <nombreP> 
	And Se cierra el navegador 
	
	Examples: 
		|buscarObjetivoP  |nombreP|
		|Aspiración de prueba 10002	  |diego|
		
		@Regresion
		Scenario Outline: Asignación responsable Otros Actores TEST CASE 136672 
			And Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en boton Mas 
			Then Se agregue un actor <nombreP> y rol <rolCumplimiento> 
			And Se cierra el navegador 
			Examples: 
				|buscarObjetivoP  |nombreP		|rolCumplimiento|
				|Hola Familia	  |Fern |Pruebas Automat|
				
				
				@Regresion
				Scenario Outline: Consultar responsables TEST CASE 136677
					Then Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en editar 
					And Se cierra el navegador 
					Examples: 
						|buscarObjetivoP  |
						|Hola Familia	  |
						
		