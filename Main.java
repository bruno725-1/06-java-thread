public class Main {
  public static void main(String[] args) {
    Produtor produtor = new Produtor();

    Consumidor consumidor2threads = new Consumidor(2);
    Consumidor consumidor4threads = new Consumidor(4);
    Consumidor consumidor6threads = new Consumidor(6);

    Tarefa[] tarefas2threads = produtor.produzir(8);
    double tempo2 = consumidor2threads.consumir(tarefas2threads);
    System.out.println("Teste com 2 threads: " + tempo2 + " segundos\n");

    Tarefa[] tarefas4threads = produtor.produzir(8);
    double tempo4 = consumidor4threads.consumir(tarefas4threads);
    System.out.println("Teste com 4 threads: " + tempo4 + " segundos\n");

    Tarefa[] tarefas6threads = produtor.produzir(8);
    double tempo6 = consumidor6threads.consumir(tarefas6threads);
    System.out.println("Teste com 6 threads: " + tempo6 + " segundos\n");

    double menorTempo = tempo2;
    int melhorConfiguracao = 2;

    if (tempo4 < menorTempo) {
      menorTempo = tempo4;
      melhorConfiguracao = 4;
    }

    if (tempo6 < menorTempo) {
      menorTempo = tempo6;
      melhorConfiguracao = 6;
    }

    System.out.println(
        "Configuração mais eficiente: "
        + melhorConfiguracao
        + " threads ("
        + menorTempo
        + "s)"
    );

    System.out.println("FIM DO PROGRAMA!");
  }
}