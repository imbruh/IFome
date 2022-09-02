package com.IFome.Exception;

import com.IFome.Enum.EnumException;

public class IFMException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IFMException(EnumException validacaoException){
        super(validacaoException.getDescricaoErro());
    }
}
