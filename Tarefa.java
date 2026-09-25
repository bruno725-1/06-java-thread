public class Tarefa extends Thread {
    private final Prioridade prioridade;
    private String nome;

    public Tarefa(String nome, Prioridade prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    @Override
    public void run() {
        try {
            // A thread tenta dormir por 1 segundo.
            Thread.sleep(1000);
            System.out.println(
                getName() + " (" + prioridade + ") realizada com sucesso."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nome + " realizada com sucesso.");
    }
}
