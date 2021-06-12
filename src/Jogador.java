/**
 * Criação do objeto Jogador
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.Serializable;
import java.util.*;

public class Jogador implements Serializable {
    private String nome;
    private int nCamisola;
    private Posicao posicao;
    private Map<Habilidades,Integer> skills;
    private List<String> historial;

    /**
     * Criação do construtor vazio
     */
    public Jogador(){
        this.nome = "";
        this.nCamisola = 0;
        this.posicao = null;
        this.skills = new HashMap<>();
        this.historial = new ArrayList<>();
    }

    /**
     * Criação do construtor parametrizado
     * @param nome Nome do jogador
     * @param nCamisola Número da camisola
     * @param posicao Posição do jogador
     * @param skills Habilidades do jogador
     * @param historial Equipas por onde passou
     */
    public Jogador(String nome, int nCamisola, Posicao posicao, Map<Habilidades,Integer> skills,
                   List<String> historial) {
        this.nome = nome;
        this.nCamisola = nCamisola;
        this.posicao = posicao;
        setSkills(skills);
        setHistorial(historial);
    }

    /**
     * Criação do construtor cópia
     * @param jogador Objeto Jogador
     */
    public Jogador(Jogador jogador){
        this.nome = jogador.getNome();
        this.nCamisola = jogador.getnCamisola();
        this.posicao = jogador.getPosicao();
        setSkills(jogador.getSkills());
        setHistorial(jogador.getHistorial());
    }

    /**
     * Indica as habilidades que um jogador pode obter
     */
    public enum Habilidades {
        DESTREZA,
        VELOCIDADE,
        RESISTENCIA,
        IMPULSAO,
        CABECEAMENTO,
        REMATE,
        PASSE,
        FLEXIBILIDADE,
        CRUZAMENTO,
        RECUPERACAO
    }

    /**
     * Indica a posição que o jogador joga
     */
    public enum Posicao {
        AVANCADO,
        DEFESA,
        GUARDA_REDES,
        LATERAL,
        MEDIO
    }

    /**
     * Função que verifica se o jogador remata
     * @return Retorna um boleano que indica se o jogador rematou
     */
    public boolean remata(){
        int power = 0, n = 0;
        for(Habilidades habilidades : this.skills.keySet()){
            if(habilidades.equals(Habilidades.REMATE) || habilidades.equals(Habilidades.CABECEAMENTO)){
                power += this.skills.get(habilidades);
                n++;
            }
        }
        Random random = new Random();
        int sorte = random.nextInt(20);
        return (power / n) < sorte;
    }

    /**
     * Função que verifica se o guarda redes defende
     * @return Retorna um boleano que indica se o guarda-redes defendeu
     */
    public boolean defende(){
        if(posicao.equals(Posicao.GUARDA_REDES)){
            int power = 0, n = 0;
            for(Habilidades habilidades : this.skills.keySet()){
                if(habilidades.equals(Habilidades.FLEXIBILIDADE) || habilidades.equals(Habilidades.DESTREZA)){
                    power += this.skills.get(habilidades);
                    n++;
                }
            }

            Random random = new Random();
            int sorte = random.nextInt(20);
            return (power / n) < sorte;
        }
        return false;
    }

    /**
     * função que verifica se é golo comparando o boleano defende e o boleano remata
     * @return Retorna um boleano que indica se foi golo
     */
    public boolean golo(){
        return remata() && !defende();
    }

    /**
     * Função que calcula o overall consoante a posição do jogador
     * @return Retorna o overall do jogador
     */
    public float calculaOverall(){
        if(this.getSkills() == null || this.getSkills().size() == 0) return 0;
        float over_jogador=0;
        if(this.getPosicao()==Posicao.AVANCADO){
            float total_jogador=0;
            Map<Jogador.Habilidades,Integer> map_crtJog= this.getSkills();
            int cabeca=map_crtJog.get(Jogador.Habilidades.CABECEAMENTO);
            total_jogador+=cabeca*4;
            int remate=map_crtJog.get(Jogador.Habilidades.REMATE);
            total_jogador+=remate*4;
            int velo= map_crtJog.get(Jogador.Habilidades.VELOCIDADE);
            total_jogador+=velo;
            int passe= map_crtJog.get(Jogador.Habilidades.PASSE);
            total_jogador+=passe;
            int imp= map_crtJog.get(Jogador.Habilidades.IMPULSAO);
            total_jogador+=imp;
            int resis= map_crtJog.get(Jogador.Habilidades.RESISTENCIA);
            total_jogador+=resis*0.5;
            int destr= map_crtJog.get(Jogador.Habilidades.DESTREZA);
            total_jogador+=destr*0.5;
            over_jogador=total_jogador/7;
        }
        else if(this.getPosicao()== Posicao.MEDIO){
            float total_jogador=0;
            Map<Jogador.Habilidades,Integer> map_crtJog= this.getSkills();
            int cabeca=map_crtJog.get(Jogador.Habilidades.CABECEAMENTO);
            total_jogador+=cabeca*0.5;
            int remate=map_crtJog.get(Jogador.Habilidades.REMATE);
            total_jogador+=remate;
            int velo= map_crtJog.get(Jogador.Habilidades.VELOCIDADE);
            total_jogador+=velo;
            int passe= map_crtJog.get(Jogador.Habilidades.PASSE);
            total_jogador+=passe*4;
            int imp= map_crtJog.get(Jogador.Habilidades.IMPULSAO);
            total_jogador+=imp*0.5;
            int resis= map_crtJog.get(Jogador.Habilidades.RESISTENCIA);
            total_jogador+=resis;
            int destr= map_crtJog.get(Jogador.Habilidades.DESTREZA);
            total_jogador+=destr;
            int recup=map_crtJog.get(Jogador.Habilidades.RECUPERACAO);
            total_jogador+=recup*4;
            over_jogador=total_jogador/8;
        }
        else if(this.getPosicao()== Posicao.DEFESA){
            float total_jogador=0;
            Map<Jogador.Habilidades,Integer> map_crtJog= this.getSkills();
            int cabeca=map_crtJog.get(Jogador.Habilidades.CABECEAMENTO);
            total_jogador+=cabeca;
            int remate=map_crtJog.get(Jogador.Habilidades.REMATE);
            total_jogador+=remate*0.5;
            int velo= map_crtJog.get(Jogador.Habilidades.VELOCIDADE);
            total_jogador+=velo*0.5;
            int passe= map_crtJog.get(Jogador.Habilidades.PASSE);
            total_jogador+=passe;
            int imp= map_crtJog.get(Jogador.Habilidades.IMPULSAO);
            total_jogador+=imp*4;
            int resis= map_crtJog.get(Jogador.Habilidades.RESISTENCIA);
            total_jogador+=resis;
            int destr= map_crtJog.get(Jogador.Habilidades.DESTREZA);
            total_jogador+=destr*4;
            over_jogador=total_jogador/7;
        }
        else if(this.getPosicao()== Posicao.LATERAL){
            float total_jogador=0;
            Map<Jogador.Habilidades,Integer> map_crtJog= this.getSkills();
            int cabeca=map_crtJog.get(Jogador.Habilidades.CABECEAMENTO);
            total_jogador+=cabeca;
            int remate=map_crtJog.get(Jogador.Habilidades.REMATE);
            total_jogador+=remate*0.5;
            int velo= map_crtJog.get(Jogador.Habilidades.VELOCIDADE);
            total_jogador+=velo;
            int passe= map_crtJog.get(Jogador.Habilidades.PASSE);
            total_jogador+=passe;
            int imp= map_crtJog.get(Jogador.Habilidades.IMPULSAO);
            total_jogador+=imp*0.5;
            int resis= map_crtJog.get(Jogador.Habilidades.RESISTENCIA);
            total_jogador+=resis*4;
            int destr= map_crtJog.get(Jogador.Habilidades.DESTREZA);
            total_jogador+=destr;
            int cruz=map_crtJog.get(Jogador.Habilidades.CRUZAMENTO);
            total_jogador+=cruz*4;
            over_jogador=total_jogador/8;
        }
        else if(this.getPosicao()== Posicao.GUARDA_REDES){
            float total_jogador=0;
            Map<Jogador.Habilidades,Integer> map_crtJog= this.getSkills();
            int cabeca=map_crtJog.get(Jogador.Habilidades.CABECEAMENTO);
            total_jogador+=cabeca*0.5;
            int remate=map_crtJog.get(Jogador.Habilidades.REMATE);
            total_jogador+=remate*0.5;
            int velo= map_crtJog.get(Jogador.Habilidades.VELOCIDADE);
            total_jogador+=velo;
            int passe= map_crtJog.get(Jogador.Habilidades.PASSE);
            total_jogador+=passe*4;
            int imp= map_crtJog.get(Jogador.Habilidades.IMPULSAO);
            total_jogador+=imp;
            int resis= map_crtJog.get(Jogador.Habilidades.RESISTENCIA);
            total_jogador+=resis;
            int destr= map_crtJog.get(Jogador.Habilidades.DESTREZA);
            total_jogador+=destr;
            int flex=map_crtJog.get(Jogador.Habilidades.FLEXIBILIDADE);
            total_jogador+=flex*4;
            over_jogador=total_jogador/8;
        }
        return over_jogador;
    }

    /**
     * Função que recebendo um input e uma posição identifica as habilidades do jogador
     * @param input Linha com as informações do jogador
     * @param pos Posição do jogador
     * @return Jogador com as habilidades dadas
     */
    public static Jogador parse(String input, Posicao pos){
        String[] campos = input.split(",");
        Map<Habilidades,Integer> habilidades = new HashMap<>();
        habilidades.put(Habilidades.VELOCIDADE, Integer.parseInt(campos[2]));
        habilidades.put(Habilidades.RESISTENCIA, Integer.parseInt(campos[3]));
        habilidades.put(Habilidades.DESTREZA, Integer.parseInt(campos[4]));
        habilidades.put(Habilidades.IMPULSAO, Integer.parseInt(campos[5]));
        habilidades.put(Habilidades.CABECEAMENTO, Integer.parseInt(campos[6]));
        habilidades.put(Habilidades.REMATE, Integer.parseInt(campos[7]));
        habilidades.put(Habilidades.PASSE, Integer.parseInt(campos[8]));

        if(pos.equals(Posicao.GUARDA_REDES))
            habilidades.put(Habilidades.FLEXIBILIDADE, Integer.parseInt(campos[9]));

        if(pos.equals(Posicao.LATERAL))
            habilidades.put(Habilidades.CRUZAMENTO, Integer.parseInt(campos[9]));

        if(pos.equals(Posicao.MEDIO))
            habilidades.put(Habilidades.RECUPERACAO, Integer.parseInt(campos[9]));

        return new Jogador(
                campos[0],
                Integer.parseInt(campos[1]),
                pos,
                habilidades,
                new ArrayList<>()
        );
    }

    /**
     * Getter do nome do jogador
     * @return Nome do jogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter do nome do jogador
     * @param nome Nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do número da camisola
     * @return Número da camisola
     */
    public int getnCamisola() {
        return this.nCamisola;
    }

    /**
     * Setter do número da camisola
     * @param nCamisola Número da camisola
     */
    public void setnCamisola(int nCamisola) {
        this.nCamisola = nCamisola;
    }

    /**
     * Getter da posição do jogador
     * @return Posição do jogador
     */
    public Posicao getPosicao() {
        return posicao;
    }

    /**
     * Setter da posição do jogador
     * @param posicao Posição do jogador
     */
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    /**
     * Getter das skills do jogador
     * @return Mapa das skills do jogador
     */
    public Map<Habilidades, Integer> getSkills() {
        Map<Habilidades, Integer> newMap = new HashMap<>();
        for(Map.Entry<Habilidades, Integer> skill : this.skills.entrySet()){
            newMap.put(skill.getKey(), skill.getValue());
        }
        return newMap;
    }

    /**
     * Setter das skills do jogador
     * @param skills mapa com as skills do jogador
     */
    public void setSkills(Map<Habilidades, Integer> skills) {
        Map<Habilidades, Integer> newMap = new HashMap<>();
        for(Map.Entry<Habilidades, Integer> skill : skills.entrySet()){
            newMap.put(skill.getKey(), skill.getValue());
        }
        this.skills = newMap;
    }

    /**
     * Getter do historial de clubes do jogador
     * @return Lista de clubes que o jogador jogou
     */
    public List<String> getHistorial() {
        return new ArrayList<>(this.historial);
    }

    /**
     * Setter do historial de clubes do jogador
     * @param historial Lista de clubes que o jogador jogou
     */
    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>(historial);
    }

    /**
     * Função que indica a informação que pretende ser impressa
     * @return Informação imprimida
     */
    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", nCamisola=" + nCamisola +
                ", posicao=" + posicao +
                ", skills=" + skills +
                '}';
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
        Jogador jogador = (Jogador) o;
        return nCamisola == jogador.nCamisola && Objects.equals(nome, jogador.nome)
                && posicao == jogador.posicao && Objects.equals(skills, jogador.skills);
    }

    /**
     * Funçao que faz o clone
     * @return o clone do Objeto Jogador
     */
    @Override
    public Jogador clone() {
        return new Jogador(this);
    }
}
