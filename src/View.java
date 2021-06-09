import java.util.List;
import java.util.Map;

public class View {

    public View(){

    }

    /**
     * Funçao que indica o que imprimir no terminal para incializar o Football Manager
     */
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

    /**
     * Função que indica quais os dados para imprimir em relação às equipas
     * @param equipas Equipas a ser imprimidas
     */
    public void printEquipas(Map<String,Equipa> equipas){
        for(Equipa equipa : equipas.values()){
            System.out.println(equipa.getNome() + " - " + equipa.getFundacaoEquipa() + " - " + equipa.calculaOverall());
        }
    }

    /**
     * Funçao que indica quais os dados em imprimir em relação aos jogadores
     * @param jogadores Jogadores a ser imprimidos
     */
    public void printJogadores(Map<Integer, Jogador> jogadores){
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

    /**
     *
     * @param jogos Jogos a ser imprimidos
     */
    public void printJogos(List<Jogo> jogos){
        for(Jogo jogo: jogos){
            jogo.printJogo();
        }
    }

    public void printTatics(){
        System.out.println("Indica uma tática para a equipa escolhida: \n");
        System.out.println("[1] - 4-3-3");
        System.out.println("[2] - 4-4-2");
        System.out.println("[3] - 4-2-4");
        System.out.println("[4] - 4-2-3-1");
    }

    public void printEquipInval(){
        System.out.println("Nome de equipa invalido");
    }

    public void printIndiquEquip(){
        System.out.println("Indique uma equipa: \n");
    }

    public void printTaticInv(){
        System.out.println("Tatica invalida.");
    }

    public void printIntroNum(){
        System.out.println("Introduza um numero.");
    }

    public void printNomeEquipa(){
        System.out.println("Introduza o nome da equipa: ");
    }

    public void printIDJogador(){
        System.out.println("Introduza o id do jogador: ");
    }

    public void printIdIn(){
        System.out.println("Id the jogador invalido");
    }

    public void printTransfer(String stJog,String stEqu){
        System.out.println(stJog + " foi transferido para " + stEqu);
    }

    public void printOPIN(){
        System.out.println("Opçao invalida.");
    }



}
