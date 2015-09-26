package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecosDeTeatro implements CalculadoraDePrecosInterface {

	@Override
	public BigDecimal calcula(Sessao sessao, Integer quantidade) {
		return sessao.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}

}
