package com.example.blog.services;

public interface GlobaleService<Dto, Id> {

    public Dto add(Dto Element);
    public Dto update(Id id, Dto elementBody);
    public Dto findById(Id id);
    public Dto delete(Id id);

}
