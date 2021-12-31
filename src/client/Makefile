IMAGE_NAME=eviaocloud/k8s-learn-client
CONTAINER_NAME=k8s-learn-client-container

build:Dockerfile
	docker build -t ${IMAGE_NAME} .

run:
	docker run --name ${CONTAINER_NAME} -p 80:80 -d ${IMAGE_NAME}

stop:
	docker stop ${CONTAINER_NAME}

rm:
	docker rm ${CONTAINER_NAME}

sh:
	docker exec -it ${CONTAINER_NAME} sh

push:
	docker push ${IMAGE_NAME}