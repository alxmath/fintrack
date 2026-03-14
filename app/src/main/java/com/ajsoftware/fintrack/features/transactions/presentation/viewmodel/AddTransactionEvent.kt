package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

sealed class AddTransactionEvent {

    object TransactionSaved : AddTransactionEvent()

    data class Error(val message: String) : AddTransactionEvent()

}