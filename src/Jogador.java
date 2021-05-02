/**
 * Criação do metodo do Jogador
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.util.*;

public class Jogador {
    private String nome;
    private int idade;
    private int nCamisola;
    private int nivelFisico; // 0 (perna partida) - 50 (saudavel)
    private String nacionalidade;
    private String equipaAtual;
    private Posicao posicao;
    private List<String> historicoEquipas;
    private Map<Habilidades,Integer> skills;

    public Jogador(){
        this.nome = null;
        this.idade = 0;
        this.nCamisola = 0;
        this.nivelFisico = 0;
        this.nacionalidade = null;
        this.equipaAtual = null;
        this.posicao = null;
        this.historicoEquipas = null;
        this.skills = null;
    }

    public Jogador(String nome, int idade, int nCamisola, int nivelFisico, String nacionalidade,
                   String equipaAtual, Posicao posicao, List<String> historicoEquipas,
                   Map<Habilidades,Integer> skills) {
        this.nome = nome;
        this.idade = idade;
        this.nCamisola = nCamisola;
        this.nivelFisico = nivelFisico;
        this.nacionalidade = nacionalidade;
        this.equipaAtual = equipaAtual;
        this.posicao = posicao;
        setHistoricoEquipas(historicoEquipas);
        setSkills(skills);
    }

    public Jogador(Jogador jogador){
        this.nome = jogador.getNome();
        this.idade = jogador.getIdade();
        this.nCamisola = jogador.getnCamisola();
        this.nivelFisico = jogador.getNivelFisico();
        this.nacionalidade = jogador.getNacionalidade();
        this.equipaAtual = jogador.getEquipaAtual();
        this.posicao = jogador.getPosicao();
        setHistoricoEquipas(jogador.getHistoricoEquipas());
        setSkills(jogador.getSkills());
    }

    public enum Habilidades {
        DESTREZA,
        VELOCIDADE,
        RESISTENCIA,
        IMPULSAO,
        CABECEAMENTO,
        REMATE,
        PASSE,
        FLEXIBILIDADE
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

    /**
     * @brief
     * @return
     */
    public int calculaOverall(){
        if(this.getSkills() == null || this.getSkills().size() == 0) return 0;
        int overall = 0;
        for (Integer atual : this.getSkills().values()) {
            overall += atual;
        }
        return overall/this.getSkills().size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getnCamisola() {
        return this.nCamisola;
    }

    public void setnCamisola(int nCamisola) {
        this.nCamisola = nCamisola;
    }

    public int getNivelFisico() {
        return nivelFisico;
    }

    public void setNivelFisico(int nivelFisico) {
        this.nivelFisico = nivelFisico;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEquipaAtual() {
        return equipaAtual;
    }

    public void setEquipaAtual(String equipaAtual) {
        this.equipaAtual = equipaAtual;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public List<String> getHistoricoEquipas() {
        return new ArrayList<>(this.historicoEquipas);
    }

    public void setHistoricoEquipas(List<String> historicoEquipas) {
        this.historicoEquipas = new ArrayList<>(historicoEquipas);
    }

    // TODO: 03/05/21
    public Map<Habilidades, Integer> getSkills() {
        return this.skills;
    }

    // TODO: 03/05/21  
    public void setSkills(Map<Habilidades, Integer> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jogador{");
        sb.append("nome='").append(nome).append('\'').append('\n');
        sb.append(", idade=").append(idade).append('\n');
        sb.append(", nivelFisico=").append(nivelFisico).append('\n');
        sb.append(", nacionalidade='").append(nacionalidade).append('\'').append('\n');
        sb.append(", equipaAtual='").append(equipaAtual).append('\'').append('\n');
        sb.append(", historicoEquipas=").append(historicoEquipas).append('\n');
        sb.append(", skills=").append(skills).append('\n');
        sb.append('}').append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        if (idade != jogador.idade) return false;
        if (nivelFisico != jogador.nivelFisico) return false;
        if (!Objects.equals(nome, jogador.nome)) return false;
        if (!Objects.equals(nacionalidade, jogador.nacionalidade)) return false;
        if (!Objects.equals(equipaAtual, jogador.equipaAtual)) return false;
        if (!Objects.equals(historicoEquipas, jogador.historicoEquipas)) return false;
        return Objects.equals(skills, jogador.skills);
    }

    @Override
    public Jogador clone() {
        return new Jogador(this);
    }
}
