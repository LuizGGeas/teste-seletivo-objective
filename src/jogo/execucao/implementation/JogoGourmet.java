package jogo.execucao.implementation;

import jogo.comida.Comida;
import jogo.execucao.JogoGourmetI;

import java.util.*;
import java.util.stream.Collectors;

public abstract class JogoGourmet implements JogoGourmetI {
    List<Comida> comidaList = new ArrayList<>();
    List<String> caracteristicaList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    protected final String SIM = "SIM";
    protected final String NAO = "NAO";

    public JogoGourmet() {
        this.initGame();
    }

    protected void initGame() {
        final String caracteristica = "doce";
        Comida pudim = new Comida("pudim", caracteristica);
        caracteristicaList.add(caracteristica);
        comidaList.add(pudim);
    }

    abstract public void startGame();

    protected void retornarComidasDeterminadaCaracteristica(String caracteristicaAtual) {
        comidaList = comidaList.stream()
                .filter(comida -> getCaracteristicaIgual(comida, caracteristicaAtual))
                .collect(Collectors.toList());
    }

    protected String scanData(String message) {
        System.out.println(message);
        return sc.next();
    }

    protected void adicionarCaracteristicaAComida(String nomeComida, String caracteristica) {
        Comida comida = new Comida(nomeComida, caracteristica);
        addCaracteristicaIfAbsent(caracteristica);
        caracteristicaList.forEach(item -> {
            boolean isNewCaracteristica = item.equals(caracteristica);
            comida.addCaracteristica(item, isNewCaracteristica);
        });
    }

    private boolean getCaracteristicaIgual(Comida comida, String caracteristicaAtual) {
        return comida.getCaracteristicaMap().get(caracteristicaAtual);
    }

    private void addCaracteristicaIfAbsent(String caracteristica) {
        if(!caracteristicaList.contains(caracteristica))
            caracteristicaList.add(caracteristica);
    }
}
