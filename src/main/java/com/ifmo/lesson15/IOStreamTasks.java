package com.ifmo.lesson15;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Реализуйте все методы с использованием потоков ввода-вывода.
 */
public class IOStreamTasks {
    public static void main(String[] args) throws IOException {
        File encrypt = new File("src/main/resources/lesson15/encrypt.txt");
        File location = new File("src/main/resources/lesson15/dst.txt");
        File decrypt = new File("src/main/resources/lesson15/decrypt.txt");
        File src = new File("src/main/resources/lesson15/test.txt");
        File pass = new File("src/main/resources/lesson15/password.txt");

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(location)) {
            copy(in, out);
        }

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(encrypt)){
            encrypt(in, out, "password");
        }

        try (InputStream in = new FileInputStream(encrypt);
             OutputStream out = new FileOutputStream(decrypt)){
            encrypt(in, out, "password");
        }

        encrypt(src, encrypt, pass);
        encrypt(encrypt, decrypt, pass);

        List<File> spliter= split(src, new File("src/main/resources/lesson15"), 1000000);
        File dist = new File("src/main/resources/lesson15/assembly.txt");
        assembly(spliter, dist);
    }

    /**
     * Полностью копирует один поток в другой.
     *
     * @param src Входящий поток.
     * @param dst Выходящий поток.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void copy(InputStream src, OutputStream dst) throws IOException {
        byte[] buffer = new byte[1000000];
        int len;
        try {
            while ((len = src.read(buffer)) > 0) {
                dst.write(buffer, 0, len);
            }
        } finally {
            dst.flush();
        }
    }

    /**
     * Последовательно разбивает файл на несколько более мелких, равных
     * указанному размеру. Последний файл может быть меньше задданого
     * размера.
     *
     * @param file Файл, который будет разбит на несколько.
     * @param dstDir Директория, в которой будут созданы файлы меньшего размера.
     * @param size Размер каждого файла-части, который будет создан.
     * @return Список файлов-частей в том порядке, в котором они должны считываться.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static List<File> split(File file, File dstDir, int size) throws IOException {
        List<File> listOfFiles = new ArrayList<>();
        byte[] buffer = new byte[size];
        try (InputStream in = new FileInputStream(file)) {
            for (int i = 1; ; i++) {
                int len;
                if ((len = in.read(buffer)) < 0) break;
                File outFile = new File(dstDir.getAbsolutePath() + "/" + file.getName() + "_" + i);
                listOfFiles.add(outFile);
                try (OutputStream out = new FileOutputStream(outFile)) {
                    out.write(buffer, 0, len);
                }
            }
        }
        return listOfFiles;
    }

    /**
     * Собирает из частей один файл.
     *
     * @param files Список файлов в порядке чтения.
     * @param dst Файл, в который будут записаны все части.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void assembly(List<File> files, File dst) throws IOException {
        byte[] buf = new byte[1024];
        try (OutputStream out = new FileOutputStream(dst)) {
            for (File file : files) {
                try (InputStream in = new FileInputStream(file)) {
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                }
            }
        }
    }

    /**
     * Шифрует/дешифрует поток с помощью XOR. В качестве ключа используется пароль.
     *
     * @param src Входящий поток, данные которого будут зашифрованы/расшифрованы.
     * @param dst Выходящий поток, куда будут записаны зашифрованные/расшифрованные данные.
     * @param passphrase Пароль.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(InputStream src, OutputStream dst, String passphrase) throws IOException {
        byte[] pass = passphrase.getBytes();
        byte[] srcBytes = src.readAllBytes();

        for (int i = 0, j = 0; i < srcBytes.length; i++) {
            srcBytes[i] ^= pass[j];
            j = ++j < pass.length ? j : 0;
        }
        dst.write(srcBytes);
    }



    /**
     * Шифрует/дешифрует файл с помощью файла-ключа.
     *
     * @param src Файл, который должен быть зашифрован/расшифрован.
     * @param dst Файл, куда будут записаны зашифрованные/расшифрованные данные.
     * @param key Файл-ключ.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(File src, File dst, File key) throws IOException {
        try(InputStream in = new BufferedInputStream(new FileInputStream(src));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(dst));
            InputStream fileKey = new FileInputStream(key)) {

            String pass = Arrays.toString(fileKey.readAllBytes());
            encrypt(in, out, pass);
        }
    }
}