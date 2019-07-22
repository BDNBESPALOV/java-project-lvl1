.DEFAULT_GOAL := run
run:
	rm -rf ./target
	javac -d ./target/classes ./src/main/java/games/*.java
	jar cfe ./target/java-project-lvl1.jar games.Choice  -C ./target/classes .
	java -jar ./target/java-project-lvl1.jar 1
runWin:
	rd /S /Q target
	javac -d ./target/classes ./src/main/java/games/Choice.java
	jar cfe ./target/java-project-lvl1.jar games.Choice  -C ./target/classes .
	java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar
build:
	D:\XO_\java-project-lvl1\mvnw clean package
update:
	D:\XO_\java-project-lvl1\mvnw versions:update-properties
	D:\XO_\java-project-lvl1\mvnw versions:display-plugin-updates
	
	
