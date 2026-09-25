public class Main {
  public static void main(String[] args) {
    Produtor produtor = new Produtor();
    Consumidor consumidor = new Consumidor();

    Tarefa[] tarefas = produtor.produzir();
    consumidor.consumir(tarefas);

    System.out.println("FIM DO PROGRAMA!");
  }
}