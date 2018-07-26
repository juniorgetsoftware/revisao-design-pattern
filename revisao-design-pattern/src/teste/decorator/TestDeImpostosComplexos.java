package teste.decorator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import revisao.ICMS;
import revisao.ICPP;
import revisao.ISS;
import revisao.Imposto;
import revisao.Item;
import revisao.Orcamento;

public class TestDeImpostosComplexos {

	private Orcamento orcamento;

	@Before
	public void setUp() {
		orcamento = new Orcamento();
		orcamento.add(new Item("Smartphone", 500.0));
	}

	@After
	public void tearDown() {
		orcamento = null;
	}

	@Test
	public void deveTestarISS_e_ICMS() {
		Imposto i = new ISS(new ICMS());

		double valor = i.calcularImposto(orcamento);
		Assert.assertEquals(80.0, valor, 0.001);
	}

	@Test
	public void deveTestarISS_e_ICMS_e_ICPP() {
		Imposto i = new ISS(new ICMS(new ICPP()));
		double valor = i.calcularImposto(orcamento);
		Assert.assertEquals(105.0, valor, 0.001);
	}

	@Test
	public void deveTestarCalculoISS_e_ICPP() {
		Imposto i = new ISS(new ICPP());
		double valor = i.calcularImposto(orcamento);
		Assert.assertEquals(55.0, valor, 0.001);
	}
}
