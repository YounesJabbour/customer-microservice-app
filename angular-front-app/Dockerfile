FROM node:latest as build

# Stage 1: Building the app

# Work directory in the container
WORKDIR /usr/local/app

# Copy the source code in the container
COPY ./ /usr/local/app/

# install dependencies
RUN npm install

# build the project
RUN npm run build



# Stage 2: Serve the app using nginx
FROM nginx:latest

COPY --from=build /usr/local/app/dist/angular-front-app/browser /usr/share/nginx/html

#Expose on 80
EXPOSE 80
