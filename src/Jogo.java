import java.util.List;

public class Jogo {
    private Estado e;
    private int golosvisitado;
    private int golosvisitante;
    private List<Jogador> titularesVisitado;
    private List<Jogador> titularesVisitante;
    private List<Jogador> suplentesVisitado;
    private List<Jogador> suplentesesVisitante;

    public enum Estado{
        TERMINADO,
        ADECORRER,
        PORINICIAR,
        //INTERVALO;//diferença entre o inincio e o meio ser 45 min
    }
}
