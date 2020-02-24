package mob;

import java.util.ArrayList;

public class Contacts {
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String emailAddress;
    public Contacts(String firstName , String lastName, Integer phoneNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public static Contacts createContact(String firstName, String lastName, String emailAddress, Integer phoneNumber  ){
        return new Contacts(firstName,lastName , phoneNumber , emailAddress);
    }

    ArrayList<String> contactlist = new ArrayList<String>();

    public ArrayList<String> getContactlist(){
        return contactlist;
    }

    public void storeContacts(String names){
        contactlist.add(firstName);
    }

    public void printContactList(){
        System.out.println("You have" + contactlist.size() + "Contacts in your list.");
        for(int i =0; i < contactlist.size(); i++ ){
            System.out.println(i + " - " + contactlist.get(i));
        }
    }
}
