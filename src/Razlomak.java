
public class Razlomak {
private int brojilac;
private int imenilac;
// Konstruktori
public Razlomak() {
super();
this.brojilac = 0;
this.imenilac = 1;
}
public Razlomak(int brojilac) {
super();
this.brojilac = brojilac;
this.imenilac = 1;
}
public Razlomak(int brojilac, int imenilac) {
super();
this.brojilac = brojilac;
this.imenilac = imenilac;
}
// Inspektori i mutatori
public int getBrojilac() {
return brojilac;
}
public void setBrojilac(int brojilac) {
this.brojilac = brojilac;
}
public int getImenilac() {
return imenilac;
}
public void setImenilac(int imenilac) {
this.imenilac = imenilac;
}
// Staticke metode za sab, oduzimanje, dijeljenje i mnozenje
public static Razlomak saberi(Razlomak a, Razlomak b){
Razlomak rez = new Razlomak();
rez.setBrojilac(a.getBrojilac()*b.getImenilac()+a.getImenilac()*b.getBrojilac());
rez.setImenilac(a.getImenilac()*b.getImenilac());
return rez;
}
public static Razlomak oduzmi(Razlomak a, Razlomak b){
Razlomak rez = new Razlomak();
rez.setBrojilac(a.getBrojilac()*b.getImenilac()-a.getImenilac()*b.getBrojilac());
rez.setImenilac(a.getImenilac()*b.getImenilac());
return rez;
}
public static Razlomak pomnozi(Razlomak a, Razlomak b){
Razlomak rez = new Razlomak();
rez.setBrojilac(a.getBrojilac()*b.getBrojilac());
rez.setImenilac(a.getImenilac()*b.getImenilac());
return rez;
}
public static Razlomak podijeli(Razlomak a, Razlomak b){
Razlomak rez = new Razlomak();
rez.setBrojilac(a.getBrojilac()*b.getImenilac());
rez.setImenilac(a.getImenilac()*b.getBrojilac());
return rez;
}
// Realizacija toString metode
@Override
public String toString() {
return brojilac + "/" + imenilac;
}
// Realizacija metode za skracivanje razlomka
public void skrati(){
for(int i=2;
i<Math.min(Math.abs(this.getImenilac()),Math.abs(this.getImenilac()));i++){
while(imenilac%i==0 && brojilac%i==0){
brojilac/=i;
imenilac/=i;
}
}
}
}

