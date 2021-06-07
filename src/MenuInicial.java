import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                        // fazer numero random que atribui o resultado
                        // escolher a equipa e o seu respetivo esquema tatico

                        System.out.println("Indique uma equipa: \n");
                        Equipa equipa1=null;
                        String dummy = scanner.nextLine();
                        while(equipa1==null){
                            String equipa1Nome =scanner.nextLine();
                            if(informacoes.getEquipas().containsKey(equipa1Nome))
                                equipa1 = informacoes.getEquipas().get(equipa1Nome);
                            else{
                                System.out.println("Nome de equipa invalido");
                            }
                        }
                        System.out.println("Indica uma tática para a equipa escolhida: \n");
                        System.out.println("1 - 4-3-3");
                        System.out.println("2 - 4-4-2");
                        Jogo.TaticaEquipa taticaEquipa1 = null;
                        while(taticaEquipa1 == null){
                            try{
                                int tatica = scanner.nextInt();
                                if (tatica == 1){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_TRES_TRES;
                                }else if(tatica == 2){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_QUATRO_DOIS;
                                }else{
                                    System.out.println("Tatica invalida.");
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Introduza um numero.");
                                scanner.next();
                            }
                        }

                        System.out.println("Indique uma equipa adversaria: \n");
                        Equipa equipa2=null;
                        String dummy1 = scanner.nextLine();
                        while(equipa2==null){
                            String equipa2Nome =scanner.nextLine();
                            if(!equipa2Nome.equalsIgnoreCase(equipa1.getNome()) && informacoes.getEquipas().containsKey(equipa2Nome))
                                equipa2 = informacoes.getEquipas().get(equipa2Nome);
                            else{
                                System.out.println("Nome de equipa invalido");
                            }
                        }
                        System.out.println("Indica uma tática para a equipa escolhida: \n");
                        System.out.println("1 - 4-3-3");
                        System.out.println("2 - 4-4-2");
                        Jogo.TaticaEquipa taticaEquipa2 = null;
                        while(taticaEquipa2 == null){
                            try{
                                int tatica = scanner.nextInt();
                                if (tatica == 1){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_TRES_TRES;
                                }else if(tatica == 2){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_QUATRO_DOIS;
                                }else{
                                    System.out.println("Tatica invalida.");
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Introduza um numero.");
                                scanner.next();
                            }
                        }

                        Jogo jogo = new Jogo(equipa1, equipa2, taticaEquipa1, taticaEquipa2);

                        jogo.printJogo();
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
            System.out.println("[" + entry.getKey() + "] " +
                    jogador.getNome() + " - " +
                    jogador.getnCamisola() + " - " +
                    jogador.getPosicao() + " - " +
                    jogador.getHistorial().get(jogador.getHistorial().size()-1) + " - " +
                    jogador.calculaOverall());
        }
    }

    private void printJogos(List<Jogo> jogos){
        for(Jogo jogo: jogos){
            jogo.printJogo();
        }
    }
}
