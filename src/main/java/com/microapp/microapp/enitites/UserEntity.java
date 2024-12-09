package com.microapp.microapp.enitites;

import com.microapp.microapp.converter.BooleanToIntegerConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "users")
public class UserEntity {
        @Id
        private int userId;

        @Column(name = "username", nullable = false)
        private String username;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "phone", nullable = false)
        private String phone;

        @Column(name = "sports", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean sports;

        @Column(name = "theatre", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean theatre;

        @Column(name = "concerts", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean concerts;

        @Column(name = "jazz", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean jazz;

        @Column(name = "classical", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean classical;

        @Column(name = "opera", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean opera;

        @Column(name = "rock", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean rock;

        @Column(name = "vegas", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean vegas;

        @Column(name = "broadway", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean broadway;

        @Column(name = "musicals", nullable = false)
        @Convert(converter = BooleanToIntegerConverter.class)
        private boolean musicals;

}


