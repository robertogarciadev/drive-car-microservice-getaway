# 🚗 Driver-Car Microservices System

Este proyecto es una arquitectura de microservicios desarrollada en Java con Spring Boot, que gestiona la relación entre conductores y coches.
Incluye tres microservicios independientes (drivers, cars y un orquestador) y un API Gateway que centraliza todas las peticiones del cliente.

<img width="862" alt="Captura de Pantalla 2025-06-17 a las 11 01 16" src="https://github.com/user-attachments/assets/7978ac54-3c70-4897-abc9-db3ad45edb34" />



## 🧩 Microservicios

- **Car Service**: gestiona la información de los coches.
- **Driver Service**: gestiona la información de los conductores.
- **Driver-Car Service**: intermedia entre conductores y coches (relación N:M).
- **API Gateway**: expone un único punto de acceso para el cliente.

## 🛠️ Tecnologías utilizadas

### 🔷 Backend
- **Java 17**
- **Spring Boot**:
  - `spring-boot-starter-web`: para construir APIs REST.
  - `spring-boot-starter-data-jpa`: para persistencia de datos.
  - `spring-cloud-starter-openfeign`: para la comunicación entre microservicios.
- **Lombok**: simplificación de código (anotaciones como `@Getter`, `@Builder`, etc.).
- **Feign Client**: para llamadas declarativas entre microservicios.
- **Maven**: sistema de construcción y gestión de dependencias.

### 🐳 Contenedores y bases de datos
- **Docker**: contenedorización de bases de datos.
- **MySQL**: base de datos para el servicio de coches.
- **PostgreSQL**: base de datos para el servicio de conductores.

### 🧰 Herramientas adicionales
- **IntelliJ IDEA**: entorno de desarrollo.
- **DBeaver**: cliente visual para administrar MySQL y PostgreSQL.
- **Postman**: pruebas de los endpoints REST.

## 🔄 Comunicación entre servicios

Los microservicios se comunican usando **Feign Client**, permitiendo realizar llamadas REST de manera sencilla y desacoplada.
Por ejemplo, el servicio `driver-car` consulta datos directamente desde los servicios de `driver` y `car`.

## 🧪 Pruebas

Se han utilizado **Postman** y pruebas manuales para validar los endpoints expuestos por el API Gateway y los servicios internos.



