package revisao;

public class COFINS implements Imposto {

	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.03;
	}

}
