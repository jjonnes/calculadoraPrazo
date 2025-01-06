package com.prazo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class FeriadoUtils {

  public static List<LocalDate> obterFeriados() {
    ObjectMapper objectMapper = new ObjectMapper();
    try (InputStream inputStream = FeriadoUtils.class
        .getClassLoader()
        .getResourceAsStream("feriados.json")) {

      if (inputStream == null) {
        throw new RuntimeException("Arquivo feriados.json não encontrado!");
      }

      List<String> feriadosString = objectMapper
          .readValue(inputStream, new TypeReference<List<String>>() {
          });

      return feriadosString.stream()
          .map(LocalDate::parse)
          .toList();

    } catch (IOException e) {
      throw new RuntimeException("Erro ao ler o arquivo feriados.json", e);
    }
  }
}