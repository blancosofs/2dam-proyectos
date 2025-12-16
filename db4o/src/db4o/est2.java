package db4o;

public class est2 {
	private String name;
	 private int notas;

	 public est2(String name,int notas) {
	 this.name=name;
	 this.notas=notas;
	 }

	 public int getPoints() {
	 return notas;
	 }

	 public void addPoints(int notas) {
	 this.notas+=notas;
	 }

	 public String getName() {
	 return name;
	 }

	 public String toString() {
	 return name+":"+notas;
	 }

}
