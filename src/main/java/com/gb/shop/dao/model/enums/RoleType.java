package com.gb.shop.dao.model.enums;

public enum RoleType {
    ADMIN("ADMIN"), USER("USER"), MANAGER("MANAGER");
    private String name;

    RoleType(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
