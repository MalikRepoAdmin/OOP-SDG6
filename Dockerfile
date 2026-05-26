FROM eclipse-temurin:25-jdk-jammy

WORKDIR /app

COPY . /app

RUN find . -name "*.java" > sources.txt && \
    javac -cp ".:lib/*" @sources.txt

CMD ["java", "-cp", ".:lib/*", "Main"]
