package com.harman.harman.utils;

import com.harman.harman.model.VideoDetail;
import org.springframework.data.jpa.domain.Specification;

public class VideoSpacification {

    public static Specification<VideoDetail> title(String title) {
        return (root, query, builder) -> builder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<VideoDetail> derector(String director) {
        return (root, query, builder) -> builder.equal(root.get("director"), director);
    }


    public  static  Specification<VideoDetail> genre(String genre){
        return (root , query , builder) -> builder.equal(root.get("genre") , genre );
    }

    public  static  Specification<VideoDetail> castName(String castName){
        return (root , query , builder) -> builder.equal(root.get("castName") , castName );
    }

    public  static  Specification<VideoDetail> deListed(){
        return (root , query , builder) -> builder.equal(root.get("deListed") , Boolean.FALSE );
    }
}
