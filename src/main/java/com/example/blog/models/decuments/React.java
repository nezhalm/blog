package com.example.blog.models.decuments;

import com.example.blog.MediaType;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class React  {

    @Id
    protected Long id;
    protected User reactor;
    protected MediaType type;

}
