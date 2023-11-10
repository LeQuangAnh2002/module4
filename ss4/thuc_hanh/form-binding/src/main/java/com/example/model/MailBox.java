package com.example.model;

public class MailBox {
    private String id;
    private String languages;
    private String pageSize;
    private String filter;
    private String signature;

    public MailBox() {
    }

    public MailBox(String id, String languages, String pageSize, String filter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
