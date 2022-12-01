package br.com.cachorro.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "cachorro")
@AllArgsConstructor
@NoArgsConstructor
public class CachorroModel extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    @ApiModelProperty(notes = "The ID")
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    @Setter
    @Getter
    @ApiModelProperty(notes = "The dog full name")
    private String name;

    //..new attributes of V2
    @Column(nullable = true, length = 100)
    @Getter
    @Setter
    @ApiModelProperty(notes = "A valid color")
    private String cor;

    //..relationship with ProfessionModel
    @ManyToOne
    @JoinColumn(name = "raca_id")
    @Setter
    @Getter
    private RacaModel raca;
}
