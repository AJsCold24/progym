# PRO-GYM Backend

Sistema de gestión de socios e inventario para gimnasio.

## Requisitos
- Java 17
- Maven
- SQL Server 2019+
- IntelliJ IDEA

## Configuración

1. Clona el repositorio
2. Copia `src/main/resources/application.properties.example`
   y renómbralo a `application.properties`
3. Edita `application.properties` con tu contraseña de SQL Server
4. Crea la base de datos en SQL Server:
```sql
   CREATE DATABASE gym_db;
```
5. Ejecuta el proyecto — Spring creará las tablas automáticamente

## Frontend
El archivo `index.html` está en `src/main/resources/static/`
Accede en: `http://localhost:8080/index.html`

## Endpoints principales
- GET  /api/socios
- POST /api/socios
- GET  /api/productos
- POST /api/inventario/entradas
- POST /api/inventario/salidas
- POST /api/auth/login