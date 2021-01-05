FROM centos:7
WORKDIR /usr/src/app
RUN curl -sL https://rpm.nodesource.com/setup_10.x | bash - && yum install nodejs -y 
COPY "*.js" /usr/src/app/
CMD [ "node", "server.js" ]
