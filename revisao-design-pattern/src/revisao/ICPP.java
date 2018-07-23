package revisao;

public class ICPP extends TemplateDeImpostoCondicional {

	@Override
	double taxaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	double taxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	boolean deveUSarTaxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

}
