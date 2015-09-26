package br.com.caelum.agiletickets.domain.precos;

import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecosFactory {

	public static CalculadoraDePrecosInterface get(TipoDeEspetaculo tipoDeEspetaculo) {

		switch (tipoDeEspetaculo) {
		
		case BALLET:
			
			return new CalculadoraDePrecosDeBallet();
			
		case CINEMA:
			
			return new CalculadoraDePrecosDeCinema();
			
		case ORQUESTRA:
			
			return new CalculadoraDePrecosDeOrquestra();
			
		case SHOW:
			
			return new CalculadoraDePrecosDeShow();

		case TEATRO:
			
			return new CalculadoraDePrecosDeTeatro();
		
		default:
			
			throw new IllegalArgumentException("Calculadora nao implementada para o tipo de espetaculo informado.");
		}
		
		
	}
	
}