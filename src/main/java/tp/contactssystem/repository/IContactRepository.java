package tp.contactssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.contactssystem.model.Contact;

public interface IContactRepository extends JpaRepository<Contact, Integer> {
}
