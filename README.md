# COVID dashboard

## Spring Boot Start

https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.3.1.RELEASE&packaging=jar&jvmVersion=14&groupId=poc.mikael&artifactId=coda&name=coda&description=COVID19%20dashboard&packageName=poc.mikael.coda&dependencies=web,devtools

## Data

https://data.europa.eu/euodp/en/data/dataset/covid-19-coronavirus-data

https://opendata.ecdc.europa.eu/covid19/casedistribution/json/

## UI

### Template language

https://pebbletemplates.io/

### Integrating NPM packages into JVM applications

https://www.baeldung.com/maven-webjars

https://www.webjars.org/

Webjars POMs have transitive dependencies which are 99% of the time meant as build dependencies,
so we'll blanket remove those.

```
configurations.all {
	withDependencies {
		this.filter { it.group == "org.webjars.npm" }
			.map { it as ExternalModuleDependency }
			.forEach { it.isTransitive = false }
	}
}
```

### UI Theme: AdminLTE 3

Source: https://github.com/ColorlibHQ/AdminLTE

Demo: https://adminlte.io/themes/v3/

Package: https://www.npmjs.com/package/admin-lte

```
	implementation("org.webjars.npm:admin-lte:3.0.5")
```

### UI Theme: CoreUI

**Source:** https://github.com/coreui/coreui-free-bootstrap-admin-template

**Demo:** https://coreui.io/demo/

https://coreui.io/bootstrap/

**Packages:** https://www.npmjs.com/package/@coreui/coreui

https://www.jsdelivr.com/package/npm/@coreui/coreui

https://www.jsdelivr.com/package/npm/@coreui/utils

```
	implementation("org.webjars.npm:coreui__coreui:3.4.0")
	implementation("org.webjars.npm:coreui__utils:1.3.1")
	implementation("org.webjars.npm:coreui__icons:2.0.0-rc.0")
	implementation("org.webjars.npm:coreui__chartjs:2.0.0")
```

**Docs:** https://coreui.io/docs/getting-started/introduction/

**Examples:** https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/master/src/index.html

https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/master/src/404.html

https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/master/src/500.html

