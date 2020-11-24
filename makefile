all.o:
	javac -cp .:hamcrest-core-2.2.jar:junit-4.12.jar *.java
main.o:
	javac Tweets.java Users.java Main.java
tests.o:
	javac -cp .:hamcrest-core-2.2.jar:junit-4.12.jar Tweets.java Users.java Main.java
run:
	make all.o; java Main
runTests:
	make all.o; java -cp .:hamcrest-core-2.2.jar:junit-4.12.jar TestRunner
buildMain:
	make clean; make main.o; echo Main-class: Main > manifest.txt; jar cvfm Main.jar manifest.txt *.class
buildTests:
	make clean; make tests.o; echo "Main-Class: TestRunner\nClass-Path: junit-4.12.jar hamcrest-core-2.2.jar" > manifest.txt; jar cvfm Tests.jar manifest.txt *.class
clean:
	rm -f *.class