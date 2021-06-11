/**
 * Criação do objeto Parser
 *
 * @author João Mendes
 * @author Francisco Paiva
 * @author Ricardo Silva
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    /**
     * Função principal do parser que converte o conteúdo do ficheiro
     * @return Retorna as informaçoes
     * @throws LinhaIncorretaException Linha incorreta
     */
    public static Informacoes parse(String filename) throws LinhaIncorretaException, FileNotFoundException {
        List<String> linhas = lerFicheiro(filename);
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        List<Jogo> jogos = new ArrayList<>();
        Equipa ultima = null; Jogador j;
        String[] linhaPartida;
        List<String> historial;
        int jogadorId = 0;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = new Equipa(linhaPartida[1], LocalDate.now(), new ArrayList<>());
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = Jogador.parse(linhaPartida[1], Jogador.Posicao.GUARDA_REDES);
                    jogadores.put(jogadorId++, j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    historial = j.getHistorial();
                    historial.add(ultima.getNome());
                    j.setHistorial(historial);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Jogador.parse(linhaPartida[1], Jogador.Posicao.DEFESA);
                    jogadores.put(jogadorId++, j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    historial = j.getHistorial();
                    historial.add(ultima.getNome());
                    j.setHistorial(historial);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Jogador.parse(linhaPartida[1], Jogador.Posicao.MEDIO);
                    jogadores.put(jogadorId++, j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    historial = j.getHistorial();
                    historial.add(ultima.getNome());
                    j.setHistorial(historial);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Jogador.parse(linhaPartida[1], Jogador.Posicao.LATERAL);
                    jogadores.put(jogadorId++, j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    historial = j.getHistorial();
                    historial.add(ultima.getNome());
                    j.setHistorial(historial);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Jogador.parse(linhaPartida[1], Jogador.Posicao.AVANCADO);
                    jogadores.put(jogadorId++, j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    historial = j.getHistorial();
                    historial.add(ultima.getNome());
                    j.setHistorial(historial);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    try{
                        Jogo jo = Jogo.parser(linhaPartida[1], equipas);
                        jogos.add(jo);
                    }catch (NumberFormatException ex){
                        ex.printStackTrace();
                    }
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }
        return new Informacoes(equipas, jogadores, jogos);
    }

    /**
     * Função que permite ler os ficheiros
     * @param nomeFicheiro nome do ficheiro
     * @return Retorna uma lista com o conteúdo do ficheiro
     */
    public static List<String> lerFicheiro(String nomeFicheiro) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFicheiro), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
