package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.Comments;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.CommentsServices;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsServices commentsServices;
    private final UserService userService;

    @GetMapping("/{order_id}")
    public List<Comments> all_comments(@PathVariable  Long order_id){
//        System.out.println(" comments   :  ");
        return commentsServices.get_all_comment(order_id);
    }

    @PostMapping("/add")
    public Comments add_comment(@RequestBody Comments comment, @RequestBody  Long order_id, HttpServletRequest request){
        User user  = userService.getUser(request);
        comment.setUser(user);
       return commentsServices.add_comment(comment,order_id);
    }

    @GetMapping("/delete/{id}")
    public void delete_comment(@PathVariable Long id){
        commentsServices.delete_comment(id);
    }
    @PostMapping("/edit")
    public Comments update_comment(@RequestBody Comments comment, @RequestBody  Long order_id, HttpServletRequest request){
        User user  = userService.getUser(request);
        comment.setUser(user);
        return commentsServices.edit_comment(comment);
    }

}
