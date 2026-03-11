import java.util.*;

class SQuestion{
    String question;
    String answer;

    SQuestion(String q,String a){
        question=q;
        answer=a;
    }
}

public class SpeedSolve {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<SQuestion>>> database = new HashMap<>();


    static void loadQuestions(){

        for(int cls=6; cls<=10; cls++){

            HashMap<Integer,List<SQuestion>> category = new HashMap<>();


            // 1 QUICK MATH
            List<SQuestion> c1 = new ArrayList<>();

            c1.add(new SQuestion("5 + 7 = ?", "12"));
            c1.add(new SQuestion("9 × 3 = ?", "27"));
            c1.add(new SQuestion("20 - 6 = ?", "14"));
            c1.add(new SQuestion("18 ÷ 3 = ?", "6"));
            c1.add(new SQuestion("4 × 8 = ?", "32"));

            if(cls>=8){
                c1.set(0,new SQuestion("35 + 47 = ?", "82"));
                c1.set(1,new SQuestion("12 × 9 = ?", "108"));
            }

            if(cls>=9){
                c1.set(2,new SQuestion("125 + 75 = ?", "200"));
                c1.set(3,new SQuestion("144 ÷ 12 = ?", "12"));
            }

            if(cls==10){
                c1.set(4,new SQuestion("250 × 4 = ?", "1000"));
            }

            category.put(1,c1);



            // 2 MENTAL CALCULATION
            List<SQuestion> c2 = new ArrayList<>();

            c2.add(new SQuestion("Half of 40?", "20"));
            c2.add(new SQuestion("Double of 15?", "30"));
            c2.add(new SQuestion("Square of 5?", "25"));
            c2.add(new SQuestion("10% of 200?", "20"));
            c2.add(new SQuestion("Quarter of 80?", "20"));

            if(cls>=8){
                c2.set(0,new SQuestion("Half of 120?", "60"));
                c2.set(1,new SQuestion("Double of 45?", "90"));
            }

            if(cls>=9){
                c2.set(2,new SQuestion("Square of 12?", "144"));
                c2.set(3,new SQuestion("20% of 300?", "60"));
            }

            if(cls==10){
                c2.set(4,new SQuestion("Square of 15?", "225"));
            }

            category.put(2,c2);



            // 3 TIME CHALLENGE
            List<SQuestion> c3 = new ArrayList<>();

            c3.add(new SQuestion("Seconds in 1 minute?", "60"));
            c3.add(new SQuestion("Minutes in 1 hour?", "60"));
            c3.add(new SQuestion("Hours in 1 day?", "24"));
            c3.add(new SQuestion("Days in a week?", "7"));
            c3.add(new SQuestion("Months in a year?", "12"));

            if(cls>=8){
                c3.set(0,new SQuestion("Minutes in 2 hours?", "120"));
                c3.set(1,new SQuestion("Seconds in 2 minutes?", "120"));
            }

            if(cls>=9){
                c3.set(2,new SQuestion("Hours in 3 days?", "72"));
                c3.set(3,new SQuestion("Minutes in 3 hours?", "180"));
            }

            if(cls==10){
                c3.set(4,new SQuestion("Seconds in 5 minutes?", "300"));
            }

            category.put(3,c3);



            // 4 LOGICAL SPEED
            List<SQuestion> c4 = new ArrayList<>();

            c4.add(new SQuestion("Next: 2,4,6,8, ?", "10"));
            c4.add(new SQuestion("Next: 3,6,9,12, ?", "15"));
            c4.add(new SQuestion("Next: 5,10,15,20, ?", "25"));
            c4.add(new SQuestion("Next: 7,14,21, ?", "28"));
            c4.add(new SQuestion("Next: 9,18,27, ?", "36"));

            if(cls>=8){
                c4.set(0,new SQuestion("Next: 2,6,18, ?", "54"));
                c4.set(1,new SQuestion("Next: 4,16,64, ?", "256"));
            }

            if(cls>=9){
                c4.set(2,new SQuestion("Next: 1,4,9,16, ?", "25"));
                c4.set(3,new SQuestion("Next: 3,9,27, ?", "81"));
            }

            if(cls==10){
                c4.set(4,new SQuestion("Next: 2,5,10,17, ?", "26"));
            }

            category.put(4,c4);



            // 5 RAPID REASONING
            List<SQuestion> c5 = new ArrayList<>();

            c5.add(new SQuestion("Which is larger: 15 or 51?", "51"));
            c5.add(new SQuestion("Which is smallest: 8,3,5?", "3"));
            c5.add(new SQuestion("Which number is even: 7,9,12?", "12"));
            c5.add(new SQuestion("Which is odd: 4,8,11?", "11"));
            c5.add(new SQuestion("Which is greater: 99 or 100?", "100"));

            if(cls>=8){
                c5.set(0,new SQuestion("Which is larger: 120 or 102?", "120"));
                c5.set(1,new SQuestion("Which is smallest: 45,32,67?", "32"));
            }

            if(cls>=9){
                c5.set(2,new SQuestion("Which is even: 13,17,24?", "24"));
                c5.set(3,new SQuestion("Which is odd: 20,31,44?", "31"));
            }

            if(cls==10){
                c5.set(4,new SQuestion("Which is greater: 999 or 1000?", "1000"));
            }

            category.put(5,c5);


            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<SQuestion> list = database.get(cls).get(cat);

        int score = 0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            SQuestion q = list.get(i);

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

        System.out.println("\n===== SpeedSolve =====");

        System.out.print("Enter Class (6-10): ");
        int cls = sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Quick Math");
        System.out.println("2 Mental Calculation");
        System.out.println("3 Time Challenge");
        System.out.println("4 Logical Speed");
        System.out.println("5 Rapid Reasoning");

        int cat = sc.nextInt();

        startQuiz(cls,cat);
    }
}