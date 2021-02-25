package com.iot.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "vending_machine")
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "vendingMachine", cascade = {CascadeType.ALL})
    private List<MoneyCollection> moneyCollections;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
