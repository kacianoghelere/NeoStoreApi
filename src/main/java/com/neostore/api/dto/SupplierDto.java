package com.neostore.api.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author kaciano
 */
public class SupplierDto {

    @NotBlank(message = "Nome não pode ser nulo")
    private String name;

    private String description;

    @NotBlank(message = "E-mail não pode ser nulo")
    private String email;

    @NotBlank(message = "CNPJ não pode ser nulo")
    @CNPJ(message = "Informe um cnpj válido")
    private String cnpj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
