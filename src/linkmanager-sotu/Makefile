CONTAINER_NAME=k8s-learn-linkmanager-sotu
IMAGE_NAME=localhost:5000/${CONTAINER_NAME}

build:Dockerfile
    docker build -t ${IMAGE_NAME} .

push:
    docker push ${IMAGE_NAME}