FROM openjdk:17.0.1-oracle

LABEL author="eviao@live.cn"

WORKDIR /apps
COPY target/*.jar ./k8s-learn-usercenter.jar

EXPOSE 8000
CMD ["java", "-jar", "/apps/k8s-learn-usercenter.jar"]
