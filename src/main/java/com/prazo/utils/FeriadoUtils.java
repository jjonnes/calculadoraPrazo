package com.prazo.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FeriadoUtils {

  public static List<LocalDate> obterFeriados() {
    return Arrays.asList(
        LocalDate.of(2025, 1, 1), // Confraternização Universal
        LocalDate.of(2025, 3, 3), // Carnaval
        LocalDate.of(2025, 3, 4), // Carnaval
        LocalDate.of(2025, 4, 18), // Paixão de Cristo
        LocalDate.of(2025, 5, 1), // Dia do Trabalho
        LocalDate.of(2025, 9, 7), // Independência do Brasil
        LocalDate.of(2025, 10, 12), // Nossa Senhora Aparecida
        LocalDate.of(2025, 11, 2), // Finados
        LocalDate.of(2025, 11, 15), // Proclamação da República
        LocalDate.of(2025, 12, 25) // Natal
    );
  }
}
