# gRPC in spring-boot

so here is a demo of gRPC implemented in spirng-boot :

the app is based on :
- https://github.com/vinsguru/grpc-java-course/tree/master/99-old-projects/grpc-flix

> the repo use two gRPC endpoint and use a REST API which calls it aggregator as REST server, get the data and by usign gRPC client send the collected data to gRPC endpoints

the app expose two endpoints :

- localhost:8080 -> http api based on spring web for H2-console
- localhost:6565 -> for grpc (not http)

using gRPC :

- first you use the proto directory and import both files in **POSTMAN**
- then you send this message by selecting **Use Example Message**:
```json
{
  "login_id" : "vinsguru"
}
```

 