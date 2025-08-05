package com.tsinjo.app.model.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class User {
    private final String id;
    private final String email;
    private String name;
}
