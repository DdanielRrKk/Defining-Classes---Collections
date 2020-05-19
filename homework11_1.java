package dom11;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class zad1 {

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		df2.setRoundingMode(RoundingMode.DOWN);
		Scanner sc=new Scanner(System.in);
		Map<String,Person>pers=new HashMap<String,Person>();
		String line="";
		
		line=sc.nextLine();
		while(!"End".equals(line)) {
			String splitline[]=line.split(" ");
			if(!pers.containsKey(splitline[0])) {
				pers.put(splitline[0], new Person());
			}
			switch(splitline[1]) {
			case "company":
				String s1=splitline[2];
				String s2=splitline[3];
				double sal=Double.parseDouble(splitline[4]);
				Company com=new Company(s1,s2,sal);
				pers.get(splitline[0]).setCompany(com);
				break;
				
			case "pokemon":
				String pn=splitline[2];
				String pt=splitline[3];
				Pokemon pok=new Pokemon(pn,pt);
				pers.get(splitline[0]).addPokemon(pok);
				break;
				
			case "parents":
				String pr=splitline[2];
				String pb=splitline[3];
				Parents par=new Parents(pr,pb);
				pers.get(splitline[0]).addParents(par);
				break;
				
			case "children":
				String cn=splitline[2];
				String cb=splitline[3];
				Children chil=new Children(cn,cb);
				pers.get(splitline[0]).addChildren(chil);
				break;
				
			case "car":
				String ca=splitline[2];
				int sp=Integer.parseInt(splitline[3]);
				Car c=new Car(ca,sp);
				pers.get(splitline[0]).setCar(c);
				break;
				
			default: break;
			}
			line=sc.nextLine();
		}
		
		line=sc.nextLine();
		if(pers.containsKey(line)) {System.out.println(pers.get(line));}
		
		sc.close();
		System.out.println("good bye");
	}
	

}

class Person{
	String name;
	Company comp=new Company();
	List<Pokemon> pokemons=new ArrayList<Pokemon>();
	List<Parents> parents=new ArrayList<Parents>();
	List<Children> childs=new ArrayList<Children>();
	Car car=new Car();
	
	Person(){name="";}
	
	public void setPersonName(String s) {name=s;}
	public void setCompany(Company c) {comp=c;}
	public void addPokemon(Pokemon p) {pokemons.add(p);}
	public void addParents(Parents p) {parents.add(p);}
	public void addChildren(Children c) {childs.add(c);}
	public void setCar(Car c) {car=c;}
	
	public String getName() {return name;}
	public int getSizePok() {return pokemons.size();}
	public int getSizePar() {return parents.size();}
	public int getSizeChi() {return childs.size();}
	
	public String toString() {return ("\n"+name+"\n Company: "+comp+"\n Pokemon: "+pokemons+"\n Parents: "+parents+"\n Children: "+childs+"\n Car: "+car);}
}

class Company{
	String coName;
	String department;
	double salary;
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	Company(){coName="";department="";salary=0.0;}
	Company(String s1,String s2,double d){coName=s1;department=s2;salary=d;}
	
	public void setCompanyName(String s) {coName=s;}
	public void setDepartment(String s) {department=s;}
	public void setSalary(double d) {salary=d;}
	
	public String toString() {
		if(salary==0) {return "";}
		return (""+coName+" "+department+" "+df2.format(salary));
	}
}

class Pokemon{
	String pokName;
	String type;
	
	Pokemon(){pokName="";type="";}
	Pokemon(String s1,String s2){pokName=s1;type=s2;}
	
	public void setPokemonName(String s) {pokName=s;}
	public void setType(String s) {type=s;}
	
	public String toString() {return (""+pokName+" "+type);}
}

class Parents{
	String parName;
	String parBday;
	
	Parents(){parName="";parBday="";}
	Parents(String s1,String s2){parName=s1;parBday=s2;}
	
	public void setParentName(String s) {parName=s;}
	public void setParentBday(String s) {parBday=s;}
	
	public String toString() {return (""+parName+" "+parBday);}
}

class Children{
	String chName;
	String chBday;
	
	Children(){chName="";chBday="";}
	Children(String s1,String s2){chName=s1;chBday=s2;}
	
	public void setChildrenName(String s) {chName=s;}
	public void setChildrenBday(String s) {chBday=s;}
	
	public String toString() {return (""+chName+" "+chBday);}
}

class Car{
	String model;
	int speed;
	
	Car(){model="";speed=0;}
	Car(String s,int i){model=s;speed=i;}
	
	public void setModel(String s) {model=s;}
	public void setSpeed(int i) {speed=i;}
	
	public String toString() {
		if(speed==0) {return "";}
		return (""+model+" "+speed);
	}
}
