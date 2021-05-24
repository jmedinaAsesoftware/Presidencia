#18/05/2020
#Jhonatan Medina Blanco
Feature: Asignar responsables lideres (HU 017) (USER STORY 134835) 
Background: 
	Given que se ingreso a la url 
	When Llegue a la opcion asignar responsables 
	

@Regresion2

Scenario Outline: Asignación de responsable Líder Cumplimiento. TEST CASE 136670 

	And Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en boton Mas 
	Then Se agregue un lider  <nombreP> 
	And Se cierra el navegador 
	
	Examples: 
		|buscarObjetivoP  |nombreP|
		|Objetivo prueba 1  |ivan|
		
		@Regresion2
		Scenario Outline: Asignación responsable Otros Actores TEST CASE 136672 
			And Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en boton Mas 
			Then Se agregue un actor <nombreP> y rol <rolCumplimiento> 
			And Se cierra el navegador 
			Examples: 
				|buscarObjetivoP  |nombreP		|rolCumplimiento|
				|Objetivo prueba 1|Claudi	|Pruebas Automat|
				
				
				@Regresion2
				Scenario Outline: Consultar responsables TEST CASE 136677 
					Then Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en editar 
					And Se cierra el navegador 
					Examples: 
						|buscarObjetivoP  |
						|Objetivo prueba 1|
						
						@Regresion2
						Scenario Outline: editar responsables TEST CASE 136679 
							Then Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en editar 
							And Al seleccionar el nombre <buscarNombreP> para editar el rol <rolCumplimientoP> se confimar la actualizacion <buscarObjetivoP> 
							And Se cierra el navegador 
							Examples: 
								|buscarObjetivoP  |buscarNombreP|rolCumplimientoP|
								|Objetivo prueba 1 |Claudi|borrador|
								
								@Regresion2
								Scenario Outline: eliminar responsables TEST CASE 136679 
									Then Buscar categoria y objetivo <buscarObjetivoP> y hacer clic en editar 
									And Al seleccionar el nombre <buscarNombreP> para eliminar el responsable se confimar la eliminacion <buscarObjetivoP>
									And Se cierra el navegador 
									Examples: 
										|buscarObjetivoP  |buscarNombreP|
										|Objetivo prueba 1|Claudia|