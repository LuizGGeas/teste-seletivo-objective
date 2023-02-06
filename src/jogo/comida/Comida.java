package jogo.comida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comida {
    private String nomeComida;
    private Map<String, Boolean> caracteristicaMap = new HashMap();

    public Comida() {

    }

    public Comida(String nomeComida, String caracteristica) {
        this.nomeComida = nomeComida;
        this.caracteristicaMap.put(caracteristica, true);
    }

    public String getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        this.nomeComida = nomeComida;
    }

    public Map<String, Boolean> getCaracteristicaMap() {
        return caracteristicaMap;
    }

    public void setCaracteristicaMap(Map<String, Boolean> caracteristicaExistenteList) {
        this.caracteristicaMap = caracteristicaExistenteList;
    }

    public void addCaracteristica(String caracteristica, boolean exists) {
        this.caracteristicaMap.putIfAbsent(caracteristica, exists);
    }



}
