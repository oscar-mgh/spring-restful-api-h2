package com.amigoscode.springboot.sbcourse.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Customer")
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
class Customer {
    @Id
    private Long id;

    @NotBlank(message = "name must not be empty")
    private String name;

    @NotBlank(message = "password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    //    @Email(regexp = "([\\w\\.\\-_]+)?\\w+@[\\w-_]+(\\.\\w+){2,}")
    @NotBlank(message = "email must not be empty")
    @Size(
            min = 12,
            max = 60
    )
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
