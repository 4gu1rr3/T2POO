import java.util.*;
public class GaragemLocomotivas {
    private static ArrayList<Locomotiva> garagemLocomotiva = new ArrayList<Locomotiva>();
    public GaragemLocomotivas(){
        Locomotiva locomotiva1 = new Locomotiva(1, 2000, 10);
        garagemLocomotiva.add(locomotiva1);
        Locomotiva locomotiva2 = new Locomotiva(2, 2500, 8);
        garagemLocomotiva.add(locomotiva2);
        Locomotiva locomotiva3 = new Locomotiva(3, 3000, 12);
        garagemLocomotiva.add(locomotiva3);
    }

    public static void removeLocomotiva(Locomotiva locomotiva) {
        int count = 0;
        for(Locomotiva l : garagemLocomotiva){
            if(l == locomotiva){
                garagemLocomotiva.remove(count);
                break;
            }
            count++;
        };
    }

    public static void addLocomotiva(Locomotiva locomotiva) {
        garagemLocomotiva.add(locomotiva);
    }

    /**
     * Verifica se o identificador da locomotiva informada pelo usuário existe.
     * @param id
     * @return Retorna true se existir e false se não existir.
     */
    public static boolean verificaIdLocomotiva(int id){
        for(Locomotiva l: garagemLocomotiva){
            if (l.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static Locomotiva getLocomotiva(int idLocomotiva) {
        int count = 0;
        int posicao = 0;
        for(Locomotiva l : garagemLocomotiva){
            if(l.getId() == idLocomotiva){
                posicao = count;
            }
            count++;
        }
        return garagemLocomotiva.get(posicao);
    }

    public String toString() {
        String retorno = "";
        for(Locomotiva l : garagemLocomotiva){
            retorno += l.toString() + "\n";
        }
        return retorno;
    }
}
