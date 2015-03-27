# springMultiProject
Spring project with multiple modules

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
* copy war/target/war-<version>.war into your webapps folder
* use webap.xml as a template to configure and copy-it into the webapps folder too
