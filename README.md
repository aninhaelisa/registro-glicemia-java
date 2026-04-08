# 🩸 Controle de Glicemia em Java

Um sistema simples desenvolvido em **Java** para registrar, armazenar e consultar medições de glicemia.

Esse projeto foi criado com o objetivo de ajudar no acompanhamento diário da glicemia, permitindo salvar medições com **data e hora**, visualizar o histórico e obter informações úteis para levar ao médico.

---

## 📌 Funcionalidades

- Registrar nova medição de glicemia
- Salvar medições em arquivo `.txt`
- Visualizar todas as medições salvas
- Consultar:
  - maior glicemia registrada
  - menor glicemia registrada
  - dia com maior média
  - dia com menor média
  - hora com maior média
  - hora com menor média
- Buscar medições por data

---

## 🛠️ Tecnologias utilizadas

- **Java**
- `Scanner`
- `ArrayList`
- `FileReader`
- `FileWriter`
- `BufferedReader`
- `BufferedWriter`
- `LocalDate`
- `LocalTime`
- `LocalDateTime`

---

## 📂 Estrutura do projeto

```bash
controle-glicemia-java/
│
├── App.java
├── glicemia_exemplo.txt
└── README.md
```

---

## ▶️ Como executar

1. Clone este repositório:

```bash
git clone https://github.com/aninhaelisa/registro-glicemia-java.git
```

2. Abra o projeto na sua IDE de preferência:
- VS Code
- IntelliJ IDEA
- Eclipse

3. Compile e execute o arquivo:

```bash
App.java
```

---

## 📋 Exemplo do menu

```text
==============================
   CONTROLE DE GLICEMIA
==============================
1 - Adicionar medição
2 - Ver todas as medições
3 - Ver maior glicemia
4 - Ver menor glicemia
5 - Ver dia com maior média
6 - Ver dia com menor média
7 - Ver hora com maior média
8 - Ver hora com menor média
9 - Buscar medições por dia
0 - Sair
```

---

## 💾 Sobre o arquivo `.txt`

As medições são armazenadas em um arquivo de texto no seguinte formato:

```txt
110;2026-04-08T17:34:33.541610900
140;2026-04-01T14:55
98;2026-04-02T07:15
```

### Estrutura:
```txt
valorDaGlicemia;dataHora
```

Exemplo:
- `110` = valor da glicemia
- `2026-04-08T17:34:33.541610900` = data e hora da medição

---

## ⚠️ Arquivo fictício para demonstração

O arquivo **`glicemia.txt`** presente neste repositório contém **dados fictícios**, criados apenas para demonstrar o funcionamento do sistema.

Esses dados:
- **não pertencem a nenhuma pessoa real**
- **não devem ser utilizados para fins médicos**
- servem apenas para **teste, estudo e apresentação do projeto**

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido como prática de programação em Java e também como uma solução simples para organizar medições de glicemia de forma acessível e útil para acompanhamento médico.

Além do aprendizado técnico, a proposta foi criar algo com **utilidade real**, simulando um pequeno sistema de registro de saúde.

---

## 🚀 Possíveis melhorias futuras

- adicionar observações à medição (ex: jejum, após almoço, antes de dormir)
- calcular média geral
- gerar relatório em `.txt`
- permitir exclusão de medições
- ordenar medições por data
- criar interface gráfica futuramente

---
