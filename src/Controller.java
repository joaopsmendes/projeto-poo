/**
 * Criação do objeto MenuInicial
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    /**
     * Funçao que inicializa o Menu para começar a jogar
     */
    public void initMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        try {
            Informacoes informacoes = Parser.parse("src/logs.txt");
            View jan=new View();
            Jogo jogo;
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
                        List<Jogador> onzeJoga1=null;
                        String dummy = scanner.nextLine();
                        Jogo.TaticaEquipa taticaEquipa1 = null;
                        while(equipa1==null){
                            String equipa1Nome =scanner.nextLine();
                            if(informacoes.getEquipas().containsKey(equipa1Nome)){
                                equipa1 = informacoes.getEquipas().get(equipa1Nome);
                                jan.printTatics();
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
                                List<Integer> onze1= jan.printJogadoresEquipa(equipa1,1,taticaEquipa1);
                                onzeJoga1=informacoes.get11Jogadores(onze1,equipa1);
                            }
                            else{
                                jan.printEquipInval();
                            }
                        }

                        jan.printIndiquEquip();
                        Equipa equipa2=null;
                        List<Jogador> onzeJoga2=null;
                        String dummy1 = scanner.nextLine();
                        Jogo.TaticaEquipa taticaEquipa2 = null;
                        while(equipa2==null){
                            String equipa2Nome =scanner.nextLine();
                            if(!equipa2Nome.equalsIgnoreCase(equipa1.getNome())
                                    && informacoes.getEquipas().containsKey(equipa2Nome)){
                                jan.printTatics();
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
                                equipa2 = informacoes.getEquipas().get(equipa2Nome);
                                List<Integer> onze2= jan.printJogadoresEquipa(equipa2,2,taticaEquipa2);
                                onzeJoga2=informacoes.get11Jogadores(onze2,equipa2);
                            }
                            else{
                                jan.printEquipInval();
                            }
                        }

                        jogo = new Jogo(equipa1, equipa2, taticaEquipa1, taticaEquipa2,onzeJoga1,onzeJoga2);
                        jogo.simulacao_part1();
                        Map<Integer,Integer> subs1=jan.printJogoInter(jogo,1);
                        Map<Integer,Integer> subs2=jan.printJogoInter(jogo,2);
                        jogo.simulacao_part2(subs1,subs2);
                        List<Jogo> jogos=informacoes.getJogos();
                        jogos.add(jogo);
                        informacoes.setJogos(jogos);
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
                        Equipa e1=informacoes.getEquipa_fromNome(ult_equi);
                        while(informacoes.verificaNumJog(e1,jogador.getnCamisola())){
                            int numJog=jan.printNumJogadorInv_getint();
                            jogador.setnCamisola(numJog);
                        }
                        Map<Integer,Jogador> lista_jogadores=informacoes.getJogadores();
                        lista_jogadores.put(lista_jogadores.size(),jogador);
                        informacoes.setJogadores(lista_jogadores);
                        if(informacoes.verificaEquipa(ult_equi) ){
                            Map<String,Equipa> newMAPEqui=new HashMap<>();
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
                    }else if(selecao==7){
                        Equipa novaEq=jan.printCriaEquipa();
                        informacoes.addEquipa(novaEq);
                    }else if(selecao==8){
                        String filePrint=jan.printGuarda();
                        if(filePrint.endsWith(".txt")) {
                            informacoes.writeTxt(filePrint);
                        }
                        else if(filePrint.endsWith(".bin") | filePrint.endsWith(".DEFAULT")){
                            String ret=informacoes.writeFileBin(filePrint);
                            jan.printString(ret);
                        }
                    }else if(selecao==9){
                        String fileRead=jan.printLe();
                        System.out.println(fileRead);
                        if(fileRead.endsWith(".txt")){
                            informacoes=Parser.parse(fileRead);
                        }
                        else if(fileRead.endsWith(".bin") | fileRead.endsWith(".DEFAULT")){
                            informacoes=informacoes.readFileBin(fileRead);
                        }
                    }
                    else if(selecao == 0){
                        quit = true;
                    }else{
                        jan.printOPIN();
                    }
                }catch (NumberFormatException e){
                    jan.printIntroNum();
                }catch (IOException e) {
                    jan.printFichNotFind();
                } catch (ClassNotFoundException e) {
                    jan.printClassNotFound();
                }
            }
        } catch (LinhaIncorretaException | FileNotFoundException e) {
            View jan=new View();
            jan.printErro();
        }
        scanner.close();
    }



    //4-2-4 MARCA MAIS GOLOS
    //4-3-3 melhor defesa

    //TODO : ver o algoritmo dos golos, ver o algoritmo das taticas, ver o algortimo do overall e influenciar no golos
}
