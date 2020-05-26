package by.barysau.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@Slf4j
@WebListener
public class FileLocationContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        log.info("Getting upload folder path...");
 //        String uploadPath = "uploadedimages" + File.separator;
        String uploadPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "webapp" + File.separator + "uploadedimages" + File.separator;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            log.info("Creating upload folder.");
            uploadDir.mkdir();
        }
        System.setProperty("uploadFolderPath", uploadPath);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
