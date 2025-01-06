package com.prazo.controller;

import com.prazo.model.Etapa;
import com.prazo.service.PrazoService;
import com.prazo.utils.FeriadoUtils;
import com.prazo.utils.PrazoUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class PrazoController {

  private final PrazoService prazoService;
  private final Scanner scanner;
  private LocalDate dataInicio;

  public PrazoController() {
    this.prazoService = new PrazoService();
    this.scanner = new Scanner(System.in);
  }

  public void iniciar() {
    dataInicio = solicitarDataInicio();
    List<Etapa> etapas = prazoService.calcularEtapas(dataInicio);

    System.out.println("Datas previstas iniciadas em " + dataInicio + ":");
    exibirTabela(etapas);
    System.out.println();

    atualizarEtapasComDiasPraticados(etapas);
    scanner.close();
  }

  private LocalDate solicitarDataInicio() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    dataInicio = null;

    while (dataInicio == null) {
      try {
        System.out.print("Digite a data inicial (formato: yyyy-MM-dd): ");
        String entrada = scanner.nextLine();
        dataInicio = LocalDate.parse(entrada, formato);
      } catch (DateTimeParseException e) {
        System.err.println("Input inválido! Exemplo de data permitida: 2025-01-05");
      }
    }
    return dataInicio;
  }

  private void atualizarEtapasComDiasPraticados(List<Etapa> etapas) {
    LocalDate dataPraticadaAnterior = dataInicio;
    LocalDate dataAnteriorParaRecalculo = dataInicio;

    for (int i = 0; i < etapas.size(); i++) {
      Etapa etapa = etapas.get(i);
      int diasUteisPraticados = solicitarDiasUteisPraticados(etapa);
      dataAnteriorParaRecalculo = atualizarEtapaAtual(etapa, dataAnteriorParaRecalculo, diasUteisPraticados);
      dataPraticadaAnterior = dataAnteriorParaRecalculo;
      atualizarProximasEtapas(etapas, i, dataPraticadaAnterior);
      exibirTabelaAtualizada(etapas);
    }
  }

  private int solicitarDiasUteisPraticados(Etapa etapa) {
    int diasUteisPraticados = -1;
    while (diasUteisPraticados <= 0) {
      try {
        System.out.print("Informe os dias úteis necessários para finalizar a etapa '" + etapa.getNome() + "': ");
        diasUteisPraticados = Integer.parseInt(scanner.nextLine());
        if (diasUteisPraticados <= 0) {
          System.out.println("O número deve ser maior que zero. Tente novamente.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Insira apenas números inteiros maiores que zero.");
      }
    }
    return diasUteisPraticados;
  }

  private LocalDate atualizarEtapaAtual(Etapa etapa, LocalDate dataAnteriorParaRecalculo, int diasUteisPraticados) {
    LocalDate dataPraticada = PrazoUtils.adicionarDiasUteis(dataAnteriorParaRecalculo, diasUteisPraticados,
        FeriadoUtils.obterFeriados());
    etapa.setDiasUteisPraticados(diasUteisPraticados);
    etapa.setDataPraticada(dataPraticada);
    etapa.setDataRecalculada(dataPraticada);
    return dataPraticada;
  }

  private void atualizarProximasEtapas(List<Etapa> etapas, int indiceEtapaAtual, LocalDate dataPraticadaAnterior) {
    for (int j = indiceEtapaAtual + 1; j < etapas.size(); j++) {
      Etapa proximaEtapa = etapas.get(j);
      dataPraticadaAnterior = PrazoUtils.adicionarDiasUteis(dataPraticadaAnterior, proximaEtapa.getPrazo(),
          FeriadoUtils.obterFeriados());
      proximaEtapa.setDataRecalculada(dataPraticadaAnterior);
    }
  }

  private void exibirTabelaAtualizada(List<Etapa> etapas) {
    System.out.println("\nTabela de prazos atualizada:");
    exibirTabela(etapas);
    System.out.println();
  }

  private void exibirTabela(List<Etapa> etapas) {
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-10s %n", "Etapa", "Prazo", "Data Prevista",
        "Data Praticada", "Data Recalculada", "Status");
    System.out.println("=".repeat(120));
    for (Etapa e : etapas) {
      System.out.printf("%-20s %-20d %-20s %-20s %-20s %-10s %n",
          e.getNome(),
          e.getPrazo(),
          e.getDataPrevista() != null ? e.getDataPrevista().toString() : "Não calculada",
          e.getDataPraticada() != null ? e.getDataPraticada().toString() : "Não praticada",
          e.getDataRecalculada() != null ? e.getDataRecalculada().toString() : "Não recalculada",
          e.getStatus());
    }
  }
}