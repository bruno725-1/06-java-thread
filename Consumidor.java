import java.util.Arrays;

public class Consumidor {
  public void consumir(Tarefa[] tarefas) {
    int alta = 0;
    int media = 0;
    int baixa = 0;

    Arrays.sort(tarefas, (t1, t2) -> Integer.compare(
        t1.getPrioridade().getValor(),
        t2.getPrioridade().getValor()));

    System.out.println("Executando por prioridade:");

    for (Tarefa tarefa : tarefas) {
      try {
        tarefa.start();
        tarefa.join();

        switch (tarefa.getPrioridade()) {
          case ALTA:
            alta++;
            break;

          case MEDIA:
            media++;
            break;

          case BAIXA:
            baixa++;
            break;
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.printf("Resumo: %d ALTA, %d MEDIA, %d BAIXA\n", alta, media, baixa);
  }
}