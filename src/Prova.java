import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prova {
    private String titulo;
    private String disciplina;
    private List<Questao> questoes;

    public Prova(String titulo, String disciplina) {
        this.titulo = titulo;
        this.disciplina = disciplina;
        this.questoes = new ArrayList<>();
    }

    public void adicionarQuestao(Questao questao) {
        // Validação extra garantindo que não entre questão zerada ou negativa na prova
        if (questao.getValor() > 0) {
            questoes.add(questao);
        } else {
            System.out.println("Erro: A questão possui valor inválido e não foi adicionada.");
        }
    }

    // Consulta a quantidade de questões cadastradas
    public int consultarQuantidadeQuestoes() {
        return questoes.size();
    }

    // Calcula o valor total varrendo a lista
    public double calcularValorTotal() {
        double total = 0;
        for (Questao q : questoes) {
            total += q.getValor();
        }
        return total;
    }

    public void aplicarProva() {
        Scanner scanner = new Scanner(System.in);
        double notaFinal = 0;
        double valorTotal = calcularValorTotal();
        
        // Lista para guardar as strings do resultado individual de cada questão
        List<String> relatorioIndividual = new ArrayList<>();

        System.out.println("PROVA: " + titulo);
        System.out.println("DISCIPLINA: " + disciplina);
        System.out.println("Quantidade de questões: " + consultarQuantidadeQuestoes());
        System.out.println("Valor total da prova: " + valorTotal);
        System.out.println("=======================================\n");

        for (int i = 0; i < questoes.size(); i++) {
            Questao q = questoes.get(i);
            
            System.out.println("Questão " + (i + 1) + " - Valor: " + q.getValor());
            System.out.println(q.getEnunciado());
            System.out.print("Resposta: ");
            String resposta = scanner.nextLine();
            
            // Corrige a questão usando polimorfismo (cada uma resolve do seu jeito)
            double notaObtida = q.corrigir(resposta);
            notaFinal += notaObtida;

            // Salva o desempenho da questão atual no relatório
            relatorioIndividual.add("Questão " + (i + 1) + ": " + notaObtida + "/" + q.getValor());
            System.out.println();
        }

        exibirRelatorio(relatorioIndividual, notaFinal, valorTotal);
        scanner.close();
    }

    private void exibirRelatorio(List<String> relatorioIndividual, double notaFinal, double valorTotal) {
        System.out.println("RESULTADO");
        System.out.println("===================");
        for (String linha : relatorioIndividual) {
            System.out.println(linha); // Imprime a nota de cada questão
        }
        System.out.println("NOTA FINAL: " + notaFinal + "/" + valorTotal);
    }
}