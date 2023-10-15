package rocket;

import java.util.*;
public class Patio {
    static ArrayList<Trem> trens = new ArrayList<Trem>();

    /**
     * Verifica se o identificador do trem informado pelo usuário existe.
     * @param id
     * @return Retorna true se existir e false se não existir.
     */
    public static boolean verificaIdTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Trem criaTrem(int tremId, Locomotiva locomotiva, GaragemCarros gc){
        Trem t = new Trem(tremId, locomotiva, gc);
        trens.add(t);
        return t;
    }

    public void desfazTrem(int id, GaragemCarros gc){
        int count = 0;
        for(Trem t : trens){
            if (t.getId() == id){
                t.desengataTudo(gc);
                trens.remove(count);
                break;
            }
            count++;
        }
    }

    public static Trem getTrem(int idTrem) {
        int index = 0;
        int posicao = 0;
        for(Trem t : trens){
            if(t.getId() == idTrem){
                posicao = index;
            }
            index++;
        }
        return trens.get(posicao);
    }

    public String toString() {
        String retorno = "     Trens estacionados:\n";
        if(trens.size() <1){
            retorno += "- Nenhum";
        }
        for(Trem t : trens){
            retorno += "- " + t.toString() + "\n";
        }
        return retorno;
    }
}
