package teste.templatemethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import revisao.CalculadorDeImposto;
import revisao.ICPP;
import revisao.IKCV;
import revisao.Imposto;
import revisao.Item;
import revisao.Orcamento;

public class TestTemplateDeImposto {

	private Orcamento orcamento;
	private CalculadorDeImposto calculadora;

	@Before
	public void setUp() {
		orcamento = new Orcamento();
		calculadora = new CalculadorDeImposto();
	}

	@After
	public void tearDown() {
		orcamento = null;
		calculadora = null;
	}

	@Test
	public void deveCalcularImpostoMaximoParaICPP() {
		orcamento.add(new Item("Smartphone", 600.0));
		Imposto icpp = new ICPP();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(42, imposto, 0.001);
	}

	@Test
	public void deveCalcularImpostoMinimoParaICPP() {
		orcamento.add(new Item("Headphone", 250.0));
		Imposto icpp = new ICPP();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(12.5, imposto, 0.001);
	}

	@Test
	public void deveCalcularImpostoMinimoParaIKCV() {
		orcamento.add(new Item("Livro", 300.0));
		Imposto icpp = new IKCV();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(18, imposto, 0.001);
	}

	@Test
	public void deveCalcularImpostoMaximoParaIKCV() {
		orcamento.add(new Item("Memória RAM 8GB", 850.0));
		Imposto icpp = new IKCV();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(85, imposto, 0.001);
	}

	@Test
	public void naoDeveCalcularImpostoMaximoParaIKCVSemItemComValorAcimaDe100Reais() {
		orcamento.add(new Item("Lâmpada Led", 20.0));
		orcamento.add(new Item("Headphone", 50.0));
		orcamento.add(new Item("Teclado", 90.0));
		orcamento.add(new Item("Mouse", 60.0));
		orcamento.add(new Item("Livro", 69.90));
		orcamento.add(new Item("Case laptop", 99.0));
		orcamento.add(new Item("Case smartphone", 50.0));
		orcamento.add(new Item("Calculadora", 50.0));
		orcamento.add(new Item("Assinatura cursos", 99.0));

		Imposto icpp = new IKCV();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(35.274, imposto, 0.001);
	}

	@Test
	public void naoDeveCalcularImpostoMaximoParaIKCVSemTotalAcimaDe500Reais() {
		orcamento.add(new Item("Lâmpada Led", 20.0));
		orcamento.add(new Item("Teclado", 120.0));
		orcamento.add(new Item("Mouse", 80.0));

		Imposto icpp = new IKCV();
		double imposto = calculadora.realizarCalculo(orcamento, icpp);
		Assert.assertEquals(13.2, imposto, 0.001);
	}

}
