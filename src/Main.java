public class Main {
    public static void main(String[] args) {
        System.out.println("Testando a parte Questão de Múltipla Escolha:");

        // Testando a criação de uma questão de múltipla escolha
        String[] alternativas = {"A) Java", "B) Python", "C) C++", "D) JavaScript"};
        QuestaoMultiplaEscolha q1 = new QuestaoMultiplaEscolha(
                "Qual linguagem estamos usando neste projeto?",
                2.5,
                alternativas,
                "A) Java"
        );

        // Testando o encapsulamento (tentando colocar valor inválido - deve disparar erro)
        try {
            q1.setValor(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de encapsulamento funcionou: " + e.getMessage());
        }

        // Testando a correção
        double nota = q1.corrigir("A) Java");
        System.out.println("Enunciado: " + q1.getEnunciado());
        System.out.println("Nota obtida na questão: " + nota);
    }
}
