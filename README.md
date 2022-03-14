# Taller 8 - Cantera 2 -Sofka

## Bingo virtual: Taller final

La empresa "El Gran Buda", una casa de juegos de apuestas y azar, requiere desarrollar un Bingo Virtual, bajo los siguientes requerimientos.

1. Cada persona deberá ser un usuario del sistema, usted puede usar lo que más le convenga como por ejemplo:
* El clásico usuario y contraseña.
* Identificación con cualquier red social.
* Identificación con cuentas de correo como por ejemplo de Gmail, Outlook, entre otros.
* Identificación por medio alguna wallet como por ejemplo MetaMask (web 3.0)
2. Los usuarios (backend) serán manejados con NodeJS + MongoDB.
3. El frontend puede ser desarrollado en Angular, ReactJS, VueJS o cualquier otro framework y/o librería, como también lo puede hacer en HTML puro producido desde NodeJS bajo la tecnología que usted desee escoger.
4. La comunicación entre el frontend y el backend, debe ser de forma exclusiva por medio de fetch, axios o cualquier otro método que use la tecnología AJAX; si desea usar websockets también lo puede hacer, no hay problema.
5. El backend, es decir, quien maneja la lógica del negocio, deberá ser escrita en Java con Spring Boot.
6. La base debe principal debe usar MySQL, PostgreSQL, Oracle o MSSQL.
7. Aplique todos los conocimientos adquiridos en Cantera Nivel 2.
8. El backend en Java, sí requiere información de un usuario, el sistema deberá solicitarlo a NodeJS a través del consumo de un API.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## ¿Que hizo falta para completar el taller?
1. Aplicar la lógica al juego bingo, 
generando los cartones para cada jugador,
elegir las balotas en el bingo y determinar el ganador

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Backend - Juego Bingo
Proyecto desarrollado en IntelliJ IDEA Ultimate, utilizando:
* JAVA - Spring boot
* MySQL
## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
```
git clone https://github.com/tattortega/Taller_8.git
```
2. Ejecute el método principal directamente en el IDE para iniciar la aplicación Spring Boot.
```
Run 'BingoGameApplication'
```
------------------------------------------------------------------------------------------------------------------------
# Backend - Usuarios del Bingo
Proyecto desarrollado en IntelliJ IDEA Ultimate, utilizando:
* Node.js
* MongoDB
## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
```
git clone https://github.com/tattortega/Taller_8.git
```
2. Ubicarse en la raiz del proyecto:
```
cd .\backend\
cd .\users\
```
3. Ejecutar los siguientes comandos:
```
npm install
npm run dev
```
---------------------------------------------------------------------------------------------
# Frontend - Bingo
Proyecto desarrollado en IntelliJ IDEA Ultimate, utilizando:
* Vue.js version 2

## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
```
git clone https://github.com/tattortega/Taller_8.git
```
2. Ubicarse en la raiz del proyecto:
```
cd .\frontend\
cd .\bingo\
```
3. Ejecutar los siguientes comandos:
```
npm install
npm run serve

Abrir la URL http://localhost:3000/
```



