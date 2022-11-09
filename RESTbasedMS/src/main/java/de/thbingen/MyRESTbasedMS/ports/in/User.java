package de.thbingen.MyRESTbasedMS.ports.in;

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

  Long id;
  String name;
}
