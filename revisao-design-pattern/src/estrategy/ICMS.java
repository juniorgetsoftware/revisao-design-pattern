package estrategy;

public class ICMS implements Imposto {

	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

}
