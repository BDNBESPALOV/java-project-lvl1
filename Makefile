.DEFAULT_GOAL := run
runW:
	mvnw clean package
	C:\Program Files\Java\jdk-12.0.1\bin\java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar 1
run:
	./mvnw clean package
	./mvnw versions:update-properties
	./mvnw versions:display-plugin-updates
	java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar 1
run_old:
	rm -rf ./target
	javac -d ./target/classes ./src/main/java/games/*.java
	jar cfe ./target/java-project-lvl1.jar games.Choice  -C ./target/classes .
	java -jar ./target/java-project-lvl1.jar 1
runWin:
	rd /S /Q target
	mvn compile package
	javac -d ./target/classes ./src/main/java/games/*.java
	jar cfe ./target/java-project-lvl1.jar games.Slot  -C ./target/classes .
	jar cfe ./target/java-project-lvl1.jar games.Drunkard  -C ./target/classes .
	jar cfe ./target/java-project-lvl1.jar games.Choice  -C ./target/classes .
	java -jar ./target/java-project-lvl1.jar 1
build:
	D:\XO_\java-project-lvl1_\mvnw clean package
update:
	D:\XO_\java-project-lvl1_\mvnw versions:update-properties
	D:\XO_\java-project-lvl1_\mvnw versions:display-plugin-updates



