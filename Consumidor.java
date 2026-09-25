public class Consumidor {
  private int tarefasExecutadas;
  public static final int MAX_THREAD = 3;

  public void consumir(Tarefa[] tarefas) {
    int i, j, iteracao, resto;
    long inicio = System.currentTimeMillis();
    tarefasExecutadas = 0;

    /*
     * Exemplo:
     * Tamanho do vetor de tarefas: 8
     * MAX_THREAD: 3
     * iteracao: 8 / 3 = 2
     * resto: 8 % 3 = 2
     */
    iteracao = tarefas.length / MAX_THREAD;
    resto = tarefas.length % MAX_THREAD;

    System.out.println("Tamanho do vetor de tarefas: " + tarefas.length);
    System.out.println("Número máximo de threads: " + MAX_THREAD);
    System.out.println("Iterações: " + iteracao);
    System.out.println("Resto: " + resto);

    for (i = 0; i < iteracao; i++) {
      for (j = 0; j < MAX_THREAD; j++)
        try {
          tarefas[MAX_THREAD * i + j].start();
        } catch (Exception e) {
          e.printStackTrace();
        }

      for (j = 0; j < MAX_THREAD; j++)
        try {
          tarefas[MAX_THREAD * i + j].join();
          tarefasExecutadas++;
        } catch (Exception e) {
          e.printStackTrace();
        }

      System.out.println("Fim da iteração: " + i);
    }

    for (j = 0; j < resto; j++)
      try {
        tarefas[MAX_THREAD * i + j].start();
      } catch (Exception e) {
        e.printStackTrace();
      }

    for (j = 0; j < resto; j++)
      try {
        tarefas[MAX_THREAD * i + j].join();
        tarefasExecutadas++;
      } catch (Exception e) {
        e.printStackTrace();
      }

      long fim = System.currentTimeMillis();
      double tempoTotal = (fim - inicio) / 1000.0;
      System.out.println("Total de tarefas executadas: " + tarefasExecutadas);
      System.out.println("Tempo total: " + tempoTotal + " segundos");
  }

  public int getTarefasExecutadas() {
    return tarefasExecutadas;
  }
}
