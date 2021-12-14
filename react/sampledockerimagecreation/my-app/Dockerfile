FROM node
WORKDIR /app
copy . /app/
RUN npm install
RUN export NODE_OPTIONS=--openssl-legacy-provider
CMD [ "npm","start" ]