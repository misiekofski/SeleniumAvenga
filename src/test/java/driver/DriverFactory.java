package driver;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
