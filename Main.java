public class Main {
    public static void main(String[] args) {
        Produtor produtor = new Produtor();
        Consumidor consumidor = new Consumidor();

        Tarefa[] tarefas = produtor.produzir(8);

        System.out.println("Tarefas geradas:");

        for (Tarefa tarefa : tarefas) {
            System.out.println(
                tarefa.getName() + " (" + tarefa.getPrioridade() + ")"
            );
        }

        consumidor.consumir(tarefas);

        System.out.println("FIM DO PROGRAMA!");
    }
}