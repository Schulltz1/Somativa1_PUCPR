# Build stage
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

# Instalar Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Copiar arquivos de configuração do Maven primeiro (para cache)
COPY pom.xml .

# Baixar dependências (fica em cache se pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Copiar código fonte
COPY src ./src

# Compilar e gerar JAR
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-slim

WORKDIR /app

# Copiar apenas o JAR do stage anterior
COPY --from=build /app/target/*.jar app.jar

# Criar usuário não-root para segurança
RUN groupadd -r appuser && useradd -r -g appuser appuser
RUN chown appuser:appuser app.jar
USER appuser

# Expor porta (se necessário)
EXPOSE 8080

# Comando para executar
ENTRYPOINT ["java", "-jar", "app.jar"]