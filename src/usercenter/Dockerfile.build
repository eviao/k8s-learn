FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /usr/src/app
COPY . .
RUN mvn -e -T 1C clean package

FROM openjdk:17.0.1-slim
LABEL author="eviao@live.cn"
WORKDIR /apps
COPY --from=builder /usr/src/app/target/*.jar ./k8s-learn-usercenter.jar
EXPOSE 8000
CMD ["java", "-jar", "/apps/k8s-learn-usercenter.jar"]
