package scopes;

public class Human {
/* Global Scope? Nope!
    everything must belong to a class
    Lifetime of a variable!
    Types:
    -Static or Class
        - Accessible to all members of a class
    -Method or Local
        - Accessible within the method it is declared in
    -Block
        -Accessible inside of a block or control statement
    -Instance
        -Accessible inside of that specific object

    Shadowing
        what occurs when variables in different scopes have the same name

    What defines scope- {}

 */
    private String name;
    private int age;
    private int weight;
    static private String homePlanet="Earth";

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    //no args constructor
    public Human(){
        //super();
   }

    //constructor w/ fields
    public Human(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
    }
    //getters and setters (accessors and mutators)
    public String getName() {
        return name;
    }
    //Example of shadowing
    public void setName(String name) {//name is method scope
        this.name = name; //this.name refers to the specific instance's name field
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", homePlanet="+ homePlanet +
                '}';
    }
}


