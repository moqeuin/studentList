package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {
	File fp;
	
	public FileProc(String name) {
		fp = new File("D:\\tmp\\"+name+".txt");
	}
	
	public void create() {
		try {
			if(fp.createNewFile()) {
				System.out.println("파일이 성공적으로 생성되었습니다.");
			}
			else {
				System.out.println("파일을 생성하는데 실패했습니다.");
			}
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	public void sav_file(String[] saveData) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fp)));
			for (int i = 0; i < saveData.length; i++) {
				pw.println(saveData[i]);
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] load_file() {
		String loadData[]=null;
		int count = 0;
		int n = 0;
		String str = "";
		BufferedReader br;
		try {
			
			br = new BufferedReader(new FileReader(fp));
			
			while((str=br.readLine())!=null) {
					count++;
			}
			br.close();
			
			loadData = new String[count];
			br = new BufferedReader(new FileReader(fp));
			
			while((str=br.readLine())!=null) {
				loadData[n] = str;
				n++;
			}
			br.close();
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		} 
		
		return loadData;
	}
	
}
