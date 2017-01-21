
# Run me

## hello-service

Create web service endpoint
> gradle build
> java -jar build/libs/hello-service-0.1.jar

OR just run the default tasks
> gradle

## hello-client

Generate the client stubs using wsimport
> cd hello-client/
> wsimport -s src/main/ws/ http://localhost:8080/WS/Hello?wsdl

> gradle run

## hello-webclient


