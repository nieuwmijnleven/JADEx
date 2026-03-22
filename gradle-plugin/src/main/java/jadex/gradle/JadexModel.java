package jadex.gradle;

import java.io.Serializable;
import java.util.List;

public interface JadexModel extends Serializable {
    String getProjectDir();
    String getPluginVersion();
    String getSourceDir();
    String getOutputDir();
    String getJavaHome();
    String getJavaVersion();

    List<String> getJavaSrcDirs();
    List<String> getClassPath();
}