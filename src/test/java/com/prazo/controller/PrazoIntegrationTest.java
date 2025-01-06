package com.prazo.controller;

import com.prazo.model.Etapa;
import com.prazo.service.PrazoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

public class PrazoIntegrationTest {

  @Mock
  private PrazoService prazoService;

  @InjectMocks
  private PrazoController prazoController;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testIniciarIntegration() {

    LocalDate dataInicio = LocalDate.of(2025, 1, 1);
    List<Etapa> etapas = List.of(
        new Etapa("Etapa 1", 3),
        new Etapa("Etapa 2", 2),
        new Etapa("Etapa 3", 2),
        new Etapa("Etapa 4", 1));
    when(prazoService.calcularEtapas(dataInicio)).thenReturn(etapas);

    prazoController.iniciar();

  }
}
