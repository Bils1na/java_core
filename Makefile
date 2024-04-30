#all:
#    javac -sourcepath .src/ -d out src/main/java/org/example/Main.java

SRC_DIR := src
OUT_DIR := out

JC := javac
JCFLAGS := -sourcepath .$(SRC_DIR)/ -d $(OUT_DIR)