package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			
			BigDecimal preco;
			
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			} else {
				preco = sessao.getPreco();
			}
			
			return preco.multiply(BigDecimal.valueOf(quantidade));
		}
		
	}, SHOW {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			
			BigDecimal preco;
			
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			} else {
				preco = sessao.getPreco();
			}
			
			return preco.multiply(BigDecimal.valueOf(quantidade));
		}
		
	}, TEATRO {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			return sessao.getPreco().multiply(BigDecimal.valueOf(quantidade));
		}
		
	}, BALLET {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			
			BigDecimal preco;
			
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			
			return preco.multiply(BigDecimal.valueOf(quantidade));
			
		}
		
	}, ORQUESTRA {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			
			BigDecimal preco;
			
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = sessao.getPreco();
			}

			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			
			return preco.multiply(BigDecimal.valueOf(quantidade));
		}
		
	}, CIRCO {
		
		@Override
		public BigDecimal calcula(Sessao sessao, Integer quantidade) {
			return BigDecimal.ZERO;
		}
		
	};
	
	
	public abstract BigDecimal calcula(Sessao sessao, Integer quantidade);
}
