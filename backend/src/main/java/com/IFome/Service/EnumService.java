package com.IFome.Service;

import org.springframework.stereotype.Service;

import com.IFome.Enum.EnumException;

@Service
public class EnumService {

	public int getCodigoErro(String descricaoErro) {
		for (EnumException enumerico : EnumException.values()) {
			if (enumerico.getDescricaoErro().equals(descricaoErro)) {
				return enumerico.getCodigo();
			}
		}
		return 500;
	}
	
}
