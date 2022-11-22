package bridge;

public class ValidateBridge {

    static int validateBridgeSize(String beforeValidateSize) {
        int size = 0;
        try {
            size = Integer.parseInt(beforeValidateSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이가 숫자가 아닙니다");
        }

        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하여야 합니다.");
        }
        return size;
    }

    static String validateMovement(String beforeMovement) {
        if (!beforeMovement.equals("U") && !beforeMovement.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D로 입력해야 합니다.");
        }
        return beforeMovement;
    }

    static String validateRetry(String beforeValidateRetry) {
        if (!beforeValidateRetry.equals("Q") && !beforeValidateRetry.equals("R")) {
            throw new IllegalArgumentException("[ERROR] 재시작/종료 여부는 R이나 Q로 입력해야 합니다.");
        }
        return beforeValidateRetry;
    }
}
