package com.prazo.model;

import java.time.LocalDate;

public class Etapa {
  private String nome;
  private int prazo;
  private int diasUteisPraticados;
  private LocalDate dataPrevista;
  private LocalDate dataPraticada;
  private LocalDate dataRecalculada;

  public Etapa(String nome, int prazo) {
    this.nome = nome;
    this.prazo = prazo;
  }

  public String getNome() {
    return nome;
  }

  public int getPrazo() {
    return prazo;
  }

  public int getDiasUteisPraticados() {
    return diasUteisPraticados;
  }

  public void setDiasUteisPraticados(int diasUteisPraticados) {
    this.diasUteisPraticados = diasUteisPraticados;
  }

  public LocalDate getDataPrevista() {
    return dataPrevista;
  }

  public void setDataPrevista(LocalDate dataPrevista) {
    this.dataPrevista = dataPrevista;
  }

  public LocalDate getDataPraticada() {
    return dataPraticada;
  }

  public void setDataPraticada(LocalDate dataPraticada) {
    this.dataPraticada = dataPraticada;
  }

  public LocalDate getDataRecalculada() {
    return dataRecalculada;
  }

  public void setDataRecalculada(LocalDate dataRecalculada) {
    this.dataRecalculada = dataRecalculada;
  }

  public String getStatus() {
    if (dataPraticada == null) {
      return "Pendente";
    }
    if (dataPraticada.isBefore(dataPrevista)) {
      return "Adiantado";
    } else if (dataPraticada.isAfter(dataPrevista)) {
      return "Atrasado";
    } else {
      return "No Prazo";
    }
  }
}
