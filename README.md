# Calculadora de Prazos

Este projeto é uma calculadora de prazos que permite calcular datas previstas e praticadas para diferentes etapas de um processo, levando em consideração feriados e dias úteis.

## Requisitos

- Java 11 ou superior
- Maven

## Estrutura do Projeto

- `src/main/java/com/prazo/Main.java`: Classe principal que executa a lógica do programa.
- `src/main/java/com/prazo/model/`: Contém as classes de modelo, incluindo `Etapa` e `EtapaEnum`.
- `src/main/java/com/prazo/utils/`: Contém utilitários para manipulação de datas e feriados.

## Como Compilar e Executar

1. **Clone o repositório:**

2. **Compile o projeto usando Maven:**

   ```bash
   mvn clean install
   ```

3. **Execute o programa:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.prazo.Main"
   ```

## Como Usar

1. Altera a dataInicial em Main se necessário.
2. Alrete os feriádos se necessário.
3. O programa começará solicitando que você informe os dias úteis necessários para finalizar cada etapa.
4. As datas previstas e praticadas serão exibidas em uma tabela após cada entrada.
5. O programa considera feriados ao calcular os dias úteis.
