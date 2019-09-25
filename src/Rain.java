//write a program in java to input the following details of user
//users name
//users company name
//user joining year
import java.util.Random;
public class Rain {
    private String name;
    private String companyName;
    private int age;
    private String email;
    private String password;
    public Rain(String name,String companyName,int age){
        this.name=name;
        this.companyName=companyName;
        this.age=age;
        this.email=createUserEmail();
        this.password=createUserPassword();


    }
    private String createUserPassword(){
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomCharacter());
        for(int i=0;i<4;i++){
            sb.append(generateRandomTntegerFromLimit(10));
        }
        sb.append(generateFirstCharacterFromusername());
        sb.append(generateSpecialSymbol());
        return sb.toString();


    }
    private String createUserEmail(){
        return String.format("%s_%d@%s.com",getName().toLowerCase(),getAge(),getCompanyName().toLowerCase());

    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public int generateRandomTntegerFromLimit(int limit){
        return (int) (Math.random()*limit);
    }
    private char generateRandomCharacter(){
        int randomNumberUpto26=generateRandomTntegerFromLimit(26);
        return (char) ('a'+randomNumberUpto26);
    }
    private String generateFirstCharacterFromusername(){
        if(getName().length()>5 ){
            int diff =5 - getName().length();
            StringBuilder tempName=new StringBuilder(getName());
            for(int i =0;i<diff;i++){
                tempName.append("0");
            }
            return tempName.toString();
        }else{
            return getName().substring(0,5);
        }
    }
    private char generateSpecialSymbol(){
        char[] specialsymbols ={'!','@','#','$','%','^','&','*','(',')'};
        int randonInteger = generateRandomTntegerFromLimit(specialsymbols.length);
        return specialsymbols[randonInteger];

    }
}
class UserEntry{
    public static void main(String[] args) {
        Rain obj = new Rain("sahas","google",18);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());


    }
}