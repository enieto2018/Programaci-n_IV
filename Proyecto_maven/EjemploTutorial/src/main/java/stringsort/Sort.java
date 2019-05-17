package stringsort;

public class Sort {
	public void sort(String [] names) {
		int n = names.length;
		while (n>1) {
			for (int j=0; j<n-1; j++) {
				if(names[j].compareTo(names[j+1])>0) {
					final String temp=names[j+1];
					names[j+1]=names[j];
					names[j]=temp;
				}
			}
			n--;
		}
	}

}
