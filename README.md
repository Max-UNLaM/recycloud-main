# RecyCloud Main

Este es el sistema principal de RecyCloud.

- [Instalar](#instalar)
- [Tecnologías](#tecnologías)
  - [Spring Framework](#spring-framework)
  - [Spring Boot](#spring-boot)
  - [Lombok](#lombok)
  - [Thymeleaf](#thymeleaf)
- [Estructura](#estructura)
- [Git Flow](#git-flow)

## Instalar

En unix
```shell script
mvn clean install
```

En windows
```shell script
./mvnw.cmd clean install
```

## Instalar Dependencias

### Mongo

### Ubuntu

```shell script
sudo apt update
```

```shell script
sudo apt install -y mongodb
```

Si se necesita acceder:

https://www.shellhacks.com/mongodb-install-client-mongo-shell-ubuntu-centos/

### Windows

https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

## Configurar

### Variables de Entorno
#### Terminal

```shell script
nano ~/.bashrc
```

Y añadir al final de todo:

```shell script
export MONGO_CONNECTION_STRING="mongodb://localhost"
export MONGO_DATABASE="recycloud"
export RECY_SQL_HOST="localhost:3306"
export RECY_SQL_DB="recycloud"
export RECY_SQL_USER="sa"
export RECY_SQL_PASSWORD="1234"
export RECY_ENV="PROD"
export RECY_COMMERCE_HOST="http://www.recycommerce.local"
export RECY_COMMERCE_STATUS=true
```

Puede que sea necesario reiniciar el IntelliJ para que reconozca las variables o, si se lo ejecuta desde la terminal:

```shell script
source ~/.bashrc
```

#### IntelliJ

Se puede incluir las variables en el mismo IDE. 
https://www.jetbrains.com/help/objc/add-environment-variables-and-program-arguments.html#

### Bases de datos

#### MYSQL

Primero es necesario cerar una base de datos a usar para nuestro proyecto.

```mysql
CREATE SCHEMA recycloud;
```

Crearle un usuario o modificar permisos

```mysql
CREATE USER 'sa'@'localhost' IDENTIFIED BY '1234';
```

Darle privilegios a ese usuario

```mysql
GRANT ALL PRIVILEGES ON * . * TO 'sa'@'localhost';
```

Para conectarse a las bases de datos, el proyecto necesita que se le pasen ciertas variables de entorno. Para esto, editar el archivo .bashrc o .zshrc:

#### Mongo

Para poder poblar a mongo con datos, primero generar las collections y asignarles un índice de tipo 2dsphere a location.

Conectarse a la base recycloud, si no existe, la va a crear

Primero abrir mongo
```shell script
mongo
```

Usar la base de datos, si no existe la va a crear
```mongojs
use recycloud
```

Agregarle los índices a las collections. Si no existe, las va a crear.
```mongojs
db.dialog.createIndex( {location : "2dsphere"});
db.pin.createIndex( {location : "2dsphere"});
```

Salir de mongo
```shell script
exit
```

Ir hacia la carpeta de mocks de resources

```shell script
cd ./src/main/resources/mocks
```
Cargar los datos a las collections, dentro de la carpeta de resources:
```shell script
mongoimport --jsonArray --db recycloud --collection pin --file pines.json   
mongoimport --jsonArray --db recycloud --collection dialog --file dialogs.json                                                                                                               1 ↵
```

### Poblar bases de datos

Hibernate generará las tablase necesarias en la primera ejecución. Pero estas no van a contar con información. Sumarle esa información usando los .sql que hay en /resources/sql.
Basta con ejecutarlos para poblar las bases de datos.

## Ejecutar

En unix
```shell script
mvn clean spring-boot:run
```

En windows
```shell script
./mvnw.cmd spring-boot:run
```

## Tecnologías

### Spring Framework
Es la base del proyecto conecta a todos los componentes Spring y mete su magia.

### Spring Boot
Usamos esto para poder iniciar el sitio. Añade el task spring-boot:run y se encarga de hacer todo el resto.

### Lombok
Provee annotations para generar modelos más fácilmente: https://projectlombok.org/features/all

### Thymeleaf
Es nuestro motor de templates. La configuración se encuentra en /conf/ThymeleafConfig. Ahí seteamos una carpeta raíz para los templates, y le decimos a Spring quién está va a resolver los templates.

### Mysql 8
Usar versión 8 por las dudas, pero cualquier está bien.

## Estructura
Los paquetes están organizados por "feature" (características). Cada característica del sistema tiene un paquete propio. Esta característica puede ser: calcular un mapa, mostrar una página web, etc. Cada feature implementará las capas necesarias. Por ejemplo: si un elemento es accesible por el navegador, tendrá un Controller, si accede a una base de datos, un DAO y así.

A continuación, un resumen de qué hacen los packages principales.

### Api
Aquí está la lógica interna del proyecto. Procesos, conexiones a apis externas, etc.

### Conf
Aquí están las configuraciones de Spring como el motor de template.

### Web
Aquí está la parte visual del proyecto. Tenemos páginas y componentes. Las páginas son los sitios donde se podrá navegar. Componentes son los elementos consumidos por las páginas (como puede ser un header, footer, o elementos visuales).

Es importante distinguir qué cosa le "importa" a cada feature. Por ejemplo: a la página "Mapa" no le interesa cómo se obtiene la información que dibuja en el mapa. Eso es tarea de la api. Entonces podemos tener dos features "mapa". Uno en la web, que es lo que se ve, y otro en api que es lo que se hace.

## Git Flow
Para organizar el trabajo usar la secuencia de git flow. Esta divide al proyecto en dos grandes ramas: develop y master que van en paralelo.

### Secuencia normal
1. Develop -> feature/cosa inicio del feature
2. feature/cosa -> develop completado del feature
3. Backport: develop -> features/existentes se mergean los cambios desde develop hacia los otros features activos
4. Release: develop -> release/1.0.0 una vez que se suman todos los features esperados, se lanza un release desde develop
5. Prueba del release
6. Salida a producción: release -> master
7. Backport: master -> develop

### Hotfix
Si surgen cuestiones a arreglar en producción (master) o en la beta (release), se generar hotfixes desde la rama
1. master -> hotfix/1.0.1 se crea branch del hotfix
2. hotfix/1.0.1 -> master se lleva el hotfix hacia producción

![Git flow chart](https://leanpub.com/site_images/git-flow/git-flow-nvie.png "Git Flow Chart")
