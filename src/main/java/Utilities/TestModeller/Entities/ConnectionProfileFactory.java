package Utilities.TestModeller.Entities;

import Utilities.PropertiesLoader;

public class ConnectionProfileFactory {
    private static ConnectionProfile profile;

    public ConnectionProfileFactory()
    {

    }

    public static ConnectionProfile getProfile() {
        if (profile == null)
            profile = new ConnectionProfile(PropertiesLoader.getProperties().getProperty("testModeller.apiHost"), PropertiesLoader.getProperties().getProperty("testModeller.apiKey"));

        return profile;
    }
}
