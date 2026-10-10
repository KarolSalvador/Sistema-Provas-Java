public class QuestaoMultiplaEscolha extends Questao {
    private String[] alternativas;
    private String alternativaCorreta;

    public QuestaoMultiplaEscolha(String enunciado, double valor, String[] alternativas, String alternativaCorreta) {
        super(enunciado, valor);
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public String getEnunciado() {
        String textoCompleto = super.getEnunciado() + "\n";
        for (String alternativa : alternativas) {
            textoCompleto += alternativa + "\n";
        }
        return textoCompleto;
    }

    @Override
    public double corrigir(String resposta) {
        if (resposta != null && !resposta.trim().isEmpty()) {
            // Pega a primeira letra da resposta digitada pelo usuário e deixa maiúscula
            String letraDigitada = resposta.trim().substring(0, 1).toUpperCase();
            
            // Pega a primeira letra da alternativa correta cadastrada
            String letraCorreta = this.alternativaCorreta.trim().substring(0, 1).toUpperCase();
            
            if (letraDigitada.equals(letraCorreta)) {
                return getValor();
            }
        }
        return 0.0;
    }
}
