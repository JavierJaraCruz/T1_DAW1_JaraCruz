package com.evaluacion.T1.model;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Trabajador {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String cargo;
    private Double salario;
    private String estado;
}
