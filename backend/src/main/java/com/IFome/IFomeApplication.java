package com.IFome;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.IFome.Enum.CategoriaEmpresa;
import com.IFome.Enum.EnumException;
import com.IFome.Enum.FormaPagamento;
import com.IFome.Model.Cliente;
import com.IFome.Model.Empresa;
import com.IFome.Model.Funcionario;
import com.IFome.Model.Pedido;
import com.IFome.Model.Pessoa;
import com.IFome.Model.Produto;
import com.IFome.Service.ClienteService;
import com.IFome.Service.EmpresaService;
import com.IFome.Service.FuncionarioService;
import com.IFome.Service.PedidoService;
import com.IFome.Service.ProdutoService;

@SpringBootApplication
public class IFomeApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClienteService clienteService,
			@Autowired EmpresaService empresaService,
			@Autowired ProdutoService produtoService,
			@Autowired PedidoService pedidoService,
			@Autowired FuncionarioService funcionarioService) {
		return args -> {
			System.out.println("============== @SpringBootApplication Main ==============");
			Cliente cliente = clienteService.cadastrar(
					Cliente.builder()
					.email("admin@admin.com")
					.senha("admin")
					.pessoa(
							Pessoa.builder()
							.nome("ADMIN")
							.dataNascimento(LocalDate.parse("2000-01-20"))
							.cpf("42101948400")
							.endereco("teste")
							.telefone("00912345678")
							.build())
					.build());
			
			Empresa empresa = empresaService.cadastrar(Empresa.builder()
					.nome("Bob's")
					.cnpj(465798465)
					.categoria(CategoriaEmpresa.HAMBURGUER)
					.avaliacao(2)
					.build());
			
			Funcionario funcionario = funcionarioService.cadastrar(
					Funcionario.builder()
					.senha("admin")
					.pessoa(cliente.getPessoa())
					.empresa(empresa)
					.build());
			
			Produto produtoDoubleChesse = produtoService.cadastrar(Produto.builder()
					.nome("Double Cheese")
					.preco(10)
					.empresa(empresa)
					.build());
			
			Produto produtoCocaCola = produtoService.cadastrar(Produto.builder()
					.nome("Coca Cola")
					.preco(3)
					.estoque(100)
					.empresa(empresa)
					.build());
			
			Pedido pedido = pedidoService.cadastrar(Pedido.builder()
					.numero(1)
					.dataHora(LocalDateTime.parse("2022-09-01T20:30:00"))
					.quantidadeProduto(2)
					.total(20)
					.formaPagamento(FormaPagamento.DINHEIRO)
					.cliente(cliente)
					.produto(produtoDoubleChesse)
					.build());
			
			Pedido pedido1 = pedidoService.cadastrar(Pedido.builder()
					.numero(1)
					.dataHora(LocalDateTime.parse("2022-09-01T20:30:00"))
					.quantidadeProduto(1)
					.total(3)
					.formaPagamento(FormaPagamento.DINHEIRO)
					.cliente(cliente)
					.produto(produtoCocaCola)
					.build());

		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(IFomeApplication.class, args);
	}

}
