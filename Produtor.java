import java.util.Random;

public class Produtor {
    public Tarefa[] produzir(int quantidade) {
        Tarefa[] tarefas = new Tarefa[quantidade];

        Random aleatorio = new Random();
        Prioridade[] prioridades = Prioridade.values();

        for(int i = 0; i < quantidade; i++) {
            Prioridade prioridade =
                prioridades[aleatorio.nextInt(prioridades.length)];

            tarefas[i] = new Tarefa(
                "Tarefa " + i, prioridade
            );
        }
        return tarefas;
    }
}
