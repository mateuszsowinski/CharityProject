package pl.sowinski.charity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;


//    - id
//- quantity (liczba worków) (Integer)
//- categories (lista obiektów typu `Category`), pamiętaj o odpowiedniej adnotacji
//- institution (obiekt typu `Institution`), pamiętaj o odpowiedniej adnotacji.
//- street (String)
//- city (String)
//- zipCode (String)
//- pickUpDate (LocalDate)
//- pickUpTime (LocalTime)
//- pickUpComment (String)
//
//
}
