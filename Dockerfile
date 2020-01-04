FROM openjdk:8
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-servicio-client-Enterprise-0.0.1-SNAPSHOT.jar client-enterprise.jar
ENTRYPOINT ["java","-jar","/client-enterprise.jar"]
