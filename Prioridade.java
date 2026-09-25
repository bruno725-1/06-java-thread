public enum Prioridade {
    ALTA(1),
    MEDIA(2),
    BAIXA(3);
    private int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
