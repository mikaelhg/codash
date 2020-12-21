package io.mikael.poc

import java.net.URI

data class ApplicationConfiguration(val jsonUrl: URI)

const val F_CUMULATIVE = "Cumulative_number_for_14_days_of_COVID-19_cases_per_100000"

const val F_POPULATION = "popData2019"

const val F_COUNTRYCODE = "countryterritoryCode"

const val F_DATE = "dateRep"
