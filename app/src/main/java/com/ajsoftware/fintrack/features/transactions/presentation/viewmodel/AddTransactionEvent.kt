package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

sealed class AddTransactionEvent {

    object TransactionSaved : AddTransactionEvent()

}