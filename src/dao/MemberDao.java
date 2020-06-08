package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberStu;
import file.FileProc;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	private ArrayList <MemberStu> list = new ArrayList<MemberStu>();
	private FileProc fp;
	
	
	public MemberDao() {
		fp = new FileProc("student");
		fp.create();
		load_data();
	}
	
	public int search(String name) {
		
		int index = -1;	
		for (int i = 0; i < list.size(); i++) {
			MemberStu stu = list.get(i);
			if(stu.getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void insert() {
		System.out.println("학생의 정보를 입력하세요.");
							
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		System.out.print("영어:");
		int eng = sc.nextInt();
		
		System.out.print("수학:");
		int math = sc.nextInt();
		
		list.add(new MemberStu(name, age, eng, math));
			
	}
	
	public void delete() {
			
		System.out.print("삭제할 학생의 이름 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("찾으시는 이름의 학생의 데이터가 존재하지 않습니다.");
			return;
		}
		
		list.remove(findIndex);	
	}
	
	public void select() {
			
		System.out.print("검색할 학생의 이름 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("찾으시는 이름의 학생의 데이터가 존재하지 않습니다.");
			return;
		}
		MemberStu st = list.get(findIndex);
		
		System.out.println("데이터를 찾았습니다");
		System.out.println("이름:" + st.getName());
		System.out.println("나이:" + st.getAge());
		System.out.println("영어:" + st.getEng());
		System.out.println("수학:" + st.getMath());
	}
	
	public void update() {	
		
		System.out.print("수정할 학생의 이름 = ");
		String name = sc.next();	
		int findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("찾으시는 이름의 학생의 데이터가 존재하지 않습니다.");
			return;
		}
		
		MemberStu st = list.get(findIndex);
		System.out.println("수정 데이터를 입력해 주십시오.");
		
		System.out.print("영어:");
		int eng = sc.nextInt();
			
		System.out.print("수학:");
		int math = sc.nextInt();
			
		st.setEng(eng);
		st.setMath(math);
			
		System.out.println("데이터가 수정되었습니다");			
	}
	
	public void allPrint() {
		
		for (int i = 0; i < list.size(); i++) {
			MemberStu st = list.get(i);
			System.out.println(st.toString());
		}
	}
	
	public int chapSum() {
		
		// 영어, 수학 선택
		
		System.out.print("합계를 구할 과목을 선택,  영어(1), 수학(2) = ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		if(num==1) {
			for (int i = 0; i < list.size(); i++) {
				MemberStu st = list.get(i);
				sum = sum + st.getEng();
			}		
		}
		if(num==2) {
			for (int i = 0; i < list.size(); i++) {
				MemberStu st = list.get(i);
				sum = sum + st.getMath();
			}		
		}	
		if(num==1)	
			System.out.println("영어의 합계는 "+sum + "점입니다");	
		else if(num==2)
			System.out.println("수학의 합계는 "+sum + "점입니다");
		return sum;
	}
	
	public void chapAvg() {
		
		int sum = chapSum();
		
		System.out.print("평균를 구할 과목을 선택,  영어(1), 수학(2) = ");
		int num = sc.nextInt();
		
		double avg = (double)sum/list.size();
		
		if(num == 1)	System.out.print("영어의 평균은 ");
		else			System.out.print("수학의 평균은 ");		
		System.out.println(avg + "점입니다");		
	}
	
	public void sorting() {
			
		ArrayList<MemberStu> relist = new ArrayList<MemberStu>();
		for (int i = 0; i < list.size(); i++) {
			MemberStu st = list.get(i);
			relist.add(st);
		}
		System.out.println("정렬을 할 과목을 선택해주세요. 영어(1)/수학(2)");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println("오름차순(1)/내림차순(2)");
			int num2 = sc.nextInt();
			if(num2 == 1) {	
				for (int i = 0; i < relist.size()-1; i++) {
					for (int j = i+1; j < relist.size(); j++) {
						MemberStu st1 = relist.get(i);
						MemberStu st2 = relist.get(j);
						if(st1.getEng() > st2.getEng()) {
							MemberStu tmp = relist.get(i);
							relist.set(i, relist.get(j));
							relist.set(j, tmp);
						}
					}
				}
			}
			else if(num == 2) {
				for (int i = 0; i < relist.size()-1; i++) {
					for (int j = i+1; j < relist.size(); j++) {
						MemberStu st1 = relist.get(i);
						MemberStu st2 = relist.get(j);
						if(st1.getEng() > st2.getEng()) {
							MemberStu tmp = relist.get(i);
							relist.set(i, relist.get(j));
							relist.set(j, tmp);
						}
					}
				}
			}
		}
		else if(num == 2) {
			System.out.println("오름차순(1)/내림차순(2)");
			int num3 = sc.nextInt();
			if(num3 == 1) {	
				for (int i = 0; i < relist.size()-1; i++) {
					for (int j = i+1; j > relist.size(); j++) {
						MemberStu st1 = relist.get(i);
						MemberStu st2 = relist.get(j);
						if(st1.getMath() < st2.getMath()) {
							MemberStu tmp = relist.get(i);
							relist.set(i, relist.get(j));
							relist.set(j, tmp);
						}
					}
				}
			}
			else if(num3 == 2) {
				for (int i = 0; i < relist.size()-1; i++) {
					for (int j = i+1; j < relist.size(); j++) {
						MemberStu st1 = relist.get(i);
						MemberStu st2 = relist.get(j);
						if(st1.getMath() > st2.getMath()) {
							MemberStu tmp = relist.get(i);
							relist.set(i, relist.get(j));
							relist.set(j, tmp);
						}
					}
				}
			}
	
		}
		for (int i = 0; i < relist.size(); i++) {
			System.out.println(relist.get(i).toString());
		}
	}	
	
	public void sav_data() {
				
		String saveData[] = new String[list.size()];
		
		for (int i = 0; i < saveData.length; i++) {
			saveData[i] = list.get(i).toString();						
		}		
		fp.sav_file(saveData);							
	}

	public void load_data() {
		String loadData[] = fp.load_file();
		
		for (int i = 0; i < loadData.length; i++) {
			String data[] = loadData[i].split("-");
			
			MemberStu st = new MemberStu(data[0], Integer.parseInt(data[1]),
					                     Integer.parseInt(data[2]),
					                     Integer.parseInt(data[3]));
			
			list.add(st);
		}	
	}	
}
