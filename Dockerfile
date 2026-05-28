FROM eclipse-temurin:25-jdk-jammy

WORKDIR /app

# Copy the entire project into the container
COPY . /app

# 1. Create the bin directory for compiled files
# 2. Find all source files and compile them into 'bin', using 'lib/*' for dependencies
RUN mkdir -p bin && \
    find . -name "*.java" > sources.txt && \
    javac -cp ".:lib/*" -d bin @sources.txt

# Run the app: classpath includes your compiled classes (bin) and your drivers (lib/*)
CMD ["java", "-cp", "bin:lib/*", "Main"]
