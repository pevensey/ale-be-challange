package com.rest.ale.be.model;

public class GetFile {
    private String id;

    private String fileName;

    private String fileType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public GetFile(String id, String fileName, String fileType) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
    }
}
