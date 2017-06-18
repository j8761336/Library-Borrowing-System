package Preferences;

import java.util.ArrayList;

public class catchData {
	ArrayList<TableDataList>tdlist=new ArrayList<TableDataList>();
	String tmpData[];
	public catchData(String tmpData[]){
		this.tmpData=tmpData;
		addList(tmpData);
//		tdlist.add(new TableDataList(tmpData[0],tmpData[1],tmpData[2],tmpData[3],tmpData[4],tmpData[5]));
	}
	public String[] getData(){
		return this.tmpData;
	}
	public void addList(String tmpData[]){
//		tdlist.add(new TableDataList(tmpData[0],tmpData[1],tmpData[2],tmpData[3],tmpData[4],tmpData[5]));
		
	}
	public int getSize(){
		return tdlist.size();
	}
	public String[][] getListData(){
//		String tmp [] = new String[1];
//		switch(colnm){
//			case 0:
//				tmp[0] = tdlist.get(count).retNum();
//			case 1:
//				tmp[0] = tdlist.get(count).retVariety();
//			case 2:
//				tmp[0] = tdlist.get(count).retBookName();
//			case 3:
//				tmp[0] = tdlist.get(count).Author();
//			case 4:
//				tmp[0] = tdlist.get(count).returnDate();
//			case 5:
//				tmp[0] = tdlist.get(count).Status();
//		}
//		return tmp[0];
		String tmp [][]= new String[tdlist.size()][6];
		for(int i=0;i<tdlist.size();i++){
			tdlist.get(i).showInfo();
//			tmp[i][0] = tdlist.get(i).retNum();
//			tmp[i][1] = tdlist.get(i).retVariety();
//			tmp[i][2] = tdlist.get(i).retBookName();
//			tmp[i][3] = tdlist.get(i).Author();
//			tmp[i][4] = tdlist.get(i).returnDate();
//			tmp[i][5] = tdlist.get(i).Status();
			System.out.println("1");
			tmp[i][0] = "1";
			tmp[i][1] = "1";
			tmp[i][2] = "1";
			tmp[i][3] = "1";
			tmp[i][4] = "1";
			tmp[i][5] = "1";
		}
		return tmp;
	}
	
	public String getListNum(int count){
		return tdlist.get(count).retNum();
	}
	public String getListVariety(int count){
		return tdlist.get(count).retVariety();
	}
	public String getListBookName(int count){
		return tdlist.get(count).retBookName();
	}
	public String getListAuthor(int count){
		return tdlist.get(count).Author();
	}
	public String getListreturnDate(int count){
		return tdlist.get(count).returnDate();
	}
	public String getListStatus(int count){
		return tdlist.get(count).Status();
	}
//	public int getTest(){
//		return tdlist.get(0).retTest();
//	}
}
//---------------

class TableDataList{
	private String num;
	private String variety;
	private String bookName;
	private String author;
	private String returnDate;
	private String status;
	private String rentDate;
	private int test1;
	public TableDataList(String num,String variety,String bookName,String author,String rentDate,
			String returnDate,String status){
		this.num=num;this.variety=variety;this.bookName=bookName;
		this.author=author;this.rentDate=rentDate;this.returnDate=returnDate;this.status=status;this.test1=1;
	}
	
//	public int retTest(){
//		test1=1;
//		return this.test1;
//	}
	public String retNum(){
		
		return this.num;
	}
	public String retVariety(){
		
		return this.variety;
	}
	public String retBookName(){
		
		return this.bookName;
	}
	public String Author(){
		
		return this.author;
	}
	public String rentDate(){
		return this.rentDate;
	}
	public String returnDate(){
		
		return this.returnDate;
	}
	public String Status(){
		
		return this.status;
	}
	public void showInfo(){
		System.out.println(this.num);
		System.out.println(this.variety);
		System.out.println(this.bookName);
		System.out.println(this.author);
		System.out.println(this.rentDate);
		System.out.println(this.returnDate);
		System.out.println(this.status);
	}
}

class VarietyList{
	private String variety;
	public VarietyList(String variety){
		this.variety=variety;
	}
	public String retVariety(){
		return this.variety;
	}
}