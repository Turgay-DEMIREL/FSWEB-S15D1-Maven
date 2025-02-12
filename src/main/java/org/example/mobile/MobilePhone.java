package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts){
        this.myContacts = myContacts;
        this.myNumber = myNumber;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){
        boolean returnValue = false;
        if (!myContacts.contains(contact))
            returnValue = myContacts.add(contact);

        return returnValue;
    }

    public boolean updateContact(Contact contact, Contact contactToUpdate){
    boolean returnValue = false;

    if (myContacts.contains(contact)){
     Contact replaceContact = myContacts.set(myContacts.indexOf(contact),contactToUpdate);
     returnValue = replaceContact.equals(contact);
    }

    return returnValue;
    }

    public boolean removeContact(Contact contact){
        boolean returnValue  =false;
        if (myContacts.contains(contact))
            returnValue = myContacts.remove(contact);
        return returnValue;
    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    public int findContact(String name){
        int returnValue = -1;
        for (Contact contact : myContacts){
            if (contact.getName().equals(name)){
                returnValue = findContact(contact);
            }
        }
        return returnValue;
    }
    public Contact queryContact(String name){
        Contact returnValue = null;
        for (Contact contact:myContacts){
            if (contact.getName().equals(name)){
                returnValue = contact;
                break;
            }
        }
        return returnValue;
    }

    public void printContact(){
        for (int i = 0; i<myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(i + ", " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
