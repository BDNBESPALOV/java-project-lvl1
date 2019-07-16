.DEFAULT_GOAL := run
compile: clearW
	javac -d ./target/classes ./src/main/java/games/Slot.java
run: compile
	java -cp ./target/classes main.java.games.Slot
clearW:
	rd /S /Q target
clearU:
	rm -rf ./target
build_old:
	jar cfe ./target/java-project-lvl1.jar main.java.games.Slot  -C ./target/classes .
build_run_old:
	java -jar ./target/java-project-lvl1.jar main.java.games.Slot
build:
	D:\XO_\java-project-lvl1\mvnw clean package
build_run:
	java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar
update:
	D:\XO_\java-project-lvl1\mvnw versions:update-properties
	D:\XO_\java-project-lvl1\mvnw versions:display-plugin-updates
	
	
