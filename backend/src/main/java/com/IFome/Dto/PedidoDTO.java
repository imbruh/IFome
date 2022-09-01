package com.IFome.Dto;

import java.util.UUID;

import com.IFome.Model.Cliente;
import com.IFome.Model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {

	private int numero;
	
	private UUID idCliente;
}
