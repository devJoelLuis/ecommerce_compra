package com.mscompra.compra.model;

import com.mscompra.compra.utils.CleanValues;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_pedido")
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 8426333489931208381L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @Min(1)
    private Long produto;
    @NotNull
    @Min(1)
    private BigDecimal valor;
    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate dataCompra;
    @NotBlank
    private String cpf;
    @NotBlank
    private String cep;

    public void setCpf(String cpf) {
        var cpfClean = CleanValues.cleanStringNumberOnly(cpf);
        if (cpfClean.length() < 11)
            throw new RuntimeException(String.format("O cpf do cliente possui apenas %s números.", cpfClean.length()));
        this.cpf = cpfClean;
    }

    public void setCep(String cep) {
        this.cep = CleanValues.cleanStringNumberOnly(cep);
    }
}
