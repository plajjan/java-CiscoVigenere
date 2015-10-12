DEP = -classpath .
JFLAGS = -g -Xlint $(DEP)
JC = javac
JAR = jar
JARFILE = ciscovigenere.jar
JARFLAGS = cf $(JARFILE)

default: jar

classes:
	$(JC) $(JFLAGS) net/spritelink/CiscoVigenere.java

jar: classes
	$(JAR) $(JARFLAGS) net/spritelink/CiscoVigenere.class

clean:
	$(RM) *.class $(JARFILE)
