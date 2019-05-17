package Ejemplo1;

import stringsort.Sort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] actualNames = new String [] {
        		"jhon","wil","wilk","abraham","dago"
        };
        final Sort sorter = new Sort();
        sorter.sort(actualNames);
        for(final String name:actualNames) {
        	System.out.println(name);
        }
    }
}

