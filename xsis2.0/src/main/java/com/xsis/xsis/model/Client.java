package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.dto.ClientEmployeeDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "clientMapping", classes = {
        @ConstructorResult(targetClass = ClientEmployeeDto.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "user_client_name", type = String.class),
                @ColumnResult(name = "ero", type = Long.class),
                @ColumnResult(name = "user_email", type = String.class) }) })

// List Client Join Employee
@NamedNativeQuery(name = "Client.getClientSelectOption", query = "select a.id,a.name,a.user_client_name,a.ero,a.user_email from x_client a "
        + "join x_employee c on c.id=a.ero where a.isdelete=false and c.isdelete=false", resultSetMapping = "clientMapping")

/**
 * Client
 */
@Entity
@Table(name = "x_client")
public class Client extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_client_name")
    private String userClientName;

    @Column(name = "ero")
    private Long ero;

    @Column(name = "user_email")
    private String userEmail;

    public Client() {
    }

    public Client(Long id, String name, String userClientName, Long ero, String userEmail) {
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