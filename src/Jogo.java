import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private int tempo; // segundos (120 = 2:00) / (110 = 1:50)
    private Estado estado;
    private Equipa equipa1;
    private Equipa equipa2;
    private int golosVisitado;
    private int golosVisitante;
    private List<Jogador> formacaoEquipa1;
    private List<Jogador> formacaoEquipa2;

    public Jogo(){
        this.tempo = 0;
        this.estado = null;
        this.equipa1 = null;
        this.equipa2 = null;
        this.golosVisitado = 0;
        this.golosVisitante = 0;
        this.formacaoEquipa1 = null;
        this.formacaoEquipa2 = null;
    }

    public Jogo(int tempo, Estado estado, Equipa equipa1, Equipa equipa2, int golosVisitado,
                int golosVisitante, List<Jogador> formacaoEquipa1, List<Jogador> formacaoEquipa2) {
        this.tempo = tempo;
        this.estado = estado;
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
        setFormacaoEquipa1(formacaoEquipa1);
        setFormacaoEquipa2(formacaoEquipa2);
    }

    public Jogo(Jogo jogo){
        this.tempo = jogo.getTempo();
        this.estado = jogo.getEstado();
        setEquipa1(equipa1);
        setEquipa2(equipa2);
        this.golosVisitado = jogo.getGolosVisitado();
        this.golosVisitante = jogo.getGolosVisitante();
        setFormacaoEquipa1(jogo.getFormacaoEquipa1());
        setFormacaoEquipa2(jogo.getFormacaoEquipa2());
    }

    public enum Estado{
        POR_INICIAR,
        PRIMEIRA_PARTE,
        INTERVALO,
        SEGUNDA_PARTE,
        TERMINADO
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
