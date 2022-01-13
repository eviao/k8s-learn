FROM maven:3-openjdk-17
WORKDIR /usr/src/app
COPY . .
RUN mvn -e -T 1C clean package

FROM openjdk:17-slim
LABEL author="eviao@live.cn"
WORKDIR /app
COPY --from=builder /usr/src/app/target/*.jar ./k8s-learn-linkmanager.jar
EXPOSE 8001
CMD ["java", "-jar", "/app/k8s-learn-linkmanager.jar"]