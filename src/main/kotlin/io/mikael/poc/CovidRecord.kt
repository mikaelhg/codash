package io.mikael.poc

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class CovidRecord(

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonProperty(F_DATE) val date: LocalDate,

    val cases: Int,

    val deaths: Int,

    @JsonProperty(F_COUNTRYCODE)
	val countryCode: String?,

    @JsonProperty(F_POPULATION)
	val population: Long,

    @JsonProperty(F_CUMULATIVE)
	val cumulativeCases: Double
)
