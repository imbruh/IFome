package com.IFome.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EnumException {
	
	USUARIO_NAO_ENCONTRADO("Usuário não encontrado");
	
	private String descricaoErro;
	
}
