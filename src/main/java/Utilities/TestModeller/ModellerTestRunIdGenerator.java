package Utilities.TestModeller;

import java.util.UUID;

public class ModellerTestRunIdGenerator {
    private static String RunId = null;

    public static String GetRunId()
    {
        if (RunId == null) {
            RunId = UUID.randomUUID().toString();
        }

        return RunId;
    }

}
