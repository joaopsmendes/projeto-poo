import java.util.Scanner;

public class MenuInicial {
    public MenuInicial(){
        initMenuInicial();
    }

    public void initMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        printMenuInicial();

        while(!quit){
            try{
                int selecao = scanner.nextInt();
                if(selecao == 1){
                    Jogo jogo = new Jogo(0, Jogo.Estado.POR_INICIAR, Tester.getTrofense(), Tester.getBraga(), 1, 0, Tester.getTrofense().getJogadores().subList(0, 11), Tester.getBraga().getJogadores().subList(0, 11));
                    System.out.println(jogo.toString());
                }else if(selecao == 2){
                    // CARREGAR JOGO
                }else if(selecao == 3){
                    quit = true;
                }else{
                    System.out.println("Opçao invalida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Introduza um numero.");
            }
        }
        scanner.close();
    }

    public void printMenuInicial(){
        System.out.println("+------------------------------+");
        System.out.println("|        Football Manager      |");
        System.out.println("+------------------------------+\n");
        System.out.println("[1] - Novo Jogo");
        System.out.println("[2] - Carregar Jogo");
        System.out.println("[3] - Sair\n");
    }
}
