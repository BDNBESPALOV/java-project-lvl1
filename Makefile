.DEFAULT_GOAL := build-run
compile:
	mkdir -p ./target/classes
	javac -d ./target/classes ./src/main/java/games/Slot.java
run:
	java -cp ./target/classes src.Slot
clear:
	rm -rf ./target
compile-run: build build-run
build:
	./mvnw clean package
build-run:
	java -jar ./target/F-1-jar-with-dependencies.jar
update:
	./mvnw versions:update-properties
	./mvnw versions:display-plugin-updates
