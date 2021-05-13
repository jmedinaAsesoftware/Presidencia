#10/05/2020
#Jhonatan Medina Blanco
Feature: Escala de evaluacion (HU011)(USER STORY 131842) 
Background: 
	Given que se ingreso a la url 
	And dirigirse al formulario de evaluacion riesgo 
	And se debe anexar documentos y ver archivos cargados 
	
@Regresion 
Scenario Outline: Agregar impacto en el cumplimiento (133080) 

	When diligencie el campo nivel 1 <nivel1P> descripcion <descripNivel1P> campo nivel 2 <nivel2P> descripcion <descripNivel2P> 
	And diligenciar campo nivel 3 <nivel3P> descripcion <descripNivel3P> campo nivel 4 <nivel4P> descripcion <descripNivel4P> campo nivel 5 <nivel5P> descripcion <descripNivel5P> 
	And Se cierra el navegador 
	Examples: 
		|nivel1P		|descripNivel1P|nivel2P|descripNivel2P|nivel3P|descripNivel3P|nivel4P|descripNivel4P|nivel5P|descripNivel5P|
		|Demaciado bajo |Descripcion1  |Nivel2  |descrip2	  |Nivel3 |Descr3		 |Nivel4 |Descrip4		|Nivel5	|Descri5       |
		
		
		@Regresion 
		Scenario Outline: Agregar probabilidad de ocurrencia (133084) 
		
			When limpie los campos de probabilidad de ocurrencia 
			Then debe diligenciar el campo nivel 1 <nivel1P> descripcion <descripNivel1P> campo nivel 2 <nivel2P> descripcion <descripNivel2P> 
			And diligenciar los campo nivel 3 <nivel3P> descripcion <descripNivel3P> campo nivel 4 <nivel4P> descripcion <descripNivel4P> campo nivel 5 <nivel5P> descripcion <descripNivel5P> 
			And Se cierra el navegador 
			Examples: 
				|nivel1P		|descripNivel1P|nivel2P  |descripNivel2P|nivel3P	|descripNivel3P|nivel4P  |descripNivel4P|nivel5P	|descripNivel5P|
				|Demaciado alto |Desc1 w	   |Nivel2 w |descri2 w     |Nivel3 w	|Desc3 w	   |Nivel4 w |Descr4 w		|Nivel5 w	|Descrip5 w	   |
				
				