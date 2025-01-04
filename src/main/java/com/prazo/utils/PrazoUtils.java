package com.prazo.utils;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.List;

public class PrazoUtils {

  public static LocalDate adicionarDiasUteis(LocalDate data, int dias, List<LocalDate> feriados) {
    int diasAdicionados = 0;
    while (diasAdicionados < dias) {
      data = data.plusDays(1);
      if (isDiaUtil(data, feriados)) {
        diasAdicionados++;
      }
    }
    return data;
  }

  public static boolean isDiaUtil(LocalDate data, List<LocalDate> feriados) {
    return !(data.getDayOfWeek() == DayOfWeek.SATURDAY ||
        data.getDayOfWeek() == DayOfWeek.SUNDAY ||
        feriados.contains(data));
  }
}
