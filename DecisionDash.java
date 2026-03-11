import java.util.*;

class DQuestion{
    String question;
    String answer;

    DQuestion(String q,String a){
        question=q;
        answer=a;
    }
}

public class DecisionDash {

    static Scanner sc=new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<DQuestion>>> database=new HashMap<>();


    static void loadQuestions(){

        for(int cls=6;cls<=10;cls++){

            HashMap<Integer,List<DQuestion>> category=new HashMap<>();


            // 1 SITUATION DECISION

            List<DQuestion> s1=new ArrayList<>();

            s1.add(new DQuestion("You forgot homework. What should you do? (tell/lie)","tell"));
            s1.add(new DQuestion("Friend is sad. What should you do? (ignore/help)","help"));
            s1.add(new DQuestion("Teacher asks question you know. (answer/keep quiet)","answer"));
            s1.add(new DQuestion("You see trash in class. (pick/leave)","pick"));
            s1.add(new DQuestion("You broke a pencil of friend. (tell/silent)","tell"));

            if(cls>=8){
                s1.set(0,new DQuestion("Exam tomorrow but friends invite to play. (study/play)","study"));
                s1.set(1,new DQuestion("See bullying in school. (ignore/report)","report"));
            }

            if(cls>=9){
                s1.set(2,new DQuestion("Group project leader absent. (wait/organize)","organize"));
                s1.set(3,new DQuestion("See cheating in exam. (ignore/report)","report"));
            }

            if(cls==10){
                s1.set(4,new DQuestion("Important exam but feeling lazy. (study/sleep)","study"));
            }

            category.put(1,s1);



            // 2 BEST CHOICE

            List<DQuestion> s2=new ArrayList<>();

            s2.add(new DQuestion("Best way to learn? (practice/memorize)","practice"));
            s2.add(new DQuestion("Healthy drink? (juice/soda)","juice"));
            s2.add(new DQuestion("Best way to solve doubt? (ask/search)","ask"));
            s2.add(new DQuestion("Saving money means? (spend/save)","save"));
            s2.add(new DQuestion("Reading improves? (knowledge/laziness)","knowledge"));

            if(cls>=8){
                s2.set(0,new DQuestion("Best exam preparation? (plan/random)","plan"));
                s2.set(1,new DQuestion("Better transport? (cycle/walk)","cycle"));
            }

            if(cls>=9){
                s2.set(2,new DQuestion("Best teamwork skill? (communication/silence)","communication"));
                s2.set(3,new DQuestion("Learning coding requires? (practice/guess)","practice"));
            }

            if(cls==10){
                s2.set(4,new DQuestion("Best career preparation? (planning/luck)","planning"));
            }

            category.put(2,s2);



            // 3 PROBLEM SOLVING

            List<DQuestion> s3=new ArrayList<>();

            s3.add(new DQuestion("Puzzle difficult. First step? (think/quit)","think"));
            s3.add(new DQuestion("Computer not working. (restart/break)","restart"));
            s3.add(new DQuestion("Math problem hard. (practice/skip)","practice"));
            s3.add(new DQuestion("Lost your notebook. (search/ignore)","search"));
            s3.add(new DQuestion("Friend argument. (talk/fight)","talk"));

            if(cls>=8){
                s3.set(0,new DQuestion("Team losing game. (motivate/leave)","motivate"));
                s3.set(1,new DQuestion("Code error occurs. (debug/delete)","debug"));
            }

            if(cls>=9){
                s3.set(2,new DQuestion("Business loss. (analyze/quit)","analyze"));
                s3.set(3,new DQuestion("Low marks. (improve/blame)","improve"));
            }

            if(cls==10){
                s3.set(4,new DQuestion("Project failed. (retry/stop)","retry"));
            }

            category.put(3,s3);



            // 4 ETHICAL THINKING

            List<DQuestion> s4=new ArrayList<>();

            s4.add(new DQuestion("Found wallet. (return/keep)","return"));
            s4.add(new DQuestion("Friend cheating. (stop/help)","stop"));
            s4.add(new DQuestion("Borrowed book. (return/forget)","return"));
            s4.add(new DQuestion("See rule break. (report/join)","report"));
            s4.add(new DQuestion("Respect teachers? (yes/no)","yes"));

            if(cls>=8){
                s4.set(0,new DQuestion("See someone drop money. (return/ignore)","return"));
                s4.set(1,new DQuestion("Online bullying. (report/ignore)","report"));
            }

            if(cls>=9){
                s4.set(2,new DQuestion("Fake news online. (verify/share)","verify"));
                s4.set(3,new DQuestion("Plagiarism in project. (avoid/use)","avoid"));
            }

            if(cls==10){
                s4.set(4,new DQuestion("Ethical leadership means? (fair/selfish)","fair"));
            }

            category.put(4,s4);



            // 5 DAILY LIFE DECISIONS

            List<DQuestion> s5=new ArrayList<>();

            s5.add(new DQuestion("Morning routine? (exercise/sleep)","exercise"));
            s5.add(new DQuestion("Homework time? (early/late)","early"));
            s5.add(new DQuestion("Food choice? (healthy/junk)","healthy"));
            s5.add(new DQuestion("Screen time? (limit/unlimited)","limit"));
            s5.add(new DQuestion("Sleep time? (regular/late)","regular"));

            if(cls>=8){
                s5.set(0,new DQuestion("Study plan? (schedule/random)","schedule"));
                s5.set(1,new DQuestion("Learning new skill? (practice/ignore)","practice"));
            }

            if(cls>=9){
                s5.set(2,new DQuestion("Career planning? (think/ignore)","think"));
                s5.set(3,new DQuestion("Daily reading? (yes/no)","yes"));
            }

            if(cls==10){
                s5.set(4,new DQuestion("Goal setting? (clear/none)","clear"));
            }

            category.put(5,s5);



            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<DQuestion> list=database.get(cls).get(cat);

        int score=0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            DQuestion q=list.get(i);

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

        System.out.println("\n===== DecisionDash =====");

        System.out.print("Enter Class (6-10): ");
        int cls=sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Situation Decision");
        System.out.println("2 Best Choice");
        System.out.println("3 Problem Solving");
        System.out.println("4 Ethical Thinking");
        System.out.println("5 Daily Life Decisions");

        int cat=sc.nextInt();

        startQuiz(cls,cat);
    }
}