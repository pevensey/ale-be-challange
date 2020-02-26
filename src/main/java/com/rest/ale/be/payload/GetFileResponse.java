package com.rest.ale.be.payload;

/*
 Bean untuk get data dari DBFile. Berbeda dari DBFile yang digunakan sebagai POST, GetFileResponse untuk GET data
 */
public class GetFileResponse {
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

    //constructor nya berbeda dengan DBFile(String fileName, String fileType, byte[] data).
    //Hasil yang diharapkan dari constructcor ini adalah (id, fileName, fileType)
    public GetFileResponse(String id, String fileName, String fileType) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
    }
}
