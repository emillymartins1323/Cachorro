package br.com.cachorro.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "raca")
@AllArgsConstructor
@NoArgsConstructor

public class RacaModel extends RepresentationModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    @ApiModelProperty(notes = "The ID")
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    @Setter @Getter
    @ApiModelProperty(notes = "The raca name")
    private String name;
}

