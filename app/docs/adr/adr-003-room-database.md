# ADR-003 – Uso do Room Database

## Status

Aceito

---

## Contexto

O aplicativo precisa armazenar dados localmente para permitir o funcionamento offline.

As principais opções avaliadas foram:

- SQLite direto
- Room Database
- bibliotecas de banco de dados externas

---

## Decisão

Utilizar **Room Database** como solução de persistência local.

Room é parte do **Android Jetpack** e funciona como uma camada de abstração sobre SQLite.

---

## Motivações

Motivos para usar Room:

- integração oficial com Android Jetpack
- verificação de queries em tempo de compilação
- suporte nativo a migrations
- menor quantidade de código comparado ao SQLite puro
- suporte a coroutines e Flow

---

## Consequências

Benefícios:

- código mais seguro
- menor risco de erros em queries SQL
- facilidade de manutenção

Desvantagens:

- pequena curva de aprendizado inicial
- limitações em queries muito complexas

---

## Alternativas Consideradas

### SQLite direto

Vantagens:

- controle total sobre o banco de dados

Desvantagens:

- grande quantidade de boilerplate
- maior chance de erros

### Bancos de dados externos

Exemplo:

Realm

Desvantagens:

- dependência externa
- menor integração com Jetpack

---

## Decisão Final

Utilizar **Room Database** como camada de persistência local.
