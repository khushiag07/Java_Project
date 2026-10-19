import java.rmi.Naming;

public static void main(String[] args){
    try{
        Calculator obj = (Calculator) Naming.lookup("rmi://localhost/Calculator");
        System.out.println("Addition = " + obj.add(10,20));
        System.out.println("Subtract = " + obj.subtract(10 , 20 ));
        
    }
        catch (Exception e){
            System.out.println(e);
        }

        
    }
