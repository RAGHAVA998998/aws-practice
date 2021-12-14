FROM node
WORKDIR /app
COPY package.json .
RUN npm install
COPY . /app/            
RUN export NODE_OPTIONS=--openssl-legacy-provider
CMD [ "npm","start" ]