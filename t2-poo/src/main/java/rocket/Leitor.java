package rocket;
import java.io.*;
import java.util.*;

import javax.annotation.processing.SupportedOptions;

// classe para formatar o arquivo .csv em uma matriz manipulavel
public class Leitor{

    private List<String[]> listaLinhas = new ArrayList<String[]>();
    private String linha;
    private String[][] matrizString;
    private int tamLinha, tamColuna;

    // acessar o arquivo .csv e construir uma matriz
    public Leitor(String str){
        if(str.equals("C")){
            try(BufferedReader data = new BufferedReader(new FileReader("composicao.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamColuna = itensLinha.length;
                    tamLinha++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(str.equals("L")){
            try(BufferedReader data = new BufferedReader(new FileReader("locomotiva.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamColuna = itensLinha.length;
                    tamLinha++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(str.equals("V")){
            try(BufferedReader data = new BufferedReader(new FileReader("vagoes.csv"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.split(",");
                    listaLinhas.add(itensLinha);
                    tamColuna = itensLinha.length;
                    tamLinha++;
                }
                data.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }

        matrizString = new String[tamLinha][tamColuna];

        for(int i = 0; i < tamLinha; i++){
            for(int j = 0; j < tamColuna; j++){
                matrizString[i][j] = listaLinhas.get(i)[j];
            }
        }
    }

    public String[][] getMatriz(){
        return matrizString;
    }
}