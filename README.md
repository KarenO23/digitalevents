# digitalevents

Servicio web que permite el registro  y la consulta de eventos 
digitales. Se hace uso de un enfoque de diseño orientado al dominio (DDD)
que provee una estructura practica y terminologia sencilla que facilita
la toma de desiciones en base al negocio.

# Estructura del proyecto
El proyecto esta divido en tres fases:
* Web - Se define el controlador y la documentación
* Domain - Contiene la lógica del negocio
* Persistence - Entidades de base de datos.

* ### Documentacion: 
Se hace uso de la herramienta swagger2 v3.0.0 para la documentación para el consumo de la aplicación.
>.../digitalevents/api/swagger-ui/index.html

* ### Request:
- Se crea la entrada para el registro de eventos tomando como parametros el evento, la plataforma y la fecha en que se
origina la petición.
>.../digitalevents/api/event/registry?idPlatform=DEPO&idEvent=F004&initDate=02/10/2022

- Se crea la entrada para la consulta de eventos por plataforma, utilizando como parámetros la plataforma y la fecha.
>.../digitalevents/api/event/platform?idPlatform=DEPO&date=02/10/2022

# Tecnologias
Se hizo uso de las siguientes tecnoligias
* Postgres 42.3.1
* Java 11
* Framework Spring boot 2.5.0
* Swagger 3.0.0
* Herramienta postman para la validacion de peticiones.
