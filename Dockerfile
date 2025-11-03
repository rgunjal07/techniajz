FROM alpine
RUN apk add openjdk17
#ENV PATH=$PATH:/usr/lib/jvm/java-17-openjdk/bin/javac
WORKDIR /app

ENTRYPOINT ["java", "-jar", "app.jar"]

