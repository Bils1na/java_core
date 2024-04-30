FROM openjdk:latest
# устанавливаем рабочую директорию
WORKDIR /usr/src/app

COPY ./src/main/java .

RUN javac -sourcepath . -d out ./org/example/sem1/task1/Program.java

WORKDIR /usr/src/app/out

#CMD java -classpath . org.example.sem1.task1.Program
ENTRYPOINT ["java", "org.example.sem1.task1.Program"]