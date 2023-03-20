package core;

public enum EmployeeActionEnum {

    angestellter{
        void doAction(){
            System.out.println("Ich bin Angestellter.");
        }

    },
    arbeiter{
        void doAction(){
            System.out.println("Ich bin Arbeiter.");
        }

    },
    praktikant{
        void doAction(){
            System.out.println("Ich bin Praktikant.");
        }

    };

    abstract void doAction ();
}
