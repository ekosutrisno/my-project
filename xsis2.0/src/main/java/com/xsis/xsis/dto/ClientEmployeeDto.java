package com.xsis.xsis.dto.vacancy_pendidikan_resourceproject;

/**
 * ClientEmployeeDto
 */
public class ClientEmployeeDto {

    private Long id;
    private String name;
    private String userClientName;
    private Long ero;
    private String userEmail;

    public ClientEmployeeDto() {
    }

    public ClientEmployeeDto(Long id, String name, String userClientName, Long ero, String userEmail) {
        this.id = id;
        this.name = name;
        this.userClientName = userClientName;
        this.ero = ero;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserClientName() {
        return this.userClientName;
    }

    public void setUserClientName(String userClientName) {
        this.userClientName = userClientName;
    }

    public Long getEro() {
        return this.ero;
    }

    public void setEro(Long ero) {
        this.ero = ero;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}