package jadex.gradle;

import java.io.Serializable;

public interface JadexModel extends Serializable {
    String getSourceDir();
    String getOutputDir();
}