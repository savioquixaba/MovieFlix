# ================================
# Stage 1: Build
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia o pom.xml e baixa as dependências (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o restante do código e builda
COPY src ./src
RUN mvn clean package -DskipTests -B

# ================================
# Stage 2: Runtime
# ================================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Cria usuário não-root por segurança
RUN addgroup -S movieflix && adduser -S movieflix -G movieflix

# Copia o jar gerado no stage anterior
COPY --from=builder /app/target/*.jar app.jar

RUN chown movieflix:movieflix app.jar

USER movieflix

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]