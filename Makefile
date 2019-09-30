# find . -name "*.java" > sources.txt
# javac -sourcepath . @sources.txt
SRC_FILE = sources.txt

all:
	find . -name "*.java" > sources.txt
	javac -sourcepath . @$(SRC_FILE)
