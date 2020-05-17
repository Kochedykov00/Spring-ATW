package com.example.myfirstspringproject.util;

import com.example.myfirstspringproject.models.FileInfo;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 01.12.2017
 * FileStorageUtil
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class FileStorageUtil {

    @Value("C:\\files")
    private String storagePath;

    public String getStoragePath() {
        return storagePath;
    }

    // сохраняет файл на диск
    @SneakyThrows
    public void copyToStorage(MultipartFile file, String storageFileName) {
        Files.copy(file.getInputStream(), Paths.get(storagePath, storageFileName));
    }

    // принимает на вход файл в формате Multipart
    // сохраняет его в БД
    public FileInfo convertFromMultipart(MultipartFile file) {
        // получаем название файла
        String originalFileName = file.getOriginalFilename();
        // вытаскиваем контент-тайп (MIME)
        String type = file.getContentType();
        // размер файла
        long size = file.getSize();
        // создаем имя файла
        String storageName = createStorageName(originalFileName);
        // получаем url файла по которому он будет доступен внутри системы
        String fileUrl = getUrlOfFile(storageName);
        return FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(storageName)
                .url(fileUrl)
                .size(size)
                .type(type)
                .build();
    }

    public String save(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String storageName = createStorageName(originalFileName);
        copyToStorage(file, storageName);
        return getUrlOfFile(storageName);
    }

    private String getUrlOfFile(String storageFileName) {
        // путь к папке с файлами на диске + название файла
        return storagePath + "/" + storageFileName;
    }

    // создает уникальное имя файла на диске с его расширением
    private String createStorageName(String originalFileName) {
        // получаем расширение файла по его имени
        String extension = FilenameUtils.getExtension(originalFileName);
        // генерируем случайную строку
        String newFileName = UUID.randomUUID().toString();
        // новое имя файла - UUID + . + расширение файла
        return newFileName + "." + extension;
    }
}

