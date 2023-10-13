import java.util.*;
public class GaragemVagoes {
    private static ArrayList<Vagao> garagemVagoes = new ArrayList<Vagao>();

    public GaragemVagoes(){
        Vagao vagao1 = new Vagao(1, 350);
        garagemVagoes.add(vagao1);
        Vagao vagao2 = new Vagao(2, 100);
        garagemVagoes.add(vagao2);
        Vagao vagao3 = new Vagao(3, 500);
        garagemVagoes.add(vagao3);
    }

    public static void removeVagao(Vagao vagao) {
        int index = 0;
        for(Vagao v : garagemVagoes){
            if(v == vagao){
                garagemVagoes.remove(index);
                break;
            }
            index++;
        }
    }

    public static void addVagao(Vagao vagao) {
        garagemVagoes.add(vagao);
    }

    /**
     * Verifica se o identificador do vagão informado pelo usuário existe.
     * @param id
     * @return Retorna true se existir e false se não existir.
     */
    public static boolean verificaIdVagao(int id){
        for(Vagao v: garagemVagoes){
            if (v.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static Vagao getVagao(int idVagao) {
        int index = 0;
        int posicaoB = 0;
        for(Vagao v : garagemVagoes){
            if(v.getId() == idVagao){
                posicaoB = index;
            }
            index++;
        }
        return garagemVagoes.get(posicaoB);
    }

    public String toString() {
        String retorno = "";
        for(Vagao v : garagemVagoes){
            retorno += v.toString() + "\n";
        }
        return retorno;
    }
}