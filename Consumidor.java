public class Consumidor {
  private final int maxThread;

  public Consumidor(int maxThread) {
    this.maxThread = maxThread;
  }

  public double consumir(Tarefa[] tarefas) {
    int i, j, iteracao, resto;

    long inicio = System.currentTimeMillis();

    iteracao = tarefas.length / maxThread;
    resto = tarefas.length % maxThread;

    System.out.println("Tamanho do vetor de tarefas: " + tarefas.length);
    System.out.println("Número máximo de threads: " + maxThread);
    System.out.println("Iterações: " + iteracao);
    System.out.println("Resto: " + resto);

    for (i = 0; i < iteracao; i++) {
      for (j = 0; j < maxThread; j++)
        try {
          tarefas[maxThread * i + j].start();
        } catch (Exception e) {
          e.printStackTrace();
        }

      for (j = 0; j < maxThread; j++)
        try {
          tarefas[maxThread * i + j].join();
        } catch (Exception e) {
          e.printStackTrace();
        }

      System.out.println("Fim da iteração: " + i);
    }

    for (j = 0; j < resto; j++)
      try {
        tarefas[maxThread * i + j].start();
      } catch (Exception e) {
        e.printStackTrace();
      }

    for (j = 0; j < resto; j++)
      try {
        tarefas[maxThread * i + j].join();
      } catch (Exception e) {
        e.printStackTrace();
      }

    long fim = System.currentTimeMillis();
    return (fim - inicio) / 1000.0;
  }
}