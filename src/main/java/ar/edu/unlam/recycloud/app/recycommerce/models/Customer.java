package ar.edu.unlam.recycloud.app.recycommerce.models;

import lombok.Data;

@Data
public class Customer {
    private int customerGroupId = 1;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone = "";
    private String password;
    private int newsLetter = 0;
    private int status = 1;
    private int safe = 0;
}
