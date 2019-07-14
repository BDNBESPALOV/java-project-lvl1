.DEFAULT_GOAL := compile-run
compile:
	mkdir -p ./target/classes
	javac -d ./target/classes ./src/main/java/games/Slot.java
run:
	java -cp ./target/classes src.main.java.games.Slot
clear:
	rm -rf ./target
compile-run: compile run
