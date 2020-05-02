# Docker Learning Repository #

### Sample commands ###

- Build image from Dockerfile: `docker build --tag hello-world:1.0.0 .`
- Start the container: `docker run -p 8081:8081 --name hello-world hello-world:1.0.0`
- Start with remote debug support: `docker run  \
-e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n" \
-p 8081:8081 -p 5005:5005 hello-world:1.0.0`
- Start with memory limits: `docker run -p 8081:8081 --name hello-world \
--memory=1g --memory-swap=1G --oom-kill-disable hello-world:1.0.0`
- Start with a volume mount: `docker run -p 8081:8081 --name hello-world \
--mount 'type=volume,src=my-volume,dst=/usr/local/bin/target,volume-driver=local' hello-world:1.0.0`
- Start with a custom network: `docker run -p 8081:8081 --name hello-world \
--network my-network hello-world:1.0.0`

### Pushing and pulling images ###

- Login to Dockerhub: `docker login`
- Tag the image: `docker tag hello-world:1.0.0 alexrolea/hello-world:1.0.0`
- Push the image: `docker push alexrolea/hello-world:1.0.0`
- Pull the image: `docker pull alexrolea/hello-world:1.0.0`

