import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Informacoes {
    private Map<String,Equipa> equipas;
    private Map<Integer, Jogador> jogadores;
    private List<Jogo> jogos;

    public Informacoes(){
        this.equipas = null;
        this.jogadores = null;
        this.jogos = null;
    }

    public Informacoes(Map<String, Equipa> equipas, Map<Integer, Jogador> jogadores, List<Jogo> jogos) {
        setEquipas(equipas);
        setJogadores(jogadores);
        setJogos(jogos);
    }

    public Informacoes(Informacoes informacoes){
        setEquipas(informacoes.getEquipas());
        setJogadores(informacoes.getJogadores());
        setJogos(informacoes.getJogos());
    }

    public void transfereJogador(Jogador jogador, String nomeEquipaFinal){
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Informacoes{");
        sb.append("equipas=").append(equipas);
        sb.append(", jogadores=").append(jogadores);
        sb.append(", jogos=").append(jogos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Informacoes that = (Informacoes) o;

        if (equipas != null ? !equipas.equals(that.equipas) : that.equipas != null) return false;
        if (jogadores != null ? !jogadores.equals(that.jogadores) : that.jogadores != null) return false;
        return jogos != null ? jogos.equals(that.jogos) : that.jogos == null;
    }

    public Informacoes clone(){
        return new Informacoes(this);
    }
}
