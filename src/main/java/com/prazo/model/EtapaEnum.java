package com.prazo.model;

import java.util.ArrayList;
import java.util.List;

public enum EtapaEnum {

  ETAPA1("Etapa 1", 3),
  ETAPA2("Etapa 2", 2),
  ETAPA3("Etapa 3", 2),
  ETAPA4("Etapa 4", 1);

  private String nome;
  private int prazo;

  EtapaEnum(String nome, int prazo) {
    this.nome = nome;
    this.prazo = prazo;
  }

  public String getNome() {
    return nome;
  }

  public int getPrazo() {
    return prazo;
  }

  public static List<Etapa> criarEtapas() {
    List<Etapa> etapas = new ArrayList<>();
    for (EtapaEnum e : EtapaEnum.values()) {
      etapas.add(new Etapa(e.getNome(), e.getPrazo()));
    }
    return etapas;
  }
}
