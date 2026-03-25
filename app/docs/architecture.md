# Arquitetura do Sistema

Projeto: App de Finanças Pessoais  
Plataforma: Android  
Linguagem: Kotlin

---

# 1. Visão Geral

O aplicativo segue os princípios de **Clean Architecture** combinados com **Vertical Slice Architecture**.

Objetivos da arquitetura:

- alta testabilidade
- baixo acoplamento
- alta coesão
- facilidade de manutenção
- escalabilidade de funcionalidades

A aplicação é dividida em **features independentes**, onde cada feature contém seus próprios componentes de apresentação, domínio e dados.

---

# 2. Padrões Arquiteturais

A aplicação utiliza os seguintes padrões:

- Clean Architecture
- Vertical Slice Architecture
- MVVM (Model View ViewModel)
- Repository Pattern
- Dependency Injection

---

# 3. Estrutura de Camadas

A arquitetura segue o fluxo:

UI → ViewModel → UseCase → Repository → DataSource

Responsabilidades:

UI  
Responsável pela renderização de telas e interação do usuário.

ViewModel  
Gerencia estado da tela e coordena chamadas de casos de uso.

UseCase  
Contém regras de negócio específicas da aplicação.

Repository  
Interface que abstrai o acesso a dados.

DataSource  
Responsável pela persistência (local ou remoto).

---

# 4. Estrutura do Projeto

Estrutura principal:
app
core
features

Detalhamento:

app
│
├── core
│ ├── database
│ ├── di
│ ├── utils
│ ├── navigation
│ └── common
│
├── features
│ ├── auth
│ ├── dashboard
│ ├── transactions
│ ├── categories
│ └── reports

Cada feature possui sua própria estrutura interna.

---

# 5. Estrutura de uma Feature

Exemplo: transactions

transactions
│
├── presentation
│ ├── activity
│ ├── viewmodel
│ └── state
│
├── domain
│ ├── model
│ ├── repository
│ └── usecase
│
└── data
├── repository
├── datasource
└── entity

---

# 6. Gerenciamento de Estado

O estado das telas será gerenciado via **ViewModel + StateFlow**.

Responsabilidades:

ViewModel

- expõe estado da tela
- chama casos de uso
- trata eventos da UI

UI

- observa mudanças de estado
- renderiza a interface

---

# 7. Persistência de Dados

A persistência local será feita com **Room Database**.

Vantagens:

- integração nativa com Android
- suporte a Kotlin Coroutines
- segurança de tipos
- consultas SQL eficientes

Principais tabelas:

- users
- categories
- transactions
- goals (futuro)

---

# 8. Autenticação

A autenticação será feita via **Firebase Authentication**.

Métodos suportados:

- Login com Google
- Email e senha (opcional)

Os dados do usuário serão isolados por **userId**.

---

# 9. Estratégia Offline

O aplicativo adotará estratégia **Offline First**.

Fluxo:

1. dados são salvos localmente (Room)
2. sincronização futura com backend ou cloud

Isso garante funcionamento mesmo sem internet.

---

# 10. Injeção de Dependência

Será utilizado **Hilt** para gerenciar dependências.

Benefícios:

- menor acoplamento
- facilidade de testes
- melhor organização

---

# 11. Bibliotecas Principais

Stack principal:

Kotlin  
Android Jetpack  
Room Database  
Hilt  
Firebase Authentication  
MPAndroidChart

---

# 12. Navegação

A navegação entre telas será feita utilizando:

Android Navigation Component

Benefícios:

- gerenciamento seguro de rotas
- passagem de argumentos tipada
- melhor integração com ViewModel

---

# 13. Testes

Serão implementados:

Testes unitários para:

- UseCases
- ViewModels

Ferramentas:

JUnit  
MockK

---

# 14. Princípios Seguidos

SOLID

Single Responsibility  
Open/Closed  
Liskov Substitution  
Interface Segregation  
Dependency Inversion

---

# 15. Escalabilidade

A arquitetura permite crescimento com novas funcionalidades:

- metas financeiras
- sincronização em nuvem
- exportação de relatórios
- integração bancária futura

Sem impacto nas features existentes.
