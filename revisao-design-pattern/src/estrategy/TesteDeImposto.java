package estrategy;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteDeImposto {

	private CalculadorDeImposto calculadora;
	private Orcamento orcamento;

	@Before
	public void setUp() {
		this.calculadora = new CalculadorDeImposto();
		this.orcamento = new Orcamento(500.00);
	}

	@After
	public void tearDown() {
		this.calculadora = null;
		this.orcamento = null;
	}

	@Test
	public void deveCalcularImpostoICMS() {
		Imposto icms = new ICMS();
		double valorImposto = calculadora.realizarCalculo(orcamento, icms);
		assertEquals(50.0, valorImposto, 0.0001);
	}

	@Test
	public void deveCalcularImpostoISS() {
		Imposto iss = new ISS();
		double valorImposto = calculadora.realizarCalculo(orcamento, iss);
		assertEquals(30.0, valorImposto, 0.0001);
	}

	@Test
	public void deveCalcularImpostoCOFINS() {
		Imposto confins = new COFINS();
		double valorImposto = calculadora.realizarCalculo(orcamento, confins);
		assertEquals(15.0, valorImposto, 0.0001);
	}
}
