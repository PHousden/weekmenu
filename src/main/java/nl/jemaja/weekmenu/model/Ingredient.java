package nl.jemaja.weekmenu.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long ingredientId;
	private String name;
	private UOM uom;
	

}
