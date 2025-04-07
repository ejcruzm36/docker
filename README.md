# Docker (Integrado con Spring Boot)

1. ## Docker host:
Docker host es el ordenador o servidor donde se encuentra instalado Docker. Este contiene al Docker Daemon

2. ## Docker Deamon:
Docker deamon es el servicio que vive el servicio mismo de Docker. Escucha las solicitudes de Docker API y administra objetos Docker como imágenes, contenedores, redes y volúmenes.

3. ## Docker CLI:
Es la principal forma en que interactúan muchos usuarios con Docker. Cuando usas comandos como *docker run*, Docker CLI los envía comandos para Docker Daemon, que los lleva a cabo. El CLI el comando usa el API Docker. El Docker CLI puede comunicarse con más de un Docker Daemon.

- ### *Gráfica del funcionamiento de Docker*
        
        DOCKER CLIENT <--> REST API <--> DOCKER DEAMON

    - *Arquitectura:* https://docs.docker.com/get-started/images/docker-architecture.webp

**Ojo:** *Por medio de docker client podemos manejar imágenes, contenedores, volúmenes, etc.*

4. ## Objetos Docker

    - ## Dockerfile
    Es el archivo donde se define la **configuracion** de una **Imagen** de Docker. Este archivo contiene argumentos como:

    - #### Argumentos

        - **`FROM`:** En este se define la imagen base de donde construirá la image. Recordemos que una imagen puede partir de una imagen base. Además, todo dockerfile debe comenzar por este argumento. Para este proyecto se define lo siguiente (imagen base que contiene maven y jdk17 para compilar codigo fuente de nuestra aplicacion): `FROM maven:3.9-eclipse-temurin-17`.
        - **`RUN`:** Este argumento contiene comandos que se ejecutan en la terminal. Para el ejemplo se usa un comando para generar el *.jar* de nuestra aplicacion: `RUN mvn clean package -DskipTests`.
        - **`COPY/ADD`:** Sirven para copiar/agregar archivos desde nuestro entorno local hacia la imagen o copiar archivos desde otro contenedor en una imagen *multi-stag* (multi etapa). En nuestro ejemplo copiamos el *.jar* generado en la primera etapa para ejecutarlo desde la segunda etapa: `COPY --from=build /app/target/${APP_NAME} app.jar`
        - **`ENV`:** Sirven para definir variables de entorno
        - **`WORKDIR`:** Este argumento nos sive para definir directorios de trabajo. Es decir, indicamos a docker que los siguientes argumentos (como *COPY*) trabajaran desde la ruta que se le indica. En nuestra aplicacion, definimos que nuestro directorio o carpeta de trabajo será */app* del contenedor. `WORKDIR /app`
        - **`EXPOSE`:** Este argumentos nos sirve para exponer puertos
        - **`LABEL`:** 
        - **`USER`:** Este argumento define que usuario ejecutará la tarea
        - **`VOLUME`:** 
        - **`CMD`:**
        ------------------------------
        - **`.dockerignore`:**

    - ## Imagen
    Es una plantilla de solo lectura con instrucciones para crear un *contenedor*. Este tiene todo lo necesario para que funcione una aplicacion o un servicio  (paquetes, configuraciones, etc)
    
    Una imagen se compone por múltiples capas, las principales son:
       - **CAPA 1:** *FROM* -> Se define la base de la imagen, como JDK para aplicaciones java, Node, algun sistema operativo, etc.
       - **CAPA 2:** *RUN* -> Se define que comandos ejecutar mientras se crea una imagen. Estos comandos pueden ser la instalacion de paquetes, creacion de carpetas necesarias, etc
       - **CAPA 3:** *CMD* -> Es la linea que se ejecutara para levantar el servicio o una aplicacion.

    Estas capas se construyen mediante el **DOCKERFILE**

    #### *Comando para crear una imagen*

        docker build <opciones> . 
    *el punto especifica que el dockerfile se encuentra en nuestra ubicacion actual*

    #### *Opciones:* 

    Estas opciones son las más usadas para construir una imagen a partir de un **DOCKERFILE**

    | Opciones | Descripcion| Ejemplo |
    | --- | --- | --- |
    | **`-f`, `--file`**   | Especifica el Dockerfile si no está en la ruta por defecto.  | `-f Dockerfile.dev` |
    | **`-t`, `--tag`**   | Nombra y etiqueta la imagen que estás construyendo. | `-t miapp:latest` |
    | **`--build-arg`**  | Pasa variables de entorno en tiempo de construcción. | `--build-arg VERSION=1.0.0` |
    | **`--no-cache`**  | Fuerza que no se use la caché, asegurando una construcción limpia.  | `--no-cache` |
    | **`--pull`**   | Descarga siempre la última versión de las imágenes base.   | `--pull` |
    | **`--platform`**  | Define para qué arquitectura estás construyendo.  | `--platform=linux/amd64` |
    | **`--output`** | Especifica el destino de salida de la imagen. Útil con `buildx`. | `--output=type=docker` |
    | **`--push`**   | Envía la imagen directamente a un registro remoto una vez construida.  | `--push` |
    | **`--cache-from` / `--cache-to`**  | Usa o guarda caché para acelerar futuras construcciones. | `--cache-from=type=local,src=./.build_cache` |


    - ## Contenedores
    Un contenedor es una instancia ejecutable de una imagen. Un contenedor contiene la **ejecucion de la imagen**, contiene **volúmenes** y contiene **redes**, que sirven para comunicar contenedores entre si.
    
    **Ojo:** *Los contenedores son temporales, si se desea hacer algun cambio en la configuración se tiene que hacer en la imagen, de lo contrario se perderán los cambios que hagamos.*







asdasd

    +-------------------+
    |     Dockerfile    | <--- (Receta con instrucciones)
    +-------------------+
            |
            v
    +--------------------+
    |   Imagen Docker    | <--- (Plantilla con todo para ejecutar la app)
    +--------------------+
            |
            v
    +------------------------+
    |  Contenedor Docker      | <--- (La ejecución, corriendo la app de manera aislada)
    |  (Proceso en ejecución)|
    +------------------------+
            |
            v
        [Accede a la app en tu puerto expuesto]


