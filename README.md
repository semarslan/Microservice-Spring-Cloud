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

### Eureka-Server & Eureka-Client
Mikroservislerimize Eureka Client denilebilir. Bu clientlar yml, properties veya java konfigürasyonları ile kendilerine tanımlanmış olan ve 'Eureka Server' denilen ortama kendilerini kaydediyorlar.
Daha sonra bir servise; ihtiyacı olan diğer servis, ulaşmak istediği servisin bilgilerini Eureka Server'dan alarak, işlemine devam ediyor.
Bu sayede port, IP gibi bilgileri bir yerde tutmak zorunda kalmıyoruz.

Elimizde pek çok servis olduğunda bunların port, ip bilgileri, instanceları nelerdir gibi bilgilerinin bir yerde tutulması gerekir. Basitçe bir registry yapısının olması gerekiyor. Daha sonra bunlar birbirlerine erişmek isteyebilirler, bunun için Account service ayağa kalktığında ticket service'in nerde olduğunu yani hangi portta olduğu öğrenmek için eureka'ya gelir. Bir diğeri ise tickettan pek çok instance var; frontend geliştirilirken de eureka üzerinden yük dağılımı (load balancer) için kolaylıklar sağlar. 
Desteklediği algoritma ile default'ta her bir isteği sırasıyla yönlendirir. 

### Admin-Server
Her bir spring boot uygulamasının detaylı hatalarını, threadlerini, ne kadar yer kapladığı vs. gibi pek çok fonksiyonu sunan yapı.
https://codecentric.github.io/spring-boot-admin/current/

### API-GATEWAY
Mikroservis mimarisi ile ortaya çıkan pek çok servisin yönetiminin, kontrolünü sağlamak için kullanılan yapı.
Eureka üzerinden api'ların dışarıya açılmasını, api gateway ile tek bir nokta haline getirilmesini sağlar. Roller eklenebilir.

### Netflix Hystrix
Mikroservislerin çalışma durumlarını dinler ve bir kullanıcı ui'ı sağlar. Api'lardaki hata case'lerini hsytrix dashboard ile takibini sağlarız.

### Zipkin Server
Tüm mikroservislerdeki requestlerin tracelerini loglayan yapı, örneğin; bir hata odluğunda nerede olduğunu bulmamızı kolaylaştırır.


