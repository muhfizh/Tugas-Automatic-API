# Tugas Gradle - Module 20

Proyek ini adalah Contoh Implementasi sederhana terkait proses testing automasi API menggunakan TestNG.


## Instalasi

Ikuti langkah-langkah berikut untuk menginstal proyek ini:

1. Clone repositori ini:
    ```bash
    git clone https://github.com/muhfizh/Tugas-Automatic-API.git
    ```
2. Pindah ke direktori proyek:
    ```bash
    cd Tugas-Automatic-API
    ```
3. Jalankan perintah Gradle untuk menginisialisasi proyek:
    ```bash
    gradle init --type java-library
    ```

## Penggunaan

Anda dapat menjalankan tugas khusus yang telah dibuat dengan perintah berikut:

1. buka Command promt
2. pindahkan directory ke folder tempat mengclone repository
3. jalankan perintah berikut :
    ```bash
    gradlew clean test
    ```
4. Akan muncul tampilan testing berjalan
   ```bash
    https://github.com/muhfizh/Tugas-Automatic-API/blob/main/screenshot%2021.png
    ```
5. jalankan perintah berikut :
    ```bash
    allure serve build\allure-results
    ```
6. Hasil jalankan report allure
    ```bash
    https://github.com/muhfizh/Tugas-Automatic-API/blob/main/screenshot%2022.png
    https://github.com/muhfizh/Tugas-Automatic-API/blob/main/screenshot%2023.png
    ```
