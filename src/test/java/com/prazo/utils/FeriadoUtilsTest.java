package com.prazo.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeriadoUtilsTest {

  @Test
  public void testObterFeriados() {

    List<LocalDate> feriados = FeriadoUtils.obterFeriados();

    assertEquals(10, feriados.size());
    assertEquals(LocalDate.of(2025, 1, 1), feriados.get(0));
    assertEquals(LocalDate.of(2025, 3, 3), feriados.get(1));
    assertEquals(LocalDate.of(2025, 3, 4), feriados.get(2));
    assertEquals(LocalDate.of(2025, 4, 18), feriados.get(3));
    assertEquals(LocalDate.of(2025, 5, 1), feriados.get(4));
    assertEquals(LocalDate.of(2025, 9, 7), feriados.get(5));
    assertEquals(LocalDate.of(2025, 10, 12), feriados.get(6));
    assertEquals(LocalDate.of(2025, 11, 2), feriados.get(7));
    assertEquals(LocalDate.of(2025, 11, 15), feriados.get(8));
    assertEquals(LocalDate.of(2025, 12, 25), feriados.get(9));
  }
}