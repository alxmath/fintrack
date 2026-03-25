# UI Guidelines – App de Finanças Android

## Visão Geral

Este documento define os padrões visuais e de experiência do usuário do aplicativo.

O objetivo é garantir:

- consistência visual
- boa usabilidade
- interface simples

O aplicativo seguirá **Material Design 3**.

---

# Princípios de Design

O design deve priorizar:

- simplicidade
- legibilidade
- rapidez de uso

Regra importante:

Registrar uma transação deve levar **menos de 10 segundos**.

---

# Paleta de Cores

Sugestão inicial:

Primary

#4CAF50

Representa finanças positivas.

Secondary

#2196F3

Usado em ações secundárias.

Erro / Despesa

#F44336

Usado para indicar despesas.

Background

#F5F5F5

Texto principal

#212121

Texto secundário

#757575

---

# Tipografia

Fonte padrão:

Roboto

Tamanhos recomendados:

Título

24sp

Subtítulo

20sp

Texto principal

16sp

Texto secundário

14sp

---

# Componentes Principais

Botões

- Botão primário
- Botão secundário
- Floating Action Button (FAB)

Inputs

- campo de valor
- campo de descrição
- seletor de categoria
- seletor de data

Cards

- resumo financeiro
- categoria
- transação

---

# Padrões de Tela

Dashboard

Deve exibir:

- saldo do mês
- receitas
- despesas
- gráfico

Transações

Lista simples contendo:

- valor
- categoria
- data

Adicionar Transação

Campos:

- tipo
- valor
- categoria
- descrição
- data

---

# Navegação

Estrutura principal:

Bottom Navigation

Itens:

- Dashboard
- Transações
- Relatórios
- Categorias

Adicionar transação:

Floating Action Button

---

# Ícones

Biblioteca recomendada:

Material Icons

Exemplos:

Receita

arrow_downward

Despesa

arrow_upward

Categoria

label

Relatórios

bar_chart

---

# Espaçamento

Margens padrão:

16dp

Espaçamento interno:

8dp

Padding de cards:

16dp

---

# Feedback ao Usuário

Sempre fornecer feedback:

- Snackbar para ações concluídas
- AlertDialog para confirmação
- Loading indicators para operações demoradas

---

# Acessibilidade

Boas práticas:

- contraste adequado
- tamanhos de toque mínimos (48dp)
- suporte a leitor de tela
