import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GradeManager {
    Admin admin;
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public GradeManager() {
        this.students.add(new Student("aaa", "aa"));
        this.students.add(new Student("bbb", "bb"));
        this.students.add(new Student("ccc", "cc"));
    }

    void run() {
        boolean start = false;
        while (true) {
            start = LoginOrExit();
            if (!start)
                break;
            while (true) {
                LoginAdmin();
                selectMenu();
                System.out.println("로그아웃됨");
                System.out.println();
                break;
            }
        }


    }

    boolean LoginOrExit() {
        System.out.println("""
                <<성적 처리>>
                1.관리자 로그인
                2.종료
                """);
        int select = 0;
        while (true) {
            try {
                select = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("다시입력하세요");
                sc.nextLine();
            }
        }
        return select == 1;
    }

    void LoginAdmin() {
        while (true) {
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Phone:");
            String phone = sc.next();
            this.admin = new Admin(name, phone);
            System.out.print("ID:");
            String ID = sc.next();
            System.out.print("PW:");
            String PW = sc.next();
            if (this.admin.getID().equals(ID) && this.admin.getPW().equals(PW)) {
                System.out.println(admin.getName() + "관리자님 반갑습니다");
                break;
            } else
                System.out.println("관리자 계정이 틀렸습니다");
        }
    }

    void selectMenu() {
        while (true) {
            System.out.println("""
                    <<성적처리>>
                    1.성적 입력
                    2.성적 검색
                    3.전체 성적 출력
                    4.로그아웃
                    """);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    setStudentsScore();
                    break;
                case 2:
                    searchStudentScore();
                    break;
                case 3:
                    searchAllScore();
                    break;
                case 4:
                    return;
            }

        }
    }

    void setStudentsScore() {
        Iterator<Student> student = this.students.iterator();
        while (student.hasNext()) {
            Student st = student.next();
            System.out.println("ID:" + st.getID() + " NAME:" + st.getName());
            System.out.print("국어:");
            int korean = sc.nextInt();
            st.setKoreanScore(korean);

            System.out.print("영어:");
            int english = sc.nextInt();
            st.setEnglishScore(english);

            System.out.print("수학:");
            int math = sc.nextInt();
            st.setMathScore(math);
            if (student.hasNext()) {
                System.out.println("계속입력하시겠습니까? y/n");
                String select = sc.next();
                if (select.equals("n")) {
                    break;
                }
            }else
                System.out.println("모든 학생의 입력이 끝났습니다");
        }
    }
    void searchStudentScore(){
        System.out.print("검색할 학생의 학번:");
        String search = sc.next();
        Student searched = null;
        for(Student student : students){
            if(student.getID().equals(search)){
                searched = student;
            }
        }
        if(searched==null){
            System.out.println("해당 ID로 찾지 못했습니다");
        }else {
            System.out.println("ID:" + searched.getID() + " Name:" + searched.getName());
            System.out.println("국어:" + searched.getKoreanScore());
            System.out.println("영어:" + searched.getEnglishScore());
            System.out.println("수학:" + searched.getMathScore());
            searched.countScore();
            System.out.println("총점:" + searched.getTotalScore());
            System.out.println("평균:" + searched.getAverageScore());
        }
    }
    void searchAllScore(){
        for(Student student : students){
            student.countScore();
            System.out.println("ID:" + student.getID() + " Name:" + student.getName());
            System.out.println("국어:" + student.getKoreanScore());
            System.out.println("영어:" + student.getEnglishScore());
            System.out.println("수학:" + student.getMathScore());
            System.out.println("총점:" + student.getTotalScore());
            System.out.println("평균:" + student.getAverageScore());
        }
    }
}
