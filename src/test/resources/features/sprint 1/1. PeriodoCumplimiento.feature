#30/04/2020
#Jhonatan Medina Blanco
@Regresion
Feature: Registro del Período para la Gestión del Cumplimiento. Hu(007) (USER STORY 131817) 
Scenario Outline: Registro del Período para la Gestión del Cumplimiento (132981) 
	Given que se ingreso a la url 
	When Se consulte la fecha inicio <FechaInicio> y fecha fin <FechaFin> 
	And se debe anexar documentos y ver archivos cargados 
	And Se cierra el navegador 
	
	Examples: 
		|FechaInicio|FechaFin	|
		|22/05/2022 |22/10/2022 |
		|22/05/2023 |22/10/2023 |
	