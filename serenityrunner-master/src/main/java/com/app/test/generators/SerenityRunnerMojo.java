package com.app.test.generators;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Yuvarej on 16/09/2016.
 */
@Mojo(name = "generateSerenityRunner",  defaultPhase = LifecyclePhase.VALIDATE)
public class SerenityRunnerMojo extends AbstractMojo{

    @Parameter(property = "project", readonly = true, required = true)
    private MavenProject project;

    @Parameter(required = false, defaultValue = "src/test/resources/features")
    public String features;

    @Parameter(required = false, defaultValue = "{\"pretty\",\"json:target/cucumber.json\"}")
    public String format;

    @Parameter(required = true, defaultValue = "@tag1,@tag2,@tag3")
    public String tags;

    @Parameter(required = true, defaultValue = "Creation")
    public String phase;

    @Parameter(required = false, defaultValue = "{com.app.test}")
    public String glue;

    @Parameter(required = false, defaultValue = "${project.build.directory}/test-classes/")
    public File outDir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException{
        getFeatures().forEach(feature -> {
            SuiteClass suiteClass = new SuiteClass(format, tags, feature);
            long systemNanoTime = System.nanoTime();
            String generatedFile = suiteClass.generateFile(phase, String.valueOf(systemNanoTime));
            System.out.println(generatedFile);
            try {
                FileUtils.forceMkdir(outDir);
                FileUtils.fileWrite(String.format("%s/%s%sIT.java", outDir.getAbsolutePath(), phase,
                        String.valueOf(systemNanoTime)), generatedFile);
                project.addTestCompileSourceRoot(outDir.getAbsolutePath());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }


    /**
     * get Feature File names in the project directory
     * @return
     */
    private List<String> getFeatures() {
        File baseDir = project.getBasedir();
        String featureFileAbsPath = baseDir.getAbsolutePath() +"/"+ features;
        System.out.println("Feature File Directory Path" + featureFileAbsPath);
        File folder = new File(featureFileAbsPath);
        File[] featureFiles = folder.listFiles();
        return Arrays.stream(featureFiles).filter(x->x.getName().contains(".feature"))
                .map(x->x.getAbsolutePath())
                .collect(Collectors.toList());
    }

}
