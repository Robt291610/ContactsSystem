package tp.contactssystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.contactssystem.model.Contact;
import tp.contactssystem.repository.IContactRepository;

import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactRepository contactRepository;

    @Override
    public List<Contact> listContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }
}
