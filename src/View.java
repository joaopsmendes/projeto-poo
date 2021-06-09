import java.util.*;

public class View {

    public View(){

    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    /**
     * Funçao que indica o que imprimir no terminal para incializar o Football Manager
     */
    public void printMenuInicial(){

        System.out.println(ANSI_CYAN +" ______          _   _           _ _    __  __                                           " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"|  ____|        | | | |         | | |  |  \\/  |                                         " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"| |__ ___   ___ | |_| |__   __ _| | |  | \\  / | __ _ _ __   __ _  __ _  ___ _ __        " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"|  __/ _ \\ / _ \\| __| '_ \\ / _` | | |  | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|  " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"| | | (_) | (_) | |_| |_) | (_| | | |  | |  | | (_| | | | | (_| | (_| |  __/ |           " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"|_|  \\___/ \\___/ \\__|_.__/ \\__,_|_|_|  |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"                                                                  __/ |                  " + ANSI_RESET);
        System.out.println(ANSI_CYAN +"                                                                 |___/                 \n" + ANSI_RESET);
        System.out.println("        (1) - Novo Jogo");
        System.out.println("        (2) - Ver Equipas");
        System.out.println("        (3) - Ver Jogadores");
        System.out.println("        (4) - Mudar Jogador de Equipa");
        System.out.println("        (5) - Ver resultados de jogos realizados");
        System.out.println("        (6) - Criar Jogador");
        System.out.println(ANSI_RED + "        (0) - Sair\n" +ANSI_RESET);
    }

    /**
     * Função que indica quais os dados para imprimir em relação às equipas
     * @param equipas Equipas a ser imprimidas
     */
    public void printEquipas(Map<String,Equipa> equipas){
        System.out.println(ANSI_GREEN + "Nome da Equipa " + " - " + " Data de Formação " + " - " + " Overall da Equipa" + ANSI_RESET);
        for(Equipa equipa : equipas.values()){
            System.out.println( equipa.getNome() + " - " + equipa.getFundacaoEquipa() + " - " + equipa.calculaOverall());
        }
    }

    /**
     * Função que indica quais os dados em imprimir em relação aos jogadores
     * @param jogadores Jogadores a ser imprimidos
     */
    public void printJogadores(Map<Integer, Jogador> jogadores){
        System.out.println(ANSI_GREEN + "[ID do jogador] " + " " + "Nome do jogador " + " - " + " Número da Camisola " + " - " +
                           " Posição " + " - " + " Equipa " + " - " + " Overall do Jogador" + ANSI_RESET);
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

    public Jogador printJogador(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza o nome do jogador:");
        String nome=sc.nextLine();
        System.out.println("Introduza o número de camisola do jogador:");
        int numero=sc.nextInt();
        System.out.println("Introduza a posição que o jogador joga:");
        String stPos=sc.next();
        Jogador.Posicao pos= getPos_fromString(stPos);
        System.out.println("Introduza as habilidades do Jogador:");
        Map<Jogador.Habilidades,Integer> hab=getHabilidades(pos);
        List<String> histo=new ArrayList<>();
        System.out.println("Introduza a Equipa do Jogador:");
        String equipa=sc.next();
        String[] arrE= equipa.split(",");
        equipa=arrE[0];
        for(int i=1;i< arrE.length;i++){
            String ya=equipa + " " + arrE[i];
            equipa=ya;
        }
        histo.add(equipa);
        return new Jogador(nome,numero,pos,hab,histo);
    }

    public Jogador.Posicao getPos_fromString(String st){
        Jogador.Posicao pos=null;
        if(st.equals("Guarda-Redes")){
            pos= Jogador.Posicao.GUARDA_REDES;
        }
        else if(st.equals("Defesa")){
            pos= Jogador.Posicao.DEFESA;
        }
        else if(st.equals("Avancado")){
            pos= Jogador.Posicao.AVANCADO;
        }
        else if(st.equals("Lateral")){
            pos= Jogador.Posicao.LATERAL;
        }
        else if(st.equals("Medio")){
            pos= Jogador.Posicao.MEDIO;
        }
        return pos;
    }

    public Map<Jogador.Habilidades,Integer> getHabilidades(Jogador.Posicao pos){
        Scanner sc=new Scanner(System.in);
        System.out.println("\tIntroduza a nota de Cabeceamento:");
        int cabeca=sc.nextInt();
        System.out.println("\tIntroduza a nota de Remate:");
        int remate=sc.nextInt();
        System.out.println("\tIntroduza a nota de Velocidade:");
        int velocidade=sc.nextInt();
        System.out.println("\tIntroduza a nota de Passe:");
        int passe=sc.nextInt();
        System.out.println("\tIntroduza a nota de Impulsao:");
        int impulsao=sc.nextInt();
        System.out.println("\tIntroduza a nota de Resistencia:");
        int resis=sc.nextInt();
        System.out.println("\tIntroduza a nota de Destreza:");
        int destr=sc.nextInt();
        Map<Jogador.Habilidades,Integer> habilidades=new HashMap<>();
        if(pos.equals(Jogador.Posicao.AVANCADO) | pos.equals(Jogador.Posicao.DEFESA)){
            habilidades.put(Jogador.Habilidades.VELOCIDADE, velocidade);
            habilidades.put(Jogador.Habilidades.RESISTENCIA, resis);
            habilidades.put(Jogador.Habilidades.DESTREZA, destr);
            habilidades.put(Jogador.Habilidades.IMPULSAO, impulsao);
            habilidades.put(Jogador.Habilidades.CABECEAMENTO, cabeca);
            habilidades.put(Jogador.Habilidades.REMATE, remate);
            habilidades.put(Jogador.Habilidades.PASSE, passe);
        }
        else if(pos.equals(Jogador.Posicao.GUARDA_REDES)){
            System.out.println("\tIntroduza a nota de Flexibilidade:");
            int flex=sc.nextInt();
            habilidades.put(Jogador.Habilidades.FLEXIBILIDADE, flex);
            habilidades.put(Jogador.Habilidades.VELOCIDADE, velocidade);
            habilidades.put(Jogador.Habilidades.RESISTENCIA, resis);
            habilidades.put(Jogador.Habilidades.DESTREZA, destr);
            habilidades.put(Jogador.Habilidades.IMPULSAO, impulsao);
            habilidades.put(Jogador.Habilidades.CABECEAMENTO, cabeca);
            habilidades.put(Jogador.Habilidades.REMATE, remate);
            habilidades.put(Jogador.Habilidades.PASSE, passe);
        }
        else if (pos.equals(Jogador.Posicao.LATERAL)){
            System.out.println("\tIntroduza a nota de Cruzamento:");
            int cruz=sc.nextInt();
            habilidades.put(Jogador.Habilidades.CRUZAMENTO, cruz);
            habilidades.put(Jogador.Habilidades.VELOCIDADE, velocidade);
            habilidades.put(Jogador.Habilidades.RESISTENCIA, resis);
            habilidades.put(Jogador.Habilidades.DESTREZA, destr);
            habilidades.put(Jogador.Habilidades.IMPULSAO, impulsao);
            habilidades.put(Jogador.Habilidades.CABECEAMENTO, cabeca);
            habilidades.put(Jogador.Habilidades.REMATE, remate);
            habilidades.put(Jogador.Habilidades.PASSE, passe);
        }
        else if (pos.equals(Jogador.Posicao.MEDIO)){
            System.out.println("\tIntroduza a nota de Recuperação:");
            int recup=sc.nextInt();
            habilidades.put(Jogador.Habilidades.RECUPERACAO, recup);
            habilidades.put(Jogador.Habilidades.VELOCIDADE, velocidade);
            habilidades.put(Jogador.Habilidades.RESISTENCIA, resis);
            habilidades.put(Jogador.Habilidades.DESTREZA, destr);
            habilidades.put(Jogador.Habilidades.IMPULSAO, impulsao);
            habilidades.put(Jogador.Habilidades.CABECEAMENTO, cabeca);
            habilidades.put(Jogador.Habilidades.REMATE, remate);
            habilidades.put(Jogador.Habilidades.PASSE, passe);
        }
        return habilidades;
    }

}
