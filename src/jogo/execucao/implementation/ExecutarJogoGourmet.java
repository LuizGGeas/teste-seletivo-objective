package jogo.execucao.implementation;

import java.util.Scanner;

public class ExecutarJogoGourmet extends JogoGourmet{

    public ExecutarJogoGourmet() {
        super();
    }

    @Override
    public void startGame() {
        System.out.println("Regras:\nDigite SIM/NAO para as perguntas, apenas em maiúsculo\n");
        boolean continuar = true;
        String caracteristicaAtual = "";
        String caracteristica = "";
        String acertou = "";
        String jogarNovamente = "";
        while (continuar && !caracteristicaList.isEmpty()) {
            caracteristicaAtual = caracteristicaList.remove(0);
            caracteristica = scanData("A Comida é " + caracteristicaAtual + "?");

            if(caracteristica.equals(SIM)) {
                retornarComidasDeterminadaCaracteristica(caracteristicaAtual);
            }

            if(comidaList.size() <= 1) {
                acertou = scanData("A sua comida é " + comidaList.get(0).getNomeComida() + "?");
                if(acertou.equals(NAO)) {
                    String novaComida = scanData("Qual comida você pensou?");
                    String novaCaracteristica = scanData("Digite uma caracteristica da comida: ");
                    adicionarCaracteristicaAComida(novaComida, novaCaracteristica);
                } else {
                    System.out.println("Parabéns!!!");
                }
                jogarNovamente = scanData("Jogar novamente?");
                continuar = jogarNovamente.equals(SIM);
            }
        }
    }
}
