public class QuestaoMultiplaEscolha extends Questao {
    private String[] alternativas;
    private String alternativaCorreta;

    public QuestaoMultiplaEscolha(String enunciado, double valor, String[] alternativas, String alternativaCorreta) {
        super(enunciado, valor);
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    @Override
    public double corrigir(String resposta) {
        // Se a resposta do aluno for igual à alternativa correta, ele ganha o valor total da questão. Senão, ganha 0.
        if (resposta != null && resposta.trim().equalsIgnoreCase(alternativaCorreta)) {
            return getValor();
        }
        return 0.0;
    }
}
