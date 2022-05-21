package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.*;
import com.grad.exchangesys.Services.UserService;
import com.grad.exchangesys.Services.WorkImageServices;
import com.grad.exchangesys.Services.WorkLogService;
import com.grad.exchangesys.Services.impl.WorkLogserviceImpl;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/work")
public class WorksLogController {

    private final WorkLogService workLogservice;
    private final UserService userService;
    private final WorkImageServices workImageServices;


    @GetMapping(value = "/all")
    public List<Object> getworks(HttpServletRequest request) {
        List<Object> list=new ArrayList<>();
        User user=userService.getUser(request);
        List<WorkLog> workLogs=workLogservice.getAllWorks(user.getId());
        list.add(workLogs);
        for(int i=0;i<workLogs.size();i++){
            list.add(workImageServices.getworkimage(workLogs.get(i).getId()));

        }

        return list;

    }
    @GetMapping(value = "/allimage/{id}")
    public List<WorkImage> getimage(@PathVariable Long id) {

        return workImageServices.getworkimage(id);

    }
    @GetMapping(value = "/activity")
    public List<Object> activity(HttpServletRequest request) {
        List<Object> list=new ArrayList<>();
        User user=userService.getUser(request);
        List <ActivityWork> actvity=workLogservice.getActivity(user);
        for(int i=0;i<actvity.size();i++){
            list.add(actvity.get(i));
         // list.add(workLogservice.getWork(actvity.get(i).getId_work()));

        }

        return list;

    }


    @PostMapping(value = "/add")
    public Long addwork(HttpServletRequest request, @RequestBody WorkLog workLog) throws IOException {

        User user=userService.getUser(request);
        workLog.setUser(user);
         WorkLog workLog1= workLogservice.addWork(workLog);
        ActivityWork activityWork=new ActivityWork();
        activityWork.setName("add");
        activityWork.setId_work(workLog1.getId());
        activityWork.setTitle(workLog1.getName());
        activityWork.setUser(user);
        workLogservice.saveActivity(activityWork);
        return workLog1.getId();
    }


    @PostMapping(value = "/addimage/{id}")
    public Boolean addimagework(HttpServletRequest request,@RequestParam("files")MultipartFile[] multipartFile,@PathVariable Long id) throws IOException {

            for(int i=0;i<multipartFile.length;i++){

                WorkImage workImage=new WorkImage();
                String fileName = StringUtils.cleanPath(multipartFile[i].getOriginalFilename());
                User user=userService.getUser(request);
                String uploadDir = "user-photos/work/" + user.getId();
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath;
                try (InputStream inputStream = multipartFile[i].getInputStream()) {

                    filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    workImage.setImagePath(filePath.toString());
                    workImage.setWorkLog(workLogservice.getWork(id));

                    workImageServices.SaveImage(workImage);
                } catch (IOException ioe) {
                    throw new IOException("Could not save image file: " + fileName, ioe);
                }

            }
        List<WorkImage> workImages=workImageServices.getworkimage(id);
       // workLogservice.getWork(id).setImage(workImages);
        return true;
    }


    @PostMapping(value = "/updateimage/{id}")
    public Boolean updateimagework(HttpServletRequest request,@RequestParam("files")MultipartFile[] multipartFile,@PathVariable Long id) throws IOException {


        List<WorkImage> workImagess= workImageServices.getworkimage(id);
        for (int i=0;i<workImagess.size();i++){
            workImageServices.delete(workImagess.get(i));

        }
        for(int i=0;i<multipartFile.length;i++){

            WorkImage workImage=new WorkImage();
            String fileName = StringUtils.cleanPath(multipartFile[i].getOriginalFilename());
            User user=userService.getUser(request);
            String uploadDir = "user-photos/work/" + user.getId();
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath;
            try (InputStream inputStream = multipartFile[i].getInputStream()) {

                filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                workImage.setImagePath(filePath.toString());
                workImage.setWorkLog(workLogservice.getWork(id));

                workImageServices.SaveImage(workImage);
            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }

        }
        List<WorkImage> workImages=workImageServices.getworkimage(id);
       // workLogservice.getWork(id).setImage(workImages);
        return true;
    }


    @PutMapping("/update")
    public boolean updateWork( @RequestBody WorkLog workLog,HttpServletRequest request){
        User user=userService.getUser(request);
      workLogservice.update(workLog);
      ActivityWork activityWork=new ActivityWork();
        activityWork.setName("edit");
        activityWork.setId_work(workLog.getId());
        activityWork.setTitle(workLog.getName());
        activityWork.setUser(user);
        workLogservice.saveActivity(activityWork);
        return true;

    }
    @DeleteMapping("delete/{id}")
    public void deleteWork(@PathVariable Long id ){
        List<WorkImage> workImagess= workImageServices.getworkimage(id);

        for (WorkImage imagess : workImagess) {
            workImageServices.delete(imagess);

        }
        WorkLog workLog=workLogservice.getWork(id);
        List<ActivityWork> activityWork=new ArrayList<>();
        activityWork= workLogservice.getactivitybyidwork(workLog.getId());
       for (int i=0;i<activityWork.size();i++) {
           if (activityWork.get(i).getId() != null) {
               workLogservice.deleteactivity(activityWork.get(i));

           }
       }
        workLogservice.delete(workLog);
    }

}
