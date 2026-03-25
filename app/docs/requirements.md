# Documento de Requisitos

App: Controle de Finanças Pessoais

## 1. Visão Geral

Aplicativo mobile Android que permite ao usuário registrar, acompanhar e analisar suas finanças pessoais.

O aplicativo permitirá registrar receitas e despesas, categorizá-las e visualizar relatórios e gráficos financeiros mensais.

O objetivo é ajudar o usuário a entender seus hábitos financeiros e melhorar seu controle de gastos.

---

## 2. Público-alvo

Pessoas que desejam controlar finanças pessoais de forma simples.

Perfis:

- estudantes
- trabalhadores
- autônomos
- pequenos empreendedores

---

## 3. Funcionalidades Principais

### 3.1 Cadastro de Usuário

O usuário poderá criar conta utilizando autenticação OAuth.

Opções:

- Login com Google
- Login com email e senha

---

### 3.2 Gestão de Categorias

O usuário poderá:

- criar categorias
- editar categorias
- excluir categorias

Exemplos:

- alimentação
- combustível
- internet
- lazer
- moradia

---

### 3.3 Registro de Despesas

O usuário poderá registrar despesas contendo:

- valor
- categoria
- descrição
- data

---

### 3.4 Registro de Receitas

O usuário poderá registrar entradas financeiras contendo:

- valor
- categoria
- descrição
- data

---

### 3.5 Visualização de Movimentos

O usuário poderá:

- visualizar lista de movimentos
- filtrar por mês
- filtrar por categoria

---

### 3.6 Relatórios

O aplicativo deverá apresentar:

- total de receitas
- total de despesas
- saldo mensal

---

### 3.7 Gráficos

O aplicativo apresentará gráficos como:

- gastos por categoria
- evolução de gastos mensais
- proporção de despesas

---

## 4. Requisitos Não Funcionais

### Performance

O aplicativo deve carregar dados em menos de 2 segundos.

---

### Segurança

- autenticação via OAuth
- dados isolados por usuário

---

### Usabilidade

Interface simples e intuitiva baseada em Material Design.

---

### Offline

O aplicativo deve funcionar offline para consulta e registro de dados.

---

## 5. Plataforma

- Android
- versão mínima Android 8 (API 26)

---

## 6. Tecnologias

- Kotlin
- Android Studio
- Clean Architecture
- Vertical Slice
- Room Database
- Firebase Authentication
- MPAndroidChart
