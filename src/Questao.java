public abstract class Questao {
    private String enunciado;
    private double valor;

    // Construtor com validação (Encapsulamento)
    public Questao(String enunciado, double valor) {
        this.enunciado = enunciado;
        setValor(valor);
    }

    // Métodos Get e Set
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public double getValor() {
        return valor;
    }

    // Método setValor com validação de encapsulamento exigida pelo trabalho
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da questão deve ser maior que zero!");
        }
        this.valor = valor;
    }

    // Método abstrato (Polimorfismo)
    public abstract double corrigir(String resposta);
}