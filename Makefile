.DEFAULT_GOAL := run
run:
	mvnw clean package
	java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar 1
build:
	mvnw clean package
update:
	mvnw versions:update-properties
	mvnw versions:display-plugin-updates
