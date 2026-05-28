-- SQLite Clean Water Database Schema

-- -----------------------------------------------------
-- Table User
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS User (
  id_user TEXT NOT NULL,
  nama TEXT NULL,
  password TEXT NOT NULL,
  email TEXT NOT NULL,
  tgl_lahir TEXT NULL,
  pekerjaan TEXT NULL,
  bio TEXT NULL,
  foto_profil BLOB NULL,
  domisili TEXT NULL,
  PRIMARY KEY (id_user)
);

-- -----------------------------------------------------
-- Table Sungai
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Sungai (
  id_sungai INTEGER NOT NULL,
  status TEXT NULL CHECK(status IN ('Bersih', 'Cukup Bersih', 'Kurang Bersih', 'Tercemar')),
  koordinat TEXT NULL,
  alamat TEXT NOT NULL,
  nama_sungai TEXT NOT NULL,
  gambar_sungai BLOB NULL,
  id_user TEXT NOT NULL,
  PRIMARY KEY (id_sungai),
  FOREIGN KEY (id_user) REFERENCES User (id_user) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- -----------------------------------------------------
-- Table Admin
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Admin (
  id_admin TEXT NOT NULL,
  password TEXT NULL,
  email TEXT NULL,
  PRIMARY KEY (id_admin)
);

-- -----------------------------------------------------
-- Table Data_Baru
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Data_Baru (
  id_data_baru INTEGER NOT NULL,
  status_data TEXT NULL CHECK(status_data IN ('Verifikasi', 'Menunggu', 'Tidak Diketahui')),
  tgl_data TEXT NOT NULL,
  id_admin TEXT NOT NULL,
  PRIMARY KEY (id_data_baru, id_admin),
  FOREIGN KEY (id_admin) REFERENCES Admin (id_admin) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- -----------------------------------------------------
-- Table Verifikasi_email
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Verifikasi_email (
  id_verifikasi INTEGER PRIMARY KEY AUTOINCREMENT,
  tgl_kirim TEXT NOT NULL,
  tgl_verifikasi TEXT,
  email TEXT NOT NULL,
  id_user TEXT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES User (id_user) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- -----------------------------------------------------
-- Table Komentar
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Komentar (
  id_komentar INTEGER NOT NULL,
  isi_komentar TEXT NULL,
  id_user TEXT NOT NULL,
  PRIMARY KEY (id_komentar, id_user),
  FOREIGN KEY (id_user) REFERENCES User (id_user) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- -----------------------------------------------------
-- Table Laporan
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Laporan (
  id_admin TEXT NOT NULL,
  id_sungai INTEGER NOT NULL,
  tgl_lapor TEXT NOT NULL,
  attachment BLOB NULL,
  PRIMARY KEY (id_admin, id_sungai),
  FOREIGN KEY (id_admin) REFERENCES Admin (id_admin) ON DELETE RESTRICT ON UPDATE RESTRICT,
  FOREIGN KEY (id_sungai) REFERENCES Sungai (id_sungai) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- -----------------------------------------------------
-- Triggers
-- -----------------------------------------------------

-- Trigger: User_AFTER_INSERT
CREATE TRIGGER User_AFTER_INSERT 
AFTER INSERT ON User
FOR EACH ROW
BEGIN
    INSERT INTO Verifikasi_email (tgl_kirim, tgl_verifikasi, email, id_user) 
    VALUES (datetime('now'), '', NEW.email, NEW.id_user);
END;

-- Trigger: Sungai_AFTER_INSERT
-- Note: SQLite requires a fallback value or handling for compound PKs like Laporan(id_admin). 
-- Added 'SYSTEM_AUTO' as a default placeholder string for the missing id_admin during creation.
CREATE TRIGGER Sungai_AFTER_INSERT 
AFTER INSERT ON Sungai
FOR EACH ROW
BEGIN
    INSERT INTO Laporan (id_admin, id_sungai, tgl_lapor, attachment)
    VALUES ('SYSTEM_AUTO', NEW.id_sungai, datetime('now'), NEW.gambar_sungai);
END;
