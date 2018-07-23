package revisao;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	@Override
	public double calcularImposto(Orcamento orcamento) {
		if (deveUSarTaxaMaxima(orcamento)) {
			return taxaMaxima(orcamento);
		} else {
			return taxaMinima(orcamento);
		}
	}

	abstract double taxaMinima(Orcamento orcamento);

	abstract double taxaMaxima(Orcamento orcamento);

	abstract boolean deveUSarTaxaMaxima(Orcamento orcamento);

}
