# Peppa Lanches 🍔

## 👥 Autores

- Tiago Henrique Ribeiro Lemos - 42421637
- Ana Carolina dos Santos - 42421890   
- Lucas Silva Rodrigues

Este projeto consiste na implementação de testes automatizados utilizando **Java**, **JUnit** e **Cucumber**, seguindo o estilo BDD (Behavior Driven Development). O domínio do problema é uma **hamburgueria**, onde são definidos cenários de pedido, regras de negócio e comportamentos esperados do sistema.

## Objetivo

- Completar os cenários no arquivo `.feature`.
- Implementar as classes de teste em Java:
  - Runner (`RunnerTest.java`)
  - Steps (`PedidoSteps.java`)
- Garantir que **todos os testes passem**, respeitando as regras de negócio dos cenários definidos em BDD.

## 📦 Tecnologias utilizadas
- **Java 21+**
- **JUnit**
- **Cucumber JVM**
- **Gherkin**
- **Maven**

## ⚙️ Pré-requisitos
- Java 11 (ou versão compatível com seu `pom.xml`)  
- Maven instalado na máquina  
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code etc.)  

## 📁 Estrutura do repositório
```
hamburgueria/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── runner/
│       │   │   └── RunnerTest.java
│       │   └── steps/
│       │       └── PedidoSteps.java
│       │
│       └── resources/
│           └── features/
│               └── pedidos.feature
│
└── pom.xml
```

## 📝 Sobre os Cenários

O arquivo .feature define o comportamento esperado do sistema em linguagem natural (Gherkin).
Os testes seguem a estrutura clássica:

- Dado (estado inicial)

- Quando (ação)

- Então (resultado esperado)

Cada passo deve possuir sua implementação correspondente em PedidoSteps.java.
