package com.prazo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.prazo.model.Etapa;
import com.prazo.model.EtapaEnum;
import com.prazo.utils.FeriadoUtils;
import com.prazo.utils.PrazoUtils;

public class Main {

  public static void main(String[] args) {
    LocalDate dataInicio = LocalDate.of(2025, 1, 2);

    List<LocalDate> feriados = FeriadoUtils.obterFeriados();
    List<Etapa> etapas = EtapaEnum.criarEtapas();
    Scanner scanner = new Scanner(System.in);
    LocalDate dataAtual = dataInicio;

    for (int i = 0; i < etapas.size(); i++) {
      Etapa etapa = etapas.get(i);

      dataAtual = PrazoUtils.adicionarDiasUteis(dataAtual, etapa.getPrazo(), feriados);
      etapa.setDataPrevista(dataAtual);
    }

    System.out.println("Datas previstas iniciadas em " + dataInicio + ":");
    EtapaEnum.exibirTabela(etapas);
    System.out.println();

    LocalDate dataPraticadaAnterior = dataInicio;
    LocalDate dataPraticadaAnteriorR = dataInicio;

    for (int i = 0; i < etapas.size(); i++) {
      Etapa etapa = etapas.get(i);
      System.out.print("Informe os dias úteis necessários para finalizar a etapa '" + etapa.getNome() + "': ");
      int diasUteisPraticados = Integer.parseInt(scanner.nextLine());
      LocalDate dataPraticada = PrazoUtils.adicionarDiasUteis(dataPraticadaAnteriorR, diasUteisPraticados, feriados);
      etapa.setDiasUteisPraticados(diasUteisPraticados);
      etapa.setDataPraticada(dataPraticada);
      etapa.setDataRecalculada(dataPraticada);
      dataPraticadaAnteriorR = dataPraticada;

      for (int j = i + 1; j < etapas.size(); j++) {
        if (j == 1) {
          dataPraticadaAnterior = dataPraticadaAnterior.plusDays(diasUteisPraticados);
        }
        Etapa proximaEtapa = etapas.get(j);
        dataPraticadaAnterior = PrazoUtils.adicionarDiasUteis(dataPraticadaAnterior, proximaEtapa.getPrazo(), feriados);
        proximaEtapa.setDataRecalculada(dataPraticadaAnterior);
      }

      System.out.println("\nTabela de prazos atualizada:");
      EtapaEnum.exibirTabela(etapas);
      System.out.println();
    }
    scanner.close();
  }
}
