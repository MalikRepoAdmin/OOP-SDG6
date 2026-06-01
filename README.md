# Sistem Manajemen Sanitasi Sungai

---

# Tim Pengembang

| Nama | NIM | Peran |
|--------|--------|--------|
| ZAHRAH | 244311060 | Role 1 |
| Angelis Nasta Nadia | 254311010 | Role 2 |
| Mohamad Malik Fajar Baihaqi| 254311011 | Role 3 |
| Raditya Daffa Pratama | 254311018 | Role 4 |

---

# Teknologi yang Digunakan

- Java 17
- Java Swing
- Jakarta Validation 3.1.1
- JUnit Jupiter 5
- Maven

---

# Dependencies

## Jakarta Validation

Digunakan untuk validasi input data sebelum diproses oleh sistem.

```xml
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>3.1.1</version>
</dependency>
```

## JUnit Jupiter

Digunakan untuk pengujian unit (unit testing).

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.13.1</version>
    <scope>test</scope>
</dependency>
```

---

# Prerequisites 

Pastikan perangkat telah memenuhi kebutuhan berikut sebelum menjalankan proyek.

## Java Development Kit

- JDK 17 versi yang digunakan oleh tim

Verifikasi instalasi:

```bash
java --version
javac --version
```

---

## Visual Studio Code

Install:

- Visual Studio Code
- Extension Pack for Java

Disarankan memasang extension berikut:

### Wajib

- Extension Pack for Java
- Language Support for Java™ by Red Hat
- Debugger for Java
- Test Runner for Java
- Maven for Java

### Opsional

- Gradle for Java
- GitLens
- Error Lens

---

# Cara Menjalankan Proyek

## Clone Repository

```bash
git clone <repository-url>
```

Masuk ke folder proyek:

```bash
cd SistemInformasiSungai
```

---

## Compile

Jika menggunakan Maven:

```bash
mvn clean compile
```

---

## Menjalankan Aplikasi

```bash
mvn exec:java
```

atau jalankan file:

```text
Main.java
```

melalui IDE.

---

# Menjalankan Unit Test

```bash
mvn test
```

atau melalui:

- VS Code Test Explorer
- JUnit Test Runner

---

# Kontributor

Seluruh anggota tim pengembang Sistem Informasi Sungai.

---

# Lisensi

Proyek ini dibuat untuk keperluan akademik dan pembelajaran.