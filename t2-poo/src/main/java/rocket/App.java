package rocket;

import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Patio patio = new Patio();
        Scanner scanner = new Scanner(System.in);
        GaragemCarros gc = new GaragemCarros();
        int escolhaMenu = -1;
        int tremId, id;

        System.out.println("Bem-vindo ao sistema de trens =)");

        do{
            System.out.println("\n");
            System.out.println("         Menu         ");
            System.out.println("   1. Criar trem      ");
            System.out.println("   2. Editar trem     ");
            System.out.println("   3. Listar trens    ");
            System.out.println("   4. Desfazer trem   ");
            System.out.println("   5. Sair do programa");
            System.out.println("\n");
            System.out.print("Digite o número da opção desejada: ");
            escolhaMenu = scanner.nextInt();
            while(escolhaMenu < 1 || escolhaMenu > 5){
                System.out.println("Opção inválida. Digite novamente: ");
            }
            if(escolhaMenu == 1){
                System.out.println("Qual o identificador do trem? ");
                tremId = scanner.nextInt();
                while(Patio.verificaIdTrem(tremId) == true){
                    System.out.println("Já existe um trem com esse identificador. Digite novamente: ");
                    tremId = scanner.nextInt();
                }
                System.out.println("Qual o identificador da primeira locomotiva? ");
                id = scanner.nextInt();
                while(gc.verificaIdCarro(id) == false || (gc.getCarro(id)) instanceof Vagao){
                    System.out.println("Essa locomotiva não está disponível. Digite novamente: ");
                    id = scanner.nextInt();
                }
                Locomotiva locoadd = (Locomotiva) gc.getCarro(id);
                patio.criaTrem(tremId,locoadd,gc);
                System.out.println("Trem criado com sucesso! =)");
            }
            if(escolhaMenu == 2){
                do{
                    System.out.println("\n");
                    System.out.println("          Menu de Opções            ");
                    System.out.println("   1. Inserir uma locomotiva      ");
                    System.out.println("   2. Inserir um vagão     ");
                    System.out.println("   3. Remover o último elemento   ");
                    System.out.println("   4. Listar locomotivas livres   ");
                    System.out.println("   5. Listar vagões livres   ");
                    System.out.println("   6. Voltar");
                    System.out.println("\n");
                    System.out.print("Digite o número da opção desejada: ");
                    escolhaMenu = scanner.nextInt();
                    while(escolhaMenu < 1 || escolhaMenu > 6){
                        System.out.println("Opção inválida. Digite novamente: ");
                    }
                    if(escolhaMenu == 1){
                        System.out.println("Qual o identificador do trem em que deseja adicionar? ");
                        tremId = scanner.nextInt();
                        while(Patio.verificaIdTrem(tremId) == false){
                            System.out.println("Não existe um trem com esse identificador. Digite novamente: ");
                            tremId = scanner.nextInt();
                        }
                        System.out.println("Qual o identificador da locomotiva? ");
                        id = scanner.nextInt();
                        while(gc.verificaIdCarro(id) == false || (gc.getCarro(id)) instanceof Vagao){
                            System.out.println("Essa locomotiva não está disponível. Digite novamente: ");
                            id = scanner.nextInt();
                        }
                        Locomotiva locoadd = (Locomotiva) gc.getCarro(id);
                        Trem tremadd = Patio.getTrem(tremId);
                        boolean engatado = tremadd.engataCarro(locoadd,gc);
                        if(engatado == true) {
                            System.out.println("Locomotiva adicionada com sucesso! =)");
                        }
                        else {
                            System.out.println("Não foi possível adicionar a locomotiva. Já existe um vagão engatado =(");
                        }
                    }
                    if(escolhaMenu == 2){
                        System.out.println("Qual o identificador do trem em que deseja adicionar? ");
                        tremId = scanner.nextInt();
                        while(Patio.verificaIdTrem(tremId) == false){
                            System.out.println("Não existe um trem com esse identificador. Digite novamente: ");
                            tremId = scanner.nextInt();
                        }
                        System.out.println("Qual o identificador do vagão? ");
                        id = scanner.nextInt();
                        while(gc.verificaIdCarro(id) == false || (gc.getCarro(id)) instanceof Locomotiva){
                            System.out.println("Esse vagão não está disponível. Digite novamente: ");
                            id = scanner.nextInt();
                        }
                        Vagao vagaoAdd = (Vagao) gc.getCarro(id);
                        Trem tremadd = Patio.getTrem(tremId);
                        boolean engatado = tremadd.engataCarro(vagaoAdd, gc);
                        if(engatado == true) {
                            System.out.println("Vagão adicionado com sucesso! =)");
                        }
                        else {
                            System.out.println("Não foi possível adicionar o vagão. Capacidade máxima do trem excedida! =(");
                        }
                    }
                    if(escolhaMenu == 3){
                        System.out.println("Qual o identificador do trem que deseja editar? ");
                        tremId = scanner.nextInt();
                        while(Patio.verificaIdTrem(tremId) == false){
                            System.out.println("Não existe um trem com esse identificador. Digite novamente: ");
                            tremId = scanner.nextInt();
                        }
                        Trem tremadd = Patio.getTrem(tremId);
                        if(tremadd.getQuantLocomotiva()<2){
                            System.out.println("Não é possível retirar o último elemento do trem. =(");
                        }
                        else{
                            tremadd.desengataCarro(gc);
                        }
                        System.out.println("Elemento removido com sucesso! =)");
                    }
                    if (escolhaMenu == 4) {
                        System.out.println("Locomotivas disponíveis:");
                        System.out.println(gc.toString(1));
                        System.out.println("6. Voltar");
                        scanner.next();
                        scanner.nextLine();

                    }
                    if (escolhaMenu == 5) {
                        System.out.println("Vagoes disponíveis:");
                        System.out.println(gc.toString(2));
                        System.out.println("6. Voltar");
                        scanner.next();
                        scanner.nextLine();
                    }
                }while(escolhaMenu != 6);
            }
            if(escolhaMenu == 3){
                System.out.println(patio.toString());
                System.out.println("6. Voltar");
                scanner.next();
                scanner.nextLine();
            }
            if (escolhaMenu == 4){
                System.out.println("Qual o identificador do trem que será removido? ");
                tremId = scanner.nextInt();
                while(Patio.verificaIdTrem(tremId) == false){
                    System.out.println("Não existe um trem com esse identificador. Digite novamente: ");
                    tremId = scanner.nextInt();
                }
                patio.desfazTrem(tremId,gc);
                System.out.println("Trem removido com sucesso! =)");
            }
        }while(escolhaMenu != 5);
        System.out.println("Até a próxima =)");
        scanner.close();
    }
}