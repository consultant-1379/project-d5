# 定义我们需要从哪个镜像进行构建
FROM node:16

  # 在镜像中创建一个文件夹存放应用程序代码，这将是你的应用程序工作目录
WORKDIR /usr/src/app


COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 8080
RUN export NODE_OPTIONS=--openssl-legacy-provider

CMD [ "npm", "start"]
