package bridge.domain;


import java.util.ArrayList;
import java.util.List;

import static bridge.constants.CommandConstants.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int random = bridgeNumberGenerator.generate();
            bridge = checkRandom(bridge, random);
        }
        return bridge;
    }

    private List<String> checkRandom(List<String> bridge, int random) {
        if (random == 0) {
            bridge.add(MOVE_D.getCommand());
        }
        if (random == 1) {
            bridge.add(MOVE_U.getCommand());
        }
        return bridge;
    }
}
