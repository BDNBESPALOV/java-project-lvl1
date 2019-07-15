.DEFAULT_GOAL := build-run
compile:
	mkdir -p ./target/classes
	javac -d ./target/classes ./src/main/java/games/Slot.java
run:
	java -cp ./target/classes src.main.java.games.Slot
clear:
	rm -rf ./target
compile-run: build build-run
build:
	./mvnw clean package
build-run:
	java -jar ./target/project-root-1.2-SNAPSHOT-jar-with-dependencies.jar
update:
	./mvnw versions:update-properties
	./mvnw versions:display-plugin-updates
