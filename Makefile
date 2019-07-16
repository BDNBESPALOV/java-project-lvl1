.DEFAULT_GOAL := run
compile: clearW
	javac -d ./target/classes ./src/main/java/games/Slot.java
run: compile
	java -cp ./target/classes main.java.games.Slot
clearW:
	rd /S /Q target
clearU:
	rm -rf ./target