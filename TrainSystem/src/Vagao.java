/**
 * A classe Vagao representa um vagão que pode ser engatado em um trem.
 * Cada vagão possui um identificador, uma capacidade e pode ser engatado em um trem.
 *
 * @author 4gu1rr3 (Yasmin Aguirre)
 * @version 1.0
 */
public class Vagao {
    private int id;
    private double capacidade;
    private int idTrem;

    /**
     * Construtor da classe Vagao.
     *
     * @param id
     * @param capacidade
     */
    public Vagao(int id, double capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.idTrem = 0;
    }

    /**
     * Obtém o identificador do vagão.
     *
     * @return O identificador do vagão.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém a capacidade do vagão.
     *
     * @return A capacidade do vagão.
     */
    public double getCapacidade() {
        return capacidade;
    }

    /**
     * Obtém o identificador do trem ao qual o vagão está engatado.
     *
     * @return O identificador do trem ao qual o vagão está engatado, ou 0 se não estiver engatado em nenhum trem.
     */
    public int getIdTrem() {
        return idTrem;
    }

    /**
     * Define o identificador do trem ao qual o vagão está engatado.
     *
     * @param idTrem
     */
    public void setIdTrem(int idTrem) {
        this.idTrem = idTrem;
    }

    /**
     * Retorna uma representação em formato de string do vagão.
     *
     * @return Uma string no formato "Vagão[v{id}, Capacidade = {capacidade}]".
     */
    public String toString() {
        return "Vagão [V" + id + ", Capacidade = " + capacidade + "]";
    }
}