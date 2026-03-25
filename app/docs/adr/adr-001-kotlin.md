# ADR-001 – Uso de Kotlin como linguagem principal

## Status

Aceito

---

## Contexto

O desenvolvimento do aplicativo Android exige a escolha de uma linguagem de programação principal.

As principais opções disponíveis no ecossistema Android são:

- Java
- Kotlin

Historicamente, muitos aplicativos Android foram desenvolvidos em Java. No entanto, o Android moderno passou a adotar Kotlin como linguagem oficial.

---

## Decisão

O projeto utilizará **Kotlin** como linguagem principal de desenvolvimento.

---

## Motivações

Motivos para a escolha de Kotlin:

- linguagem oficialmente recomendada pelo Google para Android
- menor quantidade de boilerplate
- suporte nativo a coroutines para programação assíncrona
- melhor segurança contra NullPointerException (null safety)
- maior produtividade no desenvolvimento

Além disso, a maioria das bibliotecas modernas do Android já são projetadas com Kotlin em mente.

---

## Consequências

Benefícios:

- código mais conciso e legível
- melhor integração com Jetpack
- suporte moderno a concorrência com coroutines

Possíveis desvantagens:

- curva de aprendizado para desenvolvedores acostumados apenas com Java
- algumas bibliotecas antigas podem ter suporte limitado

---

## Alternativas Consideradas

### Java

Vantagens:

- linguagem amplamente conhecida
- grande quantidade de material existente

Desvantagens:

- maior quantidade de código boilerplate
- menor integração com recursos modernos do Android
- ausência de null safety nativo

---

## Decisão Final

O projeto adotará **Kotlin como linguagem principal de desenvolvimento**.
