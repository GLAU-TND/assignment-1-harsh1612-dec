package mob;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;
    private LinkedList<Integer> object = new LinkedList<Integer>();
    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
        this.object = new LinkedList<Integer>();
    }
    private  static Scanner scanner = new Scanner(System.in);

    //Adding a new Contact
    public boolean addNewContact(Contacts contact){

        //Before adding a contact we check if the contact exists or not
        if(findContact(contact.getFirstName())>=0){
            System.out.println("Contact is already in the list");
        }

        myContacts.add(contact);
        return true;

    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPostion = findContact(oldContact);
        if(foundPostion < 0){
            System.out.println(oldContact.getFirstName() + " "+ oldContact.getLastName() + "was not found");
            return false;
        }
        else{
            this.myContacts.set(foundPostion, newContact);
            System.out.println(oldContact.getFirstName() + " " + oldContact.getLastName() + " was replaced with " + newContact.getFirstName() + " " + newContact.getLastName());
            return true;
        }
    }

    public boolean removeContact(Contacts contact){
        int foundPostion = findContact(contact);
        if(foundPostion < 0){
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " was not found.");
            return  false;
        }
        else{
            this.myContacts.remove(foundPostion);
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " was deleted.");
            return true;
        }
    }

    // Find Contact Position
    private int findContact(Contacts contact) {
        return this.myContacts.indexOf(contact);
    }

    // Find Contact Names
    private int findContact(String contactName) {
        for(int i =0; i < myContacts.size(); i++) {
            // Creating another temporary object to hold the name and compare
            Contacts contacts = this.myContacts.get(i);
            if(contacts.getFirstName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // query contact
    public String queryContact(Contacts contact) {
        if(findContact(contact) >= 0) {
            return contact.getFirstName();
        }
        return null;
    }

    public Contacts queryContact(String FirstName) {
        int position = findContact(FirstName);
        if(position >=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public LinkedList<Integer> printnumbers() {
        return object;

    }
    int a[] = new int[7] ;
    int i =0;
    public void addNewContact() {

        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of Person");
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Email Address: ");
        String email = scanner.nextLine();
        System.out.println("Contact Number: ");
        Integer phone = scanner.nextInt();
        scanner.nextLine();
        this.object.add(phone);
        boolean g = true;
        Character x ;

        int count = 1;
        while(g){
            System.out.println("Would you like to add another contact? (y/n): ");
            x = scanner.next().charAt(0);
            scanner.nextLine();
            if('y' == x){
                System.out.println("Contact Number: ");
                int phone1 = scanner.nextInt();

                this.object.add(phone1);

                count ++;
            }

            else{
                a[i] = count;
                g = false;
                i++;
            }
        }
        Contacts newContact = Contacts.createContact(firstName,lastName,  email, phone);
        if(addNewContact(newContact)) {
            System.out.println("New Contact Added: name = "+ firstName + " " + lastName + "  phone" + phone );
        }else {
            System.out.println("Can't add, " + firstName +" " +lastName+" already on file");
        }
    }

    int k =0;
    //int f = 0;
    //int m= a[k];
    public void printContacts() {
        System.out.println("---Here are all your contacts---");
        System.out.println("-------- * -------- * -------- * --------");
        for(int i = 0; i < this.myContacts.size(); i++) {
            System.out.println( "First Name: " + this.myContacts.get(i).getFirstName() );
            System.out.println( "Last Name: " + this.myContacts.get(i).getLastName());
            if(a[k]>1){
                System.out.print("Contact Number(s): " );
            }
            for (int q : a){
                for(int j = 0; j<q-1; j++){
                    if(a[k]<2){
                        System.out.print("Contact Number: " + this.myContacts.get(j).getPhoneNumber());

                        break;
                }
                    if(a[k]>1){

                        System.out.print(object.get(j));
                        System.out.print(",");

                     }
            }
            k++;

            System.out.println();
            System.out.println("Email Address: " + this.myContacts.get(i).getEmailAddress());
            System.out.println(object);
            System.out.println("-------- * -------- * -------- * --------");
        }
    }
}}
