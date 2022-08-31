package com.IFome.Dto;

import lombok.NoArgsConstructor;

import com.IFome.Model.Cliente;
import com.IFome.Model.Pessoa;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

	private Pessoa pessoa;
	
	private Cliente cliente;
	
}
