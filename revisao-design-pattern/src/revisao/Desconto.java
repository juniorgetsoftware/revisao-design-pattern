package revisao;

public interface Desconto {

	double calcularDesconto(Orcamento orcamento);

	void setProximo(Desconto desconto);
}
