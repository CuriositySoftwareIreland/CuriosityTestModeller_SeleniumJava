package Utilities.TestModeller.DataResolution;

import java.io.IOException;

public class RemoteDataResolver {
    public RemoteDataResolver()
    {

    }

    public static void ResolveData()
    {
        Process p = null;
        try {
            ProcessBuilder pb = new ProcessBuilder("resolveData.bat");
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);

            p = pb.start();

            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
