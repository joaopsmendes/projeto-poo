/**
 * Criação do objeto Informaçoes
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Informacoes {
    private Map<String,Equipa> equipas;
    private Map<Integer, Jogador> jogadores;
    private List<Jogo> jogos;

    /**
     * Criaçao do construtor vazio
     */
    public Informacoes(){
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    /**
     * Criação do construtor parametrizado
     * @param equipas Todas as equipas
     * @param jogadores Todos os jogadores
     * @param jogos Todos os jogos realizados
     */
    public Informacoes(Map<String, Equipa> equipas, Map<Integer, Jogador> jogadores, List<Jogo> jogos) {
        setEquipas(equipas);
        setJogadores(jogadores);
        setJogos(jogos);
    }

    /**
     * Criação do construtor cópia
     * @param informacoes Todas as informações
     */
    public Informacoes(Informacoes informacoes){
        setEquipas(informacoes.getEquipas());
        setJogadores(informacoes.getJogadores());
        setJogos(informacoes.getJogos());
    }

    /**
     * Função que permite trasnferencia dos jogadores entre equipa
     * @param id Id do jogador
     * @param jogador Jogador a ser transferido
     * @param nomeEquipaFinal Equipa para o qual vai ser tranferido
     */
    public void transfereJogador(int id, Jogador jogador, String nomeEquipaFinal){
        Equipa equipaFinal = this.equipas.get(nomeEquipaFinal);
        if(equipaFinal == null) return;

        Equipa equipaInicial = this.equipas.get(jogador.getHistorial().get(jogador.getHistorial().size()-1));
        if(equipaInicial == null) return;
        equipaInicial.removeJogador(jogador);

        Jogador novoJogador = jogador.clone();
        List<String> historial = novoJogador.getHistorial();
        historial.add(nomeEquipaFinal);
        novoJogador.setHistorial(historial);
        equipaFinal.insereJogador(jogador);
        this.equipas.put(nomeEquipaFinal, equipaFinal.clone());
        this.jogadores.put(id, novoJogador.clone());
    }

    public boolean verificaEquipa(String nomeEqu){
        for(Map.Entry<String,Equipa> entry: this.getEquipas().entrySet()){
            if(entry.getValue().getNome().equals(nomeEqu)) return true;
        }
        return false;
    }

    public Equipa getEquipa_fromNome(String nomeEqu){
        for(Map.Entry<String,Equipa> entry: this.getEquipas().entrySet()){
            if(entry.getValue().getNome().equals(nomeEqu)) return entry.getValue().clone();
        }
        return null;
    }

    public Map<String, Equipa> getEquipas() {
        Map<String, Equipa> newMap = new HashMap<>();
        for(Map.Entry<String, Equipa> atual : equipas.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        return newMap;
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        Map<String, Equipa> newMap = new HashMap<>();
        for(Map.Entry<String, Equipa> atual : equipas.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        this.equipas = newMap;
    }

    public Map<Integer, Jogador> getJogadores() {
        Map<Integer, Jogador> newMap = new HashMap<>();
        for(Map.Entry<Integer, Jogador> atual : jogadores.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        return newMap;
    }

    public List<Jogador> get11Jogadores(List<Integer> onzeInt,Equipa e1){
        List<Jogador> onze=new ArrayList<>();
        for(Equipa e:getEquipas().values()){
            if(e.getNome().equals(e1.getNome())){
                for(Integer inteiro:onzeInt){
                    Jogador jog=getJogador_fromNum(inteiro,e.getJogadores());
                    onze.add(jog);
                }
            }
        }
        return onze;
    }

    private Jogador getJogador_fromNum(Integer num,List<Jogador> listJoga){
        for(Jogador jog:listJoga){
            if(jog.getnCamisola()==num) return jog;
        }
        return null;
    }

    public void setJogadores(Map<Integer, Jogador> jogadores) {
        Map<Integer, Jogador> newMap = new HashMap<>();
        for(Map.Entry<Integer, Jogador> atual : jogadores.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        this.jogadores = newMap;
    }

    public List<Jogo> getJogos() {
        List<Jogo> newList = new ArrayList<>();
        for(Jogo atual : this.jogos){
            newList.add(atual.clone());
        }
        return newList;
    }

    public void setJogos(List<Jogo> jogos) {
        List<Jogo> newList = new ArrayList<>();
        for(Jogo atual : jogos){
            newList.add(atual.clone());
        }
        this.jogos = jogos;
    }

    public void addEquipa(Equipa novaEqu){
        Map<String,Equipa> novoMapa=getEquipas();
        novoMapa.put(novaEqu.getNome(),novaEqu.clone());
        setEquipas(novoMapa);
    }

    /**
     * Função que indica a informação que pretende ser impressa
     * @return Informação imprimida
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Informacoes{");
        sb.append("equipas=").append(equipas);
        sb.append(", jogadores=").append(jogadores);
        sb.append(", jogos=").append(jogos);
        sb.append('}');
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

        Informacoes that = (Informacoes) o;

        if (equipas != null ? !equipas.equals(that.equipas) : that.equipas != null) return false;
        if (jogadores != null ? !jogadores.equals(that.jogadores) : that.jogadores != null) return false;
        return jogos != null ? jogos.equals(that.jogos) : that.jogos == null;
    }

    /**
     * Funçao que faz o clone
     * @return o clone do Objeto Informacoes
     */
    @Override
    public Informacoes clone(){
        return new Informacoes(this);
    }
}
