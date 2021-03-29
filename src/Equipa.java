import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Equipa {
    private String Nome;
    private int habilidadeGlobal;
    //private LocalDateTime fundacaoEquipa;
    private List<Jogador> joagadores; //duvidas
    //private ArrayList<Integer> formacao; (array 5 por 5)


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getHabilidadeGlobal() {
        return habilidadeGlobal;
    }

    public void setHabilidadeGlobal(int habilidadeGlobal) {
        this.habilidadeGlobal = habilidadeGlobal;
    }

    public List<Jogador> getJoagadores() {
        return joagadores;
    }

    public void setJoagadores(List<Jogador> joagadores) {
        this.joagadores = joagadores;
    }

}
