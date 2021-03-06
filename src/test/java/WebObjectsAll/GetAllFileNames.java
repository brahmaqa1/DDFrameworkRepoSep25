package WebObjectsAll;

import java.io.File;

public class GetAllFileNames {

	/**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fList = directory.listFiles();

        for (File file : fList){
            System.out.println(file.getName());
        }
    }

    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fList = directory.listFiles();

        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fList = directory.listFiles();

        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fList = directory.listFiles();

        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

    public static void main (String[] args){

    	GetAllFileNames listFilesUtil = new GetAllFileNames();

//        final String directoryLinuxMac ="/Users/loiane/test";

        //Windows directory example
        final String directoryWindows ="D:\\test videosel\\C language Module 1";

        listFilesUtil.listFiles(directoryWindows);
    }
	/*
	 * public static void main(String[] args) {
	 * 
	 * String FolderName=
	 * "D:\\test videosel\\C language Module 1\\5.Control statements"; File f= new
	 * File(FolderName); String[] filesArr= f.list(); String prevFileName;
	 * for(String fname: filesArr) { System.out.println(fname);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

}
