import jogo.comida.Comida;
import jogo.execucao.JogoGourmetI;
import jogo.execucao.implementation.ExecutarJogoGourmet;
import jogo.execucao.implementation.JogoGourmet;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        JogoGourmetI jogoGourmet = new ExecutarJogoGourmet();
        jogoGourmet.startGame();
    }
}
