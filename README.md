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
registro-glicemia-java/
│
├── v1
│   ├── App.java
│   └──glicemia_exemplo.txt
├── v2
│   ├── App.java
│   └── entities
│       ├── GerenciadorArquivos.java
│       └── Medicao.java
│
├── medicoes.csv
├── medicoes.txt  
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

## 📋 Exemplo do menu v2

```text
------------------------- Controle de glicemia ------------------------------
1 - Adicionar medição   |   2 - Listar medições  |   3 - Média             
4 - Ranking Completo    |   5 - Buscar           |   6 - Remover medição  
0 - Sair                |
> 
```

---

## ⚠️ Arquivos fictício para demonstração

Todos os arquivos presentes neste repositório contém **dados fictícios**, criados apenas para demonstrar o funcionamento do sistema.

>AVISO: Este programa possui finalidade exclusivamente didática.
>Os resultados não devem ser utilizados para diagnóstico médico.

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido como prática de programação em Java e também como uma solução simples para organizar medições de glicemia de forma acessível e útil para acompanhamento médico.

Além do aprendizado técnico, a proposta foi criar algo com **utilidade real**, simulando um pequeno sistema de registro de saúde.

---

## 🚀 Possíveis melhorias futuras
- banco de dados
- filtros mais avançados
- exportação de relatorios
- criar interface gráfica futuramente

---
