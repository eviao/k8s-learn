IMAGE_NAME=localhost:5000/k8s-learn-usercenter
CONTAINER_NAME=k8s-learn-usercenter-container

build:Dockerfile
	docker build -t ${IMAGE_NAME} .

run:
	docker run --name ${CONTAINER_NAME} -p 8000:8000 -d ${IMAGE_NAME}

rm:
	-docker stop ${CONTAINER_NAME}
	-docker rm ${CONTAINER_NAME}
	-docker rmi ${IMAGE_NAME}

bash:
	docker exec -it ${CONTAINER_NAME} bash

push:
	docker push ${IMAGE_NAME}