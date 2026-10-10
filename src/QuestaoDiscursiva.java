public class QuestaoDiscursiva extends Questao {
    private String palavraChaveEsperada;

    public QuestaoDiscursiva(String enunciado, double valor, String palavraChaveEsperada) {
        super(enunciado, valor);
        this.palavraChaveEsperada = palavraChaveEsperada.toLowerCase();
    }

    // Verifica se a resposta dada contém a palavra-chave.
    // Isso aplica o polimorfismo, pois a Prova chamará este método sem saber o tipo da questão.
    @Override
    public double corrigir(String resposta) {
        if (resposta != null && resposta.toLowerCase().contains(this.palavraChaveEsperada)) {
            return getValor(); 
        }
        return 0.0;
    }
}