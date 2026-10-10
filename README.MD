**Conceitos Aplicados no Sistema de Provas**

**1. Abstração**

Utilizamos a classe `Questao` como uma abstração para representar o conceito genérico de uma pergunta. Por ser uma classe abstrata, ela define a estrutura básica obrigatória (atributos de enunciado e valor) e o contrato do método `corrigir(String resposta)`. A classe abstrai os detalhes de como a correção é feita, focando apenas no fato de que toda questão no sistema deve possuir a capacidade de ser corrigida.

**2. Encapsulamento**
Protegemos o estado interno dos objetos definindo todos os atributos das classes como `private` (ex: `titulo` e `questoes` na classe `Prova`, ou `alternativas` na `QuestaoMultiplaEscolha`). O acesso e as modificações ocorrem exclusivamente por meio de métodos e construtores. Também aplicamos validações de regra de negócio, garantindo que o sistema lance exceções ou bloqueie a inserção de questões com valor igual ou inferior a zero no momento de adicioná-las à prova e no `setValor`.

**3. Herança**
Criamos subclasses específicas (`QuestaoMultiplaEscolha`, `QuestaoDiscursiva` e a bônus `QuestaoVerdadeiroFalso`) que utilizam a palavra-chave `extends` para herdar as características da classe mãe `Questao`. Isso evitou a repetição de código, pois os filhos reaproveitam a lógica do enunciado e do valor, adicionando apenas seus atributos e comportamentos exclusivos (como o armazenamento de uma palavra-chave esperada para a questão discursiva).

**4. Polimorfismo**
A aplicação do polimorfismo ocorre de forma central na classe `Prova`. Armazenamos questões de naturezas completamente diferentes em uma mesma lista tipada como `List<Questao>`. Durante o laço de repetição no método `aplicarProva()`, o sistema chama o método `q.corrigir(resposta)`. Devido ao polimorfismo, o programa identifica dinamicamente em tempo de execução qual é o tipo do objeto e executa a lógica de correção apropriada de cada subclasse, eliminando qualquer necessidade de checar manualmente o tipo da questão com `if` e `instanceof`.