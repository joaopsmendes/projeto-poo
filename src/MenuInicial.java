/**
 * Criação do objeto MenuInicial
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuInicial {
    /**
     * Funçao que inicializa o Menu para começar a jogar
     */

    private View jan;

    public void initMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        try {
            Informacoes informacoes = Parser.parse();

            while(!quit){
                this.jan.printMenuInicial();
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
                        jan.printTatics();
                        Jogo.TaticaEquipa taticaEquipa1 = null;
                        while(taticaEquipa1 == null){
                            try{
                                int tatica = scanner.nextInt();
                                if (tatica == 1){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_TRES_TRES;
                                }else if(tatica == 2){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_QUATRO_DOIS;
                                }else if(tatica == 3){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_DOIS_QUATRO;
                                }else if(tatica == 4){
                                    taticaEquipa1 = Jogo.TaticaEquipa.QUATRO_DOIS_TRES_UM;
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
                        jan.printTatics();
                        Jogo.TaticaEquipa taticaEquipa2 = null;
                        while(taticaEquipa2 == null){
                            try{
                                int tatica = scanner.nextInt();
                                if (tatica == 1){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_TRES_TRES;
                                }else if(tatica == 2){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_QUATRO_DOIS;
                                }else if(tatica == 3){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_DOIS_QUATRO;
                                }else if(tatica == 4){
                                    taticaEquipa2 = Jogo.TaticaEquipa.QUATRO_DOIS_TRES_UM;
                                }else{
                                    System.out.println("Tatica invalida.");
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Introduza um numero.");
                                scanner.next();
                            }
                        }

                        Jogo jogo = new Jogo(equipa1, equipa2, taticaEquipa1, taticaEquipa2);
                        jogo.simulacao();
                        jogo.printJogo();
                    }else if(selecao == 2) {
                        jan.printEquipas(informacoes.getEquipas());
                    }else if(selecao == 3) {
                        jan.printJogadores(informacoes.getJogadores());
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
                        jan.printJogos(informacoes.getJogos());
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




    //4-2-4 MARCA MAIS GOLOS
    //4-3-3 melhor defesa

    //TODO : ver o algoritmo dos golos, ver o algoritmo das taticas, ver o algortimo do overall e influenciar no golos
}
