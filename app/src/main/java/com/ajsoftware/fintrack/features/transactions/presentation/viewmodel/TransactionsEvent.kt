package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

sealed class TransactionsEvent {

    data object TransactionSaved : TransactionsEvent()

}