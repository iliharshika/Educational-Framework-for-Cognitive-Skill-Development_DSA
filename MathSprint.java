import java.util.*;

class MQuestion{
    String question;
    String answer;

    MQuestion(String q,String a){
        question=q;
        answer=a;
    }
}

public class MathSprint {

    static Scanner sc=new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<MQuestion>>> database=new HashMap<>();


    static void loadQuestions(){

        for(int cls=6;cls<=10;cls++){

            HashMap<Integer,List<MQuestion>> category=new HashMap<>();


            // 1 ARITHMETIC

            List<MQuestion> c1=new ArrayList<>();

            c1.add(new MQuestion("12 + 8 = ?", "20"));
            c1.add(new MQuestion("25 - 9 = ?", "16"));
            c1.add(new MQuestion("7 × 6 = ?", "42"));
            c1.add(new MQuestion("81 ÷ 9 = ?", "9"));
            c1.add(new MQuestion("15 + 17 = ?", "32"));

            if(cls>=8){
                c1.set(0,new MQuestion("45 + 37 = ?", "82"));
                c1.set(1,new MQuestion("90 - 47 = ?", "43"));
            }

            if(cls>=9){
                c1.set(2,new MQuestion("12 × 14 = ?", "168"));
                c1.set(3,new MQuestion("144 ÷ 12 = ?", "12"));
            }

            if(cls==10){
                c1.set(4,new MQuestion("125 × 8 = ?", "1000"));
            }

            category.put(1,c1);



            // 2 FRACTIONS

            List<MQuestion> c2=new ArrayList<>();

            c2.add(new MQuestion("1/2 + 1/2 = ?", "1"));
            c2.add(new MQuestion("3/4 + 1/4 = ?", "1"));
            c2.add(new MQuestion("5/6 - 1/6 = ?", "4/6"));
            c2.add(new MQuestion("2/3 of 9 = ?", "6"));
            c2.add(new MQuestion("1/5 of 20 = ?", "4"));

            if(cls>=8){
                c2.set(0,new MQuestion("2/3 + 1/3 = ?", "1"));
                c2.set(1,new MQuestion("7/8 - 3/8 = ?", "4/8"));
            }

            if(cls>=9){
                c2.set(2,new MQuestion("3/5 of 20 = ?", "12"));
                c2.set(3,new MQuestion("4/9 of 27 = ?", "12"));
            }

            if(cls==10){
                c2.set(4,new MQuestion("5/6 of 30 = ?", "25"));
            }

            category.put(2,c2);



            // 3 ALGEBRA BASICS

            List<MQuestion> c3=new ArrayList<>();

            c3.add(new MQuestion("x + 5 = 10, x = ?", "5"));
            c3.add(new MQuestion("x - 3 = 7, x = ?", "10"));
            c3.add(new MQuestion("2x = 14, x = ?", "7"));
            c3.add(new MQuestion("x/2 = 6, x = ?", "12"));
            c3.add(new MQuestion("3x = 21, x = ?", "7"));

            if(cls>=8){
                c3.set(0,new MQuestion("x + 12 = 20, x = ?", "8"));
                c3.set(1,new MQuestion("2x = 18, x = ?", "9"));
            }

            if(cls>=9){
                c3.set(2,new MQuestion("x² = 49, x = ?", "7"));
                c3.set(3,new MQuestion("x² = 64, x = ?", "8"));
            }

            if(cls==10){
                c3.set(4,new MQuestion("x² = 81, x = ?", "9"));
            }

            category.put(3,c3);



            // 4 GEOMETRY

            List<MQuestion> c4=new ArrayList<>();

            c4.add(new MQuestion("Triangle angles sum?", "180"));
            c4.add(new MQuestion("Square sides?", "4"));
            c4.add(new MQuestion("Rectangle opposite sides?", "equal"));
            c4.add(new MQuestion("Pentagon sides?", "5"));
            c4.add(new MQuestion("Hexagon sides?", "6"));

            if(cls>=8){
                c4.set(0,new MQuestion("Area of square with side 4?", "16"));
                c4.set(1,new MQuestion("Perimeter of square side 5?", "20"));
            }

            if(cls>=9){
                c4.set(2,new MQuestion("Area of rectangle 5×4?", "20"));
                c4.set(3,new MQuestion("Circle diameter if radius 5?", "10"));
            }

            if(cls==10){
                c4.set(4,new MQuestion("Area of circle formula?", "πr²"));
            }

            category.put(4,c4);



            // 5 WORD PROBLEMS

            List<MQuestion> c5=new ArrayList<>();

            c5.add(new MQuestion("If a pen costs 10 and you buy 3, total?", "30"));
            c5.add(new MQuestion("5 apples each cost 4. Total cost?", "20"));
            c5.add(new MQuestion("10 students share 50 candies. Each gets?", "5"));
            c5.add(new MQuestion("Distance 60 km in 2 hrs. Speed?", "30"));
            c5.add(new MQuestion("Perimeter of square side 6?", "24"));

            if(cls>=8){
                c5.set(0,new MQuestion("A book costs 50. 4 books cost?", "200"));
                c5.set(1,new MQuestion("Speed 40 km/hr for 3 hrs distance?", "120"));
            }

            if(cls>=9){
                c5.set(2,new MQuestion("Area rectangle 10×6?", "60"));
                c5.set(3,new MQuestion("Average of 10 and 20?", "15"));
            }

            if(cls==10){
                c5.set(4,new MQuestion("Simple interest on 1000 at 10% for 1 year?", "100"));
            }

            category.put(5,c5);



            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<MQuestion> list=database.get(cls).get(cat);

        int score=0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            MQuestion q=list.get(i);

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

        System.out.println("\n===== MathSprint =====");

        System.out.print("Enter Class (6-10): ");
        int cls=sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Arithmetic");
        System.out.println("2 Fractions");
        System.out.println("3 Algebra Basics");
        System.out.println("4 Geometry");
        System.out.println("5 Word Problems");

        int cat=sc.nextInt();

        startQuiz(cls,cat);
    }
}