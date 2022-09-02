package com.IFome.Enum;

import lombok.Getter;

@Getter
public enum EnumFormaPagamento {
	
	DINHEIRO(1,"Dinheiro"),
	CARTAO_CREDITO(2,"Cartão de Crédito"),
	CARTAO_DEBITO(3,"Cartão de Débito"),
	VALE_REFEICAO(4,"Vale Refeição"),
	PIX(5,"PIX");
	
	private int codigo;
	private String descricao;
	
	private EnumFormaPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
}
