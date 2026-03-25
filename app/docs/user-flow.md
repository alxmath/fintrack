# User Flow – App de Finanças Android

## Visão Geral

Este documento descreve os **principais fluxos de navegação do usuário** dentro do aplicativo de controle de finanças.

O objetivo é garantir:

- navegação simples
- poucas etapas para registrar transações
- acesso rápido a relatórios

O aplicativo segue o princípio:

```

3 toques ou menos para registrar uma transação

```

---

# Fluxo Geral do Aplicativo

Fluxo principal:

```

Abrir aplicativo
↓
Tela de Login
↓
Autenticação com Google
↓
Dashboard
↓
Usuário pode navegar para:

* Nova Transação
* Lista de Transações
* Categorias
* Relatórios

```

---

# 1. Fluxo de Login

Objetivo: autenticar o usuário usando **Google OAuth (Firebase Authentication)**.

Fluxo:

```

Usuário abre o aplicativo
↓
Tela de Login
↓
Botão "Entrar com Google"
↓
Google Authentication
↓
Login bem sucedido
↓
Criar usuário no banco local (se necessário)
↓
Ir para Dashboard

```

Possíveis exceções:

```

Falha na autenticação
↓
Exibir mensagem de erro
↓
Permitir nova tentativa

```

---

# 2. Fluxo do Dashboard

O **Dashboard** é a tela principal do aplicativo.

Ele apresenta:

- saldo do mês
- total de receitas
- total de despesas
- gráfico de gastos por categoria
- acesso rápido para adicionar transação

Fluxo:

```

Login concluído
↓
Abrir Dashboard
↓
Carregar dados do mês atual
↓
Exibir resumo financeiro

```

Ações possíveis:

```

Adicionar transação
Ver lista de transações
Ver relatórios
Gerenciar categorias

```

---

# 3. Fluxo de Cadastro de Transação

Registrar uma nova **receita ou despesa**.

Fluxo:

```

Usuário toca em "Adicionar"
↓
Tela Nova Transação
↓
Selecionar tipo:
- Receita
- Despesa
↓
Selecionar categoria
↓
Inserir valor
↓
Inserir descrição (opcional)
↓
Selecionar data
↓
Salvar transação
↓
Persistir no Room Database
↓
Atualizar Dashboard

```

Validações:

```

Valor deve ser maior que zero
Categoria deve ser selecionada

```

Resultado:

```

Transação salva com sucesso

```

---

# 4. Fluxo de Listagem de Transações

Permite visualizar todas as transações registradas.

Fluxo:

```

Dashboard
↓
Usuário abre "Transações"
↓
Listagem por data (mais recente primeiro)

```

Funcionalidades:

```

Filtrar por:

* mês
* tipo (receita/despesa)
* categoria

```

Ações possíveis:

```

Editar transação
Excluir transação

```

---

# 5. Fluxo de Edição de Transação

Fluxo:

```

Usuário abre lista de transações
↓
Seleciona uma transação
↓
Tela de edição
↓
Alterar campos
↓
Salvar alterações
↓
Atualizar banco local

```

---

# 6. Fluxo de Exclusão de Transação

Fluxo:

```

Usuário abre uma transação
↓
Seleciona "Excluir"
↓
Exibir confirmação
↓
Usuário confirma
↓
Remover transação do banco
↓
Atualizar Dashboard

```

---

# 7. Fluxo de Gerenciamento de Categorias

Permite criar categorias para organizar receitas e despesas.

Fluxo:

```

Usuário abre menu Categorias
↓
Lista de categorias

```

Ações possíveis:

```

Criar categoria
Editar categoria
Excluir categoria

```

Criar categoria:

```

Botão "Nova Categoria"
↓
Inserir nome
Selecionar tipo (receita ou despesa)
Selecionar cor
Selecionar ícone
↓
Salvar

```

---

# 8. Fluxo de Relatórios

Tela destinada à análise financeira.

Fluxo:

```

Dashboard
↓
Usuário abre "Relatórios"

```

Informações exibidas:

```

Resumo mensal
Total de receitas
Total de despesas
Saldo

```

Visualizações:

```

Gráfico de pizza
Gastos por categoria

```

Filtro:

```

Selecionar mês

```

---

# 9. Fluxo Offline

O aplicativo funciona **totalmente offline**.

Fluxo de persistência:

```

Usuário registra transação
↓
Dados salvos no Room Database
↓
Dashboard atualizado imediatamente

```

Sincronização futura (planejado):

```

Room Database
↓
Sync Service
↓
Backend / Cloud

```

---

# 10. Primeiro Uso do Aplicativo

Fluxo inicial:

```

Instalar aplicativo
↓
Abrir pela primeira vez
↓
Tela de Login
↓
Autenticação Google
↓
Criar perfil local
↓
Criar categorias padrão

```

Categorias padrão sugeridas:

Despesas:

```

Alimentação
Transporte
Moradia
Lazer
Saúde
Educação
Outros

```

Receitas:

```

Salário
Freelance
Investimentos
Outros

```

---

# Fluxo de Navegação Simplificado

Mapa geral:

```

Login
↓
Dashboard
↓
├── Nova Transação
├── Transações
├── Categorias
└── Relatórios

```

---

# Objetivo de UX

O aplicativo deve priorizar:

```

rapidez
simplicidade
clareza de dados

```

Princípios:

- registrar transações rapidamente
- visualizar saldo facilmente
- entender gastos sem esforço

```

```
