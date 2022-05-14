package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Model.WorkLog;
import com.grad.exchangesys.Services.UserService;
import com.grad.exchangesys.Services.impl.WorkLogserviceImpl;
import lombok.RequiredArgsConstructor;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/works")
public class WorksLogController {

    private final WorkLogserviceImpl workLogservice;
    private final UserService userService;

    @GetMapping(value = "/{username}")
    public List<WorkLog> getworks(@PathVariable String username) {
        return workLogservice.getAllWorks(username);

    }

    @PostMapping(value = "/add")
    public String addworks(HttpServletRequest request, @RequestBody WorkLog workLog,
                           @RequestParam("image") MultipartFile multipartFile, @RequestParam("video") MultipartFile multipartFile1) throws IOException {

        String fileNameImage = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String fileNameVideo = StringUtils.cleanPath(multipartFile1.getOriginalFilename());

        User user = userService.getUser(request);

        String uploadDirImag = "user-photos/" + user.getId();
        String uploadDirVid = "user-videos/" + user.getId();

        Path uploadPathImag = Paths.get(uploadDirImag);
        Path uploadPathVid = Paths.get(uploadDirVid);

        if (!Files.exists(uploadPathImag)) {
            Files.createDirectories(uploadPathImag);
        } if (!Files.exists(uploadPathVid)) {
            Files.createDirectories(uploadPathVid);
        }
        Path filePathImag;
        try (InputStream inputStream = multipartFile.getInputStream()) {
            filePathImag = uploadPathImag.resolve(fileNameImage);
            Files.copy(inputStream, filePathImag, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not upload image file: " + fileNameImage, ioe);
        }
        File file = new File(fileNameVideo);
        FileInputStream fr = null;
        FileOutputStream fw = null;

        byte a[] = new byte[(int) file.length()];

        try {
            fr = new FileInputStream(file);
            fw = new FileOutputStream(uploadDirVid);

            fr.read(a);
            fw.write(a);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        workLog.setImagePath(uploadDirImag);
        workLog.setVideoPath(uploadDirVid);
        workLogservice.addWork(workLog);

        return"works";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteWork(@PathVariable Long id , HttpServletRequest request){
        User myuser= userService.getUser(request);
        workLogservice.removeWork(myuser.getId());

        return "works";

    }

}
