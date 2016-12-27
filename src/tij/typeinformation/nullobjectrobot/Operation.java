package tij.typeinformation.nullobjectrobot;

/**
 * Created by Xiaolong on 12/27/2016.
 *
 *
 * Design Pattern: Command Patttern
 *
 * Operation contains a description and a command
 *
 */
public interface Operation {
    String description();
    void command();
}
