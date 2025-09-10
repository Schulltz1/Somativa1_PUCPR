FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN mkdir -p target/classes

RUN find . -name "*.java" > sources.txt && \
    javac -d target/classes -cp . @sources.txt

CMD ["java", "-cp", "target/classes", "br.estudos.calculadora.Main"]