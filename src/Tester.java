//import java.time.LocalDate;
//import java.util.*;
//
//public class Tester {
//    public static Equipa getTrofense(){
//        List<Jogador> jogadoresTrofense = new ArrayList<>();
//
//
//        Map<Jogador.Habilidades, Integer> rickyHabilidades = new HashMap<>();
//        rickyHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        rickyHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador ricky = new Jogador("Rickz", 32, 17,20, "Francesa", "Trofense", Jogador.Posicao.LATERAL, Arrays.asList("Trofense"),rickyHabilidades);
//        jogadoresTrofense.add(ricky.clone());
//
//        Map<Jogador.Habilidades, Integer> vazHabilidades = new HashMap<>();
//        vazHabilidades.put(Jogador.Habilidades.RESISTENCIA, 4);
//        vazHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        Jogador vaz= new Jogador("Vaz4490", 19, 42, 20, "Jamaicano", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),vazHabilidades);
//        jogadoresTrofense.add(vaz.clone());
//
//        Map<Jogador.Habilidades, Integer> tabzHabilidades = new HashMap<>();
//        tabzHabilidades.put(Jogador.Habilidades.CABECEAMENTO, 16);
//        tabzHabilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        Jogador tabz = new Jogador("Mafodas", 19, 2, 2, "Lisboeta", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),tabzHabilidades);
//        jogadoresTrofense.add(tabz.clone());
//
//        Map<Jogador.Habilidades, Integer> nunoHabilidades = new HashMap<>();
//        nunoHabilidades.put(Jogador.Habilidades.VELOCIDADE, 20);
//        nunoHabilidades.put(Jogador.Habilidades.REMATE, 8);
//        Jogador nuno = new Jogador("Nuno", 20, 19, 20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),nunoHabilidades);
//        jogadoresTrofense.add(nuno.clone());
//
//        Map<Jogador.Habilidades, Integer> cr7Habilidades = new HashMap<>();
//        cr7Habilidades.put(Jogador.Habilidades.VELOCIDADE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.REMATE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.CABECEAMENTO, 5);
//        cr7Habilidades.put(Jogador.Habilidades.IMPULSAO, 20);
//        cr7Habilidades.put(Jogador.Habilidades.PASSE, 20);
////        cr7Habilidades.put(Jogador.Habilidades.FLEXIBILIDADE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        cr7Habilidades.put(Jogador.Habilidades.RESISTENCIA, 20);
//        Jogador cr7 = new Jogador("Diogo", 20, 7, 20, "Bracarense", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),cr7Habilidades);
//        jogadoresTrofense.add(cr7.clone());
//
//        Map<Jogador.Habilidades, Integer> marianaHabilidades = new HashMap<>();
//        marianaHabilidades.put(Jogador.Habilidades.DESTREZA, 2);
//        marianaHabilidades.put(Jogador.Habilidades.REMATE, 4);
//        Jogador mariana = new Jogador("b a d h i e", 20, 27, 20, "bilaberde", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),marianaHabilidades);
//        jogadoresTrofense.add(mariana.clone());
//
//        Map<Jogador.Habilidades, Integer> ogandoHabilidades = new HashMap<>();
//        ogandoHabilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        ogandoHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        Jogador ganderz = new Jogador("ganderz", 20, 6,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),ogandoHabilidades);
//        jogadoresTrofense.add(ganderz.clone());
//
//        Map<Jogador.Habilidades, Integer> toHabilidades = new HashMap<>();
//        toHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        toHabilidades.put(Jogador.Habilidades.FLEXIBILIDADE, 20);
//        Jogador to = new Jogador("TÔ", 20, 1,20, "Francesa", "Trofense", Jogador.Posicao.GUARDA_REDES, Arrays.asList("Trofense"),toHabilidades);
//        jogadoresTrofense.add(to.clone());
//
//        Map<Jogador.Habilidades, Integer> mendesHabilidades = new HashMap<>();
//        mendesHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        mendesHabilidades.put(Jogador.Habilidades.REMATE, 20);
//        Jogador mendes = new Jogador("jean paule", 20, 66,20, "Francesa", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),mendesHabilidades);
//        jogadoresTrofense.add(mendes.clone());
//
//        Map<Jogador.Habilidades, Integer> torresHabilidades = new HashMap<>();
//        torresHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        torresHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador torres = new Jogador("BUZ", 20, 4,20, "Francesa", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),torresHabilidades);
//        jogadoresTrofense.add(torres.clone());
//
//        Map<Jogador.Habilidades, Integer> paivaHabilidades = new HashMap<>();
//        paivaHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        paivaHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador paiva = new Jogador("Paiva", 20, 8,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),paivaHabilidades);
//        jogadoresTrofense.add(paiva.clone());
//
//        Map<Jogador.Habilidades, Integer> ruiHabilidades = new HashMap<>();
//        ruiHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        ruiHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador rui = new Jogador("30", 20, 30,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),ruiHabilidades);
//        jogadoresTrofense.add(rui.clone());
//
//        Map<Jogador.Habilidades, Integer> tiagovskiHabilidades = new HashMap<>();
//        tiagovskiHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        tiagovskiHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador tiagovski = new Jogador("VSKI NA PROZIS", 20, 20, 20, "METIN 2", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),tiagovskiHabilidades);
//        jogadoresTrofense.add(tiagovski.clone());
//
//        Map<Jogador.Habilidades, Integer> rickFazerezHabilidades = new HashMap<>();
//        rickyHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        rickyHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador rickFazerez = new Jogador("RICK FAZERES", 89, 99,20, "CP", "Trofense", Jogador.Posicao.LATERAL, Arrays.asList("Trofense"),rickFazerezHabilidades);
//        jogadoresTrofense.add(rickFazerez.clone());
//
//        return new Equipa("Trofense", LocalDate.of(1930, 1, 1), jogadoresTrofense);
//    }
//
//    public static Equipa getBraga(){
//        List<Jogador> jogadoresBraga = new ArrayList<>();
//
//        Map<Jogador.Habilidades, Integer> rickyHabilidades = new HashMap<>();
//        rickyHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        rickyHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador ricky = new Jogador("Rickz", 32, 17,20, "Francesa", "Trofense", Jogador.Posicao.LATERAL, Arrays.asList("Trofense"),rickyHabilidades);
//        jogadoresBraga.add(ricky.clone());
//
//        Map<Jogador.Habilidades, Integer> vazHabilidades = new HashMap<>();
//        vazHabilidades.put(Jogador.Habilidades.RESISTENCIA, 4);
//        vazHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        Jogador vaz= new Jogador("Vaz4490", 19, 42, 20, "Jamaicano", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),vazHabilidades);
//        jogadoresBraga.add(vaz.clone());
//
//        Map<Jogador.Habilidades, Integer> tabzHabilidades = new HashMap<>();
//        tabzHabilidades.put(Jogador.Habilidades.CABECEAMENTO, 16);
//        tabzHabilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        Jogador tabz = new Jogador("Mafodas", 19, 2, 2, "Lisboeta", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),tabzHabilidades);
//        jogadoresBraga.add(tabz.clone());
//
//        Map<Jogador.Habilidades, Integer> nunoHabilidades = new HashMap<>();
//        nunoHabilidades.put(Jogador.Habilidades.VELOCIDADE, 20);
//        nunoHabilidades.put(Jogador.Habilidades.REMATE, 8);
//        Jogador nuno = new Jogador("Nuno", 20, 19, 20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),nunoHabilidades);
//        jogadoresBraga.add(nuno.clone());
//
//        Map<Jogador.Habilidades, Integer> cr7Habilidades = new HashMap<>();
//        cr7Habilidades.put(Jogador.Habilidades.VELOCIDADE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.REMATE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.CABECEAMENTO, 5);
//        cr7Habilidades.put(Jogador.Habilidades.IMPULSAO, 20);
//        cr7Habilidades.put(Jogador.Habilidades.PASSE, 20);
////        cr7Habilidades.put(Jogador.Habilidades.FLEXIBILIDADE, 20);
//        cr7Habilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        cr7Habilidades.put(Jogador.Habilidades.RESISTENCIA, 20);
//        Jogador cr7 = new Jogador("Diogo", 20, 7, 20, "Bracarense", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),cr7Habilidades);
//        jogadoresBraga.add(cr7.clone());
//
//        Map<Jogador.Habilidades, Integer> marianaHabilidades = new HashMap<>();
//        marianaHabilidades.put(Jogador.Habilidades.DESTREZA, 2);
//        marianaHabilidades.put(Jogador.Habilidades.REMATE, 4);
//        Jogador mariana = new Jogador("b a d h i e", 20, 27, 20, "bilaberde", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),marianaHabilidades);
//        jogadoresBraga.add(mariana.clone());
//
//        Map<Jogador.Habilidades, Integer> ogandoHabilidades = new HashMap<>();
//        ogandoHabilidades.put(Jogador.Habilidades.DESTREZA, 20);
//        ogandoHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        Jogador ganderz = new Jogador("ganderz", 20, 6,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),ogandoHabilidades);
//        jogadoresBraga.add(ganderz.clone());
//
//        Map<Jogador.Habilidades, Integer> toHabilidades = new HashMap<>();
//        toHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        toHabilidades.put(Jogador.Habilidades.FLEXIBILIDADE, 20);
//        Jogador to = new Jogador("TÔ", 20, 1,20, "Francesa", "Trofense", Jogador.Posicao.GUARDA_REDES, Arrays.asList("Trofense"),toHabilidades);
//        jogadoresBraga.add(to.clone());
//
//        Map<Jogador.Habilidades, Integer> mendesHabilidades = new HashMap<>();
//        mendesHabilidades.put(Jogador.Habilidades.PASSE, 20);
//        mendesHabilidades.put(Jogador.Habilidades.REMATE, 20);
//        Jogador mendes = new Jogador("jean paule", 20, 66,20, "Francesa", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),mendesHabilidades);
//        jogadoresBraga.add(mendes.clone());
//
//        Map<Jogador.Habilidades, Integer> torresHabilidades = new HashMap<>();
//        torresHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        torresHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador torres = new Jogador("BUZ", 20, 4,20, "Francesa", "Trofense", Jogador.Posicao.DEFESA, Arrays.asList("Trofense"),torresHabilidades);
//        jogadoresBraga.add(torres.clone());
//
//        Map<Jogador.Habilidades, Integer> paivaHabilidades = new HashMap<>();
//        paivaHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        paivaHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador paiva = new Jogador("Paiva", 20, 8,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),paivaHabilidades);
//        jogadoresBraga.add(paiva.clone());
//
//        Map<Jogador.Habilidades, Integer> ruiHabilidades = new HashMap<>();
//        ruiHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        ruiHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador rui = new Jogador("30", 20, 30,20, "Francesa", "Trofense", Jogador.Posicao.MEDIO, Arrays.asList("Trofense"),ruiHabilidades);
//        jogadoresBraga.add(rui.clone());
//
//        Map<Jogador.Habilidades, Integer> tiagovskiHabilidades = new HashMap<>();
//        tiagovskiHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        tiagovskiHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador tiagovski = new Jogador("VSKI NA PROZIS", 20, 20, 20, "METIN 2", "Trofense", Jogador.Posicao.AVANCADO, Arrays.asList("Trofense"),tiagovskiHabilidades);
//        jogadoresBraga.add(tiagovski.clone());
//
//        Map<Jogador.Habilidades, Integer> rickFazerezHabilidades = new HashMap<>();
//        rickyHabilidades.put(Jogador.Habilidades.DESTREZA, 12);
//        rickyHabilidades.put(Jogador.Habilidades.REMATE, 17);
//        Jogador rickFazerez = new Jogador("RICK FAZERES", 89, 99,20, "CP", "Trofense", Jogador.Posicao.LATERAL, Arrays.asList("Trofense"),rickFazerezHabilidades);
//        jogadoresBraga.add(rickFazerez.clone());
//
//        return new Equipa("Braga", LocalDate.of(1921, 1, 19), jogadoresBraga);
//    }
//}
