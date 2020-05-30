package org.usteniuk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestProjectFileUtils {
    public static final String SCREENS_FOLDER = "screens";

    public static File createFolderForScreens() throws IOException {
        File directoryToDownload = new File(SCREENS_FOLDER);
        if (directoryToDownload.exists()) {
            FileUtils.forceDelete(directoryToDownload);
        }
        FileUtils.forceMkdir(directoryToDownload);
        return directoryToDownload;
    }

    public static File getScreensFolder() {
        return new File(SCREENS_FOLDER);
    }
}
