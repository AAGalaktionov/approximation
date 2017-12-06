package amm1706;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

import java.io.File;

public class KernelConnection {
    private static KernelLink kernelLink;

    public void init(String link, String jLinkDir) throws MathLinkException {

        System.setProperty("com.wolfram.jlink.libdir", jLinkDir);

        String[] mlArgs = {"-linkmode", "launch", "-linkname", link};
        kernelLink = MathLinkFactory.createKernelLink(mlArgs);
        kernelLink.discardAnswer();
    }

    public static KernelLink getKernelLink() {
        return kernelLink;
    }

    public static void closeConnection() {
        if (kernelLink != null)
            kernelLink.close();
    }
}
