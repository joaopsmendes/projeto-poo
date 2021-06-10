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

public class Controller {
    /**
     * Funçao que inicializa o Menu para começar a jogar
     */

    public void initMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        try {
            Informacoes informacoes = Parser.parse();
            View jan=new View();
            while(!quit){
                jan.printMenuInicial();
                try{
                    int selecao = scanner.nextInt();
                    if(selecao == 1) {
                        // TODO
                        // fazer numero random que atribui o resultado
                        // escolher a equipa e o seu respetivo esquema tatico

                        jan.printIndiquEquip();
                        Equipa equipa1=null;
                        String dummy = scanner.nextLine();
                        while(equipa1==null){
                            String equipa1Nome =scanner.nextLine();
                            if(informacoes.getEquipas().containsKey(equipa1Nome))
                                equipa1 = informacoes.getEquipas().get(equipa1Nome);
                            else{
                                jan.printEquipInval();
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
                                    jan.printTaticInv();
                                }
                            }catch (InputMismatchException e){
                                jan.printIntroNum();
                                scanner.next();
                            }
                        }

                        jan.printIndiquEquip();
                        Equipa equipa2=null;
                        String dummy1 = scanner.nextLine();
                        while(equipa2==null){
                            String equipa2Nome =scanner.nextLine();
                            if(!equipa2Nome.equalsIgnoreCase(equipa1.getNome()) && informacoes.getEquipas().containsKey(equipa2Nome))
                                equipa2 = informacoes.getEquipas().get(equipa2Nome);
                            else{
                                jan.printEquipInval();
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
                                    jan.printTaticInv();
                                }
                            }catch (InputMismatchException e){
                                jan.printIntroNum();
                                scanner.next();
                            }
                        }

                        Jogo jogo = new Jogo(equipa1, equipa2, taticaEquipa1, taticaEquipa2);
                        jogo.simulacao_part1();
                        Map<Integer,Integer> subs=jan.printJogoInter(jogo);
                        jogo.simulacao_part2(subs);
                        jan.printJogo(jogo);
                    }else if(selecao == 2) {
                        jan.printEquipas(informacoes.getEquipas());
                    }else if(selecao == 3) {
                        jan.printJogadores(informacoes.getJogadores());
                    }else if(selecao == 4) {
                        jan.printIDJogador();
                        int jogId = scanner.nextInt();
                        Jogador jogador = informacoes.getJogadores().get(jogId);
                        if (jogador == null) {
                            jan.printIdIn();
                            continue;
                        }

                        jan.printNomeEquipa();
                        String dummy = scanner.nextLine();
                        String nomeEquipa = scanner.nextLine();
                        Equipa equipa = informacoes.getEquipas().get(nomeEquipa);
                        if (equipa == null) {
                            jan.printEquipInval();
                            continue;
                        }

                        informacoes.transfereJogador(jogId, jogador, equipa.getNome());
                        jan.printTransfer(jogador.getNome(),equipa.getNome());
                    }else if(selecao==5){
                        jan.printJogos(informacoes.getJogos());
                    }else if(selecao==6){
                        Jogador jogador=jan.printJogador();
                        List<String> histo=jogador.getHistorial();
                        String ult_equi=histo.get(histo.size()-1);

                        if(informacoes.verificaEquipa(ult_equi) ){
                            Map<String,Equipa> newMAPEqui=null;
                            Equipa newEqui=informacoes.getEquipa_fromNome(ult_equi);
                            newEqui.insereJogador(jogador);
                            for(Equipa e:informacoes.getEquipas().values()){
                                if(newEqui.getNome().equals(e.getNome())){
                                    newMAPEqui.put(newEqui.getNome(),newEqui.clone());
                                }
                                else{
                                    newMAPEqui.put(e.getNome(),e.clone());
                                }
                            }
                            informacoes.setEquipas(newMAPEqui);
                        }
                        else{
                            jan.printEquipInval();
                        }
                    }
                    else if(selecao == 0){
                        quit = true;
                    }else{
                        jan.printOPIN();
                    }
                }catch (NumberFormatException e){
                    jan.printIntroNum();
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
