import view.Engine;

public class Main {
    private static Engine engine;
    public static void main(String[] args) {
        engine = new Engine();
        engine.Engine();
    }

    public static Engine getEngine() {
        return engine;
    }
}