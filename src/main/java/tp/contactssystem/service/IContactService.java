package tp.contactssystem.service;

import tp.contactssystem.model.Contact;

import java.util.List;

public interface IContactService {
    public List<Contact> listContacts();
    public Contact getContactById(Integer id);
    public void saveContact(Contact contact);
    public void deleteContactById(Integer id);
}
