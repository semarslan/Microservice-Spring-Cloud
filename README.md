# Microservice with Spring Boot & Spring Cloud


# Teknolojiler

* Java 11
* Lombok
* PostgreSQL  
* Spring Boot
* Spring Cloud  
* REST-API
* API-Gateway
* Config-server
* Eureka-server & Eureka-client
* Admin-server
* Zipkin-server
* Hystrix
* Cassandra
* Elasticsearch
* RabbitMQ
* Docker



## Kısa kısa..

### API-GATEWAY
Mikroservis mimarisi ile ortaya çıkan pek çok servisin yönetiminin kontrolünü sağlamak için kullanılan yapı.

### Eureka-Server & Eureka-Client
Mikroservislerimize Eureka Client denilebilir. Bu clientlar yml, properties veya java konfigürasyonları ile kendilerine tanımlanmış olan 'Eureka Server' denilen ortama kendilerini kaydediyorlar.
Daha sonra bir servise ihtiyacı olan diğer servis, ulaşmak istediği servisin bilgilerini Eureka Server'dan alarak, işlemine devame diyor.
Bu sayde port, IP gibi bilgileri bir yerde tutmak zorunda kalmıyoruz.

### Admin-Server
.

### Netflix Hystrix
Mikroservislerin çalışma durumlarını dinler ve bir kullanıcı ui'ı sağlar.

### Zipkin Server
Tüm mikroservislerdeki requestlerin tracelerini loglayan yapı, örneğin; bir hata odluğunda nerede olduğunu bulmamızı kolaylaştırır.


