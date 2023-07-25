package test.level1;

public class Child extends Parent{
    Child(){
        System.out.println("자식");
    }

    @Override
    public void getName(){
        System.out.println("자식이름");
    }

    public static void main(String[] args){
        Parent parent = new Child();

        parent.getName();
    }
}
