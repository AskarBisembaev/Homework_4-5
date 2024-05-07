package Home_Work.Reflection;

public class Cat extends Animal {
    public Cat(int age) {
        super("Cat",age);
    }

    @Override
    public void doVoice() {
        System.out.println("meow");
    }
}