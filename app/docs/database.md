# Database Documentation – App de Finanças Android

## Visão Geral

O aplicativo utiliza **Room Database** como solução de persistência local, seguindo a estratégia **Offline First**.

Todos os dados são armazenados localmente no dispositivo e poderão futuramente ser sincronizados com um backend/cloud.

Banco de dados:

```

finance_db

```

Principais entidades:

- users
- categories
- transactions

---

# Entidades

## users

Representa o usuário autenticado no aplicativo.

Tabela:

```

users

```

Campos:

| Campo     | Tipo                | Obrigatório | Descrição                      |
| --------- | ------------------- | ----------- | ------------------------------ |
| id        | TEXT (UUID)         | sim         | Identificador único do usuário |
| name      | TEXT                | sim         | Nome do usuário                |
| email     | TEXT                | sim         | Email do usuário               |
| photoUrl  | TEXT                | não         | URL da foto do perfil          |
| createdAt | INTEGER (timestamp) | sim         | Data de criação                |

Índices:

- unique(email)

Observações:

- O login é feito via **Google OAuth (Firebase Authentication)**.
- O id pode ser sincronizado futuramente com backend.

---

## categories

Representa categorias de receitas ou despesas.

Tabela:

```

categories

```

Campos:

| Campo     | Tipo        | Obrigatório | Descrição                             |
| --------- | ----------- | ----------- | ------------------------------------- |
| id        | TEXT (UUID) | sim         | Identificador da categoria            |
| userId    | TEXT        | sim         | Usuário dono da categoria             |
| name      | TEXT        | sim         | Nome da categoria                     |
| type      | TEXT        | sim         | Tipo da categoria (INCOME ou EXPENSE) |
| color     | TEXT        | não         | Cor usada na UI                       |
| icon      | TEXT        | não         | Ícone da categoria                    |
| createdAt | INTEGER     | sim         | Data de criação                       |

Índices:

- index(userId)
- index(type)

Relacionamentos:

```

users (1) → (N) categories

```

Observações:

- Cada usuário possui suas próprias categorias.

---

## transactions

Representa receitas e despesas registradas pelo usuário.

Tabela:

```

transactions

```

Campos:

| Campo       | Tipo        | Obrigatório | Descrição                   |
| ----------- | ----------- | ----------- | --------------------------- |
| id          | TEXT (UUID) | sim         | Identificador da transação  |
| userId      | TEXT        | sim         | Usuário dono da transação   |
| categoryId  | TEXT        | sim         | Categoria associada         |
| type        | TEXT        | sim         | INCOME ou EXPENSE           |
| amount      | REAL        | sim         | Valor da transação          |
| description | TEXT        | não         | Descrição opcional          |
| date        | INTEGER     | sim         | Data da transação           |
| createdAt   | INTEGER     | sim         | Data de criação do registro |

Índices:

- index(userId)
- index(categoryId)
- index(date)

Relacionamentos:

```

users (1) → (N) transactions
categories (1) → (N) transactions

```

Observações:

- O campo **amount** é sempre positivo.
- O tipo da transação define se ela é receita ou despesa.

---

# Enums

## TransactionType

Define o tipo da transação.

Valores:

```

INCOME
EXPENSE

```

Uso:

- classificação da transação
- cálculos de relatórios
- filtros de listagem

---

# Queries Principais

## Buscar transações do mês

```

SELECT *
FROM transactions
WHERE userId = :userId
AND date BETWEEN :startDate AND :endDate
ORDER BY date DESC

```

---

## Total de receitas do mês

```

SELECT SUM(amount)
FROM transactions
WHERE userId = :userId
AND type = 'INCOME'
AND date BETWEEN :startDate AND :endDate

```

---

## Total de despesas do mês

```

SELECT SUM(amount)
FROM transactions
WHERE userId = :userId
AND type = 'EXPENSE'
AND date BETWEEN :startDate AND :endDate

```

---

## Gastos por categoria

```

SELECT categoryId, SUM(amount)
FROM transactions
WHERE type = 'EXPENSE'
AND date BETWEEN :startDate AND :endDate
GROUP BY categoryId

```

---

# Cálculo de Resumo Mensal

O resumo mensal não é persistido no banco.

Ele é calculado em memória.

Estrutura:

```

MonthlySummary

```

Campos:

| Campo        | Tipo   |
| ------------ | ------ |
| totalIncome  | Double |
| totalExpense | Double |
| balance      | Double |

Cálculo:

```

balance = totalIncome - totalExpense

```

---

# Estratégia de IDs

Todos os registros utilizam:

```

UUID

```

Motivos:

- evitar colisão
- facilitar sincronização futura
- independência de backend

---

# Estratégia de Migração

Room utilizará **Database Migrations** para alterações estruturais.

Boas práticas:

- nunca remover colunas diretamente
- sempre criar migration explícita
- manter histórico de versões

Exemplo:

```

Migration(1, 2)

```

---

# Versionamento do Banco

Versão inicial:

```

version = 1

```

Alterações futuras devem:

- incrementar versão
- criar migration correspondente

---

# Sincronização Futura (Planejado)

Quando backend for introduzido:

Estratégia:

```

local-first
sync-later

```

Campos adicionais poderão ser adicionados:

```

synced
updatedAt
deletedAt

```

Para suportar:

- sincronização incremental
- soft delete
- resolução de conflitos

```

```
