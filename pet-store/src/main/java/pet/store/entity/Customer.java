package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long customerId;
	public String customerFirstName;
	public String customerLastName;
	public String customerEmail;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores = new HashSet<>();

//	"customers" maps this page which uses customers and PetStores together
	// understand recursive relationships and links together!!!!!

}
