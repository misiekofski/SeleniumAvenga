package driver;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },
    SELENIUM_GRID{
        @Override
        public DriverManager getDriverManager() {
            return new RemoteDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
