public class Delegation {
	public static void main(String args[]) {
		C111 c111 = new C111();
		System.out.println(c111.m111());

		C112 c112 = new C112();
		System.out.println(c112.m112());
		
		D111 d111 = new D111();
		System.out.println(d111.m111());

		D112 d112 = new D112();
		System.out.println(d112.m112());
	}
}

 class C1 {
	protected int a1 = 1;

	public int m1() {
		return a1 + p1(100) + q1(100);
	}

	public int p1(int m) {
		return m;
	}
	
	public int q1(int m) {
		return m;
	}
}

 class C11 extends C1 {
	protected int a11 = 11;

	public int m11() {
		return m1() + q1(200);
	}

	public int p1(int m) {
		return m * a1;
	}

	public int q1(int m) {
		return m + a11;
	}
}

class C111 extends C11 {
	protected int a111 = 111;

	public int m111() {
		return m1() + m11() + a111;
	}
	
	public int p1(int m) {
		return m * a1 * a11;
	}
}

class C112 extends C11 {
	protected int a112 = 112;

	public int m112() {
		return m1() + m11() + a112;
	}

	public int p1(int m) {
		return m * a1 * a11 * a112;
		
	}
}


// -------SIMULATING CLASS INHERITANCE BY DELEGATION ---------

interface I1 {
	public int m1();

	public int p1(int m);
	
	public int q1(int m);

	public int getA1();
	 
}

interface I11 extends I1 {
	public int m11(); 

	public int p1(int m); 

	public int q1(int m);

	public int getA11();
}

interface I111 extends I11 {
	public int m111();
	
	public int p1(int m);
}

interface I112 extends I11 {
	 public int m112();
	 public int p1(int m);
}

class D1 implements I1 {

	protected int a1=1;
	I1 this2;
	 I11 i11;
	public D1(I11 i11) {
		// TODO Auto-generated constructor stub
		this2=this;
		this.i11=i11;
	}

	public int m1() {
		return a1 + i11.p1(100) + i11.q1(100);
	}

	public int p1(int m) {
		return m;
		//return this2.p1(m);
	}
	
	public int q1(int m) {
		return this2.q1(m);
	}
	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return a1;
	}
	 
}

class D11 implements I11 {
	I1 this2;
	I111 i111;
	I112 i112;
protected int a11=11;
	public D11(I111 i111) {
		 this2=new D1(this);
		 this.i111=i111;
	 }
		public D11(I112 i112) {
			this2=new D1(this);
			 this.i112=i112;
	}
		// TODO Auto-generated constructor stub

	@Override
	public int m1() {
		// TODO Auto-generated method stub
		return this2.m1();
	}

	@Override
	public int m11() {
		// TODO Auto-generated method stub
		return  this2.m1() + q1(200);
	}

	public int p1(int m) {
		if(i111==null&&i112==null)
			return m*this2.getA1();
		if(i111==null)
			return i112.p1(m); 
		return i111.p1(m);
	}

	public int q1(int m) {
		return m+a11;
	}

	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return this2.getA1();
	}

	@Override
	public int getA11() {
		// TODO Auto-generated method stub
		return a11;
	}
	}



 
class D111 implements I111 { 
	 protected int a111=111;
	 I11 this2;
	public D111()
	{
		this2=new D11(this);
	}
	@Override
	public int m11() {
		// TODO Auto-generated method stub
		return this2.m11();
	}
	@Override
	public int q1(int m) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int m1() {
		// TODO Auto-generated method stub
		return this2.m1();
	}
	@Override
	public int m111() {
		return this2.m1() + this2.m11() + a111;
	}
	@Override
	public int p1(int m) {
		return m * this2.getA1() * this2.getA11();
	}
	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return this2.getA1();
	}
	@Override
	public int getA11() {
		// TODO Auto-generated method stub
		return this2.getA11();
	}
	
	

}

class D112 implements I112 {
protected int a112=112;
I11 this2;
D112()
{
	this2=new D11(this);
	}
	@Override
	public int m11() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int m112() {
		return this2.m1() + this2.m11() + a112;
	}

	public int p1(int m) {
		return m * this2.getA1() * this2.getA11() * a112;
		
	}

	@Override
	public int q1(int m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getA11() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int m1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return 0;
	}
	 
}
