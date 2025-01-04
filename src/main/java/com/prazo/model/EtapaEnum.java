package com.prazo.model;

import java.util.ArrayList;
import java.util.List;

public enum EtapaEnum {

  ETAPA1("Etapa 1", 3),
  ETAPA2("Etapa 2", 2),
  ETAPA3("Etapa 3", 3),
  ETAPA4("Etapa 4", 2);

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
    for (EtapaEnum etapaEnum : EtapaEnum.values()) {
      etapas.add(new Etapa(etapaEnum.getNome(), etapaEnum.getPrazo()));
    }
    return etapas;
  }

  public static void exibirTabela(List<Etapa> etapas) {
    System.out.printf("%-25s %-20s %-20s %-20s %-20s %-10s%n", "Etapa", "Prazo (dias úteis)", "Data Prevista",
        "Data Praticada", "Data Recalculada", "Status");
    System.out.println("=".repeat(118));
    for (Etapa e : etapas) {
      System.out.printf("%-25s %-20d %-20s %-20s %-20s %-10s%n",
          e.getNome(),
          e.getPrazo(),
          e.getDataPrevista() != null ? e.getDataPrevista().toString() : "Não calculada",
          e.getDataPraticada() != null ? e.getDataPraticada().toString() : "Não praticada",
          e.getDataRecalculada() != null ? e.getDataRecalculada().toString() : "Não recalculada",
          e.getStatus());
    }
  }
}
