package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder stringBuilderUp;
    private StringBuilder stringBuilderDown;

    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        this.stringBuilderInit();
        for (int i = 0; i < bridgeGame.getCurrentDownBridge().size(); i++) {
            appendUpDown(bridgeGame, i);
            if (i == bridgeGame.getCurrentUpBridge().size() - 1) {
                appendBracket();
                break;
            }
            appendDivision();
        }
        printUpDown();
    }

    private void printUpDown() {
        System.out.println(stringBuilderUp);
        System.out.println(stringBuilderDown);
        System.out.println();
    }

    private void appendDivision() {
        stringBuilderUp.append(" | ");
        stringBuilderDown.append(" | ");
    }

    private void appendBracket() {
        stringBuilderUp.append(" ]");
        stringBuilderDown.append(" ]");
    }

    private void appendUpDown(BridgeGame bridgeGame, int i) {
        stringBuilderUp.append(bridgeGame.getCurrentUpBridge().get(i));
        stringBuilderDown.append(bridgeGame.getCurrentDownBridge().get(i));
    }

    private void stringBuilderInit() {
        this.stringBuilderUp = new StringBuilder();
        this.stringBuilderDown = new StringBuilder();
        this.stringBuilderUp.append("[ ");
        this.stringBuilderDown.append("[ ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param isSuccess
     * @param bridgeGame
     */
    public void printResult(boolean isSuccess, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        if (isSuccess == true) {
            System.out.println("게임 성공 여부: "+ CheckSuccess.SUCCESS_GAME.getMessage());
        }
        if (isSuccess == false) {
            System.out.println("게임 성공 여부: " + CheckSuccess.FAIL_GAME.getMessage());
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    enum CheckSuccess {
        SUCCESS_GAME("성공"),
        FAIL_GAME("실패");

        private boolean isSuccess;
        private String message;

        CheckSuccess(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
