package com.prazo.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FeriadoUtils {

  public static List<LocalDate> obterFeriados() {
    return Arrays.asList(
        LocalDate.of(2025, 1, 1),
        LocalDate.of(2025, 3, 3),
        LocalDate.of(2025, 3, 4),
        LocalDate.of(2025, 4, 18),
        LocalDate.of(2025, 5, 1),
        LocalDate.of(2025, 9, 7),
        LocalDate.of(2025, 10, 12),
        LocalDate.of(2025, 11, 2),
        LocalDate.of(2025, 11, 15),
        LocalDate.of(2025, 12, 25)
    // LocalDate.of(2025, 12, 25)
    );
  }
}
