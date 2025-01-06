package com.prazo.service;

import com.prazo.model.Etapa;
import com.prazo.model.EtapaEnum;
import com.prazo.utils.FeriadoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PrazoServiceTest {

  private PrazoService prazoService;

  @BeforeEach
  public void setup() {
    prazoService = new PrazoService();
  }

  @Test
  public void testCalcularEtapas() {

    LocalDate dataInicio = LocalDate.of(2025, 1, 1);
    List<Etapa> etapasMock = new ArrayList<>();
    etapasMock.add(new Etapa("Etapa 1", 3));
    etapasMock.add(new Etapa("Etapa 2", 2));
    when(EtapaEnum.criarEtapas()).thenReturn(etapasMock);
    when(FeriadoUtils.obterFeriados()).thenReturn(new ArrayList<>());

    List<Etapa> etapasCalculadas = prazoService.calcularEtapas(dataInicio);

    assertEquals(2, etapasCalculadas.size());
    assertEquals("Etapa 1", etapasCalculadas.get(0).getNome());
    assertEquals("Etapa 2", etapasCalculadas.get(1).getNome());
  }
}
