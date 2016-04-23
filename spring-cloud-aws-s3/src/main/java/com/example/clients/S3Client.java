package com.example.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;
import java.util.UUID;

public class S3Client {

    private static final Logger LOGGER = LogManager.getLogger();

    private String s3Bucket;
    private ResourceLoader resourceLoader;

    @Autowired
    public S3Client(@Value("${upload.s3.bucket}") String s3Bucket, ResourceLoader resourceLoader) {
        this.s3Bucket = s3Bucket;
        this.resourceLoader = resourceLoader;
    }

    /**
     * Upload a file to S3 bucket
     * @param content
     */
    public void upload(final String content) {
        try {
            Resource resource = resourceLoader.getResource(s3Bucket + "/" + UUID.randomUUID().toString() + ".log");
            if (Optional.ofNullable(resource).isPresent()) {
                WritableResource writableResource = (WritableResource) resource;
                try (OutputStream outputStream = writableResource.getOutputStream()) {
                    outputStream.write(content.getBytes());
                }
            } else {
                throw new IOException("Unable to retrieve s3 bucket resource");
            }
        } catch (IOException ex) {
            LOGGER.info("Error when uploading content: " + content);
            LOGGER.error(ex.getMessage(), ex);
        }
    }

}
