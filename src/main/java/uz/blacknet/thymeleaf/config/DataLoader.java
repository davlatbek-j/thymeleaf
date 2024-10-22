package uz.blacknet.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataLoader implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    @Value("${photo.upload.path}")
    private String uploadPath;

    @Override
    public void run(String... args) throws Exception
    {
        createPhotoPath();
    }

    private void createPhotoPath()
    {
        File directory = new File(uploadPath);
        log.info("directory.exists() = " + directory.exists());
        if (!directory.exists())
        {
            if (directory.mkdirs())
                log.info("Directory Created with path : {}", directory.getAbsolutePath());
        }
    }
}
