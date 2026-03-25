# Domain Model

Projeto: App de Finanças Pessoais  
Plataforma: Android  
Linguagem: Kotlin

---

# 1. Visão Geral

O modelo de domínio define as entidades centrais responsáveis por representar as regras de negócio do aplicativo de finanças.

O sistema foi projetado para suportar:

- registro de receitas
- registro de despesas
- categorização de movimentos financeiros
- geração de relatórios financeiros
- evolução futura para metas financeiras e sincronização em nuvem

O domínio foi estruturado para manter **consistência financeira**, **simplicidade** e **extensibilidade**.

---

# 2. Entidades Principais

As principais entidades do domínio são:

- User
- Category
- Transaction
- TransactionType
- MonthlySummary (derivada)

---

# 3. User

Representa o usuário autenticado no sistema.

Cada usuário possui seus próprios dados financeiros isolados.

### Atributos

- id
- name
- email
- createdAt

### Observações

O identificador do usuário será fornecido pelo sistema de autenticação (Firebase Authentication).

---

# 4. Category

Representa uma categoria utilizada para classificar receitas ou despesas.

Exemplos de categorias:

- Alimentação
- Combustível
- Internet
- Moradia
- Lazer

### Atributos

- id
- userId
- name
- color
- createdAt

### Regras

- categorias pertencem a um usuário
- categorias podem ser criadas, editadas e removidas
- categorias podem ser usadas em múltiplas transações

---

# 5. Transaction

Representa um movimento financeiro realizado pelo usuário.

Uma transação pode ser uma **receita** ou uma **despesa**.

### Atributos

- id
- userId
- categoryId
- type
- amount
- description
- date
- createdAt

### Descrição dos campos

id  
Identificador único da transação.

userId  
Usuário dono da transação.

categoryId  
Categoria associada à transação.

type  
Define se é receita ou despesa.

amount  
Valor monetário da transação.

description  
Descrição opcional do lançamento.

date  
Data em que ocorreu a transação.

createdAt  
Data de criação do registro.

---

# 6. TransactionType

Define o tipo da transação.

Valores possíveis:

- INCOME
- EXPENSE

### INCOME

Representa entradas financeiras.

Exemplos:

- salário
- pagamento de serviços
- rendimentos

### EXPENSE

Representa saídas financeiras.

Exemplos:

- alimentação
- combustível
- aluguel
- compras

---

# 7. MonthlySummary

Representa um resumo financeiro mensal do usuário.

Esta entidade não precisa ser persistida diretamente, podendo ser derivada das transações.

### Atributos

- month
- year
- totalIncome
- totalExpense
- balance

### Cálculos

totalIncome  
Soma de todas as transações do tipo INCOME.

totalExpense  
Soma de todas as transações do tipo EXPENSE.

balance

balance = totalIncome - totalExpense

---

# 8. Regras de Negócio

As seguintes regras devem ser respeitadas:

1. Toda transação deve pertencer a um usuário.

2. Toda transação deve possuir um tipo válido (INCOME ou EXPENSE).

3. Toda transação deve possuir valor maior que zero.

4. Uma transação deve estar associada a uma categoria.

5. Categorias devem pertencer ao mesmo usuário da transação.

---

# 9. Relacionamentos

User
└── Category (1:N)

User
└── Transaction (1:N)

Category
└── Transaction (1:N)

---

# 10. Evoluções Futuras

O modelo permite futuras expansões como:

### Metas Financeiras

Nova entidade:

Goal

Exemplo de atributos:

- id
- userId
- categoryId
- targetAmount
- month
- year

---

### Contas Financeiras

Possível entidade futura:

Account

Exemplos:

- carteira
- conta corrente
- cartão de crédito

Isso permitiria rastrear de onde vem e para onde vai o dinheiro.

---

### Parcelamentos

Outra possível evolução:

InstallmentTransaction

Para registrar compras parceladas.

---

# 11. Princípios do Modelo

O modelo foi construído com os seguintes princípios:

- simplicidade
- separação clara de responsabilidades
- independência de infraestrutura
- foco em regras de negócio

Esse modelo pode ser facilmente mapeado para:

- Room Database
- APIs REST
- sincronização futura em nuvem
