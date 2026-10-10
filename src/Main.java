import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Testando a parte Questão de Múltipla Escolha:");

        // Testando a criação de uma questão de múltipla escolha
        String[] alternativas = {"A) Java", "B) Python", "C) C++", "D) JavaScript"};
        QuestaoMultiplaEscolha q1 = new QuestaoMultiplaEscolha(
                "Qual linguagem estamos usando neste projeto?",
                1.5,
                alternativas,
                "A) Java"
        );

        // Testando o encapsulamento (tentando colocar valor inválido - deve disparar erro)
        try {
            q1.setValor(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de encapsulamento funcionou: " + e.getMessage());
        }

        // Testando a correção manual dela
        double nota = q1.corrigir("A) Java");
        System.out.println("Enunciado:\n" + q1.getEnunciado());
        System.out.println("Nota obtida no teste isolado: " + nota);
        
        System.out.println("\n-------------------------------------------------\n");

        System.out.println("=======================================");
        System.out.println("    SISTEMA DE CRIAÇÃO DE PROVAS       ");
        System.out.println("=======================================");
        
        // O sistema permite criar a prova informando título e disciplina interativamente
        System.out.print("Informe o título da prova (ex: Avaliação NP1): ");
        String tituloProva = entrada.nextLine();
        
        System.out.print("Informe a disciplina: ");
        String disciplinaProva = entrada.nextLine();

        // 1. Instancia a classe gerenciadora (Prova) com os dados informados
        Prova provaNp1 = new Prova(tituloProva, disciplinaProva);

        System.out.println("\n[Prova criada com sucesso!]");
        System.out.println("Adicionando questões ao banco de dados da prova...\n");

        // 2. Cria a sua questão discursiva e a de verdadeiro ou falso
        QuestaoDiscursiva q2 = new QuestaoDiscursiva(
            "Explique, com suas palavras, o conceito de encapsulamento.", 
            2.0, 
            "proteger" 
        );

        QuestaoVerdadeiroFalso q3 = new QuestaoVerdadeiroFalso(
            "A linguagem Java é orientada a objetos. (V/F)", 
            1.5, 
            "V"
        );

        // 3. Adiciona a questão q1, a q2 e a q3 (bônus)
        provaNp1.adicionarQuestao(q1);
        provaNp1.adicionarQuestao(q2);
        provaNp1.adicionarQuestao(q3);

        System.out.println("Pressione ENTER para iniciar a aplicação da prova aos alunos...");
        entrada.nextLine(); // Segura a tela para você ler o que aconteceu antes de começar

        // 4. Inicia a aplicação real no console
        provaNp1.aplicarProva();
        
        entrada.close();
    }
}