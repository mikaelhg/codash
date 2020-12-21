# COVID dashboard

## Data

https://data.europa.eu/euodp/en/data/dataset/covid-19-coronavirus-data

https://opendata.ecdc.europa.eu/covid19/casedistribution/json/

## Backend

Spring Boot + Spring Kofu.

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

