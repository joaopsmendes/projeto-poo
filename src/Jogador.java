/**
 * Criação do objeto Jogador
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.util.*;

public class Jogador{
    private String nome;
    private int nCamisola;
    private Posicao posicao;
    private Map<Habilidades,Integer> skills;
    private List<String> historial;

    public Jogador(){
        this.nome = null;
        this.nCamisola = 0;
        this.posicao = null;
        this.skills = null;
        this.historial = null;
    }

    public Jogador(String nome, int nCamisola, Posicao posicao, Map<Habilidades,Integer> skills, List<String> historial) {
        this.nome = nome;
        this.nCamisola = nCamisola;
        this.posicao = posicao;
        setSkills(skills);
        setHistorial(historial);
    }

    public Jogador(Jogador jogador){
        this.nome = jogador.getNome();
        this.nCamisola = jogador.getnCamisola();
        this.posicao = jogador.getPosicao();
        setSkills(jogador.getSkills());
        setHistorial(jogador.getHistorial());
    }

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

    public enum Posicao {
        AVANCADO,
        DEFESA,
        GUARDA_REDES,
        LATERAL,
        MEDIO
    }

    /**
     * @brief Função que verifica se é golo ou nao
     * @return
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

    //verificar isto
    /**
     * @brief funçao que vereifica se o guarda redes defende ou nao
     * @return
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

    //verificar isto
    /**
     * @brief função que verifica se é golo ou nao
     * @return
     */
    public boolean golo(){
        return remata() && !defende();
    }

    public int calculaOverall(){
        if(this.getSkills() == null || this.getSkills().size() == 0) return 0;
        int overall = 0;
        for (Integer atual : this.getSkills().values()) {
            overall += atual;
        }
        return overall/this.getSkills().size();
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnCamisola() {
        return this.nCamisola;
    }

    public void setnCamisola(int nCamisola) {
        this.nCamisola = nCamisola;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Map<Habilidades, Integer> getSkills() {
        Map<Habilidades, Integer> newMap = new HashMap<>();
        for(Map.Entry<Habilidades, Integer> skill : this.skills.entrySet()){
            newMap.put(skill.getKey(), skill.getValue());
        }
        return newMap;
    }

    public void setSkills(Map<Habilidades, Integer> skills) {
        Map<Habilidades, Integer> newMap = new HashMap<>();
        for(Map.Entry<Habilidades, Integer> skill : skills.entrySet()){
            newMap.put(skill.getKey(), skill.getValue());
        }
        this.skills = newMap;
    }

    public List<String> getHistorial() {
        return new ArrayList<>(this.historial);
    }

    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>(this.historial);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", nCamisola=" + nCamisola +
                ", posicao=" + posicao +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return nCamisola == jogador.nCamisola && Objects.equals(nome, jogador.nome) && posicao == jogador.posicao && Objects.equals(skills, jogador.skills);
    }

    @Override
    public Jogador clone() {
        return new Jogador(this);
    }
}
