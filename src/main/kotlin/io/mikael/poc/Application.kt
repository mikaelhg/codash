package io.mikael.poc

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.loader.ClasspathLoader
import com.mitchellbosecke.pebble.spring.extension.SpringExtension
import com.mitchellbosecke.pebble.spring.servlet.PebbleViewResolver
import org.springframework.boot.logging.LogLevel
import org.springframework.core.io.ClassPathResource
import org.springframework.fu.kofu.webApplication
import org.springframework.fu.kofu.webmvc.webMvc

object Application {

	internal val app = webApplication {
		logging {
			level = LogLevel.ERROR
		}
		beans {
			configurationProperties<ApplicationConfiguration>(prefix = "app")
			bean<DataService>()
			bean {
				val engine = PebbleEngine.Builder()
					.apply {
						loader(ClasspathLoader())
						extension(SpringExtension(ref()))
					}
					.build()
				PebbleViewResolver(engine).apply {
					setPrefix("templates/")
					setSuffix(".pebble")
				}
			}
		}
		webMvc {
			engine = undertow()
			router {
				val service = ref<DataService>()
				GET("/") {
					ok().render("index", mapOf("members" to "12345"))
				}
				GET("/api/numbers") {
					ok().body(service.getNumbers())
				}
				resources("/webjars/**", ClassPathResource("META-INF/resources/webjars/"))
			}
			converters {
				string()
				resource()
				jackson {
					indentOutput = true
				}
			}
		}
	}

	@JvmStatic
	fun main(args: Array<String>) {
		app.run(args)
	}

}
