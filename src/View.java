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
            this.printJogo(jogo);
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

    /**
     * Função que indica quais os dados a imprimir em relação ao jogo
     */
    public void printJogo(Jogo jogo){
        System.out.println("[Jogo] "
                + jogo.getEquipa1().getNome() + " : "
                + jogo.getGolosVisitado() + " vs " + jogo.getGolosVisitante() + " : "
                + jogo.getEquipa2().getNome());
    }

    public Map<Integer,Integer> printJogoInter(Jogo jogo){
        System.out.println("[Jogo Ao Intervalo] "
                + jogo.getEquipa1().getNome() + " : "
                + jogo.getGolosVisitado() + " vs " + jogo.getGolosVisitante() + " : "
                + jogo.getEquipa2().getNome());
        System.out.println("Deseja fazer substituições ?");
        System.out.println("1:Sim    2:Não");
        Map<Integer,Integer> subs=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int quer=sc.nextInt();
        if(quer==1){
            System.out.println("Equipa 1:1    Equipa 2:2");
            int op=sc.nextInt();
            if(op==1){
                subs.put(0,1);
                this.print11Inicial(jogo.getJogadoresEquipa1(),1);
                this.printSup(jogo.getJogadoresEquipa1(),jogo.getEquipa1().getJogadores());
                System.out.println("Para substituir os jogadores use os números da camisola. Para finalizar digite -1. Tem um máximo de 3 substituições");
                int numSubs=3;
                int crt11=sc.nextInt();
                while(numSubs>0 && crt11!=-1){
                    while( !contemJogador(crt11,jogo.getJogadoresEquipa1()) && crt11!=-1){
                        System.out.println("Jogador não encontrado");
                        crt11=sc.nextInt();
                    }
                    if(crt11==-1){
                        break;
                    }
                    int crtSub=sc.nextInt();
                    while(!contemJogador(crtSub,jogo.getEquipa1().getJogadores()) && crtSub!=-1){
                        System.out.println("Jogador não encontrado");
                        crtSub=sc.nextInt();
                    }
                    if(crtSub==-1) break;
                    subs.put(crt11,crtSub);
                    numSubs--;
                    if(numSubs==0){
                        break;
                    }
                    crt11=sc.nextInt();
                }

            }
            else if(op==2){
                subs.put(0,2);
                this.print11Inicial(jogo.getJogadoresEquipa2(),2);
                this.printSup(jogo.getJogadoresEquipa2(),jogo.getEquipa2().getJogadores());
                System.out.println("Para substituir os jogadores use os números da camisola. Para finalizar digite -1. Tem um máximo de 3 substituições");
                int numSubs=3;
                int crt11=sc.nextInt();
                while(numSubs>0 && crt11!=-1){
                    while( !contemJogador(crt11,jogo.getJogadoresEquipa2()) && crt11!=-1){
                        System.out.println("Jogador não encontrado");
                        crt11=sc.nextInt();
                    }
                    if(crt11==-1){
                        break;
                    }
                    int crtSub=sc.nextInt();
                    while(!contemJogador(crtSub,jogo.getEquipa2().getJogadores()) && crtSub!=-1){
                        System.out.println("Jogador não encontrado");
                        crtSub=sc.nextInt();
                    }
                    if(crtSub==-1) break;
                    subs.put(crt11,crtSub);
                    numSubs--;
                    if(numSubs==0){
                        break;
                    }
                    crt11=sc.nextInt();
                }

            }
            else{
                this.printOPIN();
            }
        }
        else if(quer==2){
            subs=new HashMap<>();
        }
        else{
            System.out.println("Comando Inválido.");
        }
        return subs;
    }

    private boolean contemJogador(int num, List<Jogador> lista){
        for(Jogador jog:lista){
            if(jog.getnCamisola()==num) return true;
        }
        return false;
    }

    public void print11Inicial(List<Jogador> e, int num){
        System.out.println("11 Inicial da Equipa " + num );
        for(Jogador jog:e){
            System.out.println(jog.getnCamisola() + " " + jog.getNome() + " " + this.printPosicao(jog.getPosicao()) );
        }
    }

    public void printSup(List<Jogador> onze, List<Jogador> plantel){
        System.out.println("Suplentes " );
        for(Jogador joga:plantel){
            if(!onze.contains(joga)){
                System.out.println(joga.getnCamisola() + " " + joga.getNome() + " " + printPosicao(joga.getPosicao()));
            }
        }
    }

    public String printPosicao(Jogador.Posicao pos){
        if(pos.equals(Jogador.Posicao.AVANCADO)){
            return "Avançado";
        }
        else if(pos.equals(Jogador.Posicao.MEDIO)){
            return "Médio";
        }
        else if(pos.equals(Jogador.Posicao.DEFESA)){
            return "Defesa";
        }
        else if(pos.equals(Jogador.Posicao.LATERAL)){
            return "Lateral";
        }
        else if(pos.equals(Jogador.Posicao.GUARDA_REDES)){
            return "Guarda-Redes";
        }
        return null;
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
