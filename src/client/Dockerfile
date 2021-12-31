FROM nginx:alpine

LABEL author="eviao@live.cn"

WORKDIR /usr/share/nginx/html

COPY build/*.* ./
COPY build/static/css ./static/css
COPY build/static/js ./static/js

EXPOSE 80