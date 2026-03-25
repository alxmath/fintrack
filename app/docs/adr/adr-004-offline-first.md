# ADR-004 – Estratégia Offline First

## Status

Aceito

---

## Contexto

Aplicativos de finanças pessoais precisam funcionar de forma confiável, mesmo quando o usuário não possui conexão com a internet.

Além disso, operações como registrar despesas devem ser rápidas e independentes da rede.

---

## Decisão

Adotar uma estratégia **Offline First**.

Nesta abordagem:

- os dados são gravados primeiro no banco local
- sincronização com serviços remotos ocorrerá posteriormente

Fluxo de dados:

App → Room Database → Sincronização futura com backend

---

## Motivações

Benefícios da estratégia Offline First:

- aplicação sempre responsiva
- funcionamento sem conexão com internet
- melhor experiência do usuário
- maior confiabilidade na gravação de dados

---

## Consequências

Benefícios:

- operações rápidas
- independência da rede
- melhor usabilidade

Desafios:

- necessidade de lógica de sincronização futura
- tratamento de conflitos de dados

---

## Alternativas Consideradas

### Online First

Neste modelo, os dados são enviados primeiro para um servidor.

Problemas:

- aplicativo depende de conexão constante
- maior latência nas operações
- risco de perda de dados em caso de falha de rede

---

## Decisão Final

Adotar **Offline First**, utilizando Room como fonte primária de dados.
