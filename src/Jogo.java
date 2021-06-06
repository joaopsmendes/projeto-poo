import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    private int tempo; // segundos (120 = 2:00) / (110 = 1:50)
    private Estado estado;
    private Equipa equipa1;
    private Equipa equipa2;
    private int golosVisitado;
    private int golosVisitante;
    private List<Jogador> formacaoEquipa1;
    private List<Jogador> formacaoEquipa2;
    private Map<Integer, Integer> substituicoesEquipa1;
    private Map<Integer, Integer> substituicoesEquipa2;

    public Jogo(){
        this.tempo = 0;
        this.estado = Estado.POR_INICIAR;
        this.equipa1 = new Equipa();
        this.equipa2 = new Equipa();
        this.golosVisitado = 0;
        this.golosVisitante = 0;
        this.formacaoEquipa1 = new ArrayList<>();
        this.formacaoEquipa2 = new ArrayList<>();
        this.substituicoesEquipa1 = new HashMap<>();
        this.substituicoesEquipa2 = new HashMap<>();
    }

    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitado,
                int golosVisitante, List<Jogador> formacaoEquipa1, List<Jogador> formacaoEquipa2,
                Map<Integer, Integer> substituicoesEquipa1, Map<Integer, Integer> substituicoesEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
        setFormacaoEquipa1(formacaoEquipa1);
        setFormacaoEquipa2(formacaoEquipa2);
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
        setFormacaoEquipa1(jogo.getFormacaoEquipa1());
        setFormacaoEquipa2(jogo.getFormacaoEquipa2());
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

    public List<Jogador> getFormacaoEquipa1() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.formacaoEquipa1){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    public void setFormacaoEquipa1(List<Jogador> formacaoEquipa1) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:formacaoEquipa1){
            newArr.add(jogador.clone());
        }
        this.formacaoEquipa1 = newArr;
    }

    public List<Jogador> getFormacaoEquipa2() {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:this.formacaoEquipa2){
            newArr.add(jogador.clone());
        }
        return newArr;
    }

    public void setFormacaoEquipa2(List<Jogador> formacaoEquipa2) {
        List<Jogador> newArr = new ArrayList<>();
        for(Jogador jogador:formacaoEquipa2){
            newArr.add(jogador.clone());
        }
        this.formacaoEquipa2 = newArr;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jogo{");
        sb.append("tempo=").append(tempo).append('\n');
        sb.append(", estado=").append(estado).append('\n');
        sb.append(", equipa1=").append(equipa1).append('\n');
        sb.append(", equipa2=").append(equipa2).append('\n');
        sb.append(", golosVisitado=").append(golosVisitado).append('\n');
        sb.append(", golosVisitante=").append(golosVisitante).append('\n');
        sb.append(", formacaoEquipa1=").append(formacaoEquipa1).append('\n');
        sb.append(", formacaoEquipa2=").append(formacaoEquipa2).append('\n');
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
        if (formacaoEquipa1 != null ? !formacaoEquipa1.equals(jogo.formacaoEquipa1) : jogo.formacaoEquipa1 != null)
            return false;
        return formacaoEquipa2 != null ? formacaoEquipa2.equals(jogo.formacaoEquipa2) : jogo.formacaoEquipa2 == null;
    }

    @Override
    public Jogo clone(){
        return new Jogo(this);
    }
}
