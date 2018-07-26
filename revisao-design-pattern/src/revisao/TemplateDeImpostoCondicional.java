package revisao;

public abstract class TemplateDeImpostoCondicional extends Imposto {

	@Override
	public double calcularImposto(Orcamento orcamento) {
		if (deveUSarTaxaMaxima(orcamento)) {
			return taxaMaxima(orcamento) + calcularOutroimopsto(orcamento);
		} else {
			return taxaMinima(orcamento) + calcularOutroimopsto(orcamento);
		}
	}

	abstract double taxaMinima(Orcamento orcamento);

	abstract double taxaMaxima(Orcamento orcamento);

	abstract boolean deveUSarTaxaMaxima(Orcamento orcamento);

}
