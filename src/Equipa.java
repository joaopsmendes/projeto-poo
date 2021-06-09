/**
 * Criação do objeto Jogo
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Equipa {
    private String nome;
    private LocalDate fundacaoEquipa;
    private List<Jogador> jogadores;

    /**
     * Criação do construtor vazio
     */
    public Equipa(){
        this.nome = "";
        this.fundacaoEquipa = null;
        this.jogadores = new ArrayList<>();
    }

    /**
     * Crição do construtor parametrizado
     * @param nome
     * @param fundacaoEquipa
     * @param jogadores
     */
    public Equipa(String nome, LocalDate fundacaoEquipa, List<Jogador> jogadores) {
        this.nome = nome;
        setFundacaoEquipa(fundacaoEquipa);
        setJogadores(jogadores);
    }

    /**
     * Crição do construtor cópia
     * @param equipa
     */
    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        setFundacaoEquipa(equipa.getFundacaoEquipa());
        setJogadores(equipa.getJogadores());
    }

    /**
     * Funçao que permite obter o jogador a partir do numero de camisola
     *
     * @param numero
     * @return o jogador
     */
    public Jogador obterJogadorPeloNumero(int numero){
        for(Jogador jg : this.jogadores){
            if (jg.getnCamisola() == numero)
                return jg;
        }
        return null;
    }

    /**
     * Funçao que permite calcular o overall da equipa
     *
     * @return o overall da equipa
     */
    public float calculaOverall(){
        float overall = 0;
        int size = 0;
        for(Jogador jogador : this.jogadores){
            overall+=jogador.calculaOverall();
            ++size;
        }
        return overall/size;
    }

    /**
     * Funçao que permite adicionar um jogador a uma equipa
     * @param jogador
     */
    public void insereJogador(Jogador jogador){
        this.jogadores.add(jogador.clone());
    }

    /**
     * Função que permite remover um jogador de uma certa equipa
     * @param jogador
     */
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

    /**
     * Funçao que indica a informaçao que pretende ser impressa
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipa{");
        sb.append("nome='").append(nome).append('\'').append('\n');
        sb.append(", fundacaoEquipa=").append(fundacaoEquipa).append('\n');
        sb.append(", jogadores=").append(jogadores).append('\n');
        sb.append('}').append('\n');
        return sb.toString();
    }

    /**
     * Funçao que permite igualar
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipa equipa = (Equipa) o;

        if (!Objects.equals(nome, equipa.nome)) return false;
        if (!Objects.equals(fundacaoEquipa, equipa.fundacaoEquipa)) return false;
        return Objects.equals(jogadores, equipa.jogadores);
    }

    /**
     * Funçao que faz o clone
     * @return o clone do Objeto Equipa
     */
    @Override
    public Equipa clone() {
        return new Equipa(this);
    }
}