import java.util.*;

public class Test4 {
    private Deque<String> commandHistory; // 실행된 명령과 결과를 저장하는 리스트
    private Stack<String> undoStack; // undo 스택
    private Stack<String> redoStack; // redo 스택
    private int size; // 저장 가능한 명령의 최대 개수

    // 생성자
    public Test4(int size) {
        this.commandHistory = new ArrayDeque<>();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.size = size;
    }

    // 명령을 실행하는 메서드
    public void execute(String command) {
        String actionInfo = command.replace("action ", "");

        // 저장할 수 있는 명령 수가 초과되었을 경우, 가장 오래된 명령 삭제
        if (undoStack.size() == size) {
            undoStack.remove(0); // 가장 오래된 명령 제거
        }

        // 명령을 추가하고, undo 스택에 쌓는다.
        commandHistory.addLast(actionInfo);
        undoStack.push(actionInfo);
        redoStack.clear(); // 새로운 명령이 실행되면 redo 스택 초기화
    }

    // undo 명령을 처리하는 메서드
    public void undo(int count) {
        while (!undoStack.isEmpty() && count > 0) {
            String command = undoStack.pop();
            redoStack.push(command); // undo된 명령을 redo 스택에 추가
            commandHistory.removeLast(); // undo된 명령을 기록에서 제거
            count--;
        }
    }

    // redo 명령을 처리하는 메서드
    public void redo(int count) {
        while (!redoStack.isEmpty() && count > 0) {
            String command = redoStack.pop();
            commandHistory.addLast(command); // redo된 명령을 기록에 다시 추가
            undoStack.push(command); // redo된 명령을 undo 스택에도 추가
            count--;
        }
    }

    // 현재 실행된 명령 리스트를 출력하는 메서드
    public List<String> getResult() {
        return new ArrayList<>(commandHistory); // Deque를 리스트로 변환하여 반환
    }

    public static void main(String[] args) {
        // 테스트용 코드
        Test4 editor = new Test4(10); // 최대 10개의 명령 저장 가능

        // 명령어 리스트
        List<String> commands = Arrays.asList(
                "action addPage -1",
                "action movePage 1",
                "undo 2",
                "redo 1",
                "action addPage -2"
        );

        // 명령어 실행
        for (String command : commands) {
            String type = command.split(" ")[0];

            if (type.equals("action")) {
                editor.execute(command);
            } else {
                int count = 1;
                if (command.contains(" ")) {
                    count = Integer.parseInt(command.split(" ")[1]);
                }

                if (type.equals("undo")) {
                    editor.undo(count);
                } else if (type.equals("redo")) {
                    editor.redo(count);
                }
            }
        }

        System.out.println(editor.getResult()); // 실행된 명령 리스트 출력
    }
}