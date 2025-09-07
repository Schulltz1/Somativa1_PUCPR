FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN find . -name "*.java" > sources.txt && \
    javac -d target/classes -cp . @sources.txt

EXPOSE 80

CMD ["java", "-cp", "./target/classes", "br.estudos.calculadora.Main", "--port", "80"]