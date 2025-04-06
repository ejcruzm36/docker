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

    - ## Imagen
    Es una plantilla de solo lectura con instrucciones para crear un *contenedor*. Este tiene todo lo necesario para que funcione una aplicacion o un servicio  (paquetes, configuraciones, etc)
    
    Una imagen se compone por múltiples capas, las principales son:
       - **CAPA 1:** *FROM* -> Se define la base de la imagen, como JDK para aplicaciones java, Node, algun sistema operativo, etc.
       - **CAPA 2:** *RUN* -> Se define que comandos ejecutar mientras se crea una imagen. Estos comandos pueden ser la instalacion de paquetes, creacion de carpetas necesarias, etc
       - **CAPA 3:** *CMD* -> Es la linea que se ejecutara para levantar el servicio o una aplicacion.

    Estas capas se construyen mediante el DOCKERFILE

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


