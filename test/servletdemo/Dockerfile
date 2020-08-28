FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package

FROM payara/server-full
COPY  --from=MAVEN_TOOL_CHAIN /tmp/target/ServletDemo-1.0.war /opt/payara/deployments/

