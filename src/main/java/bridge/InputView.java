package bridge;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리 길이를 입력해 주세요.");
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해 주세요. (위: U, 아래: D)");
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }
}
