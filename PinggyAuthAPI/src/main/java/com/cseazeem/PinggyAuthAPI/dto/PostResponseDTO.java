package com.cseazeem.PinggyAuthAPI.dto;

public class PostResponseDTO {
    private String title;
    private String body;
    private String pinggyAuthHeader;

    public PostResponseDTO(String title, String body, String pinggyAuthHeader) {
        this.title = title;
        this.body = body;
        this.pinggyAuthHeader = pinggyAuthHeader;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPinggyAuthHeader() {
        return pinggyAuthHeader;
    }

    public void setPinggyAuthHeader(String pinggyAuthHeader) {
        this.pinggyAuthHeader = pinggyAuthHeader;
    }
}
