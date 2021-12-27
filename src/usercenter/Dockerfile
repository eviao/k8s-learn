FROM openjdk:17.0.1-oracle

LABEL author="eviao@live.cn"

WORKDIR /applications
COPY target/*.jar ./k8s-learn-usercenter.jar

EXPOSE 3000
CMD ["java", "-jar", "/applications/k8s-learn-usercenter.jar"]
