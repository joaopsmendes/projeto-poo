/**
 * Criação do objeto Jogo
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.util.*;
import java.util.stream.Collectors;

public class Jogo {
    private int tempo; // segundos (120 = 2:00) / (110 = 1:50)
    private Estado estado;
    private Equipa equipa1;
    private Equipa equipa2;
    private int golosVisitada;
    private int golosVisitante;
    private List<Jogador> jogadoresEquipa1;
    private List<Jogador> jogadoresEquipa2;
    private TaticaEquipa taticaEquipa1;
    private TaticaEquipa taticaEquipa2;
    private Map<Integer, Integer> substituicoesEquipa1;
    private Map<Integer, Integer> substituicoesEquipa2;

    /**
     * Criação do construtor vazio
     */
    public Jogo(){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        this.equipa1 = new Equipa();
        this.equipa2 = new Equipa();
        this.golosVisitada = 0;
        this.golosVisitante = 0;
        this.jogadoresEquipa1 = new ArrayList<>();
        this.jogadoresEquipa2 = new ArrayList<>();
        this.taticaEquipa1 = TaticaEquipa.QUATRO_TRES_TRES;
        this.taticaEquipa2 = TaticaEquipa.QUATRO_TRES_TRES;
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    /**
     * Construtor parametrizado sem golos e substituições
     * @param equipa1 Primeira equipa
     * @param equipa2 Segunda equipa
     * @param taticaEquipa1 Tática da primeira equipa
     * @param taticaEquipa2 Tática da segunda equipa
     */
    public Jogo(Equipa equipa1, Equipa equipa2, TaticaEquipa taticaEquipa1, TaticaEquipa taticaEquipa2){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitada = 0;
        this.golosVisitante = 0;
        this.jogadoresEquipa1 = this.equipa1.getJogadores().stream().limit(11).collect(Collectors.toList());
        this.jogadoresEquipa2 = this.equipa2.getJogadores().stream().limit(11).collect(Collectors.toList());
        this.taticaEquipa1 = taticaEquipa1;
        this.taticaEquipa2 = taticaEquipa2;
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    public Jogo(Equipa equipa1, Equipa equipa2, TaticaEquipa taticaEquipa1, TaticaEquipa taticaEquipa2,List<Jogador> onze1,List<Jogador> onze2){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitada = 0;
        this.golosVisitante = 0;
        setJogadoresEquipa1(onze1);
        setJogadoresEquipa2(onze2);
        this.taticaEquipa1 = taticaEquipa1;
        this.taticaEquipa2 = taticaEquipa2;
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    /**
     * Criação do construtor parametrizado sem táticas
     *
     * @param tempo Data do Jogo
     * @param estado Estado do jogo
     * @param equipa1 Primeira equipa
     * @param equipa2 Segunda equipa
     * @param golosVisitada Golos da equipa da casa
     * @param golosVisitante Golos da equipa visitante
     * @param jogadoresEquipa1 Jogadores da equipa da casa
     * @param jogadoresEquipa2 Jogadores da equipa visitante
     * @param substituicoesEquipa1 Substituições da primeira equipa
     * @param substituicoesEquipa2 Substituições da segunda equipa
     */
    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitada,
                int golosVisitante, List<Jogador> jogadoresEquipa1, List<Jogador> jogadoresEquipa2,
                Map<Integer, Integer> substituicoesEquipa1, Map<Integer, Integer> substituicoesEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitada = golosVisitada;
        this.golosVisitante = golosVisitante;
        setJogadoresEquipa1(jogadoresEquipa1);
        setJogadoresEquipa2(jogadoresEquipa2);
        this.taticaEquipa1 = TaticaEquipa.QUATRO_TRES_TRES;
        this.taticaEquipa2 = TaticaEquipa.QUATRO_TRES_TRES;
        setSubstituicoesEquipa1(substituicoesEquipa1);
        setSubstituicoesEquipa2(substituicoesEquipa2);
    }

    /**
     * Construtor parametrizado mas com as táticas
     * @param tempo Data do jogo
     * @param estado Estado do jogo
     * @param equipa1 Primeira equipa
     * @param equipa2 Segunda equipa
     * @param golosVisitada Golos da equipa da casa
     * @param golosVisitante Golos da equipa visitante
     * @param jogadoresEquipa1 Jogadores da equipa da casa
     * @param jogadoresEquipa2 Jogadores da equipa visitante
     * @param taticaEquipa1 Tática da primeira equipa
     * @param taticaEquipa2 Tática da segunda equipa
     * @param substituicoesEquipa1 Substituições da primeira equipa
     * @param substituicoesEquipa2 Substituições da segunda equipa
     */
    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitada,
                int golosVisitante, List<Jogador> jogadoresEquipa1, List<Jogador> jogadoresEquipa2,
                TaticaEquipa taticaEquipa1, TaticaEquipa taticaEquipa2, Map<Integer, Integer> substituicoesEquipa1,
                Map<Integer, Integer> substituicoesEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitada = golosVisitada;
        this.golosVisitante = golosVisitante;
        setJogadoresEquipa1(jogadoresEquipa1);
        setJogadoresEquipa2(jogadoresEquipa2);
        this.taticaEquipa1 = taticaEquipa1;
        this.taticaEquipa2 = taticaEquipa2;
        setSubstituicoesEquipa1(substituicoesEquipa1);
        setSubstituicoesEquipa2(substituicoesEquipa2);
    }

    /**
     * Craição do construtor cópia
     *
     * @param jogo Objeto Jogo
     */
    public Jogo(Jogo jogo){
        this.tempo = jogo.getTempo();
        this.estado = jogo.getEstado();
        setEquipa1(jogo.getEquipa1());
        setEquipa2(jogo.getEquipa2());
        this.golosVisitada = jogo.getGolosVisitada();
        this.golosVisitante = jogo.getGolosVisitante();
        setJogadoresEquipa1(jogo.getJogadoresEquipa1());
        setJogadoresEquipa2(jogo.getJogadoresEquipa2());
        this.taticaEquipa1 = jogo.getTaticaEquipa1();
        this.taticaEquipa2 = jogo.getTaticaEquipa2();
        setSubstituicoesEquipa1(jogo.getSubstituicoesEquipa1());
        setSubstituicoesEquipa2(jogo.getSubstituicoesEquipa2());
    }

    /**
     * Indica os diferentes estado em que o jogo pode se encontrar
     */
    public enum Estado{
        POR_INICIAR,
        PRIMEIRA_PARTE,
        INTERVALO,
        SEGUNDA_PARTE,
        TERMINADO
    }

    /**
     * Indica o os diferentes esquemas táticos que as equipas podem adotar
     */
    public enum TaticaEquipa{
        QUATRO_QUATRO_DOIS,
        QUATRO_TRES_TRES,
        QUATRO_DOIS_QUATRO,
        QUATRO_DOIS_TRES_UM
    }

    /**
     *
     * @param input Linha de um ficheiro com jogos
     * @param equipas Equipas do jogo
     * @return Retorna o jogo com as informações nessa linha
     * @throws NumberFormatException
     */
    public static Jogo parser(String input, Map<String, Equipa> equipas) throws NumberFormatException{
//        Bach F. C.,Sporting Club Shostakovich,1,3,2021-02-02,4,47,35,2,36,39,14,43,5,32,50,14->0,
//        4->30,36->21,43,30,1,22,33,11,38,31,39,6,12,43->3,31->34,12->20
        String[] campos = input.split(",");
        Equipa equipa1 = equipas.get(campos[0]);
        Equipa equipa2 = equipas.get(campos[1]);
        if(equipa1 == null || equipa2 == null) return new Jogo();
        List<Jogador> jogadoresEquipa1 = new ArrayList<>();
        List<Jogador> jogadoresEquipa2 = new ArrayList<>();
        for(int i = 5; i < 16; i++){
            if(equipa1.obterJogadorPeloNumero(i)!=null)
            jogadoresEquipa1.add(equipa1.obterJogadorPeloNumero(i));
        }
        for(int i = 19; i < 30; i++){
            if(equipa2.obterJogadorPeloNumero(i)!=null)
            jogadoresEquipa2.add(equipa2.obterJogadorPeloNumero(i));
        }
        Map<Integer,Integer> substituicoesEquipa1 = new HashMap<>();
        substituicoesEquipa1.put(Integer.parseInt(campos[16].split("->")[0]),
                Integer.parseInt(campos[16].split("->")[1]));
        substituicoesEquipa1.put(Integer.parseInt(campos[17].split("->")[0]),
                Integer.parseInt(campos[17].split("->")[1]));
        substituicoesEquipa1.put(Integer.parseInt(campos[18].split("->")[0]),
                Integer.parseInt(campos[18].split("->")[1]));
        Map<Integer,Integer> substituicoesEquipa2 = new HashMap<>();
        substituicoesEquipa2.put(Integer.parseInt(campos[30].split("->")[0]),
                Integer.parseInt(campos[30].split("->")[1]));
        substituicoesEquipa2.put(Integer.parseInt(campos[31].split("->")[0]),
                Integer.parseInt(campos[31].split("->")[1]));
        substituicoesEquipa2.put(Integer.parseInt(campos[32].split("->")[0]),
                Integer.parseInt(campos[32].split("->")[1]));

        return new Jogo(
                90,
                Estado.TERMINADO,
                equipa1,
                equipa2,
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                jogadoresEquipa1,
                jogadoresEquipa2,
                substituicoesEquipa1,
                substituicoesEquipa2
        );
    }

    /**
     * Getter da data do jogo
     * @return Data do jogo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Setter da data do jogo
     * @param tempo Data do jogo
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    /**
     * Getter do estado do jogo
     * @return Estado do jogo
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Setter do estado do jogo
     * @param estado estado do jogo
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Getter da equipa da casa
     * @return Equipa da casa
     */
    public Equipa getEquipa1() {
        return equipa1.clone();
    }

    /**
     * Setter da equipa da casa
     * @param equipa1 Equipa da casa
     */
    public void setEquipa1(Equipa equipa1) {
        this.equipa1 = equipa1.clone();
    }

    /**
     * Getter da equipa visitante
     * @return Equipa visitante
     */
    public Equipa getEquipa2() {
        return equipa2.clone();
    }

    /**
     * Setter da equipa visitante
     * @param equipa2 Equipa visitante
     */
    public void setEquipa2(Equipa equipa2) {
        this.equipa2 = equipa2.clone();
    }

    /**
     * Getter golos da equipa da casa
     * @return Golos da equipa da casa
     */
    public int getGolosVisitada() {
        return golosVisitada;
    }
    /**
     * Setter golos da equipa da casa
     * @param golosVisitada Golos da equipa da casa
     */
    public void setGolosVisitada(int golosVisitada) {
        this.golosVisitada = golosVisitada;
    }

    /**
     * Getter golos da equipa visitante
     * @return Golos da equipa visitante
     */
    public int getGolosVisitante() {
        return golosVisitante;
    }

    /**
     * Setter dos golos da equipa visitante
     * @param golosVisitante Golos da equipa visitante
     */
    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    /**
     * Getter dos jogadores da equipa da casa
     * @return Lista de jogadores da equipa da casa
     */
    public List<Jogador> getJogadoresEquipa1() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.jogadoresEquipa1){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    /**
     * Setter dos jogadores da equipa da casa
     * @param jogadoresEquipa1 Lista de jogadores da equipa da casa
     */
    public void setJogadoresEquipa1(List<Jogador> jogadoresEquipa1) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador: jogadoresEquipa1){
            newArr.add(jogador.clone());
        }
        this.jogadoresEquipa1 = newArr;
    }

    /**
     * Getter dos jogadores da equipa visitante
     * @return Lista de jogadores da equipa visitante
     */
    public List<Jogador> getJogadoresEquipa2() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.jogadoresEquipa2){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    /**
     * Setter dos jogadores da equipa visitante
     * @param jogadoresEquipa2 Lista de jogadores da equipa visitante
     */
    public void setJogadoresEquipa2(List<Jogador> jogadoresEquipa2) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador: jogadoresEquipa2){
            newArr.add(jogador.clone());
        }
        this.jogadoresEquipa2 = newArr;
    }

    /**
     * Getter da tática da equipa da casa
     * @return Tática da equipa da casa
     */
    public TaticaEquipa getTaticaEquipa1() {
        return taticaEquipa1;
    }

    /**
     * Setter da tática da equipa da casa
     * @param taticaEquipa1 tática da equipa da casa
     */
    public void setTaticaEquipa1(TaticaEquipa taticaEquipa1) {
        this.taticaEquipa1 = taticaEquipa1;
    }

    /**
     * Getter da tática da equipa visitante
     * @return Tática da equipa visitante
     */
    public TaticaEquipa getTaticaEquipa2() {
        return taticaEquipa2;
    }

    /**
     * Setter da tática da equipa visitante
     * @param taticaEquipa2 tática da equipa visitante
     */
    public void setTaticaEquipa2(TaticaEquipa taticaEquipa2) {
        this.taticaEquipa2 = taticaEquipa2;
    }

    /**
     * Getter das substituições da equipa da casa
     * @return Mapa das substituições da equipa da casa
     */
    public Map<Integer, Integer> getSubstituicoesEquipa1() {
        return new HashMap<>(this.substituicoesEquipa1);
    }

    /**
     * Setter das substituições da equipa da casa
     * @param substituicoesEquipa1 Mapa das substituições da equipa da casa
     */
    public void setSubstituicoesEquipa1(Map<Integer, Integer> substituicoesEquipa1) {
        this.substituicoesEquipa1 = new HashMap<>(substituicoesEquipa1);
    }

    /**
     * Getter das substituições da equipa visitante
     * @return Mapa das substituições da equipa visitante
     */
    public Map<Integer, Integer> getSubstituicoesEquipa2() {
        return new HashMap<>(this.substituicoesEquipa2);
    }

    /**
     * Setter das substituições da equipa visitante
     * @param substituicoesEquipa2 Mapa das substituições da equipa visitante
     */
    public void setSubstituicoesEquipa2(Map<Integer, Integer> substituicoesEquipa2) {
        this.substituicoesEquipa2 = new HashMap<>(substituicoesEquipa2);
    }

    /**
     * Função que devolve o overall da equipa incial
     * @param jogs lista de jogadores que vão jogar de inicio
     * @return Overall da equipa titular
     */
    public float overallTits(List<Jogador> jogs){
        float overall = 0;
        int size = 0;
        for(Jogador jogador : jogs){
            overall+=jogador.calculaOverall();
            ++size;
        }
        return overall/size;
    }

    /**
     * Função que permite simular o resultado de um jogo
     */
    public void simulacao_part1(){
        int i=9;
        float over1=overallTits(this.jogadoresEquipa1);
        float over2=overallTits(this.jogadoresEquipa2);
        while(i>0){
            Random ran=new Random();
            int ranN= ran.nextInt(10);
            if(over1>over2){
                //0 1 2 3 para e1
                //9 para e2
                //4 5 6 7 8
                float ratio=over2/over1;
                int superi=numOps(ratio);
                //nada  para 2->1,2,3,4,5,6
                if(ranN>=9-superi){//para 2->7,8,9; para 3-> 6,7,8,9; para 4->5,6,7,8,9
                    this.golosVisitada++;
                }
                else if(superi==2 && ranN<=1){//0
                    this.golosVisitante++;
                }
                else if(superi>2 && ranN<=0){//0
                    this.golosVisitante++;
                }
            }
            else if(over1<over2){
                //0 para a e1
                //9
                //1 2 3 4 5 6
                float ratio=over1/over2;
                int superi=numOps(ratio);
                //nada  para 2->1,2,3,4,5,6
                if(ranN>=9-superi){//para 2->7,8,9; para 3-> 6,7,8,9; para 4->5,6,7,8,9
                    this.golosVisitante++;
                }
                else if(superi==2 && ranN<=1){//0
                    this.golosVisitada++;
                }
                else if(superi>2 && ranN<=0){//0
                    this.golosVisitada++;
                }

            }
            else{
                //0 e 1 e 2 para a e1
                //9 e 8 e 7 para a e2
                //3 4 5 6  para nada
                if(ranN<=1){
                    this.golosVisitada++;
                }
                else if(ranN>=8){
                    this.golosVisitante++;
                }
            }


            --i;
        }

    }

    /**
     * Função que retorna um jogador através do número da camisola
     * @param lista Lista de jogadores
     * @param num Número da camisola
     * @return Jogador correspondente
     */
    private Jogador getJogad_fromNum(List<Jogador> lista,int num){
        for(Jogador jog:lista){
            if(jog.getnCamisola()==num){
                return jog;
            }
        }
        return null;
    }

    /**
     * Função que simula a segunda parte do jogo de acordo com as substiuições efetuadas ao intervalo
     * @param subs1 Substituições feitas à equipa da casa
     * @param subs2 Substituições feitas à equipa visitante
     */
    public void simulacao_part2(Map<Integer,Integer> subs1,Map<Integer,Integer> subs2){
        //mudar a lista de titulares de acordo com as sub
        if(!subs1.isEmpty()) {
            Map<Integer, Integer> newSubs1 = new HashMap<>();
            List<Jogador> newJogadores1 = new ArrayList<>();
            System.out.println("Substituições da Equipa 1:");
            for (Map.Entry<Integer, Integer> entry : subs1.entrySet()) {
                if (entry.getKey() != 0) {
                    newSubs1.put(entry.getKey(), entry.getValue());
                    System.out.println("\tO jogador->" + entry.getValue() + " substituiu " + entry.getKey());
                } else {
                    continue;
                }
                for (Jogador jog : this.getJogadoresEquipa1()) {
                    if (jog.getnCamisola() != entry.getKey()) {
                        newJogadores1.add(jog);
                    } else {
                        Jogador xjogador = getJogad_fromNum(this.getEquipa1().getJogadores(), entry.getValue());
                        if (xjogador != null) {
                            newJogadores1.add(xjogador);
                        }
                    }
                }
            }
            setSubstituicoesEquipa1(newSubs1);
            setJogadoresEquipa1(newJogadores1);
        }
        if(!subs2.isEmpty()) {
            Map<Integer,Integer> newSubs=new HashMap<>();
            List<Jogador> newJogadores=new ArrayList<>();
            System.out.println("Substituições da Equipa 2:");
            for(Map.Entry<Integer,Integer> entry: subs2.entrySet()){
                if(entry.getKey()!=0){
                    newSubs.put(entry.getKey(),entry.getValue());
                    System.out.println("\tO jogador->" + entry.getValue() + " substituiu " + entry.getKey());
                }
                else{
                    continue;
                }
                for(Jogador jog:this.getJogadoresEquipa2()){
                    if(jog.getnCamisola()!=entry.getKey()){
                        newJogadores.add(jog);
                    }
                    else{
                        Jogador xjogador=getJogad_fromNum(this.getEquipa2().getJogadores(), entry.getValue());
                        if(xjogador!=null){
                            newJogadores.add(xjogador);
                        }
                    }
                }
            }
            setSubstituicoesEquipa2(newSubs);
            setJogadoresEquipa2(newJogadores);
        }
        int i=9;
        float over1=overallTits(this.jogadoresEquipa1);
        float over2=overallTits(this.jogadoresEquipa2);
        while(i>0){
            Random ran=new Random();
            int ranN= ran.nextInt(10);
            if(over1>over2){
                //0 1 2 3 para e1
                //9 para e2
                //4 5 6 7 8
                float ratio=over2/over1;
                int superi=numOps(ratio);
                //nada  para 2->1,2,3,4,5,6
                if(ranN>=9-superi){//para 2->7,8,9; para 3-> 6,7,8,9; para 4->5,6,7,8,9
                    this.golosVisitada++;
                }
                else if(superi==2 && ranN<=1){//0
                    this.golosVisitante++;
                }
                else if(superi>2 && ranN<=0){//0
                    this.golosVisitante++;
                }
            }
            else if(over1<over2){
                //0 para a e1
                //9
                //1 2 3 4 5 6
                float ratio=over1/over2;
                int superi=numOps(ratio);
                //nada  para 2->1,2,3,4,5,6
                if(ranN>=9-superi){//para 2->7,8,9; para 3-> 6,7,8,9; para 4->5,6,7,8,9
                    this.golosVisitante++;
                }
                else if(superi==2 && ranN<=1){//0
                    this.golosVisitada++;
                }
                else if(superi>2 && ranN<=0){//0
                    this.golosVisitada++;
                }

            }
            else{
                //0 e 1 e 2 para a e1
                //9 e 8 e 7 para a e2
                //3 4 5 6  para nada
                if(ranN<=1){
                    this.golosVisitada++;
                }
                else if(ranN>=8){
                    this.golosVisitante++;
                }
            }


            --i;
        }
    }

    /**
     * Função que indica o número de oportunidades da equipa
     * @param ratio Valor que compara as duas equipas
     * @return Retorna o número de oportunidades da equipa
     */
    private int numOps(float ratio){
        float ya=ratio*10;
        if(ya<1.25){
            return 3;
        }
        else if(ya<2.5){
            return 4;
        }
        return 2;
    }

    /**
     * Função que indica a informação que pretende ser impressa
     * @return Informação imprimida
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jogo{");
        sb.append("tempo=").append(tempo).append('\n');
        sb.append(", estado=").append(estado).append('\n');
        sb.append(", equipa1=").append(equipa1).append('\n');
        sb.append(", equipa2=").append(equipa2).append('\n');
        sb.append(", golosVisitado=").append(golosVisitada).append('\n');
        sb.append(", golosVisitante=").append(golosVisitante).append('\n');
        sb.append(", formacaoEquipa1=").append(jogadoresEquipa1).append('\n');
        sb.append(", formacaoEquipa2=").append(jogadoresEquipa2).append('\n');
        sb.append('}').append('\n');
        return sb.toString();
    }

    /**
     * Função que verifca a igualdade dos objetos
     * @param o Objeto da classe
     * @return Boleano que indica se é igual
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogo jogo = (Jogo) o;

        if (tempo != jogo.tempo) return false;
        if (golosVisitada != jogo.golosVisitada) return false;
        if (golosVisitante != jogo.golosVisitante) return false;
        if (estado != jogo.estado) return false;
        if (equipa1 != null ? !equipa1.equals(jogo.equipa1) : jogo.equipa1 != null) return false;
        if (equipa2 != null ? !equipa2.equals(jogo.equipa2) : jogo.equipa2 != null) return false;
        if (jogadoresEquipa1 != null ? !jogadoresEquipa1.equals(jogo.jogadoresEquipa1) : jogo.jogadoresEquipa1 != null)
            return false;
        return jogadoresEquipa2 != null ? jogadoresEquipa2.equals(jogo.jogadoresEquipa2) :
                jogo.jogadoresEquipa2 == null;
    }

    /**
     * Funçao que faz o clone
     * @return o clone do Objeto Jogo
     */
    @Override
    public Jogo clone(){
        return new Jogo(this);
    }
}
