import java.util.*;
import java.util.stream.Collectors;

public class Jogo {
    private int tempo; // segundos (120 = 2:00) / (110 = 1:50)
    private Estado estado;
    private Equipa equipa1;
    private Equipa equipa2;
    private int golosVisitado;
    private int golosVisitante;
    private List<Jogador> jogadoresEquipa1;
    private List<Jogador> jogadoresEquipa2;
    private TaticaEquipa taticaEquipa1;
    private TaticaEquipa taticaEquipa2;
    private Map<Integer, Integer> substituicoesEquipa1;
    private Map<Integer, Integer> substituicoesEquipa2;

    public Jogo(){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        this.equipa1 = new Equipa();
        this.equipa2 = new Equipa();
        this.golosVisitado = 0;
        this.golosVisitante = 0;
        this.jogadoresEquipa1 = new ArrayList<>();
        this.jogadoresEquipa2 = new ArrayList<>();
        this.taticaEquipa1 = TaticaEquipa.QUATRO_TRES_TRES;
        this.taticaEquipa2 = TaticaEquipa.QUATRO_TRES_TRES;
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    public Jogo(Equipa equipa1, Equipa equipa2, TaticaEquipa taticaEquipa1, TaticaEquipa taticaEquipa2){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = 0;
        this.golosVisitante = 0;
        this.jogadoresEquipa1 = this.equipa1.getJogadores().stream().limit(11).collect(Collectors.toList());
        this.jogadoresEquipa2 = this.equipa2.getJogadores().stream().limit(11).collect(Collectors.toList());
        this.taticaEquipa1 = taticaEquipa1;
        this.taticaEquipa2 = taticaEquipa2;
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitado,
                int golosVisitante, List<Jogador> jogadoresEquipa1, List<Jogador> jogadoresEquipa2,
                Map<Integer, Integer> substituicoesEquipa1, Map<Integer, Integer> substituicoesEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
        setJogadoresEquipa1(jogadoresEquipa1);
        setJogadoresEquipa2(jogadoresEquipa2);
        this.taticaEquipa1 = TaticaEquipa.QUATRO_TRES_TRES;
        this.taticaEquipa2 = TaticaEquipa.QUATRO_TRES_TRES;
        setSubstituicoesEquipa1(substituicoesEquipa1);
        setSubstituicoesEquipa2(substituicoesEquipa2);
    }

    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitado,
                int golosVisitante, List<Jogador> jogadoresEquipa1, List<Jogador> jogadoresEquipa2, TaticaEquipa taticaEquipa1,
                TaticaEquipa taticaEquipa2, Map<Integer, Integer> substituicoesEquipa1,
                Map<Integer, Integer> substituicoesEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
        setJogadoresEquipa1(jogadoresEquipa1);
        setJogadoresEquipa2(jogadoresEquipa2);
        this.taticaEquipa1 = taticaEquipa1;
        this.taticaEquipa2 = taticaEquipa2;
        setSubstituicoesEquipa1(substituicoesEquipa1);
        setSubstituicoesEquipa2(substituicoesEquipa2);
    }

    public Jogo(Jogo jogo){
        this.tempo = jogo.getTempo();
        this.estado = jogo.getEstado();
        setEquipa1(jogo.getEquipa1());
        setEquipa2(jogo.getEquipa2());
        this.golosVisitado = jogo.getGolosVisitado();
        this.golosVisitante = jogo.getGolosVisitante();
        setJogadoresEquipa1(jogo.getJogadoresEquipa1());
        setJogadoresEquipa2(jogo.getJogadoresEquipa2());
        this.taticaEquipa1 = jogo.getTaticaEquipa1();
        this.taticaEquipa2 = jogo.getTaticaEquipa2();
        setSubstituicoesEquipa1(jogo.getSubstituicoesEquipa1());
        setSubstituicoesEquipa2(jogo.getSubstituicoesEquipa2());
    }

    public enum Estado{
        POR_INICIAR,
        PRIMEIRA_PARTE,
        INTERVALO,
        SEGUNDA_PARTE,
        TERMINADO
    }

    public enum TaticaEquipa{
        QUATRO_QUATRO_DOIS,
        QUATRO_TRES_TRES,
        QUATRO_DOIS_QUATRO,
        QUATRO_DOIS_TRES_UM
    }

