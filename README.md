
# JAX-WS tutorial

## Build it

```
> gradle -p hello-service run
```
* Access http://localhost:8080/WS/Hello?wsdl to see details
* Ctrl-C
```
> gradle -p hello-service generatews
```

```
> gradle -p hello-client importws
> gradle -p hello-client build
```

```
> gradle -p hello-webclient importws
> gradle -p hello-webclient compileJava
> gradle -p hello-webclient appRun
```
* After all access http://localhost:8181/hello-webclient/hello to see how it works.

## Run it
### Start server
```
> gradle -p hello-service run
```
* Access http://localhost:8080/WS/Hello?wsdl to see details

### Run client
```
> gradle -p hello-client runClient
```

### Run web client
```
> gradle -p hello-webclient appRun
```
* After all access http://localhost:8181/hello-webclient/hello to see how it works.


## Others
```
> gradle -p hello-service build
> java -jar hello-service/build/libs/hello-service-0.1.jar
```

