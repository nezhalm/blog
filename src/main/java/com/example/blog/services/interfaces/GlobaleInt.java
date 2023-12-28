package com.example.blog.services.interfaces;

public interface GlobaleInt<T, Id> {

    public T add(T Element);
    public T update(Id id, T elementBody);
    public T findById(Id id);
    public T delete(Id id);

}
