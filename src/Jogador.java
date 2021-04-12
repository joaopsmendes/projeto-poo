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
    private int nivelFisico; // 0 (perna partida) - 50 (saudavel)
    private String nacionalidade;
    private String equipaAtual;
    private Posicao posicao;
    private List<String> historicoEquipas;
    private Map<Habilidades,Integer> skills;

    public Jogador(){
        this.nome = null;
        this.idade = 0;
        this.nivelFisico = 0;
        this.nacionalidade = null;
        this.equipaAtual = null;
        this.posicao = null;
        this.historicoEquipas = null;
        this.skills = null;
    }

    public Jogador(String nome, int idade, int nivelFisico, String nacionalidade,
                   String equipaAtual, Posicao posicao, List<String> historicoEquipas,
                   Map<Habilidades,Integer> skills) {
        this.nome = nome;
        this.idade = idade;
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

    public boolean remata(){
        for(Habilidades habilidades : this.skills.keySet()){
            if(habilidades.equals(Habilidades.REMATE)){
                Random random = new Random();
                int sorte = random.nextInt(20);
                if(this.skills.get(habilidades) < sorte){
                    return true;
                }
            }
        }
        return false;
    }


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
        this.historicoEquipas = new ArrayList<>(this.historicoEquipas);
    }

    public Map<Habilidades, Integer> getSkills() {
        return new HashMap<>(this.getSkills());
    }

    public void setSkills(Map<Habilidades, Integer> skills) {
        this.skills = new HashMap<>(this.getSkills());;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jogador{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append(", nivelFisico=").append(nivelFisico);
        sb.append(", nacionalidade='").append(nacionalidade).append('\'');
        sb.append(", equipaAtual='").append(equipaAtual).append('\'');
        sb.append(", historicoEquipas=").append(historicoEquipas);
        sb.append(", skills=").append(skills);
        sb.append('}');
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
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + idade;
        result = 31 * result + nivelFisico;
        result = 31 * result + (nacionalidade != null ? nacionalidade.hashCode() : 0);
        result = 31 * result + (equipaAtual != null ? equipaAtual.hashCode() : 0);
        result = 31 * result + (historicoEquipas != null ? historicoEquipas.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }

    @Override
    protected Jogador clone() {
        return new Jogador(this);
    }
}
