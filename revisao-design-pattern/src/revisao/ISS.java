package revisao;

public class ISS implements Imposto {

	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

}
