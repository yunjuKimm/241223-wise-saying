import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // 클래스에서 함수들이 공유해야 하는 변수 -> 인스턴스 변수
    private int lastId = 0; // 명언 번호
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>(); // 명언들을 저장할 리스트

    Scanner scanner = new Scanner(System.in);

    public void run() {

        // 테스트 명언 데이터1
        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니");
        add("현재를 사랑하라", "작자 미상");

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {
                writeWiseSaying();

            } else if (command.equals("목록")) {
                printWiseSayingList();

            } else if (command.startsWith("삭제?id=")) {
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);

                boolean result = deleteWiseSaying(id);

                if (result) {
                    System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
                } else {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
                }
            }
        }
    }

    // 함수 이름 지을 땐 동사
    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author); // 명언 저장 객체 생성
        wiseSayingList.add(wiseSaying);
    }

    private boolean deleteWiseSaying(int targetId) {
//        wiseSayingList.remove(1); // 1번째 명언 삭제 -> 명언의 번호와 배열의 index가 아무 상관이 없다.

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                wiseSayingList.remove(wiseSaying);
                return true;
            }
        }
        return false;
    }

    private void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine(); // 명언 입력 -> 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감.

        System.out.print("작가 : ");
        String author = scanner.nextLine(); // 작가 입력

        add(content, author);  // 1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)
        System.out.println("%d번 명언이 등록되었습니다. %s".formatted(lastId));
    }

    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }

    }
}
