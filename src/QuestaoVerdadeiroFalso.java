public class QuestaoVerdadeiroFalso extends Questao {
    private String respostaCorreta; 

    public QuestaoVerdadeiroFalso(String enunciado, double valor, String respostaCorreta) {
        super(enunciado, valor);
        // Garante que será V ou F maiúsculo para facilitar a correção
        this.respostaCorreta = respostaCorreta.toUpperCase();
    }

    @Override
    public double corrigir(String resposta) {
        if (resposta != null && !resposta.trim().isEmpty()) {
            // Pega a primeira letra da resposta do aluno
            String letraDigitada = resposta.trim().substring(0, 1).toUpperCase();
            if (letraDigitada.equals(this.respostaCorreta)) {
                return getValor();
            }
        }
        return 0.0;
    }
}