import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipa {
    private String nome;
    private LocalDate fundacaoEquipa;
    private List<Jogador> jogadores;

    public Equipa(){
        this.nome = "";
        this.fundacaoEquipa = null;
        this.jogadores = new ArrayList<>();
    }

    public Equipa(String nome, LocalDate fundacaoEquipa, List<Jogador> jogadores) {
        this.nome = nome;
        setFundacaoEquipa(fundacaoEquipa);
        setJogadores(jogadores);
    }

    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        setFundacaoEquipa(equipa.getFundacaoEquipa());
        setJogadores(equipa.getJogadores());
    }

    public Jogador obterJogadorPeloNumero(int numero){
        for(Jogador jg : this.jogadores){
            if (jg.getnCamisola() == numero)
                return jg;
        }
        return null;
    }

    public int calculaOverall(){
        int overall = 0, size = 0;
        for(Jogador jogador : this.jogadores){
            for(Integer atual : jogador.getSkills().values()){
                overall += atual;
                size++;
            }
        }
        return overall/size;
    }

    public void insereJogador(Jogador jogador){
        this.jogadores.add(jogador.clone());
    }

    public void removeJogador(Jogador jogador){
        this.jogadores.remove(jogador);
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getFundacaoEquipa() {
        return LocalDate.of(
                this.fundacaoEquipa.getYear(),
                this.fundacaoEquipa.getMonth(),
                this.fundacaoEquipa.getDayOfMonth()
        );
    }

    public void setFundacaoEquipa(LocalDate fundacaoEquipa) {
        this.fundacaoEquipa = LocalDate.of(
                fundacaoEquipa.getYear(),
                fundacaoEquipa.getMonth(),
                fundacaoEquipa.getDayOfMonth()
        );
    }

    public List<Jogador> getJogadores() {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : this.jogadores){
            newArray.add(jogador.clone());
        }
        return newArray;
    }

    public void setJogadores(List<Jogador> jogadores) {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : jogadores){
            newArray.add(jogador.clone());
        }
        this.jogadores = newArray;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipa{");
        sb.append("nome='").append(nome).append('\'').append('\n');
        sb.append(", fundacaoEquipa=").append(fundacaoEquipa).append('\n');
        sb.append(", jogadores=").append(jogadores).append('\n');
        sb.append('}').append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipa equipa = (Equipa) o;

        if (!Objects.equals(nome, equipa.nome)) return false;
        if (!Objects.equals(fundacaoEquipa, equipa.fundacaoEquipa)) return false;
        return Objects.equals(jogadores, equipa.jogadores);
    }

    @Override
    public Equipa clone() {
        return new Equipa(this);
    }
}