package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.Comments;

import java.util.List;

public interface CommentsServices {

    List<Comments> get_all_comment(Long order_id);
    void delete_comment(Long comment_id);
    Comments edit_comment(Comments comment);
    Comments add_comment(Comments comments,Long order_id);

}