    public static Jogo parser(String input, Map<String, Equipa> equipas) throws NumberFormatException{
//        Bach F. C.,Sporting Club Shostakovich,1,3,2021-02-02,4,47,35,2,36,39,14,43,5,32,50,14->0,4->30,36->21,43,30,1,22,33,11,38,31,39,6,12,43->3,31->34,12->20
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
        substituicoesEquipa1.put(Integer.parseInt(campos[16].split("->")[0]), Integer.parseInt(campos[16].split("->")[1]));
        substituicoesEquipa1.put(Integer.parseInt(campos[17].split("->")[0]), Integer.parseInt(campos[17].split("->")[1]));
        substituicoesEquipa1.put(Integer.parseInt(campos[18].split("->")[0]), Integer.parseInt(campos[18].split("->")[1]));
        Map<Integer,Integer> substituicoesEquipa2 = new HashMap<>();
        substituicoesEquipa2.put(Integer.parseInt(campos[30].split("->")[0]), Integer.parseInt(campos[30].split("->")[1]));
        substituicoesEquipa2.put(Integer.parseInt(campos[31].split("->")[0]), Integer.parseInt(campos[31].split("->")[1]));
        substituicoesEquipa2.put(Integer.parseInt(campos[32].split("->")[0]), Integer.parseInt(campos[32].split("->")[1]));

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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Equipa getEquipa1() {
        return equipa1.clone();
    }

    public void setEquipa1(Equipa equipa1) {
        this.equipa1 = equipa1.clone();
    }

    public Equipa getEquipa2() {
        return equipa2.clone();
    }

    public void setEquipa2(Equipa equipa2) {
        this.equipa2 = equipa2.clone();
    }

    public int getGolosVisitado() {
        return golosVisitado;
    }

    public void setGolosVisitado(int golosVisitado) {
        this.golosVisitado = golosVisitado;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public List<Jogador> getJogadoresEquipa1() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.jogadoresEquipa1){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    public void setJogadoresEquipa1(List<Jogador> jogadoresEquipa1) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador: jogadoresEquipa1){
            newArr.add(jogador.clone());
        }
        this.jogadoresEquipa1 = newArr;
    }

    public List<Jogador> getJogadoresEquipa2() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.jogadoresEquipa2){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    public void setJogadoresEquipa2(List<Jogador> jogadoresEquipa2) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador: jogadoresEquipa2){
            newArr.add(jogador.clone());
        }
        this.jogadoresEquipa2 = newArr;
    }

    public TaticaEquipa getTaticaEquipa1() {
        return taticaEquipa1;
    }

    public void setTaticaEquipa1(TaticaEquipa taticaEquipa1) {
        this.taticaEquipa1 = taticaEquipa1;
    }

    public TaticaEquipa getTaticaEquipa2() {
        return taticaEquipa2;
    }

    public void setTaticaEquipa2(TaticaEquipa taticaEquipa2) {
        this.taticaEquipa2 = taticaEquipa2;
    }

    public Map<Integer, Integer> getSubstituicoesEquipa1() {
        return new HashMap<>(this.substituicoesEquipa1);
    }

    public void setSubstituicoesEquipa1(Map<Integer, Integer> substituicoesEquipa1) {
        this.substituicoesEquipa1 = new HashMap<>(substituicoesEquipa1);
    }

    public Map<Integer, Integer> getSubstituicoesEquipa2() {
        return new HashMap<>(this.substituicoesEquipa2);
    }

    public void setSubstituicoesEquipa2(Map<Integer, Integer> substituicoesEquipa2) {
        this.substituicoesEquipa2 = new HashMap<>(substituicoesEquipa2);
    }

    public void printJogo(){
        System.out.println("[Jogo] "
                + this.getEquipa1().getNome() + " : "
                + this.getGolosVisitado() + " vs " + this.getGolosVisitante() + " : "
                + this.getEquipa2().getNome());
    }

    public int overallTits(List<Jogador> jogs){
        int overall = 0, size = 0;
        for(Jogador jogador : jogs){
            //mudar para ter os atacantes melhor pelo remate
            for(Integer atual : jogador.getSkills().values()){
                overall += atual;
                size++;
            }
        }
        return overall/size;
    }

    public void simulacao(){
        int i=18;
        int over1=overallTits(this.jogadoresEquipa1);
        int over2=overallTits(this.jogadoresEquipa1);
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
                    this.golosVisitado++;
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
                    this.golosVisitado++;
                }
                else if(superi>2 && ranN<=0){//0
                    this.golosVisitado++;
                }

            }
            else{
                //0 e 1 e 2 para a e1
                //9 e 8 e 7 para a e2
                //3 4 5 6  para nada
                if(ranN<=1){
                    this.golosVisitado++;
                }
                else if(ranN>=8){
                    this.golosVisitante++;
                }
            }


            --i;
        }

    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jogo{");
        sb.append("tempo=").append(tempo).append('\n');
        sb.append(", estado=").append(estado).append('\n');
        sb.append(", equipa1=").append(equipa1).append('\n');
        sb.append(", equipa2=").append(equipa2).append('\n');
        sb.append(", golosVisitado=").append(golosVisitado).append('\n');
        sb.append(", golosVisitante=").append(golosVisitante).append('\n');
        sb.append(", formacaoEquipa1=").append(jogadoresEquipa1).append('\n');
        sb.append(", formacaoEquipa2=").append(jogadoresEquipa2).append('\n');
        sb.append('}').append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogo jogo = (Jogo) o;

        if (tempo != jogo.tempo) return false;
        if (golosVisitado != jogo.golosVisitado) return false;
        if (golosVisitante != jogo.golosVisitante) return false;
        if (estado != jogo.estado) return false;
        if (equipa1 != null ? !equipa1.equals(jogo.equipa1) : jogo.equipa1 != null) return false;
        if (equipa2 != null ? !equipa2.equals(jogo.equipa2) : jogo.equipa2 != null) return false;
        if (jogadoresEquipa1 != null ? !jogadoresEquipa1.equals(jogo.jogadoresEquipa1) : jogo.jogadoresEquipa1 != null)
            return false;
        return jogadoresEquipa2 != null ? jogadoresEquipa2.equals(jogo.jogadoresEquipa2) : jogo.jogadoresEquipa2 == null;
    }

    @Override
    public Jogo clone(){
        return new Jogo(this);
    }
}
