package com.project.demo.sushiCo.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.project.demo.sushiCo.domain.exception.StorageException;
import com.project.demo.sushiCo.domain.exception.StorageFileNotFoundException;

import jakarta.annotation.Resource;

public interface StorageService {
	void init();

	void store(MultipartFile file, String filename) throws StorageException;

	Stream<Path> loadAll() throws StorageException;

	Path load(String filename);

	Resource loadAsResource(String filename) throws StorageFileNotFoundException;

	void deleteAll();

}

