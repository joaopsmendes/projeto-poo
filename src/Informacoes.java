/**
 * Criação do objeto Informaçoes
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Informacoes implements Serializable{
    private Map<String,Equipa> equipas;
    private Map<Integer, Jogador> jogadores;
    private List<Jogo> jogos;

    /**
     * Criação do construtor vazio
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
     * Função que permite transferẽncia dos jogadores entre equipas
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

    /**
     * Verifica se a equipa existe
     * @param nomeEqu Nome da equipa
     * @return Boleano que indica se a equipa existe
     */
    public boolean verificaEquipa(String nomeEqu){
        for(Map.Entry<String,Equipa> entry: this.getEquipas().entrySet()){
            if(entry.getValue().getNome().equals(nomeEqu)) return true;
        }
        return false;
    }

    /**
     * Função que através do nome da equipa retorna a Equipa
     * @param nomeEqu nome da equipa
     * @return Objeto equipa
     */
    public Equipa getEquipa_fromNome(String nomeEqu){
        for(Map.Entry<String,Equipa> entry: this.getEquipas().entrySet()){
            if(entry.getValue().getNome().equals(nomeEqu)) return entry.getValue().clone();
        }
        return null;
    }

    /**
     * Getter das Equipas
     * @return Todas as equipas
     */
    public Map<String, Equipa> getEquipas() {
        Map<String, Equipa> newMap = new HashMap<>();
        for(Map.Entry<String, Equipa> atual : equipas.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        return newMap;
    }

    /**
     * Setter das equipas
     * @param equipas Mapa das equipas
     */
    public void setEquipas(Map<String, Equipa> equipas) {
        Map<String, Equipa> newMap = new HashMap<>();
        for(Map.Entry<String, Equipa> atual : equipas.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        this.equipas = newMap;
    }

    /**
     * Getter dos Jogadores
     * @return Todos os jogadores
     */
    public Map<Integer, Jogador> getJogadores() {
        Map<Integer, Jogador> newMap = new HashMap<>();
        for(Map.Entry<Integer, Jogador> atual : jogadores.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        return newMap;
    }

    /**
     * Função para obter o onze inical de uma equipa
     * @param onzeInt Lista de jogadores
     * @param e1 Equipa pretendida
     * @return Lista de jogadores
     */
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

    /**
     * Função para obter um jogador através do seu número da camisola
     * @param num Número da camisola
     * @param listJoga Lista de jogadores
     * @return Jogador pretendido
     */
    private Jogador getJogador_fromNum(Integer num,List<Jogador> listJoga){
        for(Jogador jog:listJoga){
            if(jog.getnCamisola()==num) return jog;
        }
        return null;
    }

    /**
     * Setter dos jogadores
     * @param jogadores Mapa de jogadores
     */
    public void setJogadores(Map<Integer, Jogador> jogadores) {
        Map<Integer, Jogador> newMap = new HashMap<>();
        for(Map.Entry<Integer, Jogador> atual : jogadores.entrySet()){
            newMap.put(atual.getKey(), atual.getValue().clone());
        }
        this.jogadores = newMap;
    }

    /**
     * Getter da Lista de jogos
     * @return Lista de jogos
     */
    public List<Jogo> getJogos() {
        List<Jogo> newList = new ArrayList<>();
        for(Jogo atual : this.jogos){
            newList.add(atual.clone());
        }
        return newList;
    }

    /**
     * Setter de jogos
     * @param jogos Lista de jogos
     */
    public void setJogos(List<Jogo> jogos) {
        List<Jogo> newList = new ArrayList<>();
        for(Jogo atual : jogos){
            newList.add(atual.clone());
        }
        this.jogos = jogos;
    }

    /**
     * Função que cria uma nova equipa
     * @param novaEqu Nova equipa
     */
    public void addEquipa(Equipa novaEqu){
        Map<String,Equipa> novoMapa=getEquipas();
        novoMapa.put(novaEqu.getNome(),novaEqu.clone());
        setEquipas(novoMapa);
    }

    /**
     * Função para ler o ficheiro default
     * @param filename Nome do ficheiro
     * @return Retorna as informações
     * @throws IOException Exceção
     * @throws ClassNotFoundException Classe não encontrada
     */
    public Informacoes readFile(String filename) throws IOException, ClassNotFoundException {

        // lines = Files.readAllLines(Paths.get(nomeFicheiro), StandardCharsets.UTF_8);

        FileInputStream fis=new FileInputStream(filename);
        ObjectInputStream ois=new ObjectInputStream(fis);
        Informacoes info= (Informacoes) ois.readObject();
        ois.close();
        return info;
    }

    /**
     * Função para adicionar a uma String todas as equipas
     * @return String com todas as equipas
     */
    public String printFileEqui(){
        StringBuilder sb=new StringBuilder();
        for(Equipa e:getEquipas().values()){
            sb.append(e.printFile());
        }
        return sb.toString();
    }

    /**
     * Função para adicionar todos os jogos a uma String
     * @return String com todos os jogos
     */
    public String printFileJogo(){
        StringBuilder sb=new StringBuilder();
        for(Jogo jog:getJogos()){
            sb.append(jog.printFile());
        }
        return sb.toString();
    }

    /**
     * Função para escrever num ficheiro os objetos
     * @param filename Nome do ficheiro
     * @throws IOException Exceção
     */
    public void writeBin(String filename) throws IOException {
        PrintWriter pw=new PrintWriter(filename);
        pw.print(this.printFileEqui());
        pw.print(this.printFileJogo());
        pw.flush();
        /*
        FileOutputStream fos=new FileOutputStream(filename);
        System.out.println("Ainda nao deu erro");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        */
        /*
        for(Equipa e:getEquipas().values()){
            oos.writeObject(e);
        }
        for(Jogador jog:getJogadores().values()){
            //oos.writeUTF();
        }
        for(Jogo jogo:getJogos()){
            oos.writeUTF(jogo.getEquipa1().getNome());
            oos.writeUTF(jogo.getEquipa2().getNome());
            oos.write(jogo.getGolosVisitante());
            oos.write(jogo.getGolosVisitada());
            //oos.writeUTF("\n");
        }
        */
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
