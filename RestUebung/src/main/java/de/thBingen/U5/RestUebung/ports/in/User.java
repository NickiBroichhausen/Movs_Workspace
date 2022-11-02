package de.thBingen.U5.RestUebung.ports.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class User {

    int id;
    String name;
    String surname;
}