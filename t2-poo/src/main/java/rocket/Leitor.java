package rocket;
import java.io.*;
import java.util.*;

// classe para formatar o arquivo .csv em uma matriz manipulavel
public class Leitor{

    private List<String[]> listaLinhas = new ArrayList<String[]>();
    private String linha;
    private String[][] matrizString;
    private int tamLinha, tamColuna;

    // acessar o arquivo .csv e construir uma matriz
    public Leitor(String str){
        if(str.equals("C")){
            try(BufferedReader data = new BufferedReader(new FileReader("t2-poo\\composicao.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamLinha = itensLinha.length;
                    tamColuna++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(str.equals("L")){
            try(BufferedReader data = new BufferedReader(new FileReader("t2-poo\\locomotiva.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamLinha = itensLinha.length;
                    tamColuna++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(str.equals("V")){
            try(BufferedReader data = new BufferedReader(new FileReader("t2-poo\\vagoes.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamLinha = itensLinha.length;
                    tamColuna++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }

        for(int i = 0; i < tamLinha; i++){
            for(int j = 0; j < tamColuna-1; j++){
                matrizString[i][j] = listaLinhas.get(i)[j];
            }
        }
    }

    public String[][] getMatriz(){
        return matrizString;
    }
}