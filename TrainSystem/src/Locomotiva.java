/**
 * A classe Locomotiva representa uma locomotiva que pode ser engatada em um trem.
 * Cada locomotiva possui um identificador, um peso máximo que conseque trancionar, uma quantidade máxima de vagões que consegue tracionar
 * e pode ser engatada em um trem.
 *
 * @author 4gu1rr3 (Yasmin Aguirre)
 * @version 1.0
 */
public class Locomotiva extends Carro{
    private double maxPeso;
    private int maxVagoes;

    /**
     * Construtor da classe Locomotiva.
     * @param id
     * @param maxPeso
     * @param maxVagoes
     */
    public Locomotiva(int id, int idTrem, double maxPeso, int maxVagoes) {
        super(id, idTrem);
        this.maxPeso = maxPeso;
        this.maxVagoes = maxVagoes;
    }

    /**
     * Obtém o identificador da Locomotiva.
     *
     * @return O identificador da locomotiva.
     */
    public int getId() {
        return super.getId();
    }

    /**
     * Obtém o peso máximo que a locomotiva consegue tracionar.
     *
     * @return O peso máximo que a locomotiva consegue tracionar.
     */
    public double getMaxPeso() {
        return maxPeso;
    }

    /**
     * Obtém o máximo de vagões que a locomotiva consegue tracionar.
     *
     * @return O máximo de vagões que a locomotiva consegue tracionar.
     */
    public int getMaxVagoes() {
        return maxVagoes;
    }

    /**
     * Obtém o identificador do trem ao qual a locomotiva está engatada.
     *
     * @return O identificador do trem ao qual a locomotiva está engatada, ou 0 se não estiver engatada em nenhum trem.
     */
    public int getIdTrem() {
        return super.getIdTrem();
    }

    /**
     * Define o identificador do trem ao qual a locomotiva está engatada.
     *
     * @param IdTrem
     */
    public void setIdTrem(int IdTrem) {
        super.setIdTrem(IdTrem);
    }

    /**
     * Retorna uma representação em formato de string da locomotiva.
     *
     * @return Uma string no formato "Locomotiva[L{id}, Capacidade = {maxPeso}, Máximo de Vagões{maxVagoes}]".
     */
    public String toString() {
        return super.toString() + "Locomotiva, Capacidade = " + maxPeso + ", Máximo de Vagões = " + maxVagoes + "]";
    }
}
