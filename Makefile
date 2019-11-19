# find . -name "*.java" > sources.txt
# javac -sourcepath . @sources.txt
SRC_FILE = sources.txt

all:
	find . -name "*.java" > sources.txt
	javac -sourcepath . @$(SRC_FILE)

clean :
	rm za/co/wethinkcode/*.class
	rm za/co/wethinkcode/interfaces/*.class
	rm za/co/wethinkcode/factories/*.class
	rm za/co/wethinkcode/classes/*.class
