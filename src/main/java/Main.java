import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();

    }
}

class App {
    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        int lastNo = 1; // 명언 번호
        ArrayList<Saying> sayings = new ArrayList<>(); // 명언들을 저장할 리스트

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String sayingText = scanner.nextLine(); // 명언 입력 -> 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감.

                System.out.print("작가 : ");
                String sayingAuthor = scanner.nextLine(); // 작가 입력

                Saying newSaying = new Saying(lastNo, sayingAuthor, sayingText); // 명언 저장 객체 생성
                sayings.add(newSaying); // 명언 리스트에 추가

                System.out.println(lastNo + "번 명언이 등록되었습니다.");
                lastNo++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                // 등록된 명언 목록 출력
                for (int i = 0; i < sayings.size(); i++) {
                    Saying saying = sayings.get(i); // 인덱스를 이용해 직접 접근
                    System.out.println(saying.getNo() + " / " + saying.getAuthor() + " / " + saying.getText());
                }
            }
        }
    }
}


// 명언 저장 클래스
class Saying {
    int no;
    String author;
    String text;

    public Saying(int no, String author, String text) {
        this.no = no;
        this.author = author;
        this.text = text;
    }

    public int getNo() {
        return no;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

}