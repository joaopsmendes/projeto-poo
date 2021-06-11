/**
 * Criação do módulo View
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.File;
import java.util.*;
import java.time.LocalDate;

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
        System.out.println("        (7) - Criar Equipa");
        System.out.println("        (8) - Guardar Progresso no ficheiro");
        System.out.println("        (9) - Carregar Progresso");
        System.out.println(ANSI_RED + "        (0) - Sair\n" +ANSI_RESET);
    }

    /**
     * Função que indica quais os dados para imprimir em relação às equipas
     * @param equipas Equipas a ser imprimidas
     */
    public void printEquipas(Map<String,Equipa> equipas){
        System.out.println(ANSI_GREEN + "Nome da Equipa " + " - "
                + " Data de Formação " + " - " + " Overall da Equipa" + ANSI_RESET);
        for(Equipa equipa : equipas.values()){
            if(equipa.getJogadores().isEmpty()){
                System.out.println( equipa.getNome() + " - " + equipa.getFundacaoEquipa()
                        + " - " + "0");
            }
            else{
                System.out.println( equipa.getNome() + " - " + equipa.getFundacaoEquipa()
                        + " - " + equipa.calculaOverall());
            }
        }
    }

    /**
     * Função que indica quais os dados em imprimir em relação aos jogadores
     * @param jogadores Jogadores a ser imprimidos
     */
    public void printJogadores(Map<Integer, Jogador> jogadores){
        System.out.println(ANSI_GREEN + "[ID do jogador] " + " " + "Nome do jogador " + " - " +
                "" + " Número da Camisola " + " - " +
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
     * Função que imprime os jogos
     * @param jogos Lista de jogos a ser imprimidos
     */
    public void printJogos(List<Jogo> jogos){
        for(Jogo jogo: jogos){
            this.printJogo(jogo);
        }
    }

    /**
     * Função que imprime as táticas possíveis a ser escolhidas
     */
    public void printTatics(){
        System.out.println("Indica uma tática para a equipa escolhida: \n");
        System.out.println("[1] - 4-3-3");
        System.out.println("[2] - 4-4-2");
        System.out.println("[3] - 4-2-4");
        System.out.println("[4] - 4-2-3-1");
    }

    /**
     * Função que imprime o erro caso o nome da equipa introduzido seja inválido
     */
    public void printEquipInval(){
        System.out.println("Nome de equipa invalido");
    }

    /**
     * Função que pede ao utilizador que indique a equipa pretendida
     */
    public void printIndiquEquip(){
        System.out.println("Indique uma equipa: \n");
    }

    /**
     * Função que indica ao utilizador que a tática pretendida é inválida
     */
    public void printTaticInv(){
        System.out.println("Tatica invalida.");
    }

    /**
     * Função que pede ao utilizador que introduza o número
     */
    public void printIntroNum(){
        System.out.println("Introduza um numero.");
    }

    /**
     * Função que pede ao utilizador que introduza o nome da equipa
     */
    public void printNomeEquipa(){
        System.out.println("Introduza o nome da equipa: ");
    }

    /**
     * Função que pede ao utilizador o id do jogador
     */
    public void printIDJogador(){
        System.out.println("Introduza o id do jogador: ");
    }

    /**
     *
     */
    public void printNumJogadorInv(){
        System.out.println("Número de Jogador inválido");
    }
    /**
     * Função que indica ao utilizador que o id é inválido
     */
    public void printIdIn(){
        System.out.println("Id de jogador invalido");
    }

    /**
     * Função que indica o jogador e para que equipa foi transferido
     * @param stJog Nome do jogador
     * @param stEqu Nome da equipa
     */
    public void printTransfer(String stJog,String stEqu){
        System.out.println(stJog + " foi transferido para " + stEqu);
    }

    /**
     * Função que indica ao utilizador que a opção escolhida é inválida
     */
    public void printOPIN(){
        System.out.println("Opçao invalida.");
    }

    /**
     * Função que indica quais os dados a imprimir em relação ao jogo
     */
    public void printJogo(Jogo jogo){
        System.out.println("[Jogo] "
                + jogo.getEquipa1().getNome() + " : "
                + jogo.getGolosVisitada() + " vs " + jogo.getGolosVisitante() + " : "
                + jogo.getEquipa2().getNome());
    }

    /**
     * Função que
     * @param e1
     * @param numEQ
     * @return
     */
    public List<Integer> printJogadoresEquipa(Equipa e1,int numEQ){
        System.out.println("Plantel da Equipa " + numEQ);
        for(Jogador jog:e1.getJogadores()){
            System.out.println(jog.getnCamisola() + " - " + jog.getNome() + " - " + jog.getPosicao());
        }
        System.out.println("Digite o número de camisola de 11 jogadores da equipa.");
        List<Integer> onzeLista=new ArrayList<>();
        int onze=11;
        Scanner sc=new Scanner(System.in);
        while(true){
            int numJog=sc.nextInt();
            while(!equipContemNumJog(e1,numJog) | onzeLista.contains(numJog)){
                this.printNumJogadorInv();
                numJog=sc.nextInt();
            }
            onzeLista.add(numJog);
            onze--;
            if(onze==0 && onzeLista.size()==11) break;
        }
        return onzeLista;
    }

    /**
     * Função que verifica a existência de um jogador numa equipa
     * @param e1 Equipa
     * @param numJog
     * @return
     */
    public boolean equipContemNumJog(Equipa e1,int numJog){
        for(Jogador jog:e1.getJogadores()){
            if(jog.getnCamisola()==numJog) return true;
        }
        return false;
    }
    /**
     * Função que indica o resultado ao intervalo e pergunta ao utilizador se pretende fazer alterações a alguma
     * das equipas
     * @param jogo jogo em questão
     * @param numEqu 1- Equipa da casa, 2- Equipa visitante
     * @return Retorna o resultado e se pretende fazer substuições
     */
    public Map<Integer,Integer> printJogoInter(Jogo jogo,int numEqu){
        System.out.println("[Jogo Ao Intervalo] "
                + jogo.getEquipa1().getNome() + " : "
                + jogo.getGolosVisitada() + " vs " + jogo.getGolosVisitante() + " : "
                + jogo.getEquipa2().getNome());
        System.out.println("Equipa" + numEqu + "-> Deseja fazer substituições ?");
        System.out.println("1:Sim    2:Não");
        Map<Integer,Integer> subs=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int quer=sc.nextInt();
        if(quer==1){
            if(numEqu==1){
                this.print11Inicial(jogo.getJogadoresEquipa1(),1);
                this.printSup(jogo.getJogadoresEquipa1(),jogo.getEquipa1().getJogadores());
                System.out.println("Para substituir os jogadores use os números da camisola. " +
                        "Para finalizar digite -1. Tem um máximo de 3 substituições");
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
            else if(numEqu==2){
                this.print11Inicial(jogo.getJogadoresEquipa2(),2);
                this.printSup(jogo.getJogadoresEquipa2(),jogo.getEquipa2().getJogadores());
                System.out.println("Para substituir os jogadores use os números da camisola. " +
                        "Para finalizar digite -1. Tem um máximo de 3 substituições");
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

        }
        else{
            System.out.println("Comando Inválido.");
        }
        return subs;
    }

    /**
     * Função que verifica se o jogador existe numa lista de jogadores
     * @param num Número da camisola do jogador
     * @param lista Lista onde se pretende verificar a existência do jogador
     * @return Boleano que indica o jogador está nessa lista
     */
    private boolean contemJogador(int num, List<Jogador> lista){
        for(Jogador jog:lista){
            if(jog.getnCamisola()==num) return true;
        }
        return false;
    }

    /**
     * Função que imprime o 11 inical de uma equipa
     * @param e Lista de jogadores
     * @param num Número da equipa
     */
    public void print11Inicial(List<Jogador> e, int num){
        System.out.println("11 Inicial da Equipa " + num );
        for(Jogador jog:e){
            System.out.println(jog.getnCamisola() + " - " + jog.getNome() +
                    " : " + printPosicao(jog.getPosicao()) );
        }
    }

    /**
     * Função que imprime os jogadores suplentes de uma equipa
     * @param onze jogadores titulares de uma equipa
     * @param plantel Todos os jogadores de uma equipa
     */
    private void printSup(List<Jogador> onze, List<Jogador> plantel){
        System.out.println("Suplentes " );
        for(Jogador joga:plantel){
            if(!onze.contains(joga)){
                System.out.println(joga.getnCamisola() + " - " + joga.getNome() +
                        " : " + printPosicao(joga.getPosicao()));
            }
        }
    }

    /**
     * Função que imprime a posição de um jogador
     * @param pos Posição do jogador
     * @return Imprime uma String da posição do jogador
     */
    private String printPosicao(Jogador.Posicao pos){
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

    /**
     * Função para criar um jogador
     * @return Jogador criado pelo utilizador
     */
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
        String dummy=sc.nextLine();
        String equipa=sc.nextLine();
        histo.add(equipa);
        return new Jogador(nome,numero,pos,hab,histo);
    }

    /**
     * Função que obtém a posição do jogador através de uma string
     * @param st Posição introduzida pelo utilizador
     * @return Retorna o jogador com a posição escolhida
     */
    private Jogador.Posicao getPos_fromString(String st){
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

    /**
     * Função que ao jogador criado atribui as habilidades introduzidas pelo utilizador ao jogador criado
     * @param pos Posição do jogador
     * @return Mapa com as habilidades e o respetivo overall
     */
    private Map<Jogador.Habilidades,Integer> getHabilidades(Jogador.Posicao pos){
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

    /**
     * Função que cria uma equipa
     * @return Equipa criada
     */
    public Equipa printCriaEquipa(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduza o nome da Equipa que deseja criar.");
        String nome=sc.nextLine();
        LocalDate ld=LocalDate.now();
        return new Equipa(nome,ld,new ArrayList<>());
    }

    /**
     * Função que imprime a mensagem de erro
     */
    public void printErro(){
        System.out.println("Erro");
    }

    /**
     * Função que pede e lê o nome do ficheiro onde se pretende guardar os dados
     * @return Nome do ficheiro
     */
    public String printGuarda(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza o nome do ficheiro onde pretende guardar os dados.");
        String nomefp=sc.nextLine();
        return nomefp;
    }

    /**
     * Função que pede e lê o nome do ficheiro de onde se pretende ler os ficheiros
     * @return Nome do ficheiro
     */
    public String printLe(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza o nome do ficheiro que pretende ler.");
        String nomefp=sc.nextLine();
        return nomefp;
    }

    /**
     * Mensagem de erro quando o ficheiro não é encontrado
     */
    public void printFichNotFind(){
        System.out.println("Ficheiro não foi encontrado.");
    }

    /**
     * Mensagem de erro quando a classe não é encotrada
     */
    public void printClassNotFound(){
        System.out.println("Classe não encontrada.");
    }
}
