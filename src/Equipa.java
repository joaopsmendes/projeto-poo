/**
 * Criação do objeto Jogo
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Equipa implements Serializable {
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
     * @param nome Nome da equipa
     * @param fundacaoEquipa Ano que a equipa foi fundada
     * @param jogadores Jogadores dessa equipa
     */
    public Equipa(String nome, LocalDate fundacaoEquipa, List<Jogador> jogadores) {
        this.nome = nome;
        setFundacaoEquipa(fundacaoEquipa);
        setJogadores(jogadores);
    }

    /**
     * Criação do construtor cópia
     * @param equipa Objeto Equipa
     */
    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        setFundacaoEquipa(equipa.getFundacaoEquipa());
        setJogadores(equipa.getJogadores());
    }

    /**
     * Função que permite obter o jogador a partir do número de camisola
     * @param numero número da camisola
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
     * Função que permite calcular o overall da equipa
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
     * Função que permite adicionar um jogador a uma equipa
     * @param jogador Jogador a ser adicionado
     */
    public void insereJogador(Jogador jogador){
        this.jogadores.add(jogador.clone());
    }

    /**
     * Função que permite remover um jogador de uma certa equipa
     * @param jogador Jogador a ser retirado da equipa
     */
    public void removeJogador(Jogador jogador){
        this.jogadores.remove(jogador);
    }

    /**
     * Getter do nome da equipa
     * @return Nome da equipa
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Setter do nome da equipa
     * @param nome Nome da equipa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter da data que a equipa foi fundada
     * @return Data em que a equipa foi fundada
     */
    public LocalDate getFundacaoEquipa() {
        return LocalDate.of(
                this.fundacaoEquipa.getYear(),
                this.fundacaoEquipa.getMonth(),
                this.fundacaoEquipa.getDayOfMonth()
        );
    }

    /**
     * Setter da data que a equipa foi fundada
     * @param fundacaoEquipa Data de fundação
     */
    public void setFundacaoEquipa(LocalDate fundacaoEquipa) {
        this.fundacaoEquipa = LocalDate.of(
                fundacaoEquipa.getYear(),
                fundacaoEquipa.getMonth(),
                fundacaoEquipa.getDayOfMonth()
        );
    }

    /**
     * Getter da lista de jogadores dessa equipa
     * @return Lista de jogadores
     */
    public List<Jogador> getJogadores() {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : this.jogadores){
            newArray.add(jogador.clone());
        }
        return newArray;
    }

    /**
     * Setter da lista de jogadores
     * @param jogadores Jogadores da equipa
     */
    public void setJogadores(List<Jogador> jogadores) {
        List<Jogador> newArray = new ArrayList<>();
        for(Jogador jogador : jogadores){
            newArray.add(jogador.clone());
        }
        this.jogadores = newArray;
    }

    /**
     * Função que imprime numa String a equipa e os seus jogadores
     * @return String com as informações
     */
    public String printFile(){
        StringBuilder sb=new StringBuilder();
        sb.append("Equipa:" + getNome() + "\n");
        for(Jogador jog:getJogadores()){
            sb.append(printPos(jog.getPosicao()) + jog.getNome() + "," + jog.getnCamisola() + "," +
                    printHabilities(jog.getSkills(),jog.getPosicao()) + "\n");
        }
        return sb.toString();
    }

    /**
     * Função que imprime numa String as habilidades conforme a posição do jogador
     * @param habs Mapa de habilidades
     * @param pos Posição do jogador
     * @return String com as habilidades e posição de um jogador
     */
    private String printHabilities(Map<Jogador.Habilidades,Integer> habs, Jogador.Posicao pos){
        StringBuilder sb=new StringBuilder();
        sb.append(habs.get(Jogador.Habilidades.VELOCIDADE) + ",");
        sb.append(habs.get(Jogador.Habilidades.RESISTENCIA) + ",");
        sb.append(habs.get(Jogador.Habilidades.DESTREZA) + ",");
        sb.append(habs.get(Jogador.Habilidades.IMPULSAO) + ",");
        sb.append(habs.get(Jogador.Habilidades.CABECEAMENTO) + ",");
        sb.append(habs.get(Jogador.Habilidades.REMATE) + ",");
        sb.append(habs.get(Jogador.Habilidades.PASSE));
        if(pos.equals(Jogador.Posicao.GUARDA_REDES)){
            sb.append("," + habs.get(Jogador.Habilidades.FLEXIBILIDADE));
        }
        else if(pos.equals(Jogador.Posicao.LATERAL)){
            sb.append("," + habs.get(Jogador.Habilidades.CRUZAMENTO));
        }
        else if(pos.equals(Jogador.Posicao.MEDIO)){
            sb.append("," + habs.get(Jogador.Habilidades.RECUPERACAO));
        }
        return sb.toString();
    }

    /**
     * Função que imprime numa String a posição do jogador
     * @param pos Posição do jogador
     * @return String com a sua posição
     */
    private String printPos(Jogador.Posicao pos){
        if(pos.equals(Jogador.Posicao.AVANCADO)){
            return "Avancado:";
        }
        else if(pos.equals(Jogador.Posicao.DEFESA)){
            return "Defesa:";
        }
        else if(pos.equals(Jogador.Posicao.MEDIO)){
            return "Medio:";
        }
        else if(pos.equals(Jogador.Posicao.LATERAL)){
            return "Lateral:";
        }
        else if(pos.equals(Jogador.Posicao.GUARDA_REDES)){
            return "Guarda-Redes:";
        }
        return "Null:";
    }

    /**
     * Função que indica a informação que pretende ser impressa
     * @return Informação imprimida
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
     * Função que verifca a igualdade dos objetos
     * @param o Objeto da classe
     * @return Boleano que indica se é igual
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