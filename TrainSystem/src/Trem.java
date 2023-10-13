import java.util.*;
public class Trem {
    private int id;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;
    private boolean vagaoEngatado;
    private double capacidadeTotalPeso = 0;
    private int capacidadeTotalVagoes = 0;

    /**
     * Construtor da classe Trem.
     * @param id
     * @param locomotiva
     */
    public Trem(int id, Locomotiva locomotiva){
        this.id = id;
        this.locomotivas = new ArrayList<Locomotiva>();
        this.vagoes = new ArrayList<Vagao>();
        engataLocomotiva(locomotiva);
    }

    public int getId() {
        return id;
    }

    public int getQuantLocomotiva() {
        return locomotivas.size();
    }

    public int getQuantVagoes() {
        return vagoes.size();
    }

    public Locomotiva getLocomotiva(int idLocomotiva) {
        int index = 0;
        int posicao = 0;
        for(Locomotiva l : locomotivas){
            if(l.getId() == idLocomotiva){
                posicao = index;
            }
            index++;
        }
        return locomotivas.get(posicao);
    }

    public Locomotiva getLocomotivaByPos(int posicao) {
        return locomotivas.get(posicao);
    }

    public Vagao getVagao(int idVagao) {
        int index = 0;
        int posicaoB = 0;
        for(Vagao v : vagoes){
            if(v.getId() == idVagao){
                posicaoB = index;
            }
            index++;
        }
        return vagoes.get(posicaoB);
    }

    public Vagao getVagaoByPos(int posicao) {
        return vagoes.get(posicao);
    }

    public boolean engataVagao(Vagao vagao) {
        if (this.capacidadeTotalPeso > vagao.getCapacidade() && this.capacidadeTotalVagoes > 0){
            vagoes.add(vagao);
            vagaoEngatado = true;
            vagao.setIdTrem(this.id);
            this.capacidadeTotalPeso -= vagao.getCapacidade();
            this.capacidadeTotalVagoes -= 1;
            GaragemVagoes.removeVagao(vagao);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        if (vagaoEngatado == false) {
            locomotivas.add(locomotiva);
            locomotiva.setIdTrem(this.id);
            this.capacidadeTotalPeso += locomotiva.getMaxPeso();
            this.capacidadeTotalVagoes += locomotiva.getMaxVagoes();
            if(locomotivas.size()>1){
                this.capacidadeTotalPeso = capacidadeTotalPeso * 0.9;
                this.capacidadeTotalVagoes = (int) (capacidadeTotalVagoes * 0.9);
            }
            GaragemLocomotivas.removeLocomotiva(locomotiva);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean desengataLocomotiva(Locomotiva locomotiva) {
        locomotivas.remove(locomotiva);
        locomotiva.setIdTrem(0);
        if(locomotivas.size()>1){
            this.capacidadeTotalPeso -= locomotiva.getMaxPeso() * 0.9;
            this.capacidadeTotalVagoes -= locomotiva.getMaxVagoes() * 0.9;
        }
        else{
            this.capacidadeTotalPeso -= locomotiva.getMaxPeso();
            this.capacidadeTotalVagoes -= locomotiva.getMaxVagoes();
        }
        GaragemLocomotivas.addLocomotiva(locomotiva);
        return true;
    }

    public boolean desengataVagao(Vagao vagao) {
        if(vagoes.size() == 1){
            vagaoEngatado = false;
        }
        vagoes.remove(vagao);
        vagao.setIdTrem(0);
        this.capacidadeTotalPeso += vagao.getCapacidade();
        this.capacidadeTotalVagoes += 1;
        GaragemVagoes.addVagao(vagao);
        return true;
    }

    public void desengataTudo(){
        int sizeV = this.vagoes.size();
        for(int i = 0; i < sizeV; i++){
            desengataVagao(getVagao(vagoes.size()-1));
        }
        int sizeL = this.locomotivas.size();
        for(int i = 0; i < sizeL; i++){
            desengataLocomotiva(getLocomotiva(locomotivas.size()-1));
        }
    }

    public String toString() {
        String retorno = "Trem "+ id + ": ";
        for(Locomotiva l : locomotivas){
            retorno += "L" + l.getId() + " ";
        }
        for(Vagao v : vagoes){
            retorno += "V" + v.getId() + " ";
        }
        return retorno;
    }
}