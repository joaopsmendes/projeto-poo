import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipa {
    private String nome;
    private LocalDate fundacaoEquipa;
    private List<Jogador> jogadores;

    public Equipa(){
        this.nome = null;
        this.fundacaoEquipa = null;
        this.jogadores = null;
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
                this.fundacaoEquipa.getYear(),
                this.fundacaoEquipa.getMonth(),
                this.fundacaoEquipa.getDayOfMonth()
        );
    }

    public List<Jogador> getJogadores() {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : this.getJogadores()){
            newArray.add(jogador.clone());
        }
        return newArray;
    }

    public void setJogadores(List<Jogador> joagadores) {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : this.getJogadores()){
            newArray.add(jogador.clone());
        }
        this.jogadores = newArray;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipa{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", fundacaoEquipa=").append(fundacaoEquipa);
        sb.append(", jogadores=").append(jogadores);
        sb.append('}');
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
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (fundacaoEquipa != null ? fundacaoEquipa.hashCode() : 0);
        result = 31 * result + (jogadores != null ? jogadores.hashCode() : 0);
        return result;
    }

    @Override
    public Equipa clone() {
        return new Equipa(this);
    }
}