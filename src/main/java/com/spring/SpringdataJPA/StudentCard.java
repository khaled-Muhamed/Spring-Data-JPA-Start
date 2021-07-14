package com.spring.SpringdataJPA;

import javax.persistence.*;

@Entity
@Table(name = "student_id_card")
public class StudentCard {

    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "card_number",nullable = false,columnDefinition = "TEXT",length = 15)
    private String cardNumber;


    public StudentCard() {
    }

    public StudentCard(Long student_id, String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "student_id_fk"))
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String ccardNumber) {
        this.cardNumber = ccardNumber;
    }
}
