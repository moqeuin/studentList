package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		MemberDao md = new MemberDao();
		int choice;

		while(true) {
			System.out.println("-----------------메뉴");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 삭제");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 모두 출력");
			System.out.println("6. 과목의 총점");
			System.out.println("7. 과목의 평균");
			System.out.println("8. 성적  차순정렬");			
			System.out.println("9. 데이터를 파일에 저장");
			System.out.println("10.데이터를 파일에서 불러오기");
			System.out.println("11.프로그램 종료");
			System.out.println("메뉴 번호를 입력해 주십시오");
			System.out.print(">>> ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:		
					md.insert();
					break;
				case 2:
					md.delete();					
					break;
				case 3:
					md.select();					
					break;
				case 4:
					md.update();
					break;
				case 5:
					md.allPrint();
					break;
				case 6:
					md.chapSum();
					break;
				case 7:
					md.chapAvg();
					break;
				case 8:
					md.sorting();
					break;
				case 9:
					md.sav_data();
					break;
				case 10:
					md.load_data();
				case 11:
					System.out.println("프로그램을 종료합니다");
					System.exit(0);					
					break;
			}			
		}
	}
		 
	
	
	
	

}





