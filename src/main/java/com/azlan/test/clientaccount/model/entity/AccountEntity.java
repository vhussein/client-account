package com.azlan.test.clientaccount.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "CLIENT_ID")
    private long clientId;
}
