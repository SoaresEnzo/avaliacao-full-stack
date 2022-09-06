#Using official node image as the base image
FROM node:current-alpine3.16 as node
WORKDIR /app
COPY ./ ./
RUN npm install
RUN npm run build

#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/ui-app/ /usr/share/nginx/html/

EXPOSE 4200:80