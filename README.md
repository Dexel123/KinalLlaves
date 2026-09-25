# PaginaLib3 - Módulo de Persistencia

Documentación técnica y configuración de la conexión a la base de datos mediante JDBC para el proyecto.

## 1. Requisitos Previos
* **Servidor de Base de Datos:** MySQL Server (versión 8.0 o superior recomendada) ejecutándose localmente o en un servidor accesible.
* **Driver JDBC:** Librería **MySQL Connector/J** integrada en las bibliotecas de Apache NetBeans del proyecto.

## 2. Parámetros de Conexión (`config.properties`)
La conexión se administra externamente mediante un archivo de propiedades (`config.properties`) ubicado en `src/main/resources/`:

* **`db.url`**: URL JDBC que apunta al esquema de la base de datos. 
  * *Formato:* `jdbc:mysql://localhost:3306/paginalib3?useSSL=false&serverTimezone=UTC`
* **`db.user`**: Nombre de usuario con privilegios en MySQL (ej. `root`).
* **`db.password`**: Contraseña correspondiente al usuario configurado.

## 3. Consideraciones Técnicas del Driver
* **Clase del Driver:** Se invoca de forma explícita la clase `com.mysql.cj.jdbc.Driver`.
* **Configuraciones de la URL:** Se incluyen los parámetros `useSSL=false` para evitar conflictos de certificados locales y `serverTimezone=UTC` para prevenir discrepancias horarias con el motor.
