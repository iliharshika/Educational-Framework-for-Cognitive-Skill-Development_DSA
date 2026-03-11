import java.util.*;

class RQuestion{
    String question;
    String answer;

    RQuestion(String q,String a){
        question=q;
        answer=a;
    }
}

public class RecallRush {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<RQuestion>>> database = new HashMap<>();


    static void loadQuestions(){

        for(int cls=6; cls<=10; cls++){

            HashMap<Integer,List<RQuestion>> category = new HashMap<>();


            // 1 MEMORY SEQUENCE

            List<RQuestion> c1 = new ArrayList<>();

            c1.add(new RQuestion("Remember this sequence: 3,7,9. What is the second number?", "7"));
            c1.add(new RQuestion("Sequence: 5,8,2. What is the first number?", "5"));
            c1.add(new RQuestion("Sequence: 4,1,6. What is the last number?", "6"));
            c1.add(new RQuestion("Sequence: 9,3,7. What is the middle number?", "3"));
            c1.add(new RQuestion("Sequence: 2,8,5. What is the first number?", "2"));

            if(cls>=8){
                c1.set(0,new RQuestion("Sequence: 6,4,9. What is the last number?", "9"));
                c1.set(1,new RQuestion("Sequence: 8,2,5. What is the middle number?", "2"));
            }

            if(cls>=9){
                c1.set(2,new RQuestion("Sequence: 7,1,3. What is the first number?", "7"));
                c1.set(3,new RQuestion("Sequence: 5,9,4. What is the last number?", "4"));
            }

            if(cls==10){
                c1.set(4,new RQuestion("Sequence: 2,6,8. What is the middle number?", "6"));
            }

            category.put(1,c1);



            // 2 OBJECT RECALL

            List<RQuestion> c2 = new ArrayList<>();

            c2.add(new RQuestion("Remember: Apple, Pen, Book. Which is the second item?", "pen"));
            c2.add(new RQuestion("Remember: Dog, Cat, Cow. Which is the first item?", "dog"));
            c2.add(new RQuestion("Remember: Bus, Car, Train. Which is the last item?", "train"));
            c2.add(new RQuestion("Remember: Table, Chair, Bed. Which is the middle item?", "chair"));
            c2.add(new RQuestion("Remember: Mango, Banana, Apple. Which is the first item?", "mango"));

            if(cls>=8){
                c2.set(0,new RQuestion("Remember: Pencil, Eraser, Scale. Which is second?", "eraser"));
                c2.set(1,new RQuestion("Remember: Lion, Tiger, Bear. Which is first?", "lion"));
            }

            if(cls>=9){
                c2.set(2,new RQuestion("Remember: Bike, Car, Bus. Which is last?", "bus"));
                c2.set(3,new RQuestion("Remember: Cup, Plate, Spoon. Which is middle?", "plate"));
            }

            if(cls==10){
                c2.set(4,new RQuestion("Remember: Red, Blue, Green. Which is second?", "blue"));
            }

            category.put(2,c2);



            // 3 NUMBER RECALL

            List<RQuestion> c3 = new ArrayList<>();

            c3.add(new RQuestion("Remember number 47. What was the number?", "47"));
            c3.add(new RQuestion("Remember number 82. What was the number?", "82"));
            c3.add(new RQuestion("Remember number 15. What was the number?", "15"));
            c3.add(new RQuestion("Remember number 29. What was the number?", "29"));
            c3.add(new RQuestion("Remember number 63. What was the number?", "63"));

            if(cls>=8){
                c3.set(0,new RQuestion("Remember number 94. What was it?", "94"));
                c3.set(1,new RQuestion("Remember number 56. What was it?", "56"));
            }

            if(cls>=9){
                c3.set(2,new RQuestion("Remember number 71. What was it?", "71"));
                c3.set(3,new RQuestion("Remember number 38. What was it?", "38"));
            }

            if(cls==10){
                c3.set(4,new RQuestion("Remember number 120. What was it?", "120"));
            }

            category.put(3,c3);



            // 4 PATTERN RECALL

            List<RQuestion> c4 = new ArrayList<>();

            c4.add(new RQuestion("Pattern: Circle, Square, Circle. What is second shape?", "square"));
            c4.add(new RQuestion("Pattern: Red, Blue, Red. What is second color?", "blue"));
            c4.add(new RQuestion("Pattern: A,B,A. What is second letter?", "b"));
            c4.add(new RQuestion("Pattern: Up,Down,Up. What is second word?", "down"));
            c4.add(new RQuestion("Pattern: Cat,Dog,Cat. What is second word?", "dog"));

            if(cls>=8){
                c4.set(0,new RQuestion("Pattern: Sun,Moon,Sun. What is second?", "moon"));
                c4.set(1,new RQuestion("Pattern: East,West,East. What is second?", "west"));
            }

            if(cls>=9){
                c4.set(2,new RQuestion("Pattern: Day,Night,Day. What is second?", "night"));
                c4.set(3,new RQuestion("Pattern: Hot,Cold,Hot. What is second?", "cold"));
            }

            if(cls==10){
                c4.set(4,new RQuestion("Pattern: Start,Stop,Start. What is second?", "stop"));
            }

            category.put(4,c4);



            // 5 QUICK FACTS

            List<RQuestion> c5 = new ArrayList<>();

            c5.add(new RQuestion("How many days in a week?", "7"));
            c5.add(new RQuestion("How many months in a year?", "12"));
            c5.add(new RQuestion("How many hours in a day?", "24"));
            c5.add(new RQuestion("How many legs does a spider have?", "8"));
            c5.add(new RQuestion("How many continents on Earth?", "7"));

            if(cls>=8){
                c5.set(0,new RQuestion("How many sides in a hexagon?", "6"));
                c5.set(1,new RQuestion("How many letters in English alphabet?", "26"));
            }

            if(cls>=9){
                c5.set(2,new RQuestion("How many degrees in a triangle?", "180"));
                c5.set(3,new RQuestion("How many players in a cricket team?", "11"));
            }

            if(cls==10){
                c5.set(4,new RQuestion("Speed of light approx (km/s)?", "300000"));
            }

            category.put(5,c5);


            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<RQuestion> list = database.get(cls).get(cat);

        int score = 0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            RQuestion q = list.get(i);

            System.out.println("\nQuestion "+(i+1));
            System.out.println(q.question);

            System.out.print("Answer: ");
            String ans = sc.nextLine();

            if(ans.equalsIgnoreCase(q.answer))
                score++;
        }

        System.out.println("\nResult: "+score+"/5");
    }



    public static void main(String[] args){

        loadQuestions();

        System.out.println("\n===== RecallRush =====");

        System.out.print("Enter Class (6-10): ");
        int cls = sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Memory Sequence");
        System.out.println("2 Object Recall");
        System.out.println("3 Number Recall");
        System.out.println("4 Pattern Recall");
        System.out.println("5 Quick Facts");

        int cat = sc.nextInt();

        startQuiz(cls,cat);
    }
}