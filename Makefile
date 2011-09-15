all:
	env LA_ALL=en javac Main.java
	java Main

clean:
	rm -fr *.class