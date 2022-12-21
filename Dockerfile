FROM adoptopenjdk/maven-openjdk8
COPY target/ /AppFolder
WORKDIR /AppFolder
EXPOSE 8080
CMD java -jar voucherRedemptionManagement-0.0.1-SNAPSHOT.jar