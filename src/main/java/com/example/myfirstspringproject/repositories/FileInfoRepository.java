package com.example.myfirstspringproject.repositories;


import com.example.myfirstspringproject.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findOneByStorageFileName(String storageFileName);
}

