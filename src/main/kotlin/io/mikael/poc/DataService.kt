package io.mikael.poc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Service
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

@Service
class DataService(private val objectMapper: ObjectMapper,
				  private val configuration: ApplicationConfiguration)
{
	val data: List<CovidRecord> by lazy { fetchData() }

	fun getNumbers() = data

	fun fetchData(): List<CovidRecord> {
		val client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_1_1)
				.followRedirects(HttpClient.Redirect.NEVER)
				.connectTimeout(Duration.ofSeconds(2))
				.build()
		val request = HttpRequest.newBuilder(configuration.jsonUrl)
				.GET()
				.timeout(Duration.ofSeconds(5))
				.build()
		val response = client.send(request, HttpResponse.BodyHandlers.ofString())

		val doc = objectMapper.readTree(response.body())

		val parser = doc["records"].traverse()

		return objectMapper.readValue(parser)
	}

}