package com.xsis.xsis.dto;

/**
 * EmployeeDto
 */
public class EmployeeDto {

    private Long id;
    private Long biodataId;
    private boolean isIdle;
    private boolean isEro;
    private boolean isUserClient;
    private String eroEmail;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, Long biodataId, boolean isIdle, boolean isEro, boolean isUserClient, String eroEmail) {
        this.id = id;
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean isIdle) {
        this.isIdle = isIdle;
    }

    public boolean isEro() {
        return isEro;
    }

    public void setEro(boolean isEro) {
        this.isEro = isEro;
    }

    public boolean isUserClient() {
        return isUserClient;
    }

    public void setUserClient(boolean isUserClient) {
        this.isUserClient = isUserClient;
    }

    public String getEroEmail() {
        return eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }

}