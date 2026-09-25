public class Produtor {
    public Tarefa[] produzir(int quantidade) {
        Tarefa[] tarefas = new Tarefa[quantidade];

        for(int i = 0; i < quantidade; i++)
            tarefas[i] = new Tarefa("Terefa " + i);

        return tarefas;
    }
}
