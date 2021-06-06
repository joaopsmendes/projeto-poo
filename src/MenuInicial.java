import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuInicial {
    public void initMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        try {
            Informacoes informacoes = Parser.parse();

            while(!quit){
                printMenuInicial();
                try{
                    int selecao = scanner.nextInt();
                    if(selecao == 1) {
                        // TODO
                    }else if(selecao == 2) {
                        printEquipas(informacoes.getEquipas());
                    }else if(selecao == 3) {
                        printJogadores(informacoes.getJogadores());
                    }else if(selecao == 4) {
                        System.out.println("Introduza o id do jogador: ");
                        int jogId = scanner.nextInt();
                        Jogador jogador = informacoes.getJogadores().get(jogId);
                        if (jogador == null) {
                            System.out.println("Id the jogador invalido");
                            continue;
                        }

                        System.out.println("Introduza o nome da equipa: ");
                        String dummy = scanner.nextLine();
                        String nomeEquipa = scanner.nextLine();
                        Equipa equipa = informacoes.getEquipas().get(nomeEquipa);
                        if (equipa == null) {
                            System.out.println("Nome de equipa invalido");
                            continue;
                        }

                        informacoes.transfereJogador(jogId, jogador, equipa.getNome());
                        System.out.println(jogador.getNome() + " foi transferido para " + equipa.getNome());
                    }else if(selecao==5){
                        //TODO: verificar
                        printJogos(informacoes.getJogos());
                    }else if(selecao == 0){
                        quit = true;
                    }else{
                        System.out.println("Opçao invalida.");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Introduza um numero.");
                }
            }
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public void printMenuInicial(){

        System.out.println(" ______          _   _           _ _    __  __                                           ");
        System.out.println("|  ____|        | | | |         | | |  |  \\/  |                                         ");
        System.out.println("| |__ ___   ___ | |_| |__   __ _| | |  | \\  / | __ _ _ __   __ _  __ _  ___ _ __        ");
        System.out.println("|  __/ _ \\ / _ \\| __| '_ \\ / _` | | |  | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|  ");
        System.out.println("| | | (_) | (_) | |_| |_) | (_| | | |  | |  | | (_| | | | | (_| | (_| |  __/ |           ");
        System.out.println("|_|  \\___/ \\___/ \\__|_.__/ \\__,_|_|_|  |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   ");
        System.out.println("                                                                  __/ |                  ");
        System.out.println("                                                                 |___/                 \n");
        System.out.println("        (1) - Novo Jogo");
        System.out.println("        (2) - Ver Equipas");
        System.out.println("        (3) - Ver Jogadores");
        System.out.println("        (4) - Mudar Jogador de Equipa");
        System.out.println("        (5) - Ver resultados de jogos realizados");
        System.out.println("        (0) - Sair\n");
    }

    private void printEquipas(Map<String,Equipa> equipas){
        for(Equipa equipa : equipas.values()){
            System.out.println(equipa.getNome() + " - " + equipa.getFundacaoEquipa() + " - " + equipa.calculaOverall());
        }
    }

    private void printJogadores(Map<Integer, Jogador> jogadores){
        for(Map.Entry<Integer, Jogador> entry : jogadores.entrySet()){
            Jogador jogador = entry.getValue();
            System.out.println("[" + entry.getKey() + "] " + jogador.getNome() + " - " + jogador.getnCamisola() + " - " + jogador.getPosicao() + " - " + jogador.getHistorial().get(jogador.getHistorial().size()-1) + " - " + jogador.calculaOverall());
        }
    }

    private void printJogos(List<Jogo> jogos){
        for(Jogo jogo: jogos){
            System.out.println("[Jogo] " + jogo.getEquipa1().getNome() + ": " + jogo.getGolosVisitado() + " vs " + jogo.getEquipa2().getNome() + ": " + jogo.getGolosVisitante());
        }
    }
}
