package revisao;

public class IKCV extends TemplateDeImpostoCondicional {

	@Override
	double taxaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	double taxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	boolean deveUSarTaxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemComValorMaiorQue100Reais(orcamento);
	}

	private boolean temItemComValorMaiorQue100Reais(Orcamento orcamento) {
		return orcamento.temItemComValorMaiorQue(100.0);
	}

}
