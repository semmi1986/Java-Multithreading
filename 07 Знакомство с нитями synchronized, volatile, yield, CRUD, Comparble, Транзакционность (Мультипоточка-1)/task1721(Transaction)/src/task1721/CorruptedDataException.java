package task1721;

import java.io.IOException;

public class CorruptedDataException extends IOException {
    public CorruptedDataException(String message) {
        super(message);
    }
}
