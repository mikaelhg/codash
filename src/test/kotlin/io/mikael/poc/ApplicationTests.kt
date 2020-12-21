package io.mikael.poc

import io.mikael.poc.Application.app
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.context.ConfigurableApplicationContext

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	private lateinit var context: ConfigurableApplicationContext

	@BeforeAll
	fun beforeAll() {
		context = app.run(profiles = "test")
	}

	@AfterAll
	fun afterAll() {
		context.close()
	}

	@Test
	fun dataServiceTest() {
		val dataService = context.getBean(DataService::class.java)
		println(dataService.data[234])
	}

}
