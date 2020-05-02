# RecyCloud Main

Este es el sistema principal de RecyCloud.

- [Instalar](#instalar)
- [Tecnologías](#tecnologías)
  - [Spring Framework](#spring-framework)
  - [Spring Boot](#spring-boot)
  - [Lombok](#lombok)
  - [Thymeleaf](#thymeleaf)
- [Estructura](#estructura)


## Instalar

En unix
```shell script
mvn clean install
```

En windows
```shell script
./mvnw.cmd clean install
```

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