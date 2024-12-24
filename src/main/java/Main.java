import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    // 클래스에서 함수들이 공유해야 하는 변수 -> 인스턴스 변수
    int lastId = 0; // 명언 번호
    int wiseSayingSize = 0;
    WiseSaying[] wiseSayingList = new WiseSaying[3]; // 명언들을 저장할 리스트

    public void run() {

        Scanner scanner = new Scanner(System.in);

        // 테스트 명언 데이터1
        WiseSaying wiseSayingTest = new WiseSaying();
        wiseSayingTest.id = ++lastId;
        wiseSayingTest.content = "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.";
        wiseSayingTest.author = "월트 디즈니";
        wiseSayingList[wiseSayingSize++] = wiseSayingTest;


        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine(); // 명언 입력 -> 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감.

                System.out.print("작가 : ");
                String author = scanner.nextLine(); // 작가 입력

                add(content, author);  // 1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)

                System.out.println("%d번 명언이 등록되었습니다. %s".formatted(lastId));

            } else if (command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                //등록된 명언 목록 출력
                for (int i = 0; i < wiseSayingSize; i++) {
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                }

            }


        }
    }

    // 함수 이름 지을 땐 동사
    public void add(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(); // 명언 저장 객체 생성

        wiseSaying.id = ++lastId;
        wiseSaying.content = content;
        wiseSaying.author = author;

        wiseSayingList[wiseSayingSize++] = wiseSaying;
    }

}


// 명언 저장 클래스
class WiseSaying {
    int id;
    String author;
    String content;

//    public WiseSaying(int no, String author, String content) {
//        this.id = no;
//        this.author = author;
//        this.content = content;
//    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

}