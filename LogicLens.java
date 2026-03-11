import java.util.*;

class Question {
    String question;
    String answer;

    Question(String q,String a){
        question=q;
        answer=a;
    }
}

public class LogicLens {

    static Scanner sc=new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<Question>>> database=new HashMap<>();


    static void loadQuestions(){

        for(int cls=6;cls<=10;cls++){

            HashMap<Integer,List<Question>> category=new HashMap<>();


            // 1 NUMBER PATTERN
            List<Question> num=new ArrayList<>();

            num.add(new Question("2,4,6,8, ?", "10"));
            num.add(new Question("3,6,9,12, ?", "15"));
            num.add(new Question("5,10,15,20, ?", "25"));
            num.add(new Question("1,3,5,7, ?", "9"));
            num.add(new Question("4,8,12,16, ?", "20"));

            if(cls>=8){
                num.set(0,new Question("2,6,18,54, ?", "162"));
                num.set(1,new Question("5,10,20,40, ?", "80"));
            }

            if(cls>=9){
                num.set(2,new Question("2,5,10,17,26, ?", "37"));
                num.set(3,new Question("1,4,9,16,25, ?", "36"));
            }

            if(cls==10){
                num.set(4,new Question("1,4,13,40,121, ?", "364"));
            }

            category.put(1,num);



            // 2 ODD ONE OUT

            List<Question> odd=new ArrayList<>();

            odd.add(new Question("4,9,16,18","18"));
            odd.add(new Question("Apple,Banana,Car,Mango","Car"));
            odd.add(new Question("Dog,Cat,Tiger,Chair","Chair"));
            odd.add(new Question("Rose,Lily,Sunflower,Pen","Pen"));
            odd.add(new Question("Circle,Square,Triangle,Pencil","Pencil"));

            if(cls>=8){
                odd.set(0,new Question("4,9,16,20","20"));
                odd.set(1,new Question("25,36,49,52","52"));
            }

            if(cls>=9){
                odd.set(2,new Question("16,25,36,45","45"));
                odd.set(3,new Question("Tiger,Lion,Elephant,Table","Table"));
            }

            if(cls==10){
                odd.set(4,new Question("64,81,100,105","105"));
            }

            category.put(2,odd);



            // 3 ALPHABET PATTERN

            List<Question> alpha=new ArrayList<>();

            alpha.add(new Question("A,C,E,G, ?", "I"));
            alpha.add(new Question("B,D,F,H, ?", "J"));
            alpha.add(new Question("A,D,G,J, ?", "M"));
            alpha.add(new Question("B,E,H,K, ?", "N"));
            alpha.add(new Question("C,F,I,L, ?", "O"));

            if(cls>=8){
                alpha.set(0,new Question("A,D,G,J, ?", "M"));
                alpha.set(1,new Question("B,E,H,K, ?", "N"));
            }

            if(cls>=9){
                alpha.set(2,new Question("A,C,F,J,O, ?", "U"));
                alpha.set(3,new Question("B,D,G,K,P, ?", "V"));
            }

            if(cls==10){
                alpha.set(4,new Question("A,D,H,M,S, ?", "Z"));
            }

            category.put(3,alpha);



            // 4 ANALOGY

            List<Question> ana=new ArrayList<>();

            ana.add(new Question("Dog : Puppy :: Cat : ?", "Kitten"));
            ana.add(new Question("Pen : Write :: Knife : ?", "Cut"));
            ana.add(new Question("Bird : Fly :: Fish : ?", "Swim"));
            ana.add(new Question("Sun : Day :: Moon : ?", "Night"));
            ana.add(new Question("Book : Read :: Food : ?", "Eat"));

            if(cls>=8){
                ana.set(0,new Question("Teacher : School :: Doctor : ?", "Hospital"));
                ana.set(1,new Question("Cow : Milk :: Bee : ?", "Honey"));
            }

            if(cls>=9){
                ana.set(2,new Question("Heart : Blood :: Lungs : ?", "Oxygen"));
                ana.set(3,new Question("Book : Library :: Car : ?", "Garage"));
            }

            if(cls==10){
                ana.set(4,new Question("Tree : Root :: Building : ?", "Foundation"));
            }

            category.put(4,ana);



            // 5 SHAPE LOGIC

            List<Question> shape=new ArrayList<>();

            shape.add(new Question("Triangle sides?", "3"));
            shape.add(new Question("Square sides?", "4"));
            shape.add(new Question("Pentagon sides?", "5"));
            shape.add(new Question("Hexagon sides?", "6"));
            shape.add(new Question("Circle sides?", "0"));

            if(cls>=8){
                shape.set(0,new Question("Shape with 5 sides?", "Pentagon"));
                shape.set(1,new Question("Shape with 6 sides?", "Hexagon"));
            }

            if(cls>=9){
                shape.set(2,new Question("Triangle angle sum?", "180"));
                shape.set(3,new Question("Square angle sum?", "360"));
            }

            if(cls==10){
                shape.set(4,new Question("Interior angle of hexagon?", "120"));
            }

            category.put(5,shape);



            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<Question> list=database.get(cls).get(cat);

        int score=0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            Question q=list.get(i);

            System.out.println("\nQuestion "+(i+1));
            System.out.println(q.question);

            System.out.print("Answer: ");
            String ans=sc.nextLine();

            if(ans.equalsIgnoreCase(q.answer))
                score++;
        }

        System.out.println("\nResult: "+score+"/5");
    }



    public static void main(String[] args){

        loadQuestions();

        System.out.println("\n===== LogicLens =====");

        System.out.print("Enter Class (6-10): ");
        int cls=sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Number Pattern");
        System.out.println("2 Odd One Out");
        System.out.println("3 Alphabet Pattern");
        System.out.println("4 Logical Analogy");
        System.out.println("5 Shape Logic");

        int cat=sc.nextInt();

        startQuiz(cls,cat);

    }
}