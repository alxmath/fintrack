# ADR-001 – Arquitetura do Projeto

## Status

Aceito

---

# Contexto

O aplicativo será um sistema de controle de finanças pessoais que pode crescer com o tempo.

Para evitar acoplamento e facilitar manutenção, é necessário definir uma arquitetura clara.

---

# Decisão

O projeto utilizará:

Clean Architecture combinada com MVVM.

Estrutura de camadas:

UI → ViewModel → UseCase → Repository → DataSource

---

# Motivações

Clean Architecture oferece:

- separação de responsabilidades
- baixo acoplamento
- alta testabilidade
- facilidade de evolução

MVVM é o padrão recomendado para Android moderno.

---

# Consequências

Benefícios:

- código mais organizado
- testes mais simples
- substituição fácil de implementações

Desvantagens:

- maior quantidade de arquivos
- curva de aprendizado maior

---

# Alternativas Consideradas

MVC

Problemas:

- forte acoplamento
- difícil manutenção

MVP

Problemas:

- menos alinhado com Jetpack

---

# Decisão Final

Usar:

Clean Architecture + MVVM
