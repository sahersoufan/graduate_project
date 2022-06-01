package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Comments;
import com.grad.exchangesys.Repository.CommentsRepo;
import com.grad.exchangesys.Repository.OrdersRepo;
import com.grad.exchangesys.Services.CommentsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsServicesImpl implements CommentsServices {

        private final CommentsRepo commentsRepo;
        private final OrdersRepo ordersRepo;


    @Override
    public List<Comments> get_all_comment(Long order_id) {
        List<Comments> comments = new ArrayList<>();
        for ( Comments c : commentsRepo.findAll()){
            if(c.getOrder().getId()== order_id){

                comments.add(c);
            }
        }
        return comments;
    }

    @Override
    public void delete_comment(Long comment_id) {
         commentsRepo.delete(commentsRepo.getById(comment_id));
    }

    @Override
    public Comments edit_comment(Comments comment ) {
            return commentsRepo.save(comment);
    }

    @Override
    public Comments add_comment(Comments comments,Long order_id) {
        comments.setOrder(ordersRepo.getById(order_id));
        return commentsRepo.save(comments);
    }
}
