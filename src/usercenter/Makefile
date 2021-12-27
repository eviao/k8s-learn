IMAGE_NAME=eviaocloud/k8s-learn-usercenter
CONTAINER_NAME=k8s-learn-usercenter-container

build:Dockerfile
	docker build -t ${IMAGE_NAME} .

run:
	docker run --name ${CONTAINER_NAME} -p 3000:3000 -d ${IMAGE_NAME}

stop:
	docker stop ${CONTAINER_NAME}

rm:
	docker rm ${CONTAINER_NAME}

bash:
	docker exec -it ${CONTAINER_NAME} bash

push:
	docker push ${IMAGE_NAME}