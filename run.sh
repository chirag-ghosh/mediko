#build jar file
mvn package -Djacoco.skip=true

#run the jar file
java -jar target/mediko-1.0-SNAPSHOT.jar