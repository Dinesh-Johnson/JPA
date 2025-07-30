package com.xworkz.shop.voter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "voter_candidates")
public class VoterCandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private int id;

    @Column(name = "candidate_name")
    private String name;

    @Column(name = "party_name")
    private String party;

    @Column(name = "constituency")
    private String constituency;

    @Column(name = "age")
    private int age;
}
