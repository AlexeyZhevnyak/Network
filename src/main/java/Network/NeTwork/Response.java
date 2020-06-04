package Network.NeTwork;

import java.io.Serializable;

public class Response implements Serializable {
    private final Serializable payload;

    public Serializable getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "payload=" + payload +
                '}';
    }

    public Response(Serializable payload) {
        this.payload = payload;
    }
}
