project created for a 3 tier project to run on [Pivotal CF](https://docs.pivotal.io/pivotalcf/1-12/devguide/deploy-apps/deploy-app.html)

source inspired from https://spring.io/guides/gs/rest-service/

Run spring server with Gradle.
```batch
./gradlew bootRun
```

Build and deployment
--------------------


To create a deployable self contained jar (FAT jar)
(Name specified in build.gradle under JAR section)
```batch
./gradlew bootRepackage
```

This creates a FAT jar in /build/libs/gs-accessing-data-mysql-0.1.0.jar

This can be executed with

```batch
java -jar gs-accessing-data-mysql-0.1.0.jar --spring.profiles.active=prod
```

profile determines which credentials to use in the /src/main/resources/application.yml file  
is prod or local, if not specified, default is used. this is aliased to local

This can be deployed to Cloud Foundry, after the ```cf``` cmd line is installed and logged in.

```batch
cf push helloworldbackend -p build/libs/gs-accessing-data-mysql-0.1.0.jar  --no-start
```

create service
--------------

cf create-service elephantsql turtle hw-postgres

bind and run app
-------

```batch
cf bind-service helloworldbackend hw-postgres
cf restart helloworldbackend
```

binding to services
-------------------

to bind to services in CF check the following example [ref](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#cloud-deployment-cloud-foundry-services)
```java
@Component
class MyBean implements EnvironmentAware {

    private String instanceId;

    @Override
    public void setEnvironment(Environment environment) {
        this.instanceId = environment.getProperty("vcap.application.instance_id");
    }

    // ...

}
```
