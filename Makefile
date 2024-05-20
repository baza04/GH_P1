build:
	javac -d ./bin ./src/Main.java

run: build
	java ./bin/Main.class
