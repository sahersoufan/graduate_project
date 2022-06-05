package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.FriendRequest;
import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.FriendRequestServices;
import com.grad.exchangesys.Services.FriendsService;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final FriendRequestServices friendRequestServices;
    private final FriendsService friendsService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String signup() {
        return " and VueJS!";
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @GetMapping("/islog")
    public String islog() {
     return "islog";

    }
    @PostMapping("/getuser")
    public ResponseEntity<User> getuser(@RequestBody User user1,HttpServletRequest request){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/getuser").toUriString());

        User user=userService.getUser(request);
        return ResponseEntity.created(uri).body(user);
    }
    @PostMapping("/all")
    public ResponseEntity<  List <Map<String, String> >>all(HttpServletRequest request){
        User user=userService.getUser(request);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/all").toUriString());

        List <User> users=userService.getusernotfriend(user.getUsername());
        List<FriendsList> friendsLists=friendsService.getFrinends(user.getId());
        List<FriendRequest> friendRequests=friendRequestServices.AllFriendRequest(user.getId());
        List<FriendRequest> friendRequestList=friendRequestServices.allrequesttouser(user.getId());
        List <Map<String, String> >mapList = new ArrayList<>();
        for (FriendRequest friendRequest : friendRequests) {


            if (users.contains(friendRequest.getUser())) {
                users.remove(friendRequest.getUser());
            }


        }
        for (int i=0;i<friendRequestList.size();i++){
            User user1=userService.getUser(friendRequestList.get(i).getUser_id());

            if(users.contains(user1)){
                users.remove(user1);
            }


        }
        for (int i=0;i<friendsLists.size();i++){
            User user1=userService.getUser(friendsLists.get(i).getUser_id());

            if(users.contains(user1)){
                users.remove(user1);
            }


        }
        for (int i=0;i<users.size();i++){
            Map<String,String> map=new HashMap<>();

            map.put("id", users.get(i).getId().toString());
            map.put("imagepath", users.get(i).getImagepath());
            map.put("firstname", users.get(i).getFirstname());
            map.put("lastname", users.get(i).getLastname());
            map.put("description", users.get(i).getDescription());
            mapList.add(map);
        }

        return ResponseEntity.created(uri).body(mapList);
    }

    @PostMapping("/user/update")
    public Boolean update(@RequestBody User user, HttpServletRequest request){

        User user1=userService.getUser(request);
       if(user.getUsername()!=null){
           user1.setUsername(user.getUsername());
       }
        if(user.getFirstname()!=null){
            user1.setFirstname(user.getFirstname());
        }
        if(user.getLastname()!=null){
            user1.setLastname(user.getLastname());
        }
        if(user.getGender()!=null){
            user1.setGender(user.getGender());
        }
        if(user.getPhone()!=null){
            user1.setPhone(user.getPhone());
        }
        if(user.getDescription()!=null){
            user1.setDescription(user.getDescription());
        }
        userService.UpdateUser(user1);
        return true;
    }
    @PostMapping("/user/changepass")
    public Boolean changepass( HttpServletRequest request,@RequestBody Map<String, String> payload) throws IOException {
        User user=userService.getUser(request);

        if(passwordEncoder.matches(payload.get("old"), user.getPassword())){

            user.setPassword(passwordEncoder.encode(payload.get("new")));
            userService.UpdateUser(user);
            return true;


        }

        return false;

    }

    @PostMapping("/uploadimage")
    public String uploadimage( HttpServletRequest request,@RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        User user=userService.getUser(request);
        String uploadDir = "user-photos/" + user.getId();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath;
        try (InputStream inputStream = multipartFile.getInputStream()) {
             filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            user.setImagepath(filePath.toString());
            userService.UpdateUser(user);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return filePath.toString();
    }


    @PostMapping("/uploadprofile")
    public String uploadprofile( HttpServletRequest request,@RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        User user=userService.getUser(request);
        String uploadDir = "user-profile/" + user.getId();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath;
        try (InputStream inputStream = multipartFile.getInputStream()) {
            filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            user.setProfilepath(filePath.toString());
            userService.UpdateUser(user);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return filePath.toString();
    }

}
