FROM openjdk:17
ARG JAR_FILE=build/libs/pharmacy_way.jar
COPY ${JAR_FILE} ./pharmacy_way.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "./pharmacy_way.jar"]