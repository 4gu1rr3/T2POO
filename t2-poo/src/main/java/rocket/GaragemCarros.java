package rocket;

import java.util.*;
public class GaragemCarros {
    private ArrayList<Carro> garagemCarro;
    public GaragemCarros(){
        this.garagemCarro = new ArrayList<Carro>();
        garagemCarro.add(new Locomotiva(1, 2000, 10));
        garagemCarro.add(new Locomotiva(2, 2500, 8));
        garagemCarro.add(new Locomotiva(3, 3000, 12));
        garagemCarro.add(new Vagao(4, 200));
        garagemCarro.add(new Vagao(5, 250));
        garagemCarro.add(new Vagao(6, 300));
    }

    public void removeCarro(Carro Carro) {
        int count = 0;
        for(Carro c : garagemCarro){
            if(c == Carro){
                garagemCarro.remove(count);
                break;
            }
            count++;
        };
    }

    public void addCarro(Carro Carro) {
        garagemCarro.add(Carro);
    }

    /**
     * Verifica se o identificador da Carro informada pelo usuário existe.
     * @param id
     * @return Retorna true se existir e false se não existir.
     */
    public boolean verificaIdCarro(int id){
        for(Carro c: garagemCarro){
            if (c.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Carro getCarro(int idCarro) {
        int count = 0;
        int posicao = 0;
        for(Carro c : garagemCarro){
            if(c.getId() == idCarro){
                posicao = count;
            }
            count++;
        }
        return garagemCarro.get(posicao);
    }

    public String toString(int op) {
        String retorno ="";
        if(op ==1){
            for(Carro c : garagemCarro){
                if(c instanceof Locomotiva){
                    retorno += c.toString() + "\n";   
                }
            }
        }
        if(op == 2){
            for(Carro c : garagemCarro){
                if(c instanceof Vagao){
                    retorno += c.toString() + "\n";   
                }
            }
        }
        return retorno;
    }
}