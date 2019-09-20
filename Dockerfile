FROM maven:latest
COPY . .
CMD mvn spring-boot:run
EXPOSE 9090/tcp
