# Specify a base image
# Base images should come from a reputable maintainer and should not include unused dependencies
FROM amazoncorretto:11

# Set labels for the image for fetching purposes
# Intermediary layers added by LABEL are automatically removed
LABEL com.rolea.learning.dockerlearning.version.is-production="false" \
      com.rolea.learning.dockerlearning.release-date="05-04-2020" \
      com.rolea.learning.dockerlearning.maintainer="rolea"

# Specify a wildcard for resolving the fat jar during the image build phase
# The JAR_FILE variable won't be resolvable once the build finishes
ARG JAR_FILE=target/docker-demo-*.jar

# Define environment variables for the group id, group name, user id and user name
ENV APP_ID=9988 \
    APP_NAME=spring-boot

# Create user and group in order to avoid running the app as root
RUN yum install -y shadow-utils  && \
    groupadd --gid $APP_ID $APP_NAME && \
    useradd --uid $APP_ID --gid $APP_NAME --shell /bin/bash --create-home $APP_NAME && \
    yum clean all

# Switch to non-root user
USER $APP_NAME

# Copy the spring boot fat jar from the local file system to the image
COPY ${JAR_FILE} /usr/local/bin/hello-world.jar

# Define the port on which the app binds
EXPOSE 8081

# Run the app (Xmx is no longer needed since JVM is aware of container limits since Java 10)
ENTRYPOINT ["java", "-Xms512M", "-jar", "/usr/local/bin/hello-world.jar"]
