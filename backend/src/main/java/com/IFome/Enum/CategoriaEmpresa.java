package com.IFome.Enum;

import lombok.Getter;

@Getter
public enum CategoriaEmpresa {
	
	PIZZA(1,"Pizza"),
	LANCHES(2, "Lanches"),
	HAMBURGUER(3, "Hamburguer"),
	CHINESA(4, "Chinesa"),
	JAPONESA(5, "Japonesa"),
	BRASILEIRA(6, "Brasileira"),
	DOCES(7, "Doces"),
	SORVETE_ACAI(8, "Sorvetes e açai"),
	BEBIDA(9, "Bebida");
	
	private int codigo;
	private String descricao;
	
	CategoriaEmpresa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}
