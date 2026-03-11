import java.util.*;

class WQuestion{
    String question;
    String answer;

    WQuestion(String q,String a){
        question=q;
        answer=a;
    }
}

public class WordRush {

    static Scanner sc=new Scanner(System.in);

    static HashMap<Integer,HashMap<Integer,List<WQuestion>>> database=new HashMap<>();


    static void loadQuestions(){

        for(int cls=6;cls<=10;cls++){

            HashMap<Integer,List<WQuestion>> category=new HashMap<>();


            // 1 SYNONYMS

            List<WQuestion> c1=new ArrayList<>();

            c1.add(new WQuestion("Synonym of Happy?", "joyful"));
            c1.add(new WQuestion("Synonym of Fast?", "quick"));
            c1.add(new WQuestion("Synonym of Big?", "large"));
            c1.add(new WQuestion("Synonym of Smart?", "clever"));
            c1.add(new WQuestion("Synonym of Begin?", "start"));

            if(cls>=8){
                c1.set(0,new WQuestion("Synonym of Brave?", "courageous"));
                c1.set(1,new WQuestion("Synonym of Silent?", "quiet"));
            }

            if(cls>=9){
                c1.set(2,new WQuestion("Synonym of Rapid?", "fast"));
                c1.set(3,new WQuestion("Synonym of Tiny?", "small"));
            }

            if(cls==10){
                c1.set(4,new WQuestion("Synonym of Intelligent?", "smart"));
            }

            category.put(1,c1);



            // 2 ANTONYMS

            List<WQuestion> c2=new ArrayList<>();

            c2.add(new WQuestion("Opposite of Hot?", "cold"));
            c2.add(new WQuestion("Opposite of Day?", "night"));
            c2.add(new WQuestion("Opposite of Up?", "down"));
            c2.add(new WQuestion("Opposite of Open?", "close"));
            c2.add(new WQuestion("Opposite of Happy?", "sad"));

            if(cls>=8){
                c2.set(0,new WQuestion("Opposite of Early?", "late"));
                c2.set(1,new WQuestion("Opposite of Light?", "dark"));
            }

            if(cls>=9){
                c2.set(2,new WQuestion("Opposite of Success?", "failure"));
                c2.set(3,new WQuestion("Opposite of Strong?", "weak"));
            }

            if(cls==10){
                c2.set(4,new WQuestion("Opposite of Accept?", "reject"));
            }

            category.put(2,c2);



            // 3 FILL IN THE BLANK

            List<WQuestion> c3=new ArrayList<>();

            c3.add(new WQuestion("The sun ___ in the east. (rises/sets)", "rises"));
            c3.add(new WQuestion("Birds ___ in the sky. (fly/run)", "fly"));
            c3.add(new WQuestion("Fish live in ___. (water/air)", "water"));
            c3.add(new WQuestion("We read books in ___. (school/river)", "school"));
            c3.add(new WQuestion("Trees give us ___. (oxygen/sand)", "oxygen"));

            if(cls>=8){
                c3.set(0,new WQuestion("Students ___ exams. (write/eat)", "write"));
                c3.set(1,new WQuestion("Doctors ___ patients. (treat/play)", "treat"));
            }

            if(cls>=9){
                c3.set(2,new WQuestion("Engineers ___ machines. (design/destroy)", "design"));
                c3.set(3,new WQuestion("Teachers ___ knowledge. (give/take)", "give"));
            }

            if(cls==10){
                c3.set(4,new WQuestion("Leaders ___ teams. (guide/ignore)", "guide"));
            }

            category.put(3,c3);



            // 4 WORD MEANING

            List<WQuestion> c4=new ArrayList<>();

            c4.add(new WQuestion("Meaning of 'Ancient'?", "old"));
            c4.add(new WQuestion("Meaning of 'Rapid'?", "fast"));
            c4.add(new WQuestion("Meaning of 'Tiny'?", "small"));
            c4.add(new WQuestion("Meaning of 'Huge'?", "big"));
            c4.add(new WQuestion("Meaning of 'Silent'?", "quiet"));

            if(cls>=8){
                c4.set(0,new WQuestion("Meaning of 'Courage'?", "bravery"));
                c4.set(1,new WQuestion("Meaning of 'Fragile'?", "delicate"));
            }

            if(cls>=9){
                c4.set(2,new WQuestion("Meaning of 'Complex'?", "complicated"));
                c4.set(3,new WQuestion("Meaning of 'Expand'?", "increase"));
            }

            if(cls==10){
                c4.set(4,new WQuestion("Meaning of 'Innovate'?", "create"));
            }

            category.put(4,c4);



            // 5 SPELL CHECK

            List<WQuestion> c5=new ArrayList<>();

            c5.add(new WQuestion("Correct spelling: (recieve/receive)", "receive"));
            c5.add(new WQuestion("Correct spelling: (beleive/believe)", "believe"));
            c5.add(new WQuestion("Correct spelling: (freind/friend)", "friend"));
            c5.add(new WQuestion("Correct spelling: (enviroment/environment)", "environment"));
            c5.add(new WQuestion("Correct spelling: (seperate/separate)", "separate"));

            if(cls>=8){
                c5.set(0,new WQuestion("Correct spelling: (definately/definitely)", "definitely"));
                c5.set(1,new WQuestion("Correct spelling: (goverment/government)", "government"));
            }

            if(cls>=9){
                c5.set(2,new WQuestion("Correct spelling: (occurence/occurrence)", "occurrence"));
                c5.set(3,new WQuestion("Correct spelling: (maintainance/maintenance)", "maintenance"));
            }

            if(cls==10){
                c5.set(4,new WQuestion("Correct spelling: (accomodate/accommodate)", "accommodate"));
            }

            category.put(5,c5);



            database.put(cls,category);
        }
    }



    static void startQuiz(int cls,int cat){

        List<WQuestion> list=database.get(cls).get(cat);

        int score=0;
        sc.nextLine();

        for(int i=0;i<5;i++){

            WQuestion q=list.get(i);

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

        System.out.println("\n===== WordRush =====");

        System.out.print("Enter Class (6-10): ");
        int cls=sc.nextInt();

        System.out.println("\nSelect Category");

        System.out.println("1 Synonyms");
        System.out.println("2 Antonyms");
        System.out.println("3 Fill in the Blank");
        System.out.println("4 Word Meaning");
        System.out.println("5 Spell Check");

        int cat=sc.nextInt();

        startQuiz(cls,cat);
    }
}