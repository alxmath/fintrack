package com.ajsoftware.fintrack.features.reports.domain.model

enum class ReportPeriod(val days: Long) {
    LAST_7_DAYS(7),
    LAST_30_DAYS(30),
    LAST_90_DAYS(90)
}