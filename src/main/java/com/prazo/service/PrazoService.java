package com.prazo.service;

import com.prazo.model.Etapa;
import com.prazo.model.EtapaEnum;
import com.prazo.utils.FeriadoUtils;
import com.prazo.utils.PrazoUtils;

import java.time.LocalDate;
import java.util.List;

public class PrazoService {

  public List<Etapa> calcularEtapas(LocalDate dataInicio) {
    List<LocalDate> feriados = FeriadoUtils.obterFeriados();
    List<Etapa> etapas = EtapaEnum.criarEtapas();
    LocalDate dataAtual = dataInicio;

    for (Etapa etapa : etapas) {
      dataAtual = PrazoUtils.adicionarDiasUteis(dataAtual, etapa.getPrazo(), feriados);
      etapa.setDataPrevista(dataAtual);
    }

    return etapas;
  }
}
