FROM node:17-slim

LABEL author="eviao@live.cn"

WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8002
CMD ["node", "index.js"]