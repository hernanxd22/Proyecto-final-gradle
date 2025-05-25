package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Base  {
    private String auth0id;
    private String username;
}
