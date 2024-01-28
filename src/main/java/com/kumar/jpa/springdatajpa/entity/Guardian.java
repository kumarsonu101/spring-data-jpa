package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
    @AttributeOverride(
        name = "name",
        column = @Column(name = "guardian_name")
    ),
    @AttributeOverride(
        name = "email",
        column = @Column(name = "guardian_email")
    ),
    @AttributeOverride(
        name = "mobile",
        column = @Column(name = "guardian_mobile")
    )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;

    public Guardian() {
    }

    public Guardian(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Guardian guardian = new Guardian();

        private Builder() {

        }

        public Builder name(String name) {
            guardian.name = name;
            return this;
        }

        public Builder email(String email) {
            guardian.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            guardian.mobile = mobile;
            return this;
        }

        // Add more builder methods for other fields...

        public Guardian build() {
            // Validate if necessary and return the built User object
            return guardian;
        }
    }
    

}
