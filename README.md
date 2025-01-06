# Calculadora de Prazos

Este projeto é uma aplicação Java que permite calcular prazos com base em etapas e dias úteis praticados. O usuário pode inserir uma data inicial e, em seguida, o aplicativo calcula as datas previstas para cada etapa, considerando feriados e dias úteis.

## Funcionalidades

- Solicita uma data inicial ao usuário.
- Calcula as etapas com base na data inicial e nos dias úteis praticados.
- Exibe uma tabela com as etapas, prazos, datas previstas, datas praticadas e status.

## Como Configurar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado.
2. Instale o [Maven](https://maven.apache.org/download.cgi) para gerenciar as dependências do projeto.
3. Clone este repositório em sua máquina local.

## Como Executar

1. Navegue até o diretório do projeto.
2. Execute o seguinte comando para compilar o projeto:

   ```bash
   mvn clean install
   ```

3. Após a compilação, execute a aplicação com o comando:

   ```bash
   mvn exec:java -Dexec.mainClass="com.prazo.Main"
   ```

## Como Usar

1. Ao executar a aplicação, você será solicitado a inserir uma data inicial no formato `yyyy-MM-dd`.
2. Em seguida, insira os dias úteis necessários para cada etapa.

### Exemplo de Uso

1. Execute a aplicação.
2. Insira a data inicial, por exemplo: `2025-01-01`.

#### Entradas e Saídas Esperadas

- **Entrada:**

  ```
  Digite a data inicial (formato: yyyy-MM-dd): 2025-01-01
  ```

- **Saída Esperada:**

  ```
  Datas previstas iniciadas em 2025-01-01:
  Etapa               Prazo               Data Prevista         Data Praticada       Data Recalculada     Status
  =========================================================================================================================
  Etapa 1            3                   2025-01-04          Não praticada        Não recalculada      Pendente
  Etapa 2            2                   2025-01-06          Não praticada        Não recalculada      Pendente
  Etapa 3            2                   2025-01-08          Não praticada        Não recalculada      Pendente
  Etapa 4            1                   2025-01-09          Não praticada        Não recalculada      Pendente
  ```

- **Entrada:**

  ```
  Informe os dias úteis necessários para finalizar a etapa 'Etapa 1': 3
  ```

- **Saída Esperada:**

  ```
  Tabela de prazos atualizada:
  Etapa               Prazo               Data Prevista         Data Praticada       Data Recalculada     Status
  =========================================================================================================================
  Etapa 1            3                   2025-01-04          2025-01-04          2025-01-04          No Prazo
  Etapa 2            2                   2025-01-06          2025-01-06          2025-01-06          No Prazo
  Etapa 3            2                   2025-01-08          2025-01-08          2025-01-08          No Prazo
  Etapa 4            1                   2025-01-09          2025-01-09          2025-01-09          No Prazo
  ```

- **Entrada:**

  ```
  Informe os dias úteis necessários para finalizar a etapa 'Etapa 2': 2
  ```

- **Saída Esperada:**

  ```
  Tabela de prazos atualizada:
  Etapa               Prazo               Data Prevista         Data Praticada       Data Recalculada     Status
  =========================================================================================================================
  Etapa 1            3                   2025-01-04          2025-01-04          2025-01-04          No Prazo
  Etapa 2            2                   2025-01-06          2025-01-06          2025-01-06          No Prazo
  Etapa 3            2                   2025-01-08          2025-01-08          2025-01-08          No Prazo
  Etapa 4            1                   2025-01-09          2025-01-09          2025-01-09          No Prazo
  ```

- **Entrada:**

  ```
  Informe os dias úteis necessários para finalizar a etapa 'Etapa 3': 2
  ```

- **Saída Esperada:**

  ```
  Tabela de prazos atualizada:
  Etapa               Prazo               Data Prevista         Data Praticada       Data Recalculada     Status
  =========================================================================================================================
  Etapa 1            3                   2025-01-04          2025-01-04          2025-01-04          No Prazo
  Etapa 2            2                   2025-01-06          2025-01-06          2025-01-06          No Prazo
  Etapa 3            2                   2025-01-08          2025-01-08          2025-01-08          No Prazo
  Etapa 4            1                   2025-01-09          2025-01-09          2025-01-09          No Prazo
  ```

- **Entrada:**

  ```
  Informe os dias úteis necessários para finalizar a etapa 'Etapa 4': 1
  ```

- **Saída Esperada:**
  ```
  Tabela de prazos atualizada:
  Etapa               Prazo               Data Prevista         Data Praticada       Data Recalculada     Status
  =========================================================================================================================
  Etapa 1            3                   2025-01-04          2025-01-04          2025-01-04          No Prazo
  Etapa 2            2                   2025-01-06          2025-01-06          2025-01-06          No Prazo
  Etapa 3            2                   2025-01-08          2025-01-08          2025-01-08          No Prazo
  Etapa 4            1                   2025-01-09          2025-01-09          2025-01-09          No Prazo
  ```

## Modificações Personalizadas

### Modificando o Enum de Etapas

O enum `EtapaEnum` define as etapas do processo. Você pode adicionar ou modificar etapas editando o arquivo `EtapaEnum.java`. Por exemplo, para adicionar uma nova etapa:

```java
ETAPA5("Etapa 5", 4);
```

### Alterando os Feriados

Os feriados são definidos no arquivo `feriados.json`. Você pode adicionar ou remover feriados conforme necessário. Por exemplo, para adicionar um feriado em 2025-12-31, você pode modificar o arquivo para:

```json
[
  "2025-01-01",
  "2025-03-03",
  "2025-03-04",
  "2025-04-18",
  "2025-05-01",
  "2025-09-07",
  "2025-10-12",
  "2025-11-02",
  "2025-11-15",
  "2025-12-25",
  "2025-12-31"
]
```
