import java.util.*;
public class GaragemCarros {
    
    private ArrayList<Carro> garagemCarro = new ArrayList<Carro>();
    public GaragemCarros(){
        Carro Carro1 = new Carro(1, 2000, 10);
        garagemCarro.add(Carro1);
        Carro Carro2 = new Carro(2, 2500, 8);
        garagemCarro.add(Carro2);
        Carro Carro3 = new Carro(3, 3000, 12);
        garagemCarro.add(Carro3);
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

    public String toString() {
        String retorno = "";
        for(Carro c : garagemCarro){
            retorno += c.toString() + "\n";
        }
        return retorno;
    }
}
