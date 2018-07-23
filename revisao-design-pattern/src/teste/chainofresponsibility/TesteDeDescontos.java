package teste.chainofresponsibility;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import revisao.CalculadoraDeDesconto;
import revisao.Item;
import revisao.Orcamento;

public class TesteDeDescontos {

	private Orcamento orcamento;
	private CalculadoraDeDesconto calculadora;

	@Before
	public void setUp() {
		this.orcamento = new Orcamento();
		this.calculadora = new CalculadoraDeDesconto();
	}

	@After
	public void tearDown() {
		this.orcamento = null;
		this.calculadora = null;
	}

	@Test
	public void naoDdeveGerarDesconto() {
		orcamento.add(new Item("Livro IA", 100.0));
		orcamento.add(new Item("Livro Estrutura de dados", 250.0));
		double desconto = calculadora.calcularDesconto(orcamento);
		Assert.assertEquals(0.0, desconto, 0.0001);
	}

	@Test
	public void deveCalcularCincoPorCentoDeDescontoEmOrcamentoAcimaDeQuinhentosReais() {
		orcamento.add(new Item("Livro IA", 300.0));
		orcamento.add(new Item("Livro Estrutura de dados", 250.0));
		double desconto = calculadora.calcularDesconto(orcamento);
		Assert.assertEquals(27.50, desconto, 0.0001);
	}

	@Test
	public void deveCalcularDezPorCentoDeDescontoAcimaDeCincoItens() {
		orcamento.add(new Item("Livro IA", 300.0));
		orcamento.add(new Item("Livro Engenharia de Software", 150.0));
		orcamento.add(new Item("Livro Estrutura de dados", 250.0));
		orcamento.add(new Item("Mouse", 100.0));
		orcamento.add(new Item("Teclado", 150.0));
		orcamento.add(new Item("Headphone", 550.0));

		double desconto = calculadora.calcularDesconto(orcamento);
		Assert.assertEquals(150.0, desconto, 0.0001);
	}
}
