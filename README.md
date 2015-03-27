# springMultiProject
Spring project with multiple modules separated
* Database model and DAO service
  * JDO with Datanucleus
* WebServices
* Static web content
* War deployer

### Database connection
* database: springJdoSample
* user: test
* password: test

### First create table
from modelAndDao module folder
```
mvn datanucleus:schema-create
```

### Compile all
from parent folder
```
mvn clean install
```

### Development run
from war module folder
```
mvn spring-boot:run
```

### Deploy as WAR in a jetty distribution
* copy war/target/war-<version>.war into your jetty distribution folder
* use config/jettyConfig.xml as a template to configure and copy-it into the webapps folder too
* by default jetty distributions deploy all .xml in the webapps folder
